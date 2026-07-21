package rx.n.a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: OnSubscribeFromIterable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u<T> implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Iterable<? extends T> f26500f;

    /* JADX INFO: compiled from: OnSubscribeFromIterable.java */
    static final class a<T> extends AtomicLong implements rx.g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final rx.j<? super T> f26501f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Iterator<? extends T> f26502g;

        a(rx.j<? super T> jVar, Iterator<? extends T> it) {
            this.f26501f = jVar;
            this.f26502g = it;
        }

        void a() {
            rx.j<? super T> jVar = this.f26501f;
            Iterator<? extends T> it = this.f26502g;
            while (!jVar.isUnsubscribed()) {
                try {
                    jVar.onNext(it.next());
                    if (jVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (jVar.isUnsubscribed()) {
                                return;
                            }
                            jVar.onCompleted();
                            return;
                        }
                    } catch (Throwable th) {
                        rx.exceptions.a.f(th, jVar);
                        return;
                    }
                } catch (Throwable th2) {
                    rx.exceptions.a.f(th2, jVar);
                    return;
                }
            }
        }

        void b(long j2) {
            rx.j<? super T> jVar = this.f26501f;
            Iterator<? extends T> it = this.f26502g;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2) {
                        j2 = get();
                        if (j3 == j2) {
                            break;
                        }
                    } else {
                        if (jVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            jVar.onNext(it.next());
                            if (jVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (jVar.isUnsubscribed()) {
                                        return;
                                    }
                                    jVar.onCompleted();
                                    return;
                                }
                                j3++;
                            } catch (Throwable th) {
                                rx.exceptions.a.f(th, jVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            rx.exceptions.a.f(th2, jVar);
                            return;
                        }
                    }
                }
                j2 = rx.n.a.a.c(this, j3);
            } while (j2 != 0);
        }

        @Override // rx.g
        public void request(long j2) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j2 == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                a();
            } else {
                if (j2 <= 0 || rx.n.a.a.b(this, j2) != 0) {
                    return;
                }
                b(j2);
            }
        }
    }

    public u(Iterable<? extends T> iterable) {
        if (iterable == null) {
            throw new NullPointerException("iterable must not be null");
        }
        this.f26500f = iterable;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        try {
            Iterator<? extends T> it = this.f26500f.iterator();
            boolean zHasNext = it.hasNext();
            if (jVar.isUnsubscribed()) {
                return;
            }
            if (zHasNext) {
                jVar.setProducer(new a(jVar, it));
            } else {
                jVar.onCompleted();
            }
        } catch (Throwable th) {
            rx.exceptions.a.f(th, jVar);
        }
    }
}
