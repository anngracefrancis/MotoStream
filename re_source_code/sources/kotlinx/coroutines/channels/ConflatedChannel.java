package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.u;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.s0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.channels.j, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ConflatedChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012 \u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0018\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0014J\u0015\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00028\u00002\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 H\u0014¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\rH\u0014J\n\u0010$\u001a\u0004\u0018\u00010\u0017H\u0014J\u0016\u0010%\u001a\u0004\u0018\u00010\u00172\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 H\u0014J\u0014\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0002R\u0014\u0010\b\u001a\u00020\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\r8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0012\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lkotlinx/coroutines/channels/ConflatedChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "onUndeliveredElement", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "bufferDebugString", HttpUrl.FRAGMENT_ENCODE_SET, "getBufferDebugString", "()Ljava/lang/String;", "isBufferAlwaysEmpty", HttpUrl.FRAGMENT_ENCODE_SET, "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isEmpty", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "value", HttpUrl.FRAGMENT_ENCODE_SET, "enqueueReceiveInternal", "receive", "Lkotlinx/coroutines/channels/Receive;", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onCancelIdempotent", "wasClosed", "pollInternal", "pollSelectInternal", "updateValueLocked", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ConflatedChannel<E> extends AbstractChannel<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ReentrantLock f25721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f25722f;

    public ConflatedChannel(Function1<? super E, u> function1) {
        super(function1);
        this.f25721e = new ReentrantLock();
        this.f25722f = b.a;
    }

    private final UndeliveredElementException C(Object obj) {
        Function1<E, u> function1;
        Object obj2 = this.f25722f;
        UndeliveredElementException undeliveredElementExceptionD = null;
        if (obj2 != b.a && (function1 = this.f25705c) != null) {
            undeliveredElementExceptionD = y.d(function1, obj2, null, 2, null);
        }
        this.f25722f = obj;
        return undeliveredElementExceptionD;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected String f() {
        ReentrantLock reentrantLock = this.f25721e;
        reentrantLock.lock();
        try {
            return "(value=" + this.f25722f + ')';
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object m(E e2) {
        ReentrantLock reentrantLock = this.f25721e;
        reentrantLock.lock();
        try {
            Closed<?> closedG = g();
            if (closedG != null) {
                reentrantLock.unlock();
                return closedG;
            }
            if (this.f25722f == b.a) {
                while (true) {
                    ReceiveOrClosed<E> receiveOrClosedP = p();
                    if (receiveOrClosedP == null) {
                        break;
                    }
                    if (receiveOrClosedP instanceof Closed) {
                        reentrantLock.unlock();
                        return receiveOrClosedP;
                    }
                    kotlin.jvm.internal.m.c(receiveOrClosedP);
                    Symbol symbolH = receiveOrClosedP.h(e2, null);
                    if (symbolH != null) {
                        if (s0.a()) {
                            if (!(symbolH == kotlinx.coroutines.p.a)) {
                                throw new AssertionError();
                            }
                        }
                        u uVar = u.a;
                        reentrantLock.unlock();
                        receiveOrClosedP.g(e2);
                        return receiveOrClosedP.c();
                    }
                }
            }
            UndeliveredElementException undeliveredElementExceptionC = C(e2);
            if (undeliveredElementExceptionC != null) {
                throw undeliveredElementExceptionC;
            }
            Symbol symbol = b.f25699b;
            reentrantLock.unlock();
            return symbol;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected boolean u(Receive<? super E> receive) {
        ReentrantLock reentrantLock = this.f25721e;
        reentrantLock.lock();
        try {
            return super.u(receive);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean v() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean w() {
        ReentrantLock reentrantLock = this.f25721e;
        reentrantLock.lock();
        try {
            return this.f25722f == b.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object z() {
        ReentrantLock reentrantLock = this.f25721e;
        reentrantLock.lock();
        try {
            Object obj = this.f25722f;
            Symbol symbol = b.a;
            if (obj != symbol) {
                this.f25722f = symbol;
                u uVar = u.a;
                return obj;
            }
            Object objG = g();
            if (objG == null) {
                objG = b.f25701d;
            }
            return objG;
        } finally {
            reentrantLock.unlock();
        }
    }
}
