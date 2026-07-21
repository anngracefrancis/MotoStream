package kotlin.reflect.y.internal.j0.l;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.y.internal.j0.h.c;
import kotlin.reflect.y.internal.j0.h.f;
import kotlin.reflect.y.internal.j0.l.t1.e;

/* JADX INFO: compiled from: flexibleTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z extends y implements n {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f24884i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f24885j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f24886k;

    /* JADX INFO: compiled from: flexibleTypes.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(m0 m0Var, m0 m0Var2) {
        super(m0Var, m0Var2);
        m.f(m0Var, "lowerBound");
        m.f(m0Var2, "upperBound");
    }

    private final void a1() {
        if (!f24885j || this.f24886k) {
            return;
        }
        this.f24886k = true;
        b0.b(W0());
        b0.b(X0());
        m.a(W0(), X0());
        e.a.d(W0(), X0());
    }

    @Override // kotlin.reflect.y.internal.j0.l.n
    public boolean A0() {
        return (W0().O0().w() instanceof e1) && m.a(W0().O0(), X0().O0());
    }

    @Override // kotlin.reflect.y.internal.j0.l.n
    public e0 K(e0 e0Var) {
        q1 q1VarD;
        m.f(e0Var, "replacement");
        q1 q1VarR0 = e0Var.R0();
        if (q1VarR0 instanceof y) {
            q1VarD = q1VarR0;
        } else {
            if (!(q1VarR0 instanceof m0)) {
                throw new NoWhenBranchMatchedException();
            }
            m0 m0Var = (m0) q1VarR0;
            q1VarD = f0.d(m0Var, m0Var.S0(true));
        }
        return p1.b(q1VarD, q1VarR0);
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    public q1 S0(boolean z) {
        return f0.d(W0().S0(z), X0().S0(z));
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    public q1 U0(a1 a1Var) {
        m.f(a1Var, "newAttributes");
        return f0.d(W0().U0(a1Var), X0().U0(a1Var));
    }

    @Override // kotlin.reflect.y.internal.j0.l.y
    public m0 V0() {
        a1();
        return W0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.y
    public String Y0(c cVar, f fVar) {
        m.f(cVar, "renderer");
        m.f(fVar, "options");
        if (!fVar.n()) {
            return cVar.t(cVar.w(W0()), cVar.w(X0()), kotlin.reflect.y.internal.j0.l.x1.a.h(this));
        }
        return '(' + cVar.w(W0()) + ".." + cVar.w(X0()) + ')';
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public y Y0(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        e0 e0VarA = gVar.a(W0());
        m.d(e0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        e0 e0VarA2 = gVar.a(X0());
        m.d(e0VarA2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new z((m0) e0VarA, (m0) e0VarA2);
    }

    @Override // kotlin.reflect.y.internal.j0.l.y
    public String toString() {
        return '(' + W0() + ".." + X0() + ')';
    }
}
