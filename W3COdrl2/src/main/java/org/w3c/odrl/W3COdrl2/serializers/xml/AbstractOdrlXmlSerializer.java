/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers.xml;

import java.util.HashMap;
import java.util.Map;

import org.w3c.odrl.W3COdrl2.serializers.AbstractOdrlSerializer;

/**
 * @author Jim Earley <xml.jim@gmail.com> Feb 16, 2015
 *
 */
public abstract class AbstractOdrlXmlSerializer extends AbstractOdrlSerializer implements IOdrlXmlSerializer {

    public static IOdrlXmlSerializer newXmlSerializer() {
        return new DefaultOdrlXmlSerializer();
    }

    public static IOdrlXmlUnmarshaller newXmlUnmarshaller() {
        return new DefaultXmlUnmarshaller();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.serializers.xml.IOdrlXmlSerializer#setNamespacePrefix(java.lang.String, java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public void setNamespacePrefix(final String namespaceUri, final String prefix) {
        Map<String, String> nsMap = null;
        if (hasProperty(IOdrlXmlSerializer.NS_MAP_PROP)) {
            nsMap = (Map<String, String>) getProperty(IOdrlXmlSerializer.NS_MAP_PROP);
        } else {
            nsMap = new HashMap<String, String>();
        }

        nsMap.put(namespaceUri, prefix);

        setProperty(IOdrlXmlSerializer.NS_MAP_PROP, nsMap);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.serializers.xml.IOdrlXmlSerializer#getNamespacePrefix(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public String getNamespacePrefix(final String namespaceUri) {
        String prefix = null;

        Map<String, String> nsMap = null;
        if (hasProperty(IOdrlXmlSerializer.NS_MAP_PROP)) {
            nsMap = (Map<String, String>) getProperty(IOdrlXmlSerializer.NS_MAP_PROP);
            if (nsMap.containsKey(namespaceUri)) {
                prefix = nsMap.get(namespaceUri);
            }
        }

        return prefix;

    }


}
