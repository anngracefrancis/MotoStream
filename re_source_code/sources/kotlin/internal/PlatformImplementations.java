package kotlin.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.jvm.internal.m;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.z.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lkotlin/internal/PlatformImplementations;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "addSuppressed", HttpUrl.FRAGMENT_ENCODE_SET, "cause", HttpUrl.FRAGMENT_ENCODE_SET, "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", HttpUrl.FRAGMENT_ENCODE_SET, "getSuppressed", HttpUrl.FRAGMENT_ENCODE_SET, "ReflectThrowable", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class PlatformImplementations {

    /* JADX INFO: renamed from: kotlin.z.a$a */
    /* JADX INFO: compiled from: PlatformImplementations.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a {
        public static final a a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Method f25625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Method f25626c;

        /* JADX WARN: Code duplicated, block: B:10:0x003b  */
        static {
            Method method;
            Method method2;
            boolean z;
            Method[] methods = Throwable.class.getMethods();
            m.e(methods, "throwableMethods");
            int length = methods.length;
            int i2 = 0;
            while (true) {
                method = null;
                if (i2 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i2];
                if (m.a(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    m.e(parameterTypes, "it.parameterTypes");
                    if (m.a(j.O(parameterTypes), Throwable.class)) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    break;
                } else {
                    i2++;
                }
            }
            f25625b = method2;
            for (Method method3 : methods) {
                if (m.a(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
            }
            f25626c = method;
        }

        private a() {
        }
    }

    public void a(Throwable th, Throwable th2) {
        m.f(th, "cause");
        m.f(th2, "exception");
        Method method = a.f25625b;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public Random b() {
        return new FallbackThreadLocalRandom();
    }
}
