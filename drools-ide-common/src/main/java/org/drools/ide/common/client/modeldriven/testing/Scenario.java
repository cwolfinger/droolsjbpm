/**
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.ide.common.client.modeldriven.testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.drools.ide.common.client.modeldriven.brl.PortableObject;

/**
 * This represents a test scenario.
 * It also encapsulates the result of a scenario run.
 *
 * @author Michael Neale
 */
public class Scenario
    implements
    PortableObject {

    /**
     * The maximum number of rules to fire so we don't recurse for ever.
     */
    public int            maxRuleFirings = 100000;

    /**
     * global data which must be setup before hand.
     */
    public List<FactData> globals        = new ArrayList<FactData>();

    /**
     * Fixtures are parts of the test. They may be assertions, globals, data, execution runs etc.
     * Anything really.
     *
     */
    public List<Fixture>  fixtures       = new ArrayList<Fixture>();

    /**
     * This is the date the last time the scenario was run (and what the results apply to).
     */
    public Date           lastRunResult;

    /**
     * the rules to include or exclude
     */
    public List<String>   rules          = new ArrayList<String>();

    /**
     * true if only the rules in the list should be allowed to fire. Otherwise
     * it is exclusive (ie all rules can fire BUT the ones in the list).
     */
    public boolean        inclusive      = false;

    /**
     * Returns true if this was a totally successful scenario, based on the results contained.
     */
    public boolean wasSuccessful() {
        for ( Iterator iterator = fixtures.iterator(); iterator.hasNext(); ) {
            Fixture f = (Fixture) iterator.next();
            if ( f instanceof Expectation ) {
                if ( !((Expectation) f).wasSuccessful() ) {
                    return false;
                }
            }

        }
        return true;
    }

    /**
     * Will slip in a fixture after the specified one, but before the next execution trace.
     */
    public void insertBetween(Fixture fix,
                              Fixture toAdd) {

    	boolean inserted = false;
        int start = (fix == null) ? 0 : fixtures.indexOf( fix ) + 1;
      
        for ( int j = start; j < fixtures.size(); j++ ) {
            Fixture f = (Fixture) fixtures.get( j );
            if ( f instanceof ExecutionTrace ) {
                fixtures.add( j,
                              toAdd );
                System.out.println(toAdd.toString());
                return;
            }
        }

        if ( !inserted ) {
            //fixtures.add( fixtures.indexOf(fix) + 1, toAdd);
            fixtures.add( toAdd );
        }
    }

    /**
     * Remove the specified fixture.
     */
    public void removeFixture(Fixture f) {
        this.fixtures.remove( f );
        this.globals.remove( f );
    }

    /**
     * Remove fixtures between this ExecutionTrace and the previous one.
     */
    public void removeExecutionTrace(ExecutionTrace et) {

        boolean remove = false;
        for ( Iterator<Fixture> iterator = fixtures.iterator(); iterator.hasNext(); ) {
            Fixture f = iterator.next();

            if ( f.equals( et ) ) {
                remove = true;
                continue;
            } else if ( remove && (f instanceof ExecutionTrace || (f instanceof FactData)) ) {
                break;
            }

            if ( remove ) {
                iterator.remove();
                this.globals.remove( f );
            }
        }

        Collections.reverse( fixtures );

        remove = false;
        for ( Iterator<Fixture> iterator = fixtures.iterator(); iterator.hasNext(); ) {
            Fixture f = iterator.next();

            // Catch the first or next ExecutionTrace.
            if ( f.equals( et ) ) {
                remove = true;
            } else if ( remove && (f instanceof ExecutionTrace || (f instanceof VerifyFact)) ) {
                break;
            }

            if ( remove ) {
                iterator.remove();
                this.globals.remove( f );
            }
        }

        Collections.reverse( fixtures );
    }

    /**
    *
    * @return A mapping of variable names to their fact type.
    */
    public Map getFactTypes() {
        Map m = new HashMap();
        int p = this.fixtures.size();
        for ( int i = 0; i < p; i++ ) {
            Fixture f = (Fixture) fixtures.get( i );
            if ( f instanceof FactData ) {
                FactData fd = (FactData) f;
                m.put( fd.name,
                       fd );
            }
        }
        return m;
    }

    /**
     *
     * @return A mapping of variable names to their fact type.
     */
    public Map<String, String> getVariableTypes() {
        Map<String, String> map = new HashMap<String, String>();
        for ( Fixture fixture : fixtures ) {
            if ( fixture instanceof FactData ) {
                FactData factData = (FactData) fixture;
                map.put( factData.name,
                         factData.type );
            }
        }
        for ( FactData factData : globals ) {
            map.put( factData.name,
                     factData.type );
        }
        return map;
    }

    /**
     * This will return a list of fact names that are in scope (including globals).
     * @return List<String>
     */
    public List<String> getFactNamesInScope(ExecutionTrace ex,
                                            boolean includeGlobals) {
        if ( ex == null ) return Collections.emptyList();
        List<String> factDataNames = new ArrayList<String>();
        int p = this.fixtures.indexOf( ex );
        for ( int i = 0; i < p; i++ ) {
            Fixture fixture = (Fixture) fixtures.get( i );
            if ( fixture instanceof FactData ) {
                FactData factData = (FactData) fixture;
                factDataNames.add( factData.name );
            } else if ( fixture instanceof RetractFact ) {
                RetractFact retractFact = (RetractFact) fixture;
                factDataNames.remove( retractFact.name );
            }
        }

        if ( includeGlobals ) {
            for ( FactData factData : globals ) {
                factDataNames.add( factData.name );
            }
        }
        return factDataNames;
    }

    /**
     * @return true iff a fact name is already in use.
     */
    public boolean isFactNameExisting(String factName) {
        for ( Iterator iterator = globals.iterator(); iterator.hasNext(); ) {
            FactData fd = (FactData) iterator.next();
            if ( fd.name.equals( factName ) ) {
                return true;
            }
        }
        for ( Iterator iterator = fixtures.iterator(); iterator.hasNext(); ) {
            Fixture f = (Fixture) iterator.next();
            if ( f instanceof FactData ) {
                FactData fd = (FactData) f;
                if ( fd.name.equals( factName ) ) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return true iff a fact is actually used (ie if its not, its safe to remove it).
     */
    public boolean isFactNameUsed(FactData fd) {
        int start = this.fixtures.indexOf( fd );
        for ( int i = start + 1; i < fixtures.size(); i++ ) {
            Fixture f = (Fixture) fixtures.get( i );
            if ( f instanceof RetractFact ) {
                if ( ((RetractFact) f).name.equals( fd.name ) ) {
                    return true;
                }
            } else if ( f instanceof VerifyFact ) {
                if ( ((VerifyFact) f).name.equals( fd.name ) ) {
                    return true;
                }
            } else if ( f instanceof FactData ) {
                if ( ((FactData) f).name.equals( fd.name ) ) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @return int[0] = failures, int[1] = total;
     */
    public int[] countFailuresTotal() {
        int total = 0;
        int failures = 0;
        for ( Iterator iterator = fixtures.iterator(); iterator.hasNext(); ) {
            Fixture f = (Fixture) iterator.next();
            if ( f instanceof VerifyRuleFired ) {
                total++;
                VerifyRuleFired vr = (VerifyRuleFired) f;
                if ( vr.successResult != null && !vr.successResult.booleanValue() ) {
                    failures++;
                }
            } else if ( f instanceof VerifyFact ) {
                VerifyFact vf = (VerifyFact) f;
                for ( Iterator it = vf.fieldValues.iterator(); it.hasNext(); ) {
                    VerifyField vfl = (VerifyField) it.next();
                    if ( vfl.successResult != null && !vfl.successResult.booleanValue() ) {
                        failures++;
                    }
                    total++;
                }
            }
        }
        return new int[]{failures, total};
    }

    public String printFailureReport() {
        int total = 0;
        int failures = 0;
        StringBuilder buf = new StringBuilder();
        buf.append( "------- Unmet expectations: -------\n" );
        for ( Iterator iterator = fixtures.iterator(); iterator.hasNext(); ) {
            Fixture f = (Fixture) iterator.next();
            if ( f instanceof VerifyRuleFired ) {
                total++;
                VerifyRuleFired vr = (VerifyRuleFired) f;
                if ( vr.successResult != null && !vr.successResult.booleanValue() ) {
                    failures++;
                    buf.append( vr.explanation );
                    buf.append( '\n' );
                }
            } else if ( f instanceof VerifyFact ) {
                VerifyFact vf = (VerifyFact) f;
                for ( Iterator it = vf.fieldValues.iterator(); it.hasNext(); ) {
                    VerifyField vfl = (VerifyField) it.next();
                    if ( vfl.successResult != null && !vfl.successResult.booleanValue() ) {
                        failures++;
                        buf.append( vfl.explanation );
                        buf.append( '\n' );

                    }
                    total++;
                }
            }
        }
        buf.append( "\n------- Summary: ------\n" );
        buf.append( failures + " failures out of " + total + " expectations." );
        return buf.toString();
    }

}
