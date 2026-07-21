package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class ew {
    private static final cw a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final cw f12543b = new dw();

    static cw a() {
        return a;
    }

    static cw b() {
        return f12543b;
    }

    private static cw c() {
        try {
            return (cw) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
