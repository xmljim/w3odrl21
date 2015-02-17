/**
 *
 */
package org.w3c.odrl.W3COdrl2.model;

import org.w3c.odrl.W3COdrl2.vocabulary.FunctionType;
import org.w3c.odrl.W3COdrl2.vocabulary.ScopeType;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
public interface IOdrlParty extends IOdrlElementUUIDAndId<IOdrlParty> {

    FunctionType getFunction();

    ScopeType getScope();

    void setFunction(FunctionType function);

    void setScope(ScopeType scope);
}
