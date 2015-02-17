package org.w3c.odrl.W3COdrl2.model;

import javax.xml.namespace.QName;

public interface IOdrlElementReference<T> extends IOdrlElementBase {

    QName getReferenceIdentifierAttribute();

    T getReferenceTarget();

    void setReferenceIdentifierAttribute(QName qname);

    void setReferenceTarget(T element);
}
