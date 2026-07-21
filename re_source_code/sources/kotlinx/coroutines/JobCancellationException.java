package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u0010\u0010\b\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", HttpUrl.FRAGMENT_ENCODE_SET, "cause", HttpUrl.FRAGMENT_ENCODE_SET, "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "createCopy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "fillInStackTrace", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JobCancellationException extends CancellationException implements CopyableThrowable<JobCancellationException> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient Job f25629f;

    public JobCancellationException(String str, Throwable th, Job job) {
        super(str);
        this.f25629f = job;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JobCancellationException a() {
        if (!s0.c()) {
            return null;
        }
        String message = getMessage();
        kotlin.jvm.internal.m.c(message);
        return new JobCancellationException(message, this, this.f25629f);
    }

    public boolean equals(Object other) {
        if (other != this) {
            if (other instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) other;
                if (!kotlin.jvm.internal.m.a(jobCancellationException.getMessage(), getMessage()) || !kotlin.jvm.internal.m.a(jobCancellationException.f25629f, this.f25629f) || !kotlin.jvm.internal.m.a(jobCancellationException.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (s0.c()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.m.c(message);
        int iHashCode = ((message.hashCode() * 31) + this.f25629f.hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f25629f;
    }
}
