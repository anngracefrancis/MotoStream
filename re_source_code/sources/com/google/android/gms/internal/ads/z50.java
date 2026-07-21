package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
final class z50 extends h60<zzzk> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Context f13683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzyd f13684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f13685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzyh f13686e;

    z50(zzyh zzyhVar, Context context, zzyd zzydVar, String str) {
        this.f13686e = zzyhVar;
        this.f13683b = context;
        this.f13684c = zzydVar;
        this.f13685d = str;
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzzk a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zza(ObjectWrapper.E0(this.f13683b), this.f13684c, this.f13685d, 15000000);
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzzk c() {
        zzyh.d(this.f13683b, "search");
        return new zzabp();
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzzk d() throws RemoteException {
        return this.f13686e.a.c(this.f13683b, this.f13684c, this.f13685d, null, 3);
    }
}
