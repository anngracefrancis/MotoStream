package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class fv implements yv {
    private static final fv a = new fv();

    private fv() {
    }

    public static fv c() {
        return a;
    }

    @Override // com.google.android.gms.internal.ads.yv
    public final xv a(Class<?> cls) {
        if (!zzdob.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (xv) zzdob.w(cls.asSubclass(zzdob.class)).q(zzdob.zze.f16023c, null, null);
        } catch (Exception e2) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.yv
    public final boolean b(Class<?> cls) {
        return zzdob.class.isAssignableFrom(cls);
    }
}
