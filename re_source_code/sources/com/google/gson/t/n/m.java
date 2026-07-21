package com.google.gson.t.n;

import com.google.gson.q;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
final class m<T> extends q<T> {
    private final com.google.gson.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q<T> f20263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f20264c;

    m(com.google.gson.e eVar, q<T> qVar, Type type) {
        this.a = eVar;
        this.f20263b = qVar;
        this.f20264c = type;
    }

    private Type e(Type type, Object obj) {
        if (obj != null) {
            return (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type;
        }
        return type;
    }

    @Override // com.google.gson.q
    public T b(com.google.gson.stream.a aVar) throws IOException {
        return this.f20263b.b(aVar);
    }

    @Override // com.google.gson.q
    public void d(com.google.gson.stream.c cVar, T t) throws IOException {
        q<T> qVarJ = this.f20263b;
        Type typeE = e(this.f20264c, t);
        if (typeE != this.f20264c) {
            qVarJ = this.a.j(com.google.gson.u.a.get(typeE));
            if (qVarJ instanceof i.b) {
                q<T> qVar = this.f20263b;
                if (!(qVar instanceof i.b)) {
                    qVarJ = qVar;
                }
            }
        }
        qVarJ.d(cVar, t);
    }
}
