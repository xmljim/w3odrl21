/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.entityhandlers;

import java.util.List;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlContentProcessor;

/**
 * 
 * @author Jim Earley <xml.jim@gmail.com> Sep 4, 2014
 *
 * @param <V>
 *            Specifies the data type of the entity value that will be used to trigger this entity processor. For example, this could be a
 *            {@link QName} for XML documents, or a String to represent the key to a JSONObject or JSONArray.
 * @param <E>
 *            Specifies the data type of the entity name. For example, this might be a DOM Element for XML encodings, or Object or
 *            {@link JSONValue} for JSON encodings (depending on your JSON implementation).
 * @param <D>
 *            Specifies the data type of the ODRL root document holding the data (e.g,. a JSONObject, or DOM Document)
 * 
 */
public interface IOdrlEntityHandler<V, E, D> {

    /**
     * Returns the set of entity names that this handler supports.
     * 
     * @return
     */
    List<V> getEntityNames();

    /**
     * Process the entity
     * 
     * @param entity
     *            The entity in its native data entity type (e.g., a DOM Element)
     * @param dataDocument
     *            the native document implementation holding the entire ODRL document
     * @param document
     *            the local OdrlDocument implementation
     * @param parent
     *            the current Odrl Element parent
     * @param processor
     *            the {@link IOdrlContentProcessor} implementation calling this handler
     */
    IOdrlElementBase handleEntity(E entityData, D dataDocument, IOdrlDocument document, IOdrlElement<?> parent,
                    IOdrlContentProcessor<V, D> processor) throws OdrlEntityHandlerException;
}
