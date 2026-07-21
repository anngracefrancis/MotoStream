package com.google.android.gms.internal.ads;

import android.os.Looper;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class zzjz {
    private final ExecutorService a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private l00 f16387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16388c;

    public zzjz(String str) {
        this.a = zzkq.e(str);
    }

    static /* synthetic */ l00 c(zzjz zzjzVar, l00 l00Var) {
        zzjzVar.f16387b = null;
        return null;
    }

    static /* synthetic */ boolean e(zzjz zzjzVar, boolean z) {
        zzjzVar.f16388c = false;
        return false;
    }

    public final boolean a() {
        return this.f16388c;
    }

    public final void b() {
        if (this.f16388c) {
            f();
        }
        this.a.shutdown();
    }

    public final void d(zzkc zzkcVar, zzka zzkaVar) {
        Looper looperMyLooper = Looper.myLooper();
        zzkh.d(looperMyLooper != null);
        zzkh.d(!this.f16388c);
        this.f16388c = true;
        l00 l00Var = new l00(this, looperMyLooper, zzkcVar, zzkaVar, 0);
        this.f16387b = l00Var;
        this.a.submit(l00Var);
    }

    public final void f() {
        zzkh.d(this.f16388c);
        this.f16387b.a();
    }
}
