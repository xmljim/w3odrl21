package org.w3c.odrl.W3COdrl2.vocabulary;

import java.util.HashMap;
import java.util.Map;

import org.w3c.odrl.W3COdrl2.datatypes.DataTypeException;
import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;



/**
 * Contains a predefined set of policy types.
 * <p>
 * 	In addition to predefined policy types, additional policy types may be registered by using the 
 * {@link #registerPolicyType(PolicyType)} method to support custom policy type definitions
 * </p>
 * @author jearley
 *
 */
public class PolicyType extends URIQNameQCode {
	
	private static Map<String, PolicyType> policies = new HashMap<String, PolicyType>();
	
	/** Represents an agreement **/
	public static final PolicyType AGREEMENT = PolicyType.newPolicyType(Vocab.createOdrlVocabItem("agreement"));
	
	/** Represents an offer **/
	public static final PolicyType OFFER = PolicyType.newPolicyType(Vocab.createOdrlVocabItem("offer"));
	
	/** Represents a privacy policy **/
	public static final PolicyType PRIVACY = PolicyType.newPolicyType(Vocab.createOdrlVocabItem("privacy"));
	
	/** Represents a request policy **/
	public static final PolicyType REQUEST = PolicyType.newPolicyType(Vocab.createOdrlVocabItem("request"));
	
	/** Represents a set policy **/
	public static final PolicyType SET = PolicyType.newPolicyType(Vocab.createOdrlVocabItem("set"));
	
	/** Represents a ticket **/
	public static final PolicyType TICKET = PolicyType.newPolicyType(Vocab.createOdrlVocabItem("ticket"));
	

	
	static {
		registerPolicyType(AGREEMENT);
		registerPolicyType(OFFER);
		registerPolicyType(PRIVACY);
		registerPolicyType(REQUEST);
		registerPolicyType(SET);
		registerPolicyType(TICKET);
	}
	
	private PolicyType() {
		super();
	}

	/** 
	 * Single Constructor.  Create a new policy type.  Note that this constructor does not register the policy type. 
	 * Instead, it should only be used for "one-off" policy types. Developers should use {@link #registerPolicyType(PolicyType)}
	 * instead
	 * @param val the PolicyType identifier
	 * @throws DataTypeException thrown if the policy type identifer is not a valid {@link URIQNameQCode}
	 */
	public PolicyType(final String val) throws DataTypeException {
	    super(val);
    }
	
	/**
	 * Creates and registers a new policy type
	 * @param uriQnameQcodeValue the policy type identifier
	 * @return the new policy type
	 */
	public static PolicyType newPolicyType(final String uriQnameQcodeValue) {
		final PolicyType pt = new PolicyType();
		pt.setValue(uriQnameQcodeValue);
		if (!isPolicyType(pt)) {
			registerPolicyType(pt);
		}
		return pt;
	}
	
	public static PolicyType newPolicyType(final URIQNameQCode vocabId) {
        return newPolicyType(vocabId.toString());

	}
	
	/**
	 * Registers a new policy type
	 * @param type the policy type
	 */
	public static void registerPolicyType(final PolicyType type) {
		policies.put(type.toString(), type);
	}
	
	/**
	 * Evaluates whether the identifier is a registered policy type. 
	 * @param uriQnameQcode the identifier
	 * @return <code>true</code> if the identifier is registered; <code>false</code> otherwise
	 */
	public static boolean isPolicyType(final URIQNameQCode uriQnameQcode) {
		return policies.containsKey(uriQnameQcode.toString());
	}
	
	/**
	 * Returns all registered policy types. 
	 * @return all registered policy types
	 */
	public static Iterable<PolicyType> getPolicyTypes() {
		return policies.values();
	}

    public static PolicyType valueOf(final String policyTypeString) {
        final PolicyType pt = new PolicyType();
        pt.setValue(policyTypeString);
        return pt;
    }
}
