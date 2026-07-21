package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {
    static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f1717b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c.b.a.b.b<r<? super T>, LiveData<T>.c> f1718c = new c.b.a.b.b<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1719d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile Object f1721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile Object f1722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1723h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1724i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1725j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Runnable f1726k;

    class LifecycleBoundObserver extends LiveData<T>.c implements i {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final k f1727e;

        LifecycleBoundObserver(k kVar, r<? super T> rVar) {
            super(rVar);
            this.f1727e = kVar;
        }

        @Override // androidx.lifecycle.i
        public void a(k kVar, g.b bVar) {
            g.c cVarB = this.f1727e.getLifecycle().b();
            if (cVarB == g.c.DESTROYED) {
                LiveData.this.m(this.a);
                return;
            }
            g.c cVar = null;
            while (cVar != cVarB) {
                b(e());
                cVar = cVarB;
                cVarB = this.f1727e.getLifecycle().b();
            }
        }

        @Override // androidx.lifecycle.LiveData.c
        void c() {
            this.f1727e.getLifecycle().c(this);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean d(k kVar) {
            return this.f1727e == kVar;
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean e() {
            return this.f1727e.getLifecycle().b().g(g.c.STARTED);
        }
    }

    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f1717b) {
                obj = LiveData.this.f1722g;
                LiveData.this.f1722g = LiveData.a;
            }
            LiveData.this.n(obj);
        }
    }

    private class b extends LiveData<T>.c {
        b(r<? super T> rVar) {
            super(rVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean e() {
            return true;
        }
    }

    private abstract class c {
        final r<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f1731b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1732c = -1;

        c(r<? super T> rVar) {
            this.a = rVar;
        }

        void b(boolean z) {
            if (z == this.f1731b) {
                return;
            }
            this.f1731b = z;
            LiveData.this.c(z ? 1 : -1);
            if (this.f1731b) {
                LiveData.this.e(this);
            }
        }

        void c() {
        }

        boolean d(k kVar) {
            return false;
        }

        abstract boolean e();
    }

    public LiveData() {
        Object obj = a;
        this.f1722g = obj;
        this.f1726k = new a();
        this.f1721f = obj;
        this.f1723h = -1;
    }

    static void b(String str) {
        if (c.b.a.a.a.e().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void d(LiveData<T>.c cVar) {
        if (cVar.f1731b) {
            if (!cVar.e()) {
                cVar.b(false);
                return;
            }
            int i2 = cVar.f1732c;
            int i3 = this.f1723h;
            if (i2 >= i3) {
                return;
            }
            cVar.f1732c = i3;
            cVar.a.a((Object) this.f1721f);
        }
    }

    void c(int i2) {
        int i3 = this.f1719d;
        this.f1719d = i2 + i3;
        if (this.f1720e) {
            return;
        }
        this.f1720e = true;
        while (true) {
            try {
                int i4 = this.f1719d;
                if (i3 == i4) {
                    this.f1720e = false;
                    return;
                }
                boolean z = i3 == 0 && i4 > 0;
                boolean z2 = i3 > 0 && i4 == 0;
                if (z) {
                    j();
                } else if (z2) {
                    k();
                }
                i3 = i4;
            } catch (Throwable th) {
                this.f1720e = false;
                throw th;
            }
        }
    }

    void e(LiveData<T>.c cVar) {
        if (this.f1724i) {
            this.f1725j = true;
            return;
        }
        this.f1724i = true;
        do {
            this.f1725j = false;
            if (cVar != null) {
                d(cVar);
                cVar = null;
            } else {
                c.b.a.b.b<r<? super T>, LiveData<T>.c>.d dVarH = this.f1718c.h();
                while (dVarH.hasNext()) {
                    d((c) dVarH.next().getValue());
                    if (this.f1725j) {
                        break;
                    }
                }
            }
        } while (this.f1725j);
        this.f1724i = false;
    }

    public T f() {
        T t = (T) this.f1721f;
        if (t != a) {
            return t;
        }
        return null;
    }

    public boolean g() {
        return this.f1719d > 0;
    }

    public void h(k kVar, r<? super T> rVar) {
        b("observe");
        if (kVar.getLifecycle().b() == g.c.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(kVar, rVar);
        LiveData<T>.c cVarO = this.f1718c.o(rVar, lifecycleBoundObserver);
        if (cVarO != null && !cVarO.d(kVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVarO != null) {
            return;
        }
        kVar.getLifecycle().a(lifecycleBoundObserver);
    }

    public void i(r<? super T> rVar) {
        b("observeForever");
        b bVar = new b(rVar);
        LiveData<T>.c cVarO = this.f1718c.o(rVar, bVar);
        if (cVarO instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVarO != null) {
            return;
        }
        bVar.b(true);
    }

    protected void j() {
    }

    protected void k() {
    }

    protected void l(T t) {
        boolean z;
        synchronized (this.f1717b) {
            z = this.f1722g == a;
            this.f1722g = t;
        }
        if (z) {
            c.b.a.a.a.e().c(this.f1726k);
        }
    }

    public void m(r<? super T> rVar) {
        b("removeObserver");
        LiveData<T>.c cVarQ = this.f1718c.q(rVar);
        if (cVarQ == null) {
            return;
        }
        cVarQ.c();
        cVarQ.b(false);
    }

    protected void n(T t) {
        b("setValue");
        this.f1723h++;
        this.f1721f = t;
        e(null);
    }
}
