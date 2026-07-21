package g.a.a.a;

import h.a.i;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.j;
import rx.k;

/* JADX INFO: compiled from: FlowableV2ToObservableV1.java */
/* JADX INFO: loaded from: classes2.dex */
final class c<T> implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final k.a.a<T> f21414f;

    /* JADX INFO: compiled from: FlowableV2ToObservableV1.java */
    static final class a<T> extends AtomicReference<k.a.c> implements i<T>, k, g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final j<? super T> f21415f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicLong f21416g = new AtomicLong();

        a(j<? super T> jVar) {
            this.f21415f = jVar;
        }

        @Override // k.a.b
        public void a() {
            this.f21415f.onCompleted();
        }

        @Override // k.a.b
        public void b(k.a.c cVar) {
            h.a.z.i.b.q(this, this.f21416g, cVar);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return h.a.z.i.b.CANCELLED == get();
        }

        @Override // k.a.b
        public void onError(Throwable th) {
            this.f21415f.onError(th);
        }

        @Override // k.a.b
        public void onNext(T t) {
            this.f21415f.onNext(t);
        }

        @Override // rx.g
        public void request(long j2) {
            if (j2 != 0) {
                h.a.z.i.b.k(this, this.f21416g, j2);
            }
        }

        @Override // rx.k
        public void unsubscribe() {
            h.a.z.i.b.g(this);
        }
    }

    c(k.a.a<T> aVar) {
        this.f21414f = aVar;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super T> jVar) {
        a aVar = new a(jVar);
        jVar.add(aVar);
        jVar.setProducer(aVar);
        this.f21414f.b(aVar);
    }
}
