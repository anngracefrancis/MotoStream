package k.b;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import k.b.f.e;
import k.b.f.g;
import k.b.f.h;
import k.b.f.i;

/* JADX INFO: compiled from: LoggerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    static volatile int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static h f22889b = new h();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static e f22890c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static boolean f22891d = i.c("slf4j.detectLoggerNameMismatch");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f22892e = {"1.6", "1.7"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f22893f = "org/slf4j/impl/StaticLoggerBinder.class";

    private c() {
    }

    private static final void a() {
        Set<URL> setF = null;
        try {
            if (!k()) {
                setF = f();
                q(setF);
            }
            k.b.g.c.c();
            a = 3;
            p(setF);
            g();
            n();
            f22889b.b();
        } catch (Exception e2) {
            e(e2);
            throw new IllegalStateException("Unexpected initialization failure", e2);
        } catch (NoClassDefFoundError e3) {
            if (!l(e3.getMessage())) {
                e(e3);
                throw e3;
            }
            a = 4;
            i.a("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
            i.a("Defaulting to no-operation (NOP) logger implementation");
            i.a("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
        } catch (NoSuchMethodError e4) {
            String message = e4.getMessage();
            if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                a = 2;
                i.a("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                i.a("Your binding is version 1.5.5 or earlier.");
                i.a("Upgrade your binding to version 1.6.x.");
            }
            throw e4;
        }
    }

    private static void b(k.b.e.d dVar, int i2) {
        if (dVar.a().m()) {
            c(i2);
        } else {
            if (dVar.a().n()) {
                return;
            }
            d();
        }
    }

    private static void c(int i2) {
        i.a("A number (" + i2 + ") of logging calls during the initialization phase have been intercepted and are");
        i.a("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        i.a("See also http://www.slf4j.org/codes.html#replay");
    }

    private static void d() {
        i.a("The following set of substitute loggers may have been accessed");
        i.a("during the initialization phase. Logging calls during this");
        i.a("phase were not honored. However, subsequent logging calls to these");
        i.a("loggers will work as normally expected.");
        i.a("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    static void e(Throwable th) {
        a = 2;
        i.b("Failed to instantiate SLF4J LoggerFactory", th);
    }

    static Set<URL> f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = c.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(f22893f) : classLoader.getResources(f22893f);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e2) {
            i.b("Error getting resources from path", e2);
        }
        return linkedHashSet;
    }

    private static void g() {
        synchronized (f22889b) {
            f22889b.e();
            for (g gVar : f22889b.d()) {
                gVar.q(i(gVar.l()));
            }
        }
    }

    public static a h() {
        if (a == 0) {
            synchronized (c.class) {
                if (a == 0) {
                    a = 1;
                    m();
                }
            }
        }
        int i2 = a;
        if (i2 == 1) {
            return f22889b;
        }
        if (i2 == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        if (i2 == 3) {
            return k.b.g.c.c().a();
        }
        if (i2 == 4) {
            return f22890c;
        }
        throw new IllegalStateException("Unreachable code");
    }

    public static b i(String str) {
        return h().a(str);
    }

    private static boolean j(Set<URL> set) {
        return set.size() > 1;
    }

    private static boolean k() {
        String strD = i.d("java.vendor.url");
        if (strD == null) {
            return false;
        }
        return strD.toLowerCase().contains("android");
    }

    private static boolean l(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    private static final void m() {
        a();
        if (a == 3) {
            r();
        }
    }

    private static void n() {
        LinkedBlockingQueue<k.b.e.d> linkedBlockingQueueC = f22889b.c();
        int size = linkedBlockingQueueC.size();
        ArrayList<k.b.e.d> arrayList = new ArrayList(128);
        int i2 = 0;
        while (linkedBlockingQueueC.drainTo(arrayList, 128) != 0) {
            for (k.b.e.d dVar : arrayList) {
                o(dVar);
                int i3 = i2 + 1;
                if (i2 == 0) {
                    b(dVar, size);
                }
                i2 = i3;
            }
            arrayList.clear();
        }
    }

    private static void o(k.b.e.d dVar) {
        if (dVar == null) {
            return;
        }
        g gVarA = dVar.a();
        String strL = gVarA.l();
        if (gVarA.o()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (gVarA.n()) {
            return;
        }
        if (gVarA.m()) {
            gVarA.p(dVar);
        } else {
            i.a(strL);
        }
    }

    private static void p(Set<URL> set) {
        if (set == null || !j(set)) {
            return;
        }
        i.a("Actual binding is of type [" + k.b.g.c.c().b() + "]");
    }

    private static void q(Set<URL> set) {
        if (j(set)) {
            i.a("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it = set.iterator();
            while (it.hasNext()) {
                i.a("Found binding in [" + it.next() + "]");
            }
            i.a("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    private static final void r() {
        try {
            String str = k.b.g.c.f22928b;
            boolean z = false;
            for (String str2 : f22892e) {
                if (str.startsWith(str2)) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            i.a("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f22892e).toString());
            i.a("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            i.b("Unexpected problem occured during version sanity check", th);
        }
    }
}
