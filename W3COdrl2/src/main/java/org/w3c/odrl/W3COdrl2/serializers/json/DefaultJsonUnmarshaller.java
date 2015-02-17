/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers.json;

import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.serializers.AbstractOdrlUnmarshaller;
import org.w3c.odrl.W3COdrl2.serializers.IOdrlEntityOutputProcessor;
import org.w3c.odrl.W3COdrl2.serializers.IOdrlSerializer;

import com.ghotibown.json.JSONFactory;
import com.ghotibown.json.JSONObject;

/**
 * @author Jim Earley <xml.jim@gmail.com> Feb 15, 2015
 *
 */
class DefaultJsonUnmarshaller extends AbstractOdrlUnmarshaller<JSONObject> implements IOdrlJsonUnmarshaller<JSONObject> {
    private JSONObject result = null;

    public DefaultJsonUnmarshaller() {
        this.result = JSONFactory.newFactory().newParser().newJSONObject();
        registerOutputProcessor(new DefaultPolicyOutputProcessor());
        registerOutputProcessor(new DefaultPermissionOutputProcessor());
        registerOutputProcessor(new DefaultProhibitionOutputProcessor());
        registerOutputProcessor(new DefaultAssetOutputProcessor());
        registerOutputProcessor(new DefaultActionOutputProcessor());
        registerOutputProcessor(new DefaultConstraintOutputProcessor());
        registerOutputProcessor(new DefaultDutyOutputProcessor());
        registerOutputProcessor(new DefaultPartyOutputProcessor());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.serializers.IOdrlUnmarshaller#unmarshall(org.w3c.odrl.v21.model.IOdrlDocument)
     */
    @Override
    public void unmarshall(final IOdrlDocument document, final IOdrlSerializer serializer) {
        unmarshall(document.getPolicy(), serializer);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.serializers.IOdrlUnmarshaller#unmarshall(org.w3c.odrl.v21.model.IOdrlElement)
     */
    @Override
    public void unmarshall(final IOdrlElement<?> element, final IOdrlSerializer serializer) {
        final IOdrlEntityOutputProcessor<JSONObject, JSONObject> outputProcessor = getOutputProcessor(element.getName());
        outputProcessor.processEntityToOutput(element, this.result, this);
        
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.serializers.IOdrlUnmarshaller#getResult()
     */
    @Override
    public JSONObject getResult() {

        return this.result;
    }


}
