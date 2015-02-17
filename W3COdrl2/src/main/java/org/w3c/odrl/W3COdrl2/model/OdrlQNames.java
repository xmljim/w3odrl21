package org.w3c.odrl.W3COdrl2.model;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.vocabulary.Vocab;

public class OdrlQNames {

    private OdrlQNames() {
        // TODO Auto-generated constructor stub
    }

    public static final QName POLICY_ELEMENT = Vocab.createItemQName(Vocab.ODRL_NS, "Policy");

    public static final QName CONSTRAINT_ELEMENT = Vocab.createItemQName(Vocab.ODRL_NS, "constraint");

    public static final QName ASSET_ELEMENT = Vocab.createItemQName(Vocab.ODRL_NS, "asset");

    public static final QName PROHIBITION_ELEMENT = Vocab.createItemQName(Vocab.ODRL_NS, "prohibition");

    public static final QName PERMISSION_ELEMENT = Vocab.createItemQName(Vocab.ODRL_NS, "permission");

    public static final QName DUTY_ELEMENT = Vocab.createItemQName(Vocab.ODRL_NS, "duty");

    public static final QName ACTION_ELEMENT = Vocab.createItemQName(Vocab.ODRL_NS, "action");

    public static final QName PARTY_ELEMENT = Vocab.createItemQName(Vocab.ODRL_NS, "party");

    public static final QName UID_ATTR = Vocab.createItemQName(null, "uid");

    public static final QName TYPE_ATTR = Vocab.createItemQName(null, "type");

    public static final QName CONFLICT_ATTR = Vocab.createItemQName(null, "confict");

    public static final QName UNDEFINED_ATTR = Vocab.createItemQName(null, "undefined");

    public static final QName INHERIT_ALLOWED_ATTR = Vocab.createItemQName(null, "inheritAllowed");

    public static final QName INHERIT_FROM_ATTR = Vocab.createItemQName(null, "inheritFrom");

    public static final QName INHERIT_RELATION_ATTR = Vocab.createItemQName(null, "inheritRelation");

    public static final QName PROFILE_ATTR = Vocab.createItemQName(null, "profile");

    public static final QName ID_ATTR = Vocab.createItemQName(null, "id");

    public static final QName IDREF_ATTR = Vocab.createItemQName(null, "idref");

    public static final QName RELATION_ATTR = Vocab.createItemQName(null, "relation");

    public static final QName FUNCTION_ATTR = Vocab.createItemQName(null, "function");

    public static final QName SCOPE_ATTR = Vocab.createItemQName(null, "scope");

    public static final QName ACTION_NAME_ATTR = Vocab.createItemQName(null, "name");

    /*
     * Even though Action and Constraint @name are the same, it's always a good idea to make a distinction in the event it changes down the
     * road
     */

    public static final QName CONSTRAINT_NAME_ATTR = Vocab.createItemQName(null, "name");

    public static final QName OPERATOR_ATTR = Vocab.createItemQName(null, "operator");

    public static final QName RIGHT_OPERAND_ATTR = Vocab.createItemQName(null, "rightOperand");

    public static final QName DATA_TYPE_ATTR = Vocab.createItemQName(null, "dataType");

    public static final QName UNIT_ATTR = Vocab.createItemQName(null, "unit");

    public static final QName STATUS_ATTR = Vocab.createItemQName(null, "status");

}
