package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.v, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Lazy.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0088\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", HttpUrl.FRAGMENT_ENCODE_SET, "value", "getValue", "()Ljava/lang/Object;", "isInitialized", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "writeReplace", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UnsafeLazyImpl<T> implements Lazy<T>, Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function0<? extends T> f25530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f25531g;

    public UnsafeLazyImpl(Function0<? extends T> function0) {
        kotlin.jvm.internal.m.f(function0, "initializer");
        this.f25530f = function0;
        this.f25531g = UNINITIALIZED_VALUE.a;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    public boolean a() {
        return this.f25531g != UNINITIALIZED_VALUE.a;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        if (this.f25531g == UNINITIALIZED_VALUE.a) {
            Function0<? extends T> function0 = this.f25530f;
            kotlin.jvm.internal.m.c(function0);
            this.f25531g = function0.invoke();
            this.f25530f = null;
        }
        return (T) this.f25531g;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
