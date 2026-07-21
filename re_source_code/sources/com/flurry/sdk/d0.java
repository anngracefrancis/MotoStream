package com.flurry.sdk;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 extends d7<c0> {
    public AtomicLong p;
    public AtomicLong q;
    public AtomicBoolean r;
    public long s;
    private long t;
    public List<e.d.a.c> u;
    private h7 v;
    private f7<i7> w;

    final class a implements f7<i7> {
        a() {
        }

        @Override // com.flurry.sdk.f7
        public final /* synthetic */ void a(i7 i7Var) {
            int i2 = g.a[i7Var.f10835b.ordinal()];
            if (i2 == 1) {
                d0.this.C(f0.FOREGROUND, false);
            } else {
                if (i2 != 2) {
                    return;
                }
                d0.this.D(f0.FOREGROUND, false);
            }
        }
    }

    final class b extends f2 {
        b() {
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            d0.this.t = p2.f("initial_run_time", Long.MIN_VALUE);
        }
    }

    public class c extends f2 {
        public c() {
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            d0.this.t = Long.MIN_VALUE;
        }
    }

    final class d extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f10690h;

        d(List list) {
            this.f10690h = list;
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            for (e.d.a.c cVar : this.f10690h) {
                if (cVar != null) {
                    cVar.a();
                }
            }
        }
    }

    final class e extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ f0 f10692h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f10693i;

        e(f0 f0Var, boolean z) {
            this.f10692h = f0Var;
            this.f10693i = z;
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            d1.c(3, "ReportingProvider", "Start session: " + this.f10692h.name() + ", isManualSession: " + this.f10693i);
            d0.B(d0.this, this.f10692h, e0.SESSION_START, this.f10693i);
        }
    }

    final class f extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ f0 f10695h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f10696i;

        f(f0 f0Var, boolean z) {
            this.f10695h = f0Var;
            this.f10696i = z;
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            d1.c(3, "ReportingProvider", "End session: " + this.f10695h.name() + ", isManualSession: " + this.f10696i);
            d0.B(d0.this, this.f10695h, e0.SESSION_END, this.f10696i);
        }
    }

    static /* synthetic */ class g {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[g7.values().length];
            a = iArr;
            try {
                iArr[g7.FOREGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[g7.BACKGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public d0(h7 h7Var) {
        super("ReportingProvider");
        this.p = new AtomicLong(0L);
        this.q = new AtomicLong(0L);
        this.r = new AtomicBoolean(true);
        this.w = new a();
        this.u = new ArrayList();
        this.v = h7Var;
        h7Var.v(this.w);
        m(new b());
    }

    static /* synthetic */ void B(d0 d0Var, f0 f0Var, e0 e0Var, boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (d0Var.t == Long.MIN_VALUE) {
            d0Var.t = jCurrentTimeMillis;
            p2.c("initial_run_time", jCurrentTimeMillis);
            d1.c(3, "ReportingProvider", "Refresh initial timestamp");
        }
        d0Var.t(new c0(f0Var, jCurrentTimeMillis, d0Var.t, f0Var.equals(f0.FOREGROUND) ? d0Var.s : 60000L, e0Var, z));
    }

    public final void A(e.d.a.c cVar) {
        if (cVar == null) {
            d1.c(2, "ReportingProvider", "Cannot register with null listener");
        } else {
            this.u.add(cVar);
        }
    }

    public final void C(f0 f0Var, boolean z) {
        m(new e(f0Var, z));
    }

    public final void D(f0 f0Var, boolean z) {
        m(new f(f0Var, z));
    }

    public final String y() {
        return String.valueOf(this.p.get());
    }

    public final void z(long j2, long j3) {
        this.p.set(j2);
        this.q.set(j3);
        if (this.u.isEmpty()) {
            return;
        }
        r(new d(new ArrayList(this.u)));
    }
}
