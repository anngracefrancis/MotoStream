package j;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: GzipSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements d0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte f22849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final x f22850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Inflater f22851h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final o f22852i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CRC32 f22853j;

    public n(d0 d0Var) {
        kotlin.jvm.internal.m.f(d0Var, "source");
        x xVar = new x(d0Var);
        this.f22850g = xVar;
        Inflater inflater = new Inflater(true);
        this.f22851h = inflater;
        this.f22852i = new o((h) xVar, inflater);
        this.f22853j = new CRC32();
    }

    private final void a(String str, int i2, int i3) throws IOException {
        if (i3 == i2) {
            return;
        }
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i2)}, 3));
        kotlin.jvm.internal.m.e(str2, "java.lang.String.format(this, *args)");
        throw new IOException(str2);
    }

    private final void b() throws IOException {
        this.f22850g.g1(10L);
        byte bM = this.f22850g.f22874f.m(3L);
        boolean z = ((bM >> 1) & 1) == 1;
        if (z) {
            d(this.f22850g.f22874f, 0L, 10L);
        }
        a("ID1ID2", 8075, this.f22850g.readShort());
        this.f22850g.skip(8L);
        if (((bM >> 2) & 1) == 1) {
            this.f22850g.g1(2L);
            if (z) {
                d(this.f22850g.f22874f, 0L, 2L);
            }
            long jN = this.f22850g.f22874f.N();
            this.f22850g.g1(jN);
            if (z) {
                d(this.f22850g.f22874f, 0L, jN);
            }
            this.f22850g.skip(jN);
        }
        if (((bM >> 3) & 1) == 1) {
            long jA = this.f22850g.a((byte) 0);
            if (jA == -1) {
                throw new EOFException();
            }
            if (z) {
                d(this.f22850g.f22874f, 0L, jA + 1);
            }
            this.f22850g.skip(jA + 1);
        }
        if (((bM >> 4) & 1) == 1) {
            long jA2 = this.f22850g.a((byte) 0);
            if (jA2 == -1) {
                throw new EOFException();
            }
            if (z) {
                d(this.f22850g.f22874f, 0L, jA2 + 1);
            }
            this.f22850g.skip(jA2 + 1);
        }
        if (z) {
            a("FHCRC", this.f22850g.j(), (short) this.f22853j.getValue());
            this.f22853j.reset();
        }
    }

    private final void c() throws IOException {
        a("CRC", this.f22850g.f(), (int) this.f22853j.getValue());
        a("ISIZE", this.f22850g.f(), (int) this.f22851h.getBytesWritten());
    }

    private final void d(f fVar, long j2, long j3) {
        y yVar = fVar.f22831f;
        kotlin.jvm.internal.m.c(yVar);
        while (true) {
            int i2 = yVar.f22880d;
            int i3 = yVar.f22879c;
            if (j2 < i2 - i3) {
                break;
            }
            j2 -= (long) (i2 - i3);
            yVar = yVar.f22883g;
            kotlin.jvm.internal.m.c(yVar);
        }
        while (j3 > 0) {
            int i4 = (int) (((long) yVar.f22879c) + j2);
            int iMin = (int) Math.min(yVar.f22880d - i4, j3);
            this.f22853j.update(yVar.f22878b, i4, iMin);
            j3 -= (long) iMin;
            yVar = yVar.f22883g;
            kotlin.jvm.internal.m.c(yVar);
            j2 = 0;
        }
    }

    @Override // j.d0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f22852i.close();
    }

    @Override // j.d0
    public long read(f fVar, long j2) throws IOException {
        kotlin.jvm.internal.m.f(fVar, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (j2 == 0) {
            return 0L;
        }
        if (this.f22849f == 0) {
            b();
            this.f22849f = (byte) 1;
        }
        if (this.f22849f == 1) {
            long size = fVar.size();
            long j3 = this.f22852i.read(fVar, j2);
            if (j3 != -1) {
                d(fVar, size, j3);
                return j3;
            }
            this.f22849f = (byte) 2;
        }
        if (this.f22849f == 2) {
            c();
            this.f22849f = (byte) 3;
            if (!this.f22850g.R()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // j.d0
    public e0 timeout() {
        return this.f22850g.timeout();
    }
}
