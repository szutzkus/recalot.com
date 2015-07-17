package org.osgi.service.indexer.impl.types;

import org.osgi.service.indexer.Namespaces;
import org.osgi.service.indexer.impl.Schema;
import org.osgi.service.indexer.impl.util.Tag;

import javax.lang.model.element.Name;

public class TypedAttribute {

    private final String name;
    private final Type type;
    private final Object value;

    public TypedAttribute(String name, Type type, Object value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public static TypedAttribute create(String name, Object value) {
        return new TypedAttribute(name, Type.typeOf(value), value);
    }

    public Tag toXML() {
        Tag tag = new Tag(Schema.ELEM_P);
        if (name.equals(Namespaces.NS_WIRING_PACKAGE)) {
            tag.addAttribute(Schema.ATTR_N, "package");
        } else if (name.equals("objectClass")) {
            tag.addAttribute(Schema.ATTR_N, "service");
        }
        else {
            tag.addAttribute(Schema.ATTR_N, name);
        }

        if (type.isList() || type.getType() != ScalarType.String) {
            tag.addAttribute(Schema.ATTR_T, type.toString().toLowerCase());
        }

        tag.addAttribute(Schema.ATTR_V, type.convertToString(value));

        return tag;
    }
}
