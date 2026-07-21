package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.p003y.Continuation;
import kotlin.u;
import kotlinx.coroutines.BeforeResumeCancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.s0;
import kotlinx.coroutines.t0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.channels.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0007STUVWXYB'\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0016\u0010\u0019\u001a\u00020\u00062\u000e\u0010\u001a\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dJ\u0017\u0010\u001e\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0002\b\u001fJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0004J\u0016\u0010\"\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0002J\u0016\u0010%\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0014JR\u0010&\u001a\u00020\n\"\u0004\b\u0001\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2$\u0010*\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0002\u00100J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0086\u0002J\u0010\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\nH\u0014J/\u00105\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u000208072\n\u00109\u001a\u0006\u0012\u0002\b\u00030:H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<J\b\u0010=\u001a\u00020\u0006H\u0014J\b\u0010>\u001a\u00020\u0006H\u0014J\n\u0010?\u001a\u0004\u0018\u00010,H\u0014J\u0016\u0010@\u001a\u0004\u0018\u00010,2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030)H\u0014J\u0011\u0010#\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010AJ\"\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bC\u0010AJ\u001f\u0010D\u001a\u0002H'\"\u0004\b\u0001\u0010'2\u0006\u0010.\u001a\u00020/H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010EJR\u0010F\u001a\u00020\u0006\"\u0004\b\u0001\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010.\u001a\u00020/2$\u0010*\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+H\u0002ø\u0001\u0000¢\u0006\u0002\u0010GJ \u0010H\u001a\u00020\u00062\n\u0010I\u001a\u0006\u0012\u0002\b\u00030J2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0002J\u0010\u0010K\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010LH\u0014J\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bN\u0010OJX\u0010P\u001a\u00020\u0006\"\u0004\b\u0001\u0010'* \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010.\u001a\u00020/2\b\u0010Q\u001a\u0004\u0018\u00010,H\u0002ø\u0001\u0000¢\u0006\u0002\u0010RR\u0014\u0010\t\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0012\u0010\u000e\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u00138Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "onUndeliveredElement", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "hasReceiveOrClosed", HttpUrl.FRAGMENT_ENCODE_SET, "getHasReceiveOrClosed", "()Z", "isBufferAlwaysEmpty", "isBufferEmpty", "isClosedForReceive", "isEmpty", "isEmptyImpl", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching", "cancel", "cause", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "cancelInternal$kotlinx_coroutines_core", "describeTryPoll", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "enqueueReceive", "receive", "Lkotlinx/coroutines/channels/Receive;", "enqueueReceiveInternal", "enqueueReceiveSelect", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/coroutines/Continuation;", "receiveMode", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)Z", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "onCancelIdempotent", "wasClosed", "onCancelIdempotentList", "list", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "closed", "Lkotlinx/coroutines/channels/Closed;", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "onReceiveDequeued", "onReceiveEnqueued", "pollInternal", "pollSelectInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveSuspend", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerSelectReceiveMode", "(Lkotlinx/coroutines/selects/SelectInstance;ILkotlin/jvm/functions/Function2;)V", "removeReceiveOnCancel", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "takeFirstReceiveOrPeekClosed", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryStartBlockUnintercepted", "value", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/selects/SelectInstance;ILjava/lang/Object;)V", "Itr", "ReceiveElement", "ReceiveElementWithUndeliveredHandler", "ReceiveHasNext", "ReceiveSelect", "RemoveReceiveOnCancel", "TryPollDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractChannel<E> extends AbstractSendChannel<E> implements Channel<E> {

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.a$a */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u00020\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J!\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "E", "Lkotlinx/coroutines/channels/Receive;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", HttpUrl.FRAGMENT_ENCODE_SET, "receiveMode", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlinx/coroutines/CancellableContinuation;I)V", "completeResumeReceive", HttpUrl.FRAGMENT_ENCODE_SET, "value", "(Ljava/lang/Object;)V", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "resumeValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static class a<E> extends Receive<E> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final CancellableContinuation<Object> f25693i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f25694j;

        public a(CancellableContinuation<Object> cancellableContinuation, int i2) {
            this.f25693i = cancellableContinuation;
            this.f25694j = i2;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void G(Closed<?> closed) {
            if (this.f25694j != 1) {
                CancellableContinuation<Object> cancellableContinuation = this.f25693i;
                Result.a aVar = Result.f25108f;
                cancellableContinuation.resumeWith(Result.a(kotlin.o.a(closed.K())));
            } else {
                CancellableContinuation<Object> cancellableContinuation2 = this.f25693i;
                ChannelResult channelResultB = ChannelResult.b(ChannelResult.a.a(closed.f25720i));
                Result.a aVar2 = Result.f25108f;
                cancellableContinuation2.resumeWith(Result.a(channelResultB));
            }
        }

        public final Object H(E e2) {
            return this.f25694j == 1 ? ChannelResult.b(ChannelResult.a.c(e2)) : e2;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void g(E e2) {
            this.f25693i.q(kotlinx.coroutines.p.a);
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol h(E e2, LockFreeLinkedListNode.b bVar) {
            CancellableContinuation<Object> cancellableContinuation = this.f25693i;
            Object objH = H(e2);
            if (bVar != null) {
                throw null;
            }
            Object objG = cancellableContinuation.g(objH, null, F(e2));
            if (objG == null) {
                return null;
            }
            if (s0.a()) {
                if (!(objG == kotlinx.coroutines.p.a)) {
                    throw new AssertionError();
                }
            }
            if (bVar == null) {
                return kotlinx.coroutines.p.a;
            }
            throw null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveElement@" + t0.b(this) + "[receiveMode=" + this.f25694j + ']';
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.a$b */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00028\u0001`\u000b¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010R&\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00028\u0001`\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElementWithUndeliveredHandler;", "E", "Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", HttpUrl.FRAGMENT_ENCODE_SET, "receiveMode", HttpUrl.FRAGMENT_ENCODE_SET, "onUndeliveredElement", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlinx/coroutines/CancellableContinuation;ILkotlin/jvm/functions/Function1;)V", "resumeOnCancellationFun", HttpUrl.FRAGMENT_ENCODE_SET, "value", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class b<E> extends a<E> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Function1<E, u> f25695k;

        /* JADX WARN: Multi-variable type inference failed */
        public b(CancellableContinuation<Object> cancellableContinuation, int i2, Function1<? super E, u> function1) {
            super(cancellableContinuation, i2);
            this.f25695k = function1;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, u> F(E e2) {
            return y.a(this.f25695k, e2, this.f25693i.getL());
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.a$c */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$RemoveReceiveOnCancel;", "Lkotlinx/coroutines/BeforeResumeCancelHandler;", "receive", "Lkotlinx/coroutines/channels/Receive;", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/Receive;)V", "invoke", HttpUrl.FRAGMENT_ENCODE_SET, "cause", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class c extends BeforeResumeCancelHandler {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Receive<?> f25696f;

        public c(Receive<?> receive) {
            this.f25696f = receive;
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        public void b(Throwable th) {
            if (this.f25696f.z()) {
                AbstractChannel.this.x();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(Throwable th) {
            b(th);
            return u.a;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.f25696f + ']';
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.a$d */
    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", HttpUrl.FRAGMENT_ENCODE_SET, "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends LockFreeLinkedListNode.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AbstractChannel f25698d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(LockFreeLinkedListNode lockFreeLinkedListNode, AbstractChannel abstractChannel) {
            super(lockFreeLinkedListNode);
            this.f25698d = abstractChannel;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (this.f25698d.w()) {
                return null;
            }
            return kotlinx.coroutines.internal.q.a();
        }
    }

    public AbstractChannel(Function1<? super E, u> function1) {
        super(function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <R> Object A(int i2, Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImplB = kotlinx.coroutines.q.b(kotlin.p003y.intrinsics.c.b(continuation));
        a aVar = this.f25705c == null ? new a(cancellableContinuationImplB, i2) : new b(cancellableContinuationImplB, i2, this.f25705c);
        while (true) {
            if (t(aVar)) {
                B(cancellableContinuationImplB, aVar);
                break;
            }
            Object objZ = z();
            if (objZ instanceof Closed) {
                aVar.G((Closed) objZ);
                break;
            }
            if (objZ != kotlinx.coroutines.channels.b.f25701d) {
                cancellableContinuationImplB.n(aVar.H(objZ), aVar.F(objZ));
                break;
            }
        }
        Object objW = cancellableContinuationImplB.w();
        if (objW == kotlin.p003y.intrinsics.d.c()) {
            kotlin.p003y.j.p004a.h.c(continuation);
        }
        return objW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(CancellableContinuation<?> cancellableContinuation, Receive<?> receive) {
        cancellableContinuation.e(new c(receive));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean t(Receive<? super E> receive) {
        boolean zU = u(receive);
        if (zU) {
            y();
        }
        return zU;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object a() {
        Object objZ = z();
        if (objZ == kotlinx.coroutines.channels.b.f25701d) {
            return ChannelResult.a.b();
        }
        return objZ instanceof Closed ? ChannelResult.a.a(((Closed) objZ).f25720i) : ChannelResult.a.c(objZ);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object b(Continuation<? super E> continuation) {
        Object objZ = z();
        return (objZ == kotlinx.coroutines.channels.b.f25701d || (objZ instanceof Closed)) ? A(0, continuation) : objZ;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected ReceiveOrClosed<E> p() {
        ReceiveOrClosed<E> receiveOrClosedP = super.p();
        if (receiveOrClosedP != null && !(receiveOrClosedP instanceof Closed)) {
            x();
        }
        return receiveOrClosedP;
    }

    protected boolean u(Receive<? super E> receive) {
        int iD;
        LockFreeLinkedListNode lockFreeLinkedListNodeV;
        if (!v()) {
            LockFreeLinkedListNode f25706d = getF25706d();
            d dVar = new d(receive, this);
            do {
                LockFreeLinkedListNode lockFreeLinkedListNodeV2 = f25706d.v();
                if (!(!(lockFreeLinkedListNodeV2 instanceof Send))) {
                    return false;
                }
                iD = lockFreeLinkedListNodeV2.D(receive, f25706d, dVar);
                if (iD != 1) {
                }
            } while (iD != 2);
            return false;
        }
        LockFreeLinkedListNode f25706d2 = getF25706d();
        do {
            lockFreeLinkedListNodeV = f25706d2.v();
            if (!(!(lockFreeLinkedListNodeV instanceof Send))) {
                return false;
            }
        } while (!lockFreeLinkedListNodeV.l(receive, f25706d2));
        return true;
    }

    protected abstract boolean v();

    protected abstract boolean w();

    protected void x() {
    }

    protected void y() {
    }

    protected Object z() {
        while (true) {
            Send sendQ = q();
            if (sendQ == null) {
                return kotlinx.coroutines.channels.b.f25701d;
            }
            Symbol symbolG = sendQ.G(null);
            if (symbolG != null) {
                if (s0.a()) {
                    if (!(symbolG == kotlinx.coroutines.p.a)) {
                        throw new AssertionError();
                    }
                }
                sendQ.E();
                return sendQ.getF25707i();
            }
            sendQ.H();
        }
    }
}
