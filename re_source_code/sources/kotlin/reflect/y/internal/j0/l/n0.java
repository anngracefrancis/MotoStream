package kotlin.reflect.y.internal.j0.l;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.t1.g;
import kotlin.reflect.y.internal.j0.l.u1.f;
import kotlin.reflect.y.internal.j0.l.u1.l;

/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
final class n0 extends m0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e1 f24761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<g1> f24762h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f24763i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final h f24764j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Function1<g, m0> f24765k;

    /* JADX WARN: Multi-variable type inference failed */
    public n0(e1 e1Var, List<? extends g1> list, boolean z, h hVar, Function1<? super g, ? extends m0> function1) {
        m.f(e1Var, "constructor");
        m.f(list, "arguments");
        m.f(hVar, "memberScope");
        m.f(function1, "refinedTypeFactory");
        this.f24761g = e1Var;
        this.f24762h = list;
        this.f24763i = z;
        this.f24764j = hVar;
        this.f24765k = function1;
        if (!(q() instanceof f) || (q() instanceof l)) {
            return;
        }
        throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + q() + '\n' + O0());
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public List<g1> M0() {
        return this.f24762h;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public a1 N0() {
        return a1.f24676g.h();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public e1 O0() {
        return this.f24761g;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public boolean P0() {
        return this.f24763i;
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: V0 */
    public m0 S0(boolean z) {
        if (z == P0()) {
            return this;
        }
        return z ? new k0(this) : new i0(this);
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: W0 */
    public m0 U0(a1 a1Var) {
        m.f(a1Var, "newAttributes");
        return a1Var.isEmpty() ? this : new o0(this, a1Var);
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public m0 Y0(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        m0 m0VarInvoke = this.f24765k.invoke(gVar);
        return m0VarInvoke == null ? this : m0VarInvoke;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public h q() {
        return this.f24764j;
    }
}
