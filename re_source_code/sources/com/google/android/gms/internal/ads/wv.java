package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class wv {
    private static final uv a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final uv f13522b = new vv();

    static uv a() {
        return a;
    }

    static uv b() {
        return f13522b;
    }

    private static uv c() {
        try {
            return (uv) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
