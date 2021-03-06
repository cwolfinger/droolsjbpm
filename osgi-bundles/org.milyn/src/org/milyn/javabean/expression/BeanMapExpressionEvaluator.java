/*
	Milyn - Copyright (C) 2006

	This library is free software; you can redistribute it and/or
	modify it under the terms of the GNU Lesser General Public
	License (version 2.1) as published by the Free Software
	Foundation.

	This library is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

	See the GNU Lesser General Public License for more details:
	http://www.gnu.org/licenses/lgpl.txt
*/
package org.milyn.javabean.expression;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.milyn.cdr.SmooksConfigurationException;
import org.milyn.container.ExecutionContext;
import org.milyn.expression.ExecutionContextExpressionEvaluator;
import org.milyn.expression.ExpressionEvaluationException;
import org.milyn.expression.MVELExpressionEvaluator;
import org.milyn.javabean.repository.BeanRepositoryManager;

/**
 * Javabean Cartridge bean Map expression evaluator.
 * <p/>
 * Evaluates <a href="http://mvel.codehaus.org/">MVEL</a> expressions on java objects
 * bound to the supplied {@link ExecutionContext} via the {@link org.milyn.javabean.repository.BeanRepository}.
 * <p/>
 * Cab be used to selectively target resources based on the
 * contents of the java objects bound to the supplied {@link ExecutionContext}
 * via the {@link org.milyn.javabean.repository.BeanRepository}.
 * <p/>
 * The special EC variable gives access to the EditingContext.
 *
 * @author <a href="mailto:tom.fennelly@gmail.com">tom.fennelly@gmail.com</a>
 */
public class BeanMapExpressionEvaluator extends MVELExpressionEvaluator implements ExecutionContextExpressionEvaluator {

    /**
	 *
	 */
	public static final String MVEL_EXECUTION_CONTEXT_KEY = "EC";

	private static Log logger = LogFactory.getLog(BeanMapExpressionEvaluator.class);

    public BeanMapExpressionEvaluator() {
    }

    public BeanMapExpressionEvaluator(String expression) throws SmooksConfigurationException {
        setExpression(expression);
    }

    public boolean eval(ExecutionContext context) throws ExpressionEvaluationException {
        return (Boolean) getValue(context);
    }

    public Object getValue(ExecutionContext context) throws ExpressionEvaluationException {
    	Map<String, Object> beans = BeanRepositoryManager.getBeanRepository(context).getBeanMap();

        Object value = getValue(beans);

        if(logger.isDebugEnabled()) {
            logger.debug("Expression value evaluation:===============================================================");
            logger.debug("\tExpression='" + getExpression() + "'");
            logger.debug("\tBean Map='" + beans + "'");
            logger.debug("\tValue='" + value + "'");
            logger.debug("===========================================================================================");
        }

        return value;
    }

}
