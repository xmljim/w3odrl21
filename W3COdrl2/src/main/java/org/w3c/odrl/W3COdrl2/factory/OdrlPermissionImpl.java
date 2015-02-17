/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import org.w3c.odrl.W3COdrl2.model.ElementList;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlDuty;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementReference;
import org.w3c.odrl.W3COdrl2.model.IOdrlPermission;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
class OdrlPermissionImpl extends AbstractOdrlRule<IOdrlPermission> implements IOdrlPermission {

    /**
     * @param qName
     * @param ownerDocument
     */
    public OdrlPermissionImpl(final IOdrlDocument ownerDocument) {
        super(OdrlQNames.PERMISSION_ELEMENT, ownerDocument);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPermission#addDuty(org.w3c.odrl.v21.model.IOdrlDuty)
     */
    public void addDuty(final IOdrlDuty duty) {
        appendElement(duty);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPermission#getDuties()
     */
    public ElementList<IOdrlDuty> getDuties() {
        final ElementListImpl<IOdrlDuty> duties = new ElementListImpl<IOdrlDuty>();
        for (final IOdrlElementBase duty : getChildren()) {
            if (duty instanceof IOdrlDuty) {
                duties.addNamedItem((IOdrlDuty) duty);
            }
        }

        return duties;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.model.IOdrlPermission#removeDuty()
     */
    public IOdrlDuty removeDuty(final IOdrlDuty duty) {
        removeElement(duty);
        return duty;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.model.IOdrlPermission#getDutyReferences()
     */
    @SuppressWarnings("unchecked")
    public ElementList<IOdrlElementReference<IOdrlDuty>> getDutyReferences() {
        final ElementListImpl<IOdrlElementReference<IOdrlDuty>> dutyRefs = new ElementListImpl<IOdrlElementReference<IOdrlDuty>>();

        for (final IOdrlElementBase duty : getChildren()) {
            if (duty instanceof IOdrlElementReference && ((IOdrlElementReference<?>) duty).getReferenceTarget() instanceof IOdrlDuty) {
                dutyRefs.addNamedItem((IOdrlElementReference<IOdrlDuty>) duty);
            }
        }
        return dutyRefs;
    }



}
