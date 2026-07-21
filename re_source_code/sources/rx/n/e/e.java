package rx.n.e;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;

/* JADX INFO: compiled from: ExceptionsUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public enum e {
    ;


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Throwable f26734f = new Throwable("Terminated");

    public static boolean g(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        Throwable compositeException;
        do {
            th2 = atomicReference.get();
            if (th2 == f26734f) {
                return false;
            }
            if (th2 == null) {
                compositeException = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).b());
                arrayList.add(th);
                compositeException = new CompositeException(arrayList);
            } else {
                compositeException = new CompositeException(th2, th);
            }
        } while (!atomicReference.compareAndSet(th2, compositeException));
        return true;
    }

    public static boolean k(Throwable th) {
        return th == f26734f;
    }

    public static Throwable q(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = f26734f;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }
}
