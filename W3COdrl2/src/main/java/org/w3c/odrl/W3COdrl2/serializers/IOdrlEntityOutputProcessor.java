/**
 * 
 */
package org.w3c.odrl.W3COdrl2.serializers;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;

/**
 * @author Jim Earley <xml.jim@gmail.com> Feb 15, 2015
 *
 */
public interface IOdrlEntityOutputProcessor<O, T> {
    
    QName getEntityName();

    void processEntityToOutput(IOdrlElementBase entity, O outputEntity, IOdrlUnmarshaller<T> unmarshaller);

}
