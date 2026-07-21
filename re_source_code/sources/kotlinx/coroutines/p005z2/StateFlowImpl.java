package kotlinx.coroutines.p005z2;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.p003y.Continuation;
import kotlin.p003y.j.p004a.ContinuationImpl;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.u;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.g;
import kotlinx.coroutines.internal.Symbol;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.z2.n, reason: from Kotlin metadata */
/* JADX INFO: compiled from: StateFlow.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u0010062\b\u0012\u0004\u0012\u00028\u0000072\b\u0012\u0004\u0012\u00028\u0000082\b\u0012\u0004\u0012\u00028\u000009B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0019H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0004\b&\u0010'J!\u0010*\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u00022\u0006\u0010)\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010\u000fR\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R*\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\b4\u0010%\u001a\u0004\b1\u00102\"\u0004\b3\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", HttpUrl.FRAGMENT_ENCODE_SET, "initialState", "<init>", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", HttpUrl.FRAGMENT_ENCODE_SET, "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expect", "update", HttpUrl.FRAGMENT_ENCODE_SET, "compareAndSet", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/flow/StateFlowSlot;", "createSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", HttpUrl.FRAGMENT_ENCODE_SET, "size", HttpUrl.FRAGMENT_ENCODE_SET, "createSlotArray", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "value", HttpUrl.FRAGMENT_ENCODE_SET, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "resetReplayCache", "()V", "tryEmit", "(Ljava/lang/Object;)Z", "expectedState", "newState", "updateState", HttpUrl.FRAGMENT_ENCODE_SET, "getReplayCache", "()Ljava/util/List;", "replayCache", "sequence", "I", "getValue", "()Ljava/lang/Object;", "setValue", "getValue$annotations", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, Flow {
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f25931j;

    /* JADX INFO: renamed from: kotlinx.coroutines.z2.n$a */
    /* JADX INFO: compiled from: StateFlow.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {386, 398, 403}, m = "collect")
    static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f25932f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f25933g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f25934h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f25935i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f25936j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f25937k;
        final /* synthetic */ StateFlowImpl<T> l;
        int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(StateFlowImpl<T> stateFlowImpl, Continuation<? super a> continuation) {
            super(continuation);
            this.l = stateFlowImpl;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f25937k = obj;
            this.m |= Integer.MIN_VALUE;
            return this.l.a(null, this);
        }
    }

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    private final boolean j(Object obj, Object obj2) {
        int i2;
        StateFlowSlot[] stateFlowSlotArrG;
        g();
        synchronized (this) {
            Object obj3 = this._state;
            if (obj != null && !m.a(obj3, obj)) {
                return false;
            }
            if (m.a(obj3, obj2)) {
                return true;
            }
            this._state = obj2;
            int i3 = this.f25931j;
            if ((i3 & 1) != 0) {
                this.f25931j = i3 + 2;
                return true;
            }
            int i4 = i3 + 1;
            this.f25931j = i4;
            StateFlowSlot[] stateFlowSlotArrG2 = g();
            u uVar = u.a;
            while (true) {
                StateFlowSlot[] stateFlowSlotArr = stateFlowSlotArrG2;
                if (stateFlowSlotArr != null) {
                    for (StateFlowSlot stateFlowSlot : stateFlowSlotArr) {
                        if (stateFlowSlot != null) {
                            stateFlowSlot.f();
                        }
                    }
                }
                synchronized (this) {
                    i2 = this.f25931j;
                    if (i2 == i4) {
                        this.f25931j = i4 + 1;
                        return true;
                    }
                    stateFlowSlotArrG = g();
                    u uVar2 = u.a;
                }
                stateFlowSlotArrG2 = stateFlowSlotArrG;
                i4 = i2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00aa A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00aa, B:38:0x00af, B:48:0x00d0, B:50:0x00d6, B:40:0x00b5, B:44:0x00bc, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:58:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00af A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00aa, B:38:0x00af, B:48:0x00d0, B:50:0x00d6, B:40:0x00b5, B:44:0x00bc, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:58:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b5 A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00aa, B:38:0x00af, B:48:0x00d0, B:50:0x00d6, B:40:0x00b5, B:44:0x00bc, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:58:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:43:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ce A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d6 A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00aa, B:38:0x00af, B:48:0x00d0, B:50:0x00d6, B:40:0x00b5, B:44:0x00bc, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:58:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00e8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlinx.coroutines.flow.internal.c] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object, kotlinx.coroutines.z2.p] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object, kotlinx.coroutines.z2.c] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00d4 -> B:34:0x00a6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00e6 -> B:34:0x00a6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:38:0x00af
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlinx.coroutines.p005z2.Flow
    public java.lang.Object a(kotlinx.coroutines.p005z2.FlowCollector<? super T> r11, kotlin.p003y.Continuation<?> r12) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.p005z2.StateFlowImpl.a(kotlinx.coroutines.z2.c, kotlin.y.d):java.lang.Object");
    }

    @Override // kotlinx.coroutines.p005z2.FlowCollector
    public Object c(T t, Continuation<? super u> continuation) {
        setValue(t);
        return u.a;
    }

    @Override // kotlinx.coroutines.p005z2.MutableStateFlow
    public T getValue() {
        Symbol symbol = g.a;
        T t = (T) this._state;
        if (t == symbol) {
            return null;
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public StateFlowSlot d() {
        return new StateFlowSlot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public StateFlowSlot[] e(int i2) {
        return new StateFlowSlot[i2];
    }

    @Override // kotlinx.coroutines.p005z2.MutableStateFlow
    public void setValue(T t) {
        if (t == null) {
            t = (T) g.a;
        }
        j(null, t);
    }
}
