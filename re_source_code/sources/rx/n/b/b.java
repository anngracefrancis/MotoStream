package rx.n.b;

import java.util.concurrent.atomic.AtomicInteger;
import rx.g;
import rx.j;

/* JADX INFO: compiled from: SingleDelayedProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b<T> extends AtomicInteger implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final j<? super T> f26612f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    T f26613g;

    public b(j<? super T> jVar) {
        this.f26612f = jVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(j<? super T> jVar, T t) {
        if (jVar.isUnsubscribed()) {
            return;
        }
        try {
            jVar.onNext(t);
            if (jVar.isUnsubscribed()) {
                return;
            }
            jVar.onCompleted();
        } catch (Throwable th) {
            rx.exceptions.a.g(th, jVar, t);
        }
    }

    public void b(T t) {
        do {
            int i2 = get();
            if (i2 != 0) {
                if (i2 == 2 && compareAndSet(2, 3)) {
                    a(this.f26612f, t);
                    return;
                }
                return;
            }
            this.f26613g = t;
        } while (!compareAndSet(0, 1));
    }

    @Override // rx.g
    public void request(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j2 == 0) {
            return;
        }
        do {
            int i2 = get();
            if (i2 != 0) {
                if (i2 == 1 && compareAndSet(1, 3)) {
                    a(this.f26612f, this.f26613g);
                    return;
                }
                return;
            }
        } while (!compareAndSet(0, 2));
    }
}
