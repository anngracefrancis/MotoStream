package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class m2 implements d3 {
    private static final m2 a = new m2();

    private m2() {
    }

    public static m2 c() {
        return a;
    }

    @Override // com.google.android.gms.internal.measurement.d3
    public final boolean a(Class<?> cls) {
        return zzfd.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.d3
    public final e3 b(Class<?> cls) {
        if (!zzfd.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (e3) zzfd.m(cls.asSubclass(zzfd.class)).p(zzfd.zze.f17398c, null, null);
        } catch (Exception e2) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e2);
        }
    }
}
