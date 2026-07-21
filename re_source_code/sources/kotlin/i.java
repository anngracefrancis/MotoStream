package kotlin;

import kotlin.jvm.functions.Function0;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\t"}, d2 = {"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", HttpUrl.FRAGMENT_ENCODE_SET, "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/LazyKt")
public class i {

    /* JADX INFO: compiled from: LazyJVM.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LazyThreadSafetyMode.values().length];
            iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
            iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
            iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
            a = iArr;
        }
    }

    public static <T> Lazy<T> a(LazyThreadSafetyMode lazyThreadSafetyMode, Function0<? extends T> function0) {
        kotlin.jvm.internal.m.f(lazyThreadSafetyMode, "mode");
        kotlin.jvm.internal.m.f(function0, "initializer");
        int i2 = a.a[lazyThreadSafetyMode.ordinal()];
        if (i2 == 1) {
            return new SynchronizedLazyImpl(function0, null, 2, null);
        }
        if (i2 == 2) {
            return new SafePublicationLazyImpl(function0);
        }
        if (i2 == 3) {
            return new UnsafeLazyImpl(function0);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static <T> Lazy<T> b(Function0<? extends T> function0) {
        kotlin.jvm.internal.m.f(function0, "initializer");
        return new SynchronizedLazyImpl(function0, null, 2, null);
    }
}
