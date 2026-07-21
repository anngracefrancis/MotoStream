package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.l0;
import kotlin.u;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.s0;
import kotlinx.coroutines.t0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.channels.c, reason: from Kotlin metadata */
/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u000006:\u0004defgB)\u0012 \u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u000e\u0012\u0002\b\u00030\u0011j\u0006\u0012\u0002\b\u0003`\u00122\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001f\u001a\u00020\u00032\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J#\u0010!\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\b!\u0010\"J\u001b\u0010!\u001a\u00020\b2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\b!\u0010#J)\u0010&\u001a\u00020\u00032\u0018\u0010%\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`$H\u0016¢\u0006\u0004\b&\u0010\u0007J\u0019\u0010'\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00028\u0000H\u0014¢\u0006\u0004\b+\u0010,J#\u0010/\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010.\u001a\u0006\u0012\u0002\b\u00030-H\u0014¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u000201H\u0014¢\u0006\u0004\b2\u00103JX\u00109\u001a\u00020\u0003\"\u0004\b\u0001\u001042\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010-2\u0006\u0010\u0010\u001a\u00028\u00002(\u00108\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000107\u0012\u0006\u0012\u0004\u0018\u00010\u001a05H\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010;J\u001d\u0010=\u001a\b\u0012\u0002\b\u0003\u0018\u00010<2\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0004\b=\u0010>J\u001b\u0010?\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b?\u0010;J\u0017\u0010@\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010<H\u0014¢\u0006\u0004\b@\u0010AJ\u0011\u0010B\u001a\u0004\u0018\u00010\u0018H\u0004¢\u0006\u0004\bB\u0010CJ\u000f\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FJ$\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030G2\u0006\u0010\u0010\u001a\u00028\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bH\u0010,J+\u0010J\u001a\u00020\u0003*\u0006\u0012\u0002\b\u0003072\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020D8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bL\u0010FR\u001a\u0010P\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u001a\u0010R\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010OR\u0014\u0010S\u001a\u00020\n8$X¤\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020\n8$X¤\u0004¢\u0006\u0006\u001a\u0004\bU\u0010TR\u0011\u0010V\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0014\u0010W\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u0010TR#\u0010[\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000060X8F¢\u0006\u0006\u001a\u0004\bY\u0010ZR.\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00048\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\\R\u001a\u0010^\u001a\u00020]8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bb\u0010F\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006h"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel;", "E", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", HttpUrl.FRAGMENT_ENCODE_SET, "cause", HttpUrl.FRAGMENT_ENCODE_SET, "close", "(Ljava/lang/Throwable;)Z", HttpUrl.FRAGMENT_ENCODE_SET, "countQueueSize", "()I", "element", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/AddLastDesc;", "describeSendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "describeTryOffer", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "Lkotlinx/coroutines/channels/Send;", "send", HttpUrl.FRAGMENT_ENCODE_SET, "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Closed;", "closed", "helpClose", "(Lkotlinx/coroutines/channels/Closed;)V", "helpCloseAndGetSendException", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "offer", "(Ljava/lang/Object;)Z", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendBuffered", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "sendSuspend", "takeFirstReceiveOrPeekClosed", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "takeFirstSendOrPeekClosed", "()Lkotlinx/coroutines/channels/Send;", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "trySend", "helpCloseAndResumeWithSendException", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "getBufferDebugString", "bufferDebugString", "getClosedForReceive", "()Lkotlinx/coroutines/channels/Closed;", "closedForReceive", "getClosedForSend", "closedForSend", "isBufferAlwaysFull", "()Z", "isBufferFull", "isClosedForSend", "isFullImpl", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueue", "()Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getQueueDebugStateString", "queueDebugStateString", "SendBuffered", "SendBufferedDesc", "SendSelect", "TryOfferDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractSendChannel<E> implements SendChannel<E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f25704b = AtomicReferenceFieldUpdater.newUpdater(AbstractSendChannel.class, Object.class, "onCloseHandler");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final Function1<E, u> f25705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LockFreeLinkedListHead f25706d = new LockFreeLinkedListHead();
    private volatile /* synthetic */ Object onCloseHandler = null;

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.c$a */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u00020\u000b2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0012\u0010\u0003\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "E", "Lkotlinx/coroutines/channels/Send;", "element", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "pollResult", HttpUrl.FRAGMENT_ENCODE_SET, "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", HttpUrl.FRAGMENT_ENCODE_SET, "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "tryResumeSend", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a<E> extends Send {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final E f25707i;

        public a(E e2) {
            this.f25707i = e2;
        }

        @Override // kotlinx.coroutines.channels.Send
        public void E() {
        }

        @Override // kotlinx.coroutines.channels.Send
        /* JADX INFO: renamed from: F, reason: from getter */
        public Object getF25707i() {
            return this.f25707i;
        }

        @Override // kotlinx.coroutines.channels.Send
        public Symbol G(LockFreeLinkedListNode.b bVar) {
            Symbol symbol = kotlinx.coroutines.p.a;
            if (bVar == null) {
                return symbol;
            }
            throw null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "SendBuffered@" + t0.b(this) + '(' + this.f25707i + ')';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractSendChannel(Function1<? super E, u> function1) {
        this.f25705c = function1;
    }

    private final int e() {
        LockFreeLinkedListHead lockFreeLinkedListHead = this.f25706d;
        int i2 = 0;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeR = (LockFreeLinkedListNode) lockFreeLinkedListHead.q(); !kotlin.jvm.internal.m.a(lockFreeLinkedListNodeR, lockFreeLinkedListHead); lockFreeLinkedListNodeR = lockFreeLinkedListNodeR.r()) {
            if (lockFreeLinkedListNodeR instanceof LockFreeLinkedListNode) {
                i2++;
            }
        }
        return i2;
    }

    private final String i() {
        String string;
        LockFreeLinkedListNode lockFreeLinkedListNodeR = this.f25706d.r();
        if (lockFreeLinkedListNodeR == this.f25706d) {
            return "EmptyQueue";
        }
        if (lockFreeLinkedListNodeR instanceof Closed) {
            string = lockFreeLinkedListNodeR.toString();
        } else if (lockFreeLinkedListNodeR instanceof Receive) {
            string = "ReceiveQueued";
        } else if (lockFreeLinkedListNodeR instanceof Send) {
            string = "SendQueued";
        } else {
            string = "UNEXPECTED:" + lockFreeLinkedListNodeR;
        }
        LockFreeLinkedListNode lockFreeLinkedListNodeV = this.f25706d.v();
        if (lockFreeLinkedListNodeV == lockFreeLinkedListNodeR) {
            return string;
        }
        String str = string + ",queueSize=" + e();
        if (!(lockFreeLinkedListNodeV instanceof Closed)) {
            return str;
        }
        return str + ",closedForSend=" + lockFreeLinkedListNodeV;
    }

    private final void j(Closed<?> closed) {
        Object objB = InlineList.b(null, 1, null);
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNodeV = closed.v();
            Receive receive = lockFreeLinkedListNodeV instanceof Receive ? (Receive) lockFreeLinkedListNodeV : null;
            if (receive == null) {
                break;
            } else if (receive.z()) {
                objB = InlineList.c(objB, receive);
            } else {
                receive.w();
            }
        }
        if (objB != null) {
            if (objB instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) objB;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    ((Receive) arrayList.get(size)).G(closed);
                }
            } else {
                ((Receive) objB).G(closed);
            }
        }
        n(closed);
    }

    private final Throwable k(Closed<?> closed) {
        j(closed);
        return closed.L();
    }

    private final void l(Throwable th) {
        Symbol symbol;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (symbol = b.f25703f) || !f25704b.compareAndSet(this, obj, symbol)) {
            return;
        }
        ((Function1) l0.e(obj, 1)).invoke(th);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean c(Throwable th) {
        LockFreeLinkedListNode lockFreeLinkedListNodeV;
        boolean z;
        Closed<?> closed = new Closed<>(th);
        LockFreeLinkedListNode lockFreeLinkedListNode = this.f25706d;
        do {
            lockFreeLinkedListNodeV = lockFreeLinkedListNode.v();
            z = true;
            if (!(!(lockFreeLinkedListNodeV instanceof Closed))) {
                z = false;
                break;
            }
        } while (!lockFreeLinkedListNodeV.l(closed, lockFreeLinkedListNode));
        if (!z) {
            closed = (Closed) this.f25706d.v();
        }
        j(closed);
        if (z) {
            l(th);
        }
        return z;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object d(E e2) {
        Object objM = m(e2);
        if (objM == b.f25699b) {
            return ChannelResult.a.c(u.a);
        }
        if (objM == b.f25700c) {
            Closed<?> closedG = g();
            return closedG == null ? ChannelResult.a.b() : ChannelResult.a.a(k(closedG));
        }
        if (objM instanceof Closed) {
            return ChannelResult.a.a(k((Closed) objM));
        }
        throw new IllegalStateException(("trySend returned " + objM).toString());
    }

    protected String f() {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    protected final Closed<?> g() {
        LockFreeLinkedListNode lockFreeLinkedListNodeV = this.f25706d.v();
        Closed<?> closed = lockFreeLinkedListNodeV instanceof Closed ? (Closed) lockFreeLinkedListNodeV : null;
        if (closed == null) {
            return null;
        }
        j(closed);
        return closed;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    protected final LockFreeLinkedListHead getF25706d() {
        return this.f25706d;
    }

    protected Object m(E e2) {
        ReceiveOrClosed<E> receiveOrClosedP;
        Symbol symbolH;
        do {
            receiveOrClosedP = p();
            if (receiveOrClosedP == null) {
                return b.f25700c;
            }
            symbolH = receiveOrClosedP.h(e2, null);
        } while (symbolH == null);
        if (s0.a()) {
            if (!(symbolH == kotlinx.coroutines.p.a)) {
                throw new AssertionError();
            }
        }
        receiveOrClosedP.g(e2);
        return receiveOrClosedP.c();
    }

    protected void n(LockFreeLinkedListNode lockFreeLinkedListNode) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final ReceiveOrClosed<?> o(E e2) {
        LockFreeLinkedListNode lockFreeLinkedListNodeV;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.f25706d;
        a aVar = new a(e2);
        do {
            lockFreeLinkedListNodeV = lockFreeLinkedListHead.v();
            if (lockFreeLinkedListNodeV instanceof ReceiveOrClosed) {
                return (ReceiveOrClosed) lockFreeLinkedListNodeV;
            }
        } while (!lockFreeLinkedListNodeV.l(aVar, lockFreeLinkedListHead));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.internal.r] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    protected ReceiveOrClosed<E> p() {
        ?? r1;
        LockFreeLinkedListNode lockFreeLinkedListNodeB;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.f25706d;
        while (true) {
            r1 = (LockFreeLinkedListNode) lockFreeLinkedListHead.q();
            if (r1 == lockFreeLinkedListHead || !(r1 instanceof ReceiveOrClosed)) {
                break;
            }
            if ((!(((ReceiveOrClosed) r1) instanceof Closed) || r1.y()) && (lockFreeLinkedListNodeB = r1.B()) != null) {
                lockFreeLinkedListNodeB.x();
            }
            return (ReceiveOrClosed) r1;
        }
        r1 = 0;
        return (ReceiveOrClosed) r1;
    }

    protected final Send q() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListNode lockFreeLinkedListNodeB;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.f25706d;
        while (true) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListHead.q();
            if (lockFreeLinkedListNode == lockFreeLinkedListHead || !(lockFreeLinkedListNode instanceof Send)) {
                break;
            }
            if ((!(((Send) lockFreeLinkedListNode) instanceof Closed) || lockFreeLinkedListNode.y()) && (lockFreeLinkedListNodeB = lockFreeLinkedListNode.B()) != null) {
                lockFreeLinkedListNodeB.x();
            }
            return (Send) lockFreeLinkedListNode;
        }
        lockFreeLinkedListNode = null;
        return (Send) lockFreeLinkedListNode;
    }

    public String toString() {
        return t0.a(this) + '@' + t0.b(this) + '{' + i() + '}' + f();
    }
}
