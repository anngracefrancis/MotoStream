package rx.n.a;

import java.util.Arrays;
import rx.exceptions.CompositeException;

/* JADX INFO: compiled from: OnSubscribeDoOnEach.java */
/* JADX INFO: loaded from: classes3.dex */
public class n<T> implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final rx.f<? super T> f26350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final rx.e<T> f26351g;

    /* JADX INFO: compiled from: OnSubscribeDoOnEach.java */
    private static final class a<T> extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final rx.j<? super T> f26352f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final rx.f<? super T> f26353g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f26354h;

        a(rx.j<? super T> jVar, rx.f<? super T> fVar) {
            super(jVar);
            this.f26352f = jVar;
            this.f26353g = fVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f26354h) {
                return;
            }
            try {
                this.f26353g.onCompleted();
                this.f26354h = true;
                this.f26352f.onCompleted();
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f26354h) {
                rx.q.c.j(th);
                return;
            }
            this.f26354h = true;
            try {
                this.f26353g.onError(th);
                this.f26352f.onError(th);
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                this.f26352f.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // rx.f
        public void onNext(T t) {
            if (this.f26354h) {
                return;
            }
            try {
                this.f26353g.onNext(t);
                this.f26352f.onNext(t);
            } catch (Throwable th) {
                rx.exceptions.a.g(th, this, t);
            }
        }
    }

    public n(rx.e<T> eVar, rx.f<? super T> fVar) {
        this.f26351g = eVar;
        this.f26350f = fVar;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        this.f26351g.c1(new a(jVar, this.f26350f));
    }
}
