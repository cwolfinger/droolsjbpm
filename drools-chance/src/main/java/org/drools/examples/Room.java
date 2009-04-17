package org.drools.examples;

import org.drools.fuzzy.RealDomain;
import org.drools.fuzzy.evaluators.IDynamicEvaluable;
import org.drools.spi.Evaluator;


public class Room implements IDynamicEvaluable{
	
		private TemperatureDomain temperature = new TemperatureDomain();

		
		
		public Room(double temp) {
			this.setTemperature(temp);
		}
		

		/**
		 * @param temperature the temperature to set
		 */
		public void setTemperature(Double temperature) {
			this.temperature.setValue(temperature);
		}

		/**
		 * @return the temperature
		 */
		public Double getTemperature() {
			return temperature.getValue();
		}
		
		
		public Evaluator getHot() {
			return temperature.getEvaluator(TemperatureDomain.HOT);
		}


		
		public Evaluator getPred(String opId) {
			return temperature.getEvaluator(opId);
		}
		


}
