/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementReference;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
class OdrlElementReferenceImpl<T> extends AbstractOdrlElementBase implements IOdrlElementReference<T> {
    private T elementReference;
    private QName referenceIdentfierAttribute;

    public OdrlElementReferenceImpl(final IOdrlDocument ownerDocument, final T elementReference, final QName referenceIdentifierAttribute) {
        super(((IOdrlElementBase) elementReference).getName(), ownerDocument);
        setReferenceTarget(elementReference);
        setReferenceIdentifierAttribute(referenceIdentifierAttribute);
        
        setAttribute(referenceIdentifierAttribute, "#" + ((IOdrlElementBase) elementReference).getAttribute(referenceIdentifierAttribute));
    }


    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElementReference#getReferenceIdentifierAttribute()
     */
    public QName getReferenceIdentifierAttribute() {
        return this.referenceIdentfierAttribute;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElementReference#getReferenceTarget()
     */
    public T getReferenceTarget() {
        return this.elementReference;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElementReference#setReferenceIdentifierAttribute(javax.xml.namespace.QName)
     */
    public void setReferenceIdentifierAttribute(final QName qname) {
        this.referenceIdentfierAttribute = qname;

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElementReference#setReferenceTarget(org.w3c.odrl.v21.model.IOdrlElement)
     */
    public void setReferenceTarget(final T element) {
        this.elementReference = element;

    }


}
