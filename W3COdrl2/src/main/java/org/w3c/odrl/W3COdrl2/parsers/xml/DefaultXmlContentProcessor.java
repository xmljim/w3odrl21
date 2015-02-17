/**
 * 
 */
package org.w3c.odrl.W3COdrl2.parsers.xml;

import org.w3c.odrl.W3COdrl2.parsers.IOdrlParser;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.xml.DefaultXmlActionHandler;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.xml.DefaultXmlAssetHandler;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.xml.DefaultXmlConstraintHandler;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.xml.DefaultXmlPartyHandler;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.xml.DefaultXmlPolicyHandler;
import org.w3c.odrl.W3COdrl2.parsers.entityhandlers.xml.DefaultXmlRuleHandler;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 5, 2014
 *
 */
public class DefaultXmlContentProcessor extends AbstractXmlContentProcessor {

    /**
     * 
     */
    public DefaultXmlContentProcessor(final IOdrlParser parser) {
        super(parser);
        registerEntityProcessor(new DefaultXmlPolicyHandler());
        registerEntityProcessor(new DefaultXmlActionHandler());
        registerEntityProcessor(new DefaultXmlAssetHandler());
        registerEntityProcessor(new DefaultXmlConstraintHandler());
        registerEntityProcessor(new DefaultXmlPartyHandler());
        registerEntityProcessor(new DefaultXmlRuleHandler());

    }


}
