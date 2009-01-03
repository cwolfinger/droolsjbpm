package org.drools.runtime.pipeline.impl;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;

import org.drools.io.Resource;
import org.drools.runtime.pipeline.JaxbTransformerProvider;
import org.drools.runtime.pipeline.PipelineContext;
import org.drools.runtime.pipeline.Transformer;
import org.drools.runtime.pipeline.impl.BaseEmitter;
import org.drools.runtime.pipeline.impl.BaseStage;
import org.xml.sax.InputSource;

public class JaxbTransformer extends BaseEmitter
    implements
    Transformer {
    private Unmarshaller            unmarshaller;

    public JaxbTransformer(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public void receive(Object object,
                       PipelineContext context) {
        Object result = null;
        try {
            if ( object instanceof File ) {
                result = this.unmarshaller.unmarshal( (File) object );
            } else if ( object instanceof InputStream ) {
                result = this.unmarshaller.unmarshal( (InputStream) object );
            } else if ( object instanceof Reader ) {
                result = this.unmarshaller.unmarshal( (Reader) object );
            } else if ( object instanceof Source ) {
                result = this.unmarshaller.unmarshal( (Source) object );
            } else if ( object instanceof InputSource ) {
                result = this.unmarshaller.unmarshal( (InputSource) object );
            }  else if ( object instanceof Resource ) {
                result = this.unmarshaller.unmarshal( (( Resource ) object).getReader() );
            } else {
                throw new IllegalArgumentException( "signal object must be instance of File, InputStream, Reader, Source, InputSource or Resource" );
            }
        } catch ( Exception e ) {
            handleException( this,
                             object,
                             e );
        }
        
        if ( result instanceof JAXBElement ) {
            result = ((JAXBElement) object).getValue().getClass().getName();
        }
        
        emit( result,
              context );
    }

    public static class JaxbTransformerProviderImpl implements JaxbTransformerProvider {
        public Transformer newJaxbTransformer(Unmarshaller unmarshaller) {
            return new JaxbTransformer( unmarshaller );
        }
    }

}
