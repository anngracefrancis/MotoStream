package rx.n.a;

/* JADX INFO: compiled from: EmptyObservableHolder.java */
/* JADX INFO: loaded from: classes3.dex */
public enum g implements rx.e.a<Object> {
    INSTANCE;


    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final rx.e<Object> f26218g = rx.e.b1(INSTANCE);

    public static <T> rx.e<T> k() {
        return (rx.e<T>) f26218g;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super Object> jVar) {
        jVar.onCompleted();
    }
}
