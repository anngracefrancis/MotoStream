package h.a.z.e.a;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CompletableFromCallable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends h.a.b {
    final Callable<?> a;

    public b(Callable<?> callable) {
        this.a = callable;
    }

    @Override // h.a.b
    protected void e(h.a.d dVar) {
        h.a.x.c cVarB = h.a.x.d.b();
        dVar.b(cVarB);
        try {
            this.a.call();
            if (cVarB.q()) {
                return;
            }
            dVar.a();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            if (cVarB.q()) {
                h.a.a0.a.o(th);
            } else {
                dVar.onError(th);
            }
        }
    }
}
