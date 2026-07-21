package rx.n.a;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: OnSubscribeAutoConnect.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i<T> extends AtomicInteger implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.o.b<? extends T> f26258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f26259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final rx.m.b<? super rx.k> f26260h;

    public i(rx.o.b<? extends T> bVar, int i2, rx.m.b<? super rx.k> bVar2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("numberOfSubscribers > 0 required");
        }
        this.f26258f = bVar;
        this.f26259g = i2;
        this.f26260h = bVar2;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        this.f26258f.c1(rx.p.f.c(jVar));
        if (incrementAndGet() == this.f26259g) {
            this.f26258f.i1(this.f26260h);
        }
    }
}
