package androidx.work.impl.m.e;

import androidx.work.impl.n.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ConstraintController.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c<T> implements androidx.work.impl.m.a<T> {
    private final List<String> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f2486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.work.impl.m.f.d<T> f2487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f2488d;

    /* JADX INFO: compiled from: ConstraintController.java */
    public interface a {
        void a(List<String> list);

        void b(List<String> list);
    }

    c(androidx.work.impl.m.f.d<T> dVar) {
        this.f2487c = dVar;
    }

    private void h(a aVar, T t) {
        if (this.a.isEmpty() || aVar == null) {
            return;
        }
        if (t == null || c(t)) {
            aVar.b(this.a);
        } else {
            aVar.a(this.a);
        }
    }

    @Override // androidx.work.impl.m.a
    public void a(T t) {
        this.f2486b = t;
        h(this.f2488d, t);
    }

    abstract boolean b(p pVar);

    abstract boolean c(T t);

    public boolean d(String str) {
        T t = this.f2486b;
        return t != null && c(t) && this.a.contains(str);
    }

    public void e(Iterable<p> iterable) {
        this.a.clear();
        for (p pVar : iterable) {
            if (b(pVar)) {
                this.a.add(pVar.f2525c);
            }
        }
        if (this.a.isEmpty()) {
            this.f2487c.c(this);
        } else {
            this.f2487c.a(this);
        }
        h(this.f2488d, this.f2486b);
    }

    public void f() {
        if (this.a.isEmpty()) {
            return;
        }
        this.a.clear();
        this.f2487c.c(this);
    }

    public void g(a aVar) {
        if (this.f2488d != aVar) {
            this.f2488d = aVar;
            h(aVar, this.f2486b);
        }
    }
}
