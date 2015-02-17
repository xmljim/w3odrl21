/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlParty;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;
import org.w3c.odrl.W3COdrl2.vocabulary.FunctionType;
import org.w3c.odrl.W3COdrl2.vocabulary.ScopeType;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
class OdrlPartyImpl extends AbstractOdrlElementUUIDAndId<IOdrlParty> implements IOdrlParty {

    /**
     * @param qName
     * @param ownerDocument
     */
    public OdrlPartyImpl(final IOdrlDocument ownerDocument, final URIQNameQCode uuid, final FunctionType function) {
        super(OdrlQNames.PARTY_ELEMENT, ownerDocument);
        setFunction(function);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlParty#getFunctionType()
     */
    public FunctionType getFunction() {
        final IOdrlAttribute<FunctionType> attr = getAttribute(OdrlQNames.FUNCTION_ATTR);
        return attr.getValue();
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlParty#getScope()
     */
    public ScopeType getScope() {
        final IOdrlAttribute<ScopeType> attr = getAttribute(OdrlQNames.SCOPE_ATTR);
        return attr.getValue();
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlParty#setFunction(org.w3c.odrl.v21.vocabulary.FunctionType)
     */
    public void setFunction(final FunctionType function) {
        setAttribute(OdrlQNames.FUNCTION_ATTR, function);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlParty#setScope(org.w3c.odrl.v21.vocabulary.ScopeType)
     */
    public void setScope(final ScopeType scope) {
        setAttribute(OdrlQNames.SCOPE_ATTR, scope);
    }

}
