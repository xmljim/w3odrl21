/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers.json;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.IOdrlAsset;
import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;
import org.w3c.odrl.W3COdrl2.serializers.AbstractOdrlEntityOutputProcessor;
import org.w3c.odrl.W3COdrl2.serializers.IOdrlEntityOutputProcessor;
import org.w3c.odrl.W3COdrl2.serializers.IOdrlUnmarshaller;

import com.ghotibown.json.JSONArray;
import com.ghotibown.json.JSONObject;
import com.ghotibown.json.exception.JSONInvalidValueTypeException;
import com.ghotibown.json.factory.NodeFactory;

/**
 * @author Jim Earley <xml.jim@gmail.com> Feb 15, 2015
 *
 */
class DefaultAssetOutputProcessor extends AbstractOdrlEntityOutputProcessor<JSONObject, JSONObject> {

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.serializers.AbstractOdrlEntityOutputProcessor#getEntityName()
     */
    @Override
    public QName getEntityName() {
        return OdrlQNames.ASSET_ELEMENT;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.serializers.AbstractOdrlEntityOutputProcessor#processEntityToOutput(org.w3c.odrl.v21.model.IOdrlElementBase,
     * java.lang.Object, org.w3c.odrl.v21.serializers.IOdrlUnmarshaller)
     */
    @Override
    public void processEntityToOutput(final IOdrlElementBase entity, final JSONObject outputEntity,
                    final IOdrlUnmarshaller<JSONObject> unmarshaller) {

        final IOdrlAsset asset = (IOdrlAsset)entity;
        final JSONArray assetArray = getAssetsArray(outputEntity);
        final JSONObject assetObject = NodeFactory.newJSONObject();
        
        for (final IOdrlAttribute<?> att : asset.getAttributes()) {
            DefaultJsonAttributeUtils.writeAttribute(att, assetObject);
        }
        
        for (final IOdrlElementBase elem : asset.getChildren()) {
            final IOdrlEntityOutputProcessor<JSONObject, JSONObject> elemProc = unmarshaller.getOutputProcessor(elem.getName());
            if (elemProc != null) {
                elemProc.processEntityToOutput(elem, assetObject, unmarshaller);
            }
        }
        
        assetArray.add(assetObject);
    }
    
    private JSONArray getAssetsArray(final JSONObject outputEntity) {
        JSONArray assetArray = null;
        if (outputEntity.containsKey("assets")) {
            try {
                assetArray = outputEntity.getJSONArray("assets");
            } catch (final JSONInvalidValueTypeException e) {

                e.printStackTrace();
            }
        } else {
            assetArray = NodeFactory.newJSONArray();
            outputEntity.put("assets", assetArray);
        }

        return assetArray;
    }

}
