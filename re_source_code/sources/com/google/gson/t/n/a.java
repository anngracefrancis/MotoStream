package com.google.gson.t.n;

import com.google.gson.q;
import com.google.gson.r;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: compiled from: ArrayTypeAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a<E> extends q<Object> {
    public static final r a = new C0244a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<E> f20228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q<E> f20229c;

    /* JADX INFO: renamed from: com.google.gson.t.n.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ArrayTypeAdapter.java */
    static class C0244a implements r {
        C0244a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> b(com.google.gson.e eVar, com.google.gson.u.a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type typeG = com.google.gson.t.b.g(type);
            return new a(eVar, eVar.j(com.google.gson.u.a.get(typeG)), com.google.gson.t.b.k(typeG));
        }
    }

    public a(com.google.gson.e eVar, q<E> qVar, Class<E> cls) {
        this.f20229c = new m(eVar, qVar, cls);
        this.f20228b = cls;
    }

    @Override // com.google.gson.q
    public Object b(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.Q() == com.google.gson.stream.b.NULL) {
            aVar.I();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.l()) {
            arrayList.add(this.f20229c.b(aVar));
        }
        aVar.f();
        int size = arrayList.size();
        Object objNewInstance = Array.newInstance((Class<?>) this.f20228b, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(objNewInstance, i2, arrayList.get(i2));
        }
        return objNewInstance;
    }

    @Override // com.google.gson.q
    public void d(com.google.gson.stream.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.y();
            return;
        }
        cVar.c();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f20229c.d(cVar, (E) Array.get(obj, i2));
        }
        cVar.f();
    }
}
