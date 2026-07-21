package rx.s;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.MissingBackpressureException;
import rx.f;
import rx.g;
import rx.j;
import rx.k;

/* JADX INFO: compiled from: PublishSubject.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b<T> extends d<T, T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final C0469b<T> f26866g;

    /* JADX INFO: compiled from: PublishSubject.java */
    static final class a<T> extends AtomicLong implements g, k, f<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final C0469b<T> f26867f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final j<? super T> f26868g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f26869h;

        public a(C0469b<T> c0469b, j<? super T> jVar) {
            this.f26867f = c0469b;
            this.f26868g = jVar;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.f
        public void onCompleted() {
            if (get() != Long.MIN_VALUE) {
                this.f26868g.onCompleted();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.f26868g.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t) {
            long j2 = get();
            if (j2 != Long.MIN_VALUE) {
                long j3 = this.f26869h;
                if (j2 != j3) {
                    this.f26869h = j3 + 1;
                    this.f26868g.onNext(t);
                } else {
                    unsubscribe();
                    this.f26868g.onError(new MissingBackpressureException("PublishSubject: could not emit value due to lack of requests"));
                }
            }
        }

        @Override // rx.g
        public void request(long j2) {
            long j3;
            if (rx.n.a.a.d(j2)) {
                do {
                    j3 = get();
                    if (j3 == Long.MIN_VALUE) {
                        return;
                    }
                } while (!compareAndSet(j3, rx.n.a.a.a(j3, j2)));
            }
        }

        @Override // rx.k
        public void unsubscribe() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f26867f.c(this);
            }
        }
    }

    /* JADX INFO: renamed from: rx.s.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PublishSubject.java */
    static final class C0469b<T> extends AtomicReference<a<T>[]> implements rx.e.a<T>, f<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final a[] f26870f = new a[0];

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final a[] f26871g = new a[0];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Throwable f26872h;

        public C0469b() {
            lazySet(f26870f);
        }

        boolean a(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = get();
                if (aVarArr == f26871g) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        @Override // rx.m.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void call(j<? super T> jVar) {
            a<T> aVar = new a<>(this, jVar);
            jVar.add(aVar);
            jVar.setProducer(aVar);
            if (a(aVar)) {
                if (aVar.isUnsubscribed()) {
                    c(aVar);
                }
            } else {
                Throwable th = this.f26872h;
                if (th != null) {
                    jVar.onError(th);
                } else {
                    jVar.onCompleted();
                }
            }
        }

        void c(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = get();
                if (aVarArr == f26871g || aVarArr == f26870f) {
                    return;
                }
                int length = aVarArr.length;
                int i2 = -1;
                for (int i3 = 0; i3 < length; i3++) {
                    if (aVarArr[i3] == aVar) {
                        i2 = i3;
                        break;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = f26870f;
                } else {
                    a[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                    System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!compareAndSet(aVarArr, aVarArr2));
        }

        @Override // rx.f
        public void onCompleted() {
            for (a<T> aVar : getAndSet(f26871g)) {
                aVar.onCompleted();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26872h = th;
            ArrayList arrayList = null;
            for (a<T> aVar : getAndSet(f26871g)) {
                try {
                    aVar.onError(th);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.d(arrayList);
        }

        @Override // rx.f
        public void onNext(T t) {
            for (a<T> aVar : get()) {
                aVar.onNext(t);
            }
        }
    }

    protected b(C0469b<T> c0469b) {
        super(c0469b);
        this.f26866g = c0469b;
    }

    public static <T> b<T> g1() {
        return new b<>(new C0469b());
    }

    @Override // rx.f
    public void onCompleted() {
        this.f26866g.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f26866g.onError(th);
    }

    @Override // rx.f
    public void onNext(T t) {
        this.f26866g.onNext(t);
    }
}
