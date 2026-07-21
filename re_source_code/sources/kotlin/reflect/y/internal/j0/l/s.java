package kotlin.reflect.y.internal.j0.l;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s extends r {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m0 f24783g;

    public s(m0 m0Var) {
        m.f(m0Var, "delegate");
        this.f24783g = m0Var;
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: V0 */
    public m0 S0(boolean z) {
        return z == P0() ? this : X0().S0(z).U0(N0());
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: W0 */
    public m0 U0(a1 a1Var) {
        m.f(a1Var, "newAttributes");
        return a1Var != N0() ? new o0(this, a1Var) : this;
    }

    @Override // kotlin.reflect.y.internal.j0.l.r
    protected m0 X0() {
        return this.f24783g;
    }
}
