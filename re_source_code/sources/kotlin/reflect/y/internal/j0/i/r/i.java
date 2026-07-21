package kotlin.reflect.y.internal.j0.i.r;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends g<Double> {
    public i(double d2) {
        super(Double.valueOf(d2));
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public m0 a(g0 g0Var) {
        m.f(g0Var, "module");
        m0 m0VarZ = g0Var.o().z();
        m.e(m0VarZ, "module.builtIns.doubleType");
        return m0VarZ;
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    public String toString() {
        return b().doubleValue() + ".toDouble()";
    }
}
