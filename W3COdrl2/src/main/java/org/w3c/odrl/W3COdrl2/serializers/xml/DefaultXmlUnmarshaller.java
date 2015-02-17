/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers.xml;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.serializers.AbstractOdrlUnmarshaller;
import org.w3c.odrl.W3COdrl2.serializers.IOdrlSerializer;

/**
 * @author Jim Earley <xml.jim@gmail.com> Feb 16, 2015
 *
 */
public class DefaultXmlUnmarshaller extends AbstractOdrlUnmarshaller<Document> implements IOdrlXmlUnmarshaller {
    private Document result;

    public DefaultXmlUnmarshaller() {
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;

        try {
            builder = factory.newDocumentBuilder();
            this.result = builder.newDocument();
        } catch (final ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.serializers.IOdrlUnmarshaller#unmarshall(org.w3c.odrl.v21.model.IOdrlDocument)
     */
    @Override
    public void unmarshall(final IOdrlDocument document, final IOdrlSerializer serializer) {
        unmarshall(document.getPolicy(), serializer);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.serializers.IOdrlUnmarshaller#unmarshall(org.w3c.odrl.v21.model.IOdrlElement)
     */
    @Override
    public void unmarshall(final IOdrlElement<?> element, final IOdrlSerializer serializer) {
        writeToDocument(element, null, serializer);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.serializers.IOdrlUnmarshaller#getResult()
     */
    @Override
    public Document getResult() {
        // TODO Auto-generated method stub
        return this.result;
    }

    protected void writeToDocument(final IOdrlElementBase element, final Element parentElement, final IOdrlSerializer serializer) {
        Element newElement = null;
        final QName qname = element.getName();
        if (qname.getNamespaceURI().equals("")) {

            newElement = getResult().createElement(qname.getLocalPart());
        } else {
            final IOdrlXmlSerializer xmlSerializer = (IOdrlXmlSerializer) serializer;
            final String prefix = xmlSerializer.getNamespacePrefix(qname.getNamespaceURI());
            newElement = getResult().createElementNS(qname.getNamespaceURI(), qname.getLocalPart());
            if (prefix != null) {
                newElement.setPrefix(prefix);
            }
        }

        setAttributes(element, newElement, serializer);

        if (element instanceof IOdrlElement<?>) {
            for (final IOdrlElementBase e : ((IOdrlElement<?>) element).getChildren()) {
                writeToDocument(e, newElement, serializer);
            }
        }

        if (parentElement == null) {
            getResult().appendChild(newElement);
        } else {
            parentElement.appendChild(newElement);
        }

    }

    protected void setAttributes(final IOdrlElementBase element, final Element newElement, final IOdrlSerializer serializer) {
        for (final IOdrlAttribute<?> att : element.getAttributes()) {
            final QName qname = att.getName();
            final String value = att.getValue() == null ? "" : att.getValue().toString();

            if (null == qname.getNamespaceURI() || qname.getNamespaceURI().equals("")) {

                newElement.setAttribute(qname.getLocalPart(), value);
            } else {
                String qualName = null;
                final IOdrlXmlSerializer xmlSerializer = (IOdrlXmlSerializer) serializer;
                final String prefix = xmlSerializer.getNamespacePrefix(qname.getNamespaceURI());

                if (prefix == null) {
                    qualName = qname.getLocalPart();
                } else {
                    qualName = prefix + ":" + qname.getLocalPart();
                }

                newElement.setAttributeNS(qname.getNamespaceURI(), qualName, value);
            }
        }
    }
}
