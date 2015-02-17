/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.model.ElementList;
import org.w3c.odrl.W3COdrl2.model.IOdrlAction;
import org.w3c.odrl.W3COdrl2.model.IOdrlAsset;
import org.w3c.odrl.W3COdrl2.model.IOdrlConstraint;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementReference;
import org.w3c.odrl.W3COdrl2.model.IOdrlParty;
import org.w3c.odrl.W3COdrl2.model.IOdrlRule;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
abstract class AbstractOdrlRule<T> extends AbstractOdrlElementId<T> implements IOdrlRule<T> {
    private IOdrlAction action;

    /**
     * @param qName
     * @param ownerDocument
     */
    public AbstractOdrlRule(final QName qName, final IOdrlDocument ownerDocument) {
        super(qName, ownerDocument);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlRule#addConstraint(org.w3c.odrl.v21.model.IOdrlConstraint)
     */
    
    public void addConstraint(final IOdrlConstraint constraint) {
        appendElement(constraint);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlRule#getConstraints()
     */

    
    public ElementList<IOdrlConstraint> getConstraints() {
        final ElementListImpl<IOdrlConstraint> constraints = new ElementListImpl<IOdrlConstraint>();
        for (final IOdrlElementBase b : getChildren()) {
            if (b instanceof IOdrlConstraint) {
                constraints.addNamedItem((IOdrlConstraint) b);
            }
        }

        return constraints;
    }

    @SuppressWarnings("unchecked")
    public ElementList<IOdrlElementReference<IOdrlConstraint>> getConstraintReferences() {
        final ElementListImpl<IOdrlElementReference<IOdrlConstraint>> constraintRefs = new ElementListImpl<IOdrlElementReference<IOdrlConstraint>>();
        for (final IOdrlElementBase b : getChildren()) {
            if (b instanceof IOdrlElementReference && ((IOdrlElementReference<?>) b).getReferenceTarget() instanceof IOdrlConstraint) {
                constraintRefs.addNamedItem((IOdrlElementReference<IOdrlConstraint>) b);
            }
        }
        return constraintRefs;
    }

    @SuppressWarnings("unchecked")
    public ElementList<IOdrlElementReference<IOdrlAsset>> getAssetReferences() {
        final ElementListImpl<IOdrlElementReference<IOdrlAsset>> assetRefs = new ElementListImpl<IOdrlElementReference<IOdrlAsset>>();
        for (final IOdrlElementBase b : getChildren()) {
            if (b instanceof IOdrlElementReference && ((IOdrlElementReference<?>) b).getReferenceTarget() instanceof IOdrlAsset) {
                assetRefs.addNamedItem((IOdrlElementReference<IOdrlAsset>) b);
            }
        }
        return assetRefs;
    }

    @SuppressWarnings("unchecked")
    public ElementList<IOdrlElementReference<IOdrlParty>> getPartyReferences() {
        final ElementListImpl<IOdrlElementReference<IOdrlParty>> partyRefs = new ElementListImpl<IOdrlElementReference<IOdrlParty>>();
        for (final IOdrlElementBase b : getChildren()) {
            if (b instanceof IOdrlElementReference && ((IOdrlElementReference<?>) b).getReferenceTarget() instanceof IOdrlParty) {
                partyRefs.addNamedItem((IOdrlElementReference<IOdrlParty>) b);
            }
        }
        return partyRefs;
    }


    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlRule#removeConstraint(org.w3c.odrl.v21.model.IOdrlConstraint)
     */
    public void removeConstraint(final IOdrlConstraint constraint) {
        this.children.removeItem(constraint);

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlRule#addAsset(org.w3c.odrl.v21.model.IOdrlAsset)
     */
    public void addAsset(final IOdrlAsset asset) {
        appendElement(asset);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlRule#getAssets()
     */
    public ElementList<IOdrlAsset> getAssets() {
        final ElementListImpl<IOdrlAsset> constraints = new ElementListImpl<IOdrlAsset>();
        for (final IOdrlElementBase b : getChildren()) {
            if (b instanceof IOdrlAsset) {
                constraints.addNamedItem((IOdrlAsset) b);
            }
        }

        return constraints;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlRule#removeAsset(org.w3c.odrl.v21.model.IOdrlAsset)
     */
    public IOdrlAsset removeAsset(final IOdrlAsset asset) {
        this.children.removeItem(asset);
        return asset;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlRule#setAction(org.w3c.odrl.v21.model.IOdrlAction)
     */
    public void setAction(final IOdrlAction action) {
        if (this.action != null) {
            removeElement(action);
        }

        appendElement(action);
        this.action = action;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlRule#getAction()
     */
    public IOdrlAction getAction() {
        return this.action;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlRule#addParty(org.w3c.odrl.v21.model.IOdrlParty)
     */
    public void addParty(final IOdrlParty party) {
        appendElement(party);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlRule#getParties()
     */
    public ElementList<IOdrlParty> getParties() {
        final ElementListImpl<IOdrlParty> parties = new ElementListImpl<IOdrlParty>();
        for (final IOdrlElementBase b : getChildren()) {
            if (b instanceof IOdrlParty) {
                parties.addNamedItem((IOdrlParty) b);
            }
        }

        return parties;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlRule#removeParty(org.w3c.odrl.v21.model.IOdrlParty)
     */
    public IOdrlParty removeParty(final IOdrlParty party) {
        this.children.removeItem(party);
        return party;
    }



}
