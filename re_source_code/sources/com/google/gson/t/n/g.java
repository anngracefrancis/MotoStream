package com.google.gson.t.n;

import com.google.gson.JsonSyntaxException;
import com.google.gson.q;
import com.google.gson.r;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: MapTypeAdapterFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements r {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.gson.t.c f20234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f20235g;

    /* JADX INFO: compiled from: MapTypeAdapterFactory.java */
    private final class a<K, V> extends q<Map<K, V>> {
        private final q<K> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final q<V> f20236b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.google.gson.t.i<? extends Map<K, V>> f20237c;

        public a(com.google.gson.e eVar, Type type, q<K> qVar, Type type2, q<V> qVar2, com.google.gson.t.i<? extends Map<K, V>> iVar) {
            this.a = new m(eVar, qVar, type);
            this.f20236b = new m(eVar, qVar2, type2);
            this.f20237c = iVar;
        }

        private String e(com.google.gson.j jVar) {
            if (!jVar.o()) {
                if (jVar.i()) {
                    return "null";
                }
                throw new AssertionError();
            }
            com.google.gson.m mVarG = jVar.g();
            if (mVarG.z()) {
                return String.valueOf(mVarG.v());
            }
            if (mVarG.x()) {
                return Boolean.toString(mVarG.q());
            }
            if (mVarG.C()) {
                return mVarG.w();
            }
            throw new AssertionError();
        }

        @Override // com.google.gson.q
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map<K, V> b(com.google.gson.stream.a aVar) throws IOException {
            com.google.gson.stream.b bVarQ = aVar.Q();
            if (bVarQ == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            Map<K, V> mapA = this.f20237c.a();
            if (bVarQ == com.google.gson.stream.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.l()) {
                    aVar.a();
                    K kB = this.a.b(aVar);
                    if (mapA.put(kB, this.f20236b.b(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + kB);
                    }
                    aVar.f();
                }
                aVar.f();
            } else {
                aVar.b();
                while (aVar.l()) {
                    com.google.gson.t.f.a.a(aVar);
                    K kB2 = this.a.b(aVar);
                    if (mapA.put(kB2, this.f20236b.b(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + kB2);
                    }
                }
                aVar.j();
            }
            return mapA;
        }

        @Override // com.google.gson.q
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Map<K, V> map) throws IOException {
            if (map == null) {
                cVar.y();
                return;
            }
            if (!g.this.f20235g) {
                cVar.d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.p(String.valueOf(entry.getKey()));
                    this.f20236b.d(cVar, entry.getValue());
                }
                cVar.j();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i2 = 0;
            boolean z = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                com.google.gson.j jVarC = this.a.c(entry2.getKey());
                arrayList.add(jVarC);
                arrayList2.add(entry2.getValue());
                z |= jVarC.h() || jVarC.n();
            }
            if (!z) {
                cVar.d();
                int size = arrayList.size();
                while (i2 < size) {
                    cVar.p(e((com.google.gson.j) arrayList.get(i2)));
                    this.f20236b.d(cVar, (V) arrayList2.get(i2));
                    i2++;
                }
                cVar.j();
                return;
            }
            cVar.c();
            int size2 = arrayList.size();
            while (i2 < size2) {
                cVar.c();
                com.google.gson.t.l.b((com.google.gson.j) arrayList.get(i2), cVar);
                this.f20236b.d(cVar, (V) arrayList2.get(i2));
                cVar.f();
                i2++;
            }
            cVar.f();
        }
    }

    public g(com.google.gson.t.c cVar, boolean z) {
        this.f20234f = cVar;
        this.f20235g = z;
    }

    private q<?> a(com.google.gson.e eVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? n.f20269f : eVar.j(com.google.gson.u.a.get(type));
    }

    @Override // com.google.gson.r
    public <T> q<T> b(com.google.gson.e eVar, com.google.gson.u.a<T> aVar) {
        Type type = aVar.getType();
        if (!Map.class.isAssignableFrom(aVar.getRawType())) {
            return null;
        }
        Type[] typeArrJ = com.google.gson.t.b.j(type, com.google.gson.t.b.k(type));
        return new a(eVar, typeArrJ[0], a(eVar, typeArrJ[0]), typeArrJ[1], eVar.j(com.google.gson.u.a.get(typeArrJ[1])), this.f20234f.a(aVar));
    }
}
