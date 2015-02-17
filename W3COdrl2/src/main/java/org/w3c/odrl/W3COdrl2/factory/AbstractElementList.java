/**
 * 
 */
package org.w3c.odrl.W3COdrl2.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.datatypes.XsToken;
import org.w3c.odrl.W3COdrl2.model.ElementList;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementBase;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementId;
import org.w3c.odrl.W3COdrl2.model.IOdrlElementUUID;

/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 3, 2014
 *
 */
abstract class AbstractElementList<T> extends AbstractNamedList<T> implements ElementList<T> {
    private final Map<String, IOdrlElementUUID<T>> itemUUIDMap = new HashMap<String, IOdrlElementUUID<T>>();
    private final Map<String, IOdrlElementId<T>> itemIdMap = new HashMap<String, IOdrlElementId<T>>();
    private final Map<String, List<T>> itemQNameMap = new HashMap<String, List<T>>();

    /**
     * 
     */
    public AbstractElementList() {

    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.ElementList#getItemById(org.w3c.odrl.v21.datatypes.XsToken)
     */
    
    public IOdrlElementId<T> getItemById(final XsToken id) {
        IOdrlElementId<T> base = null;
        
        if (this.itemIdMap.containsKey(id.toString())) {
            base = this.itemIdMap.get(id.toString());
        }
        
        return base;
    }

    /* (non-Javadoc)
     * @see org.w3c.odrl.v21.model.ElementList#getItemByUuid(org.w3c.odrl.v21.datatypes.URIQNameQCode)
     */
    public IOdrlElementUUID<T> getItemByUuid(final URIQNameQCode uuid) {
        IOdrlElementUUID<T> selected = null;

        if (this.itemUUIDMap.containsKey(uuid.toString())) {
            selected = this.itemUUIDMap.get(uuid.toString());
        }
        return selected;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.factory.AbstractNamedList#addNamedItem(java.lang.Object)
     */

    @Override
    protected void addNamedItem(final T item) {
        super.addNamedItem(item);
        updateLocalMaps(item);
    }

    @SuppressWarnings("unchecked")
    protected void updateLocalMaps(final T item) {

        if (item instanceof IOdrlElementUUID) {

            final URIQNameQCode uuid = ((IOdrlElementUUID<T>) item).getUUID();
            if (uuid != null) {
                this.itemUUIDMap.put(uuid.toString(), (IOdrlElementUUID<T>) item);
            }
        }

        if (item instanceof IOdrlElementId) {
            final XsToken id = ((IOdrlElementId<T>) item).getId();
            if (id != null) {
                this.itemIdMap.put(id.toString(), (IOdrlElementId<T>) item);
            }
        }

        final QName name = ((IOdrlElementBase) item).getName();

        if (this.itemQNameMap.containsKey(name.toString())) {
            final List<T> nameList = this.itemQNameMap.get(name.toString());
            if (!nameList.contains(item)) {
                nameList.add(item);
            }
        } else {
            final List<T> nameList = new ArrayList<T>();
            nameList.add(item);
            this.itemQNameMap.put(name.toString(), nameList);
        }
    }

    @Override
    protected void addNamedItemAt(final T item, final int index) {
        super.addNamedItemAt(item, index);
        updateLocalMaps(item);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.factory.AbstractNamedList#removeItem(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void removeItem(final T item) {
        if (this.itemIdMap.containsValue(item)) {
            this.itemIdMap.remove(((IOdrlElementId<T>) item).getId());
        }

        if (this.itemUUIDMap.containsValue(item)) {
            this.itemUUIDMap.remove(((IOdrlElementUUID<T>) item).getUUID());
        }

        this.itemQNameMap.remove(((IOdrlElementBase) item).getName());
        super.removeItem(item);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.w3c.odrl.v21.model.ElementList#getItemsByName(javax.xml.namespace.QName)
     */
    public Iterable<T> getItemsByName(final QName name) {
        if (this.itemQNameMap.containsKey(name.toString())) {
            return this.itemQNameMap.get(name.toString());
        } else {
            return new ArrayList<T>();
        }
    }

    protected String printUUIDMap() {
        return this.itemUUIDMap.toString();
    }

}
