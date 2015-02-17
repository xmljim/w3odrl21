/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers.json;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlDuty;
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
class DefaultDutyOutputProcessor extends AbstractOdrlEntityOutputProcessor<JSONObject, JSONObject> {
    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.serializers.AbstractOdrlEntityOutputProcessor#getEntityName()
     */
    @Override
    public QName getEntityName() {
        return OdrlQNames.DUTY_ELEMENT;
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

        final IOdrlDuty duty = (IOdrlDuty) entity;
        final JSONArray dutyArray = getProhibitionsArray(outputEntity);
        final JSONObject dutyObject = NodeFactory.newJSONObject();

        for (final IOdrlAttribute<?> att : duty.getAttributes()) {
            DefaultJsonAttributeUtils.writeAttribute(att, dutyObject);
        }

        for (final IOdrlElementBase elem : duty.getChildren()) {
            final IOdrlEntityOutputProcessor<JSONObject, JSONObject> elemProc = unmarshaller.getOutputProcessor(elem.getName());
            if (elemProc != null) {
                elemProc.processEntityToOutput(elem, dutyObject, unmarshaller);
            }
        }

        dutyArray.add(dutyObject);

    }

    private JSONArray getProhibitionsArray(final JSONObject outputEntity) {
        JSONArray permArray = null;
        if (outputEntity.containsKey("duties")) {
            try {
                permArray = outputEntity.getJSONArray("duties");
            } catch (final JSONInvalidValueTypeException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            permArray = NodeFactory.newJSONArray();
            outputEntity.put("duties", permArray);
        }

        return permArray;
    }
}
