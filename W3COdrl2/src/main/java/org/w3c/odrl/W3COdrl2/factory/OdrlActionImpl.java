/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import org.w3c.odrl.W3COdrl2.model.IOdrlAction;
import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;
import org.w3c.odrl.W3COdrl2.vocabulary.ActionName;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
class OdrlActionImpl extends AbstractOdrlElementId<IOdrlAction> implements IOdrlAction {


    public OdrlActionImpl(final IOdrlDocument ownerDoc, final ActionName name) {
        super(OdrlQNames.ACTION_ELEMENT, ownerDoc);
        setActionName(name);
    }
    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlAction#setActionName(org.w3c.odrl.v21.vocabulary.ActionName)
     */
    public void setActionName(final ActionName name) {
        setAttribute(OdrlQNames.ACTION_NAME_ATTR, name);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlAction#getActionName()
     */
    public ActionName getActionName() {
        final IOdrlAttribute<ActionName> attr = getAttribute(OdrlQNames.ACTION_NAME_ATTR);
        return attr.getValue();
    }

}
