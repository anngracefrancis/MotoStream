package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface zzno {
    void a(int i2) throws InterruptedException, IOException;

    boolean b(byte[] bArr, int i2, int i3, boolean z) throws InterruptedException, IOException;

    void c();

    void d(byte[] bArr, int i2, int i3) throws InterruptedException, IOException;

    int e(int i2) throws InterruptedException, IOException;

    long f();

    void g(int i2) throws InterruptedException, IOException;

    long getPosition();

    int read(byte[] bArr, int i2, int i3) throws InterruptedException, IOException;

    void readFully(byte[] bArr, int i2, int i3) throws InterruptedException, IOException;
}
