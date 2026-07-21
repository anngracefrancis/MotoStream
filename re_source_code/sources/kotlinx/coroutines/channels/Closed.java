package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.t0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.channels.i, reason: from Kotlin metadata */
/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0014\u0010\u0016\u001a\u00020\u00122\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u001f\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00028\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006 "}, d2 = {"Lkotlinx/coroutines/channels/Closed;", "E", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "closeCause", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/Throwable;)V", "offerResult", "getOfferResult", "()Lkotlinx/coroutines/channels/Closed;", "pollResult", "getPollResult", "receiveException", "getReceiveException", "()Ljava/lang/Throwable;", "sendException", "getSendException", "completeResumeReceive", HttpUrl.FRAGMENT_ENCODE_SET, "value", "(Ljava/lang/Object;)V", "completeResumeSend", "resumeSendClosed", "closed", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "tryResumeReceive", "Lkotlinx/coroutines/internal/Symbol;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "tryResumeSend", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Closed<E> extends Send implements ReceiveOrClosed<E> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Throwable f25720i;

    public Closed(Throwable th) {
        this.f25720i = th;
    }

    @Override // kotlinx.coroutines.channels.Send
    public void E() {
    }

    @Override // kotlinx.coroutines.channels.Send
    public Symbol G(LockFreeLinkedListNode.b bVar) {
        Symbol symbol = kotlinx.coroutines.p.a;
        if (bVar == null) {
            return symbol;
        }
        throw null;
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public Closed<E> c() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.Send
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public Closed<E> F() {
        return this;
    }

    public final Throwable K() {
        Throwable th = this.f25720i;
        return th == null ? new ClosedReceiveChannelException("Channel was closed") : th;
    }

    public final Throwable L() {
        Throwable th = this.f25720i;
        return th == null ? new ClosedSendChannelException("Channel was closed") : th;
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public void g(E e2) {
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public Symbol h(E e2, LockFreeLinkedListNode.b bVar) {
        Symbol symbol = kotlinx.coroutines.p.a;
        if (bVar == null) {
            return symbol;
        }
        throw null;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return "Closed@" + t0.b(this) + '[' + this.f25720i + ']';
    }
}
