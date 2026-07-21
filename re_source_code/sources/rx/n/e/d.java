package rx.n.e;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: BlockingUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static void a(CountDownLatch countDownLatch, rx.k kVar) {
        if (countDownLatch.getCount() == 0) {
            return;
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            kVar.unsubscribe();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e2);
        }
    }
}
