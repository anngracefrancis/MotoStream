package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: compiled from: JsonElement.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class j {
    public g c() {
        if (h()) {
            return (g) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public l f() {
        if (n()) {
            return (l) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public m g() {
        if (o()) {
            return (m) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean h() {
        return this instanceof g;
    }

    public boolean i() {
        return this instanceof k;
    }

    public boolean n() {
        return this instanceof l;
    }

    public boolean o() {
        return this instanceof m;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            com.google.gson.stream.c cVar = new com.google.gson.stream.c(stringWriter);
            cVar.J(true);
            com.google.gson.t.l.b(this, cVar);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
