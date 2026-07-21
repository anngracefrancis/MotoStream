package kotlin.reflect.y.internal.j0.i.r;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends g<String> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(String str) {
        super(str);
        m.f(str, "value");
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public m0 a(g0 g0Var) {
        m.f(g0Var, "module");
        m0 m0VarW = g0Var.o().W();
        m.e(m0VarW, "module.builtIns.stringType");
        return m0VarW;
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    public String toString() {
        return '\"' + b() + '\"';
    }
}
