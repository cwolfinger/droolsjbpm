package org.drools.spring.core.aspects;

import org.drools.WorkingMemory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionStatus;
import org.springframework.transaction.support.SmartTransactionObject;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.Assert;

/**
 * To execute drools operations within JTA transactions. In a standalone application or test suite.
 *
 */
public class DroolsTransactionManager extends AbstractPlatformTransactionManager implements InitializingBean {

	private WorkingMemory workingMemory;
	
	/**
	 * Creates a DroolsTransactionManager instance.
	 */
	public DroolsTransactionManager() {
	}
	
	/**
	 * Create a new DroolsTransactionManager instance.
	 * 
	 * @param workingMemory working memory to manage transactions for
	 */
	public DroolsTransactionManager(WorkingMemory workingMemory) {
		this.workingMemory = workingMemory;
	}
	
	public void setWorkingMemory(WorkingMemory workingMemory) {
		this.workingMemory = workingMemory;
	}
	
	public WorkingMemory getWorkingMemory() {
		return workingMemory;
	}
	
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(getWorkingMemory(), "The working memory is required.");
	}

	@Override
	protected void doBegin(Object transaction, TransactionDefinition definition)
			throws TransactionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doCommit(DefaultTransactionStatus status)
			throws TransactionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Object doGetTransaction() throws TransactionException {
		DroolsTransactionObject txObject = new DroolsTransactionObject();
		WorkingMemoryHolder wmHolder = (WorkingMemoryHolder) TransactionSynchronizationManager.getResource(getWorkingMemory());
		txObject.setWorkingMemoryHolder(wmHolder);
		return txObject;
	}

	@Override
	protected void doRollback(DefaultTransactionStatus status)
			throws TransactionException {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Internal transaction object.
	 * 
	 * @see org.springframework.transaction.support.SmartTransactionObject
	 * 
	 */
	private static class DroolsTransactionObject implements SmartTransactionObject {

		private WorkingMemoryHolder workingMemoryHolder;

		public void setWorkingMemoryHolder(WorkingMemoryHolder workingMemoryHolder) {
			this.workingMemoryHolder = workingMemoryHolder;
		}

		public WorkingMemoryHolder getWorkingMemoryHolder() {
			return workingMemoryHolder;
		}

		public void setRollbackOnly() {
			getWorkingMemoryHolder().setRollbackOnly();
		}

		public boolean isRollbackOnly() {
			return getWorkingMemoryHolder().isRollbackOnly();
		}

		/**
		 * Db4o executes everything in a transaction.
		 * @return
		 */
		public boolean hasTransaction() {
			return (workingMemoryHolder != null);
		}

	}

}
