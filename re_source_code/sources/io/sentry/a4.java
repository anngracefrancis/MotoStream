package io.sentry;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionException;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: Sentry.java */
/* JADX INFO: loaded from: classes.dex */
public final class a4 {
    private static final ThreadLocal<v1> a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile v1 f22002b = y2.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f22003c = false;

    /* JADX INFO: compiled from: Sentry.java */
    public interface a<T extends x4> {
        void a(T t);
    }

    public static void a(v0 v0Var, n1 n1Var) {
        j().n(v0Var, n1Var);
    }

    private static <T extends x4> void b(a<T> aVar, T t) {
        try {
            aVar.a(t);
        } catch (Throwable th) {
            t.getLogger().b(s4.ERROR, "Error in the 'OptionsConfiguration.configure' callback.", th);
        }
    }

    public static io.sentry.protocol.q c(l4 l4Var) {
        return j().k(l4Var);
    }

    public static io.sentry.protocol.q d(l4 l4Var, n1 n1Var) {
        return j().t(l4Var, n1Var);
    }

    public static synchronized void e() {
        v1 v1VarJ = j();
        f22002b = y2.a();
        a.remove();
        v1VarJ.close();
    }

    public static void f(t3 t3Var) {
        j().o(t3Var);
    }

    public static void g() {
        j().endSession();
    }

    private static void h(x4 x4Var, v1 v1Var) {
        try {
            x4Var.getExecutorService().submit(new l3(x4Var, v1Var));
        } catch (Throwable th) {
            x4Var.getLogger().b(s4.DEBUG, "Failed to finalize previous session.", th);
        }
    }

    public static void i(long j2) {
        j().h(j2);
    }

    @ApiStatus.Internal
    public static v1 j() {
        if (f22003c) {
            return f22002b;
        }
        ThreadLocal<v1> threadLocal = a;
        v1 v1Var = threadLocal.get();
        if (v1Var != null && !(v1Var instanceof y2)) {
            return v1Var;
        }
        v1 v1VarClone = f22002b.m373clone();
        threadLocal.set(v1VarClone);
        return v1VarClone;
    }

