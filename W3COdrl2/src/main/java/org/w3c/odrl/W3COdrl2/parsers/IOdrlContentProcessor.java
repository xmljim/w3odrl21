/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.IOdrlEntityHandler;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 4, 2014
 *
 */
public interface IOdrlContentProcessor<V, D> {

    <E> void registerEntityProcessor(IOdrlEntityHandler<V, ?, D> entityProcessor);

    <E> IOdrlEntityHandler<V, ?, D> getEntityHandler(V name);

    IOdrlDocument processData(D dataDocument) throws OdrlContentProcessorException;

    void setProperty(String name, Object value);

    Object getProperty(String name);

    void setReferenceResolver(IOdrlReferenceResolver resolver);

    IOdrlReferenceResolver getReferenceResolver();

    IOdrlParser getParser();

}
