package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface zzdsw extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void d1(long j2) throws IOException;

    long k0() throws IOException;

    ByteBuffer r(long j2, long j3) throws IOException;

    int read(ByteBuffer byteBuffer) throws IOException;

    long size() throws IOException;
}
