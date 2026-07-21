package kotlinx.coroutines.internal;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.internal.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ArrayQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u000eH\u0002J\r\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0014R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/internal/ArrayQueue;", "T", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "elements", HttpUrl.FRAGMENT_ENCODE_SET, "[Ljava/lang/Object;", "head", HttpUrl.FRAGMENT_ENCODE_SET, "isEmpty", HttpUrl.FRAGMENT_ENCODE_SET, "()Z", "tail", "addLast", HttpUrl.FRAGMENT_ENCODE_SET, "element", "(Ljava/lang/Object;)V", "clear", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ArrayQueue<T> {
    private Object[] a = new Object[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f25789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f25790c;

    private final void b() {
        Object[] objArr = this.a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        kotlin.collections.m.g(objArr, objArr2, 0, this.f25789b, 0, 10, null);
        Object[] objArr3 = this.a;
        int length2 = objArr3.length;
        int i2 = this.f25789b;
        kotlin.collections.m.g(objArr3, objArr2, length2 - i2, 0, i2, 4, null);
        this.a = objArr2;
        this.f25789b = 0;
        this.f25790c = length;
    }

    public final void a(T t) {
        Object[] objArr = this.a;
        int i2 = this.f25790c;
        objArr[i2] = t;
        int length = (objArr.length - 1) & (i2 + 1);
        this.f25790c = length;
        if (length == this.f25789b) {
            b();
        }
    }

    public final boolean c() {
        return this.f25789b == this.f25790c;
    }

    public final T d() {
        int i2 = this.f25789b;
        if (i2 == this.f25790c) {
            return null;
        }
        Object[] objArr = this.a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.f25789b = (i2 + 1) & (objArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }
}
