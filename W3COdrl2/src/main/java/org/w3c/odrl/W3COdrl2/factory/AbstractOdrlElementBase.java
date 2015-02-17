/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.AttributeList;
import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.event.IOdrlElementEventListener;
import org.w3c.odrl.W3COdrl2.model.event.OdrlAttributeEvent;
import org.w3c.odrl.W3COdrl2.model.event.OdrlElementEvent;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
abstract class AbstractOdrlElementBase extends AbstractOdrlNode implements IOdrlElementBase {
    private final Set<IOdrlElementEventListener> listeners = new HashSet<IOdrlElementEventListener>();

    AttributeListImpl attributes = new AttributeListImpl();

    /**
     * @param qName
     * @param ownerDocument
     */
    public AbstractOdrlElementBase(final QName qName, final IOdrlDocument ownerDocument) {
        super(qName, ownerDocument);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElementBase#getAttributes()
     */
    
    public AttributeList getAttributes() {
        return this.attributes;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElementBase#setAttribute(org.w3c.odrl.v21.model.IOdrlAttribute)
     */
    
    public void setAttribute(final IOdrlAttribute<?> attribute) {
        if (this.attributes.getNamedItem(attribute.getName()) != null) {
            this.attributes.getNamedItem(attribute.getName()).setValue(attribute.getValue());
            onAttributeChanged(attribute);
        } else {
            this.attributes.addNamedItem(attribute);
            ((AbstractOdrlAttribute<?>) attribute).setParent(this);
            onAttributeAdded(attribute);
        }


    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.model.IOdrlElementBase#setAttribute(javax.xml.namespace.QName, java.lang.Object)
     */
    
    public <T> void setAttribute(final QName name, final T value) {

        if (value == null) {
            if (getAttribute(name) != null) {
                // this.attributes.removeItem(getAttribute(name));
            }

        }

        final IOdrlAttribute<T> att = getOwnerDocument().createAttribute(name, value);
        setAttribute(att);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.model.IOdrlElementBase#getAttribute(javax.xml.namespace.QName)
     */
    
    public <T> IOdrlAttribute<T> getAttribute(final QName name) {

        final IOdrlAttribute<T> attr = this.attributes.getNamedItem(name);

        if (attr != null) {
            return attr;
        } else {
            return NodeFactory.createAttribute(getOwnerDocument(), name, null);
        }
    }

    
    public void addOdrlElementEventListener(final IOdrlElementEventListener listener) {
        this.listeners.add(listener);

    }

    
    public void removeOdrlElementEventListener(final IOdrlElementEventListener listener) {
        this.listeners.remove(listener);
    }

    protected void onElementAdded(final IOdrlElementBase element) {
        // System.out.println("onElementAdded: [" + element.toString() + "][context= " + toString() + "]");
        final OdrlElementEvent event = new OdrlElementEvent(element);
        for (final IOdrlElementEventListener listener : this.listeners) {
            listener.elementAdded(event);
        }
    }

    protected void onElementRemoved(final IOdrlElementBase element) {
        // System.out.println("onElementRemoved: [" + element.toString() + "][context= " + toString() + "]");
        final OdrlElementEvent event = new OdrlElementEvent(element);
        for (final IOdrlElementEventListener listener : this.listeners) {
            listener.elementRemoved(event);
        }
    }

    private void onAttributeAdded(final IOdrlAttribute<?> attribute) {
        // System.out.println("onAttributeAdded: [" + attribute.toString() + "][context= " + toString() + "]");
        final OdrlAttributeEvent event = new OdrlAttributeEvent(attribute);
        for (final IOdrlElementEventListener listener : this.listeners) {
            listener.attributeAdded(event);
        }
    }

    private void onAttributeChanged(final IOdrlAttribute<?> attribute) {
        // System.out.println("onAttributeChanged: [" + attribute.toString() + "][context= " + toString() + "]");
        final OdrlAttributeEvent event = new OdrlAttributeEvent(attribute);
        for (final IOdrlElementEventListener listener : this.listeners) {
            listener.attributeChanged(event);
        }
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        builder.append("{").append(getName().toString()).append(", attributes=[");

        for (final IOdrlAttribute<?> attr : this.attributes) {
            builder.append(attr.getName().getLocalPart());
            builder.append("=");
            builder.append(attr.getValue());
            builder.append(", ");
        }

        builder.append("]}");
        return builder.toString();
    }

}
