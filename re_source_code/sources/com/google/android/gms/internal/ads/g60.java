package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
final class g60 extends h60<zzatt> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Context f12630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f12631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzamp f12632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzyh f12633e;

    g60(zzyh zzyhVar, Context context, String str, zzamp zzampVar) {
        this.f12633e = zzyhVar;
        this.f12630b = context;
        this.f12631c = str;
        this.f12632d = zzampVar;
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzatt a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zzb(ObjectWrapper.E0(this.f12630b), this.f12631c, this.f12632d, 15000000);
    }

    @Override // com.google.android.gms.internal.ads.h60
    protected final /* synthetic */ zzatt c() {
        zzyh.d(this.f12630b, "rewarded");
        return new zzabv();
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzatt d() throws RemoteException {
        return zzauj.a(this.f12630b, this.f12631c, this.f12632d);
    }
}
