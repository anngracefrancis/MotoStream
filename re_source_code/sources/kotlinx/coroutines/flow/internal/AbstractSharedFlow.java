package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.m;
import kotlin.p003y.Continuation;
import kotlin.u;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: AbstractSharedFlow.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00060\u0003j\u0002`\u0004B\u0005¢\u0006\u0002\u0010\u0005J\r\u0010\u0018\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0019J\r\u0010\u001a\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u0019J\u001d\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000e2\u0006\u0010\u001c\u001a\u00020\tH$¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001e\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0!H\u0084\bJ\u0015\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010$R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R:\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000e2\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000e@BX\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "S", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/internal/SynchronizedObject;", "()V", "_subscriptionCount", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "<set-?>", HttpUrl.FRAGMENT_ENCODE_SET, "nCollectors", "getNCollectors", "()I", "nextIndex", HttpUrl.FRAGMENT_ENCODE_SET, "slots", "getSlots$annotations", "getSlots", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "allocateSlot", "()Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "forEachSlotLocked", HttpUrl.FRAGMENT_ENCODE_SET, "block", "Lkotlin/Function1;", "freeSlot", "slot", "(Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private S[] f25753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f25754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f25755h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private SubscriptionCountStateFlow f25756i;

    protected final S b() {
        S s;
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            S[] sArr = this.f25753f;
            if (sArr == null) {
                sArr = (S[]) e(2);
                this.f25753f = sArr;
            } else if (this.f25754g >= sArr.length) {
                Object[] objArrCopyOf = Arrays.copyOf(sArr, sArr.length * 2);
                m.e(objArrCopyOf, "copyOf(this, newSize)");
                this.f25753f = (S[]) ((AbstractSharedFlowSlot[]) objArrCopyOf);
                sArr = (S[]) ((AbstractSharedFlowSlot[]) objArrCopyOf);
            }
            int i2 = this.f25755h;
            do {
                s = sArr[i2];
                if (s == null) {
                    s = (S) d();
                    sArr[i2] = s;
                }
                i2++;
                if (i2 >= sArr.length) {
                    i2 = 0;
                }
            } while (!s.a(this));
            this.f25755h = i2;
            this.f25754g++;
            subscriptionCountStateFlow = this.f25756i;
        }
        if (subscriptionCountStateFlow == null) {
            return s;
        }
        throw null;
    }

    protected abstract S d();

    protected abstract S[] e(int i2);

    protected final void f(S s) {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        int i2;
        Continuation<u>[] continuationArrB;
        synchronized (this) {
            int i3 = this.f25754g - 1;
            this.f25754g = i3;
            subscriptionCountStateFlow = this.f25756i;
            if (i3 == 0) {
                this.f25755h = 0;
            }
            continuationArrB = s.b(this);
        }
        for (Continuation<u> continuation : continuationArrB) {
            if (continuation != null) {
                Result.a aVar = Result.f25108f;
                continuation.resumeWith(Result.a(u.a));
            }
        }
        if (subscriptionCountStateFlow != null) {
            throw null;
        }
    }

    protected final S[] g() {
        return this.f25753f;
    }
}
