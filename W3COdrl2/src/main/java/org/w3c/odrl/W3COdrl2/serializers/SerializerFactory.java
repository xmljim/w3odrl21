/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers;

import org.w3c.odrl.W3COdrl2.serializers.json.AbstractOdrlJsonSerializer;
import org.w3c.odrl.W3COdrl2.serializers.json.IOdrlJsonSerializer;
import org.w3c.odrl.W3COdrl2.serializers.xml.AbstractOdrlXmlSerializer;
import org.w3c.odrl.W3COdrl2.serializers.xml.IOdrlXmlSerializer;

/**
 * @author Jim Earley <xml.jim@gmail.com> Feb 15, 2015
 *
 */
public abstract class SerializerFactory {

    private SerializerFactory() {

    }

    public static IOdrlJsonSerializer newJsonSerializer() {
        return AbstractOdrlJsonSerializer.newJsonSerializer();
    }

    public static IOdrlXmlSerializer newXmlSerializer() {
        return AbstractOdrlXmlSerializer.newXmlSerializer();
    }
}
