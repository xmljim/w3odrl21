/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers;

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;

/**
 * @author Jim Earley <xml.jim@gmail.com> Feb 15, 2015
 *
 */
public abstract class AbstractOdrlUnmarshaller<T> implements IOdrlUnmarshaller<T> {
    private final Map<QName, IOdrlEntityOutputProcessor<?, T>> processors = new HashMap<QName, IOdrlEntityOutputProcessor<?, T>>();

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.IOdrlUnmarshaller#registerOutputProcesser(org.w3c.odrl.v21.serializers.IOdrlEntityOutputProcessor)
     */
  
    public <O> void registerOutputProcessor(final IOdrlEntityOutputProcessor<O, T> outputProcessor) {
        if (this.processors.containsKey(outputProcessor.getEntityName())) {
            this.processors.remove(outputProcessor.getEntityName());
        }

        this.processors.put(outputProcessor.getEntityName(), outputProcessor);

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.IOdrlUnmarshaller#getOutputProcessor(javax.xml.namespace.QName)
     */
    @SuppressWarnings("unchecked")
    public <O> IOdrlEntityOutputProcessor<O, T> getOutputProcessor(final QName qname) {
        IOdrlEntityOutputProcessor<O, T> processor = null;
        if (this.processors.containsKey(qname)) {
            processor = (IOdrlEntityOutputProcessor<O, T>) this.processors.get(qname);
        }

        return processor;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.IOdrlUnmarshaller#unmarshall(org.w3c.odrl.v21.model.IOdrlDocument)
     */
    public abstract void unmarshall(IOdrlDocument document, IOdrlSerializer serializer);

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.IOdrlUnmarshaller#unmarshall(org.w3c.odrl.v21.model.IOdrlElement)
     */
    public abstract void unmarshall(IOdrlElement<?> element, IOdrlSerializer serializer);

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.IOdrlUnmarshaller#getResult()
     */
    public abstract T getResult();

}
