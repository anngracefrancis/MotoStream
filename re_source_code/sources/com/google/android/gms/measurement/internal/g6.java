package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class g6 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f17773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ boolean f17774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzan f17775h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzm f17776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f17777j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzik f17778k;

    g6(zzik zzikVar, boolean z, boolean z2, zzan zzanVar, zzm zzmVar, String str) {
        this.f17778k = zzikVar;
        this.f17773f = z;
        this.f17774g = z2;
        this.f17775h = zzanVar;
        this.f17776i = zzmVar;
        this.f17777j = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar = this.f17778k.f18193d;
        if (zzelVar == null) {
            this.f17778k.h().H().a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f17773f) {
            this.f17778k.M(zzelVar, this.f17774g ? null : this.f17775h, this.f17776i);
        } else {
            try {
                if (TextUtils.isEmpty(this.f17777j)) {
                    zzelVar.Z5(this.f17775h, this.f17776i);
                } else {
                    zzelVar.j6(this.f17775h, this.f17777j, this.f17778k.h().Q());
                }
            } catch (RemoteException e2) {
                this.f17778k.h().H().b("Failed to send event to the service", e2);
            }
        }
        this.f17778k.d0();
    }
}
