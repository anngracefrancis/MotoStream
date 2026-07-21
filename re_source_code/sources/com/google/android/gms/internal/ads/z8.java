package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.view.Surface;

/* JADX INFO: loaded from: classes2.dex */
final class z8 implements zzhh {
    private final /* synthetic */ zzbdq a;

    z8(zzbdq zzbdqVar) {
        this.a = zzbdqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void a(MediaCodec.CryptoException cryptoException) {
        this.a.L("CryptoError", cryptoException.getMessage());
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void b(int i2, long j2) {
        StringBuilder sb = new StringBuilder(64);
        sb.append("Dropped frames. Count: ");
        sb.append(i2);
        sb.append(" Elapsed: ");
        sb.append(j2);
        zzbad.e(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void c(String str, long j2, long j3) {
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void d(zzgv zzgvVar) {
        this.a.L("DecoderInitializationError", zzgvVar.getMessage());
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void e(int i2, int i3, float f2) {
        this.a.B = i2;
        this.a.C = i3;
        this.a.D = f2;
        zzbdq zzbdqVar = this.a;
        zzbdqVar.A(zzbdqVar.B, this.a.C, this.a.D);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void g(Surface surface) {
    }
}
