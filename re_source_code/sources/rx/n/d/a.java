package rx.n.d;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
import rx.t.e;

/* JADX INFO: compiled from: SequentialSubscription.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends AtomicReference<k> implements k {
    public a() {
    }

    public k a() {
        k kVar = (k) super.get();
        return kVar == b.INSTANCE ? e.c() : kVar;
    }

    public boolean b(k kVar) {
        k kVar2;
        do {
            kVar2 = get();
            if (kVar2 == b.INSTANCE) {
                if (kVar == null) {
                    return false;
                }
                kVar.unsubscribe();
                return false;
            }
        } while (!compareAndSet(kVar2, kVar));
        return true;
    }

    public boolean c(k kVar) {
        k kVar2;
        do {
            kVar2 = get();
            if (kVar2 == b.INSTANCE) {
                if (kVar == null) {
                    return false;
                }
                kVar.unsubscribe();
                return false;
            }
        } while (!compareAndSet(kVar2, kVar));
        if (kVar2 == null) {
            return true;
        }
        kVar2.unsubscribe();
        return true;
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return get() == b.INSTANCE;
    }

    @Override // rx.k
    public void unsubscribe() {
        k andSet;
        k kVar = get();
        b bVar = b.INSTANCE;
        if (kVar == bVar || (andSet = getAndSet(bVar)) == null || andSet == bVar) {
            return;
        }
        andSet.unsubscribe();
    }

    public a(k kVar) {
        lazySet(kVar);
    }
}
