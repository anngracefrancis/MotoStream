package j;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* JADX INFO: compiled from: Sink.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b0 extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    @Override // java.io.Flushable
    void flush() throws IOException;

    e0 timeout();

    void write(f fVar, long j2) throws IOException;
}
