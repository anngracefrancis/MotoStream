package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
final class b60 extends h60<zzzf> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Context f12318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ String f12319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zzamp f12320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzyh f12321e;

    b60(zzyh zzyhVar, Context context, String str, zzamp zzampVar) {
        this.f12321e = zzyhVar;
        this.f12318b = context;
        this.f12319c = str;
        this.f12320d = zzampVar;
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzzf a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zza(ObjectWrapper.E0(this.f12318b), this.f12319c, this.f12320d, 15000000);
    }

    @Override // com.google.android.gms.internal.ads.h60
    protected final /* synthetic */ zzzf c() {
        zzyh.d(this.f12318b, "native_ad");
        return new zzabl();
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzzf d() throws RemoteException {
        return this.f12321e.f16995b.c(this.f12318b, this.f12319c, this.f12320d);
    }
}
