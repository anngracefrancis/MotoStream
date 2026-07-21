package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.p003y.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DebugStrings.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\bH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"classSimpleName", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class t0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(Continuation<?> continuation) {
        Object objA;
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        try {
            Result.a aVar = Result.f25108f;
            objA = Result.a(continuation + '@' + b(continuation));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f25108f;
            objA = Result.a(kotlin.o.a(th));
        }
        if (Result.b(objA) != null) {
            objA = continuation.getClass().getName() + '@' + b(continuation);
        }
        return (String) objA;
    }
}
