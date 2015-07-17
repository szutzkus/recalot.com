package com.recalot.common.communication;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Matthäus Schmedding (info@recalot.com)
 */
public class Item {
    private final Map<String, String> content;
    private final String id;

    public Item(String id){
        this(id, new HashMap<>());
    }

    public Item(String id, Map<String, String> content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public Map<String, String> getContent() {
        return content;
    }

    public String getValue(String key) {
        return content.get(key);
    }
}
