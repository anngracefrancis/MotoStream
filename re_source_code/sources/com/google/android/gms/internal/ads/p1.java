package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class p1 implements zzaho<zzalf> {
    private final /* synthetic */ zzdh a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzajw f13139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzazk f13140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzakh f13141d;

    p1(zzakh zzakhVar, zzdh zzdhVar, zzajw zzajwVar, zzazk zzazkVar) {
        this.f13141d = zzakhVar;
        this.a = zzdhVar;
        this.f13139b = zzajwVar;
        this.f13140c = zzazkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void a(zzalf zzalfVar, Map map) {
        synchronized (this.f13141d.a) {
            zzbad.h("JS Engine is requesting an update");
            if (this.f13141d.f13938h == 0) {
                zzbad.h("Starting reload.");
                this.f13141d.f13938h = 2;
                this.f13141d.c(this.a);
            }
            this.f13139b.i("/requestReload", (zzaho) this.f13140c.a());
        }
    }
}
