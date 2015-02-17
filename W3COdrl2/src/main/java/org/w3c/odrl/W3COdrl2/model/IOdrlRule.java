/**
 *
 */
package org.w3c.odrl.W3COdrl2.model;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
public interface IOdrlRule<T> extends IOdrlElementId<T> {

    // CONSTRAINT //
    void addConstraint(IOdrlConstraint constraint);

    ElementList<IOdrlConstraint> getConstraints();

    ElementList<IOdrlElementReference<IOdrlConstraint>> getConstraintReferences();

    void removeConstraint(IOdrlConstraint constraint);

    // ASSET //
    void addAsset(IOdrlAsset asset);

    ElementList<IOdrlAsset> getAssets();

    ElementList<IOdrlElementReference<IOdrlAsset>> getAssetReferences();

    IOdrlAsset removeAsset(IOdrlAsset asset);


    // ACTION

    void setAction(IOdrlAction action);

    IOdrlAction getAction();

    // PARTY
    void addParty(IOdrlParty party);

    ElementList<IOdrlParty> getParties();

    ElementList<IOdrlElementReference<IOdrlParty>> getPartyReferences();

    IOdrlParty removeParty(IOdrlParty party);
}
