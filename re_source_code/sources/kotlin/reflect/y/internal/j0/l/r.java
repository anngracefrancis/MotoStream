package kotlin.reflect.y.internal.j0.l;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r extends m0 {
    @Override // kotlin.reflect.y.internal.j0.l.e0
    public List<g1> M0() {
        return X0().M0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public a1 N0() {
        return X0().N0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public e1 O0() {
        return X0().O0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public boolean P0() {
        return X0().P0();
    }

    protected abstract m0 X0();

    @Override // kotlin.reflect.y.internal.j0.l.q1
    public m0 Y0(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        e0 e0VarA = gVar.a(X0());
        m.d(e0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return Z0((m0) e0VarA);
    }

    public abstract r Z0(m0 m0Var);

    @Override // kotlin.reflect.y.internal.j0.l.e0
    public h q() {
        return X0().q();
    }
}
