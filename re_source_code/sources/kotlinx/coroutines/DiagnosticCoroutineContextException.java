package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.p003y.CoroutineContext;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.z0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: CoroutineExceptionHandlerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/DiagnosticCoroutineContextException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "fillInStackTrace", HttpUrl.FRAGMENT_ENCODE_SET, "getLocalizedMessage", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class DiagnosticCoroutineContextException extends RuntimeException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CoroutineContext f25894f;

    public DiagnosticCoroutineContextException(CoroutineContext coroutineContext) {
        this.f25894f = coroutineContext;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f25894f.toString();
    }
}
