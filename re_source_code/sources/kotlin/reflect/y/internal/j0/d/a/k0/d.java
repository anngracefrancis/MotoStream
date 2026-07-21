package kotlin.reflect.y.internal.j0.d.a.k0;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;

/* JADX INFO: compiled from: JavaForKotlinOverridePropertyDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends f {
    private final y0 K;
    private final y0 L;
    private final t0 M;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, y0 y0Var, y0 y0Var2, t0 t0Var) {
        super(eVar, g.f25179c.b(), y0Var.j(), y0Var.getVisibility(), y0Var2 != null, t0Var.getName(), y0Var.t(), null, b.a.DECLARATION, false, null);
        m.f(eVar, "ownerDescriptor");
        m.f(y0Var, "getterMethod");
        m.f(t0Var, "overriddenProperty");
        this.K = y0Var;
        this.L = y0Var2;
        this.M = t0Var;
    }
}
