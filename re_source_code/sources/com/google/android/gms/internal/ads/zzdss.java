package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class zzdss extends zzdsu implements zzbd {
    private zzbe o;
    private String p;
    private boolean q;
    private long r;

    public zzdss(String str) {
        this.p = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbd
    public final void b(zzdsw zzdswVar, ByteBuffer byteBuffer, long j2, zzba zzbaVar) throws IOException {
        this.r = zzdswVar.k0() - ((long) byteBuffer.remaining());
        this.q = byteBuffer.remaining() == 16;
        d(zzdswVar, j2, zzbaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbd
    public final void c(zzbe zzbeVar) {
        this.o = zzbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdsu
    public final void d(zzdsw zzdswVar, long j2, zzba zzbaVar) throws IOException {
        this.f16152i = zzdswVar;
        long jK0 = zzdswVar.k0();
        this.f16154k = jK0;
        this.l = jK0 - ((long) ((this.q || 8 + j2 >= 4294967296L) ? 16 : 8));
        zzdswVar.d1(zzdswVar.k0() + j2);
        this.m = zzdswVar.k0();
        this.f16151h = zzbaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbd
    public final String getType() {
        return this.p;
    }
}
