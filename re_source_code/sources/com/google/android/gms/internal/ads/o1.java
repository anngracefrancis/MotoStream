package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class o1 implements zzaho<zzalf> {
    private final /* synthetic */ zzala a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzajw f13073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzakh f13074c;

    o1(zzakh zzakhVar, zzala zzalaVar, zzajw zzajwVar) {
        this.f13074c = zzakhVar;
        this.a = zzalaVar;
        this.f13073b = zzajwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void a(zzalf zzalfVar, Map map) {
        synchronized (this.f13074c.a) {
            if (this.a.a() != -1 && this.a.a() != 1) {
                this.f13074c.f13938h = 0;
                this.f13074c.f13935e.a(this.f13073b);
                this.a.e(this.f13073b);
                this.f13074c.f13937g = this.a;
                zzawz.m("Successfully loaded JS Engine.");
            }
        }
    }
}
