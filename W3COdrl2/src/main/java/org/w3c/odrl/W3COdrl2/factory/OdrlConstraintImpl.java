/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import org.w3c.odrl.W3COdrl2.datatypes.ListOfValues;
import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.model.IOdrlAttribute;
import org.w3c.odrl.W3COdrl2.model.IOdrlConstraint;
import org.w3c.odrl.W3COdrl2.model.IOdrlDocument;
import org.w3c.odrl.W3COdrl2.model.OdrlQNames;
import org.w3c.odrl.W3COdrl2.vocabulary.ConstraintName;
import org.w3c.odrl.W3COdrl2.vocabulary.ConstraintOperator;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
class OdrlConstraintImpl extends AbstractOdrlElementId<IOdrlConstraint> implements IOdrlConstraint {

    /**
     * @param qName
     * @param ownerDocument
     */
    public OdrlConstraintImpl(final IOdrlDocument ownerDocument, final ConstraintName name, final ConstraintOperator operator,
                    final ListOfValues<?> rightOperand) {
        super(OdrlQNames.CONSTRAINT_ELEMENT, ownerDocument);
        setConstraintName(name);
        setOperator(operator);
        setRightOperand(rightOperand);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlConstraint#getConstraintName()
     */
    public ConstraintName getConstraintName() {
        final IOdrlAttribute<ConstraintName> attr = getAttribute(OdrlQNames.CONSTRAINT_NAME_ATTR);
        return attr.getValue();
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlConstraint#getDataType()
     */
    public URIQNameQCode getDataType() {
        final IOdrlAttribute<URIQNameQCode> attr = getAttribute(OdrlQNames.DATA_TYPE_ATTR);
        return attr.getValue();
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlConstraint#getOperator()
     */
    public ConstraintOperator getOperator() {
        final IOdrlAttribute<ConstraintOperator> attr = getAttribute(OdrlQNames.OPERATOR_ATTR);
        return attr.getValue();
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlConstraint#getRightOperand()
     */
    public ListOfValues<?> getRightOperand() {
        final IOdrlAttribute<ListOfValues<?>> attr = getAttribute(OdrlQNames.RIGHT_OPERAND_ATTR);
        return attr.getValue();
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlConstraint#getStatus()
     */
    public String getStatus() {
        final IOdrlAttribute<String> attr = getAttribute(OdrlQNames.STATUS_ATTR);
        return attr.getValue();
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlConstraint#getUnit()
     */
    public URIQNameQCode getUnit() {
        final IOdrlAttribute<URIQNameQCode> attr = getAttribute(OdrlQNames.UNIT_ATTR);
        return attr.getValue();
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlConstraint#setConstraintName(org.w3c.odrl.v21.vocabulary.ConstraintName)
     */
    public void setConstraintName(final ConstraintName name) {
        setAttribute(OdrlQNames.CONSTRAINT_NAME_ATTR, name);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlConstraint#setDataType(org.w3c.odrl.v21.datatypes.URIQNameQCode)
     */
    public void setDataType(final URIQNameQCode dataType) {
        setAttribute(OdrlQNames.DATA_TYPE_ATTR, dataType);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlConstraint#setOperator(org.w3c.odrl.v21.vocabulary.ConstraintOperator)
     */
    public void setOperator(final ConstraintOperator operator) {
        setAttribute(OdrlQNames.OPERATOR_ATTR, operator);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlConstraint#setRightOperand(org.w3c.odrl.v21.datatypes.ListOfValues)
     */
    public void setRightOperand(final ListOfValues<?> value) {
        setAttribute(OdrlQNames.RIGHT_OPERAND_ATTR, value);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlConstraint#setStatus(java.lang.String)
     */
    public void setStatus(final String status) {
        setAttribute(OdrlQNames.STATUS_ATTR, status);
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.IOdrlConstraint#setUnit(org.w3c.odrl.v21.datatypes.URIQNameQCode)
     */
    public void setUnit(final URIQNameQCode unit) {
        setAttribute(OdrlQNames.UNIT_ATTR, unit);
    }

}
