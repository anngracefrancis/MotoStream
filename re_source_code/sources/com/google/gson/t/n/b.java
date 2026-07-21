package com.google.gson.t.n;

import com.google.gson.q;
import com.google.gson.r;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: CollectionTypeAdapterFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements r {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.gson.t.c f20230f;

    /* JADX INFO: compiled from: CollectionTypeAdapterFactory.java */
    private static final class a<E> extends q<Collection<E>> {
        private final q<E> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.google.gson.t.i<? extends Collection<E>> f20231b;

        public a(com.google.gson.e eVar, Type type, q<E> qVar, com.google.gson.t.i<? extends Collection<E>> iVar) {
            this.a = new m(eVar, qVar, type);
            this.f20231b = iVar;
        }

        @Override // com.google.gson.q
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<E> b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            Collection<E> collectionA = this.f20231b.a();
            aVar.a();
            while (aVar.l()) {
                collectionA.add(this.a.b(aVar));
            }
            aVar.f();
            return collectionA;
        }

        @Override // com.google.gson.q
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                cVar.y();
                return;
            }
            cVar.c();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.a.d(cVar, it.next());
            }
            cVar.f();
        }
    }

    public b(com.google.gson.t.c cVar) {
        this.f20230f = cVar;
    }

    @Override // com.google.gson.r
    public <T> q<T> b(com.google.gson.e eVar, com.google.gson.u.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type typeH = com.google.gson.t.b.h(type, rawType);
        return new a(eVar, typeH, eVar.j(com.google.gson.u.a.get(typeH)), this.f20230f.a(aVar));
    }
}
