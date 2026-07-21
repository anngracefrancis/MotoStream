package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.WorkerParameters;
import androidx.work.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: Processor.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements b, androidx.work.impl.foreground.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2391f = n.f("Processor");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f2393h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private androidx.work.b f2394i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private androidx.work.impl.utils.p.a f2395j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private WorkDatabase f2396k;
    private List<e> n;
    private Map<String, k> m = new HashMap();
    private Map<String, k> l = new HashMap();
    private Set<String> o = new HashSet();
    private final List<b> p = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PowerManager.WakeLock f2392g = null;
    private final Object q = new Object();

    /* JADX INFO: compiled from: Processor.java */
    private static class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private b f2397f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f2398g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private e.e.c.a.a.a<Boolean> f2399h;

        a(b bVar, String str, e.e.c.a.a.a<Boolean> aVar) {
            this.f2397f = bVar;
            this.f2398g = str;
            this.f2399h = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zBooleanValue;
            try {
                zBooleanValue = this.f2399h.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                zBooleanValue = true;
            }
            this.f2397f.d(this.f2398g, zBooleanValue);
        }
    }

    public d(Context context, androidx.work.b bVar, androidx.work.impl.utils.p.a aVar, WorkDatabase workDatabase, List<e> list) {
        this.f2393h = context;
        this.f2394i = bVar;
        this.f2395j = aVar;
        this.f2396k = workDatabase;
        this.n = list;
    }

    private static boolean e(String str, k kVar) {
        if (kVar == null) {
            n.c().a(f2391f, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
            return false;
        }
        kVar.d();
        n.c().a(f2391f, String.format("WorkerWrapper interrupted for %s", str), new Throwable[0]);
        return true;
    }

    private void m() {
        synchronized (this.q) {
            if (!(!this.l.isEmpty())) {
                try {
                    this.f2393h.startService(androidx.work.impl.foreground.b.f(this.f2393h));
                } catch (Throwable th) {
                    n.c().b(f2391f, "Unable to stop foreground service", th);
                }
                PowerManager.WakeLock wakeLock = this.f2392g;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.f2392g = null;
                }
            }
        }
    }

    @Override // androidx.work.impl.foreground.a
    public void a(String str, androidx.work.h hVar) {
        synchronized (this.q) {
            n.c().d(f2391f, String.format("Moving WorkSpec (%s) to the foreground", str), new Throwable[0]);
            k kVarRemove = this.m.remove(str);
            if (kVarRemove != null) {
                if (this.f2392g == null) {
                    PowerManager.WakeLock wakeLockB = androidx.work.impl.utils.j.b(this.f2393h, "ProcessorForegroundLck");
                    this.f2392g = wakeLockB;
                    wakeLockB.acquire();
                }
                this.l.put(str, kVarRemove);
                androidx.core.content.a.l(this.f2393h, androidx.work.impl.foreground.b.c(this.f2393h, str, hVar));
            }
        }
    }

    @Override // androidx.work.impl.foreground.a
    public void b(String str) {
        synchronized (this.q) {
            this.l.remove(str);
            m();
        }
    }

    public void c(b bVar) {
        synchronized (this.q) {
            this.p.add(bVar);
        }
    }

    @Override // androidx.work.impl.b
    public void d(String str, boolean z) {
        synchronized (this.q) {
            this.m.remove(str);
            n.c().a(f2391f, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), str, Boolean.valueOf(z)), new Throwable[0]);
            Iterator<b> it = this.p.iterator();
            while (it.hasNext()) {
                it.next().d(str, z);
            }
        }
    }

    public boolean f(String str) {
        boolean zContains;
        synchronized (this.q) {
            zContains = this.o.contains(str);
        }
        return zContains;
    }

    public boolean g(String str) {
        boolean z;
        synchronized (this.q) {
            z = this.m.containsKey(str) || this.l.containsKey(str);
        }
        return z;
    }

    public boolean h(String str) {
        boolean zContainsKey;
        synchronized (this.q) {
            zContainsKey = this.l.containsKey(str);
        }
        return zContainsKey;
    }

    public void i(b bVar) {
        synchronized (this.q) {
            this.p.remove(bVar);
        }
    }

    public boolean j(String str) {
        return k(str, null);
    }

    public boolean k(String str, WorkerParameters.a aVar) {
        synchronized (this.q) {
            if (g(str)) {
                n.c().a(f2391f, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                return false;
            }
            k kVarA = new k.c(this.f2393h, this.f2394i, this.f2395j, this, this.f2396k, str).c(this.n).b(aVar).a();
            e.e.c.a.a.a<Boolean> aVarB = kVarA.b();
            aVarB.g(new a(this, str, aVarB), this.f2395j.a());
            this.m.put(str, kVarA);
            this.f2395j.c().execute(kVarA);
            n.c().a(f2391f, String.format("%s: processing %s", d.class.getSimpleName(), str), new Throwable[0]);
            return true;
        }
    }

    public boolean l(String str) {
        boolean zE;
        synchronized (this.q) {
            boolean z = true;
            n.c().a(f2391f, String.format("Processor cancelling %s", str), new Throwable[0]);
            this.o.add(str);
            k kVarRemove = this.l.remove(str);
            if (kVarRemove == null) {
                z = false;
            }
            if (kVarRemove == null) {
                kVarRemove = this.m.remove(str);
            }
            zE = e(str, kVarRemove);
            if (z) {
                m();
            }
        }
        return zE;
    }

    public boolean n(String str) {
        boolean zE;
        synchronized (this.q) {
            n.c().a(f2391f, String.format("Processor stopping foreground work %s", str), new Throwable[0]);
            zE = e(str, this.l.remove(str));
        }
        return zE;
    }

    public boolean o(String str) {
        boolean zE;
        synchronized (this.q) {
            n.c().a(f2391f, String.format("Processor stopping background work %s", str), new Throwable[0]);
            zE = e(str, this.m.remove(str));
        }
        return zE;
    }
}
