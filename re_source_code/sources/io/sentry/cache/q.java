package io.sentry.cache;

import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.a1;
import io.sentry.d5;
import io.sentry.e4;
import io.sentry.h4;
import io.sentry.j4;
import io.sentry.n1;
import io.sentry.r4;
import io.sentry.s4;
import io.sentry.w1;
import io.sentry.x4;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: EnvelopeCache.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public class q extends o implements r {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final CountDownLatch f22355k;
    private final Map<h4, String> l;

    public q(x4 x4Var, String str, int i2) {
        super(x4Var, str, i2);
        this.l = new WeakHashMap();
        this.f22355k = new CountDownLatch(1);
    }

    private synchronized File A(h4 h4Var) {
        String str;
        if (this.l.containsKey(h4Var)) {
            str = this.l.get(h4Var);
        } else {
            String str2 = (h4Var.b().a() != null ? h4Var.b().a().toString() : UUID.randomUUID().toString()) + ".envelope";
            this.l.put(h4Var, str2);
            str = str2;
        }
        return new File(this.f22353i.getAbsolutePath(), str);
    }

    public static File C(String str) {
        return new File(str, "previous_session.json");
    }

    private void E(n1 n1Var) {
        Date dateD;
        Object objC = io.sentry.util.m.c(n1Var);
        if (objC instanceof io.sentry.hints.b) {
            File fileC = C(this.f22353i.getAbsolutePath());
            if (!fileC.exists()) {
                this.f22351g.getLogger().c(s4.DEBUG, "No previous session file to end.", new Object[0]);
                return;
            }
            w1 logger = this.f22351g.getLogger();
            s4 s4Var = s4.WARNING;
            logger.c(s4Var, "Previous session is not ended, we'd need to end it.", new Object[0]);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileC), o.f22350f));
                try {
                    d5 d5Var = (d5) this.f22352h.c(bufferedReader, d5.class);
                    if (d5Var != null) {
                        io.sentry.hints.b bVar = (io.sentry.hints.b) objC;
                        Long lC = bVar.c();
                        if (lC != null) {
                            dateD = a1.d(lC.longValue());
                            Date dateK = d5Var.k();
                            if (dateK == null || dateD.before(dateK)) {
                                this.f22351g.getLogger().c(s4Var, "Abnormal exit happened before previous session start, not ending the session.", new Object[0]);
                                bufferedReader.close();
                                return;
                            }
                        } else {
                            dateD = null;
                        }
                        d5Var.q(d5.b.Abnormal, null, true, bVar.f());
                        d5Var.d(dateD);
                        O(fileC, d5Var);
                    }
                    bufferedReader.close();
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                this.f22351g.getLogger().b(s4.ERROR, "Error processing previous session.", th2);
            }
        }
    }

    private void F(File file, h4 h4Var) {
        Iterable<j4> iterableC = h4Var.c();
        if (!iterableC.iterator().hasNext()) {
            this.f22351g.getLogger().c(s4.INFO, "Current envelope %s is empty", file.getAbsolutePath());
            return;
        }
        j4 next = iterableC.iterator().next();
        if (!r4.Session.equals(next.i().b())) {
            this.f22351g.getLogger().c(s4.INFO, "Current envelope has a different envelope type %s", next.i().b());
            return;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(next.h()), o.f22350f));
            try {
                d5 d5Var = (d5) this.f22352h.c(bufferedReader, d5.class);
                if (d5Var == null) {
                    this.f22351g.getLogger().c(s4.ERROR, "Item of type %s returned null by the parser.", next.i().b());
                } else {
                    O(file, d5Var);
                }
                bufferedReader.close();
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            this.f22351g.getLogger().b(s4.ERROR, "Item failed to process.", th2);
        }
    }

    private void L() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f22351g.getCacheDirPath(), "last_crash"));
            try {
                fileOutputStream.write(a1.g(a1.c()).getBytes(o.f22350f));
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            this.f22351g.getLogger().b(s4.ERROR, "Error writing the crash marker file to the disk", th2);
        }
    }

    private void M(File file, h4 h4Var) {
        if (file.exists()) {
            this.f22351g.getLogger().c(s4.DEBUG, "Overwriting envelope to offline storage: %s", file.getAbsolutePath());
            if (!file.delete()) {
                this.f22351g.getLogger().c(s4.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                this.f22352h.b(h4Var, fileOutputStream);
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            this.f22351g.getLogger().a(s4.ERROR, th2, "Error writing Envelope %s to offline storage", file.getAbsolutePath());
        }
    }

    private void O(File file, d5 d5Var) {
        if (file.exists()) {
            this.f22351g.getLogger().c(s4.DEBUG, "Overwriting session to offline storage: %s", d5Var.j());
            if (!file.delete()) {
                this.f22351g.getLogger().c(s4.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, o.f22350f));
                try {
                    this.f22352h.a(d5Var, bufferedWriter);
                    bufferedWriter.close();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedWriter.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                }
                throw th2;
            }
        } catch (Throwable th3) {
            this.f22351g.getLogger().a(s4.ERROR, th3, "Error writing Session to offline storage: %s", d5Var.j());
        }
    }

    private File[] w() {
        File[] fileArrListFiles;
        return (!g() || (fileArrListFiles = this.f22353i.listFiles(new FilenameFilter() { // from class: io.sentry.cache.b
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return str.endsWith(".envelope");
            }
        })) == null) ? new File[0] : fileArrListFiles;
    }

    public static r x(x4 x4Var) {
        String cacheDirPath = x4Var.getCacheDirPath();
        int maxCacheItems = x4Var.getMaxCacheItems();
        if (cacheDirPath != null) {
            return new q(x4Var, cacheDirPath, maxCacheItems);
        }
        x4Var.getLogger().c(s4.WARNING, "cacheDirPath is null, returning NoOpEnvelopeCache", new Object[0]);
        return io.sentry.transport.t.c();
    }

    public static File z(String str) {
        return new File(str, "session.json");
    }

    public boolean G() {
        try {
            return this.f22355k.await(this.f22351g.getFlushTimeoutMillis(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            this.f22351g.getLogger().c(s4.DEBUG, "Timed out waiting for previous session to flush.", new Object[0]);
            return false;
        }
    }

    public void Z(h4 h4Var, n1 n1Var) {
        io.sentry.util.q.c(h4Var, "Envelope is required.");
        t(w());
        File fileZ = z(this.f22353i.getAbsolutePath());
        File fileC = C(this.f22353i.getAbsolutePath());
        if (io.sentry.util.m.d(n1Var, io.sentry.hints.l.class) && !fileZ.delete()) {
            this.f22351g.getLogger().c(s4.WARNING, "Current envelope doesn't exist.", new Object[0]);
        }
        if (io.sentry.util.m.d(n1Var, io.sentry.hints.b.class)) {
            E(n1Var);
        }
        if (io.sentry.util.m.d(n1Var, io.sentry.hints.n.class)) {
            if (fileZ.exists()) {
                this.f22351g.getLogger().c(s4.WARNING, "Current session is not ended, we'd need to end it.", new Object[0]);
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileZ), o.f22350f));
                    try {
                        d5 d5Var = (d5) this.f22352h.c(bufferedReader, d5.class);
                        if (d5Var != null) {
                            O(fileC, d5Var);
                        }
                        bufferedReader.close();
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    this.f22351g.getLogger().b(s4.ERROR, "Error processing session.", th2);
                }
            }
            F(fileZ, h4Var);
            boolean zExists = new File(this.f22351g.getCacheDirPath(), ".sentry-native/last_crash").exists();
            if (!zExists) {
                File file = new File(this.f22351g.getCacheDirPath(), "last_crash");
                if (file.exists()) {
                    this.f22351g.getLogger().c(s4.INFO, "Crash marker file exists, crashedLastRun will return true.", new Object[0]);
                    if (!file.delete()) {
                        this.f22351g.getLogger().c(s4.ERROR, "Failed to delete the crash marker file. %s.", file.getAbsolutePath());
                    }
                    zExists = true;
                }
            }
            e4.a().b(zExists);
            y();
        }
        File fileA = A(h4Var);
        if (fileA.exists()) {
            this.f22351g.getLogger().c(s4.WARNING, "Not adding Envelope to offline storage because it already exists: %s", fileA.getAbsolutePath());
            return;
        }
        this.f22351g.getLogger().c(s4.DEBUG, "Adding Envelope to offline storage: %s", fileA.getAbsolutePath());
        M(fileA, h4Var);
        if (io.sentry.util.m.d(n1Var, UncaughtExceptionHandlerIntegration.a.class)) {
            L();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<h4> iterator() {
        File[] fileArrW = w();
        ArrayList arrayList = new ArrayList(fileArrW.length);
        for (File file : fileArrW) {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    arrayList.add(this.f22352h.d(bufferedInputStream));
                    bufferedInputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused2) {
                this.f22351g.getLogger().c(s4.DEBUG, "Envelope file '%s' disappeared while converting all cached files to envelopes.", file.getAbsolutePath());
            } catch (IOException e2) {
                this.f22351g.getLogger().b(s4.ERROR, String.format("Error while reading cached envelope from file %s", file.getAbsolutePath()), e2);
            }
        }
        return arrayList.iterator();
    }

    @Override // io.sentry.cache.r
    public void p(h4 h4Var) {
        io.sentry.util.q.c(h4Var, "Envelope is required.");
        File fileA = A(h4Var);
        if (!fileA.exists()) {
            this.f22351g.getLogger().c(s4.DEBUG, "Envelope was not cached: %s", fileA.getAbsolutePath());
            return;
        }
        this.f22351g.getLogger().c(s4.DEBUG, "Discarding envelope from cache: %s", fileA.getAbsolutePath());
        if (fileA.delete()) {
            return;
        }
        this.f22351g.getLogger().c(s4.ERROR, "Failed to delete envelope: %s", fileA.getAbsolutePath());
    }

    public void y() {
        this.f22355k.countDown();
    }
}
