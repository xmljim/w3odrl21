/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers.json;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlConstraint;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;
import org.w3c.odrl.W3COdrl2.serializers.AbstractOdrlEntityOutputProcessor;
import org.w3c.odrl.W3COdrl2.serializers.IOdrlUnmarshaller;

import com.ghotibown.json.JSONArray;
import com.ghotibown.json.JSONObject;
import com.ghotibown.json.exception.JSONInvalidValueTypeException;
import com.ghotibown.json.factory.NodeFactory;

/**
 * @author Jim Earley <xml.jim@gmail.com> Feb 15, 2015
 *
 */
public class DefaultConstraintOutputProcessor extends AbstractOdrlEntityOutputProcessor<JSONObject, JSONObject> {

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.serializers.AbstractOdrlEntityOutputProcessor#getEntityName()
     */
    @Override
    public QName getEntityName() {
        // TODO Auto-generated method stub
        return OdrlQNames.CONSTRAINT_ELEMENT;
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

        final IOdrlConstraint constraint = (IOdrlConstraint) entity;
        final JSONArray constraintArray = getConstraintsArray(outputEntity);
        final JSONObject constraintObject = NodeFactory.newJSONObject();

        for (final IOdrlAttribute<?> att : constraint.getAttributes()) {
            DefaultJsonAttributeUtils.writeAttribute(att, constraintObject);
        }

        constraintArray.add(constraintObject);
    }

    private JSONArray getConstraintsArray(final JSONObject outputEntity) {
        JSONArray constraintArray = null;
        if (outputEntity.containsKey("constraints")) {
            try {
                constraintArray = outputEntity.getJSONArray("constraints");
            } catch (final JSONInvalidValueTypeException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            constraintArray = NodeFactory.newJSONArray();
            outputEntity.put("constraints", constraintArray);;
        }

        return constraintArray;

    }

}
