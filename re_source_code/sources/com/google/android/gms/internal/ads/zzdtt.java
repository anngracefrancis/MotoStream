package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdtt<T> implements zzdtu<T> {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile zzdtu<T> f16175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Object f16176c = a;

    private zzdtt(zzdtu<T> zzdtuVar) {
        this.f16175b = zzdtuVar;
    }

    public static <P extends zzdtu<T>, T> zzdtu<T> a(P p) {
        return ((p instanceof zzdtt) || (p instanceof zzdth)) ? p : new zzdtt((zzdtu) zzdto.a(p));
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final T get() {
        T t = (T) this.f16176c;
        if (t != a) {
            return t;
        }
        zzdtu<T> zzdtuVar = this.f16175b;
        if (zzdtuVar == null) {
            return (T) this.f16176c;
        }
        T t2 = zzdtuVar.get();
        this.f16176c = t2;
        this.f16175b = null;
        return t2;
    }
}
