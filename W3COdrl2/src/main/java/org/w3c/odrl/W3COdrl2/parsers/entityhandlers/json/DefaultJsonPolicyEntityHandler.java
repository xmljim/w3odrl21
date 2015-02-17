/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.entityhandlers.json;

import java.util.ArrayList;
import java.util.List;

import org.w3c.odrl.W3COdrl2.datatypes.ConflictTerm;
import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.datatypes.UndefinedTerm;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.IOdrlPolicy;
import org.w3c.odrl.W3COdrl2.parsers.IOdrlContentProcessor;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.OdrlEntityHandlerException;
import org.w3c.odrl.W3COdrl2.parsers.json.IOdrlJsonContentProcessor;
import org.w3c.odrl.W3COdrl2.parsers.json.JsonProperty;
import org.w3c.odrl.W3COdrl2.vocabulary.PolicyType;

import com.ghotibown.json.JSONObject;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
public class DefaultJsonPolicyEntityHandler extends AbstractJsonEntityHandler<JSONObject> {

    /**
     * 
     */
    public DefaultJsonPolicyEntityHandler() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.parsers.IOdrlEntityHandler#getEntityNames()
     */
    @Override
    public List<String> getEntityNames() {
        final ArrayList<String> entityNames = new ArrayList<String>();
        entityNames.add("policyType");
        entityNames.add("policyId");
        entityNames.add("conflict");
        entityNames.add("undefined");
        entityNames.add("inheritFrom");
        entityNames.add("inheritRelation");
        entityNames.add("Policy");
        return entityNames;

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.parsers.AbstractJsonEntityHandler#handleEntity(org.w3c.odrl.v21.parsers.JsonProperty, java.lang.Object,
     * org.w3c.odrl.v21.model.IOdrlDocument, org.w3c.odrl.v21.model.IOdrlElement, org.w3c.odrl.v21.parsers.IOdrlContentProcessor)
     */
    @Override
    public IOdrlElementBase handleEntity(final JsonProperty entityData, final JSONObject dataDocument,
 final IOdrlDocument document,
                    final IOdrlElement<?> parent, final IOdrlContentProcessor<String, JSONObject> processor)
                    throws OdrlEntityHandlerException {
        IOdrlPolicy policy = null;

        if (parent == null) {
            if (document.getPolicy() == null) {
                policy = document.createPolicy(null, null);
                document.setPolicy(policy);
            } else {
                policy = document.getPolicy();
            }
        } else {
            policy = (IOdrlPolicy) parent;
        }

        for (final String key : dataDocument.keys()) {
            try {
                if (key.equals("policyId")) {
                    final String value = dataDocument.getString(key);
                    policy.setUUID(URIQNameQCode.newURIQNameQCode(value));

                } else if (key.equals("policyType")) {
                    final String value = dataDocument.getString(key);
                    policy.setType(PolicyType.valueOf(value));

                } else if (key.equals("conflict")) {
                    final String value = dataDocument.getString(key);
                    policy.setConflict(ConflictTerm.find(value));

                } else if (key.equals("undefined")) {
                    final String value = dataDocument.getString(key);
                    policy.setUndefined(UndefinedTerm.find(value));

                } else if (key.equals("inheritFrom")) {
                    final String value = dataDocument.getString(key);
                    policy.setInheritFrom(URIQNameQCode.newURIQNameQCode(value));

                } else if (key.equals("inheritRelation")) {
                    final String value = dataDocument.getString(key);
                    policy.setInheritRelation(URIQNameQCode.newURIQNameQCode(value));

                } else if (key.equals("inheritAllowed")) {
                    final boolean value = dataDocument.getBoolean(key);
                    policy.setInheritAllowed(value);
                } else if (key.equals("Policy")) {

                } else {
                    final JsonProperty prop = new JsonProperty(key, dataDocument.get(key).getValue(), entityData.getKey());
                    ((IOdrlJsonContentProcessor<String, JSONObject>) processor).handleJsonProperty(prop, dataDocument, document, policy);
                }
            } catch (final Exception e) {
                throw new OdrlEntityHandlerException(e);
            }


        }



        return policy;
    }




}
