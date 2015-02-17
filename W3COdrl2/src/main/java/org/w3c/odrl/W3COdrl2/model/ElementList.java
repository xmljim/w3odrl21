package org.w3c.odrl.W3COdrl2.model;

import javax.xml.namespace.QName;

import org.w3c.odrl.W3COdrl2.datatypes.URIQNameQCode;
import org.w3c.odrl.W3COdrl2.datatypes.XsToken;

public interface ElementList<T> extends NamedList<T> {

    IOdrlElementId<T> getItemById(XsToken id);

    IOdrlElementUUID<T> getItemByUuid(URIQNameQCode uuid);

    Iterable<T> getItemsByName(QName name);
}
