package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public final class zzgn extends zzgr {
    private final zzgq G;
    private final zzhq H;
    private int I;
    private long J;

    public zzgn(zzhn zzhnVar, Handler handler, zzgq zzgqVar) {
        this(zzhnVar, null, true, handler, zzgqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final void A(zzhj zzhjVar, MediaFormat mediaFormat) {
        if (zzkl.c(zzhjVar.a)) {
            this.H.h(zzhjVar.i(), 0);
        } else {
            this.H.h(mediaFormat, 0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final boolean C(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i2, boolean z) throws zzgd {
        if (z) {
            mediaCodec.releaseOutputBuffer(i2, false);
            this.f16252b.f16232f++;
            this.H.l();
            return true;
        }
        if (!this.H.a()) {
            try {
                int i3 = this.I;
                if (i3 != 0) {
                    this.H.q(i3);
                } else {
                    this.I = this.H.q(0);
                }
                if (c() == 3) {
                    this.H.c();
                }
            } catch (zzhu e2) {
                Handler handler = this.f16261k;
                if (handler != null && this.G != null) {
                    handler.post(new az(this, e2));
                }
                throw new zzgd(e2);
            }
        }
        try {
            int iF = this.H.f(byteBuffer, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs);
            if ((iF & 1) != 0) {
                this.J = Long.MIN_VALUE;
            }
            if ((iF & 2) == 0) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i2, false);
            this.f16252b.f16231e++;
            return true;
        } catch (zzhv e3) {
            Handler handler2 = this.f16261k;
            if (handler2 != null && this.G != null) {
                handler2.post(new bz(this, e3));
            }
            throw new zzgd(e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final boolean E(String str) {
        return zzkl.b(str) && super.E(str);
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final zzgc F(String str, boolean z) throws zzgz {
        return zzkl.c(str) ? new zzgc("OMX.google.raw.decoder", true) : super.F(str, z);
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final boolean d() {
        if (this.H.m()) {
            return true;
        }
        return super.d() && M() == 2;
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final void e() {
        super.e();
        this.H.c();
    }

    @Override // com.google.android.gms.internal.ads.zzhp, com.google.android.gms.internal.ads.zzgf
    public final void f(int i2, Object obj) throws zzgd {
        if (i2 == 1) {
            this.H.e(((Float) obj).floatValue());
        } else {
            super.f(i2, obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final void g() {
        this.H.b();
        super.g();
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final void i(long j2) throws zzgd {
        super.i(j2);
        this.H.d();
        this.J = Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final void m(long j2, boolean z) {
        super.m(j2, z);
        this.J = Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    protected final boolean r() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final boolean s() {
        if (super.s()) {
            return (this.H.m() && this.H.n()) ? false : true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final long t() {
        long jP = this.H.p(s());
        if (jP == Long.MIN_VALUE) {
            this.J = Math.max(this.J, super.t());
        } else {
            this.J = Math.max(this.J, jP);
        }
        return this.J;
    }

    @Override // com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzhp
    protected final void u() {
        this.I = 0;
        try {
            this.H.d();
        } finally {
            super.u();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgr
    protected final void y(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, MediaCrypto mediaCrypto) {
        if (!"OMX.google.raw.decoder".equals(str)) {
            mediaCodec.configure(mediaFormat, (Surface) null, mediaCrypto, 0);
            return;
        }
        String string = mediaFormat.getString("mime");
        mediaFormat.setString("mime", "audio/raw");
        mediaCodec.configure(mediaFormat, (Surface) null, mediaCrypto, 0);
        mediaFormat.setString("mime", string);
    }

    private zzgn(zzhn zzhnVar, zzhz zzhzVar, boolean z, Handler handler, zzgq zzgqVar) {
        super(zzhnVar, null, true, handler, zzgqVar);
        this.G = zzgqVar;
        this.I = 0;
        this.H = new zzhq();
    }
}
