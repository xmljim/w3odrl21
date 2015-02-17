package org.w3c.odrl.W3COdrl2.datatypes;

import org.w3c.odrl.W3COdrl2.vocabulary.Vocab;

public enum UndefinedTerm {

    Support(Vocab.createOdrlVocabItem("support").toString()),
    Ignore(Vocab.createOdrlVocabItem("ignore").toString()),
    Invalid(Vocab.createOdrlVocabItem("invalid").toString());
	
	private String value;
	
	UndefinedTerm(final String value) {
		this.value = value;
	}
	
    public static UndefinedTerm find(final String term) {
        UndefinedTerm ut = null;
        for (final UndefinedTerm u : UndefinedTerm.values()) {
            if (u.equals(term)) {
                ut = u;
            }
        }
        return ut;
    }

	@Override
    public String toString() {
		return this.value;
	}
}