    public static <T extends x4> void k(i3<T> i3Var, a<T> aVar, boolean z) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        T tB = i3Var.b();
        b(aVar, tB);
        n(tB, z);
    }

    public static void l(a<x4> aVar) {
        m(aVar, false);
    }

    public static void m(a<x4> aVar, boolean z) {
        x4 x4Var = new x4();
        b(aVar, x4Var);
        n(x4Var, z);
    }

    private static synchronized void n(x4 x4Var, boolean z) {
        if (p()) {
            x4Var.getLogger().c(s4.WARNING, "Sentry has been already initialized. Previous configuration will be overwritten.", new Object[0]);
        }
        if (o(x4Var)) {
            x4Var.getLogger().c(s4.INFO, "GlobalHubMode: '%s'", String.valueOf(z));
            f22003c = z;
            v1 v1VarJ = j();
            f22002b = new p1(x4Var);
            a.set(f22002b);
            v1VarJ.close();
            if (x4Var.getExecutorService().isClosed()) {
                x4Var.setExecutorService(new n4());
            }
            Iterator<Integration> it = x4Var.getIntegrations().iterator();
            while (it.hasNext()) {
                it.next().c(q1.a(), x4Var);
            }
            s(x4Var);
            h(x4Var, q1.a());
        }
    }

    private static boolean o(x4 x4Var) {
        if (x4Var.isEnableExternalConfiguration()) {
            x4Var.merge(l1.g(io.sentry.config.h.a(), x4Var.getLogger()));
        }
        String dsn = x4Var.getDsn();
        if (!x4Var.isEnabled() || (dsn != null && dsn.isEmpty())) {
            e();
            return false;
        }
        if (dsn == null) {
            throw new IllegalArgumentException("DSN is required. Use empty string or set enabled to false in SentryOptions to disable SDK.");
        }
        new f1(dsn);
        w1 logger = x4Var.getLogger();
        if (x4Var.isDebug() && (logger instanceof z2)) {
            x4Var.setLogger(new n5());
            logger = x4Var.getLogger();
        }
        s4 s4Var = s4.INFO;
        logger.c(s4Var, "Initializing SDK with DSN: '%s'", x4Var.getDsn());
        String outboxPath = x4Var.getOutboxPath();
        if (outboxPath != null) {
            new File(outboxPath).mkdirs();
        } else {
            logger.c(s4Var, "No outbox dir path is defined in options.", new Object[0]);
        }
        String cacheDirPath = x4Var.getCacheDirPath();
        if (cacheDirPath != null) {
            new File(cacheDirPath).mkdirs();
            if (x4Var.getEnvelopeDiskCache() instanceof io.sentry.transport.t) {
                x4Var.setEnvelopeDiskCache(io.sentry.cache.q.x(x4Var));
            }
        }
        String profilingTracesDirPath = x4Var.getProfilingTracesDirPath();
        if (x4Var.isProfilingEnabled() && profilingTracesDirPath != null) {
            File file = new File(profilingTracesDirPath);
            file.mkdirs();
            final File[] fileArrListFiles = file.listFiles();
            try {
                x4Var.getExecutorService().submit(new Runnable() { // from class: io.sentry.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        a4.q(fileArrListFiles);
                    }
                });
            } catch (RejectedExecutionException e2) {
                x4Var.getLogger().b(s4.ERROR, "Failed to call the executor. Old profiles will not be deleted. Did you call Sentry.close()?", e2);
            }
        }
        io.sentry.internal.modules.b modulesLoader = x4Var.getModulesLoader();
        if (!x4Var.isSendModules()) {
            x4Var.setModulesLoader(io.sentry.internal.modules.e.b());
        } else if (modulesLoader instanceof io.sentry.internal.modules.e) {
            x4Var.setModulesLoader(new io.sentry.internal.modules.a(Arrays.asList(new io.sentry.internal.modules.c(x4Var.getLogger()), new io.sentry.internal.modules.f(x4Var.getLogger())), x4Var.getLogger()));
        }
        if (x4Var.getDebugMetaLoader() instanceof io.sentry.internal.debugmeta.b) {
            x4Var.setDebugMetaLoader(new io.sentry.internal.debugmeta.c(x4Var.getLogger()));
        }
        io.sentry.util.j.c(x4Var, x4Var.getDebugMetaLoader().a());
        if (x4Var.getMainThreadChecker() instanceof io.sentry.util.thread.d) {
            x4Var.setMainThreadChecker(io.sentry.util.thread.c.e());
        }
        if (x4Var.getCollectors().isEmpty()) {
            x4Var.addCollector(new k2());
        }
        return true;
    }

    public static boolean p() {
        return j().isEnabled();
    }

    static /* synthetic */ void q(File[] fileArr) {
        if (fileArr == null) {
            return;
        }
        for (File file : fileArr) {
            io.sentry.util.l.a(file);
        }
    }

    static /* synthetic */ void r(x4 x4Var) {
        for (x1 x1Var : x4Var.getOptionsObservers()) {
            x1Var.f(x4Var.getRelease());
            x1Var.e(x4Var.getProguardUuid());
            x1Var.b(x4Var.getSdkVersion());
            x1Var.c(x4Var.getDist());
            x1Var.d(x4Var.getEnvironment());
            x1Var.a(x4Var.getTags());
        }
    }

    private static void s(final x4 x4Var) {
        try {
            x4Var.getExecutorService().submit(new Runnable() { // from class: io.sentry.u
                @Override // java.lang.Runnable
                public final void run() {
                    a4.r(x4Var);
                }
            });
        } catch (Throwable th) {
            x4Var.getLogger().b(s4.DEBUG, "Failed to notify options observers.", th);
        }
    }

    public static void t() {
        j().startSession();
    }

    public static e2 u(r5 r5Var, t5 t5Var) {
        return j().l(r5Var, t5Var);
    }
}
