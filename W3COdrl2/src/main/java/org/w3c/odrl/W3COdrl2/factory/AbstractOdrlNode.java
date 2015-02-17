/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.IOdrlNode;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
abstract class AbstractOdrlNode implements IOdrlNode {

    private QName name;
    private final IOdrlDocument ownerDocument;
    protected IOdrlElementBase parent;
    /**
     * 
     */
    public AbstractOdrlNode(final QName qName, final IOdrlDocument ownerDocument) {
        setName(qName);
        this.ownerDocument = ownerDocument;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlNode#getName()
     */
    
    public QName getName() {
        return this.name;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlNode#getParent()
     */
    
    public IOdrlElementBase getParent() {
        return this.parent;
    }

    @Override
    public boolean equals(final Object o) {
        // override to ensure that the duplicate elements in rules aren't included within the local qname list;
        return toString().equals(o.toString());
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlNode#setName(javax.xml.namespace.QName)
     */
    
    public void setName(final QName qName) {
        this.name = qName;

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlNode#getOwnerDocument()
     */
   
    public IOdrlDocument getOwnerDocument() {
        return this.ownerDocument;
    }


    protected void setParent(final IOdrlElementBase parent) {
        // System.out.println("Setting parent: " + parent.toString());
        this.parent = parent;
    }



}
