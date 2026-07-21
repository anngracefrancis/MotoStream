package j;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes3.dex */
final class p implements d0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InputStream f22858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e0 f22859g;

    public p(InputStream inputStream, e0 e0Var) {
        kotlin.jvm.internal.m.f(inputStream, "input");
        kotlin.jvm.internal.m.f(e0Var, "timeout");
        this.f22858f = inputStream;
        this.f22859g = e0Var;
    }

    @Override // j.d0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f22858f.close();
    }

    @Override // j.d0
    public long read(f fVar, long j2) throws IOException {
        kotlin.jvm.internal.m.f(fVar, "sink");
        if (j2 == 0) {
            return 0L;
        }
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        try {
            this.f22859g.throwIfReached();
            y yVarQ0 = fVar.q0(1);
            int i2 = this.f22858f.read(yVarQ0.f22878b, yVarQ0.f22880d, (int) Math.min(j2, 8192 - yVarQ0.f22880d));
            if (i2 != -1) {
                yVarQ0.f22880d += i2;
                long j3 = i2;
                fVar.f0(fVar.size() + j3);
                return j3;
            }
            if (yVarQ0.f22879c != yVarQ0.f22880d) {
                return -1L;
            }
            fVar.f22831f = yVarQ0.b();
            z.b(yVarQ0);
            return -1L;
        } catch (AssertionError e2) {
            if (q.e(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        }
    }

    @Override // j.d0
    public e0 timeout() {
        return this.f22859g;
    }

    public String toString() {
        return "source(" + this.f22858f + ')';
    }
}
