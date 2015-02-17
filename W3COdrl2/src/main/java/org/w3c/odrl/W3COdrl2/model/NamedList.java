package org.w3c.odrl.W3COdrl2.model;


public interface NamedList<T> extends Iterable<T> {
	
	Iterable<T> items();
	
	T getItem(int index);
	
	int getItemCount();
	
	void clear();

}
