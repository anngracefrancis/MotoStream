package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes2.dex */
final class v3 extends FilterInputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HttpURLConnection f13436f;

    v3(HttpURLConnection httpURLConnection) {
        super(zzat.c(httpURLConnection));
        this.f13436f = httpURLConnection;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        this.f13436f.disconnect();
    }
}
