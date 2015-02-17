/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.model.IOdrlAsset;
import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;
import org.w3c.odrl.W3COdrl2.vocabulary.AssetRelationType;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
class OdrlAssetImpl extends AbstractOdrlElementUUIDAndId<IOdrlAsset> implements IOdrlAsset {


    public OdrlAssetImpl(final IOdrlDocument ownerDocument, final URIQNameQCode uuid) {
        super(OdrlQNames.ASSET_ELEMENT, ownerDocument);
        setUUID(uuid);
    }

    /**
     * @param ownerDoc
     * @param uuid
     * @param relation
     */
    public OdrlAssetImpl(final IOdrlDocument ownerDoc, final URIQNameQCode uuid, final AssetRelationType relation) {
        this(ownerDoc, uuid);
        setRelation(relation);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlAsset#setRelation(org.w3c.odrl.v21.vocabulary.AssetRelationType)
     */
    public void setRelation(final AssetRelationType relation) {
        setAttribute(OdrlQNames.RELATION_ATTR, relation);

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlAsset#getRelation()
     */
    public AssetRelationType getRelation() {
        final IOdrlAttribute<AssetRelationType> attr = getAttribute(OdrlQNames.RELATION_ATTR);
        return attr.getValue();
    }

}
