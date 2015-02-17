/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
class OdrlAttributeImpl<T> extends AbstractOdrlAttribute<T> {

    /**
     * @param qName
     * @param value
     * @param ownerDocument
     */
    public OdrlAttributeImpl(final QName qName, final T value, final IOdrlDocument ownerDocument) {
        super(qName, value, ownerDocument);
    }

}
