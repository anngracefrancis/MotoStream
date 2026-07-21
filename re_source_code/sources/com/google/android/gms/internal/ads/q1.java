package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
final class q1 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzala f13210f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzajw f13211g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzakh f13212h;

    q1(zzakh zzakhVar, zzala zzalaVar, zzajw zzajwVar) {
        this.f13212h = zzakhVar;
        this.f13210f = zzalaVar;
        this.f13211g = zzajwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f13212h.a) {
            if (this.f13210f.a() != -1 && this.f13210f.a() != 1) {
                this.f13210f.b();
                Executor executor = zzbbm.a;
                zzajw zzajwVar = this.f13211g;
                zzajwVar.getClass();
                executor.execute(r1.a(zzajwVar));
                zzawz.m("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}
