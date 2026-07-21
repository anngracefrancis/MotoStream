package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.n.p;

/* JADX INFO: compiled from: WorkForegroundRunnable.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final String f2584f = androidx.work.n.f("WorkForegroundRunnable");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final androidx.work.impl.utils.o.c<Void> f2585g = androidx.work.impl.utils.o.c.u();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Context f2586h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final p f2587i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final ListenableWorker f2588j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final androidx.work.i f2589k;
    final androidx.work.impl.utils.p.a l;

    /* JADX INFO: compiled from: WorkForegroundRunnable.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.o.c f2590f;

        a(androidx.work.impl.utils.o.c cVar) {
            this.f2590f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2590f.s(k.this.f2588j.getForegroundInfoAsync());
        }
    }

    /* JADX INFO: compiled from: WorkForegroundRunnable.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.o.c f2592f;

        b(androidx.work.impl.utils.o.c cVar) {
            this.f2592f = cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            try {
                androidx.work.h hVar = (androidx.work.h) this.f2592f.get();
                if (hVar == null) {
                    throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", k.this.f2587i.f2527e));
                }
                androidx.work.n.c().a(k.f2584f, String.format("Updating notification for %s", k.this.f2587i.f2527e), new Throwable[0]);
                k.this.f2588j.setRunInForeground(true);
                k kVar = k.this;
                kVar.f2585g.s(kVar.f2589k.a(kVar.f2586h, kVar.f2588j.getId(), hVar));
            } catch (Throwable th) {
                k.this.f2585g.r(th);
            }
        }
    }

    @SuppressLint({"LambdaLast"})
    public k(Context context, p pVar, ListenableWorker listenableWorker, androidx.work.i iVar, androidx.work.impl.utils.p.a aVar) {
        this.f2586h = context;
        this.f2587i = pVar;
        this.f2588j = listenableWorker;
        this.f2589k = iVar;
        this.l = aVar;
    }

    public e.e.c.a.a.a<Void> a() {
        return this.f2585g;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"UnsafeExperimentalUsageError"})
    public void run() {
        if (!this.f2587i.s || androidx.core.os.a.c()) {
            this.f2585g.q(null);
            return;
        }
        androidx.work.impl.utils.o.c cVarU = androidx.work.impl.utils.o.c.u();
        this.l.a().execute(new a(cVarU));
        cVarU.g(new b(cVarU), this.l.a());
    }
}
