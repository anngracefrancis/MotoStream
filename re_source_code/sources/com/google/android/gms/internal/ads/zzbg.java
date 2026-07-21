package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbg extends zzdst {
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private Date s;
    private Date t;
    private long u;
    private long v;
    private double w;
    private float x;
    private zzdtd y;
    private long z;

    public zzbg() {
        super("mvhd");
        this.w = 1.0d;
        this.x = 1.0f;
        this.y = zzdtd.a;
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public final void e(ByteBuffer byteBuffer) {
        g(byteBuffer);
        if (f() == 1) {
            this.s = zzdsy.a(zzbc.d(byteBuffer));
            this.t = zzdsy.a(zzbc.d(byteBuffer));
            this.u = zzbc.b(byteBuffer);
            this.v = zzbc.d(byteBuffer);
        } else {
            this.s = zzdsy.a(zzbc.b(byteBuffer));
            this.t = zzdsy.a(zzbc.b(byteBuffer));
            this.u = zzbc.b(byteBuffer);
            this.v = zzbc.b(byteBuffer);
        }
        this.w = zzbc.e(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.x = ((short) ((bArr[1] & 255) | ((short) (0 | ((bArr[0] << 8) & 65280))))) / 256.0f;
        zzbc.c(byteBuffer);
        zzbc.b(byteBuffer);
        zzbc.b(byteBuffer);
        this.y = zzdtd.a(byteBuffer);
        this.A = byteBuffer.getInt();
        this.B = byteBuffer.getInt();
        this.C = byteBuffer.getInt();
        this.D = byteBuffer.getInt();
        this.E = byteBuffer.getInt();
        this.F = byteBuffer.getInt();
        this.z = zzbc.b(byteBuffer);
    }

    public final long h() {
        return this.v;
    }

    public final long i() {
        return this.u;
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.s + ";modificationTime=" + this.t + ";timescale=" + this.u + ";duration=" + this.v + ";rate=" + this.w + ";volume=" + this.x + ";matrix=" + this.y + ";nextTrackId=" + this.z + "]";
    }
}
