/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.entityhandlers.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.datatypes.XsToken;
import org.w3c.odrl.W3COdrl2.model.IOdrlAsset;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlContentProcessor;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.OdrlEntityHandlerException;
import org.w3c.odrl.W3COdrl2.vocabulary.AssetRelationType;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 6, 2014
 *
 */
public class DefaultXmlAssetHandler implements IOdrlXmlEntityHandler {

    /**
     * 
     */
    public DefaultXmlAssetHandler() {
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlEntityHandler#getEntityNames()
     */
  
    public List<QName> getEntityNames() {
        final ArrayList<QName> entityNames = new ArrayList<QName>();
        entityNames.add(OdrlQNames.ASSET_ELEMENT);
        return entityNames;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.IOdrlEntityHandler#handleEntity(java.lang.Object, java.lang.Object, org.w3c.odrl.v21.model.IOdrlDocument, org.w3c.odrl.v21.model.IOdrlElement, org.w3c.odrl.v21.parsers.IOdrlContentProcessor)
     */

    public IOdrlElementBase handleEntity(final Element entityData, final Document dataDocument, final IOdrlDocument document, final IOdrlElement<?> parent,
 final IOdrlContentProcessor<QName, Document> processor) throws OdrlEntityHandlerException {
        final IOdrlAsset asset = document.createAsset(null, null);
        applyAttributes(entityData, asset);

        if (parent != null) {
            parent.appendElement(asset);
        }

        return asset;
    }

    protected void applyAttributes(final Element dataElement, final IOdrlAsset asset) {
        final NamedNodeMap nnp = dataElement.getAttributes();

        for (int i = 0; i < nnp.getLength(); i++) {
            final Attr att = (Attr) nnp.item(i);

            final QName attName = new QName(att.getNamespaceURI(), att.getLocalName());

            if (attName.equals(OdrlQNames.ID_ATTR)) {
                asset.setAttribute(attName, XsToken.valueOf(att.getValue()));
            } else if (attName.equals(OdrlQNames.UID_ATTR)) {
                asset.setAttribute(attName, URIQNameQCode.newURIQNameQCode(att.getValue()));
            } else if (attName.equals(OdrlQNames.RELATION_ATTR)) {
                asset.setAttribute(attName, AssetRelationType.valueOf(att.getValue()));
            } else {
                asset.setAttribute(attName, att.getValue());
            }

        }
    }

}
