package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class b5 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f17702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17703g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f17704h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ String f17705i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzhc f17706j;

    b5(zzhc zzhcVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f17706j = zzhcVar;
        this.f17702f = atomicReference;
        this.f17703g = str;
        this.f17704h = str2;
        this.f17705i = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17706j.a.R().T(this.f17702f, this.f17703g, this.f17704h, this.f17705i);
    }
}
