package io.sentry.transport;

import io.sentry.h4;
import io.sentry.n1;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: ITransport.java */
/* JADX INFO: loaded from: classes2.dex */
public interface r extends Closeable {
    void V(h4 h4Var, n1 n1Var) throws IOException;

    void h(long j2);
}
