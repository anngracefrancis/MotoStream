package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class s1 implements zzbbv<zzajw> {
    private final /* synthetic */ zzala a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzakh f13302b;

    s1(zzakh zzakhVar, zzala zzalaVar) {
        this.f13302b = zzakhVar;
        this.a = zzalaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbv
    public final /* synthetic */ void a(zzajw zzajwVar) {
        synchronized (this.f13302b.a) {
            this.f13302b.f13938h = 0;
            if (this.f13302b.f13937g != null && this.a != this.f13302b.f13937g) {
                zzawz.m("New JS engine is loaded, marking previous one as destroyable.");
                this.f13302b.f13937g.i();
            }
            this.f13302b.f13937g = this.a;
        }
    }
}
