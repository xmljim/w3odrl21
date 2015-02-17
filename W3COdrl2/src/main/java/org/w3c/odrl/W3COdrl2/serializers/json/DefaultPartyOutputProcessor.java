/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers.json;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.IOdrlParty;
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
class DefaultPartyOutputProcessor extends AbstractOdrlEntityOutputProcessor<JSONObject, JSONObject> {

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.serializers.AbstractOdrlEntityOutputProcessor#getEntityName()
     */
    @Override
    public QName getEntityName() {
        return OdrlQNames.PARTY_ELEMENT;
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
        final IOdrlParty party = (IOdrlParty) entity;
        final JSONArray partyArray = getPartyArray(outputEntity);
        final JSONObject partyObject = NodeFactory.newJSONObject();

        for (final IOdrlAttribute<?> att : party.getAttributes()) {
            DefaultJsonAttributeUtils.writeAttribute(att, partyObject);
        }

        partyArray.add(partyObject);

    }

    private JSONArray getPartyArray(final JSONObject outputEntity) {
        JSONArray partyArray = null;
        if (outputEntity.containsKey("parties")) {
            try {
                partyArray = outputEntity.getJSONArray("parties");
            } catch (final JSONInvalidValueTypeException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            partyArray = NodeFactory.newJSONArray();
            outputEntity.put("parties", partyArray);
        }

        return partyArray;
    }

}
