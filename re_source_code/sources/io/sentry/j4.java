package io.sentry;

import io.sentry.exception.SentryEnvelopeException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: SentryEnvelopeItem.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class j4 {
    private static final Charset a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k4 f22457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Callable<byte[]> f22458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f22459d;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SentryEnvelopeItem.java */
    static class a {
        private byte[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Callable<byte[]> f22460b;

        public a(Callable<byte[]> callable) {
            this.f22460b = callable;
        }

        private static byte[] b(byte[] bArr) {
            return bArr != null ? bArr : new byte[0];
        }

        public byte[] a() throws Exception {
            Callable<byte[]> callable;
            if (this.a == null && (callable = this.f22460b) != null) {
                this.a = callable.call();
            }
            return b(this.a);
        }
    }

    j4(k4 k4Var, byte[] bArr) {
        this.f22457b = (k4) io.sentry.util.q.c(k4Var, "SentryEnvelopeItemHeader is required.");
        this.f22459d = bArr;
        this.f22458c = null;
    }

    private static void a(long j2, long j3, String str) throws SentryEnvelopeException {
        if (j2 > j3) {
            throw new SentryEnvelopeException(String.format("Dropping attachment with filename '%s', because the size of the passed bytes with %d bytes is bigger than the maximum allowed attachment size of %d bytes.", str, Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    public static j4 b(final c2 c2Var, final w1 w1Var, final s0 s0Var, final long j2) {
        final a aVar = new a(new Callable() { // from class: io.sentry.l0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return j4.j(s0Var, j2, c2Var, w1Var);
            }
        });
        return new j4(new k4(r4.Attachment, (Callable<Integer>) new Callable() { // from class: io.sentry.i0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(aVar.a().length);
            }
        }, s0Var.f(), s0Var.g(), s0Var.d()), (Callable<byte[]>) new Callable() { // from class: io.sentry.d0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    public static j4 c(final c2 c2Var, final io.sentry.clientreport.b bVar) throws IOException {
        io.sentry.util.q.c(c2Var, "ISerializer is required.");
        io.sentry.util.q.c(bVar, "ClientReport is required.");
        final a aVar = new a(new Callable() { // from class: io.sentry.a0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return j4.m(c2Var, bVar);
            }
        });
        return new j4(new k4(r4.resolve(bVar), new Callable() { // from class: io.sentry.x
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(aVar.a().length);
            }
        }, "application/json", null), (Callable<byte[]>) new Callable() { // from class: io.sentry.z
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    public static j4 d(final c2 c2Var, final c4 c4Var) throws IOException {
        io.sentry.util.q.c(c2Var, "ISerializer is required.");
        io.sentry.util.q.c(c4Var, "SentryEvent is required.");
        final a aVar = new a(new Callable() { // from class: io.sentry.y
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return j4.p(c2Var, c4Var);
            }
        });
        return new j4(new k4(r4.resolve(c4Var), new Callable() { // from class: io.sentry.g0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(aVar.a().length);
            }
        }, "application/json", null), (Callable<byte[]>) new Callable() { // from class: io.sentry.c0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    public static j4 e(final m3 m3Var, final long j2, final c2 c2Var) throws SentryEnvelopeException {
        final File fileA = m3Var.A();
        final a aVar = new a(new Callable() { // from class: io.sentry.b0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return j4.s(fileA, j2, m3Var, c2Var);
            }
        });
        return new j4(new k4(r4.Profile, new Callable() { // from class: io.sentry.h0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(aVar.a().length);
            }
        }, "application-json", fileA.getName()), (Callable<byte[]>) new Callable() { // from class: io.sentry.e0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    public static j4 f(final c2 c2Var, final d5 d5Var) throws IOException {
        io.sentry.util.q.c(c2Var, "ISerializer is required.");
        io.sentry.util.q.c(d5Var, "Session is required.");
        final a aVar = new a(new Callable() { // from class: io.sentry.k0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return j4.v(c2Var, d5Var);
            }
        });
        return new j4(new k4(r4.Session, new Callable() { // from class: io.sentry.j0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(aVar.a().length);
            }
        }, "application/json", null), (Callable<byte[]>) new Callable() { // from class: io.sentry.f0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    static /* synthetic */ byte[] j(s0 s0Var, long j2, c2 c2Var, w1 w1Var) throws Exception {
        if (s0Var.e() != null) {
            byte[] bArrE = s0Var.e();
            a(bArrE.length, j2, s0Var.g());
            return bArrE;
        }
        if (s0Var.i() != null) {
            byte[] bArrB = io.sentry.util.n.b(c2Var, w1Var, s0Var.i());
            if (bArrB != null) {
                a(bArrB.length, j2, s0Var.g());
                return bArrB;
            }
        } else if (s0Var.h() != null) {
            return io.sentry.util.l.b(s0Var.h(), j2);
        }
        throw new SentryEnvelopeException(String.format("Couldn't attach the attachment %s.\nPlease check that either bytes, serializable or a path is set.", s0Var.g()));
    }

    static /* synthetic */ byte[] m(c2 c2Var, io.sentry.clientreport.b bVar) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, a));
            try {
                c2Var.a(bVar, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    bufferedWriter.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable unused2) {
            }
            throw th2;
        }
    }

    static /* synthetic */ byte[] p(c2 c2Var, c4 c4Var) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, a));
            try {
                c2Var.a(c4Var, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    bufferedWriter.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable unused2) {
            }
            throw th2;
        }
    }

    static /* synthetic */ byte[] s(File file, long j2, m3 m3Var, c2 c2Var) throws Exception {
        if (!file.exists()) {
            throw new SentryEnvelopeException(String.format("Dropping profiling trace data, because the file '%s' doesn't exists", file.getName()));
        }
        String strC = io.sentry.vendor.a.c(io.sentry.util.l.b(file.getPath(), j2), 3);
        if (strC.isEmpty()) {
            throw new SentryEnvelopeException("Profiling trace file is empty");
        }
        m3Var.E(strC);
        m3Var.D();
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, a));
                    try {
                        c2Var.a(m3Var, bufferedWriter);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        bufferedWriter.close();
                        byteArrayOutputStream.close();
                        file.delete();
                        return byteArray;
                    } catch (Throwable th) {
                        try {
                            bufferedWriter.close();
                        } catch (Throwable unused) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                    throw th2;
                }
            } catch (IOException e2) {
                throw new SentryEnvelopeException(String.format("Failed to serialize profiling trace data\n%s", e2.getMessage()));
            }
        } catch (Throwable th3) {
            file.delete();
            throw th3;
        }
    }

    static /* synthetic */ byte[] v(c2 c2Var, d5 d5Var) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, a));
            try {
                c2Var.a(d5Var, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    bufferedWriter.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable unused2) {
            }
            throw th2;
        }
    }

    public io.sentry.clientreport.b g(c2 c2Var) throws Exception {
        k4 k4Var = this.f22457b;
        if (k4Var == null || k4Var.b() != r4.ClientReport) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(h()), a));
        try {
            io.sentry.clientreport.b bVar = (io.sentry.clientreport.b) c2Var.c(bufferedReader, io.sentry.clientreport.b.class);
            bufferedReader.close();
            return bVar;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public byte[] h() throws Exception {
        Callable<byte[]> callable;
        if (this.f22459d == null && (callable = this.f22458c) != null) {
            this.f22459d = callable.call();
        }
        return this.f22459d;
    }

    public k4 i() {
        return this.f22457b;
    }

    j4(k4 k4Var, Callable<byte[]> callable) {
        this.f22457b = (k4) io.sentry.util.q.c(k4Var, "SentryEnvelopeItemHeader is required.");
        this.f22458c = (Callable) io.sentry.util.q.c(callable, "DataFactory is required.");
        this.f22459d = null;
    }
}
