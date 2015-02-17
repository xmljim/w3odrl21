/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementUUIDAndId;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
abstract class AbstractOdrlElementUUIDAndId<T> extends AbstractOdrlElementId<T> implements IOdrlElementUUIDAndId<T> {

    /**
     * @param qName
     * @param ownerDocument
     */
    public AbstractOdrlElementUUIDAndId(final QName qName, final IOdrlDocument ownerDocument) {
        super(qName, ownerDocument);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElementUUID#setUUID(org.w3c.odrl.v21.datatypes.URIQNameQCode)
     */
    
    public void setUUID(final URIQNameQCode uuid) {
        setAttribute(OdrlQNames.UID_ATTR, uuid);

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElementUUID#getUUID()
     */
    
    public URIQNameQCode getUUID() {
        final IOdrlAttribute<URIQNameQCode> uuid = getAttribute(OdrlQNames.UID_ATTR);
        return uuid.getValue();
    }
}
