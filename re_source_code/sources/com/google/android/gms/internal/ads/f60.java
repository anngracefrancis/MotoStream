package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
final class f60 extends h60<zzasw> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Context f12567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzamp f12568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzyh f12569d;

    f60(zzyh zzyhVar, Context context, zzamp zzampVar) {
        this.f12569d = zzyhVar;
        this.f12567b = context;
        this.f12568c = zzampVar;
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzasw a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zza(ObjectWrapper.E0(this.f12567b), this.f12568c, 15000000);
    }

    @Override // com.google.android.gms.internal.ads.h60
    protected final /* synthetic */ zzasw c() {
        zzyh.d(this.f12567b, "rewarded_video");
        return new zzabx();
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzasw d() throws RemoteException {
        return this.f12569d.f16998e.c(this.f12567b, this.f12568c);
    }
}
