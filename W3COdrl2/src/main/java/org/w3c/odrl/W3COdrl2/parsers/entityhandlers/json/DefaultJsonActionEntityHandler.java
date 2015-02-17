/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.entityhandlers.json;

import java.util.ArrayList;
import java.util.List;

import org.w3c.odrl.W3COdrl2.datatypes.XsToken;
import org.w3c.odrl.W3COdrl2.model.IOdrlAction;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.IOdrlRule;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlContentProcessor;
import org.w3c.odrl.W3COdrl2.parsers.OdrlContentProcessorException;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.OdrlEntityHandlerException;
import org.w3c.odrl.W3COdrl2.parsers.json.IOdrlJsonContentProcessor;
import org.w3c.odrl.W3COdrl2.parsers.json.JsonProperty;
import org.w3c.odrl.W3COdrl2.vocabulary.ActionName;

import com.ghotibown.json.JSONObject;
import com.ghotibown.json.exception.JSONInvalidValueTypeException;
import com.ghotibown.json.exception.JSONValueNotFoundException;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 10, 2014
 *
 */
public class DefaultJsonActionEntityHandler extends AbstractJsonEntityHandler<JSONObject> {

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.parsers.entityhandlers.json.AbstractJsonEntityHandler#getEntityNames()
     */
    
    public List<String> getEntityNames() {
        final ArrayList<String> entityNames = new ArrayList<String>();
        entityNames.add("action");
        return entityNames;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.parsers.entityhandlers.json.AbstractJsonEntityHandler#handleEntity(org.w3c.odrl.v21.parsers.json.JsonProperty,
     * java.lang.Object, org.w3c.odrl.v21.model.IOdrlDocument, org.w3c.odrl.v21.model.IOdrlElement,
     * org.w3c.odrl.v21.parsers.IOdrlContentProcessor)
     */
    
    public IOdrlElementBase handleEntity(final JsonProperty entityData, final JSONObject dataDocument, final IOdrlDocument document,
                    final IOdrlElement<?> parent, final IOdrlContentProcessor<String, JSONObject> processor)
                    throws OdrlEntityHandlerException {
        final JSONObject actionObject = entityData.getValue();

        final IOdrlAction action = document.createAction(null);
        

        for (final String key : actionObject.keys()) {
            try {
                if (key.equals("id")) {
                    action.setId(new XsToken(actionObject.getString(key)));
                } else if (key.equals("name")) {
                    action.setActionName(ActionName.valueOf(actionObject.getString(key)));
                } else {
                    final JsonProperty prop = new JsonProperty(key, actionObject.get(key).getValue(), entityData.getKey());
                    ((IOdrlJsonContentProcessor<String, JSONObject>) processor).handleJsonProperty(prop, dataDocument, document, action);
                }
            } catch (final JSONInvalidValueTypeException e) {
                throw new OdrlEntityHandlerException(e);
            } catch (final OdrlContentProcessorException e) {
                throw new OdrlEntityHandlerException(e);
            } catch (final JSONValueNotFoundException e) {
                throw new OdrlEntityHandlerException(e);
            }
        }

        ((IOdrlRule<?>) parent).setAction(action);
        return null;
    }

}
