package org.parceler.g;

import android.os.Parcel;
import java.util.Map;

/* JADX INFO: compiled from: MapParcelConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j<K, V, M extends Map<K, V>> implements org.parceler.f<Map<K, V>, M> {
    public abstract M c();

    @Override // org.parceler.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public M a(Parcel parcel) {
        int i2 = parcel.readInt();
        if (i2 == -1) {
            return null;
        }
        M m = (M) c();
        for (int i3 = 0; i3 < i2; i3++) {
            m.put(e(parcel), g(parcel));
        }
        return m;
    }

    public abstract K e(Parcel parcel);

    public abstract void f(K k2, Parcel parcel);

    public abstract V g(Parcel parcel);

    public abstract void h(V v, Parcel parcel);

    @Override // org.parceler.f
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void b(Map<K, V> map, Parcel parcel) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            f(entry.getKey(), parcel);
            h(entry.getValue(), parcel);
        }
    }
}
