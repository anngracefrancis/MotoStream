package rx.s;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.f;
import rx.j;
import rx.n.a.h;

/* JADX INFO: compiled from: SubjectSubscriptionManager.java */
/* JADX INFO: loaded from: classes3.dex */
final class e<T> extends AtomicReference<b<T>> implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile Object f26876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f26877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    rx.m.b<c<T>> f26878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    rx.m.b<c<T>> f26879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    rx.m.b<c<T>> f26880j;

    /* JADX INFO: compiled from: SubjectSubscriptionManager.java */
    class a implements rx.m.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f26881f;

        a(c cVar) {
            this.f26881f = cVar;
        }

        @Override // rx.m.a
        public void call() {
            e.this.f(this.f26881f);
        }
    }

    /* JADX INFO: compiled from: SubjectSubscriptionManager.java */
    protected static final class b<T> {
        static final c[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final b f26883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final b f26884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f26885d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final c[] f26886e;

        static {
            c[] cVarArr = new c[0];
            a = cVarArr;
            f26883b = new b(true, cVarArr);
            f26884c = new b(false, cVarArr);
        }

        public b(boolean z, c[] cVarArr) {
            this.f26885d = z;
            this.f26886e = cVarArr;
        }

        public b a(c cVar) {
            c[] cVarArr = this.f26886e;
            int length = cVarArr.length;
            c[] cVarArr2 = new c[length + 1];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
            cVarArr2[length] = cVar;
            return new b(this.f26885d, cVarArr2);
        }

        public b b(c cVar) {
            c[] cVarArr = this.f26886e;
            int length = cVarArr.length;
            if (length == 1 && cVarArr[0] == cVar) {
                return f26884c;
            }
            if (length == 0) {
                return this;
            }
            int i2 = length - 1;
            c[] cVarArr2 = new c[i2];
            int i3 = 0;
            for (c cVar2 : cVarArr) {
                if (cVar2 != cVar) {
                    if (i3 == i2) {
                        return this;
                    }
                    cVarArr2[i3] = cVar2;
                    i3++;
                }
            }
            if (i3 == 0) {
                return f26884c;
            }
            if (i3 < i2) {
                c[] cVarArr3 = new c[i3];
                System.arraycopy(cVarArr2, 0, cVarArr3, 0, i3);
                cVarArr2 = cVarArr3;
            }
            return new b(this.f26885d, cVarArr2);
        }
    }

    /* JADX INFO: compiled from: SubjectSubscriptionManager.java */
    protected static final class c<T> implements f<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final j<? super T> f26887f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f26888g = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f26889h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        List<Object> f26890i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f26891j;

        public c(j<? super T> jVar) {
            this.f26887f = jVar;
        }

        void a(Object obj) {
            if (obj != null) {
                h.a(this.f26887f, obj);
            }
        }

        void b(Object obj) {
            synchronized (this) {
                if (this.f26888g && !this.f26889h) {
                    this.f26888g = false;
                    this.f26889h = obj != null;
                    if (obj != null) {
                        c(null, obj);
                    }
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:30:0x0038  */
        /* JADX WARN: Code duplicated, block: B:45:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        void c(List<Object> list, Object obj) throws Throwable {
            boolean z = true;
            boolean z2 = true;
            while (true) {
                if (list != null) {
                    try {
                        Iterator<Object> it = list.iterator();
                        while (it.hasNext()) {
                            a(it.next());
                        }
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (!z) {
                            synchronized (this) {
                                this.f26889h = false;
                            }
                        }
                        throw th;
                    }
                }
                if (z2) {
                    a(obj);
                    z2 = false;
                }
                try {
                    synchronized (this) {
                        try {
                            list = this.f26890i;
                            this.f26890i = null;
                            if (list == null) {
                                this.f26889h = false;
                                return;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            z = false;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                try {
                    throw th;
                } catch (Throwable th4) {
                    th = th4;
                    if (!z) {
                        synchronized (this) {
                            this.f26889h = false;
                        }
                    }
                    throw th;
                }
            }
        }

        void d(Object obj) {
            if (!this.f26891j) {
                synchronized (this) {
                    this.f26888g = false;
                    if (this.f26889h) {
                        if (this.f26890i == null) {
                            this.f26890i = new ArrayList();
                        }
                        this.f26890i.add(obj);
                        return;
                    }
                    this.f26891j = true;
                }
            }
            h.a(this.f26887f, obj);
        }

        @Override // rx.f
        public void onCompleted() {
            this.f26887f.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26887f.onError(th);
        }

        @Override // rx.f
        public void onNext(T t) {
            this.f26887f.onNext(t);
        }
    }

    public e() {
        super(b.f26884c);
        this.f26877g = true;
        this.f26878h = rx.m.c.a();
        this.f26879i = rx.m.c.a();
        this.f26880j = rx.m.c.a();
    }

    boolean a(c<T> cVar) {
        b<T> bVar;
        do {
            bVar = get();
            if (bVar.f26885d) {
                this.f26880j.call(cVar);
                return false;
            }
        } while (!compareAndSet(bVar, bVar.a(cVar)));
        this.f26879i.call(cVar);
        return true;
    }

    void b(j<? super T> jVar, c<T> cVar) {
        jVar.add(rx.t.e.a(new a(cVar)));
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void call(j<? super T> jVar) {
        c<T> cVar = new c<>(jVar);
        b(jVar, cVar);
        this.f26878h.call(cVar);
        if (!jVar.isUnsubscribed() && a(cVar) && jVar.isUnsubscribed()) {
            f(cVar);
        }
    }

    Object d() {
        return this.f26876f;
    }

    c<T>[] e(Object obj) {
        g(obj);
        return get().f26886e;
    }

    void f(c<T> cVar) {
        b<T> bVar;
        b<T> bVarB;
        do {
            bVar = get();
            if (bVar.f26885d || (bVarB = bVar.b(cVar)) == bVar) {
                return;
            }
        } while (!compareAndSet(bVar, bVarB));
    }

    void g(Object obj) {
        this.f26876f = obj;
    }

    c<T>[] h(Object obj) {
        g(obj);
        this.f26877g = false;
        return get().f26885d ? b.a : getAndSet(b.f26883b).f26886e;
    }
}
