package kotlinx.coroutines.p005z2;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.o;
import kotlin.p003y.Continuation;
import kotlin.p003y.intrinsics.d;
import kotlin.p003y.j.p004a.ContinuationImpl;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.u;
import kotlinx.coroutines.flow.internal.SafeCollector;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.z2.q, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Share.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BE\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R:\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/flow/SubscribedFlowCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSubscription", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscribedFlowCollector<T> implements FlowCollector<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FlowCollector<T> f25939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function2<FlowCollector<? super T>, Continuation<? super u>, Object> f25940g;

    /* JADX INFO: renamed from: kotlinx.coroutines.z2.q$a */
    /* JADX INFO: compiled from: Share.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {419, 423}, m = "onSubscription")
    static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f25941f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f25942g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        /* synthetic */ Object f25943h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ SubscribedFlowCollector<T> f25944i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f25945j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SubscribedFlowCollector<T> subscribedFlowCollector, Continuation<? super a> continuation) {
            super(continuation);
            this.f25944i = subscribedFlowCollector;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f25943h = obj;
            this.f25945j |= Integer.MIN_VALUE;
            return this.f25944i.a(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.internal.h] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    public final Object a(Continuation<? super u> continuation) throws Throwable {
        a aVar;
        SafeCollector safeCollector;
        SubscribedFlowCollector<T> subscribedFlowCollector;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i2 = aVar.f25945j;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                aVar.f25945j = i2 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, continuation);
            }
        } else {
            aVar = new a(this, continuation);
        }
        Object obj = aVar.f25943h;
        Object objC = d.c();
        ?? r2 = aVar.f25945j;
        try {
            if (r2 != 0) {
                if (r2 == 1) {
                    safeCollector = (SafeCollector) aVar.f25942g;
                    subscribedFlowCollector = (SubscribedFlowCollector) aVar.f25941f;
                    o.b(obj);
                } else {
                    if (r2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    o.b(obj);
                }
                return u.a;
            }
            o.b(obj);
            safeCollector = new SafeCollector(this.f25939f, aVar.getL());
            Function2<FlowCollector<? super T>, Continuation<? super u>, Object> function2 = this.f25940g;
            aVar.f25941f = this;
            aVar.f25942g = safeCollector;
            aVar.f25945j = 1;
            if (function2.invoke(safeCollector, aVar) == objC) {
                return objC;
            }
            subscribedFlowCollector = this;
            safeCollector.releaseIntercepted();
            FlowCollector<T> flowCollector = subscribedFlowCollector.f25939f;
            r2 = flowCollector instanceof SubscribedFlowCollector;
            if (r2 == 0) {
                return u.a;
            }
            aVar.f25941f = null;
            aVar.f25942g = null;
            aVar.f25945j = 2;
            if (((SubscribedFlowCollector) flowCollector).a(aVar) == objC) {
                return objC;
            }
            return u.a;
        } catch (Throwable th) {
            r2.releaseIntercepted();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.p005z2.FlowCollector
    public Object c(T t, Continuation<? super u> continuation) {
        return this.f25939f.c(t, continuation);
    }
}
