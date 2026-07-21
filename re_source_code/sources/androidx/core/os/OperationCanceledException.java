package androidx.core.os;

/* JADX INFO: loaded from: classes.dex */
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(String str) {
        super(c.i.j.d.c(str, "The operation has been canceled."));
    }
}
