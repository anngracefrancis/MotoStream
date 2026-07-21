package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class b3 {
    private static final a3 a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a3 f17133b = new c3();

    static a3 a() {
        return a;
    }

    static a3 b() {
        return f17133b;
    }

    private static a3 c() {
        try {
            return (a3) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
