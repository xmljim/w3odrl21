/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers.json;

import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;

import com.ghotibown.json.JSONObject;
import com.ghotibown.json.exception.JSONInvalidValueTypeException;

/**
 * @author Jim Earley <xml.jim@gmail.com> Feb 15, 2015
 *
 */
class DefaultJsonAttributeUtils extends JsonAttributeUtils {

    public static void writeAttribute(final IOdrlAttribute<?> attribute, final JSONObject outputEntity) {
        try {

            outputEntity.put(getName(attribute), getAttributeValue(attribute));
        } catch (final JSONInvalidValueTypeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
