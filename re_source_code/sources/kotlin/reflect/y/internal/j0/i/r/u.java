package kotlin.reflect.y.internal.j0.i.r;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends o<Short> {
    public u(short s) {
        super(Short.valueOf(s));
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public m0 a(g0 g0Var) {
        m.f(g0Var, "module");
        m0 m0VarT = g0Var.o().T();
        m.e(m0VarT, "module.builtIns.shortType");
        return m0VarT;
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    public String toString() {
        return b().intValue() + ".toShort()";
    }
}
