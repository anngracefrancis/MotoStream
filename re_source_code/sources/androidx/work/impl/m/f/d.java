package androidx.work.impl.m.f;

import android.content.Context;
import androidx.work.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: ConstraintTracker.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d<T> {
    private static final String a = n.f("ConstraintTracker");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final androidx.work.impl.utils.p.a f2495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final Context f2496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f2497d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<androidx.work.impl.m.a<T>> f2498e = new LinkedHashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    T f2499f;

    /* JADX INFO: compiled from: ConstraintTracker.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f2500f;

        a(List list) {
            this.f2500f = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f2500f.iterator();
            while (it.hasNext()) {
                ((androidx.work.impl.m.a) it.next()).a(d.this.f2499f);
            }
        }
    }

    d(Context context, androidx.work.impl.utils.p.a aVar) {
        this.f2496c = context.getApplicationContext();
        this.f2495b = aVar;
    }

    public void a(androidx.work.impl.m.a<T> aVar) {
        synchronized (this.f2497d) {
            if (this.f2498e.add(aVar)) {
                if (this.f2498e.size() == 1) {
                    this.f2499f = b();
                    n.c().a(a, String.format("%s: initial state = %s", getClass().getSimpleName(), this.f2499f), new Throwable[0]);
                    e();
                }
                aVar.a(this.f2499f);
            }
        }
    }

    public abstract T b();

    public void c(androidx.work.impl.m.a<T> aVar) {
        synchronized (this.f2497d) {
            if (this.f2498e.remove(aVar) && this.f2498e.isEmpty()) {
                f();
            }
        }
    }

    public void d(T t) {
        synchronized (this.f2497d) {
            T t2 = this.f2499f;
            if (t2 != t && (t2 == null || !t2.equals(t))) {
                this.f2499f = t;
                this.f2495b.a().execute(new a(new ArrayList(this.f2498e)));
            }
        }
    }

    public abstract void e();

    public abstract void f();
}
