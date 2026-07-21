package rx.n.a;

/* JADX INFO: compiled from: OperatorAsObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i0<T> implements rx.e.b<T, T> {

    /* JADX INFO: compiled from: OperatorAsObservable.java */
    static final class a {
        static final i0<Object> a = new i0<>();
    }

    i0() {
    }

    public static <T> i0<T> b() {
        return (i0<T>) a.a;
    }

    @Override // rx.m.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        return jVar;
    }
}
