package j;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: Source.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface d0 extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(f fVar, long j2) throws IOException;

    e0 timeout();
}
