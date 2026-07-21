package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzn;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class h6 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f17806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzm f17808h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzn f17809i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzik f17810j;

    h6(zzik zzikVar, String str, String str2, zzm zzmVar, zzn zznVar) {
        this.f17810j = zzikVar;
        this.f17806f = str;
        this.f17807g = str2;
        this.f17808h = zzmVar;
        this.f17809i = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            try {
                zzel zzelVar = this.f17810j.f18193d;
                if (zzelVar == null) {
                    this.f17810j.h().H().c("Failed to get conditional properties", this.f17806f, this.f17807g);
                    this.f17810j.l().Q(this.f17809i, arrayList);
                } else {
                    ArrayList<Bundle> arrayListL0 = zzkk.l0(zzelVar.A2(this.f17806f, this.f17807g, this.f17808h));
                    this.f17810j.d0();
                    this.f17810j.l().Q(this.f17809i, arrayListL0);
                }
            } catch (RemoteException e2) {
                this.f17810j.h().H().d("Failed to get conditional properties", this.f17806f, this.f17807g, e2);
                this.f17810j.l().Q(this.f17809i, arrayList);
            }
        } catch (Throwable th) {
            this.f17810j.l().Q(this.f17809i, arrayList);
            throw th;
        }
    }
}
