package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class z5 extends ThreadLocal<ByteBuffer> {
    z5(zzay zzayVar) {
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ ByteBuffer initialValue() {
        return ByteBuffer.allocate(32);
    }
}
