/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlProhibition;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 4, 2014
 *
 */
class OdrlProhibitionImpl extends AbstractOdrlRule<IOdrlProhibition> implements IOdrlProhibition {

    /**
     * @param qName
     * @param ownerDocument
     */
    public OdrlProhibitionImpl(final IOdrlDocument ownerDocument) {
        super(OdrlQNames.PROHIBITION_ELEMENT, ownerDocument);
    }

}
