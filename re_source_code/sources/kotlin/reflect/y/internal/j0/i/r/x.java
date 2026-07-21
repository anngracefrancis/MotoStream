package kotlin.reflect.y.internal.j0.i.r;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.u1.j;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x extends a0<Integer> {
    public x(int i2) {
        super(Integer.valueOf(i2));
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    public e0 a(g0 g0Var) {
        m.f(g0Var, "module");
        e eVarA = kotlin.p002reflect.jvm.internal.impl.descriptors.x.a(g0Var, k.a.A0);
        m0 m0VarS = eVarA != null ? eVarA.s() : null;
        return m0VarS == null ? kotlin.reflect.y.internal.j0.l.u1.k.d(j.A0, "UInt") : m0VarS;
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    public String toString() {
        return b().intValue() + ".toUInt()";
    }
}
