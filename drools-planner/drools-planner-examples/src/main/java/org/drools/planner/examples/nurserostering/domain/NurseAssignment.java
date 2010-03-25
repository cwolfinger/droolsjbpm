package org.drools.planner.examples.nurserostering.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.drools.planner.examples.common.domain.AbstractPersistable;

/**
 * @author Geoffrey De Smet
 */
@XStreamAlias("NurseAssignment")
public class NurseAssignment extends AbstractPersistable implements Comparable<NurseAssignment> {

    private Shift shift;

    // Changed by moves, between score calculations.
    private Employee employee;

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getLabel() {
        return shift + "_" + employee;
    }

    public int compareTo(NurseAssignment other) {
        return new CompareToBuilder()
                .append(shift, other.shift)
                .append(employee, other.employee)
                .toComparison();
    }

    public NurseAssignment clone() {
        NurseAssignment clone = new NurseAssignment();
        clone.id = id;
        clone.shift = shift;
        clone.employee = employee;
        return clone;
    }

    /**
     * The normal methods {@link #equals(Object)} and {@link #hashCode()} cannot be used because the rule engine already
     * requires them (for performance in their original state).
     * @see #solutionHashCode()
     */
    public boolean solutionEquals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof NurseAssignment) {
            NurseAssignment other = (NurseAssignment) o;
            return new EqualsBuilder()
                    .append(id, other.id)
                    .append(shift, other.shift)
                    .append(employee, other.employee)
                    .isEquals();
        } else {
            return false;
        }
    }

    /**
     * The normal methods {@link #equals(Object)} and {@link #hashCode()} cannot be used because the rule engine already
     * requires them (for performance in their original state).
     * @see #solutionEquals(Object)
     */
    public int solutionHashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(shift)
                .append(employee)
                .toHashCode();
    }

    @Override
    public String toString() {
        return shift + "_" + employee;
    }

}
