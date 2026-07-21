package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
final class c60 extends h60<zzaab> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Context f12401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzyh f12402c;

    c60(zzyh zzyhVar, Context context) {
        this.f12402c = zzyhVar;
        this.f12401b = context;
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzaab a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zza(ObjectWrapper.E0(this.f12401b), 15000000);
    }

    @Override // com.google.android.gms.internal.ads.h60
    protected final /* synthetic */ zzaab c() {
        zzyh.d(this.f12401b, "mobile_ads_settings");
        return new zzabr();
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzaab d() throws RemoteException {
        return this.f12402c.f16996c.c(this.f12401b);
    }
}
