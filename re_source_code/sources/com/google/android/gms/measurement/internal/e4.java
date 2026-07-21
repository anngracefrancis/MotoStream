package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class e4 implements Callable<List<zzv>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f17741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17742g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f17743h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzgc f17744i;

    e4(zzgc zzgcVar, zzm zzmVar, String str, String str2) {
        this.f17744i = zzgcVar;
        this.f17741f = zzmVar;
        this.f17742g = str;
        this.f17743h = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzv> call() throws Exception {
        this.f17744i.f18163f.e0();
        return this.f17744i.f18163f.W().k0(this.f17741f.f18234f, this.f17742g, this.f17743h);
    }
}
