package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.p003y.CoroutineContext;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.q2, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/StandaloneCoroutine;", "Lkotlinx/coroutines/AbstractCoroutine;", HttpUrl.FRAGMENT_ENCODE_SET, "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlin/coroutines/CoroutineContext;Z)V", "handleJobException", "exception", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
class StandaloneCoroutine extends AbstractCoroutine<kotlin.u> {
    public StandaloneCoroutine(CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, true, z);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected boolean Y(Throwable th) {
        l0.a(getF25631g(), th);
        return true;
    }
}
