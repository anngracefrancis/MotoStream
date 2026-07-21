package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import e.e.b.a.i.b0.j.i0;
import e.e.b.a.i.b0.j.j0;
import e.e.b.a.i.b0.j.q0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes2.dex */
public class u {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.backends.e f11355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j0 f11356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final y f11357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f11358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.synchronization.a f11359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e.e.b.a.i.c0.a f11360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final e.e.b.a.i.c0.a f11361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final i0 f11362i;

    @Inject
    public u(Context context, com.google.android.datatransport.runtime.backends.e eVar, j0 j0Var, y yVar, Executor executor, com.google.android.datatransport.runtime.synchronization.a aVar, e.e.b.a.i.c0.a aVar2, e.e.b.a.i.c0.a aVar3, i0 i0Var) {
        this.a = context;
        this.f11355b = eVar;
        this.f11356c = j0Var;
        this.f11357d = yVar;
        this.f11358e = executor;
        this.f11359f = aVar;
        this.f11360g = aVar2;
        this.f11361h = aVar3;
        this.f11362i = i0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean d(e.e.b.a.i.q qVar) {
        return Boolean.valueOf(this.f11356c.b1(qVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Iterable f(e.e.b.a.i.q qVar) {
        return this.f11356c.G(qVar);
    }

    private /* synthetic */ Object g(Iterable iterable, e.e.b.a.i.q qVar, long j2) {
        this.f11356c.e1(iterable);
        this.f11356c.O(qVar, this.f11360g.a() + j2);
        return null;
    }

    private /* synthetic */ Object i(Iterable iterable) {
        this.f11356c.q(iterable);
        return null;
    }

    private /* synthetic */ Object k() {
        this.f11362i.a();
        return null;
    }

    private /* synthetic */ Object m(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.f11362i.d(((Integer) entry.getValue()).intValue(), e.e.b.a.i.y.a.c.b.INVALID_PAYLOD, (String) entry.getKey());
        }
        return null;
    }

    private /* synthetic */ Object o(e.e.b.a.i.q qVar, long j2) {
        this.f11356c.O(qVar, this.f11360g.a() + j2);
        return null;
    }

    private /* synthetic */ Object q(e.e.b.a.i.q qVar, int i2) {
        this.f11357d.a(qVar, i2 + 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(final e.e.b.a.i.q qVar, final int i2, Runnable runnable) {
        try {
            try {
                com.google.android.datatransport.runtime.synchronization.a aVar = this.f11359f;
                final j0 j0Var = this.f11356c;
                j0Var.getClass();
                aVar.b(new com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.b
                    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                    public final Object execute() {
                        return Integer.valueOf(j0Var.o());
                    }
                });
                if (b()) {
                    u(qVar, i2);
                } else {
                    this.f11359f.b(new com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.k
                        @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                        public final Object execute() {
                            this.a.r(qVar, i2);
                            return null;
                        }
                    });
                }
            } catch (SynchronizationException unused) {
                this.f11357d.a(qVar, i2 + 1);
            }
        } finally {
            runnable.run();
        }
    }

    public e.e.b.a.i.j a(com.google.android.datatransport.runtime.backends.m mVar) {
        com.google.android.datatransport.runtime.synchronization.a aVar = this.f11359f;
        final i0 i0Var = this.f11362i;
        i0Var.getClass();
        return mVar.b(e.e.b.a.i.j.a().i(this.f11360g.a()).k(this.f11361h.a()).j("GDT_CLIENT_METRICS").h(new e.e.b.a.i.i(e.e.b.a.b.b("proto"), ((e.e.b.a.i.y.a.a) aVar.b(new com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.o
            @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
            public final Object execute() {
                return i0Var.c();
            }
        })).f())).d());
    }

    boolean b() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public /* synthetic */ Object h(Iterable iterable, e.e.b.a.i.q qVar, long j2) {
        g(iterable, qVar, j2);
        return null;
    }

    public /* synthetic */ Object j(Iterable iterable) {
        i(iterable);
        return null;
    }

    public /* synthetic */ Object l() {
        k();
        return null;
    }

    public /* synthetic */ Object n(Map map) {
        m(map);
        return null;
    }

    public /* synthetic */ Object p(e.e.b.a.i.q qVar, long j2) {
        o(qVar, j2);
        return null;
    }

    public /* synthetic */ Object r(e.e.b.a.i.q qVar, int i2) {
        q(qVar, i2);
        return null;
    }

    public com.google.android.datatransport.runtime.backends.g u(final e.e.b.a.i.q qVar, int i2) {
        com.google.android.datatransport.runtime.backends.g gVarA;
        com.google.android.datatransport.runtime.backends.m mVar = this.f11355b.get(qVar.b());
        long jMax = 0;
        com.google.android.datatransport.runtime.backends.g gVarE = com.google.android.datatransport.runtime.backends.g.e(0L);
        while (true) {
            final long j2 = jMax;
            while (true) {
                if (!((Boolean) this.f11359f.b(new com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.e
                    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                    public final Object execute() {
                        return this.a.d(qVar);
                    }
                })).booleanValue()) {
                    this.f11359f.b(new com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.i
                        @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                        public final Object execute() {
                            this.a.p(qVar, j2);
                            return null;
                        }
                    });
                    return gVarE;
                }
                final Iterable iterable = (Iterable) this.f11359f.b(new com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.g
                    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                    public final Object execute() {
                        return this.a.f(qVar);
                    }
                });
                if (!iterable.iterator().hasNext()) {
                    return gVarE;
                }
                if (mVar == null) {
                    e.e.b.a.i.z.a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", qVar);
                    gVarA = com.google.android.datatransport.runtime.backends.g.a();
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((q0) it.next()).b());
                    }
                    if (qVar.e()) {
                        arrayList.add(a(mVar));
                    }
                    gVarA = mVar.a(com.google.android.datatransport.runtime.backends.f.a().b(arrayList).c(qVar.c()).a());
                }
                gVarE = gVarA;
                if (gVarE.c() == com.google.android.datatransport.runtime.backends.g.a.TRANSIENT_ERROR) {
                    this.f11359f.b(new com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.h
                        @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                        public final Object execute() {
                            this.a.h(iterable, qVar, j2);
                            return null;
                        }
                    });
                    this.f11357d.b(qVar, i2 + 1, true);
                    return gVarE;
                }
                this.f11359f.b(new com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.j
                    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                    public final Object execute() {
                        this.a.j(iterable);
                        return null;
                    }
                });
                if (gVarE.c() == com.google.android.datatransport.runtime.backends.g.a.OK) {
                    break;
                }
                if (gVarE.c() == com.google.android.datatransport.runtime.backends.g.a.INVALID_PAYLOAD) {
                    final HashMap map = new HashMap();
                    Iterator it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        String strJ = ((q0) it2.next()).b().j();
                        if (map.containsKey(strJ)) {
                            map.put(strJ, Integer.valueOf(((Integer) map.get(strJ)).intValue() + 1));
                        } else {
                            map.put(strJ, 1);
                        }
                    }
                    this.f11359f.b(new com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.f
                        @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                        public final Object execute() {
                            this.a.n(map);
                            return null;
                        }
                    });
                }
            }
            jMax = Math.max(j2, gVarE.b());
            if (qVar.e()) {
                this.f11359f.b(new com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.l
                    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a
                    public final Object execute() {
                        this.a.l();
                        return null;
                    }
                });
            }
        }
    }

    public void v(final e.e.b.a.i.q qVar, final int i2, final Runnable runnable) {
        this.f11358e.execute(new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f11323f.t(qVar, i2, runnable);
            }
        });
    }
}
