package j;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: DeflaterSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements b0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f22846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final g f22847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Deflater f22848h;

    public j(g gVar, Deflater deflater) {
        kotlin.jvm.internal.m.f(gVar, "sink");
        kotlin.jvm.internal.m.f(deflater, "deflater");
        this.f22847g = gVar;
        this.f22848h = deflater;
    }

    @IgnoreJRERequirement
    private final void a(boolean z) throws IOException {
        y yVarQ0;
        int iDeflate;
        f fVarI = this.f22847g.i();
        while (true) {
            yVarQ0 = fVarI.q0(1);
            if (z) {
                Deflater deflater = this.f22848h;
                byte[] bArr = yVarQ0.f22878b;
                int i2 = yVarQ0.f22880d;
                iDeflate = deflater.deflate(bArr, i2, 8192 - i2, 2);
            } else {
                Deflater deflater2 = this.f22848h;
                byte[] bArr2 = yVarQ0.f22878b;
                int i3 = yVarQ0.f22880d;
                iDeflate = deflater2.deflate(bArr2, i3, 8192 - i3);
            }
            if (iDeflate > 0) {
                yVarQ0.f22880d += iDeflate;
                fVarI.f0(fVarI.size() + ((long) iDeflate));
                this.f22847g.c0();
            } else if (this.f22848h.needsInput()) {
                break;
            }
        }
        if (yVarQ0.f22879c == yVarQ0.f22880d) {
            fVarI.f22831f = yVarQ0.b();
            z.b(yVarQ0);
        }
    }

    public final void b() throws IOException {
        this.f22848h.finish();
        a(false);
    }

    @Override // j.b0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f22846f) {
            return;
        }
        Throwable th = null;
        try {
            b();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f22848h.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.f22847g.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.f22846f = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // j.b0, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.f22847g.flush();
    }

    @Override // j.b0
    public e0 timeout() {
        return this.f22847g.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f22847g + ')';
    }

    @Override // j.b0
    public void write(f fVar, long j2) throws IOException {
        kotlin.jvm.internal.m.f(fVar, "source");
        c.b(fVar.size(), 0L, j2);
        while (j2 > 0) {
            y yVar = fVar.f22831f;
            kotlin.jvm.internal.m.c(yVar);
            int iMin = (int) Math.min(j2, yVar.f22880d - yVar.f22879c);
            this.f22848h.setInput(yVar.f22878b, yVar.f22879c, iMin);
            a(false);
            long j3 = iMin;
            fVar.f0(fVar.size() - j3);
            int i2 = yVar.f22879c + iMin;
            yVar.f22879c = i2;
            if (i2 == yVar.f22880d) {
                fVar.f22831f = yVar.b();
                z.b(yVar);
            }
            j2 -= j3;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(b0 b0Var, Deflater deflater) {
        this(q.c(b0Var), deflater);
        kotlin.jvm.internal.m.f(b0Var, "sink");
        kotlin.jvm.internal.m.f(deflater, "deflater");
    }
}
