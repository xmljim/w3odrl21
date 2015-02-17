/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;

/**
 * Interface for unmarshalling IOdrl* interface entities into intermediate output representations (e.g., JSON or XML).
 * 
 * @author Jim Earley <xml.jim@gmail.com> Feb 15, 2015
 *
 */
public interface IOdrlUnmarshaller<T> {

    /**
     * Register an {@link IOdrlEntityOutputProcessor}
     * 
     * @param outputProcessor
     * @param E
     *            the {@link IOdrlElement} entity type
     * @param O
     *            the output type
     */
    <O> void registerOutputProcessor(IOdrlEntityOutputProcessor<O, T> outputProcessor);

    <O> IOdrlEntityOutputProcessor<O, T> getOutputProcessor(QName qname);

    void unmarshall(IOdrlDocument document, IOdrlSerializer serializer);

    void unmarshall(IOdrlElement<?> element, IOdrlSerializer serializer);

    T getResult();

}
