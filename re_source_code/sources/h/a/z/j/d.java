package h.a.z.j;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: HalfSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static void a(k.a.b<?> bVar, AtomicInteger atomicInteger, a aVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thB = aVar.b();
            if (thB != null) {
                bVar.onError(thB);
            } else {
                bVar.a();
            }
        }
    }

    public static void b(k.a.b<?> bVar, Throwable th, AtomicInteger atomicInteger, a aVar) {
        if (!aVar.a(th)) {
            h.a.a0.a.o(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            bVar.onError(aVar.b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void c(k.a.b<? super T> bVar, T t, AtomicInteger atomicInteger, a aVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            bVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thB = aVar.b();
                if (thB != null) {
                    bVar.onError(thB);
                } else {
                    bVar.a();
                }
            }
        }
    }
}
