/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers;

import java.util.HashMap;
import java.util.Map;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.IOdrlEntityHandler;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
public abstract class AbstractContentProcessor<V, D> implements IOdrlContentProcessor<V, D> {
    private final Map<V, IOdrlEntityHandler<V, ?, D>> entityHandlers = new HashMap<V, IOdrlEntityHandler<V, ?, D>>();
    private final Map<String, Object> properties = new HashMap<String, Object>();
    private IOdrlReferenceResolver referenceResolver;
    private final IOdrlParser parser;
    /**
     * 
     */
    public AbstractContentProcessor(final IOdrlParser parser) {
        this.parser = parser;
    }


    public <E> void registerEntityProcessor(final IOdrlEntityHandler<V, ?, D> entityProcessor) {
        for (final V name : entityProcessor.getEntityNames()) {
            // System.out.println("Register Entity Handler: [" + name.toString() + "] -> " + entityProcessor.getClass().getCanonicalName());
            this.entityHandlers.put(name, entityProcessor);
        }

    }

    public <E> IOdrlEntityHandler<V, ?, D> getEntityHandler(final V name) {
        return this.entityHandlers.get(name);
    }


    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlContentProcessor#processData(java.lang.Object)
     */
    public abstract IOdrlDocument processData(final D dataDocument) throws OdrlContentProcessorException;

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlContentProcessor#setProperty(java.lang.String, java.lang.Object)
     */
    public void setProperty(final String name, final Object value) {
        this.properties.put(name, value);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlContentProcessor#getProperty(java.lang.String)
     */
    public Object getProperty(final String name) {
        return this.properties.get(name);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlContentProcessor#setReferenceResolver()
     */
    public void setReferenceResolver(final IOdrlReferenceResolver resolver) {
        this.referenceResolver = resolver;

    }


    public IOdrlReferenceResolver getReferenceResolver() {
        return this.referenceResolver;
    }


    public IOdrlParser getParser() {
        return this.parser;
    }
}
