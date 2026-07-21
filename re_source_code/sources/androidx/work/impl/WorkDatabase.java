package androidx.work.impl;

import android.content.Context;
import androidx.work.impl.n.n;
import androidx.work.impl.n.q;
import androidx.work.impl.n.t;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class WorkDatabase extends androidx.room.j {
    private static final long a = TimeUnit.DAYS.toMillis(1);

    class a implements c.u.a.c.InterfaceC0094c {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // c.u.a.c.InterfaceC0094c
        public c.u.a.c a(c.u.a.c.b bVar) {
            c.u.a.c.b.a aVarA = c.u.a.c.b.a(this.a);
            aVarA.c(bVar.f3470b).b(bVar.f3471c).d(true);
            return new c.u.a.g.c().a(aVarA.a());
        }
    }

    class b extends androidx.room.j.b {
        b() {
        }

        @Override // androidx.room.j.b
        public void c(c.u.a.b bVar) {
            super.c(bVar);
            bVar.n();
            try {
                bVar.v(WorkDatabase.e());
                bVar.j0();
            } finally {
                bVar.z0();
            }
        }
    }

    public static WorkDatabase a(Context context, Executor executor, boolean z) {
        androidx.room.j.a aVarA;
        if (z) {
            aVarA = androidx.room.i.c(context, WorkDatabase.class).c();
        } else {
            aVarA = androidx.room.i.a(context, WorkDatabase.class, i.d());
            aVarA.f(new a(context));
        }
        return (WorkDatabase) aVarA.g(executor).a(c()).b(h.a).b(new h.C0051h(context, 2, 3)).b(h.f2432b).b(h.f2433c).b(new h.C0051h(context, 5, 6)).b(h.f2434d).b(h.f2435e).b(h.f2436f).b(new h.i(context)).b(new h.C0051h(context, 10, 11)).b(h.f2437g).e().d();
    }

    static androidx.room.j.b c() {
        return new b();
    }

    static long d() {
        return System.currentTimeMillis() - a;
    }

    static String e() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + d() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }

    public abstract androidx.work.impl.n.b b();

    public abstract androidx.work.impl.n.e f();

    public abstract androidx.work.impl.n.h g();

    public abstract androidx.work.impl.n.k h();

    public abstract n i();

    public abstract q j();

    public abstract t k();
}
