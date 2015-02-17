/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.entityhandlers.json;

import java.util.ArrayList;
import java.util.List;

import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.datatypes.XsToken;
import org.w3c.odrl.W3COdrl2.model.IOdrlAsset;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlContentProcessor;
import org.w3c.odrl.W3COdrl2.parsers.OdrlContentProcessorException;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.OdrlEntityHandlerException;
import org.w3c.odrl.W3COdrl2.parsers.json.IOdrlJsonContentProcessor;
import org.w3c.odrl.W3COdrl2.parsers.json.JsonProperty;
import org.w3c.odrl.W3COdrl2.vocabulary.AssetRelationType;

import com.ghotibown.json.JSONArray;
import com.ghotibown.json.JSONObject;
import com.ghotibown.json.JSONValue;
import com.ghotibown.json.exception.JSONInvalidValueTypeException;
import com.ghotibown.json.exception.JSONValueNotFoundException;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 10, 2014
 *
 */
public class DefaultJsonAssetsEntityHandler extends AbstractJsonEntityHandler<JSONObject> {

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.parsers.entityhandlers.json.AbstractJsonEntityHandler#getEntityNames()
     */
    @Override
    public List<String> getEntityNames() {
        final ArrayList<String> entityNames = new ArrayList<String>();
        entityNames.add("assets");
        return entityNames;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.parsers.entityhandlers.json.AbstractJsonEntityHandler#handleEntity(org.w3c.odrl.v21.parsers.json.JsonProperty,
     * java.lang.Object, org.w3c.odrl.v21.model.IOdrlDocument, org.w3c.odrl.v21.model.IOdrlElement,
     * org.w3c.odrl.v21.parsers.IOdrlContentProcessor)
     */
    @Override
    public IOdrlElementBase handleEntity(final JsonProperty entityData, final JSONObject dataDocument, final IOdrlDocument document,
                    final IOdrlElement<?> parent, final IOdrlContentProcessor<String, JSONObject> processor)
                    throws OdrlEntityHandlerException {

        final JSONArray assetsArray = entityData.getValue();

        for (final JSONValue<?> item : assetsArray) {
            final JSONObject assetObject = (JSONObject) item.getValue();

            final IOdrlAsset asset = document.createAsset(null, null);


            for (final String key : assetObject.keys()) {
                try {
                    if (key.equals("uid")) {
                        asset.setUUID(URIQNameQCode.newURIQNameQCode(assetObject.getString(key)));
                    } else if (key.equals("id")) {
                        asset.setId(new XsToken(assetObject.getString(key)));
                    } else if (key.equals("relation")) {
                        asset.setRelation(AssetRelationType.valueOf(assetObject.getString(key)));
                    } else {
                        final JsonProperty prop = new JsonProperty(key, assetObject.get(key).getValue(), entityData.getKey());
                        ((IOdrlJsonContentProcessor<String, JSONObject>) processor).handleJsonProperty(prop, dataDocument, document, asset);
                    }
                } catch (final JSONInvalidValueTypeException e) {
                    throw new OdrlEntityHandlerException(e);
                } catch (final OdrlContentProcessorException e) {
                    throw new OdrlEntityHandlerException(e);
                } catch (final JSONValueNotFoundException e) {
                    throw new OdrlEntityHandlerException(e);
                }
            }

            parent.appendElement(asset);
        }

        return null;
    }

}
