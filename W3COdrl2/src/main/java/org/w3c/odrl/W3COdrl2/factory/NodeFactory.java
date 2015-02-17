/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.datatypes.ListOfValues;
import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.model.AttributeList;
import org.w3c.odrl.W3COdrl2.model.ElementList;
import org.w3c.odrl.W3COdrl2.model.IOdrlAction;
import org.w3c.odrl.W3COdrl2.model.IOdrlAsset;
import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlConstraint;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlDuty;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementReference;
import org.w3c.odrl.W3COdrl2.model.IOdrlExtensionElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlParty;
import org.w3c.odrl.W3COdrl2.model.IOdrlPermission;
import org.w3c.odrl.W3COdrl2.model.IOdrlPolicy;
import org.w3c.odrl.W3COdrl2.model.IOdrlProhibition;
import org.w3c.odrl.W3COdrl2.vocabulary.ActionName;
import org.w3c.odrl.W3COdrl2.vocabulary.AssetRelationType;
import org.w3c.odrl.W3COdrl2.vocabulary.ConstraintName;
import org.w3c.odrl.W3COdrl2.vocabulary.ConstraintOperator;
import org.w3c.odrl.W3COdrl2.vocabulary.FunctionType;
import org.w3c.odrl.W3COdrl2.vocabulary.PolicyType;
import org.w3c.odrl.W3COdrl2.vocabulary.Vocab;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */

class NodeFactory {

    /**
     * 
     */
    private NodeFactory() {
    }

    public static <T> ElementList<T> newElementList() {
        return null;
    }

    public static AttributeList newAttributeList() {
        return null;
    }

    public static final IOdrlAsset createAsset(final IOdrlDocument ownerDoc, final URIQNameQCode uuid, final AssetRelationType relation) {
        return new OdrlAssetImpl(ownerDoc, uuid, relation);
    }

    public static final <T> IOdrlAttribute<T> createAttribute(final IOdrlDocument owner, final QName name, final T value) {
        return new OdrlAttributeImpl<T>(name, value, owner);
    }

    public static final <T> IOdrlElement<T> createElement(final IOdrlDocument owner, final QName name) {
        return new OdrlElementImpl<T>(name, owner);
    }

    public static final IOdrlExtensionElement createExtensionElement(final IOdrlDocument owner, final QName name) {

        if (name.getNamespaceURI().equals(XMLConstants.NULL_NS_URI)) {
            throw new OdrlRuntimeFactoryException("Element Namespace URI cannot be null");
        } else if (name.getNamespaceURI().equals(Vocab.ODRL_NS)) {
            throw new OdrlRuntimeFactoryException("External Element Namespace URI cannot be in the ODRL Namespace [" + Vocab.ODRL_NS + "]");
        }

        return new OdrlExtensionElementImpl(name, owner);
    }

    public static final IOdrlAction createAction(final IOdrlDocument ownerDocument, final ActionName name) {
        return new OdrlActionImpl(ownerDocument, name);
    }

    public static final IOdrlConstraint createConstraint(final IOdrlDocument ownerDoc, final ConstraintName name,
                    final ConstraintOperator operator, final ListOfValues<?> rightOperand) {
        return new OdrlConstraintImpl(ownerDoc, name, operator, rightOperand);
    }

    public static final IOdrlPolicy createPolicy(final IOdrlDocument ownerDocument, final URIQNameQCode uuid, final PolicyType type) {
        return new OdrlPolicyImpl(ownerDocument, uuid, type);
    }

    public static final <T> IOdrlElementReference<T> createElementReference(final IOdrlDocument ownerDocument, final T referenceTarget,
                    final QName referenceIdentifierAttribute) {
        return new OdrlElementReferenceImpl<T>(ownerDocument, referenceTarget, referenceIdentifierAttribute);
    }

    public static final IOdrlParty createParty(final IOdrlDocument ownerDocument, final URIQNameQCode uuid, final FunctionType function) {
        return new OdrlPartyImpl(ownerDocument, uuid, function);
    }

    public static final IOdrlPermission createPermission(final IOdrlDocument ownerDocument) {
        return new OdrlPermissionImpl(ownerDocument);
    }

    public static final IOdrlProhibition createProhibition(final IOdrlDocument ownerDocument) {
        return new OdrlProhibitionImpl(ownerDocument);
    }

    public static final IOdrlDuty createDuty(final IOdrlDocument ownerDocument, final URIQNameQCode uuid) {
        return new OdrlDutyImpl(ownerDocument, uuid);
    }
}
