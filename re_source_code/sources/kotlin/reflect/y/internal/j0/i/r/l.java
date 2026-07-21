package kotlin.reflect.y.internal.j0.i.r;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends g<Float> {
    public l(float f2) {
        super(Float.valueOf(f2));
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public m0 a(g0 g0Var) {
        m.f(g0Var, "module");
        m0 m0VarB = g0Var.o().B();
        m.e(m0VarB, "module.builtIns.floatType");
        return m0VarB;
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    public String toString() {
        return b().floatValue() + ".toFloat()";
    }
}
