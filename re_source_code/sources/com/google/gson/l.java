package com.google.gson;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: JsonObject.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l extends j {
    private final com.google.gson.t.h<String, j> a = new com.google.gson.t.h<>();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof l) && ((l) obj).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void q(String str, j jVar) {
        if (jVar == null) {
            jVar = k.a;
        }
        this.a.put(str, jVar);
    }

    public Set<Map.Entry<String, j>> r() {
        return this.a.entrySet();
    }
}
