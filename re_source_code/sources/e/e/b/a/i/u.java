package e.e.b.a.i;

import android.content.Context;
import java.util.Collections;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: compiled from: TransportRuntime.java */
/* JADX INFO: loaded from: classes2.dex */
@Singleton
public class u implements t {
    private static volatile v a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.e.b.a.i.c0.a f20847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.e.b.a.i.c0.a f20848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e.e.b.a.i.b0.e f20849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.scheduling.jobscheduling.u f20850e;

    @Inject
    u(e.e.b.a.i.c0.a aVar, e.e.b.a.i.c0.a aVar2, e.e.b.a.i.b0.e eVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.u uVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.w wVar) {
        this.f20847b = aVar;
        this.f20848c = aVar2;
        this.f20849d = eVar;
        this.f20850e = uVar;
        wVar.a();
    }

    private j b(p pVar) {
        return j.a().i(this.f20847b.a()).k(this.f20848c.a()).j(pVar.g()).h(new i(pVar.b(), pVar.d())).g(pVar.c().a()).d();
    }

    public static u c() {
        v vVar = a;
        if (vVar != null) {
            return vVar.b();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set<e.e.b.a.b> d(g gVar) {
        return gVar instanceof h ? Collections.unmodifiableSet(((h) gVar).a()) : Collections.singleton(e.e.b.a.b.b("proto"));
    }

    public static void f(Context context) {
        if (a == null) {
            synchronized (u.class) {
                if (a == null) {
                    a = f.c().a(context).c();
                }
            }
        }
    }

    @Override // e.e.b.a.i.t
    public void a(p pVar, e.e.b.a.h hVar) {
        this.f20849d.a(pVar.f().f(pVar.c().c()), b(pVar), hVar);
    }

    public com.google.android.datatransport.runtime.scheduling.jobscheduling.u e() {
        return this.f20850e;
    }

    public e.e.b.a.g g(g gVar) {
        return new r(d(gVar), q.a().b(gVar.getName()).c(gVar.getExtras()).a(), this);
    }
}
