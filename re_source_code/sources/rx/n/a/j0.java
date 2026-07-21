package rx.n.a;

import rx.exceptions.OnErrorThrowable;

/* JADX INFO: compiled from: OperatorCast.java */
/* JADX INFO: loaded from: classes3.dex */
public class j0<T, R> implements rx.e.b<R, T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Class<R> f26277f;

    /* JADX INFO: compiled from: OperatorCast.java */
    static final class a<T, R> extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final rx.j<? super R> f26278f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Class<R> f26279g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f26280h;

        public a(rx.j<? super R> jVar, Class<R> cls) {
            this.f26278f = jVar;
            this.f26279g = cls;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f26280h) {
                return;
            }
            this.f26278f.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f26280h) {
                rx.q.c.j(th);
            } else {
                this.f26280h = true;
                this.f26278f.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t) {
            try {
                this.f26278f.onNext(this.f26279g.cast(t));
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.a(th, t));
            }
        }

        @Override // rx.j
        public void setProducer(rx.g gVar) {
            this.f26278f.setProducer(gVar);
        }
    }

    public j0(Class<R> cls) {
        this.f26277f = cls;
    }

    @Override // rx.m.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super R> jVar) {
        a aVar = new a(jVar, this.f26277f);
        jVar.add(aVar);
        return aVar;
    }
}
