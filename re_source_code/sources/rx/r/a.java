package rx.r;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import rx.Single;
import rx.i;
import rx.n.e.d;

/* JADX INFO: compiled from: BlockingSingle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a<T> {
    private final Single<? extends T> a;

    /* JADX INFO: renamed from: rx.r.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BlockingSingle.java */
    class C0467a extends i<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ AtomicReference f26859g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f26860h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ AtomicReference f26861i;

        C0467a(AtomicReference atomicReference, CountDownLatch countDownLatch, AtomicReference atomicReference2) {
            this.f26859g = atomicReference;
            this.f26860h = countDownLatch;
            this.f26861i = atomicReference2;
        }

        @Override // rx.i
        public void c(T t) {
            this.f26859g.set(t);
            this.f26860h.countDown();
        }

        @Override // rx.i
        public void onError(Throwable th) {
            this.f26861i.set(th);
            this.f26860h.countDown();
        }
    }

    private a(Single<? extends T> single) {
        this.a = single;
    }

    public static <T> a<T> a(Single<? extends T> single) {
        return new a<>(single);
    }

    public T b() {
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        d.a(countDownLatch, this.a.t(new C0467a(atomicReference, countDownLatch, atomicReference2)));
        Throwable th = (Throwable) atomicReference2.get();
        if (th == null) {
            return (T) atomicReference.get();
        }
        throw rx.exceptions.a.c(th);
    }
}
