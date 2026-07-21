package kotlin.reflect.y.internal.k0;

import java.io.Serializable;

/* JADX INFO: compiled from: MapEntry.java */
/* JADX INFO: loaded from: classes3.dex */
final class e<K, V> implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final K f24955f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final V f24956g;

    public e(K k2, V v) {
        this.f24955f = k2;
        this.f24956g = v;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        K k2 = this.f24955f;
        if (k2 == null) {
            if (eVar.f24955f != null) {
                return false;
            }
        } else if (!k2.equals(eVar.f24955f)) {
            return false;
        }
        V v = this.f24956g;
        V v2 = eVar.f24956g;
        if (v == null) {
            if (v2 != null) {
                return false;
            }
        } else if (!v.equals(v2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        K k2 = this.f24955f;
        int iHashCode = k2 == null ? 0 : k2.hashCode();
        V v = this.f24956g;
        return iHashCode ^ (v != null ? v.hashCode() : 0);
    }

    public String toString() {
        return this.f24955f + "=" + this.f24956g;
    }
}
