package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.o;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0011\u0010\b\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0002\u001a\u0016\u0010\u000e\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0002\u001a\u001d\u0010\u000f\u001a\u00020\u0003*\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\b\u0013\u001a\u0014\u0010\u0014\u001a\u00020\u0010*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"MAX_DELAY", HttpUrl.FRAGMENT_ENCODE_SET, "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "getMain$annotations", "()V", "choreographer", "Landroid/view/Choreographer;", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postFrameCallback", HttpUrl.FRAGMENT_ENCODE_SET, "cont", "Lkotlinx/coroutines/CancellableContinuation;", "updateChoreographerAndPostFrameCallback", "asCoroutineDispatcher", "Landroid/os/Handler;", "name", HttpUrl.FRAGMENT_ENCODE_SET, "from", "asHandler", "Landroid/os/Looper;", "async", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class c {
    public static final HandlerDispatcher a;
    private static volatile Choreographer choreographer;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Object objA;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        try {
            Result.a aVar = Result.f25108f;
            objA = Result.a(new HandlerContext(a(Looper.getMainLooper(), true), objArr2 == true ? 1 : 0, 2, objArr == true ? 1 : 0));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f25108f;
            objA = Result.a(o.a(th));
        }
        a = (HandlerDispatcher) (Result.c(objA) ? null : objA);
    }

    public static final Handler a(Looper looper, boolean z) throws IllegalAccessException, InvocationTargetException {
        int i2;
        if (!z || (i2 = Build.VERSION.SDK_INT) < 16) {
            return new Handler(looper);
        }
        if (i2 < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        if (objInvoke != null) {
            return (Handler) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
    }
}
