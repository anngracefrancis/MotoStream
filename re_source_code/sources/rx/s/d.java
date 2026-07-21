package rx.s;

import rx.f;

/* JADX INFO: compiled from: Subject.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d<T, R> extends rx.e<R> implements f<T> {
    protected d(rx.e.a<R> aVar) {
        super(aVar);
    }

    public final c<T, R> f1() {
        return getClass() == c.class ? (c) this : new c<>(this);
    }
}
