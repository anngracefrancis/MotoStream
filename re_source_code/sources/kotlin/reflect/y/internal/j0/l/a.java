package kotlin.reflect.y.internal.j0.l;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends r {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m0 f24672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final m0 f24673h;

    public a(m0 m0Var, m0 m0Var2) {
        m.f(m0Var, "delegate");
        m.f(m0Var2, "abbreviation");
        this.f24672g = m0Var;
        this.f24673h = m0Var2;
    }

    public final m0 W() {
        return X0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: W0 */
    public m0 U0(a1 a1Var) {
        m.f(a1Var, "newAttributes");
        return new a(X0().U0(a1Var), this.f24673h);
    }

    @Override // kotlin.reflect.y.internal.j0.l.r
    protected m0 X0() {
        return this.f24672g;
    }

    public final m0 a1() {
        return this.f24673h;
    }

    @Override // kotlin.reflect.y.internal.j0.l.m0
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public a S0(boolean z) {
        return new a(X0().S0(z), this.f24673h.S0(z));
    }

    @Override // kotlin.reflect.y.internal.j0.l.r
    /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public a Y0(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        e0 e0VarA = gVar.a(X0());
        m.d(e0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        e0 e0VarA2 = gVar.a(this.f24673h);
        m.d(e0VarA2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new a((m0) e0VarA, (m0) e0VarA2);
    }

    @Override // kotlin.reflect.y.internal.j0.l.r
    /* JADX INFO: renamed from: d1, reason: merged with bridge method [inline-methods] */
    public a Z0(m0 m0Var) {
        m.f(m0Var, "delegate");
        return new a(m0Var, this.f24673h);
    }
}
