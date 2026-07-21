package androidx.work.impl.m;

import android.content.Context;
import androidx.work.impl.m.e.e;
import androidx.work.impl.m.e.f;
import androidx.work.impl.m.e.g;
import androidx.work.impl.m.e.h;
import androidx.work.impl.n.p;
import androidx.work.n;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: WorkConstraintsTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements androidx.work.impl.m.e.c.a {
    private static final String a = n.f("WorkConstraintsTracker");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f2483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final androidx.work.impl.m.e.c<?>[] f2484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f2485d;

    public d(Context context, androidx.work.impl.utils.p.a aVar, c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.f2483b = cVar;
        this.f2484c = new androidx.work.impl.m.e.c[]{new androidx.work.impl.m.e.a(applicationContext, aVar), new androidx.work.impl.m.e.b(applicationContext, aVar), new h(applicationContext, aVar), new androidx.work.impl.m.e.d(applicationContext, aVar), new g(applicationContext, aVar), new f(applicationContext, aVar), new e(applicationContext, aVar)};
        this.f2485d = new Object();
    }

    @Override // androidx.work.impl.m.e.c.a
    public void a(List<String> list) {
        synchronized (this.f2485d) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (c(str)) {
                    n.c().a(a, String.format("Constraints met for %s", str), new Throwable[0]);
                    arrayList.add(str);
                }
            }
            c cVar = this.f2483b;
            if (cVar != null) {
                cVar.e(arrayList);
            }
        }
    }

    @Override // androidx.work.impl.m.e.c.a
    public void b(List<String> list) {
        synchronized (this.f2485d) {
            c cVar = this.f2483b;
            if (cVar != null) {
                cVar.b(list);
            }
        }
    }

    public boolean c(String str) {
        synchronized (this.f2485d) {
            for (androidx.work.impl.m.e.c<?> cVar : this.f2484c) {
                if (cVar.d(str)) {
                    n.c().a(a, String.format("Work %s constrained by %s", str, cVar.getClass().getSimpleName()), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void d(Iterable<p> iterable) {
        synchronized (this.f2485d) {
            for (androidx.work.impl.m.e.c<?> cVar : this.f2484c) {
                cVar.g(null);
            }
            for (androidx.work.impl.m.e.c<?> cVar2 : this.f2484c) {
                cVar2.e(iterable);
            }
            for (androidx.work.impl.m.e.c<?> cVar3 : this.f2484c) {
                cVar3.g(this);
            }
        }
    }

    public void e() {
        synchronized (this.f2485d) {
            for (androidx.work.impl.m.e.c<?> cVar : this.f2484c) {
                cVar.f();
            }
        }
    }
}
