package rx.q;

import rx.k;

/* JADX INFO: compiled from: RxJavaObservableExecutionHook.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    @Deprecated
    public <T> rx.e.a<T> onCreate(rx.e.a<T> aVar) {
        return aVar;
    }

    @Deprecated
    public <T, R> rx.e.b<? extends R, ? super T> onLift(rx.e.b<? extends R, ? super T> bVar) {
        return bVar;
    }

    @Deprecated
    public <T> Throwable onSubscribeError(Throwable th) {
        return th;
    }

    @Deprecated
    public <T> k onSubscribeReturn(k kVar) {
        return kVar;
    }

    @Deprecated
    public <T> rx.e.a<T> onSubscribeStart(rx.e<? extends T> eVar, rx.e.a<T> aVar) {
        return aVar;
    }
}
