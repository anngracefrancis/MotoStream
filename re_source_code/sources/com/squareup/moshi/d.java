package com.squareup.moshi;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: CollectionJsonAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class d<C extends Collection<T>, T> extends f<C> {
    public static final f.e a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f<T> f20550b;

    /* JADX INFO: compiled from: CollectionJsonAdapter.java */
    class a implements f.e {
        a() {
        }

        @Override // com.squareup.moshi.f.e
        public f<?> a(Type type, Set<? extends Annotation> set, r rVar) {
            Class<?> clsG = u.g(type);
            if (!set.isEmpty()) {
                return null;
            }
            if (clsG == List.class || clsG == Collection.class) {
                return d.b(type, rVar).nullSafe();
            }
            if (clsG == Set.class) {
                return d.d(type, rVar).nullSafe();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: CollectionJsonAdapter.java */
    class b extends d<Collection<T>, T> {
        b(f fVar) {
            super(fVar, null);
        }

        @Override // com.squareup.moshi.d
        Collection<T> c() {
            return new ArrayList();
        }

        @Override // com.squareup.moshi.f
        public /* bridge */ /* synthetic */ Object fromJson(i iVar) throws IOException {
            return super.a(iVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.squareup.moshi.f
        public /* bridge */ /* synthetic */ void toJson(o oVar, Object obj) throws IOException {
            super.e(oVar, (Collection) obj);
        }
    }

    /* JADX INFO: compiled from: CollectionJsonAdapter.java */
    class c extends d<Set<T>, T> {
        c(f fVar) {
            super(fVar, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.squareup.moshi.d
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Set<T> c() {
            return new LinkedHashSet();
        }

        @Override // com.squareup.moshi.f
        public /* bridge */ /* synthetic */ Object fromJson(i iVar) throws IOException {
            return super.a(iVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.squareup.moshi.f
        public /* bridge */ /* synthetic */ void toJson(o oVar, Object obj) throws IOException {
            super.e(oVar, (Collection) obj);
        }
    }

    /* synthetic */ d(f fVar, a aVar) {
        this(fVar);
    }

    static <T> f<Collection<T>> b(Type type, r rVar) {
        return new b(rVar.d(u.c(type, Collection.class)));
    }

    static <T> f<Set<T>> d(Type type, r rVar) {
        return new c(rVar.d(u.c(type, Collection.class)));
    }

    public C a(i iVar) throws IOException {
        C c2 = (C) c();
        iVar.a();
        while (iVar.f()) {
            c2.add(this.f20550b.fromJson(iVar));
        }
        iVar.c();
        return c2;
    }

    abstract C c();

    public void e(o oVar, C c2) throws IOException {
        oVar.a();
        Iterator it = c2.iterator();
        while (it.hasNext()) {
            this.f20550b.toJson(oVar, (T) it.next());
        }
        oVar.d();
    }

    public String toString() {
        return this.f20550b + ".collection()";
    }

    private d(f<T> fVar) {
        this.f20550b = fVar;
    }
}
