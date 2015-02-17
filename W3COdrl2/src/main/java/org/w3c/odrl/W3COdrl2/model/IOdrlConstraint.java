/**
 *
 */
package org.w3c.odrl.W3COdrl2.model;

import org.w3c.odrl.W3COdrl2.datatypes.ListOfValues;
import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.vocabulary.ConstraintName;
import org.w3c.odrl.W3COdrl2.vocabulary.ConstraintOperator;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
public interface IOdrlConstraint extends IOdrlElementId<IOdrlConstraint> {

    ConstraintName getConstraintName();

    URIQNameQCode getDataType();

    ConstraintOperator getOperator();

    ListOfValues<?> getRightOperand();

    String getStatus();

    URIQNameQCode getUnit();

    void setConstraintName(ConstraintName name);

    void setDataType(URIQNameQCode dataType);

    void setOperator(ConstraintOperator operator);

    void setRightOperand(ListOfValues<?> value);

    void setStatus(String status);

    void setUnit(URIQNameQCode unit);

}
