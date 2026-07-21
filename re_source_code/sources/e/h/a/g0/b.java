package e.h.a.g0;

import java.net.ProtocolException;

/* JADX INFO: compiled from: ConnectionProfile.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f21275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f21276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f21277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f21278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f21279f;

    /* JADX INFO: renamed from: e.h.a.g0.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConnectionProfile.java */
    public static class C0275b {
        public static b a(long j2) {
            return new b(0L, 0L, -1L, j2);
        }

        public static b b(long j2, long j3, long j4, long j5) {
            return new b(j2, j3, j4, j5);
        }

        public static b c(long j2, long j3, long j4) {
            return new b(j2, j3, -1L, j4);
        }

        public static b d() {
            return new b();
        }

        public static b e() {
            return new b(0L, 0L, 0L, 0L, true);
        }
    }

    public void a(e.h.a.e0.b bVar) throws ProtocolException {
        if (this.f21278e) {
            return;
        }
        if (this.f21279f && e.h.a.k0.e.a().f21370h) {
            bVar.h("HEAD");
        }
        bVar.f("Range", this.f21276c == -1 ? e.h.a.k0.f.o("bytes=%d-", Long.valueOf(this.f21275b)) : e.h.a.k0.f.o("bytes=%d-%d", Long.valueOf(this.f21275b), Long.valueOf(this.f21276c)));
    }

    public String toString() {
        return e.h.a.k0.f.o("range[%d, %d) current offset[%d]", Long.valueOf(this.a), Long.valueOf(this.f21276c), Long.valueOf(this.f21275b));
    }

    private b() {
        this.a = 0L;
        this.f21275b = 0L;
        this.f21276c = 0L;
        this.f21277d = 0L;
        this.f21278e = false;
        this.f21279f = true;
    }

    private b(long j2, long j3, long j4, long j5) {
        this(j2, j3, j4, j5, false);
    }

    private b(long j2, long j3, long j4, long j5, boolean z) {
        if ((j2 == 0 && j4 == 0) || !z) {
            this.a = j2;
            this.f21275b = j3;
            this.f21276c = j4;
            this.f21277d = j5;
            this.f21278e = z;
            this.f21279f = false;
            return;
        }
        throw new IllegalArgumentException();
    }
}
