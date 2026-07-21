package kotlin.reflect.y.internal.j0.l.u1;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.v0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.g1;

/* JADX INFO: compiled from: ErrorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public static final k a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final g0 f24853b = d.f24825f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f24854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final e0 f24855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final e0 f24856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final t0 f24857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set<t0> f24858g;

    static {
        String str = String.format(b.ERROR_CLASS.k(), Arrays.copyOf(new Object[]{"unknown class"}, 1));
        m.e(str, "format(this, *args)");
        f fVarD = f.D(str);
        m.e(fVarD, "special(ErrorEntity.ERRO….format(\"unknown class\"))");
        f24854c = new a(fVarD);
        f24855d = d(j.y, new String[0]);
        f24856e = d(j.v0, new String[0]);
        e eVar = new e();
        f24857f = eVar;
        f24858g = v0.c(eVar);
    }

    private k() {
    }

    public static final f a(g gVar, boolean z, String... strArr) {
        m.f(gVar, "kind");
        m.f(strArr, "formatParams");
        return z ? new l(gVar, (String[]) Arrays.copyOf(strArr, strArr.length)) : new f(gVar, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static final f b(g gVar, String... strArr) {
        m.f(gVar, "kind");
        m.f(strArr, "formatParams");
        return a(gVar, false, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static final h d(j jVar, String... strArr) {
        m.f(jVar, "kind");
        m.f(strArr, "formatParams");
        return a.g(jVar, u.j(), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static final boolean m(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar != null) {
            k kVar = a;
            if (kVar.n(mVar) || kVar.n(mVar.b()) || mVar == f24853b) {
                return true;
            }
        }
        return false;
    }

    private final boolean n(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        return mVar instanceof a;
    }

    public static final boolean o(e0 e0Var) {
        if (e0Var == null) {
            return false;
        }
        e1 e1VarO0 = e0Var.O0();
        return (e1VarO0 instanceof i) && ((i) e1VarO0).g() == j.B;
    }

    public final h c(j jVar, e1 e1Var, String... strArr) {
        m.f(jVar, "kind");
        m.f(e1Var, "typeConstructor");
        m.f(strArr, "formatParams");
        return f(jVar, u.j(), e1Var, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final i e(j jVar, String... strArr) {
        m.f(jVar, "kind");
        m.f(strArr, "formatParams");
        return new i(jVar, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final h f(j jVar, List<? extends g1> list, e1 e1Var, String... strArr) {
        m.f(jVar, "kind");
        m.f(list, "arguments");
        m.f(e1Var, "typeConstructor");
        m.f(strArr, "formatParams");
        return new h(e1Var, b(g.ERROR_TYPE_SCOPE, e1Var.toString()), jVar, list, false, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final h g(j jVar, List<? extends g1> list, String... strArr) {
        m.f(jVar, "kind");
        m.f(list, "arguments");
        m.f(strArr, "formatParams");
        return f(jVar, list, e(jVar, (String[]) Arrays.copyOf(strArr, strArr.length)), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final a h() {
        return f24854c;
    }

    public final g0 i() {
        return f24853b;
    }

    public final Set<t0> j() {
        return f24858g;
    }

    public final e0 k() {
        return f24856e;
    }

    public final e0 l() {
        return f24855d;
    }
}
