package kotlin.p002reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.m;
import kotlin.u;

/* JADX INFO: compiled from: InvalidModuleException.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 {
    private static final f0<b0> a = new f0<>("InvalidModuleNotifier");

    public static final void a(g0 g0Var) {
        u uVar;
        m.f(g0Var, "<this>");
        b0 b0Var = (b0) g0Var.I0(a);
        if (b0Var != null) {
            b0Var.a(g0Var);
            uVar = u.a;
        } else {
            uVar = null;
        }
        if (uVar != null) {
            return;
        }
        throw new InvalidModuleException("Accessing invalid module descriptor " + g0Var);
    }
}
