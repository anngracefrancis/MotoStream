package com.squareup.moshi;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: MapJsonAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
final class q<K, V> extends f<Map<K, V>> {
    public static final f.e a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f<K> f20601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f<V> f20602c;

    /* JADX INFO: compiled from: MapJsonAdapter.java */
    class a implements f.e {
        a() {
        }

        @Override // com.squareup.moshi.f.e
        public f<?> a(Type type, Set<? extends Annotation> set, r rVar) {
            Class<?> clsG;
            if (!set.isEmpty() || (clsG = u.g(type)) != Map.class) {
                return null;
            }
            Type[] typeArrI = u.i(type, clsG);
            return new q(rVar, typeArrI[0], typeArrI[1]).nullSafe();
        }
    }

    q(r rVar, Type type, Type type2) {
        this.f20601b = rVar.d(type);
        this.f20602c = rVar.d(type2);
    }

    @Override // com.squareup.moshi.f
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<K, V> fromJson(i iVar) throws IOException {
        p pVar = new p();
        iVar.b();
        while (iVar.f()) {
            iVar.B();
            K kFromJson = this.f20601b.fromJson(iVar);
            V vFromJson = this.f20602c.fromJson(iVar);
            V vPut = pVar.put(kFromJson, vFromJson);
            if (vPut != null) {
                throw new JsonDataException("Map key '" + kFromJson + "' has multiple values at path " + iVar.g() + ": " + vPut + " and " + vFromJson);
            }
        }
        iVar.d();
        return pVar;
    }

    @Override // com.squareup.moshi.f
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void toJson(o oVar, Map<K, V> map) throws IOException {
        oVar.b();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getKey() == null) {
                throw new JsonDataException("Map key is null at " + oVar.g());
            }
            oVar.y();
            this.f20601b.toJson(oVar, entry.getKey());
            this.f20602c.toJson(oVar, entry.getValue());
        }
        oVar.e();
    }

    public String toString() {
        return "JsonAdapter(" + this.f20601b + "=" + this.f20602c + ")";
    }
}
