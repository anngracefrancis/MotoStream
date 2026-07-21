package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzbfl {
    private long a;

    public final long a(ByteBuffer byteBuffer) {
        zzbg zzbgVar;
        zzbf zzbfVar;
        long j2 = this.a;
        if (j2 > 0) {
            return j2;
        }
        try {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.flip();
            Iterator<zzbd> it = new zzbb(new w9(byteBufferDuplicate), x9.f13566c).e().iterator();
            while (true) {
                zzbgVar = null;
                if (!it.hasNext()) {
                    zzbfVar = null;
                    break;
                }
                zzbd next = it.next();
                if (next instanceof zzbf) {
                    zzbfVar = (zzbf) next;
                    break;
                }
            }
            for (zzbd zzbdVar : zzbfVar.e()) {
                if (zzbdVar instanceof zzbg) {
                    zzbgVar = (zzbg) zzbdVar;
                    break;
                }
            }
            long jH = (zzbgVar.h() * 1000) / zzbgVar.i();
            this.a = jH;
            return jH;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
