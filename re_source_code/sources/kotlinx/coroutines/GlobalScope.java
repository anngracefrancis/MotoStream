package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.EmptyCoroutineContext;

/* JADX INFO: renamed from: kotlinx.coroutines.r1, reason: from Kotlin metadata */
/* JADX INFO: compiled from: CoroutineScope.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/GlobalScope;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalScope implements CoroutineScope {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final GlobalScope f25874f = new GlobalScope();

    private GlobalScope() {
    }

    @Override // kotlinx.coroutines.CoroutineScope
    /* JADX INFO: renamed from: i */
    public CoroutineContext getF25795f() {
        return EmptyCoroutineContext.f25609f;
    }
}
