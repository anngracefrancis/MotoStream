package kotlin.reflect.y;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.KCallableImpl;
import kotlin.reflect.y.internal.calls.Caller;
import kotlin.reflect.y.internal.g0;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: KCallablesJvm.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\",\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"value", HttpUrl.FRAGMENT_ENCODE_SET, "isAccessible", "Lkotlin/reflect/KCallable;", "(Lkotlin/reflect/KCallable;)Z", "setAccessible", "(Lkotlin/reflect/KCallable;Z)V", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class a {
    public static final void a(KCallable<?> kCallable, boolean z) {
        Caller<?> callerB;
        m.f(kCallable, "<this>");
        if (kCallable instanceof KMutableProperty) {
            KProperty kProperty = (KProperty) kCallable;
            Field fieldB = c.b(kProperty);
            if (fieldB != null) {
                fieldB.setAccessible(z);
            }
            Method methodC = c.c(kProperty);
            if (methodC != null) {
                methodC.setAccessible(z);
            }
            Method methodE = c.e((KMutableProperty) kCallable);
            if (methodE == null) {
                return;
            }
            methodE.setAccessible(z);
            return;
        }
        if (kCallable instanceof KProperty) {
            KProperty kProperty2 = (KProperty) kCallable;
            Field fieldB2 = c.b(kProperty2);
            if (fieldB2 != null) {
                fieldB2.setAccessible(z);
            }
            Method methodC2 = c.c(kProperty2);
            if (methodC2 == null) {
                return;
            }
            methodC2.setAccessible(z);
            return;
        }
        if (kCallable instanceof KProperty.b) {
            Field fieldB3 = c.b(((KProperty.b) kCallable).n());
            if (fieldB3 != null) {
                fieldB3.setAccessible(z);
            }
            Method methodD = c.d((KFunction) kCallable);
            if (methodD == null) {
                return;
            }
            methodD.setAccessible(z);
            return;
        }
        if (kCallable instanceof KMutableProperty.a) {
            Field fieldB4 = c.b(((KMutableProperty.a) kCallable).n());
            if (fieldB4 != null) {
                fieldB4.setAccessible(z);
            }
            Method methodD2 = c.d((KFunction) kCallable);
            if (methodD2 == null) {
                return;
            }
            methodD2.setAccessible(z);
            return;
        }
        if (!(kCallable instanceof KFunction)) {
            throw new UnsupportedOperationException("Unknown callable: " + kCallable + " (" + kCallable.getClass() + ')');
        }
        KFunction kFunction = (KFunction) kCallable;
        Method methodD3 = c.d(kFunction);
        if (methodD3 != null) {
            methodD3.setAccessible(z);
        }
        KCallableImpl<?> kCallableImplB = g0.b(kCallable);
        Member member = (kCallableImplB == null || (callerB = kCallableImplB.B()) == null) ? null : callerB.getMember();
        AccessibleObject accessibleObject = member instanceof AccessibleObject ? (AccessibleObject) member : null;
        if (accessibleObject != null) {
            accessibleObject.setAccessible(true);
        }
        Constructor constructorA = c.a(kFunction);
        if (constructorA == null) {
            return;
        }
        constructorA.setAccessible(z);
    }
}
