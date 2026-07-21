package rx.o;

import rx.e;
import rx.k;
import rx.m.c;
import rx.n.a.i;
import rx.n.a.z;

/* JADX INFO: compiled from: ConnectableObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T> extends e<T> {
    protected b(e.a<T> aVar) {
        super(aVar);
    }

    public e<T> f1() {
        return g1(1);
    }

    public e<T> g1(int i2) {
        return h1(i2, c.a());
    }

    public e<T> h1(int i2, rx.m.b<? super k> bVar) {
        if (i2 > 0) {
            return e.b1(new i(this, i2, bVar));
        }
        i1(bVar);
        return this;
    }

    public abstract void i1(rx.m.b<? super k> bVar);

    public e<T> j1() {
        return e.b1(new z(this));
    }
}
