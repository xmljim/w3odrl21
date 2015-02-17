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
public abstract class AbstractOdrlEntityOutputProcessor<O, T> implements IOdrlEntityOutputProcessor<O, T> {

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.IOdrlEntityOutputProcessor#getEntityName()
     */
    public abstract QName getEntityName();



    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.serializers.IOdrlEntityOutputProcessor#processEntityToOutput(org.w3c.odrl.v21.model.IOdrlElement, java.lang.Object, org.w3c.odrl.v21.serializers.IOdrlSerializer)
     */
    public abstract void processEntityToOutput(IOdrlElementBase entity, O outputEntity, IOdrlUnmarshaller<T> unmarshaller);


}
