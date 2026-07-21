package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: JsonArray.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends j implements Iterable<j> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<j> f20151f = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof g) && ((g) obj).f20151f.equals(this.f20151f));
    }

    public int hashCode() {
        return this.f20151f.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<j> iterator() {
        return this.f20151f.iterator();
    }

    public void q(j jVar) {
        if (jVar == null) {
            jVar = k.a;
        }
        this.f20151f.add(jVar);
    }
}
