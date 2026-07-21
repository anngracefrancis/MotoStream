package com.facebook.o0;

/* JADX INFO: compiled from: FlushStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f0 {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e0 f10124b = e0.SUCCESS;

    public final int a() {
        return this.a;
    }

    public final e0 b() {
        return this.f10124b;
    }

    public final void c(int i2) {
        this.a = i2;
    }

    public final void d(e0 e0Var) {
        kotlin.jvm.internal.m.f(e0Var, "<set-?>");
        this.f10124b = e0Var;
    }
}
