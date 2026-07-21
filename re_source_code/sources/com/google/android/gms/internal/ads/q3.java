package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class q3 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbah f13216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f13217g;

    q3(zzaqx zzaqxVar, zzbah zzbahVar, String str) {
        this.f13216f = zzbahVar;
        this.f13217g = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13216f.a(this.f13217g);
    }
}
