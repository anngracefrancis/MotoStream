package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;
import kotlinx.coroutines.internal.ScopeCoroutine;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.a1, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0015B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", HttpUrl.FRAGMENT_ENCODE_SET, "state", HttpUrl.FRAGMENT_ENCODE_SET, "afterCompletion", "(Ljava/lang/Object;)V", "afterResume", "getResult", "()Ljava/lang/Object;", HttpUrl.FRAGMENT_ENCODE_SET, "tryResume", "()Z", "trySuspend", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/ScopeCoroutine;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DispatchedCoroutine<T> extends ScopeCoroutine<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f25636i = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, "_decision");
    private volatile /* synthetic */ int _decision;

    public DispatchedCoroutine(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
        this._decision = 0;
    }

    private final boolean I0() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f25636i.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean J0() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f25636i.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.AbstractCoroutine
    protected void C0(Object obj) {
        if (I0()) {
            return;
        }
        kotlinx.coroutines.internal.i.c(kotlin.p003y.intrinsics.c.b(this.f25792h), e0.a(obj, this.f25792h), null, 2, null);
    }

    public final Object H0() {
        if (J0()) {
            return kotlin.p003y.intrinsics.d.c();
        }
        Object objH = g2.h(X());
        if (objH instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) objH).f25646b;
        }
        return objH;
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.JobSupport
    protected void v(Object obj) {
        C0(obj);
    }
}
