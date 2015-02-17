/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.w3c.odrl.W3COdrl2.model.NamedList;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
abstract class AbstractNamedList<T> implements NamedList<T> {


    private final List<T> items = new ArrayList<T>();

    /**
     * 
     */
    public AbstractNamedList() {
    }


    public Iterable<T> items() {
        return this.items;
    }


    public T getItem(final int index) {
        return this.items.get(index);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.model.NamedList#getItemCount()
     */
    
    public int getItemCount() {
        return this.items.size();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.model.NamedList#clear()
     */

    public void clear() {
        this.items.clear();

    }

    protected void addNamedItem(final T item) {

        this.items.add(item);
    }

    protected void addNamedItemAt(final T item, final int index) {
        this.items.add(index, item);
    }

    protected void addItems(final List<T> itemList) {
        this.items.addAll(itemList);
    }

    protected void addItems(final Iterable<T> itemSet) {
        for (final T b : itemSet) {
            addNamedItem(b);
        }
    }

    protected void removeItem(final T item) {
        if (this.items.contains(item)) {
            this.items.remove(item);
        }
    }

    protected boolean hasItem(final T item) {
        return this.items.contains(item);
    }

   
    public Iterator<T> iterator() {
        return this.items.iterator();
    }

}
