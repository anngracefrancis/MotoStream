package androidx.work.impl.l.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.e;
import androidx.work.impl.j;
import androidx.work.impl.m.c;
import androidx.work.impl.m.d;
import androidx.work.impl.n.p;
import androidx.work.impl.utils.f;
import androidx.work.n;
import androidx.work.x;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: GreedyScheduler.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements e, c, androidx.work.impl.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2474f = n.f("GreedyScheduler");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f2475g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final j f2476h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d f2477i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private a f2479k;
    private boolean l;
    Boolean n;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Set<p> f2478j = new HashSet();
    private final Object m = new Object();

    public b(Context context, androidx.work.b bVar, androidx.work.impl.utils.p.a aVar, j jVar) {
        this.f2475g = context;
        this.f2476h = jVar;
        this.f2477i = new d(context, aVar, this);
        this.f2479k = new a(this, bVar.k());
    }

    private void f() {
        this.n = Boolean.valueOf(f.b(this.f2475g, this.f2476h.n()));
    }

    private void g() {
        if (this.l) {
            return;
        }
        this.f2476h.r().c(this);
        this.l = true;
    }

    private void h(String str) {
        synchronized (this.m) {
            for (p pVar : this.f2478j) {
                if (pVar.f2525c.equals(str)) {
                    n.c().a(f2474f, String.format("Stopping tracking for %s", str), new Throwable[0]);
                    this.f2478j.remove(pVar);
                    this.f2477i.d(this.f2478j);
                    break;
                }
            }
        }
    }

    @Override // androidx.work.impl.e
    public void a(p... pVarArr) {
        if (this.n == null) {
            f();
        }
        if (!this.n.booleanValue()) {
            n.c().d(f2474f, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        g();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (p pVar : pVarArr) {
            long jA = pVar.a();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (pVar.f2526d == x.a.ENQUEUED) {
                if (jCurrentTimeMillis < jA) {
                    a aVar = this.f2479k;
                    if (aVar != null) {
                        aVar.a(pVar);
                    }
                } else if (pVar.b()) {
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 23 && pVar.l.h()) {
                        n.c().a(f2474f, String.format("Ignoring WorkSpec %s, Requires device idle.", pVar), new Throwable[0]);
                    } else if (i2 < 24 || !pVar.l.e()) {
                        hashSet.add(pVar);
                        hashSet2.add(pVar.f2525c);
                    } else {
                        n.c().a(f2474f, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", pVar), new Throwable[0]);
                    }
                } else {
                    n.c().a(f2474f, String.format("Starting work for %s", pVar.f2525c), new Throwable[0]);
                    this.f2476h.z(pVar.f2525c);
                }
            }
        }
        synchronized (this.m) {
            if (!hashSet.isEmpty()) {
                n.c().a(f2474f, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                this.f2478j.addAll(hashSet);
                this.f2477i.d(this.f2478j);
            }
        }
    }

    @Override // androidx.work.impl.m.c
    public void b(List<String> list) {
        for (String str : list) {
            n.c().a(f2474f, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.f2476h.C(str);
        }
    }

    @Override // androidx.work.impl.e
    public boolean c() {
        return false;
    }

    @Override // androidx.work.impl.e
    public void cancel(String str) {
        if (this.n == null) {
            f();
        }
        if (!this.n.booleanValue()) {
            n.c().d(f2474f, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        g();
        n.c().a(f2474f, String.format("Cancelling work ID %s", str), new Throwable[0]);
        a aVar = this.f2479k;
        if (aVar != null) {
            aVar.b(str);
        }
        this.f2476h.C(str);
    }

    @Override // androidx.work.impl.b
    public void d(String str, boolean z) {
        h(str);
    }

    @Override // androidx.work.impl.m.c
    public void e(List<String> list) {
        for (String str : list) {
            n.c().a(f2474f, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            this.f2476h.z(str);
        }
    }
}
