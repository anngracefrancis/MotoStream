package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import io.sentry.Integration;
import io.sentry.i2;
import io.sentry.l4;
import io.sentry.n1;
import io.sentry.s4;
import io.sentry.v1;
import io.sentry.w1;
import io.sentry.x4;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public class AnrV2Integration implements Integration, Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final long f22015f = TimeUnit.DAYS.toMillis(91);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f22016g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final io.sentry.transport.q f22017h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private SentryAndroidOptions f22018i;

    static class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Context f22019f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final v1 f22020g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final SentryAndroidOptions f22021h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final long f22022i;

        a(Context context, v1 v1Var, SentryAndroidOptions sentryAndroidOptions, io.sentry.transport.q qVar) {
            this.f22019f = context;
            this.f22020g = v1Var;
            this.f22021h = sentryAndroidOptions;
            this.f22022i = qVar.a() - AnrV2Integration.f22015f;
        }

        private byte[] a(InputStream inputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = inputStream.read(bArr, 0, 1024);
                    if (i2 == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        }

        private c b(ApplicationExitInfo applicationExitInfo, boolean z) {
            try {
                InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
                try {
                    if (traceInputStream == null) {
                        c cVar = new c(c.a.NO_DUMP);
                        if (traceInputStream != null) {
                            traceInputStream.close();
                        }
                        return cVar;
                    }
                    byte[] bArrA = a(traceInputStream);
                    traceInputStream.close();
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArrA)));
                        try {
                            List<io.sentry.protocol.w> listF = new io.sentry.android.core.internal.threaddump.c(this.f22021h, z).f(io.sentry.android.core.internal.threaddump.b.c(bufferedReader));
                            if (listF.isEmpty()) {
                                c cVar2 = new c(c.a.ERROR, bArrA);
                                bufferedReader.close();
                                return cVar2;
                            }
                            c cVar3 = new c(c.a.DUMP, bArrA, listF);
                            bufferedReader.close();
                            return cVar3;
                        } catch (Throwable th) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused) {
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        this.f22021h.getLogger().b(s4.WARNING, "Failed to parse ANR thread dump", th2);
                        return new c(c.a.ERROR, bArrA);
                    }
                } catch (Throwable th3) {
                    if (traceInputStream != null) {
                        try {
                            traceInputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th4) {
                this.f22021h.getLogger().b(s4.WARNING, "Failed to read ANR thread dump", th4);
                return new c(c.a.NO_DUMP);
            }
        }

        private void c(ApplicationExitInfo applicationExitInfo, boolean z) {
            byte[] bArr;
            long timestamp = applicationExitInfo.getTimestamp();
            boolean z2 = applicationExitInfo.getImportance() != 100;
            c cVarB = b(applicationExitInfo, z2);
            if (cVarB.a == c.a.NO_DUMP) {
                this.f22021h.getLogger().c(s4.WARNING, "Not reporting ANR event as there was no thread dump for the ANR %s", applicationExitInfo.toString());
                return;
            }
            b bVar = new b(this.f22021h.getFlushTimeoutMillis(), this.f22021h.getLogger(), timestamp, z, z2);
            n1 n1VarA = io.sentry.util.m.a(bVar);
            l4 l4Var = new l4();
            c.a aVar = cVarB.a;
            if (aVar == c.a.ERROR) {
                io.sentry.protocol.j jVar = new io.sentry.protocol.j();
                jVar.d("Sentry Android SDK failed to parse system thread dump for this ANR. We recommend enabling [SentryOptions.isAttachAnrThreadDump] option to attach the thread dump as plain text and report this issue on GitHub.");
                l4Var.A0(jVar);
            } else if (aVar == c.a.DUMP) {
                l4Var.C0(cVarB.f22027c);
            }
            l4Var.z0(s4.FATAL);
            l4Var.D0(io.sentry.a1.d(timestamp));
            if (this.f22021h.isAttachAnrThreadDump() && (bArr = cVarB.f22026b) != null) {
                n1VarA.l(io.sentry.s0.b(bArr));
            }
            if (this.f22020g.t(l4Var, n1VarA).equals(io.sentry.protocol.q.f22645f) || bVar.e()) {
                return;
            }
            this.f22021h.getLogger().c(s4.WARNING, "Timed out waiting to flush ANR event to disk. Event: %s", l4Var.G());
        }

        private void d(List<ApplicationExitInfo> list, Long l) {
            Collections.reverse(list);
            for (ApplicationExitInfo applicationExitInfo : list) {
                if (applicationExitInfo.getReason() == 6) {
                    if (applicationExitInfo.getTimestamp() < this.f22022i) {
                        this.f22021h.getLogger().c(s4.DEBUG, "ANR happened too long ago %s.", applicationExitInfo);
                    } else if (l == null || applicationExitInfo.getTimestamp() > l.longValue()) {
                        c(applicationExitInfo, false);
                    } else {
                        this.f22021h.getLogger().c(s4.DEBUG, "ANR has already been reported %s.", applicationExitInfo);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        @SuppressLint({"NewApi"})
        public void run() {
            ApplicationExitInfo applicationExitInfo = null;
            List<ApplicationExitInfo> historicalProcessExitReasons = ((ActivityManager) this.f22019f.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
            if (historicalProcessExitReasons.size() == 0) {
                this.f22021h.getLogger().c(s4.DEBUG, "No records in historical exit reasons.", new Object[0]);
                return;
            }
            io.sentry.cache.r envelopeDiskCache = this.f22021h.getEnvelopeDiskCache();
            if ((envelopeDiskCache instanceof io.sentry.cache.q) && this.f22021h.isEnableAutoSessionTracking()) {
                io.sentry.cache.q qVar = (io.sentry.cache.q) envelopeDiskCache;
                if (!qVar.G()) {
                    this.f22021h.getLogger().c(s4.WARNING, "Timed out waiting to flush previous session to its own file.", new Object[0]);
                    qVar.y();
                }
            }
            ArrayList arrayList = new ArrayList(historicalProcessExitReasons);
            Long lU = io.sentry.android.core.cache.b.U(this.f22021h);
            for (ApplicationExitInfo applicationExitInfo2 : arrayList) {
                if (applicationExitInfo2.getReason() == 6) {
                    arrayList.remove(applicationExitInfo2);
                    applicationExitInfo = applicationExitInfo2;
                    break;
                }
            }
            if (applicationExitInfo == null) {
                this.f22021h.getLogger().c(s4.DEBUG, "No ANRs have been found in the historical exit reasons list.", new Object[0]);
                return;
            }
            if (applicationExitInfo.getTimestamp() < this.f22022i) {
                this.f22021h.getLogger().c(s4.DEBUG, "Latest ANR happened too long ago, returning early.", new Object[0]);
                return;
            }
            if (lU != null && applicationExitInfo.getTimestamp() <= lU.longValue()) {
                this.f22021h.getLogger().c(s4.DEBUG, "Latest ANR has already been reported, returning early.", new Object[0]);
                return;
            }
            if (this.f22021h.isReportHistoricalAnrs()) {
                d(arrayList, lU);
            }
            c(applicationExitInfo, true);
        }
    }

    @ApiStatus.Internal
    public static final class b extends io.sentry.hints.e implements io.sentry.hints.d, io.sentry.hints.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f22023d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f22024e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f22025f;

        public b(long j2, w1 w1Var, long j3, boolean z, boolean z2) {
            super(j2, w1Var);
            this.f22023d = j3;
            this.f22024e = z;
            this.f22025f = z2;
        }

        @Override // io.sentry.hints.d
        public boolean a() {
            return this.f22024e;
        }

        @Override // io.sentry.hints.b
        public Long c() {
            return Long.valueOf(this.f22023d);
        }

        @Override // io.sentry.hints.b
        public /* synthetic */ boolean d() {
            return io.sentry.hints.a.a(this);
        }

        @Override // io.sentry.hints.b
        public String f() {
            return this.f22025f ? "anr_background" : "anr_foreground";
        }
    }

    public AnrV2Integration(Context context) {
        this(context, io.sentry.transport.o.b());
    }

    @Override // io.sentry.j2
    public /* synthetic */ void a() {
        i2.a(this);
    }

    @Override // io.sentry.Integration
    @SuppressLint({"NewApi"})
    public void c(v1 v1Var, x4 x4Var) {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.q.c(x4Var instanceof SentryAndroidOptions ? (SentryAndroidOptions) x4Var : null, "SentryAndroidOptions is required");
        this.f22018i = sentryAndroidOptions;
        sentryAndroidOptions.getLogger().c(s4.DEBUG, "AnrIntegration enabled: %s", Boolean.valueOf(this.f22018i.isAnrEnabled()));
        if (this.f22018i.getCacheDirPath() == null) {
            this.f22018i.getLogger().c(s4.INFO, "Cache dir is not set, unable to process ANRs", new Object[0]);
            return;
        }
        if (this.f22018i.isAnrEnabled()) {
            try {
                x4Var.getExecutorService().submit(new a(this.f22016g, v1Var, this.f22018i, this.f22017h));
            } catch (Throwable th) {
                x4Var.getLogger().b(s4.DEBUG, "Failed to start AnrProcessor.", th);
            }
            x4Var.getLogger().c(s4.DEBUG, "AnrV2Integration installed.", new Object[0]);
            a();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        SentryAndroidOptions sentryAndroidOptions = this.f22018i;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(s4.DEBUG, "AnrV2Integration removed.", new Object[0]);
        }
    }

    @Override // io.sentry.j2
    public /* synthetic */ String d() {
        return i2.b(this);
    }

    AnrV2Integration(Context context, io.sentry.transport.q qVar) {
        this.f22016g = context;
        this.f22017h = qVar;
    }

    static final class c {
        final a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final byte[] f22026b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final List<io.sentry.protocol.w> f22027c;

        enum a {
            DUMP,
            NO_DUMP,
            ERROR
        }

        c(a aVar) {
            this.a = aVar;
            this.f22026b = null;
            this.f22027c = null;
        }

        c(a aVar, byte[] bArr) {
            this.a = aVar;
            this.f22026b = bArr;
            this.f22027c = null;
        }

        c(a aVar, byte[] bArr, List<io.sentry.protocol.w> list) {
            this.a = aVar;
            this.f22026b = bArr;
            this.f22027c = list;
        }
    }
}
