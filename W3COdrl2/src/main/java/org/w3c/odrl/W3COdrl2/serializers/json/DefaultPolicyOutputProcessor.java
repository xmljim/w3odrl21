/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers.json;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.AttributeList;
import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.IOdrlPolicy;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;
import org.w3c.odrl.W3COdrl2.serializers.AbstractOdrlEntityOutputProcessor;
import org.w3c.odrl.W3COdrl2.serializers.IOdrlEntityOutputProcessor;
import org.w3c.odrl.W3COdrl2.serializers.IOdrlUnmarshaller;

import com.ghotibown.json.JSONObject;

/**
 * @author Jim Earley <xml.jim@gmail.com> Feb 15, 2015
 *
 */
public class DefaultPolicyOutputProcessor extends AbstractOdrlEntityOutputProcessor<JSONObject, JSONObject> {

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.serializers.AbstractOdrlEntityOutputProcessor#getEntityName()
     */
    @Override
    public QName getEntityName() {
        return OdrlQNames.POLICY_ELEMENT;
    }


    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.serializers.AbstractOdrlEntityOutputProcessor#processEntityToOutput(org.w3c.odrl.v21.model.IOdrlElement,
     * java.lang.Object, org.w3c.odrl.v21.serializers.IOdrlUnmarshaller)
     */
    @Override
    public void processEntityToOutput(final IOdrlElementBase entity, final JSONObject outputEntity,
                    final IOdrlUnmarshaller<JSONObject> unmarshaller) {
        final IOdrlPolicy policy = (IOdrlPolicy)entity;
        
        final AttributeList attrs = policy.getAttributes();

        for (final IOdrlAttribute<?> att : attrs.items()) {
            DefaultJsonAttributeUtils.writeAttribute(att, outputEntity);
        }
        
        for (final IOdrlElementBase elem : policy.getChildren()) {
            final IOdrlEntityOutputProcessor<JSONObject, JSONObject> elemProc = unmarshaller.getOutputProcessor(elem.getName());
            if (elemProc != null) {
                elemProc.processEntityToOutput(elem, outputEntity, unmarshaller);
            }
        }

    }



}
