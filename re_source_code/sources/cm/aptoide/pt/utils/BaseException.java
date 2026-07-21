package cm.aptoide.pt.utils;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseException extends RuntimeException {
    public BaseException() {
    }

    public BaseException(String str) {
        super(str);
    }

    public BaseException(Throwable th) {
        super(th);
    }
}
