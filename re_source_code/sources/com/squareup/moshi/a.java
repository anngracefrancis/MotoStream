package com.squareup.moshi;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: compiled from: ArrayJsonAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
final class a extends f<Object> {
    public static final f.e a = new C0248a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<?> f20537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f<Object> f20538c;

    /* JADX INFO: renamed from: com.squareup.moshi.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ArrayJsonAdapter.java */
    class C0248a implements f.e {
        C0248a() {
        }

        @Override // com.squareup.moshi.f.e
        public f<?> a(Type type, Set<? extends Annotation> set, r rVar) {
            Type typeA = u.a(type);
            if (typeA != null && set.isEmpty()) {
                return new a(u.g(typeA), rVar.d(typeA)).nullSafe();
            }
            return null;
        }
    }

    a(Class<?> cls, f<Object> fVar) {
        this.f20537b = cls;
        this.f20538c = fVar;
    }

    @Override // com.squareup.moshi.f
    public Object fromJson(i iVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        iVar.a();
        while (iVar.f()) {
            arrayList.add(this.f20538c.fromJson(iVar));
        }
        iVar.c();
        Object objNewInstance = Array.newInstance(this.f20537b, arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Array.set(objNewInstance, i2, arrayList.get(i2));
        }
        return objNewInstance;
    }

    @Override // com.squareup.moshi.f
    public void toJson(o oVar, Object obj) throws IOException {
        oVar.a();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f20538c.toJson(oVar, Array.get(obj, i2));
        }
        oVar.d();
    }

    public String toString() {
        return this.f20538c + ".array()";
    }
}
