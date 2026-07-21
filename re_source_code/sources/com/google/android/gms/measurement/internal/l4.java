package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class l4 implements Callable<byte[]> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzan f17848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17849g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzgc f17850h;

    l4(zzgc zzgcVar, zzan zzanVar, String str) {
        this.f17850h = zzgcVar;
        this.f17848f = zzanVar;
        this.f17849g = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() throws Exception {
        this.f17850h.f18163f.e0();
        return this.f17850h.f18163f.Y().w(this.f17848f, this.f17849g);
    }
}
