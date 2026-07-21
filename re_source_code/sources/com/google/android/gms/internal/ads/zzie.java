package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface zzie {
    void a(int i2) throws InterruptedException, IOException;

    boolean b(byte[] bArr, int i2, int i3, boolean z) throws InterruptedException, IOException;

    long getPosition();

    void readFully(byte[] bArr, int i2, int i3) throws InterruptedException, IOException;
}
