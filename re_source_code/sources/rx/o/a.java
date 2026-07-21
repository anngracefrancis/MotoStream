package rx.o;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.j;
import rx.n.e.d;

/* JADX INFO: compiled from: BlockingObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a<T> {
    static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Object f26823b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Object f26824c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e<? extends T> f26825d;

    /* JADX INFO: renamed from: rx.o.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BlockingObservable.java */
    class C0464a extends j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f26826f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ AtomicReference f26827g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ AtomicReference f26828h;

        C0464a(CountDownLatch countDownLatch, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.f26826f = countDownLatch;
            this.f26827g = atomicReference;
            this.f26828h = atomicReference2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f26826f.countDown();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26827g.set(th);
            this.f26826f.countDown();
        }

        @Override // rx.f
        public void onNext(T t) {
            this.f26828h.set(t);
        }
    }

    private a(e<? extends T> eVar) {
        this.f26825d = eVar;
    }

    private T a(e<? extends T> eVar) {
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        d.a(countDownLatch, eVar.E0(new C0464a(countDownLatch, atomicReference2, atomicReference)));
        if (atomicReference2.get() != null) {
            rx.exceptions.a.c((Throwable) atomicReference2.get());
        }
        return (T) atomicReference.get();
    }

    public static <T> a<T> c(e<? extends T> eVar) {
        return new a<>(eVar);
    }

    public T b() {
        return a(this.f26825d.E());
    }
}
