package com.squareup.moshi.w;

import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.f;
import com.squareup.moshi.i;
import com.squareup.moshi.o;
import java.io.IOException;

/* JADX INFO: compiled from: NonNullJsonAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a<T> extends f<T> {
    private final f<T> a;

    public a(f<T> fVar) {
        this.a = fVar;
    }

    @Override // com.squareup.moshi.f
    public T fromJson(i iVar) throws IOException {
        if (iVar.A() != i.b.NULL) {
            return this.a.fromJson(iVar);
        }
        throw new JsonDataException("Unexpected null at " + iVar.g());
    }

    @Override // com.squareup.moshi.f
    public void toJson(o oVar, T t) throws IOException {
        if (t != null) {
            this.a.toJson(oVar, t);
            return;
        }
        throw new JsonDataException("Unexpected null at " + oVar.g());
    }

    public String toString() {
        return this.a + ".nonNull()";
    }
}
