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

package org.drools.planner.examples.nurserostering.domain.solver;

import java.io.Serializable;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.drools.planner.examples.nurserostering.domain.Employee;
import org.drools.planner.examples.nurserostering.domain.ShiftDate;

/**
 * @author Geoffrey De Smet
 */
public class EmployeeWorkSequence implements Comparable<EmployeeWorkSequence>, Serializable {

    private Employee employee;
    private int firstDayIndex;
    private int lastDayIndex;

    public EmployeeWorkSequence(Employee employee, int firstDayIndex, int lastDayIndex) {
        this.employee = employee;
        this.firstDayIndex = firstDayIndex;
        this.lastDayIndex = lastDayIndex;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getFirstDayIndex() {
        return firstDayIndex;
    }

    public void setFirstDayIndex(int firstDayIndex) {
        this.firstDayIndex = firstDayIndex;
    }

    public int getLastDayIndex() {
        return lastDayIndex;
    }

    public void setLastDayIndex(int lastDayIndex) {
        this.lastDayIndex = lastDayIndex;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof EmployeeWorkSequence) {
            EmployeeWorkSequence other = (EmployeeWorkSequence) o;
            return new EqualsBuilder()
                    .append(employee, other.employee)
                    .append(firstDayIndex, other.firstDayIndex)
                    .append(lastDayIndex, other.lastDayIndex)
                    .isEquals();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return new HashCodeBuilder()
                .append(employee)
                .append(firstDayIndex)
                .append(lastDayIndex)
                .toHashCode();
    }

    public int compareTo(EmployeeWorkSequence other) {
        return new CompareToBuilder()
                .append(employee, other.employee)
                .append(firstDayIndex, other.firstDayIndex)
                .append(lastDayIndex, other.lastDayIndex)
                .toComparison();
    }

    @Override
    public String toString() {
        return employee + " is working between " + firstDayIndex + " - " + lastDayIndex;
    }

    public int getDayLength() {
        return lastDayIndex - firstDayIndex + 1;
    }

}
