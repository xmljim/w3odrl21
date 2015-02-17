package org.w3c.odrl.W3COdrl2.datatypes;

import org.w3c.odrl.W3COdrl2.vocabulary.Vocab;



public enum ConflictTerm {

    Permanent(Vocab.createOdrlVocabItem("perm").toString()),
    Prohibited(Vocab.createOdrlVocabItem("prohibit").toString()),
    Invalid(Vocab.createOdrlVocabItem("invalid").toString());

    ConflictTerm(final String val) {
        this.value = val;
    }

    public static ConflictTerm find(final String term) {
        ConflictTerm ut = null;
        for (final ConflictTerm u : ConflictTerm.values()) {
            if (u.equals(term)) {
                ut = u;
            }
        }
        return ut;
    }

    private String value;

    @Override
    public String toString() {
        return this.value;
    }

}
