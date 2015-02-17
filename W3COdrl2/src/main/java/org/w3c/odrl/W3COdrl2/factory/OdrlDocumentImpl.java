/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.datatypes.ListOfValues;
import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.datatypes.XsToken;
import org.w3c.odrl.W3COdrl2.model.ElementList;
import org.w3c.odrl.W3COdrl2.model.IOdrlAction;
import org.w3c.odrl.W3COdrl2.model.IOdrlAsset;
import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlConstraint;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlDuty;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementReference;
import org.w3c.odrl.W3COdrl2.model.IOdrlExtensionElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlParty;
import org.w3c.odrl.W3COdrl2.model.IOdrlPermission;
import org.w3c.odrl.W3COdrl2.model.IOdrlPolicy;
import org.w3c.odrl.W3COdrl2.model.IOdrlProhibition;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;
import org.w3c.odrl.W3COdrl2.model.event.IOdrlElementEventListener;
import org.w3c.odrl.W3COdrl2.model.event.OdrlAttributeEvent;
import org.w3c.odrl.W3COdrl2.model.event.OdrlElementEvent;
import org.w3c.odrl.W3COdrl2.vocabulary.ActionName;
import org.w3c.odrl.W3COdrl2.vocabulary.AssetRelationType;
import org.w3c.odrl.W3COdrl2.vocabulary.ConstraintName;
import org.w3c.odrl.W3COdrl2.vocabulary.ConstraintOperator;
import org.w3c.odrl.W3COdrl2.vocabulary.FunctionType;
import org.w3c.odrl.W3COdrl2.vocabulary.PolicyType;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 4, 2014
 *
 */
public class OdrlDocumentImpl implements IOdrlDocument, IOdrlElementEventListener {
    private IOdrlPolicy policy;

    private final ElementListImpl<IOdrlElementBase> elements = new ElementListImpl<IOdrlElementBase>();
    private final Set<IOdrlElementEventListener> listeners = new HashSet<IOdrlElementEventListener>();

