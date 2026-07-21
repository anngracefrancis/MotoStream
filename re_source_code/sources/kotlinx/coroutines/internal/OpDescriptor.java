package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.t0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.internal.z, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Atomic.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0000J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\f\u001a\u00020\rH\u0016R\u0018\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/internal/OpDescriptor;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "isEarlierThan", HttpUrl.FRAGMENT_ENCODE_SET, "that", "perform", "affected", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OpDescriptor {
    public abstract AtomicOp<?> a();

    public final boolean b(OpDescriptor opDescriptor) {
        AtomicOp<?> atomicOpA;
        AtomicOp<?> atomicOpA2 = a();
        return (atomicOpA2 == null || (atomicOpA = opDescriptor.a()) == null || atomicOpA2.f() >= atomicOpA.f()) ? false : true;
    }

    public abstract Object c(Object obj);

    public String toString() {
        return t0.a(this) + '@' + t0.b(this);
    }
}
