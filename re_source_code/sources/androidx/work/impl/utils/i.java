package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.n.q;
import androidx.work.x;

/* JADX INFO: compiled from: StopWorkRunnable.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2579f = androidx.work.n.f("StopWorkRunnable");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final androidx.work.impl.j f2580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f2581h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f2582i;

    public i(androidx.work.impl.j jVar, String str, boolean z) {
        this.f2580g = jVar;
        this.f2581h = str;
        this.f2582i = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zO;
        WorkDatabase workDatabaseT = this.f2580g.t();
        androidx.work.impl.d dVarR = this.f2580g.r();
        q qVarJ = workDatabaseT.j();
        workDatabaseT.beginTransaction();
        try {
            boolean zH = dVarR.h(this.f2581h);
            if (this.f2582i) {
                zO = this.f2580g.r().n(this.f2581h);
            } else {
                if (!zH && qVarJ.l(this.f2581h) == x.a.RUNNING) {
                    qVarJ.a(x.a.ENQUEUED, this.f2581h);
                }
                zO = this.f2580g.r().o(this.f2581h);
            }
            androidx.work.n.c().a(f2579f, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.f2581h, Boolean.valueOf(zO)), new Throwable[0]);
            workDatabaseT.setTransactionSuccessful();
        } finally {
            workDatabaseT.endTransaction();
        }
    }
}
