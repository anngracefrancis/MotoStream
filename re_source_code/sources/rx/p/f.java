package rx.p;

import rx.j;

/* JADX INFO: compiled from: Subscribers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Subscribers.java */
    static class a<T> extends j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.f f26841f;

        a(rx.f fVar) {
            this.f26841f = fVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f26841f.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26841f.onError(th);
        }

        @Override // rx.f
        public void onNext(T t) {
            this.f26841f.onNext(t);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Subscribers.java */
    static class b<T> extends j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f26842f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(j jVar, j jVar2) {
            super(jVar);
            this.f26842f = jVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f26842f.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26842f.onError(th);
        }

        @Override // rx.f
        public void onNext(T t) {
            this.f26842f.onNext(t);
        }
    }

    public static <T> j<T> a() {
        return b(rx.p.a.a());
    }

    public static <T> j<T> b(rx.f<? super T> fVar) {
        return new a(fVar);
    }

    public static <T> j<T> c(j<? super T> jVar) {
        return new b(jVar, jVar);
    }
}
