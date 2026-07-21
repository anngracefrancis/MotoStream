package com.google.android.gms.internal.ads;

import cm.aptoide.pt.database.room.RoomNotification;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdtm<K, V> {
    private final LinkedHashMap<K, zzdtu<V>> a;

    private zzdtm(int i2) {
        this.a = zzdtf.c(i2);
    }

    public final zzdtm<K, V> a(K k2, zzdtu<V> zzdtuVar) {
        this.a.put((K) zzdto.b(k2, RoomNotification.KEY), (zzdtu) zzdto.b(zzdtuVar, "provider"));
        return this;
    }

    public final zzdtk<K, V> b() {
        return new zzdtk<>(this.a);
    }
}
