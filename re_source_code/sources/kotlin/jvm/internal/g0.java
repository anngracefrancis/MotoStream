package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Reflection.java */
/* JADX INFO: loaded from: classes2.dex */
public class g0 {
    private static final h0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final KClass[] f22944b;

    static {
        h0 h0Var = null;
        try {
            h0Var = (h0) Class.forName("kotlin.f0.y.e.b0").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (h0Var == null) {
            h0Var = new h0();
        }
        a = h0Var;
        f22944b = new KClass[0];
    }

    public static KFunction a(i iVar) {
        return a.a(iVar);
    }

    public static KClass b(Class cls) {
        return a.b(cls);
    }

    public static KDeclarationContainer c(Class cls) {
        return a.c(cls, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public static KDeclarationContainer d(Class cls, String str) {
        return a.c(cls, str);
    }

    public static KMutableProperty0 e(p pVar) {
        return a.d(pVar);
    }

    public static KMutableProperty1 f(r rVar) {
        return a.e(rVar);
    }

    public static KProperty0 g(v vVar) {
        return a.f(vVar);
    }

    public static KProperty1 h(x xVar) {
        return a.g(xVar);
    }

    public static KProperty2 i(z zVar) {
        return a.h(zVar);
    }

    public static String j(FunctionBase functionBase) {
        return a.i(functionBase);
    }

    public static String k(Lambda lambda) {
        return a.j(lambda);
    }
}
