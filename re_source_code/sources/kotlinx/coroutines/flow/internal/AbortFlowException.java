package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.p005z2.FlowCollector;
import kotlinx.coroutines.s0;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: FlowExceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbortFlowException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "owner", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;)V", "fillInStackTrace", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AbortFlowException extends CancellationException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient FlowCollector<?> f25752f;

    public AbortFlowException(FlowCollector<?> flowCollector) {
        super("Flow was aborted, no more elements needed");
        this.f25752f = flowCollector;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (s0.c()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
