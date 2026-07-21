package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class d5 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f17732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17733g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f17734h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ String f17735i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f17736j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzhc f17737k;

    d5(zzhc zzhcVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.f17737k = zzhcVar;
        this.f17732f = atomicReference;
        this.f17733g = str;
        this.f17734h = str2;
        this.f17735i = str3;
        this.f17736j = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17737k.a.R().U(this.f17732f, this.f17733g, this.f17734h, this.f17735i, this.f17736j);
    }
}
