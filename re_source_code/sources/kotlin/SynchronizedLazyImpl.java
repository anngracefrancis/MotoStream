package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.q, reason: from Kotlin metadata */
/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0088\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "writeReplace", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class SynchronizedLazyImpl<T> implements Lazy<T>, Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function0<? extends T> f25115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile Object f25116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f25117h;

    public SynchronizedLazyImpl(Function0<? extends T> function0, Object obj) {
        kotlin.jvm.internal.m.f(function0, "initializer");
        this.f25115f = function0;
        this.f25116g = UNINITIALIZED_VALUE.a;
        this.f25117h = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    public boolean a() {
        return this.f25116g != UNINITIALIZED_VALUE.a;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T tInvoke;
        T t = (T) this.f25116g;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.a;
        if (t != uninitialized_value) {
            return t;
        }
        synchronized (this.f25117h) {
            tInvoke = (T) this.f25116g;
            if (tInvoke == uninitialized_value) {
                Function0<? extends T> function0 = this.f25115f;
                kotlin.jvm.internal.m.c(function0);
                tInvoke = function0.invoke();
                this.f25116g = tInvoke;
                this.f25115f = null;
            }
        }
        return tInvoke;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ SynchronizedLazyImpl(Function0 function0, Object obj, int i2, kotlin.jvm.internal.g gVar) {
        this(function0, (i2 & 2) != 0 ? null : obj);
    }
}
