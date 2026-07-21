package kotlinx.coroutines.p005z2;

import kotlin.Metadata;
import kotlin.o;
import kotlin.p003y.Continuation;
import kotlin.p003y.intrinsics.d;
import kotlin.p003y.j.p004a.ContinuationImpl;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.u;
import kotlinx.coroutines.flow.internal.SafeCollector;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.z2.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Flow.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/flow/AbstractFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "()V", "collect", HttpUrl.FRAGMENT_ENCODE_SET, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSafely", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractFlow<T> implements Flow<T> {

    /* JADX INFO: renamed from: kotlinx.coroutines.z2.a$a */
    /* JADX INFO: compiled from: Flow.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {230}, m = "collect")
    static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f25895f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f25896g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ AbstractFlow<T> f25897h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f25898i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractFlow<T> abstractFlow, Continuation<? super a> continuation) {
            super(continuation);
            this.f25897h = abstractFlow;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f25896g = obj;
            this.f25898i |= Integer.MIN_VALUE;
            return this.f25897h.a(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.p005z2.Flow
    public final Object a(FlowCollector<? super T> flowCollector, Continuation<? super u> continuation) throws Throwable {
        a aVar;
        Throwable th;
        SafeCollector safeCollector;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i2 = aVar.f25898i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                aVar.f25898i = i2 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, continuation);
            }
        } else {
            aVar = new a(this, continuation);
        }
        Object obj = aVar.f25896g;
        Object objC = d.c();
        int i3 = aVar.f25898i;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            safeCollector = (SafeCollector) aVar.f25895f;
            try {
                o.b(obj);
                safeCollector.releaseIntercepted();
                return u.a;
            } catch (Throwable th2) {
                th = th2;
                safeCollector.releaseIntercepted();
                throw th;
            }
        }
        o.b(obj);
        SafeCollector safeCollector2 = new SafeCollector(flowCollector, aVar.getL());
        try {
            aVar.f25895f = safeCollector2;
            aVar.f25898i = 1;
            if (b(safeCollector2, aVar) == objC) {
                return objC;
            }
            safeCollector = safeCollector2;
            safeCollector.releaseIntercepted();
            return u.a;
        } catch (Throwable th3) {
            th = th3;
            safeCollector = safeCollector2;
            safeCollector.releaseIntercepted();
            throw th;
        }
    }

    public abstract Object b(FlowCollector<? super T> flowCollector, Continuation<? super u> continuation);
}
