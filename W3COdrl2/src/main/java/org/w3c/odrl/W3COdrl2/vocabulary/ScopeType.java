package org.w3c.odrl.W3COdrl2.vocabulary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;

public class ScopeType extends URIQNameQCode {

    public static List<ScopeType> getRoleScopes() {
        final List<ScopeType> scopes = new ArrayList<ScopeType>();

        for (final Entry<String, ScopeType> entry : registeredItems.entrySet()) {
            scopes.add(entry.getValue());
        }

        return scopes;
    }

    public static boolean isRoleScope(final String uriQNameQCode) {
        return registeredItems.containsKey(uriQNameQCode);
    }

    public static ScopeType newRoleScope(final String uriQNameQCodeValue) {
        final ScopeType rs = new ScopeType();
        rs.setValue(uriQNameQCodeValue);
        return rs;
    }

    public static ScopeType newRoleScope(final URIQNameQCode vocabId) {
        return newRoleScope(vocabId.toString());
    }

    public static void registerRoleScope(final ScopeType rs) {
        registeredItems.put(rs.toString(), rs);
    }

    public static final ScopeType INDIVIDUAL = ScopeType.newRoleScope(Vocab.createOdrlVocabItem("Individual"));

    public static final ScopeType GROUP = ScopeType.newRoleScope(Vocab.createOdrlVocabItem("Group"));

    public static final ScopeType ALL = ScopeType.newRoleScope(Vocab.createOdrlVocabItem("All"));

    public static final ScopeType ALL_CONNECTIONS = ScopeType.newRoleScope(Vocab.createOdrlVocabItem("AllConnections"));

    public static final ScopeType ALL_2ND_CONNECTIONS = ScopeType.newRoleScope(Vocab.createOdrlVocabItem("All2ndConnections"));

    public static final ScopeType ALL_GROUPS = ScopeType.newRoleScope(Vocab.createOdrlVocabItem("AllGroups"));

    static {
        registerRoleScope(ALL);
        registerRoleScope(ALL_2ND_CONNECTIONS);
        registerRoleScope(ALL_CONNECTIONS);
        registerRoleScope(ALL_GROUPS);
        registerRoleScope(INDIVIDUAL);
        registerRoleScope(GROUP);
    }

    private static Map<String, ScopeType> registeredItems = new HashMap<String, ScopeType>();

    private ScopeType() {
        super();
    }

    public static ScopeType valueOf(final String scopeTypeString) {
        final ScopeType st = new ScopeType();
        st.setValue(scopeTypeString);
        return st;
    }
}
