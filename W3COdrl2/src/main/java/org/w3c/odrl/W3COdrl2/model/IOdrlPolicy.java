package org.w3c.odrl.W3COdrl2.model;

import org.w3c.odrl.W3COdrl2.datatypes.ConflictTerm;
import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.datatypes.UndefinedTerm;
import org.w3c.odrl.W3COdrl2.vocabulary.ActionName;
import org.w3c.odrl.W3COdrl2.vocabulary.PolicyType;

/**
 * Represents an ODRL Policy root element
 * 
 * @author Jim Earley <xml.jim@gmail.com> Sep 10, 2014
 *
 */
public interface IOdrlPolicy extends IOdrlElementUUID<IOdrlPolicy> {

    /**
     * Set the policy type
     * 
     * @param policyType
     */
    void setType(PolicyType policyType);

    /**
     * Return the policy type
     * 
     * @return
     */
    PolicyType getType();

    /**
     * Set the Conflict handling value for the policy
     * 
     * @param conflict
     */
    void setConflict(ConflictTerm conflict);

    /**
     * return the Conflict handling value for the policy
     * 
     * @return
     */
    ConflictTerm getConflict();

    /**
     * Set the undefined value
     * 
     * @param undefined
     */
    void setUndefined(UndefinedTerm undefined);

    /**
     * Get the undefined value
     * 
     * @return
     */
    UndefinedTerm getUndefined();

    /**
     * Specify whether inheritance is allowed
     * 
     * @param inheritAllowed
     */
    void setInheritAllowed(boolean inheritAllowed);

    /**
     * Return whether inheritance is allowed
     * 
     * @return
     */
    boolean getInheritAllowed();

    /**
     * Set the Unique ID of the parent policy
     * 
     * @param inheritFrom
     */
    void setInheritFrom(URIQNameQCode inheritFrom);

    /**
     * return the Unique ID of the parent policy
     * 
     * @return
     */
    URIQNameQCode getInheritFrom();

    /**
     * Sets the UID of the inherited relation
     * 
     * @param inheritRelation
     */
    void setInheritRelation(URIQNameQCode inheritRelation);

    /**
     * Gets the UID of the inherited relation
     * 
     * @return
     */
    URIQNameQCode getInheritRelation();

    /**
     * Sets the policy profile
     * 
     * @param profile
     */
    void setProfile(URIQNameQCode profile);

    /**
     * returns the policy profile
     * 
     * @return
     */
    URIQNameQCode getProfile();

    /**
     * Adds a new permission
     * 
     * @param permission
     */
    void addPermission(IOdrlPermission permission);

    /**
     * Removes a permission
     * 
     * @param permission
     * @return
     */
    IOdrlPermission removePermission(IOdrlPermission permission);

    /**
     * Returns a list of current permissions
     * 
     * @return
     */
    ElementList<IOdrlPermission> getPermissions();

    /**
     * Finds a permission based on its specified action. Note, if there are more than one permissions in the policy with the same action
     * name, it will return the first instance.
     * 
     * @param actionName
     * @return
     */
    IOdrlPermission findPermission(ActionName actionName);

    /**
     * Returns a list of permissions relevant to a particular asset
     * 
     * @param asset
     * @return
     */
    ElementList<IOdrlPermission> findPermissionsForAsset(IOdrlAsset asset);

    /**
     * Returns whether an asset has a specified permission
     * 
     * @param asset
     *            the asset
     * @param actionName
     *            the action name, as specified on the permission's action element name attribute
     * @return
     */
    boolean assetHasPermission(IOdrlAsset asset, ActionName actionName);

    /**
     * Adds a prohibition
     * 
     * @param prohibition
     */
    void addProhibition(IOdrlProhibition prohibition);

    /**
     * Removes a prohibition
     * 
     * @param prohibition
     * @return
     */
    IOdrlProhibition removeProhibition(IOdrlProhibition prohibition);

    /**
     * Returns a list of current prohibitions
     * 
     * @return
     */
    ElementList<IOdrlProhibition> getProhibitions();

    /**
     * Finds a prohibition based on its specified action. If there are more than one prohibitions in the same policy with the same action
     * name, it will return the first instance.
     * 
     * @param actionName
     * @return
     */
    IOdrlProhibition findProhibition(ActionName actionName);

    /**
     * Returns a list of prohibitions relevant to a particular asset
     * 
     * @param asset
     * @return
     */
    ElementList<IOdrlProhibition> findProhibitionsForAsset(IOdrlAsset asset);

    /**
     * Returns whether an asset has a specified prohibition, based on the prohibition's action
     * 
     * @param asset
     *            the asset
     * @param actionName
     *            the name of the action set on the prohibition's action element
     * @return
     */
    boolean assetHasProhibition(IOdrlAsset asset, ActionName actionName);

    /**
     * Returns a distinct list of assets identified in the policy. For example, the same asset may be specified for each permission and
     * prohibition. However it will only be listed once here.
     * 
     * @return
     */
    ElementList<IOdrlAsset> getAssets();
}
