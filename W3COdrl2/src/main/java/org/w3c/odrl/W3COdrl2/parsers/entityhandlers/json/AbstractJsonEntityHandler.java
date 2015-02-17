/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.entityhandlers.json;

import java.util.List;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlContentProcessor;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.OdrlEntityHandlerException;
import org.w3c.odrl.W3COdrl2.parsers.json.JsonProperty;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
public abstract class AbstractJsonEntityHandler<D> implements IOdrlJsonEntityHandler<String, D> {

    /**
     * 
     */
    public AbstractJsonEntityHandler() {
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlEntityHandler#getEntityNames()
     */
    public abstract List<String> getEntityNames();

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.parsers.IOdrlEntityHandler#handleEntity(java.lang.Object, java.lang.Object,
     * org.w3c.odrl.v21.model.IOdrlDocument, org.w3c.odrl.v21.model.IOdrlElement, org.w3c.odrl.v21.parsers.IOdrlContentProcessor)
     */
    public abstract IOdrlElementBase handleEntity(JsonProperty entityData, D dataDocument, IOdrlDocument document, IOdrlElement<?> parent,
                    IOdrlContentProcessor<String, D> processor) throws OdrlEntityHandlerException;

}
