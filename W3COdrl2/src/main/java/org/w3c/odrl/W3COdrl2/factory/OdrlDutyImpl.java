/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlDuty;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
class OdrlDutyImpl extends AbstractOdrlRule<IOdrlDuty> implements IOdrlDuty {

    /**
     * @param qName
     * @param ownerDocument
     */
    public OdrlDutyImpl(final IOdrlDocument ownerDocument, final URIQNameQCode uuid) {
        super(OdrlQNames.DUTY_ELEMENT, ownerDocument);
        setUUID(uuid);
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
        final IOdrlAttribute<URIQNameQCode> attr = getAttribute(OdrlQNames.UID_ATTR);
        return attr.getValue();
    }

}
