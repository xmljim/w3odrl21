/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
public abstract class PolicyFactory {

    /**
     * 
     */
    public PolicyFactory() {
        // TODO Auto-generated constructor stub
    }

    public static PolicyFactory newPolicyFactory() {
        return new PolicyFactoryImpl();
    }
    
    public abstract PolicyBuilder newPolicyBuilder();
}
