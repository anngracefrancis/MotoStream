package rx.n.a;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: OnSubscribeFromCallable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t<T> implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Callable<? extends T> f26488f;

    public t(Callable<? extends T> callable) {
        this.f26488f = callable;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        rx.n.b.b bVar = new rx.n.b.b(jVar);
        jVar.setProducer(bVar);
        try {
            bVar.b(this.f26488f.call());
        } catch (Throwable th) {
            rx.exceptions.a.f(th, jVar);
        }
    }
}
