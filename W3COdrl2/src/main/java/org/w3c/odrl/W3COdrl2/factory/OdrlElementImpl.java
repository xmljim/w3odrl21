/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 4, 2014
 *
 */
public class OdrlElementImpl<T> extends AbstractOdrlElement<T> implements IOdrlElement<T> {

    /**
     * @param qName
     * @param ownerDocument
     */
    public OdrlElementImpl(final QName qName, final IOdrlDocument ownerDocument) {
        super(qName, ownerDocument);
    }

}
