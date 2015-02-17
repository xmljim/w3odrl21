/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.ElementList;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementReference;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
abstract class AbstractOdrlElement<T> extends AbstractOdrlElementBase implements IOdrlElement<T> {
    
    protected ElementListImpl<IOdrlElementBase> children = new ElementListImpl<IOdrlElementBase>();
    protected ElementListImpl<IOdrlElementReference<T>> references = new ElementListImpl<IOdrlElementReference<T>>();

    /**
     * @param qName
     * @param ownerDocument
     */
    public AbstractOdrlElement(final QName qName, final IOdrlDocument ownerDocument) {
        super(qName, ownerDocument);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElement#appendElement(org.w3c.odrl.v21.model.IOdrlElementBase)
     */
    
    public void appendElement(final IOdrlElementBase newElement) {
        this.children.addNamedItem(newElement);
        ((AbstractOdrlElementBase) newElement).setParent(this);
        onElementAdded(newElement);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElement#getChildren()
     */
    
    public ElementList<IOdrlElementBase> getChildren() {
        return this.children;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElement#getReferencedBy()
     */
    
    public ElementList<IOdrlElementReference<T>> getReferencedBy() {
        return this.references;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElement#insertElementAfter(org.w3c.odrl.v21.model.IOdrlElementBase, org.w3c.odrl.v21.model.IOdrlElementBase)
     */
    
    public void insertElementAfter(final IOdrlElementBase newElement, final IOdrlElementBase afterElement) {
        final int count = getChildren().getItemCount() - 1;
        int i = 0;
        for (final IOdrlElementBase item : getChildren().items()) {
            if (item.equals(afterElement)) {
                break;
            }
            i++;
        }

        if (i < count) {
            this.children.addNamedItemAt(newElement, i + 1);
        } else {
            this.children.addNamedItem(newElement);
        }

        onElementAdded(newElement);
        ((AbstractOdrlElementBase) newElement).setParent(this);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElement#insertElementBefore(org.w3c.odrl.v21.model.IOdrlElementBase, org.w3c.odrl.v21.model.IOdrlElementBase)
     */
    
    public void insertElementBefore(final IOdrlElementBase newElement, final IOdrlElementBase beforeElement) {
        getChildren().getItemCount();
        int i = 0;
        for (final IOdrlElementBase item : getChildren().items()) {
            if (item.equals(beforeElement)) {
                break;
            }
            i++;
        }

        if (i > 0) {
            this.children.addNamedItemAt(newElement, i - 1);
        } else {
            this.children.addNamedItem(newElement);
        }

        onElementAdded(newElement);
        ((AbstractOdrlElementBase) newElement).setParent(this);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElement#removeElement(org.w3c.odrl.v21.model.IOdrlElementBase)
     */
    
    public IOdrlElementBase removeElement(final IOdrlElementBase elementToRemove) {

        this.children.removeItem(elementToRemove);
        onElementRemoved(elementToRemove);
        return elementToRemove;

    }

    protected void notifyReference(final IOdrlElementReference<T> reference) {
        this.references.addNamedItem(reference);
    }

}
