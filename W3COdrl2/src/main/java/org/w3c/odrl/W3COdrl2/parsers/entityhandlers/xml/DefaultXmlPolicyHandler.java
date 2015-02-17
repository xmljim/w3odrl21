/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.entityhandlers.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.odrl.W3COdrl2.datatypes.ConflictTerm;
import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.datatypes.UndefinedTerm;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.IOdrlPolicy;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlContentProcessor;
import org.w3c.odrl.W3COdrl2.vocabulary.PolicyType;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
public class DefaultXmlPolicyHandler implements IOdrlXmlEntityHandler {

    /**
     * 
     */
    public DefaultXmlPolicyHandler() {
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlEntityHandler#getEntityNames()
     */
    public List<QName> getEntityNames() {
        final ArrayList<QName> entityNames = new ArrayList<QName>();
        entityNames.add(OdrlQNames.POLICY_ELEMENT);
        return entityNames;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlEntityHandler#handleEntity(java.lang.Object, java.lang.Object, org.w3c.odrl.v21.model.IOdrlDocument, org.w3c.odrl.v21.model.IOdrlElement, org.w3c.odrl.v21.parsers.IOdrlContentProcessor)
     */
    public IOdrlElementBase handleEntity(final Element entityData, final Document dataDocument, final IOdrlDocument document, final IOdrlElement<?> parent,
                    final IOdrlContentProcessor<QName, Document> processor) {

        // System.out.println("handleEntity: " + entityData.getNodeName());

        final IOdrlPolicy policy = document.createPolicy(null, null);

        for (int i = 0; i < entityData.getAttributes().getLength(); i++) {
            final Attr att = (Attr) entityData.getAttributes().item(i);

            if (att.getName().equals(OdrlQNames.UID_ATTR.toString()) || att.getName().equals(OdrlQNames.INHERIT_FROM_ATTR.toString())
                            || att.getName().equals(OdrlQNames.INHERIT_RELATION_ATTR.toString())
                            || att.getName().equals(OdrlQNames.PROFILE_ATTR.toString())) {

                policy.setAttribute(QName.valueOf(att.getName()), URIQNameQCode.newURIQNameQCode(att.getValue()));
            } else if (att.getName().equals(OdrlQNames.INHERIT_ALLOWED_ATTR.toString())) {
                policy.setInheritAllowed(Boolean.valueOf(att.getValue()));
            } else if (att.getName().equals(OdrlQNames.TYPE_ATTR.toString())) {
                policy.setType(PolicyType.valueOf(att.getValue()));
            } else if (att.getName().equals(OdrlQNames.CONFLICT_ATTR.toString())) {
                policy.setConflict(ConflictTerm.find(att.getValue()));
            } else if (att.getName().equals(OdrlQNames.UNDEFINED_ATTR.toString())) {
                policy.setUndefined(UndefinedTerm.find(att.getValue()));
            } else {
                if (att.getNamespaceURI().equals(XMLConstants.XMLNS_ATTRIBUTE_NS_URI)) {
                    // do nothing
                } else {
                    policy.setAttribute(new QName(att.getNamespaceURI(), att.getLocalName()), att.getValue());
                }
            }
        }

        document.setPolicy(policy);

        return policy;
    }

}
