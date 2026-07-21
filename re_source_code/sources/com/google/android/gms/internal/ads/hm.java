package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
final class hm extends zzatl {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbsv f12717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzbri f12718g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzbse f12719h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzbvj f12720i;

    hm(zzcnw zzcnwVar, zzbsv zzbsvVar, zzbri zzbriVar, zzbse zzbseVar, zzbvj zzbvjVar) {
        this.f12717f = zzbsvVar;
        this.f12718g = zzbriVar;
        this.f12719h = zzbseVar;
        this.f12720i = zzbvjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void F1(IObjectWrapper iObjectWrapper, int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void G6(IObjectWrapper iObjectWrapper) {
        this.f12718g.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void Y3(IObjectWrapper iObjectWrapper, zzato zzatoVar) {
        this.f12720i.P(zzatoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void Y5(IObjectWrapper iObjectWrapper) {
        this.f12717f.zzsz();
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void a2(IObjectWrapper iObjectWrapper) {
        this.f12720i.r();
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void b5(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.f12719h.i0();
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void c3(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void e4(IObjectWrapper iObjectWrapper) {
        this.f12719h.f0();
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void f1(IObjectWrapper iObjectWrapper) {
        this.f12717f.zzta();
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void q2(IObjectWrapper iObjectWrapper, int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void w3(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzb(Bundle bundle) {
    }
}
