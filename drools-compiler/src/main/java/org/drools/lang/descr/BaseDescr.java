package org.drools.lang.descr;

/*
 * Copyright 2005 JBoss Inc
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

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * This is the super type for all pattern AST nodes.
 */
public class BaseDescr
    implements
    Externalizable {

    private static final long serialVersionUID = 400L;
    private int               startCharacter   = -1;
    private int               endCharacter     = -1;
    private int               line             = -1;
    private int               column           = -1;
    private int               endLine          = -1;
    private int               endColumn        = -1;
    private String            text             = "";
    private int				  id			   = -1;
    
    private boolean			  cutter		   = false;
    private String 			  params 		   = null;
    private String 			  label			   = null;
    private String 			  prior			   = null;
    
  
     
    public int getId() {
    	return id;
    }
    
    public void setId(int newId) {
    	id = newId;
    }
    
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        startCharacter  = in.readInt();
        endCharacter  = in.readInt();
        line        = in.readInt();
        column      = in.readInt();
        endLine     = in.readInt();
        endColumn   = in.readInt();
        text        = (String)in.readObject();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(startCharacter);
        out.writeInt(endCharacter);
        out.writeInt(line);
        out.writeInt(column);
        out.writeInt(endLine);
        out.writeInt(endColumn);
        out.writeObject(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setLocation(final int line,
                            final int column) {
        this.line = line;
        this.column = column;
    }

    public void setEndLocation(final int line,
                               final int column) {
        this.endLine = line;
        this.endColumn = column;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }

    public int getEndLine() {
        return this.endLine;
    }

    public int getEndColumn() {
        return this.endColumn;
    }

    /**
     * @return the endCharacter
     */
    public int getEndCharacter() {
        return this.endCharacter;
    }

    /**
     * @param endCharacter the endCharacter to set
     */
    public void setEndCharacter(final int endCharacter) {
        this.endCharacter = endCharacter;
    }

    /**
     * @return the startCharacter
     */
    public int getStartCharacter() {
        return this.startCharacter;
    }

    /**
     * @param startCharacter the startCharacter to set
     */
    public void setStartCharacter(final int startCharacter) {
        this.startCharacter = startCharacter;
    }

	/**
	 * @param cutter the cutter to set
	 */
	public void setCutter(boolean cutter) {
		this.cutter = cutter;
	}

	/**
	 * @return the cutter
	 */
	public boolean isCutter() {
		return cutter;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(String params) {
		this.params = params;
	}

	/**
	 * @return the params
	 */
	public String getParams() {
		return params;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {	
		if (label != null)
			System.err.println(label);
		this.label = label;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		
		return label;
	}

	/**
	 * @param prior the prior to set
	 */
	public void setPrior(String prior) {
		this.prior = prior;
	}

	/**
	 * @return the prior
	 */
	public String getPrior() {
		return prior;
	}
}