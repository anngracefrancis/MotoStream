package com.facebook.internal;

/* JADX INFO: compiled from: InternalSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h0 {
    public static final h0 a = new h0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f9778b;

    private h0() {
    }

    public static final String a() {
        return f9778b;
    }

    public static final boolean b() {
        String str = f9778b;
        return kotlin.jvm.internal.m.a(str != null ? Boolean.valueOf(kotlin.text.u.E(str, "Unity.", false, 2, null)) : null, Boolean.TRUE);
    }
}
