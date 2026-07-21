package h.a;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: Completable.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements f {
    public static b c(e eVar) {
        h.a.z.b.b.c(eVar, "source is null");
        return h.a.a0.a.j(new h.a.z.e.a.a(eVar));
    }

    public static b d(Callable<?> callable) {
        h.a.z.b.b.c(callable, "callable is null");
        return h.a.a0.a.j(new h.a.z.e.a.b(callable));
    }

    private static NullPointerException g(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @Override // h.a.f
    public final void b(d dVar) {
        h.a.z.b.b.c(dVar, "observer is null");
        try {
            d dVarS = h.a.a0.a.s(this, dVar);
            h.a.z.b.b.c(dVarS, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            e(dVarS);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            h.a.a0.a.o(th);
            throw g(th);
        }
    }

    protected abstract void e(d dVar);

    public final b f(r rVar) {
        h.a.z.b.b.c(rVar, "scheduler is null");
        return h.a.a0.a.j(new h.a.z.e.a.d(this, rVar));
    }
}
