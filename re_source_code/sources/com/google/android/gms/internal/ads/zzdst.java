package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdst extends zzdsr implements zzbd {
    private int q;
    private int r;

    protected zzdst(String str) {
        super(str);
    }

    public final int f() {
        if (!this.f16146i) {
            d();
        }
        return this.q;
    }

    protected final long g(ByteBuffer byteBuffer) {
        this.q = zzbc.a(byteBuffer.get());
        this.r = (zzbc.c(byteBuffer) << 8) + 0 + zzbc.a(byteBuffer.get());
        return 4L;
    }
}
