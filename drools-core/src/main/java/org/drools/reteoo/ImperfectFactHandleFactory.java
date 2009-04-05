package org.drools.reteoo;

import org.drools.common.AbstractFactHandleFactory;
import org.drools.common.ImperfectFactHandle;
import org.drools.common.InternalFactHandle;
import org.drools.common.InternalWorkingMemory;
import org.drools.spi.FactHandleFactory;

public class ImperfectFactHandleFactory extends AbstractFactHandleFactory {
	
	
	private static final long serialVersionUID = 500L;

    public ImperfectFactHandleFactory() {
        super();
    }

    public ImperfectFactHandleFactory(int id,
                                   long counter) {
        super( id, counter );
    }
	
	

	@Override
	public FactHandleFactory newInstance() {
		return new ImperfectFactHandleFactory();
	}

	
	
	public FactHandleFactory newInstance(int id, long counter) {
		return new ImperfectFactHandleFactory(id,counter);
	}
		

	protected final InternalFactHandle newFactHandle(final int id,
            final Object object,
            final long recency,
            final ObjectTypeConf conf,
            final InternalWorkingMemory workingMemory) {
		
		//
		if ( conf != null && conf.isEvent() ) {
			throw new UnsupportedOperationException(this.getClass().toString() + " does not support event handles");
//            TypeDeclaration type = conf.getTypeDeclaration();
//            long timestamp;
//            if ( type.getTimestampExtractor() != null ) {
//                if ( Date.class.isAssignableFrom( type.getTimestampExtractor().getExtractToClass() ) ) {
//                    timestamp = ((Date) type.getTimestampExtractor().getValue( workingMemory,
//                                                                               object )).getTime();
//                } else {
//                    timestamp = type.getTimestampExtractor().getLongValue( workingMemory,
//                                                                           object );
//                }
//            } else {
//                timestamp = workingMemory.getTimerService().getCurrentTime();
//            }
//            long duration = 0;
//            if ( type.getDurationExtractor() != null ) {
//                duration = type.getDurationExtractor().getLongValue( workingMemory,
//                                                                     object );
//            }
//            
//            return new EventFactHandle( id,
//                                        object,
//                                        recency,
//                                        timestamp,
//                                        duration );
        } else {
            return new ImperfectFactHandle( id,
                                          object,
                                          recency );
        }
	
	}
	
	public Class<?> getFactHandleType() {
		return ImperfectFactHandle.class;
	}

	

}