    /**
     * 
     */
    public OdrlDocumentImpl() {

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlDocument#setPolicy(org.w3c.odrl.v21.model.IOdrlPolicy)
     */
    public void setPolicy(final IOdrlPolicy policy) {
        this.policy = policy;
        this.policy.addOdrlElementEventListener(this);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlDocument#getPolicy()
     */
    public IOdrlPolicy getPolicy() {
        return this.policy;

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlDocument#createAttribute(javax.xml.namespace.QName, java.lang.Object)
     */
    public <T> IOdrlAttribute<T> createAttribute(final QName attributeName, final T value) {
        return NodeFactory.createAttribute(this, attributeName, value);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlDocument#createElement(javax.xml.namespace.QName)
     */
    public <T> IOdrlElement<T> createElement(final QName elementName) {
        final IOdrlElement<T> element = NodeFactory.createElement(this, elementName);
        element.addOdrlElementEventListener(this);
        return element;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlDocument#createElementReference(java.lang.Object, javax.xml.namespace.QName)
     */
    public <T> IOdrlElementReference<T> createElementReference(final T referenceTarget, final QName referenceIdentifierAttribute) {
        final IOdrlElementReference<T> element = NodeFactory.createElementReference(this, referenceTarget, referenceIdentifierAttribute);
        element.addOdrlElementEventListener(this);
        return element;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlDocument#createPolicy(org.w3c.odrl.v21.datatypes.URIQNameQCode, org.w3c.odrl.v21.vocabulary.PolicyType)
     */
    public IOdrlPolicy createPolicy(final URIQNameQCode uuid, final PolicyType policyType) {
        final IOdrlPolicy element = NodeFactory.createPolicy(this, uuid, policyType);
        // element.addOdrlElementEventListener(this);
        return element;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlDocument#createAction(org.w3c.odrl.v21.vocabulary.ActionName)
     */
    public IOdrlAction createAction(final ActionName actionName) {
        final IOdrlAction element = NodeFactory.createAction(this, actionName);
        element.addOdrlElementEventListener(this);
        return element;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlDocument#createAsset(org.w3c.odrl.v21.datatypes.URIQNameQCode, org.w3c.odrl.v21.vocabulary.AssetRelationType)
     */
    public IOdrlAsset createAsset(final URIQNameQCode uuid, final AssetRelationType relation) {
        final IOdrlAsset element = NodeFactory.createAsset(this, uuid, relation);
        element.addOdrlElementEventListener(this);
        return element;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlDocument#createParty(org.w3c.odrl.v21.datatypes.URIQNameQCode, org.w3c.odrl.v21.vocabulary.FunctionType)
     */
    public IOdrlParty createParty(final URIQNameQCode uuid, final FunctionType function) {
        final IOdrlParty element = NodeFactory.createParty(this, uuid, function);
        element.addOdrlElementEventListener(this);
        return element;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlDocument#createConstraint(org.w3c.odrl.v21.vocabulary.ConstraintName, org.w3c.odrl.v21.vocabulary.ConstraintOperator, org.w3c.odrl.v21.datatypes.ListOfValues)
     */
    public IOdrlConstraint createConstraint(final ConstraintName name, final ConstraintOperator operator, final ListOfValues<?> rightOperand) {
        final IOdrlConstraint element = NodeFactory.createConstraint(this, name, operator, rightOperand);
        element.addOdrlElementEventListener(this);
        return element;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlDocument#createPermission()
     */
    public IOdrlPermission createPermission() {

        final IOdrlPermission element = NodeFactory.createPermission(this);
        element.addOdrlElementEventListener(this);
        return element;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlDocument#createProhibition()
     */
    public IOdrlProhibition createProhibition() {
        final IOdrlProhibition element = NodeFactory.createProhibition(this);
        element.addOdrlElementEventListener(this);
        return element;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlDocument#createDuty(org.w3c.odrl.v21.datatypes.URIQNameQCode)
     */
    public IOdrlDuty createDuty(final URIQNameQCode uuid) {
        final IOdrlDuty element = NodeFactory.createDuty(this, uuid);
        element.addOdrlElementEventListener(this);
        return element;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlDocument#createExternalElement(javax.xml.namespace.QName)
     */
    public IOdrlExtensionElement createExtensionElement(final QName name) {
        final IOdrlExtensionElement element = NodeFactory.createExtensionElement(this, name);
        element.addOdrlElementEventListener(this);
        return element;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.model.IOdrlDocument#getElementsByQName(javax.xml.namespace.QName)
     */
    @SuppressWarnings("unchecked")
    public <T> ElementList<IOdrlElement<T>> getElementsByQName(final QName qname) {
        final ElementListImpl<IOdrlElement<T>> elemList = new ElementListImpl<IOdrlElement<T>>();

        for (final IOdrlElementBase base : this.elements.getItemsByName(qname)) {
            elemList.addNamedItem((IOdrlElement<T>) base);
        }

        return elemList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.model.IOdrlDocument#getElementById(org.w3c.odrl.v21.datatypes.XsToken)
     */
    @SuppressWarnings("unchecked")
    public <T> T getElementById(final XsToken id) {
        return (T) this.elements.getItemById(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.model.IOdrlDocument#getElementByUuid(org.w3c.odrl.v21.datatypes.URIQNameQCode)
     */
    @SuppressWarnings("unchecked")
    public <T> T getElementByUuid(final URIQNameQCode uuid) {
        return (T) this.elements.getItemByUuid(uuid);
    }


    public void addOdrlElementEventListener(final IOdrlElementEventListener listener) {
        this.listeners.add(listener);

    }

    public void removeOdrlElementEventListener(final IOdrlElementEventListener listener) {
        this.listeners.remove(listener);
    }

    private void onElementAdded(final OdrlElementEvent event) {

        for (final IOdrlElementEventListener listener : this.listeners) {
            listener.elementAdded(event);

        }
    }

    private void onElementRemoved(final OdrlElementEvent event) {

        for (final IOdrlElementEventListener listener : this.listeners) {
            listener.elementRemoved(event);
        }
    }

    private void onAttributeAdded(final OdrlAttributeEvent event) {

        for (final IOdrlElementEventListener listener : this.listeners) {
            listener.attributeAdded(event);
        }
    }

    private void onAttributeChanged(final OdrlAttributeEvent event) {

        for (final IOdrlElementEventListener listener : this.listeners) {
            listener.attributeChanged(event);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.model.event.IOdrlElementEventListener#elementAdded(org.w3c.odrl.v21.model.event.OdrlElementEvent)
     */
    public void elementAdded(final OdrlElementEvent event) {

        if (!this.elements.hasItem(event.getSource())) {
            this.elements.addNamedItem(event.getSource());
            // System.out.println("Updated UUID Map: " + this.elements.printUUIDMap());
        }
        onElementAdded(event);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.model.event.IOdrlElementEventListener#elementRemoved(org.w3c.odrl.v21.model.event.OdrlElementEvent)
     */
    public void elementRemoved(final OdrlElementEvent event) {
        this.elements.removeItem(event.getSource());
        onElementRemoved(event);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.model.event.IOdrlElementEventListener#attributeAdded(org.w3c.odrl.v21.model.event.OdrlAttributeEvent)
     */
    public void attributeAdded(final OdrlAttributeEvent event) {

        if (event.getSource() == null) {
            return;
        }

        if (event.getSource().getParent() == null) {
            return;
        }
        
        if (!this.elements.hasItem(event.getSource().getParent())) {
            return;
        }

        if (event.getSource().getName().equals(OdrlQNames.ID_ATTR) || event.getSource().getName().equals(OdrlQNames.UID_ATTR)) {
            this.elements.updateLocalMaps(event.getElement());
        }
        onAttributeAdded(event);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.model.event.IOdrlElementEventListener#attributeChanged(org.w3c.odrl.v21.model.event.OdrlAttributeEvent)
     */
    public void attributeChanged(final OdrlAttributeEvent event) {
        onAttributeChanged(event);
    }

}
