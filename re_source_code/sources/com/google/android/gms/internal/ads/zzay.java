package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzay implements zzba {
    private static Logger a = Logger.getLogger(zzay.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ThreadLocal<ByteBuffer> f14262b = new z5(this);

    @Override // com.google.android.gms.internal.ads.zzba
    public final zzbd a(zzdsw zzdswVar, zzbe zzbeVar) throws IOException {
        int i2;
        long size;
        long jK0 = zzdswVar.k0();
        this.f14262b.get().rewind().limit(8);
        do {
            i2 = zzdswVar.read(this.f14262b.get());
            if (i2 == 8) {
                this.f14262b.get().rewind();
                long jB = zzbc.b(this.f14262b.get());
                byte[] bArr = null;
                if (jB < 8 && jB > 1) {
                    Logger logger = a;
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(jB);
                    sb.append("). Stop parsing!");
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
                String strG = zzbc.g(this.f14262b.get());
                if (jB == 1) {
                    this.f14262b.get().limit(16);
                    zzdswVar.read(this.f14262b.get());
                    this.f14262b.get().position(8);
                    size = zzbc.d(this.f14262b.get()) - 16;
                } else {
                    size = jB == 0 ? zzdswVar.size() - zzdswVar.k0() : jB - 8;
                }
                if ("uuid".equals(strG)) {
                    this.f14262b.get().limit(this.f14262b.get().limit() + 16);
                    zzdswVar.read(this.f14262b.get());
                    bArr = new byte[16];
                    for (int iPosition = this.f14262b.get().position() - 16; iPosition < this.f14262b.get().position(); iPosition++) {
                        bArr[iPosition - (this.f14262b.get().position() - 16)] = this.f14262b.get().get(iPosition);
                    }
                    size -= 16;
                }
                long j2 = size;
                zzbd zzbdVarB = b(strG, bArr, zzbeVar instanceof zzbd ? ((zzbd) zzbeVar).getType() : HttpUrl.FRAGMENT_ENCODE_SET);
                zzbdVarB.c(zzbeVar);
                this.f14262b.get().rewind();
                zzbdVarB.b(zzdswVar, this.f14262b.get(), j2, this);
                return zzbdVarB;
            }
        } while (i2 >= 0);
        zzdswVar.d1(jK0);
        throw new EOFException();
    }

    public abstract zzbd b(String str, byte[] bArr, String str2);
}
