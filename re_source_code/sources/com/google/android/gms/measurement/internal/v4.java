package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class v4 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f17989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f17991h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ Bundle f17992i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f17993j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ boolean f17994k;
    private final /* synthetic */ boolean l;
    private final /* synthetic */ String m;
    private final /* synthetic */ zzhc n;

    v4(zzhc zzhcVar, String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.n = zzhcVar;
        this.f17989f = str;
        this.f17990g = str2;
        this.f17991h = j2;
        this.f17992i = bundle;
        this.f17993j = z;
        this.f17994k = z2;
        this.l = z3;
        this.m = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.Q(this.f17989f, this.f17990g, this.f17991h, this.f17992i, this.f17993j, this.f17994k, this.l, this.m);
    }
}
