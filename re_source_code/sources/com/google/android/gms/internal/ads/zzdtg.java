package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdtg<T> implements zzdti<T> {
    private zzdtu<T> a;

    public static <T> void a(zzdtu<T> zzdtuVar, zzdtu<T> zzdtuVar2) {
        zzdto.a(zzdtuVar2);
        zzdtg zzdtgVar = (zzdtg) zzdtuVar;
        if (zzdtgVar.a != null) {
            throw new IllegalStateException();
        }
        zzdtgVar.a = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final T get() {
        zzdtu<T> zzdtuVar = this.a;
        if (zzdtuVar != null) {
            return zzdtuVar.get();
        }
        throw new IllegalStateException();
    }
}
