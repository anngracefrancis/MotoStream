package j;

import java.io.IOException;

/* JADX INFO: compiled from: ForwardingSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l implements d0 {
    private final d0 delegate;

    public l(d0 d0Var) {
        kotlin.jvm.internal.m.f(d0Var, "delegate");
        this.delegate = d0Var;
    }

    /* JADX INFO: renamed from: -deprecated_delegate, reason: not valid java name */
    public final d0 m375deprecated_delegate() {
        return this.delegate;
    }

    @Override // j.d0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final d0 delegate() {
        return this.delegate;
    }

    @Override // j.d0
    public long read(f fVar, long j2) throws IOException {
        kotlin.jvm.internal.m.f(fVar, "sink");
        return this.delegate.read(fVar, j2);
    }

    @Override // j.d0
    public e0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
