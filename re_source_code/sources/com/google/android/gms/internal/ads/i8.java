package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
final class i8 implements zzgq {
    private WeakReference<zzgq> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbdk f12748b;

    private i8(zzbdk zzbdkVar) {
        this.f12748b = zzbdkVar;
        this.a = new WeakReference<>(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void a(MediaCodec.CryptoException cryptoException) {
        this.f12748b.f("CryptoError", cryptoException.getMessage());
        zzgq zzgqVar = this.a.get();
        if (zzgqVar != null) {
            zzgqVar.a(cryptoException);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void c(String str, long j2, long j3) {
        zzgq zzgqVar = this.a.get();
        if (zzgqVar != null) {
            zzgqVar.c(str, j2, j3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void d(zzgv zzgvVar) {
        this.f12748b.f("DecoderInitializationError", zzgvVar.getMessage());
        zzgq zzgqVar = this.a.get();
        if (zzgqVar != null) {
            zzgqVar.d(zzgvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgq
    public final void f(zzhu zzhuVar) {
        this.f12748b.f("AudioTrackInitializationError", zzhuVar.getMessage());
        zzgq zzgqVar = this.a.get();
        if (zzgqVar != null) {
            zzgqVar.f(zzhuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgq
    public final void h(zzhv zzhvVar) {
        this.f12748b.f("AudioTrackWriteError", zzhvVar.getMessage());
        zzgq zzgqVar = this.a.get();
        if (zzgqVar != null) {
            zzgqVar.h(zzhvVar);
        }
    }

    public final void i(zzgq zzgqVar) {
        this.a = new WeakReference<>(zzgqVar);
    }
}
