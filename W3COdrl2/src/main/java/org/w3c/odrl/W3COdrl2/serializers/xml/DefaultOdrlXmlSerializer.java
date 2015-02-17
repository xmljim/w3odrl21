/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers.xml;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.vocabulary.Vocab;

/**
 * @author Jim Earley <xml.jim@gmail.com> Feb 16, 2015
 *
 */
class DefaultOdrlXmlSerializer extends AbstractOdrlXmlSerializer {

    /**
     * Constructor
     */
    public DefaultOdrlXmlSerializer() {
        // TODO Auto-generated constructor stub
        setNamespacePrefix(Vocab.ODRL_NS, "o");
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.AbstractOdrlSerializer#write(org.w3c.odrl.v21.model.IOdrlDocument, java.io.OutputStream)
     */
    @Override
    public void write(final IOdrlDocument odrlDocument, final OutputStream output) {
        write(odrlDocument.getPolicy(), output);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.AbstractOdrlSerializer#write(org.w3c.odrl.v21.model.IOdrlDocument, java.io.Writer)
     */
    @Override
    public void write(final IOdrlDocument odrlDocument, final Writer writer) {
        write(odrlDocument.getPolicy(), writer);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.AbstractOdrlSerializer#write(org.w3c.odrl.v21.model.IOdrlElement, java.io.OutputStream)
     */
    @Override
    public void write(final IOdrlElement<?> odrlElement, final OutputStream output) {
        final OutputStreamWriter writer = new OutputStreamWriter(output);
        write(odrlElement, writer);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.AbstractOdrlSerializer#write(org.w3c.odrl.v21.model.IOdrlElement, java.io.Writer)
     */
    @Override
    public void write(final IOdrlElement<?> odrlElement, final Writer writer) {
        final IOdrlXmlUnmarshaller unmarshaller = AbstractOdrlXmlSerializer.newXmlUnmarshaller();
        final Document d = unmarshall(unmarshaller, odrlElement);

        final TransformerFactory factory = TransformerFactory.newInstance();
        try {
            final Transformer t = factory.newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            t.transform(new DOMSource(d), new StreamResult(writer));
        } catch (final TransformerConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
