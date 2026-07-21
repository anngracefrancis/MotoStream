package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzchy extends zzars {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzchx f15262f;

    protected zzchy(zzchx zzchxVar) {
        this.f15262f = zzchxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzarr
    public final void K5(zzaym zzaymVar) {
        this.f15262f.f15256f.c(new zzayn(zzaymVar.f14279f, zzaymVar.f14280g));
    }

    @Override // com.google.android.gms.internal.ads.zzarr
    public final void V0(ParcelFileDescriptor parcelFileDescriptor) {
        this.f15262f.f15256f.a(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }
}
