package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbh extends zzdsr {
    private ByteBuffer q;

    public zzbh(String str) {
        super(str);
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public final void e(ByteBuffer byteBuffer) {
        this.q = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }
}
