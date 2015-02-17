/**
 *
 */
package org.w3c.odrl.W3COdrl2.model;


/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
public interface IOdrlPermission extends IOdrlRule<IOdrlPermission> {

    void addDuty(IOdrlDuty duty);

    ElementList<IOdrlDuty> getDuties();

    ElementList<IOdrlElementReference<IOdrlDuty>> getDutyReferences();

    IOdrlDuty removeDuty(IOdrlDuty duty);

}
