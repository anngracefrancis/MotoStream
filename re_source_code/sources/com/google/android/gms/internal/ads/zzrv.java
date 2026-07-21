package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface zzrv {
    Uri I0();

    long a(zzry zzryVar) throws IOException;

    void close() throws IOException;

    int read(byte[] bArr, int i2, int i3) throws IOException;
}
