package org.drools.base.mvel;

import java.io.Serializable;

import org.drools.WorkingMemory;
import org.drools.spi.Salience;
import org.drools.spi.Tuple;
import org.mvel.MVEL;

public class MVELSalienceExpression
    implements
    Salience,
    Serializable {

    private static final long       serialVersionUID = 400L;

    private final Serializable      expr;
    private final DroolsMVELFactory prototype;

    public MVELSalienceExpression(final Serializable expr,
                                  final DroolsMVELFactory factory) {
        this.expr = expr;
        this.prototype = factory;
    }

    public int getValue(final Tuple tuple,
                        final WorkingMemory workingMemory) {
        DroolsMVELFactory factory = (DroolsMVELFactory) this.prototype.clone();
        factory.setContext( tuple,
                                 null,
                                 null,
                                 workingMemory,
                                 null );
        return ((Number) MVEL.executeExpression( this.expr,
                                                 factory )).intValue();
    }

}
