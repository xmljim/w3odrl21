/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.xml;

import javax.xml.namespace.QName;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.odrl.W3COdrl2.factory.PolicyBuilder;
import org.w3c.odrl.W3COdrl2.factory.PolicyFactory;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.parsers.AbstractContentProcessor;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlParser;
import org.w3c.odrl.W3COdrl2.parsers.OdrlContentProcessorException;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.IOdrlEntityHandler;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.OdrlEntityHandlerException;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
public class AbstractXmlContentProcessor extends AbstractContentProcessor<QName, Document> implements IOdrlXmlContentProcessor {

    /**
     * @param parser
     */
    public AbstractXmlContentProcessor(final IOdrlParser parser) {
        super(parser);

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlContentProcessor#registerEntityProcessor(org.w3c.odrl.v21.parsers.IOdrlEntityHandler)
     */
    @Override
    public <E> void registerEntityProcessor(final IOdrlEntityHandler<QName, ?, Document> entityProcessor) {
        super.registerEntityProcessor(entityProcessor);

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlContentProcessor#getEntityHandler(java.lang.Object)
     */
    @Override
    public <E> IOdrlEntityHandler<QName, ?, Document> getEntityHandler(final QName name) {
        return super.getEntityHandler(name);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlContentProcessor#processData(java.lang.Object)
     */
    @Override
    public IOdrlDocument processData(final Document dataDocument) throws OdrlContentProcessorException {
        final PolicyFactory policyFactory = PolicyFactory.newPolicyFactory();
        final PolicyBuilder builder = policyFactory.newPolicyBuilder();
        final IOdrlDocument document = builder.newDocument();
        handleElement(dataDocument.getDocumentElement(), document, null);
        
        return document;
    }
    
    protected void handleElement(final Element element, final IOdrlDocument document, final IOdrlElement<?> parent) {
        // System.out.println("handleElement: " + element.getLocalName());

        IOdrlElementBase result = null;
        try {
            result  = runEntityHandler(element, document, parent);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        

        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            final Node item = element.getChildNodes().item(i);
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                final Element childElement = (Element) item;
                final IOdrlElementBase newParent = result != null ? result : parent;
                handleElement(childElement, document, (IOdrlElement<?>) newParent);
            }

        }

    }

    protected IOdrlElementBase runEntityHandler(final Element element, final IOdrlDocument d, final IOdrlElementBase parent)
                    throws OdrlContentProcessorException {
        final QName qName = new QName(element.getNamespaceURI(), element.getLocalName());
        @SuppressWarnings("unchecked")
        final IOdrlEntityHandler<QName, Element, Document> handler = (IOdrlEntityHandler<QName, Element, Document>) getEntityHandler(qName);

        IOdrlElementBase result = null;
        if (handler != null) {
            try {
                result = handler.handleEntity(element, element.getOwnerDocument(), d, (IOdrlElement<?>) parent, this);
            } catch (final OdrlEntityHandlerException e) {
                throw new OdrlContentProcessorException(e);
            }
        }

        return result;
    }


 

}
