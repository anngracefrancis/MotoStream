package com.facebook.login;

import java.util.Arrays;

/* JADX INFO: compiled from: LoginBehavior.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum t {
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true, true),
    NATIVE_ONLY(true, true, false, false, false, true, true),
    KATANA_ONLY(false, true, false, false, false, false, false),
    WEB_ONLY(false, false, true, false, true, false, false),
    DIALOG_ONLY(false, true, true, false, true, true, true),
    DEVICE_AUTH(false, false, false, true, false, false, false);

    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;

    t(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.m = z;
        this.n = z2;
        this.o = z3;
        this.p = z4;
        this.q = z5;
        this.r = z6;
        this.s = z7;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static t[] valuesCustom() {
        t[] tVarArrValuesCustom = values();
        return (t[]) Arrays.copyOf(tVarArrValuesCustom, tVarArrValuesCustom.length);
    }

    public final boolean k() {
        return this.q;
    }

    public final boolean q() {
        return this.p;
    }

    public final boolean u() {
        return this.m;
    }

    public final boolean v() {
        return this.s;
    }

    public final boolean x() {
        return this.n;
    }

    public final boolean y() {
        return this.o;
    }
}
