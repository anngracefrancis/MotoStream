package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.n.p;
import androidx.work.t;
import androidx.work.x;
import java.util.UUID;

/* JADX INFO: compiled from: WorkProgressUpdater.java */
/* JADX INFO: loaded from: classes.dex */
public class m implements t {
    static final String a = androidx.work.n.f("WorkProgressUpdater");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final WorkDatabase f2602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final androidx.work.impl.utils.p.a f2603c;

    /* JADX INFO: compiled from: WorkProgressUpdater.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ UUID f2604f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ androidx.work.e f2605g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.o.c f2606h;

        a(UUID uuid, androidx.work.e eVar, androidx.work.impl.utils.o.c cVar) {
            this.f2604f = uuid;
            this.f2605g = eVar;
            this.f2606h = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String string = this.f2604f.toString();
            androidx.work.n nVarC = androidx.work.n.c();
            String str = m.a;
            nVarC.a(str, String.format("Updating progress for %s (%s)", this.f2604f, this.f2605g), new Throwable[0]);
            m.this.f2602b.beginTransaction();
            try {
                p pVarM = m.this.f2602b.j().m(string);
                if (pVarM == null) {
                    throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                }
                if (pVarM.f2526d == x.a.RUNNING) {
                    m.this.f2602b.i().b(new androidx.work.impl.n.m(string, this.f2605g));
                } else {
                    androidx.work.n.c().h(str, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", string), new Throwable[0]);
                }
                this.f2606h.q(null);
                m.this.f2602b.setTransactionSuccessful();
            } catch (Throwable th) {
                try {
                    androidx.work.n.c().b(m.a, "Error updating Worker progress", th);
                    this.f2606h.r(th);
                } finally {
                    m.this.f2602b.endTransaction();
                }
            }
        }
    }

    public m(WorkDatabase workDatabase, androidx.work.impl.utils.p.a aVar) {
        this.f2602b = workDatabase;
        this.f2603c = aVar;
    }

    @Override // androidx.work.t
    public e.e.c.a.a.a<Void> a(Context context, UUID uuid, androidx.work.e eVar) {
        androidx.work.impl.utils.o.c cVarU = androidx.work.impl.utils.o.c.u();
        this.f2603c.b(new a(uuid, eVar, cVarU));
        return cVarU;
    }
}
