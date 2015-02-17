/**
 * 
 */
package org.w3c.odrl.W3COdrl2.model;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.datatypes.ListOfValues;
import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.datatypes.XsToken;
import org.w3c.odrl.W3COdrl2.model.event.IOdrlEventEnabled;
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
public interface IOdrlDocument extends IOdrlEntity, IOdrlEventEnabled {

    void setPolicy(IOdrlPolicy policy);

    IOdrlPolicy getPolicy();

    <T> IOdrlAttribute<T> createAttribute(QName attributeName, T value);

    <T> IOdrlElement<T> createElement(QName elementName);

    <T> IOdrlElementReference<T> createElementReference(T referenceTarget, QName referenceIdentifierAttribute);

    IOdrlPolicy createPolicy(URIQNameQCode uuid, PolicyType policyType);

    IOdrlAction createAction(ActionName actionName);

    IOdrlAsset createAsset(URIQNameQCode uuid, AssetRelationType relation);
    
    IOdrlParty createParty(URIQNameQCode uuid, FunctionType function);

    IOdrlConstraint createConstraint(ConstraintName name, ConstraintOperator operator, ListOfValues<?> rightOperand);

    /**
     * Creates a new Permission element. Note: all required and optional element sequences must be created separately.
     * 
     * @return a new Permission element
     */
    IOdrlPermission createPermission();

    /**
     * Creates a new Prohibition. Note: all required and optional element sequences must be created separately.
     * 
     * @return a new Permission element
     */
    IOdrlProhibition createProhibition();

    /**
     * Returns a new Duty element. Note: all required and optional element sequences must be created separately.
     * 
     * @param uuid
     *            the unique identifier for the Duty
     * @return a new Duty element
     */
    IOdrlDuty createDuty(URIQNameQCode uuid);

    /**
     * Creates an element that doesn't belong to the ODRL namespace.
     * 
     * @param name
     *            the element's QName. Must be non-null and in a namespace other than the ODRL namespace ({@linkplain Vocab#ODRL_NS})
     * @return a new Extension element
     * @throws OdrlRuntimeInvalidQnameException
     *             thrown if the element namespace is null or in the ODRL namespace
     */
    IOdrlExtensionElement createExtensionElement(QName name);

    <T> ElementList<IOdrlElement<T>> getElementsByQName(QName qname);

    <T> T getElementById(XsToken id);

    <T> T getElementByUuid(URIQNameQCode uuid);

}
