/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlExtensionElement;
import org.w3c.odrl.W3COdrl2.model.OdrlRuntimeInvalidQnameException;
import org.w3c.odrl.W3COdrl2.vocabulary.Vocab;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 4, 2014
 *
 */
class OdrlExtensionElementImpl extends AbstractOdrlElement<IOdrlExtensionElement> implements IOdrlExtensionElement {

    /**
     * @param qName
     * @param ownerDocument
     */
    public OdrlExtensionElementImpl(final QName qName, final IOdrlDocument ownerDocument) {
        super(qName, ownerDocument);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.factory.AbstractOdrlElementBase#setAttribute(javax.xml.namespace.QName, java.lang.Object)
     */
    @Override
    public <T> void setAttribute(final QName name, final T value) {
        if (name.getNamespaceURI().equals(XMLConstants.NULL_NS_URI)) {
            throw new OdrlRuntimeInvalidQnameException("Attribute cannot be in a NULL Namespace URI for external elements");
        } else if (name.getNamespaceURI().equals(Vocab.ODRL_NS)) {
            throw new OdrlRuntimeInvalidQnameException("Attribute name cannot be in the ODRL Namespace [" + Vocab.ODRL_NS + "]");
        }
        super.setAttribute(name, value);
    }

}
