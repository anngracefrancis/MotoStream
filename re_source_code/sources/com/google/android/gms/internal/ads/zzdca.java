package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdca<P> {
    private static final Charset a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentMap<String, List<zzdcb<P>>> f15860b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzdcb<P> f15861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class<P> f15862d;

    private zzdca(Class<P> cls) {
        this.f15862d = cls;
    }

    public static <P> zzdca<P> a(Class<P> cls) {
        return new zzdca<>(cls);
    }

    public final zzdcb<P> b(P p, zzdha.zzb zzbVar) throws GeneralSecurityException {
        byte[] bArrArray;
        int i2 = br.a[zzbVar.x().ordinal()];
        if (i2 == 1 || i2 == 2) {
            bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(zzbVar.B()).array();
        } else if (i2 == 3) {
            bArrArray = ByteBuffer.allocate(5).put((byte) 1).putInt(zzbVar.B()).array();
        } else {
            if (i2 != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            bArrArray = zzdbm.a;
        }
        zzdcb<P> zzdcbVar = new zzdcb<>(p, bArrArray, zzbVar.A(), zzbVar.x());
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzdcbVar);
        String str = new String(zzdcbVar.c(), a);
        List<zzdcb<P>> listPut = this.f15860b.put(str, Collections.unmodifiableList(arrayList));
        if (listPut != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(listPut);
            arrayList2.add(zzdcbVar);
            this.f15860b.put(str, Collections.unmodifiableList(arrayList2));
        }
        return zzdcbVar;
    }

    public final void c(zzdcb<P> zzdcbVar) {
        this.f15861c = zzdcbVar;
    }

    public final Class<P> d() {
        return this.f15862d;
    }

    public final zzdcb<P> e() {
        return this.f15861c;
    }
}
