package rx.p;

import rx.j;

/* JADX INFO: compiled from: SerializedSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public class e<T> extends j<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final rx.f<T> f26840f;

    public e(j<? super T> jVar) {
        this(jVar, true);
    }

    @Override // rx.f
    public void onCompleted() {
        this.f26840f.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f26840f.onError(th);
    }

    @Override // rx.f
    public void onNext(T t) {
        this.f26840f.onNext(t);
    }

    public e(j<? super T> jVar, boolean z) {
        super(jVar, z);
        this.f26840f = new d(jVar);
    }
}
