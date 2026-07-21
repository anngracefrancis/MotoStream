package rx.exceptions;

import java.util.HashSet;
import java.util.List;
import rx.f;
import rx.i;

/* JADX INFO: compiled from: Exceptions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static void a(Throwable th, Throwable th2) {
        HashSet hashSet = new HashSet();
        int i2 = 0;
        while (th.getCause() != null) {
            int i3 = i2 + 1;
            if (i2 < 25) {
                th = th.getCause();
                if (hashSet.contains(th.getCause())) {
                    break;
                }
                hashSet.add(th.getCause());
                i2 = i3;
            } else {
                return;
            }
        }
        try {
            th.initCause(th2);
        } catch (Throwable unused) {
        }
    }

    public static Throwable b(Throwable th) {
        int i2 = 0;
        while (th.getCause() != null) {
            int i3 = i2 + 1;
            if (i2 >= 25) {
                return new RuntimeException("Stack too deep to get final cause");
            }
            th = th.getCause();
            i2 = i3;
        }
        return th;
    }

    public static RuntimeException c(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new RuntimeException(th);
    }

    public static void d(List<? extends Throwable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list.size() != 1) {
            throw new CompositeException(list);
        }
        Throwable th = list.get(0);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (!(th instanceof Error)) {
            throw new RuntimeException(th);
        }
        throw ((Error) th);
    }

    public static void e(Throwable th) {
        if (th instanceof OnErrorNotImplementedException) {
            throw ((OnErrorNotImplementedException) th);
        }
        if (th instanceof OnErrorFailedException) {
            throw ((OnErrorFailedException) th);
        }
        if (th instanceof OnCompletedFailedException) {
            throw ((OnCompletedFailedException) th);
        }
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    public static void f(Throwable th, f<?> fVar) {
        e(th);
        fVar.onError(th);
    }

    public static void g(Throwable th, f<?> fVar, Object obj) {
        e(th);
        fVar.onError(OnErrorThrowable.a(th, obj));
    }

    public static void h(Throwable th, i<?> iVar) {
        e(th);
        iVar.onError(th);
    }

    public static void i(Throwable th, i<?> iVar, Object obj) {
        e(th);
        iVar.onError(OnErrorThrowable.a(th, obj));
    }
}
