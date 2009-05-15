package org.drools.util;

import java.util.Collection;
import java.util.HashSet;

import org.drools.common.AbstractWorkingMemory;
import org.drools.common.DefaultFactHandle;
import org.drools.common.InternalFactHandle;
import org.drools.common.LogicalDependency;
import org.drools.common.TruthMaintenanceSystem;
import org.drools.reteoo.ImperfectAgendaItem;
import org.drools.rule.Rule;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;
import org.drools.runtime.rule.impl.AgendaImpl;
import org.drools.spi.Activation;

public class DependencyExaminer {
	
	
	public static DepTreeNode getDependencies(StatefulKnowledgeSession session, FactHandle factHandle) {
		
		TruthMaintenanceSystem tms = ((AbstractWorkingMemory) ((AgendaImpl) session.getAgenda()).getInnerAgenda().getWorkingMemory()).getTruthMaintenanceSystem();
												
		return new DepTreeNode(factHandle,tms);
		
	}
	
	
	static class ActTreeNode {
		
		private Activation activ;
		
		private DepTreeNode[] args;
		
		public ActTreeNode(Activation activation, TruthMaintenanceSystem tms) {
			
			this.activ = activation;
						
			Collection<? extends FactHandle> args = activation.getFactHandles();
			
			int j = 0;
			this.args = new DepTreeNode[args.size()];
				for (FactHandle f : args)
					this.args[j++] = new DepTreeNode(f,tms);
						
		}
		
		public String toString(int depth) {
			StringBuilder tab = new StringBuilder();
			for (int j = 0; j < depth; j++)
				tab.append("\t");
			
			StringBuilder sb = new StringBuilder();
			sb.append(tab).append("# ").append(activ.getRule().getName()).append(" ("+activ.hashCode()+")").append(" / "+ ((ImperfectAgendaItem) activ).getDegree()).append("\n");
			for (int j = 0; j < args.length; j++) {
				sb.append("\n").append(args[j].toString(depth+1));
			}
			
			
			return sb.toString();
		}
		
	}
	
	
	public static class DepTreeNode {
			
		private FactHandle object;
		private ActTreeNode[] rules;
		
		public DepTreeNode(FactHandle object, TruthMaintenanceSystem tms) {
		
			this.object = object;
	
			HashSet<LogicalDependency> deps = (HashSet<LogicalDependency>) tms.getJustifiedMap().get(((InternalFactHandle) object).getId());

			int j = 0;
			if (deps != null) {
				rules = new ActTreeNode[deps.size()]; 
				for (LogicalDependency dep : deps) {
								
					rules[j++] = new ActTreeNode(dep.getJustifier(),tms);
							
				}
			} else {
				rules = new ActTreeNode[0];
			}
								
		}
		
		
		
		public String toString() {
			return toString(0);
		}
		
		public String toString(int depth) {
			StringBuilder tab = new StringBuilder();
			for (int j = 0; j < depth; j++)
				tab.append("\t");
			
			StringBuilder sb = new StringBuilder();
			DefaultFactHandle dfh = (DefaultFactHandle) object;
			String objS = dfh.getObject() == null ? "null" : dfh.getObject().toString();
			sb.append(tab).append("* ").append(objS).append("\n");
			for (int j = 0; j < rules.length; j++) {
				sb.append("\n").append(rules[j].toString(depth+1));
			}
			
			
			return sb.toString();
		}
		
	}
	
}
