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
import org.w3c.dom.NamedNodeMap;
import org.w3c.odrl.W3COdrl2.datatypes.ListOfValues;
import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.datatypes.XmlDataType;
import org.w3c.odrl.W3COdrl2.datatypes.XsToken;
import org.w3c.odrl.W3COdrl2.model.IOdrlConstraint;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlContentProcessor;
import org.w3c.odrl.W3COdrl2.vocabulary.ConstraintName;
import org.w3c.odrl.W3COdrl2.vocabulary.ConstraintOperator;
import org.w3c.odrl.W3COdrl2.vocabulary.Vocab;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 8, 2014
 *
 */
public class DefaultXmlConstraintHandler implements IOdrlXmlEntityHandler {

    /**
     * 
     */
    public DefaultXmlConstraintHandler() {
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlEntityHandler#getEntityNames()
     */
    public List<QName> getEntityNames() {
        final ArrayList<QName> entityNames = new ArrayList<QName>();
        entityNames.add(OdrlQNames.CONSTRAINT_ELEMENT);
        return entityNames;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlEntityHandler#handleEntity(java.lang.Object, java.lang.Object, org.w3c.odrl.v21.model.IOdrlDocument, org.w3c.odrl.v21.model.IOdrlElement, org.w3c.odrl.v21.parsers.IOdrlContentProcessor)
     */
    public IOdrlElementBase handleEntity(final Element entityData, final Document dataDocument, final IOdrlDocument document, final IOdrlElement<?> parent,
                    final IOdrlContentProcessor<QName, Document> processor)  {

        final IOdrlConstraint constraint = document.createConstraint(null, null, null);
        applyAttributes(entityData, constraint);
        parent.appendElement(constraint);
        return constraint;

    }

    protected void applyAttributes(final Element dataElement, final IOdrlElement<?> constraint) {
        final NamedNodeMap nnp = dataElement.getAttributes();
        final String dataType = dataElement.getAttribute(OdrlQNames.DATA_TYPE_ATTR.toString());

        for (int i = 0; i < nnp.getLength(); i++) {
            final Attr att = (Attr) nnp.item(i);

            final QName attName = new QName(att.getNamespaceURI(), att.getLocalName());

            if (attName.equals(OdrlQNames.ID_ATTR)) {
                constraint.setAttribute(attName, XsToken.valueOf(att.getValue()));
            } else if (attName.equals(OdrlQNames.CONSTRAINT_NAME_ATTR)) {
                constraint.setAttribute(attName, ConstraintName.valueOf(att.getValue()));
            } else if (attName.equals(OdrlQNames.OPERATOR_ATTR)) {
                constraint.setAttribute(attName, ConstraintOperator.valueOf(att.getValue()));
            } else if (attName.equals(OdrlQNames.RIGHT_OPERAND_ATTR)) {
                if (dataType == null || dataType.equals("")) {
                    constraint.setAttribute(attName, ListOfValues.newListOfValues(att.getValue()));
                } else {
                    if (XmlDataType.hasValue(dataType)) {
                        constraint.setAttribute(attName, ListOfValues.newListOfValues(att.getValue(), XmlDataType.find(dataType)));
                    } else {
                        constraint.setAttribute(attName, ListOfValues.newListOfValues(att.getValue()));
                    }
                }
            } else if (attName.equals(OdrlQNames.DATA_TYPE_ATTR)) {
                constraint.setAttribute(attName, URIQNameQCode.newURIQNameQCode(att.getValue()));
            } else if (attName.equals(OdrlQNames.UNIT_ATTR)) {
                constraint.setAttribute(attName, URIQNameQCode.newURIQNameQCode(att.getValue()));
            } else if (attName.equals(OdrlQNames.STATUS_ATTR)) {
                constraint.setAttribute(OdrlQNames.STATUS_ATTR, att.getValue());
            } else {
                if (!attName.getNamespaceURI().equals(XMLConstants.NULL_NS_URI) && !attName.getNamespaceURI().equals(Vocab.ODRL_NS)) {
                    constraint.setAttribute(attName, att.getValue());
                }
            }

        }
    }

}
