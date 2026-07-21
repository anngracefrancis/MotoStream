package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.j;
import androidx.work.impl.m.c;
import androidx.work.impl.m.d;
import androidx.work.impl.n.p;
import androidx.work.n;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintTrackingWorker extends ListenableWorker implements c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2643f = n.f("ConstraintTrkngWrkr");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private WorkerParameters f2644g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Object f2645h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    volatile boolean f2646i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    androidx.work.impl.utils.o.c<ListenableWorker.a> f2647j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ListenableWorker f2648k;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ConstraintTrackingWorker.this.f();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e.e.c.a.a.a f2650f;

        b(e.e.c.a.a.a aVar) {
            this.f2650f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (ConstraintTrackingWorker.this.f2645h) {
                if (ConstraintTrackingWorker.this.f2646i) {
                    ConstraintTrackingWorker.this.d();
                } else {
                    ConstraintTrackingWorker.this.f2647j.s(this.f2650f);
                }
            }
        }
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f2644g = workerParameters;
        this.f2645h = new Object();
        this.f2646i = false;
        this.f2647j = androidx.work.impl.utils.o.c.u();
    }

    public WorkDatabase a() {
        return j.p(getApplicationContext()).t();
    }

    @Override // androidx.work.impl.m.c
    public void b(List<String> list) {
        n.c().a(f2643f, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.f2645h) {
            this.f2646i = true;
        }
    }

    void c() {
        this.f2647j.q(ListenableWorker.a.a());
    }

    void d() {
        this.f2647j.q(ListenableWorker.a.b());
    }

    @Override // androidx.work.impl.m.c
    public void e(List<String> list) {
    }

    void f() {
        String strJ = getInputData().j("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty(strJ)) {
            n.c().b(f2643f, "No worker to delegate to.", new Throwable[0]);
            c();
            return;
        }
        ListenableWorker listenableWorkerCreateWorkerWithDefaultFallback = getWorkerFactory().createWorkerWithDefaultFallback(getApplicationContext(), strJ, this.f2644g);
        this.f2648k = listenableWorkerCreateWorkerWithDefaultFallback;
        if (listenableWorkerCreateWorkerWithDefaultFallback == null) {
            n.c().a(f2643f, "No worker to delegate to.", new Throwable[0]);
            c();
            return;
        }
        p pVarM = a().j().m(getId().toString());
        if (pVarM == null) {
            c();
            return;
        }
        d dVar = new d(getApplicationContext(), getTaskExecutor(), this);
        dVar.d(Collections.singletonList(pVarM));
        if (!dVar.c(getId().toString())) {
            n.c().a(f2643f, String.format("Constraints not met for delegate %s. Requesting retry.", strJ), new Throwable[0]);
            d();
            return;
        }
        n.c().a(f2643f, String.format("Constraints met for delegate %s", strJ), new Throwable[0]);
        try {
            e.e.c.a.a.a<ListenableWorker.a> aVarStartWork = this.f2648k.startWork();
            aVarStartWork.g(new b(aVarStartWork), getBackgroundExecutor());
        } catch (Throwable th) {
            n nVarC = n.c();
            String str = f2643f;
            nVarC.a(str, String.format("Delegated worker %s threw exception in startWork.", strJ), th);
            synchronized (this.f2645h) {
                if (this.f2646i) {
                    n.c().a(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                    d();
                } else {
                    c();
                }
            }
        }
    }

    @Override // androidx.work.ListenableWorker
    public androidx.work.impl.utils.p.a getTaskExecutor() {
        return j.p(getApplicationContext()).u();
    }

    @Override // androidx.work.ListenableWorker
    public boolean isRunInForeground() {
        ListenableWorker listenableWorker = this.f2648k;
        return listenableWorker != null && listenableWorker.isRunInForeground();
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.f2648k;
        if (listenableWorker == null || listenableWorker.isStopped()) {
            return;
        }
        this.f2648k.stop();
    }

    @Override // androidx.work.ListenableWorker
    public e.e.c.a.a.a<ListenableWorker.a> startWork() {
        getBackgroundExecutor().execute(new a());
        return this.f2647j;
    }
}
