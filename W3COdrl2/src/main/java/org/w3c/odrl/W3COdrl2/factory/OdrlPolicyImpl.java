/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import org.w3c.odrl.W3COdrl2.datatypes.ConflictTerm;
import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.datatypes.UndefinedTerm;
import org.w3c.odrl.W3COdrl2.model.ElementList;
import org.w3c.odrl.W3COdrl2.model.IOdrlAsset;
import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.IOdrlElement;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.IOdrlPermission;
import org.w3c.odrl.W3COdrl2.model.IOdrlPolicy;
import org.w3c.odrl.W3COdrl2.model.IOdrlProhibition;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;
import org.w3c.odrl.W3COdrl2.vocabulary.ActionName;
import org.w3c.odrl.W3COdrl2.vocabulary.PolicyType;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
class OdrlPolicyImpl extends AbstractOdrlElementUUID<IOdrlPolicy> implements IOdrlPolicy {

    /**
     * @param qName
     * @param ownerDocument
     */
    public OdrlPolicyImpl(final IOdrlDocument ownerDocument, final URIQNameQCode uuid, final PolicyType type) {
        super(OdrlQNames.POLICY_ELEMENT, ownerDocument);
        setType(type);
        setUUID(uuid);

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#setType(org.w3c.odrl.v21.vocabulary.PolicyType)
     */
    public void setType(final PolicyType policyType) {
        setAttribute(OdrlQNames.TYPE_ATTR, policyType);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#getType()
     */
    public PolicyType getType() {
        final IOdrlAttribute<PolicyType> attr = getAttribute(OdrlQNames.TYPE_ATTR);
        return attr.getValue();
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#setConflict(org.w3c.odrl.v21.datatypes.ConflictTerm)
     */
    public void setConflict(final ConflictTerm conflict) {
        setAttribute(OdrlQNames.CONFLICT_ATTR, conflict);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#getConflict()
     */
    public ConflictTerm getConflict() {
        final IOdrlAttribute<ConflictTerm> attr = getAttribute(OdrlQNames.CONFLICT_ATTR);
        return attr.getValue();
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#setUndefined(org.w3c.odrl.v21.datatypes.UndefinedTerm)
     */
    public void setUndefined(final UndefinedTerm undefined) {
        setAttribute(OdrlQNames.UNDEFINED_ATTR, undefined);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#getUndefined()
     */
    public UndefinedTerm getUndefined() {
        final IOdrlAttribute<UndefinedTerm> attr = getAttribute(OdrlQNames.UNDEFINED_ATTR);
        return attr.getValue();
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#setInheritAllowed(boolean)
     */
    public void setInheritAllowed(final boolean inheritAllowed) {
        setAttribute(OdrlQNames.INHERIT_ALLOWED_ATTR, inheritAllowed);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#getInheritAllowed()
     */
    public boolean getInheritAllowed() {
        final IOdrlAttribute<Boolean> attr = getAttribute(OdrlQNames.INHERIT_ALLOWED_ATTR);
        return attr.getValue().booleanValue();
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#setInheritFrom(org.w3c.odrl.v21.datatypes.URIQNameQCode)
     */
    public void setInheritFrom(final URIQNameQCode inheritFrom) {
        setAttribute(OdrlQNames.INHERIT_FROM_ATTR, inheritFrom);
    }

    public URIQNameQCode getInheritFrom() {
        final IOdrlAttribute<URIQNameQCode> attr = getAttribute(OdrlQNames.INHERIT_FROM_ATTR);
        return attr.getValue();
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#setInheritRelation(org.w3c.odrl.v21.datatypes.URIQNameQCode)
     */
    public void setInheritRelation(final URIQNameQCode inheritRelation) {
        setAttribute(OdrlQNames.INHERIT_RELATION_ATTR, inheritRelation);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#getInheritRelation()
     */
    public URIQNameQCode getInheritRelation() {
        final IOdrlAttribute<URIQNameQCode> attr = getAttribute(OdrlQNames.INHERIT_RELATION_ATTR);
        return attr.getValue();
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#setProfile(org.w3c.odrl.v21.datatypes.URIQNameQCode)
     */
    public void setProfile(final URIQNameQCode profile) {
        setAttribute(OdrlQNames.PROFILE_ATTR, profile);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#getProfile()
     */
    public URIQNameQCode getProfile() {
        final IOdrlAttribute<URIQNameQCode> attr = getAttribute(OdrlQNames.PROFILE_ATTR);
        return attr.getValue();
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#addPermission(org.w3c.odrl.v21.model.IOdrlPermission)
     */
    public void addPermission(final IOdrlPermission permission) {
        appendElement(permission);

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#removePermission(org.w3c.odrl.v21.model.IOdrlPermission)
     */
    public IOdrlPermission removePermission(final IOdrlPermission permission) {
        removeElement(permission);
        return permission;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#getPermissions()
     */
    public ElementList<IOdrlPermission> getPermissions() {
        final ElementListImpl<IOdrlPermission> perms = new ElementListImpl<IOdrlPermission>();
        for (final IOdrlElementBase item : getChildren()) {
            if (item instanceof IOdrlPermission) {
                perms.addNamedItem((IOdrlPermission) item);
            }
        }

        return perms;
    }

    public IOdrlPermission findPermission(final ActionName actionName) {
        IOdrlPermission perm = null;
        for (final IOdrlPermission p : getPermissions()) {
            if (p.getAction().getActionName().equals(actionName)) {
                perm = p;
                break;
            }
        }

        return perm;
    }

    public ElementList<IOdrlPermission> findPermissionsForAsset(final IOdrlAsset asset) {
        final ElementListImpl<IOdrlPermission> permList = new ElementListImpl<IOdrlPermission>();

        for (final IOdrlPermission p : getPermissions()) {
            for (final IOdrlAsset a : p.getAssets()) {
                if (a.getUUID().equals(asset.getUUID())) {
                    permList.addNamedItem(p);
                }
            }
        }
        return permList;
    }

    public boolean assetHasPermission(final IOdrlAsset asset, final ActionName actionName) {
        boolean result = false;

        final IOdrlPermission perm = findPermission(actionName);
        if (perm != null) {
            for (final IOdrlAsset a : perm.getAssets()) {
                if (a.getUUID().equals(asset.getUUID())) {
                    result = true;
                }
            }
        }

        return result;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#addProhibition(org.w3c.odrl.v21.model.IOdrlProhibition)
     */
    public void addProhibition(final IOdrlProhibition prohibition) {
        appendElement(prohibition);

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#removeProhibition(org.w3c.odrl.v21.model.IOdrlProhibition)
     */
    public IOdrlProhibition removeProhibition(final IOdrlProhibition prohibition) {
        removeElement(prohibition);
        return prohibition;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#getProhibitions()
     */
    public ElementList<IOdrlProhibition> getProhibitions() {
        final ElementListImpl<IOdrlProhibition> perms = new ElementListImpl<IOdrlProhibition>();
        for (final IOdrlElementBase item : getChildren()) {
            if (item instanceof IOdrlProhibition) {
                perms.addNamedItem((IOdrlProhibition) item);
            }
        }

        return perms;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.model.IOdrlPolicy#findProhibition(org.w3c.odrl.v21.datatypes.ActionName)
     */
    public IOdrlProhibition findProhibition(final ActionName actionName) {
        IOdrlProhibition prohibit = null;
        for (final IOdrlProhibition p : getProhibitions()) {
            if (p.getAction().getActionName().equals(actionName)) {
                prohibit = p;
            }
        }

        return prohibit;
    }

    public ElementList<IOdrlProhibition> findProhibitionsForAsset(final IOdrlAsset asset) {
        final ElementListImpl<IOdrlProhibition> prohibitions = new ElementListImpl<IOdrlProhibition>();
        for (final IOdrlProhibition p : getProhibitions()) {
            for (final IOdrlAsset a : p.getAssets()) {
                if (a.getUUID().equals(asset.getUUID())) {
                    prohibitions.addNamedItem(p);
                }
            }
        }

        return prohibitions;
    }

    public boolean assetHasProhibition(final IOdrlAsset asset, final ActionName actionName) {
        boolean result = false;
        final IOdrlProhibition p = findProhibition(actionName);
        if (p != null) {
            for (final IOdrlAsset a : p.getAssets()) {
                if (a.getUUID().equals(asset.getUUID())) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

    public ElementList<IOdrlAsset> getAssets() {
        final ElementList<IOdrlElement<IOdrlAsset>> assets = getOwnerDocument().getElementsByQName(OdrlQNames.ASSET_ELEMENT);
        final ElementListImpl<IOdrlAsset> assetList = new ElementListImpl<IOdrlAsset>();
        for (final IOdrlElement<IOdrlAsset> a : assets) {
            assetList.addNamedItem((IOdrlAsset) a);
        }

        return assetList;
    }

}
