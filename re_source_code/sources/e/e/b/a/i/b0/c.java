package e.e.b.a.i.b0;

import com.google.android.datatransport.runtime.backends.m;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.y;
import e.e.b.a.i.b0.j.j0;
import e.e.b.a.i.j;
import e.e.b.a.i.q;
import e.e.b.a.i.u;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.inject.Inject;

/* JADX INFO: compiled from: DefaultScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements e {
    private static final Logger a = Logger.getLogger(u.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y f20750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f20751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.backends.e f20752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j0 f20753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.synchronization.a f20754f;

    @Inject
    public c(Executor executor, com.google.android.datatransport.runtime.backends.e eVar, y yVar, j0 j0Var, com.google.android.datatransport.runtime.synchronization.a aVar) {
        this.f20751c = executor;
        this.f20752d = eVar;
        this.f20750b = yVar;
        this.f20753e = j0Var;
        this.f20754f = aVar;
    }

    private /* synthetic */ Object b(q qVar, j jVar) {
        this.f20753e.S0(qVar, jVar);
        this.f20750b.a(qVar, 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(final q qVar, e.e.b.a.h hVar, j jVar) {
        try {
            m mVar = this.f20752d.get(qVar.b());
            if (mVar == null) {
                String str = String.format("Transport backend '%s' is not registered", qVar.b());
                a.warning(str);
                hVar.a(new IllegalArgumentException(str));
            } else {
                final j jVarB = mVar.b(jVar);
                this.f20754f.b(new com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a() { // from class: e.e.b.a.i.b0.b
                    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                    public final Object execute() {
                        this.a.c(qVar, jVarB);
                        return null;
                    }
                });
                hVar.a(null);
            }
        } catch (Exception e2) {
            a.warning("Error scheduling event " + e2.getMessage());
            hVar.a(e2);
        }
    }

    @Override // e.e.b.a.i.b0.e
    public void a(final q qVar, final j jVar, final e.e.b.a.h hVar) {
        this.f20751c.execute(new Runnable() { // from class: e.e.b.a.i.b0.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f20744f.e(qVar, hVar, jVar);
            }
        });
    }

    public /* synthetic */ Object c(q qVar, j jVar) {
        b(qVar, jVar);
        return null;
    }
}
