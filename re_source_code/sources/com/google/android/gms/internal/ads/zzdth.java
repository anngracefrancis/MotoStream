package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdth<T> implements zzdte<T>, zzdtu<T> {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile zzdtu<T> f16168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Object f16169c = a;

    private zzdth(zzdtu<T> zzdtuVar) {
        this.f16168b = zzdtuVar;
    }

    public static <P extends zzdtu<T>, T> zzdtu<T> a(P p) {
        zzdto.a(p);
        return p instanceof zzdth ? p : new zzdth(p);
    }

    public static <P extends zzdtu<T>, T> zzdte<T> b(P p) {
        return p instanceof zzdte ? (zzdte) p : new zzdth((zzdtu) zzdto.a(p));
    }

    @Override // com.google.android.gms.internal.ads.zzdte, com.google.android.gms.internal.ads.zzdtu
    public final T get() {
        T t = (T) this.f16169c;
        Object obj = a;
        if (t == obj) {
            synchronized (this) {
                t = (T) this.f16169c;
                if (t == obj) {
                    t = this.f16168b.get();
                    Object obj2 = this.f16169c;
                    if (((obj2 == obj || (obj2 instanceof zzdtn)) ? false : true) && obj2 != t) {
                        String strValueOf = String.valueOf(obj2);
                        String strValueOf2 = String.valueOf(t);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 118 + strValueOf2.length());
                        sb.append("Scoped provider was invoked recursively returning different results: ");
                        sb.append(strValueOf);
                        sb.append(" & ");
                        sb.append(strValueOf2);
                        sb.append(". This is likely due to a circular dependency.");
                        throw new IllegalStateException(sb.toString());
                    }
                    this.f16169c = t;
                    this.f16168b = null;
                }
            }
        }
        return t;
    }
}
