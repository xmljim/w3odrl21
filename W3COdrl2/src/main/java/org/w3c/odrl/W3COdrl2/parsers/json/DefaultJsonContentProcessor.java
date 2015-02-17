/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.json;

import org.w3c.odrl.W3COdrl2.factory.PolicyFactory;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlParser;
import org.w3c.odrl.W3COdrl2.parsers.OdrlContentProcessorException;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.OdrlEntityHandlerException;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.json.DefaultJsonActionEntityHandler;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.json.DefaultJsonAssetsEntityHandler;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.json.DefaultJsonConstraintEntityHandler;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.json.DefaultJsonDutiesEntityHandler;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.json.DefaultJsonPartiesEntityHandler;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.json.DefaultJsonPermissionsEntityHandler;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.json.DefaultJsonPolicyEntityHandler;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.json.DefaultJsonProhibitionsEntityHandler;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.json.IOdrlJsonEntityHandler;

import com.ghotibown.json.JSONObject;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 10, 2014
 *
 */
public class DefaultJsonContentProcessor extends AbstractJsonContentProcessor<JSONObject> {

    public DefaultJsonContentProcessor(final IOdrlParser parser) {
        super(parser);
        registerEntityProcessor(new DefaultJsonActionEntityHandler());
        registerEntityProcessor(new DefaultJsonAssetsEntityHandler());
        registerEntityProcessor(new DefaultJsonConstraintEntityHandler());
        registerEntityProcessor(new DefaultJsonDutiesEntityHandler());
        registerEntityProcessor(new DefaultJsonPartiesEntityHandler());
        registerEntityProcessor(new DefaultJsonPermissionsEntityHandler());
        registerEntityProcessor(new DefaultJsonPolicyEntityHandler());
        registerEntityProcessor(new DefaultJsonProhibitionsEntityHandler());

    }

    private IOdrlDocument newDocument() {
        return PolicyFactory.newPolicyFactory().newPolicyBuilder().newDocument();
    }
    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.parsers.AbstractContentProcessor#processData(java.lang.Object)
     */
    @Override
    public IOdrlDocument processData(final JSONObject dataDocument) throws OdrlContentProcessorException {
        final IOdrlDocument document = newDocument();
        final JsonProperty prop = new JsonProperty("Policy", dataDocument);
        handleJsonProperty(prop, dataDocument, document, null);
        return document;
    }





    @SuppressWarnings("unchecked")
    public IOdrlElementBase handleJsonProperty(final JsonProperty property, final JSONObject dataDocument, final IOdrlDocument document,
                    final IOdrlElementBase parent) throws OdrlContentProcessorException {

        final IOdrlJsonEntityHandler<String, JSONObject> entityHandler = (IOdrlJsonEntityHandler<String, JSONObject>) getEntityHandler(property
                        .getKey());

        try {
            if (entityHandler != null) {
                final IOdrlElementBase result = entityHandler
                                .handleEntity(property, dataDocument, document, (IOdrlElement<?>) parent, this);
                return result;
            } else {

                throw new OdrlContentProcessorException("Invalid JSON Key Value: [" + property.getKey() + "] is not defined object type ["
                                + property.getParentKey() + "]. Entity Handler Not Registered");

            }
        } catch (final OdrlEntityHandlerException e) {
            throw new OdrlContentProcessorException(e);
        }

    }



}
