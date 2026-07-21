package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.s0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.internal.t, reason: from Kotlin metadata */
/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\b\u0000\u0018\u0000 /*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002/0B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0013J-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\"\u0010#J3\u0010&\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010(R\u0011\u0010)\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b)\u0010\u0013R\u0014\u0010*\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010+R\u0011\u0010.\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", HttpUrl.FRAGMENT_ENCODE_SET, "E", HttpUrl.FRAGMENT_ENCODE_SET, "capacity", HttpUrl.FRAGMENT_ENCODE_SET, "singleConsumer", "<init>", "(IZ)V", "element", "addLast", "(Ljava/lang/Object;)I", HttpUrl.FRAGMENT_ENCODE_SET, "state", "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "close", "()Z", "index", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "R", "Lkotlin/Function1;", "transform", HttpUrl.FRAGMENT_ENCODE_SET, "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "isEmpty", "mask", "Z", "getSize", "()I", "size", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LockFreeTaskQueueCore<E> {
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f25831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f25832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f25833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private /* synthetic */ AtomicReferenceArray f25834h;
    public static final a a = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Symbol f25830d = new Symbol("REMOVE_FROZEN");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f25828b = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f25829c = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");

    /* JADX INFO: renamed from: kotlinx.coroutines.internal.t$a */
    /* JADX INFO: compiled from: LockFreeTaskQueue.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0016\u001a\u00020\u0004*\u00020\tJ\u0012\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004JP\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0001\u0010\u001c*\u00020\t26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0086\b¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0086\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "ADD_CLOSED", HttpUrl.FRAGMENT_ENCODE_SET, "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", HttpUrl.FRAGMENT_ENCODE_SET, "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final int a(long j2) {
            return (j2 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j2, int i2) {
            return d(j2, 1073741823L) | (((long) i2) << 0);
        }

        public final long c(long j2, int i2) {
            return d(j2, 1152921503533105152L) | (((long) i2) << 30);
        }

        public final long d(long j2, long j3) {
            return j2 & (j3 ^ (-1));
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.internal.t$b */
    /* JADX INFO: compiled from: LockFreeTaskQueue.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", HttpUrl.FRAGMENT_ENCODE_SET, "index", HttpUrl.FRAGMENT_ENCODE_SET, "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        public final int a;

        public b(int i2) {
            this.a = i2;
        }
    }

    public LockFreeTaskQueueCore(int i2, boolean z) {
        this.f25831e = i2;
        this.f25832f = z;
        int i3 = i2 - 1;
        this.f25833g = i3;
        this.f25834h = new AtomicReferenceArray(i2);
        if (!(i3 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i2 & i3) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LockFreeTaskQueueCore<E> b(long j2) {
        LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = new LockFreeTaskQueueCore<>(this.f25831e * 2, this.f25832f);
        int i2 = (int) ((1073741823 & j2) >> 0);
        int i3 = (int) ((1152921503533105152L & j2) >> 30);
        while (true) {
            int i4 = this.f25833g;
            if ((i2 & i4) == (i3 & i4)) {
                lockFreeTaskQueueCore._state = a.d(j2, 1152921504606846976L);
                return lockFreeTaskQueueCore;
            }
            Object bVar = this.f25834h.get(i4 & i2);
            if (bVar == null) {
                bVar = new b(i2);
            }
            lockFreeTaskQueueCore.f25834h.set(lockFreeTaskQueueCore.f25833g & i2, bVar);
            i2++;
        }
    }

    private final LockFreeTaskQueueCore<E> c(long j2) {
        while (true) {
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._next;
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            f25828b.compareAndSet(this, null, b(j2));
        }
    }

    private final LockFreeTaskQueueCore<E> e(int i2, E e2) {
        Object obj = this.f25834h.get(this.f25833g & i2);
        if (!(obj instanceof b) || ((b) obj).a != i2) {
            return null;
        }
        this.f25834h.set(i2 & this.f25833g, e2);
        return this;
    }

    private final long h() {
        long j2;
        long j3;
        do {
            j2 = this._state;
            if ((j2 & 1152921504606846976L) != 0) {
                return j2;
            }
            j3 = j2 | 1152921504606846976L;
        } while (!f25829c.compareAndSet(this, j2, j3));
        return j3;
    }

    private final LockFreeTaskQueueCore<E> k(int i2, int i3) {
        long j2;
        a aVar;
        int i4;
        do {
            j2 = this._state;
            aVar = a;
            i4 = (int) ((1073741823 & j2) >> 0);
            if (s0.a()) {
                if (!(i4 == i2)) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & j2) != 0) {
                return i();
            }
        } while (!f25829c.compareAndSet(this, j2, aVar.b(j2, i3)));
        this.f25834h.set(this.f25833g & i4, null);
        return null;
    }

    public final int a(E e2) {
        while (true) {
            long j2 = this._state;
            if ((3458764513820540928L & j2) != 0) {
                return a.a(j2);
            }
            a aVar = a;
            int i2 = (int) ((1073741823 & j2) >> 0);
            int i3 = (int) ((1152921503533105152L & j2) >> 30);
            int i4 = this.f25833g;
            if (((i3 + 2) & i4) == (i2 & i4)) {
                return 1;
            }
            if (!this.f25832f && this.f25834h.get(i3 & i4) != null) {
                int i5 = this.f25831e;
                if (i5 < 1024 || ((i3 - i2) & 1073741823) > (i5 >> 1)) {
                    return 1;
                }
            } else if (f25829c.compareAndSet(this, j2, aVar.c(j2, (i3 + 1) & 1073741823))) {
                this.f25834h.set(i3 & i4, e2);
                LockFreeTaskQueueCore<E> lockFreeTaskQueueCoreE = this;
                while ((lockFreeTaskQueueCoreE._state & 1152921504606846976L) != 0 && (lockFreeTaskQueueCoreE = lockFreeTaskQueueCoreE.i().e(i3, e2)) != null) {
                }
                return 0;
            }
        }
    }

    public final boolean d() {
        long j2;
        do {
            j2 = this._state;
            if ((j2 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j2) != 0) {
                return false;
            }
        } while (!f25829c.compareAndSet(this, j2, j2 | 2305843009213693952L));
        return true;
    }

    public final int f() {
        long j2 = this._state;
        return 1073741823 & (((int) ((j2 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j2) >> 0)));
    }

    public final boolean g() {
        long j2 = this._state;
        return ((int) ((1073741823 & j2) >> 0)) == ((int) ((j2 & 1152921503533105152L) >> 30));
    }

    public final LockFreeTaskQueueCore<E> i() {
        return c(h());
    }

    public final Object j() {
        while (true) {
            long j2 = this._state;
            if ((1152921504606846976L & j2) != 0) {
                return f25830d;
            }
            a aVar = a;
            int i2 = (int) ((1073741823 & j2) >> 0);
            int i3 = (int) ((1152921503533105152L & j2) >> 30);
            int i4 = this.f25833g;
            if ((i3 & i4) == (i2 & i4)) {
                return null;
            }
            Object obj = this.f25834h.get(i4 & i2);
            if (obj == null) {
                if (this.f25832f) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i5 = (i2 + 1) & 1073741823;
                if (f25829c.compareAndSet(this, j2, aVar.b(j2, i5))) {
                    this.f25834h.set(this.f25833g & i2, null);
                    return obj;
                }
                if (this.f25832f) {
                    LockFreeTaskQueueCore<E> lockFreeTaskQueueCoreK = this;
                    do {
                        lockFreeTaskQueueCoreK = lockFreeTaskQueueCoreK.k(i2, i5);
                    } while (lockFreeTaskQueueCoreK != null);
                    return obj;
                }
            }
        }
    }
}
