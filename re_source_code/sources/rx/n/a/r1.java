package rx.n.a;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Single;

/* JADX INFO: compiled from: SingleOperatorZip.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r1 {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: compiled from: SingleOperatorZip.java */
    static class a<R> implements Single.j<R> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Single[] f26459f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ rx.m.h f26460g;

        /* JADX INFO: Add missing generic type declarations: [T] */
        /* JADX INFO: renamed from: rx.n.a.r1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SingleOperatorZip.java */
        class C0448a<T> extends rx.i<T> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ Object[] f26461g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f26462h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ AtomicInteger f26463i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ rx.i f26464j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f26465k;

            C0448a(Object[] objArr, int i2, AtomicInteger atomicInteger, rx.i iVar, AtomicBoolean atomicBoolean) {
                this.f26461g = objArr;
                this.f26462h = i2;
                this.f26463i = atomicInteger;
                this.f26464j = iVar;
                this.f26465k = atomicBoolean;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.i
            public void c(T t) {
                this.f26461g[this.f26462h] = t;
                if (this.f26463i.decrementAndGet() == 0) {
                    try {
                        this.f26464j.c(a.this.f26460g.call(this.f26461g));
                    } catch (Throwable th) {
                        rx.exceptions.a.e(th);
                        onError(th);
                    }
                }
            }

            @Override // rx.i
            public void onError(Throwable th) {
                if (this.f26465k.compareAndSet(false, true)) {
                    this.f26464j.onError(th);
                } else {
                    rx.q.c.j(th);
                }
            }
        }

        a(Single[] singleArr, rx.m.h hVar) {
            this.f26459f = singleArr;
            this.f26460g = hVar;
        }

        @Override // rx.m.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.i<? super R> iVar) {
            if (this.f26459f.length == 0) {
                iVar.onError(new NoSuchElementException("Can't zip 0 Singles."));
                return;
            }
            AtomicInteger atomicInteger = new AtomicInteger(this.f26459f.length);
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            Object[] objArr = new Object[this.f26459f.length];
            rx.t.b bVar = new rx.t.b();
            iVar.b(bVar);
            for (int i2 = 0; i2 < this.f26459f.length && !bVar.isUnsubscribed() && !atomicBoolean.get(); i2++) {
                C0448a c0448a = new C0448a(objArr, i2, atomicInteger, iVar, atomicBoolean);
                bVar.a(c0448a);
                if (bVar.isUnsubscribed() || atomicBoolean.get()) {
                    return;
                }
                this.f26459f[i2].t(c0448a);
            }
        }
    }

    public static <T, R> Single<R> a(Single<? extends T>[] singleArr, rx.m.h<? extends R> hVar) {
        return Single.b(new a(singleArr, hVar));
    }
}
