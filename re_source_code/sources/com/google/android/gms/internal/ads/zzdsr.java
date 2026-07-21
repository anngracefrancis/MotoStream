package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdsr implements zzbd {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static zzdtc f16143f = zzdtc.b(zzdsr.class);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f16144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzbe f16145h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ByteBuffer f16148k;
    private long l;
    private long m;
    private zzdsw o;
    private long n = -1;
    private ByteBuffer p = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f16147j = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f16146i = true;

    protected zzdsr(String str) {
        this.f16144g = str;
    }

    private final synchronized void a() {
        if (!this.f16147j) {
            try {
                zzdtc zzdtcVar = f16143f;
                String strValueOf = String.valueOf(this.f16144g);
                zzdtcVar.a(strValueOf.length() != 0 ? "mem mapping ".concat(strValueOf) : new String("mem mapping "));
                this.f16148k = this.o.r(this.l, this.n);
                this.f16147j = true;
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbd
    public final void b(zzdsw zzdswVar, ByteBuffer byteBuffer, long j2, zzba zzbaVar) throws IOException {
        long jK0 = zzdswVar.k0();
        this.l = jK0;
        this.m = jK0 - ((long) byteBuffer.remaining());
        this.n = j2;
        this.o = zzdswVar;
        zzdswVar.d1(zzdswVar.k0() + j2);
        this.f16147j = false;
        this.f16146i = false;
        d();
    }

    @Override // com.google.android.gms.internal.ads.zzbd
    public final void c(zzbe zzbeVar) {
        this.f16145h = zzbeVar;
    }

    public final synchronized void d() {
        a();
        zzdtc zzdtcVar = f16143f;
        String strValueOf = String.valueOf(this.f16144g);
        zzdtcVar.a(strValueOf.length() != 0 ? "parsing details of ".concat(strValueOf) : new String("parsing details of "));
        ByteBuffer byteBuffer = this.f16148k;
        if (byteBuffer != null) {
            this.f16146i = true;
            byteBuffer.rewind();
            e(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.p = byteBuffer.slice();
            }
            this.f16148k = null;
        }
    }

    protected abstract void e(ByteBuffer byteBuffer);

    @Override // com.google.android.gms.internal.ads.zzbd
    public final String getType() {
        return this.f16144g;
    }
}
