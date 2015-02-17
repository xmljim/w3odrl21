/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.datatypes.XsToken;
import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementId;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
abstract class AbstractOdrlElementId<T> extends AbstractOdrlElement<T> implements IOdrlElementId<T> {

    /**
     * @param qName
     * @param ownerDocument
     */
    public AbstractOdrlElementId(final QName qName, final IOdrlDocument ownerDocument) {
        super(qName, ownerDocument);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElementId#setId(org.w3c.odrl.v21.datatypes.XsToken)
     */
    
    public void setId(final XsToken id) {

        final IOdrlAttribute<XsToken> idAtt = getOwnerDocument().createAttribute(OdrlQNames.ID_ATTR, id);
        setAttribute(idAtt);

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElementId#getId()
     */
    
    public XsToken getId() {
        final IOdrlAttribute<XsToken> idAtt = getAttribute(OdrlQNames.ID_ATTR);
        return idAtt.getValue();
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElementId#setIdRef(org.w3c.odrl.v21.datatypes.XsToken)
     */
    
    public void setIdRef(final XsToken idref) {
        final IOdrlAttribute<XsToken> idAtt = getOwnerDocument().createAttribute(OdrlQNames.IDREF_ATTR, idref);
        setAttribute(idAtt);

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlElementId#getIdRef()
     */
    
    public XsToken getIdRef() {
        final IOdrlAttribute<XsToken> idrefAtt = getAttribute(OdrlQNames.IDREF_ATTR);
        return idrefAtt.getValue();
    }



}
