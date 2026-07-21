package kotlin.reflect.y.internal.j0.l.t1;

import kotlin.jvm.internal.g;
import kotlin.reflect.y.internal.j0.i.j;
import kotlin.reflect.y.internal.j0.l.d1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f;
import kotlin.reflect.y.internal.j0.l.q1;

/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f24804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f24805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j f24806e;

    public m(g gVar, f fVar) {
        kotlin.jvm.internal.m.f(gVar, "kotlinTypeRefiner");
        kotlin.jvm.internal.m.f(fVar, "kotlinTypePreparator");
        this.f24804c = gVar;
        this.f24805d = fVar;
        j jVarM = j.m(c());
        kotlin.jvm.internal.m.e(jVarM, "createWithTypeRefiner(kotlinTypeRefiner)");
        this.f24806e = jVarM;
    }

    @Override // kotlin.reflect.y.internal.j0.l.t1.l
    public j a() {
        return this.f24806e;
    }

    @Override // kotlin.reflect.y.internal.j0.l.t1.e
    public boolean b(e0 e0Var, e0 e0Var2) {
        kotlin.jvm.internal.m.f(e0Var, "a");
        kotlin.jvm.internal.m.f(e0Var2, "b");
        return e(a.b(false, false, null, f(), c(), 6, null), e0Var.R0(), e0Var2.R0());
    }

    @Override // kotlin.reflect.y.internal.j0.l.t1.l
    public g c() {
        return this.f24804c;
    }

    @Override // kotlin.reflect.y.internal.j0.l.t1.e
    public boolean d(e0 e0Var, e0 e0Var2) {
        kotlin.jvm.internal.m.f(e0Var, "subtype");
        kotlin.jvm.internal.m.f(e0Var2, "supertype");
        return g(a.b(true, false, null, f(), c(), 6, null), e0Var.R0(), e0Var2.R0());
    }

    public final boolean e(d1 d1Var, q1 q1Var, q1 q1Var2) {
        kotlin.jvm.internal.m.f(d1Var, "<this>");
        kotlin.jvm.internal.m.f(q1Var, "a");
        kotlin.jvm.internal.m.f(q1Var2, "b");
        return f.a.k(d1Var, q1Var, q1Var2);
    }

    public f f() {
        return this.f24805d;
    }

    public final boolean g(d1 d1Var, q1 q1Var, q1 q1Var2) {
        kotlin.jvm.internal.m.f(d1Var, "<this>");
        kotlin.jvm.internal.m.f(q1Var, "subType");
        kotlin.jvm.internal.m.f(q1Var2, "superType");
        return f.t(f.a, d1Var, q1Var, q1Var2, false, 8, null);
    }

    public /* synthetic */ m(g gVar, f fVar, int i2, g gVar2) {
        this(gVar, (i2 & 2) != 0 ? f.a.a : fVar);
    }
}
