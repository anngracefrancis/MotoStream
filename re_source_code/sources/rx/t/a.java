package rx.t;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;

/* JADX INFO: compiled from: BooleanSubscription.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final rx.m.a f26906f = new C0471a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final AtomicReference<rx.m.a> f26907g;

    /* JADX INFO: renamed from: rx.t.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BooleanSubscription.java */
    static class C0471a implements rx.m.a {
        C0471a() {
        }

        @Override // rx.m.a
        public void call() {
        }
    }

    public a() {
        this.f26907g = new AtomicReference<>();
    }

    public static a a() {
        return new a();
    }

    public static a b(rx.m.a aVar) {
        return new a(aVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.f26907g.get() == f26906f;
    }

    @Override // rx.k
    public void unsubscribe() {
        rx.m.a andSet;
        rx.m.a aVar = this.f26907g.get();
        rx.m.a aVar2 = f26906f;
        if (aVar == aVar2 || (andSet = this.f26907g.getAndSet(aVar2)) == null || andSet == aVar2) {
            return;
        }
        andSet.call();
    }

    private a(rx.m.a aVar) {
        this.f26907g = new AtomicReference<>(aVar);
    }
}
