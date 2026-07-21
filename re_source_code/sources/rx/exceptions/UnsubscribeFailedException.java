package rx.exceptions;

/* JADX INFO: loaded from: classes3.dex */
public final class UnsubscribeFailedException extends RuntimeException {
    public UnsubscribeFailedException(String str, Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }
}
