package g.a.a.a;

import h.a.u;
import h.a.w;
import java.util.concurrent.atomic.AtomicReference;
import rx.Single;
import rx.i;
import rx.k;

/* JADX INFO: compiled from: SingleV2ToSingleV1.java */
/* JADX INFO: loaded from: classes2.dex */
final class f<T> implements Single.j<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final w<T> f21418f;

    /* JADX INFO: compiled from: SingleV2ToSingleV1.java */
    static final class a<T> extends AtomicReference<h.a.x.c> implements u<T>, k {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final i<? super T> f21419f;

        a(i<? super T> iVar) {
            this.f21419f = iVar;
        }

        @Override // h.a.u
        public void b(h.a.x.c cVar) {
            h.a.z.a.c.A(this, cVar);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return h.a.z.a.c.u(get());
        }

        @Override // h.a.u
        public void onError(Throwable th) {
            this.f21419f.onError(th);
        }

        @Override // h.a.u
        public void onSuccess(T t) {
            this.f21419f.c(t);
        }

        @Override // rx.k
        public void unsubscribe() {
            h.a.z.a.c.g(this);
        }
    }

    f(w<T> wVar) {
        this.f21418f = wVar;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(i<? super T> iVar) {
        a aVar = new a(iVar);
        iVar.b(aVar);
        this.f21418f.b(aVar);
    }
}
