package h.a.z.e.c;

import h.a.j;
import h.a.k;
import h.a.x.d;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: MaybeFromCallable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<T> extends j<T> implements Callable<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Callable<? extends T> f21501f;

    public b(Callable<? extends T> callable) {
        this.f21501f = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return this.f21501f.call();
    }

    @Override // h.a.j
    protected void e(k<? super T> kVar) {
        h.a.x.c cVarB = d.b();
        kVar.b(cVarB);
        if (cVarB.q()) {
            return;
        }
        try {
            T tCall = this.f21501f.call();
            if (cVarB.q()) {
                return;
            }
            if (tCall == null) {
                kVar.a();
            } else {
                kVar.onSuccess(tCall);
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            if (cVarB.q()) {
                h.a.a0.a.o(th);
            } else {
                kVar.onError(th);
            }
        }
    }
}
