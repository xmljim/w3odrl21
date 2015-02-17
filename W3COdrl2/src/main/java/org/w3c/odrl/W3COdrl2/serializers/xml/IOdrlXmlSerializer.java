/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers.xml;

import java.util.Map;

import org.w3c.odrl.W3COdrl2.serializers.IOdrlSerializer;

/**
 * Interface for XML Serialization of ODRL instances. The following properties must be defined for all XML serializers:
 * 
 * <table border=1>
 * <tr>
 * <th>Property Name</th>
 * <th>Property Value Type</th>
 * <th>Description</th>
 * </tr>
 * <tr>
 * <td><code>org.w3c.odrl.v21.serializer.xml.namespacemap</code></th>
 * <td>{@link Map}</td>
 * <td>Contains a mapping of namespace URIs to namespace prefixes to use in the serialization process</td>
 * </tr>
 * </table>
 * 
 * @author Jim Earley <xml.jim@gmail.com> Feb 15, 2015
 *
 */
public interface IOdrlXmlSerializer extends IOdrlSerializer {
    /**
     * Convenience constant to access namespace map
     */
    public static final String NS_MAP_PROP = "org.w3c.odrl.v21.serializer.xml.namespacemap";

    /**
     * Convenience method setting a mapping between a namespace URI and prefix
     * 
     * @param namespaceUri
     *            the namespace uri
     * @param prefix
     *            the namespace prefix
     */
    void setNamespacePrefix(String namespaceUri, String prefix);

    /**
     * Convenience method for accessing a namespace prefix for a given namespace URI
     * 
     * @param namespaceUri
     *            the namespace URI
     * @return the string prefix for the given Namespace URI, or null if not defined
     */
    String getNamespacePrefix(String namespaceUri);

}
