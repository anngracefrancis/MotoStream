package e.g.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.f;
import rx.j;

/* JADX INFO: compiled from: RelaySubscriptionManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class e<T> extends AtomicReference<c<T>> implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile Object f21197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f21198g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    rx.m.b<b<T>> f21199h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    rx.m.b<b<T>> f21200i;

    /* JADX INFO: compiled from: RelaySubscriptionManager.java */
    class a implements rx.m.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f21201f;

        a(b bVar) {
            this.f21201f = bVar;
        }

        @Override // rx.m.a
        public void call() {
            e.this.g(this.f21201f);
        }
    }

    /* JADX INFO: compiled from: RelaySubscriptionManager.java */
    static final class b<T> implements f<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final f<? super T> f21203f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f21204g = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f21205h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        List<Object> f21206i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f21207j;

        b(f<? super T> fVar) {
            this.f21203f = fVar;
        }

        private void a(Object obj) {
            if (obj != null) {
                e.g.b.b.a(this.f21203f, obj);
            }
        }

        /* JADX WARN: Code duplicated, block: B:30:0x0038  */
        /* JADX WARN: Code duplicated, block: B:45:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        private void c(List<Object> list, Object obj) throws Throwable {
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
                                this.f21205h = false;
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
                            list = this.f21206i;
                            this.f21206i = null;
                            if (list == null) {
                                this.f21205h = false;
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
                            this.f21205h = false;
                        }
                    }
                    throw th;
                }
            }
        }

        void b(Object obj) {
            synchronized (this) {
                if (this.f21204g && !this.f21205h) {
                    this.f21204g = false;
                    this.f21205h = obj != null;
                    if (obj != null) {
                        c(null, obj);
                    }
                }
            }
        }

        void d(Object obj) {
            if (!this.f21207j) {
                synchronized (this) {
                    this.f21204g = false;
                    if (this.f21205h) {
                        if (this.f21206i == null) {
                            this.f21206i = new ArrayList();
                        }
                        this.f21206i.add(obj);
                        return;
                    }
                    this.f21207j = true;
                }
            }
            e.g.b.b.a(this.f21203f, obj);
        }

        @Override // rx.f
        public void onCompleted() {
            throw new AssertionError();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            throw new AssertionError();
        }

        @Override // rx.f
        public void onNext(T t) {
            this.f21203f.onNext(t);
        }
    }

    /* JADX INFO: compiled from: RelaySubscriptionManager.java */
    static final class c<T> {
        static final c a = new c(new b[0]);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b[] f21208b;

        c(b[] bVarArr) {
            this.f21208b = bVarArr;
        }

        c a(b bVar) {
            b[] bVarArr = this.f21208b;
            int length = bVarArr.length;
            b[] bVarArr2 = new b[length + 1];
            System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
            bVarArr2[length] = bVar;
            return new c(bVarArr2);
        }

        c b(b bVar) {
            b[] bVarArr = this.f21208b;
            int length = bVarArr.length;
            if (length == 1 && bVarArr[0] == bVar) {
                return a;
            }
            if (length == 0) {
                return this;
            }
            int i2 = length - 1;
            b[] bVarArr2 = new b[i2];
            int i3 = 0;
            for (b bVar2 : bVarArr) {
                if (bVar2 != bVar) {
                    if (i3 == i2) {
                        return this;
                    }
                    bVarArr2[i3] = bVar2;
                    i3++;
                }
            }
            if (i3 == 0) {
                return a;
            }
            if (i3 < i2) {
                b[] bVarArr3 = new b[i3];
                System.arraycopy(bVarArr2, 0, bVarArr3, 0, i3);
                bVarArr2 = bVarArr3;
            }
            return new c(bVarArr2);
        }
    }

    e() {
        super(c.a);
        this.f21198g = true;
        this.f21199h = rx.m.c.a();
        this.f21200i = rx.m.c.a();
    }

    private void a(b<T> bVar) {
        c<T> cVar;
        do {
            cVar = get();
        } while (!compareAndSet(cVar, cVar.a(bVar)));
        this.f21200i.call(bVar);
    }

    private void b(j<? super T> jVar, b<T> bVar) {
        jVar.add(rx.t.e.a(new a(bVar)));
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void call(j<? super T> jVar) {
        b<T> bVar = new b<>(jVar);
        b(jVar, bVar);
        this.f21199h.call(bVar);
        if (jVar.isUnsubscribed()) {
            return;
        }
        a(bVar);
        if (jVar.isUnsubscribed()) {
            g(bVar);
        }
    }

    Object d() {
        return this.f21197f;
    }

    b<T>[] e(Object obj) {
        h(obj);
        return get().f21208b;
    }

    b<T>[] f() {
        return get().f21208b;
    }

    void g(b<T> bVar) {
        c<T> cVar;
        c<T> cVarB;
        do {
            cVar = get();
            cVarB = cVar.b(bVar);
            if (cVarB == cVar) {
                return;
            }
        } while (!compareAndSet(cVar, cVarB));
    }

    void h(Object obj) {
        this.f21197f = obj;
    }
}
