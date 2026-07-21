package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.w1, reason: from Kotlin metadata */
/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00020\u000fB0\u0012'\u0010\b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fR5\u0010\b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/ParameterName;", "name", "cause", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobCancellingNode;"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class InvokeOnCancelling extends JobCancellingNode {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f25885j = AtomicIntegerFieldUpdater.newUpdater(InvokeOnCancelling.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Function1<Throwable, kotlin.u> f25886k;

    /* JADX WARN: Multi-variable type inference failed */
    public InvokeOnCancelling(Function1<? super Throwable, kotlin.u> function1) {
        this.f25886k = function1;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void E(Throwable th) {
        if (f25885j.compareAndSet(this, 0, 1)) {
            this.f25886k.invoke(th);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        E(th);
        return kotlin.u.a;
    }
}
