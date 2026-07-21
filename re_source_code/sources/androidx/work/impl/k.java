package androidx.work.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.n.p;
import androidx.work.impl.n.q;
import androidx.work.impl.n.t;
import androidx.work.impl.utils.l;
import androidx.work.impl.utils.m;
import androidx.work.n;
import androidx.work.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: WorkerWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final String f2449f = n.f("WorkerWrapper");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Context f2450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f2451h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<e> f2452i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private WorkerParameters.a f2453j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    p f2454k;
    ListenableWorker l;
    androidx.work.impl.utils.p.a m;
    private androidx.work.b o;
    private androidx.work.impl.foreground.a p;
    private WorkDatabase q;
    private q r;
    private androidx.work.impl.n.b s;
    private t t;
    private List<String> u;
    private String v;
    private volatile boolean y;
    ListenableWorker.a n = ListenableWorker.a.a();
    androidx.work.impl.utils.o.c<Boolean> w = androidx.work.impl.utils.o.c.u();
    e.e.c.a.a.a<ListenableWorker.a> x = null;

    /* JADX INFO: compiled from: WorkerWrapper.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e.e.c.a.a.a f2455f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.o.c f2456g;

        a(e.e.c.a.a.a aVar, androidx.work.impl.utils.o.c cVar) {
            this.f2455f = aVar;
            this.f2456g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f2455f.get();
                n.c().a(k.f2449f, String.format("Starting work for %s", k.this.f2454k.f2527e), new Throwable[0]);
                k kVar = k.this;
                kVar.x = kVar.l.startWork();
                this.f2456g.s(k.this.x);
            } catch (Throwable th) {
                this.f2456g.r(th);
            }
        }
    }

    /* JADX INFO: compiled from: WorkerWrapper.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.o.c f2458f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f2459g;

        b(androidx.work.impl.utils.o.c cVar, String str) {
            this.f2458f = cVar;
            this.f2459g = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            try {
                try {
                    ListenableWorker.a aVar = (ListenableWorker.a) this.f2458f.get();
                    if (aVar == null) {
                        n.c().b(k.f2449f, String.format("%s returned a null result. Treating it as a failure.", k.this.f2454k.f2527e), new Throwable[0]);
                    } else {
                        n.c().a(k.f2449f, String.format("%s returned a %s result.", k.this.f2454k.f2527e, aVar), new Throwable[0]);
                        k.this.n = aVar;
                    }
                } catch (InterruptedException e2) {
                    e = e2;
                    n.c().b(k.f2449f, String.format("%s failed because it threw an exception/error", this.f2459g), e);
                } catch (CancellationException e3) {
                    n.c().d(k.f2449f, String.format("%s was cancelled", this.f2459g), e3);
                } catch (ExecutionException e4) {
                    e = e4;
                    n.c().b(k.f2449f, String.format("%s failed because it threw an exception/error", this.f2459g), e);
                }
                k.this.f();
            } catch (Throwable th) {
                k.this.f();
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: WorkerWrapper.java */
    public static class c {
        Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ListenableWorker f2461b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        androidx.work.impl.foreground.a f2462c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        androidx.work.impl.utils.p.a f2463d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        androidx.work.b f2464e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        WorkDatabase f2465f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        String f2466g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        List<e> f2467h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        WorkerParameters.a f2468i = new WorkerParameters.a();

        public c(Context context, androidx.work.b bVar, androidx.work.impl.utils.p.a aVar, androidx.work.impl.foreground.a aVar2, WorkDatabase workDatabase, String str) {
            this.a = context.getApplicationContext();
            this.f2463d = aVar;
            this.f2462c = aVar2;
            this.f2464e = bVar;
            this.f2465f = workDatabase;
            this.f2466g = str;
        }

        public k a() {
            return new k(this);
        }

        public c b(WorkerParameters.a aVar) {
            if (aVar != null) {
                this.f2468i = aVar;
            }
            return this;
        }

        public c c(List<e> list) {
            this.f2467h = list;
            return this;
        }
    }

    k(c cVar) {
        this.f2450g = cVar.a;
        this.m = cVar.f2463d;
        this.p = cVar.f2462c;
        this.f2451h = cVar.f2466g;
        this.f2452i = cVar.f2467h;
        this.f2453j = cVar.f2468i;
        this.l = cVar.f2461b;
        this.o = cVar.f2464e;
        WorkDatabase workDatabase = cVar.f2465f;
        this.q = workDatabase;
        this.r = workDatabase.j();
        this.s = this.q.b();
        this.t = this.q.k();
    }

    private String a(List<String> list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.f2451h);
        sb.append(", tags={ ");
        boolean z = true;
        for (String str : list) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    private void c(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.c) {
            n.c().d(f2449f, String.format("Worker result SUCCESS for %s", this.v), new Throwable[0]);
            if (this.f2454k.d()) {
                h();
                return;
            } else {
                m();
                return;
            }
        }
        if (aVar instanceof ListenableWorker.a.b) {
            n.c().d(f2449f, String.format("Worker result RETRY for %s", this.v), new Throwable[0]);
            g();
            return;
        }
        n.c().d(f2449f, String.format("Worker result FAILURE for %s", this.v), new Throwable[0]);
        if (this.f2454k.d()) {
            h();
        } else {
            l();
        }
    }

    private void e(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.r.l(str2) != x.a.CANCELLED) {
                this.r.a(x.a.FAILED, str2);
            }
            linkedList.addAll(this.s.b(str2));
        }
    }

    private void g() {
        this.q.beginTransaction();
        try {
            this.r.a(x.a.ENQUEUED, this.f2451h);
            this.r.r(this.f2451h, System.currentTimeMillis());
            this.r.b(this.f2451h, -1L);
            this.q.setTransactionSuccessful();
        } finally {
            this.q.endTransaction();
            i(true);
        }
    }

    private void h() {
        this.q.beginTransaction();
        try {
            this.r.r(this.f2451h, System.currentTimeMillis());
            this.r.a(x.a.ENQUEUED, this.f2451h);
            this.r.n(this.f2451h);
            this.r.b(this.f2451h, -1L);
            this.q.setTransactionSuccessful();
        } finally {
            this.q.endTransaction();
            i(false);
        }
    }

    private void i(boolean z) {
        ListenableWorker listenableWorker;
        this.q.beginTransaction();
        try {
            if (!this.q.j().j()) {
                androidx.work.impl.utils.d.a(this.f2450g, RescheduleReceiver.class, false);
            }
            if (z) {
                this.r.a(x.a.ENQUEUED, this.f2451h);
                this.r.b(this.f2451h, -1L);
            }
            if (this.f2454k != null && (listenableWorker = this.l) != null && listenableWorker.isRunInForeground()) {
                this.p.b(this.f2451h);
            }
            this.q.setTransactionSuccessful();
            this.q.endTransaction();
            this.w.q(Boolean.valueOf(z));
        } catch (Throwable th) {
            this.q.endTransaction();
            throw th;
        }
    }

    private void j() {
        x.a aVarL = this.r.l(this.f2451h);
        if (aVarL == x.a.RUNNING) {
            n.c().a(f2449f, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.f2451h), new Throwable[0]);
            i(true);
        } else {
            n.c().a(f2449f, String.format("Status for %s is %s; not doing any work", this.f2451h, aVarL), new Throwable[0]);
            i(false);
        }
    }

    private void k() {
        androidx.work.e eVarB;
        if (n()) {
            return;
        }
        this.q.beginTransaction();
        try {
            p pVarM = this.r.m(this.f2451h);
            this.f2454k = pVarM;
            if (pVarM == null) {
                n.c().b(f2449f, String.format("Didn't find WorkSpec for id %s", this.f2451h), new Throwable[0]);
                i(false);
                this.q.setTransactionSuccessful();
                this.q.endTransaction();
                return;
            }
            if (pVarM.f2526d != x.a.ENQUEUED) {
                j();
                this.q.setTransactionSuccessful();
                n.c().a(f2449f, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.f2454k.f2527e), new Throwable[0]);
                this.q.endTransaction();
                return;
            }
            if (pVarM.d() || this.f2454k.c()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                p pVar = this.f2454k;
                if (!(pVar.p == 0) && jCurrentTimeMillis < pVar.a()) {
                    n.c().a(f2449f, String.format("Delaying execution for %s because it is being executed before schedule.", this.f2454k.f2527e), new Throwable[0]);
                    i(true);
                    this.q.setTransactionSuccessful();
                    this.q.endTransaction();
                    return;
                }
            }
            this.q.setTransactionSuccessful();
            this.q.endTransaction();
            if (this.f2454k.d()) {
                eVarB = this.f2454k.f2529g;
            } else {
                androidx.work.k kVarB = this.o.f().b(this.f2454k.f2528f);
                if (kVarB == null) {
                    n.c().b(f2449f, String.format("Could not create Input Merger %s", this.f2454k.f2528f), new Throwable[0]);
                    l();
                    return;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f2454k.f2529g);
                    arrayList.addAll(this.r.p(this.f2451h));
                    eVarB = kVarB.b(arrayList);
                }
            }
            WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.f2451h), eVarB, this.u, this.f2453j, this.f2454k.m, this.o.e(), this.m, this.o.m(), new m(this.q, this.m), new l(this.q, this.p, this.m));
            if (this.l == null) {
                this.l = this.o.m().createWorkerWithDefaultFallback(this.f2450g, this.f2454k.f2527e, workerParameters);
            }
            ListenableWorker listenableWorker = this.l;
            if (listenableWorker == null) {
                n.c().b(f2449f, String.format("Could not create Worker %s", this.f2454k.f2527e), new Throwable[0]);
                l();
                return;
            }
            if (listenableWorker.isUsed()) {
                n.c().b(f2449f, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.f2454k.f2527e), new Throwable[0]);
                l();
                return;
            }
            this.l.setUsed();
            if (!o()) {
                j();
                return;
            }
            if (n()) {
                return;
            }
            androidx.work.impl.utils.o.c cVarU = androidx.work.impl.utils.o.c.u();
            androidx.work.impl.utils.k kVar = new androidx.work.impl.utils.k(this.f2450g, this.f2454k, this.l, workerParameters.b(), this.m);
            this.m.a().execute(kVar);
            e.e.c.a.a.a<Void> aVarA = kVar.a();
            aVarA.g(new a(aVarA, cVarU), this.m.a());
            cVarU.g(new b(cVarU, this.v), this.m.c());
        } catch (Throwable th) {
            this.q.endTransaction();
            throw th;
        }
    }

    private void m() {
        this.q.beginTransaction();
        try {
            this.r.a(x.a.SUCCEEDED, this.f2451h);
            this.r.h(this.f2451h, ((ListenableWorker.a.c) this.n).e());
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (String str : this.s.b(this.f2451h)) {
                if (this.r.l(str) == x.a.BLOCKED && this.s.c(str)) {
                    n.c().d(f2449f, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                    this.r.a(x.a.ENQUEUED, str);
                    this.r.r(str, jCurrentTimeMillis);
                }
            }
            this.q.setTransactionSuccessful();
        } finally {
            this.q.endTransaction();
            i(false);
        }
    }

    private boolean n() {
        if (!this.y) {
            return false;
        }
        n.c().a(f2449f, String.format("Work interrupted for %s", this.v), new Throwable[0]);
        x.a aVarL = this.r.l(this.f2451h);
        if (aVarL == null) {
            i(false);
        } else {
            i(!aVarL.g());
        }
        return true;
    }

    private boolean o() {
        this.q.beginTransaction();
        try {
            boolean z = true;
            if (this.r.l(this.f2451h) == x.a.ENQUEUED) {
                this.r.a(x.a.RUNNING, this.f2451h);
                this.r.q(this.f2451h);
            } else {
                z = false;
            }
            this.q.setTransactionSuccessful();
            return z;
        } finally {
            this.q.endTransaction();
        }
    }

    public e.e.c.a.a.a<Boolean> b() {
        return this.w;
    }

    public void d() {
        boolean zIsDone;
        this.y = true;
        n();
        e.e.c.a.a.a<ListenableWorker.a> aVar = this.x;
        if (aVar != null) {
            zIsDone = aVar.isDone();
            this.x.cancel(true);
        } else {
            zIsDone = false;
        }
        ListenableWorker listenableWorker = this.l;
        if (listenableWorker == null || zIsDone) {
            n.c().a(f2449f, String.format("WorkSpec %s is already done. Not interrupting.", this.f2454k), new Throwable[0]);
        } else {
            listenableWorker.stop();
        }
    }

    void f() {
        if (!n()) {
            this.q.beginTransaction();
            try {
                x.a aVarL = this.r.l(this.f2451h);
                this.q.i().delete(this.f2451h);
                if (aVarL == null) {
                    i(false);
                } else if (aVarL == x.a.RUNNING) {
                    c(this.n);
                } else if (!aVarL.g()) {
                    g();
                }
                this.q.setTransactionSuccessful();
                this.q.endTransaction();
            } catch (Throwable th) {
                this.q.endTransaction();
                throw th;
            }
        }
        List<e> list = this.f2452i;
        if (list != null) {
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                it.next().cancel(this.f2451h);
            }
            f.b(this.o, this.q, this.f2452i);
        }
    }

    void l() {
        this.q.beginTransaction();
        try {
            e(this.f2451h);
            this.r.h(this.f2451h, ((ListenableWorker.a.C0047a) this.n).e());
            this.q.setTransactionSuccessful();
        } finally {
            this.q.endTransaction();
            i(false);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        List<String> listB = this.t.b(this.f2451h);
        this.u = listB;
        this.v = a(listB);
        k();
    }
}
