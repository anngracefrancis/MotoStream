package kotlin.reflect.y.internal.j0.d.a;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.p0;
import kotlin.collections.q0;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.collections.w0;
import kotlin.reflect.y.internal.j0.d.a.o0.h;
import kotlin.reflect.y.internal.j0.d.a.o0.i;
import kotlin.s;

/* JADX INFO: compiled from: AnnotationQualifiersFqNames.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final kotlin.reflect.y.internal.j0.f.c a = new kotlin.reflect.y.internal.j0.f.c("javax.annotation.meta.TypeQualifierNickname");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.c f23350b = new kotlin.reflect.y.internal.j0.f.c("javax.annotation.meta.TypeQualifier");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.c f23351c = new kotlin.reflect.y.internal.j0.f.c("javax.annotation.meta.TypeQualifierDefault");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.c f23352d = new kotlin.reflect.y.internal.j0.f.c("kotlin.annotations.jvm.UnderMigration");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List<b> f23353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map<kotlin.reflect.y.internal.j0.f.c, q> f23354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map<kotlin.reflect.y.internal.j0.f.c, q> f23355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Set<kotlin.reflect.y.internal.j0.f.c> f23356h;

    static {
        b bVar = b.VALUE_PARAMETER;
        List<b> listM = u.m(b.FIELD, b.METHOD_RETURN_TYPE, bVar, b.TYPE_PARAMETER_BOUNDS, b.TYPE_USE);
        f23353e = listM;
        kotlin.reflect.y.internal.j0.f.c cVarI = b0.i();
        h hVar = h.NOT_NULL;
        Map<kotlin.reflect.y.internal.j0.f.c, q> mapF = p0.f(s.a(cVarI, new q(new i(hVar, false, 2, null), listM, false)));
        f23354f = mapF;
        f23355g = q0.n(q0.l(s.a(new kotlin.reflect.y.internal.j0.f.c("javax.annotation.ParametersAreNullableByDefault"), new q(new i(h.NULLABLE, false, 2, null), t.e(bVar), false, 4, null)), s.a(new kotlin.reflect.y.internal.j0.f.c("javax.annotation.ParametersAreNonnullByDefault"), new q(new i(hVar, false, 2, null), t.e(bVar), false, 4, null))), mapF);
        f23356h = w0.i(b0.f(), b0.e());
    }

    public static final Map<kotlin.reflect.y.internal.j0.f.c, q> a() {
        return f23355g;
    }

    public static final Set<kotlin.reflect.y.internal.j0.f.c> b() {
        return f23356h;
    }

    public static final Map<kotlin.reflect.y.internal.j0.f.c, q> c() {
        return f23354f;
    }

    public static final kotlin.reflect.y.internal.j0.f.c d() {
        return f23352d;
    }

    public static final kotlin.reflect.y.internal.j0.f.c e() {
        return f23351c;
    }

    public static final kotlin.reflect.y.internal.j0.f.c f() {
        return f23350b;
    }

    public static final kotlin.reflect.y.internal.j0.f.c g() {
        return a;
    }
}
