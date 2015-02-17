/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers.json;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.datatypes.ListOfValues;
import org.w3c.odrl.W3COdrl2.datatypes.QCode;
import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.datatypes.XsToken;
import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;
import org.w3c.odrl.W3COdrl2.vocabulary.Vocab;

/**
 * @author Jim Earley <xml.jim@gmail.com> Feb 15, 2015
 *
 */
public class JsonAttributeUtils {

    public static Object getAttributeValue(final IOdrlAttribute<?> attribute) {

        if (attribute.getValue() instanceof ListOfValues<?>) {
            return ((ListOfValues<?>) attribute.getValue()).getValues();
        } else if (attribute.getValue() instanceof URIQNameQCode || attribute.getValue() instanceof XsToken
                        || attribute.getValue() instanceof QCode) {
            return attribute.getValue().toString();
        } else {
            return attribute.getValue();
        }

    }

    public static String getName(final IOdrlAttribute<?> attribute) {
        final QName qname = attribute.getName();

        if (qname.getNamespaceURI().equals(Vocab.ODRL_NS) || qname.getNamespaceURI().equals("")) {

            if (attribute.getParent().getName().equals(OdrlQNames.POLICY_ELEMENT)) {
                if (attribute.getName().getLocalPart().equals("type")) {
                    return "policytype";
                } else if (attribute.getName().getLocalPart().equals("uid")) {
                    return "policyId";
                } else {
                    return qname.getLocalPart();
                }
            } else {
                return qname.getLocalPart();
            }

        } else {
            return qname.toString();
        }
    }

}
