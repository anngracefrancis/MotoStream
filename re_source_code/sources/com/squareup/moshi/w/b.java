package com.squareup.moshi.w;

import com.squareup.moshi.f;
import com.squareup.moshi.i;
import com.squareup.moshi.o;
import java.io.IOException;

/* JADX INFO: compiled from: NullSafeJsonAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<T> extends f<T> {
    private final f<T> a;

    public b(f<T> fVar) {
        this.a = fVar;
    }

    @Override // com.squareup.moshi.f
    public T fromJson(i iVar) throws IOException {
        return iVar.A() == i.b.NULL ? (T) iVar.x() : this.a.fromJson(iVar);
    }

    @Override // com.squareup.moshi.f
    public void toJson(o oVar, T t) throws IOException {
        if (t == null) {
            oVar.m();
        } else {
            this.a.toJson(oVar, t);
        }
    }

    public String toString() {
        return this.a + ".nullSafe()";
    }
}
