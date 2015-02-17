/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.entityhandlers.json;

import java.util.ArrayList;
import java.util.List;

import org.w3c.odrl.W3COdrl2.datatypes.ListOfValues;
import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.datatypes.XmlDataType;
import org.w3c.odrl.W3COdrl2.datatypes.XsToken;
import org.w3c.odrl.W3COdrl2.model.IOdrlConstraint;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlContentProcessor;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.OdrlEntityHandlerException;
import org.w3c.odrl.W3COdrl2.parsers.json.IOdrlJsonContentProcessor;
import org.w3c.odrl.W3COdrl2.parsers.json.JsonProperty;
import org.w3c.odrl.W3COdrl2.vocabulary.ConstraintName;
import org.w3c.odrl.W3COdrl2.vocabulary.ConstraintOperator;

import com.ghotibown.json.JSONArray;
import com.ghotibown.json.JSONObject;
import com.ghotibown.json.JSONValue;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 10, 2014
 *
 */
public class DefaultJsonConstraintEntityHandler extends AbstractJsonEntityHandler<JSONObject> {


    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.parsers.entityhandlers.json.AbstractJsonEntityHandler#getEntityNames()
     */
    @Override
    public List<String> getEntityNames() {
        final ArrayList<String> entityNames = new ArrayList<String>();
        entityNames.add("constraints");
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
    public IOdrlElementBase handleEntity(final JsonProperty entityData, final JSONObject dataDocument, final IOdrlDocument document, final IOdrlElement<?> parent,
                    final IOdrlContentProcessor<String, JSONObject> processor) throws OdrlEntityHandlerException {

        final JSONArray constraintArray = entityData.getValue();
        
        for (final JSONValue<?> cItem : constraintArray) {
            final JSONObject constraintObject = (JSONObject) cItem.getValue();
            
            final IOdrlConstraint constraint = document.createConstraint(null, null, null);
            

            for (final String key : constraintObject.keys()) {
                try {
                    if (key.equals("id")) {
                        constraint.setId(new XsToken(constraintObject.getString(key)));;
                    } else if (key.equals("name")) {
                        constraint.setConstraintName(ConstraintName.valueOf(constraintObject.getString(key)));
                    } else if (key.equals("operator")) {
                        constraint.setOperator(ConstraintOperator.valueOf(constraintObject.getString(key)));
                    } else if (key.equals("rightOperand")) {
                        String dataTypeValue = null;
                        if (constraintObject.containsKey("dataType")) {
                            dataTypeValue = constraintObject.getString("dataType");
                            constraint.setDataType(URIQNameQCode.newURIQNameQCode(dataTypeValue));
                        }

                        XmlDataType dt = null;
                        if (dataTypeValue != null) {
                            dt = XmlDataType.find(dataTypeValue);
                        }
                        final ListOfValues<?> values = ListOfValues.newListOfValues(constraintObject.getString(key), dt);
                        constraint.setRightOperand(values);

                    } else if (key.equals("dataType")) {
                        // already handled with rightOperand
                    } else if (key.equals("unit")) {
                        constraint.setUnit(URIQNameQCode.newURIQNameQCode(constraintObject.getString(key)));
                    } else {
                        final JsonProperty prop = new JsonProperty(key, constraintObject.get(key).getValue(), entityData.getKey());
                        ((IOdrlJsonContentProcessor<String, JSONObject>) processor).handleJsonProperty(prop, dataDocument, document,
                                        constraint);
                    }
                } catch (final Exception e) {
                    throw new OdrlEntityHandlerException(e);
                }
            }
            
            parent.appendElement(constraint);

        }
        return null;
    }

}
