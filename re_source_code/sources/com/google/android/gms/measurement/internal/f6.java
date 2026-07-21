package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class f6 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f17759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ boolean f17760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzv f17761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzm f17762i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzv f17763j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzik f17764k;

    f6(zzik zzikVar, boolean z, boolean z2, zzv zzvVar, zzm zzmVar, zzv zzvVar2) {
        this.f17764k = zzikVar;
        this.f17759f = z;
        this.f17760g = z2;
        this.f17761h = zzvVar;
        this.f17762i = zzmVar;
        this.f17763j = zzvVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar = this.f17764k.f18193d;
        if (zzelVar == null) {
            this.f17764k.h().H().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f17759f) {
            this.f17764k.M(zzelVar, this.f17760g ? null : this.f17761h, this.f17762i);
        } else {
            try {
                if (TextUtils.isEmpty(this.f17763j.f18240f)) {
                    zzelVar.h2(this.f17761h, this.f17762i);
                } else {
                    zzelVar.R6(this.f17761h);
                }
            } catch (RemoteException e2) {
                this.f17764k.h().H().b("Failed to send conditional user property to the service", e2);
            }
        }
        this.f17764k.d0();
    }
}
