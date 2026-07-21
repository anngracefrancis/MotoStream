package kotlin.reflect.y.internal.j0.l;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* JADX INFO: compiled from: TypeWithEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p0 extends r implements o1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m0 f24774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final e0 f24775h;

    public p0(m0 m0Var, e0 e0Var) {
        m.f(m0Var, "delegate");
        m.f(e0Var, "enhancement");
        this.f24774g = m0Var;
        this.f24775h = e0Var;
    }

    @Override // kotlin.reflect.y.internal.j0.l.o1
    public e0 H() {
        return this.f24775h;
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: V0 */
    public m0 S0(boolean z) {
        q1 q1VarD = p1.d(v().S0(z), H().R0().S0(z));
        m.d(q1VarD, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (m0) q1VarD;
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: W0 */
    public m0 U0(a1 a1Var) {
        m.f(a1Var, "newAttributes");
        q1 q1VarD = p1.d(v().U0(a1Var), H());
        m.d(q1VarD, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (m0) q1VarD;
    }

    @Override // kotlin.reflect.y.internal.j0.l.r
    protected m0 X0() {
        return this.f24774g;
    }

    @Override // kotlin.reflect.y.internal.j0.l.o1
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public m0 v() {
        return X0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.r
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public p0 Y0(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        e0 e0VarA = gVar.a(X0());
        m.d(e0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new p0((m0) e0VarA, gVar.a(H()));
    }

    @Override // kotlin.reflect.y.internal.j0.l.r
    /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] */
    public p0 Z0(m0 m0Var) {
        m.f(m0Var, "delegate");
        return new p0(m0Var, H());
    }

    @Override // kotlin.reflect.y.internal.j0.l.m0
    public String toString() {
        return "[@EnhancedForWarnings(" + H() + ")] " + v();
    }
}
