package kotlin.reflect.y.internal.j0.l;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.h.c;
import kotlin.reflect.y.internal.j0.h.f;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* JADX INFO: compiled from: TypeWithEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends y implements o1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final y f24674i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final e0 f24675j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(y yVar, e0 e0Var) {
        super(yVar.W0(), yVar.X0());
        m.f(yVar, "origin");
        m.f(e0Var, "enhancement");
        this.f24674i = yVar;
        this.f24675j = e0Var;
    }

    @Override // kotlin.reflect.y.internal.j0.l.o1
    public e0 H() {
        return this.f24675j;
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    public q1 S0(boolean z) {
        return p1.d(v().S0(z), H().R0().S0(z));
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    public q1 U0(a1 a1Var) {
        m.f(a1Var, "newAttributes");
        return p1.d(v().U0(a1Var), H());
    }

    @Override // kotlin.reflect.y.internal.j0.l.y
    public m0 V0() {
        return v().V0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.y
    public String Y0(c cVar, f fVar) {
        m.f(cVar, "renderer");
        m.f(fVar, "options");
        return fVar.f() ? cVar.w(H()) : v().Y0(cVar, fVar);
    }

    @Override // kotlin.reflect.y.internal.j0.l.o1
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public y v() {
        return this.f24674i;
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public a0 Y0(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        e0 e0VarA = gVar.a(v());
        m.d(e0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return new a0((y) e0VarA, gVar.a(H()));
    }

    @Override // kotlin.reflect.y.internal.j0.l.y
    public String toString() {
        return "[@EnhancedForWarnings(" + H() + ")] " + v();
    }
}
