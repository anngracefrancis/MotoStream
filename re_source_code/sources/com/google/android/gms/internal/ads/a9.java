package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: loaded from: classes2.dex */
final class a9 implements zzgq {
    private final /* synthetic */ zzbdq a;

    a9(zzbdq zzbdqVar) {
        this.a = zzbdqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void a(MediaCodec.CryptoException cryptoException) {
        this.a.L("CryptoError", cryptoException.getMessage());
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void c(String str, long j2, long j3) {
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void d(zzgv zzgvVar) {
        this.a.L("DecoderInitializationError", zzgvVar.getMessage());
    }

    @Override // com.google.android.gms.internal.ads.zzgq
    public final void f(zzhu zzhuVar) {
        this.a.L("AudioTrackInitializationError", zzhuVar.getMessage());
    }

    @Override // com.google.android.gms.internal.ads.zzgq
    public final void h(zzhv zzhvVar) {
        this.a.L("AudioTrackWriteError", zzhvVar.getMessage());
    }
}
