package rx;

/* JADX INFO: compiled from: Observer.java */
/* JADX INFO: loaded from: classes.dex */
public interface f<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
