package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import kotlinx.coroutines.s0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.internal.j0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ThreadSafeHeap.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\u0018\u0002\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u000605j\u0002`6B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\tJ.\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u00002\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\f0\u000bH\u0086\b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0005J2\u0010\u0015\u001a\u0004\u0018\u00018\u00002!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u001fH\u0001¢\u0006\u0004\b!\u0010\"J&\u0010#\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000bH\u0086\b¢\u0006\u0004\b#\u0010\u0016J\u000f\u0010$\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b$\u0010\u0018J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001fH\u0082\u0010¢\u0006\u0004\b&\u0010'J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001fH\u0082\u0010¢\u0006\u0004\b(\u0010'J\u001f\u0010*\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001fH\u0002¢\u0006\u0004\b*\u0010+R \u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0011\u0010.\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b.\u0010/R$\u00103\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u001f8F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u0010'¨\u00064"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", HttpUrl.FRAGMENT_ENCODE_SET, "T", "<init>", "()V", "node", HttpUrl.FRAGMENT_ENCODE_SET, "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "Lkotlin/ParameterName;", "name", "value", "predicate", "find", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", HttpUrl.FRAGMENT_ENCODE_SET, "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", HttpUrl.FRAGMENT_ENCODE_SET, "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstIf", "removeFirstOrNull", "i", "siftDownFrom", "(I)V", "siftUpFrom", "j", "swap", "(II)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "getSize", "()I", "setSize", "size", "kotlinx-coroutines-core", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/internal/SynchronizedObject;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private volatile /* synthetic */ int _size = 0;
    private T[] a;

    private final T[] f() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new ThreadSafeHeapNode[4];
            this.a = tArr2;
            return tArr2;
        }
        if (get_size() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, get_size() * 2);
        kotlin.jvm.internal.m.e(objArrCopyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((ThreadSafeHeapNode[]) objArrCopyOf);
        this.a = tArr3;
        return tArr3;
    }

    private final void j(int i2) {
        this._size = i2;
    }

    private final void k(int i2) {
        while (true) {
            int i3 = (i2 * 2) + 1;
            if (i3 >= get_size()) {
                return;
            }
            T[] tArr = this.a;
            kotlin.jvm.internal.m.c(tArr);
            int i4 = i3 + 1;
            if (i4 < get_size()) {
                T t = tArr[i4];
                kotlin.jvm.internal.m.c(t);
                T t2 = tArr[i3];
                kotlin.jvm.internal.m.c(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    i3 = i4;
                }
            }
            T t3 = tArr[i2];
            kotlin.jvm.internal.m.c(t3);
            T t4 = tArr[i3];
            kotlin.jvm.internal.m.c(t4);
            if (((Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            m(i2, i3);
            i2 = i3;
        }
    }

    private final void l(int i2) {
        while (i2 > 0) {
            T[] tArr = this.a;
            kotlin.jvm.internal.m.c(tArr);
            int i3 = (i2 - 1) / 2;
            T t = tArr[i3];
            kotlin.jvm.internal.m.c(t);
            T t2 = tArr[i2];
            kotlin.jvm.internal.m.c(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            m(i2, i3);
            i2 = i3;
        }
    }

    private final void m(int i2, int i3) {
        T[] tArr = this.a;
        kotlin.jvm.internal.m.c(tArr);
        T t = tArr[i3];
        kotlin.jvm.internal.m.c(t);
        T t2 = tArr[i2];
        kotlin.jvm.internal.m.c(t2);
        tArr[i2] = t;
        tArr[i3] = t2;
        t.D(i2);
        t2.D(i3);
    }

    public final void a(T t) {
        if (s0.a()) {
            if (!(t.v() == null)) {
                throw new AssertionError();
            }
        }
        t.q(this);
        ThreadSafeHeapNode[] threadSafeHeapNodeArrF = f();
        int i2 = get_size();
        j(i2 + 1);
        threadSafeHeapNodeArrF[i2] = t;
        t.D(i2);
        l(i2);
    }

    public final T b() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public final boolean d() {
        return get_size() == 0;
    }

    public final T e() {
        T t;
        synchronized (this) {
            t = (T) b();
        }
        return t;
    }

    public final boolean g(T t) {
        boolean z;
        synchronized (this) {
            z = true;
            if (t.v() == null) {
                z = false;
            } else {
                int iG = t.g();
                if (s0.a()) {
                    if (!(iG >= 0)) {
                        throw new AssertionError();
                    }
                }
                h(iG);
            }
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0054  */
    public final T h(int i2) {
        if (s0.a()) {
            if (!(get_size() > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.a;
        kotlin.jvm.internal.m.c(tArr);
        j(get_size() - 1);
        if (i2 < get_size()) {
            m(i2, get_size());
            int i3 = (i2 - 1) / 2;
            if (i2 > 0) {
                T t = tArr[i2];
                kotlin.jvm.internal.m.c(t);
                T t2 = tArr[i3];
                kotlin.jvm.internal.m.c(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    m(i2, i3);
                    l(i3);
                } else {
                    k(i2);
                }
            } else {
                k(i2);
            }
        }
        T t3 = tArr[get_size()];
        kotlin.jvm.internal.m.c(t3);
        if (s0.a()) {
            if (!(t3.v() == this)) {
                throw new AssertionError();
            }
        }
        t3.q(null);
        t3.D(-1);
        tArr[get_size()] = null;
        return t3;
    }

    public final T i() {
        T t;
        synchronized (this) {
            t = get_size() > 0 ? (T) h(0) : null;
        }
        return t;
    }
}
