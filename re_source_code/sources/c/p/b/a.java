package c.p.b;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.os.OperationCanceledException;
import c.i.j.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: AsyncTaskLoader.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<D> extends b<D> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Executor f3366j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    volatile a<D>.RunnableC0085a f3367k;
    volatile a<D>.RunnableC0085a l;
    long m;
    long n;
    Handler o;

    /* JADX INFO: renamed from: c.p.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncTaskLoader.java */
    final class RunnableC0085a extends c<Void, Void, D> implements Runnable {
        private final CountDownLatch p = new CountDownLatch(1);
        boolean q;

        RunnableC0085a() {
        }

        @Override // c.p.b.c
        protected void h(D d2) {
            try {
                a.this.y(this, d2);
            } finally {
                this.p.countDown();
            }
        }

        @Override // c.p.b.c
        protected void i(D d2) {
            try {
                a.this.z(this, d2);
            } finally {
                this.p.countDown();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // c.p.b.c
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public D b(Void... voidArr) {
            try {
                return (D) a.this.D();
            } catch (OperationCanceledException e2) {
                if (f()) {
                    return null;
                }
                throw e2;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.q = false;
            a.this.A();
        }
    }

    public a(Context context) {
        this(context, c.f3378h);
    }

    void A() {
        if (this.l != null || this.f3367k == null) {
            return;
        }
        if (this.f3367k.q) {
            this.f3367k.q = false;
            this.o.removeCallbacks(this.f3367k);
        }
        if (this.m <= 0 || SystemClock.uptimeMillis() >= this.n + this.m) {
            this.f3367k.c(this.f3366j, null);
        } else {
            this.f3367k.q = true;
            this.o.postAtTime(this.f3367k, this.n + this.m);
        }
    }

    public abstract D B();

    public void C(D d2) {
    }

    protected D D() {
        return B();
    }

    @Override // c.p.b.b
    @Deprecated
    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.h(str, fileDescriptor, printWriter, strArr);
        if (this.f3367k != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f3367k);
            printWriter.print(" waiting=");
            printWriter.println(this.f3367k.q);
        }
        if (this.l != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.l);
            printWriter.print(" waiting=");
            printWriter.println(this.l.q);
        }
        if (this.m != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            j.c(this.m, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            j.b(this.n, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    @Override // c.p.b.b
    protected boolean l() {
        if (this.f3367k == null) {
            return false;
        }
        if (!this.f3371e) {
            this.f3374h = true;
        }
        if (this.l != null) {
            if (this.f3367k.q) {
                this.f3367k.q = false;
                this.o.removeCallbacks(this.f3367k);
            }
            this.f3367k = null;
            return false;
        }
        if (this.f3367k.q) {
            this.f3367k.q = false;
            this.o.removeCallbacks(this.f3367k);
            this.f3367k = null;
            return false;
        }
        boolean zA = this.f3367k.a(false);
        if (zA) {
            this.l = this.f3367k;
            x();
        }
        this.f3367k = null;
        return zA;
    }

    @Override // c.p.b.b
    protected void n() {
        super.n();
        c();
        this.f3367k = new RunnableC0085a();
        A();
    }

    public void x() {
    }

    void y(a<D>.RunnableC0085a runnableC0085a, D d2) {
        C(d2);
        if (this.l == runnableC0085a) {
            t();
            this.n = SystemClock.uptimeMillis();
            this.l = null;
            f();
            A();
        }
    }

    void z(a<D>.RunnableC0085a runnableC0085a, D d2) {
        if (this.f3367k != runnableC0085a) {
            y(runnableC0085a, d2);
            return;
        }
        if (j()) {
            C(d2);
            return;
        }
        d();
        this.n = SystemClock.uptimeMillis();
        this.f3367k = null;
        g(d2);
    }

    private a(Context context, Executor executor) {
        super(context);
        this.n = -10000L;
        this.f3366j = executor;
    }
}
