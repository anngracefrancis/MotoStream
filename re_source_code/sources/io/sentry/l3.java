package io.sentry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Date;

/* JADX INFO: compiled from: PreviousSessionFinalizer.java */
/* JADX INFO: loaded from: classes2.dex */
final class l3 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Charset f22488f = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final x4 f22489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final v1 f22490h;

    l3(x4 x4Var, v1 v1Var) {
        this.f22489g = x4Var;
        this.f22490h = v1Var;
    }

    private Date a(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), f22488f));
            try {
                String line = bufferedReader.readLine();
                this.f22489g.getLogger().c(s4.DEBUG, "Crash marker file has %s timestamp.", line);
                Date dateE = a1.e(line);
                bufferedReader.close();
                return dateE;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (IOException e2) {
            this.f22489g.getLogger().b(s4.ERROR, "Error reading the crash marker file.", e2);
            return null;
        } catch (IllegalArgumentException e3) {
            this.f22489g.getLogger().a(s4.ERROR, e3, "Error converting the crash timestamp.", new Object[0]);
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String cacheDirPath = this.f22489g.getCacheDirPath();
        if (cacheDirPath == null) {
            this.f22489g.getLogger().c(s4.INFO, "Cache dir is not set, not finalizing the previous session.", new Object[0]);
            return;
        }
        if (!this.f22489g.isEnableAutoSessionTracking()) {
            this.f22489g.getLogger().c(s4.DEBUG, "Session tracking is disabled, bailing from previous session finalizer.", new Object[0]);
            return;
        }
        io.sentry.cache.r envelopeDiskCache = this.f22489g.getEnvelopeDiskCache();
        if ((envelopeDiskCache instanceof io.sentry.cache.q) && !((io.sentry.cache.q) envelopeDiskCache).G()) {
            this.f22489g.getLogger().c(s4.WARNING, "Timed out waiting to flush previous session to its own file in session finalizer.", new Object[0]);
            return;
        }
        File fileC = io.sentry.cache.q.C(cacheDirPath);
        c2 serializer = this.f22489g.getSerializer();
        if (fileC.exists()) {
            this.f22489g.getLogger().c(s4.WARNING, "Current session is not ended, we'd need to end it.", new Object[0]);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileC), f22488f));
                try {
                    d5 d5Var = (d5) serializer.c(bufferedReader, d5.class);
                    if (d5Var == null) {
                        this.f22489g.getLogger().c(s4.ERROR, "Stream from path %s resulted in a null envelope.", fileC.getAbsolutePath());
                    } else {
                        File file = new File(this.f22489g.getCacheDirPath(), ".sentry-native/last_crash");
                        Date date = null;
                        if (file.exists()) {
                            this.f22489g.getLogger().c(s4.INFO, "Crash marker file exists, last Session is gonna be Crashed.", new Object[0]);
                            Date dateA = a(file);
                            if (!file.delete()) {
                                this.f22489g.getLogger().c(s4.ERROR, "Failed to delete the crash marker file. %s.", file.getAbsolutePath());
                            }
                            d5Var.p(d5.b.Crashed, null, true);
                            date = dateA;
                        }
                        if (d5Var.f() == null) {
                            d5Var.d(date);
                        }
                        this.f22490h.s(h4.a(serializer, d5Var, this.f22489g.getSdkVersion()));
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
                this.f22489g.getLogger().b(s4.ERROR, "Error processing previous session.", th2);
            }
            if (fileC.delete()) {
                return;
            }
            this.f22489g.getLogger().c(s4.WARNING, "Failed to delete the previous session file.", new Object[0]);
        }
    }
}
