package io.sentry;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: NoOpEnvelopeReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x2 implements s1 {
    private static final x2 a = new x2();

    private x2() {
    }

    public static x2 b() {
        return a;
    }

    @Override // io.sentry.s1
    public h4 a(InputStream inputStream) throws IOException {
        return null;
    }
}
