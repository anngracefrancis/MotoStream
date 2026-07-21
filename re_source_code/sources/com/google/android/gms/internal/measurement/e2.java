package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class e2 {
    private static final d2<?> a = new f2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d2<?> f17148b = c();

    static d2<?> a() {
        return a;
    }

    static d2<?> b() {
        d2<?> d2Var = f17148b;
        if (d2Var != null) {
            return d2Var;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static d2<?> c() {
        try {
            return (d2) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
