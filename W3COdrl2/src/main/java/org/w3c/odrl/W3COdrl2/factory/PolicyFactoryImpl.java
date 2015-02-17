/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
class PolicyFactoryImpl extends PolicyFactory {

    /**
     * 
     */
    public PolicyFactoryImpl() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.factory.PolicyFactory#newPolicyBuilder()
     */
    @Override
    public PolicyBuilder newPolicyBuilder() {
        return new PolicyBuilderImpl();
    }

}
