package com.ghotibown.json.factory;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.ghotibown.json.JSONMapNode;
import com.ghotibown.json.JSONValue;
import com.ghotibown.json.exception.JSONInvalidValueTypeException;

abstract class AbstractMapNode extends AbstractJSONNode implements JSONMapNode {
    /**
     * @uml.property name="jsonMap"
     * @uml.associationEnd qualifier="key:java.lang.String com.ghotibown.json.JSONValue"
     */
    private Map<String, JSONValue<?>> jsonMap = new LinkedHashMap<String, JSONValue<?>>();

    
    public String[] names() {
        String[] values = jsonMap.keySet().toArray(new String[size()]);
        return values;
    }

    
    public void clear() {
        jsonMap.clear();

    }

    
    public boolean containsKey(String key) {
        return jsonMap.containsKey(key);
    }

    
    public Set<Entry<String, JSONValue<?>>> elements() {
        return jsonMap.entrySet();
    }

   
    public JSONValue<?> get(String key) {

        return jsonMap.get(key);
    }

    public Map<String, Object> getMap() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        for (Entry<String, JSONValue<?>> element : elements()) {
            map.put(element.getKey(), element.getValue().getValue());
        }

        return map;
    }

    public void put(String key, Object value) throws JSONInvalidValueTypeException {
        JSONValue<?> v = NodeFactory.createFromObject(value);
        if (v == null) {
            //
        	v = NodeFactory.newJSONNullValue();
        }
        put(key, v);
    }

    
    public void put(String key, JSONValue<?> value) {
        jsonMap.put(key, value);
    }

    
    public void putAll(Map<String, JSONValue<?>> m) {
        jsonMap.putAll(m);

    }

    public void putAllRaw(Map<String, Object> map) {
        Set<String> keys = map.keySet();
        for (String key : keys) {
            JSONValue<?> v = NodeFactory.createFromObject(map.get(key));
            put(key, v);
        }
    }

    
    public JSONValue<?> remove(String key) {
        return jsonMap.remove(key);
    }

  
    public int size() {
        return jsonMap.size();
    }

    
    public Collection<JSONValue<?>> values() {
        return jsonMap.values();
    }

    @Override
    public JSONValue<?> getValue() {
        // TODO Auto-generated method stub
        return null;
    }

    public Iterable<String> keys() {
        return jsonMap.keySet();
    }
}
