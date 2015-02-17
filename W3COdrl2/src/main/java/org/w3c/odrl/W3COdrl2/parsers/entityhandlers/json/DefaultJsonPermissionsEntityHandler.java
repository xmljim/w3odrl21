/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.entityhandlers.json;

import java.util.ArrayList;
import java.util.List;

import org.w3c.odrl.W3COdrl2.datatypes.DataTypeException;
import org.w3c.odrl.W3COdrl2.datatypes.XsToken;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.IOdrlPermission;
import org.w3c.odrl.W3COdrl2.model.IOdrlPolicy;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlContentProcessor;
import org.w3c.odrl.W3COdrl2.parsers.OdrlContentProcessorException;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.OdrlEntityHandlerException;
import org.w3c.odrl.W3COdrl2.parsers.json.IOdrlJsonContentProcessor;
import org.w3c.odrl.W3COdrl2.parsers.json.JsonProperty;

import com.ghotibown.json.JSONArray;
import com.ghotibown.json.JSONObject;
import com.ghotibown.json.JSONValue;
import com.ghotibown.json.exception.JSONInvalidValueTypeException;
import com.ghotibown.json.exception.JSONValueNotFoundException;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
public class DefaultJsonPermissionsEntityHandler extends AbstractJsonEntityHandler<JSONObject> {

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.parsers.AbstractJsonEntityHandler#getEntityNames()
     */
    @Override
    public List<String> getEntityNames() {
        final ArrayList<String> entityNames = new ArrayList<String>();
        entityNames.add("permissions");
        return entityNames;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.parsers.AbstractJsonEntityHandler#handleEntity(org.w3c.odrl.v21.parsers.JsonProperty, java.lang.Object, org.w3c.odrl.v21.model.IOdrlDocument, org.w3c.odrl.v21.model.IOdrlElement, org.w3c.odrl.v21.parsers.IOdrlContentProcessor)
     */
    @Override
    public IOdrlElementBase handleEntity(final JsonProperty entityData, final JSONObject dataDocument,
 final IOdrlDocument document,
                    final IOdrlElement<?> parent, final IOdrlContentProcessor<String, JSONObject> processor)
                    throws OdrlEntityHandlerException {
        // TODO Auto-generated method stub
        final IOdrlPolicy policy = (IOdrlPolicy) parent;
        final JSONArray permissionArray = entityData.getValue();

        for (final JSONValue<?> item : permissionArray.getValues()) {
            final JSONObject perm = (JSONObject) item.getValue();

            final IOdrlPermission permission = document.createPermission();
            policy.addPermission(permission);

            for (final String key : perm.keys()) {
                if (key.equals("id")) {
                    try {
                        permission.setId(new XsToken(perm.getString("id")));
                    } catch (final DataTypeException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (final JSONInvalidValueTypeException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    try {
                        final JsonProperty prop = new JsonProperty(key, perm.get(key).getValue(), entityData.getKey());
                        ((IOdrlJsonContentProcessor<String, JSONObject>) processor).handleJsonProperty(
                                        prop, dataDocument, document,
                                        permission);


                    } catch (final JSONValueNotFoundException e) {
                        throw new OdrlEntityHandlerException(e);
                    } catch (final OdrlContentProcessorException e) {
                        throw new OdrlEntityHandlerException(e);
                    }
                }

            }


        }
        return policy;
    }

 



}
