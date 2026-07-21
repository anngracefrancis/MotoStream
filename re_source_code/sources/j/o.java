package j;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: InflaterSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements d0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f22854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f22855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final h f22856h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Inflater f22857i;

    public o(h hVar, Inflater inflater) {
        kotlin.jvm.internal.m.f(hVar, "source");
        kotlin.jvm.internal.m.f(inflater, "inflater");
        this.f22856h = hVar;
        this.f22857i = inflater;
    }

    private final void c() throws IOException {
        int i2 = this.f22854f;
        if (i2 == 0) {
            return;
        }
        int remaining = i2 - this.f22857i.getRemaining();
        this.f22854f -= remaining;
        this.f22856h.skip(remaining);
    }

    public final long a(f fVar, long j2) throws IOException {
        kotlin.jvm.internal.m.f(fVar, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (!(!this.f22855g)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j2 == 0) {
            return 0L;
        }
        try {
            y yVarQ0 = fVar.q0(1);
            int iMin = (int) Math.min(j2, 8192 - yVarQ0.f22880d);
            b();
            int iInflate = this.f22857i.inflate(yVarQ0.f22878b, yVarQ0.f22880d, iMin);
            c();
            if (iInflate > 0) {
                yVarQ0.f22880d += iInflate;
                long j3 = iInflate;
                fVar.f0(fVar.size() + j3);
                return j3;
            }
            if (yVarQ0.f22879c == yVarQ0.f22880d) {
                fVar.f22831f = yVarQ0.b();
                z.b(yVarQ0);
            }
            return 0L;
        } catch (DataFormatException e2) {
            throw new IOException(e2);
        }
    }

    public final boolean b() throws IOException {
        if (!this.f22857i.needsInput()) {
            return false;
        }
        if (this.f22856h.R()) {
            return true;
        }
        y yVar = this.f22856h.i().f22831f;
        kotlin.jvm.internal.m.c(yVar);
        int i2 = yVar.f22880d;
        int i3 = yVar.f22879c;
        int i4 = i2 - i3;
        this.f22854f = i4;
        this.f22857i.setInput(yVar.f22878b, i3, i4);
        return false;
    }

    @Override // j.d0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f22855g) {
            return;
        }
        this.f22857i.end();
        this.f22855g = true;
        this.f22856h.close();
    }

    @Override // j.d0
    public long read(f fVar, long j2) throws IOException {
        kotlin.jvm.internal.m.f(fVar, "sink");
        do {
            long jA = a(fVar, j2);
            if (jA > 0) {
                return jA;
            }
            if (this.f22857i.finished() || this.f22857i.needsDictionary()) {
                return -1L;
            }
        } while (!this.f22856h.R());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // j.d0
    public e0 timeout() {
        return this.f22856h.timeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(d0 d0Var, Inflater inflater) {
        this(q.d(d0Var), inflater);
        kotlin.jvm.internal.m.f(d0Var, "source");
        kotlin.jvm.internal.m.f(inflater, "inflater");
    }
}
