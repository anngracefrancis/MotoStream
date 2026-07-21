package rx.n.b;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.g;
import rx.j;

/* JADX INFO: compiled from: SingleProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c<T> extends AtomicBoolean implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final j<? super T> f26614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final T f26615g;

    public c(j<? super T> jVar, T t) {
        this.f26614f = jVar;
        this.f26615g = t;
    }

    @Override // rx.g
    public void request(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j2 != 0 && compareAndSet(false, true)) {
            j<? super T> jVar = this.f26614f;
            if (jVar.isUnsubscribed()) {
                return;
            }
            T t = this.f26615g;
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
    }
}
