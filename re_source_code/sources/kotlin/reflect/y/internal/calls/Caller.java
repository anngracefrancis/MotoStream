package kotlin.reflect.y.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.i0.d, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Caller.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\u00020\u0003J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H&¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00142\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0016¢\u0006\u0002\u0010\u0015R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", HttpUrl.FRAGMENT_ENCODE_SET, "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface Caller<M extends Member> {

    /* JADX INFO: renamed from: kotlin.f0.y.e.i0.d$a */
    /* JADX INFO: compiled from: Caller.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static <M extends Member> void a(Caller<? extends M> caller, Object[] objArr) {
            m.f(objArr, "args");
            if (f.a(caller) == objArr.length) {
                return;
            }
            throw new IllegalArgumentException("Callable expects " + f.a(caller) + " arguments, but " + objArr.length + " were provided.");
        }
    }

    List<Type> a();

    Object call(Object[] args);

    M getMember();

    Type getReturnType();
}
