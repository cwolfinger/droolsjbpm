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

package org.drools.planner.examples.pas.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.drools.planner.examples.common.domain.AbstractPersistable;

/**
 * @author Geoffrey De Smet
 */
@XStreamAlias("AdmissionPart")
public class AdmissionPart extends AbstractPersistable implements Comparable<AdmissionPart> {

    private Patient patient;
    private Night firstNight;
    private Night lastNight;
    private Specialism specialism;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Night getFirstNight() {
        return firstNight;
    }

    public void setFirstNight(Night firstNight) {
        this.firstNight = firstNight;
    }

    public Night getLastNight() {
        return lastNight;
    }

    public void setLastNight(Night lastNight) {
        this.lastNight = lastNight;
    }

    public Specialism getSpecialism() {
        return specialism;
    }

    public void setSpecialism(Specialism specialism) {
        this.specialism = specialism;
    }

    public int compareTo(AdmissionPart other) {
        return new CompareToBuilder()
                .append(patient, other.patient)
                .append(firstNight, other.firstNight)
                .append(id, other.id)
                .toComparison();
    }

    @Override
    public String toString() {
        return patient + "(" + firstNight + "-" + lastNight + ")";
    }

    public int getNightCount() {
        return lastNight.getIndex() - firstNight.getIndex() + 1;
    }

    public int calculateSameNightCount(AdmissionPart other) {
        int firstNightIndex = Math.max(getFirstNight().getIndex(), other.getFirstNight().getIndex());
        int lastNightIndex = Math.min(getLastNight().getIndex(), other.getLastNight().getIndex());
        return Math.max(0, lastNightIndex - firstNightIndex + 1);
    }

}