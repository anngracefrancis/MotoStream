package kotlin.reflect.y.internal.j0.m;

import java.util.Collection;
import java.util.List;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.y.internal.j0.i.t.a;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
final class m implements f {
    public static final m a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f24908b = "should not have varargs or parameters with default values";

    private m() {
    }

    @Override // kotlin.reflect.y.internal.j0.m.f
    public String a(y yVar) {
        return f.a.a(this, yVar);
    }

    @Override // kotlin.reflect.y.internal.j0.m.f
    public boolean b(y yVar) {
        kotlin.jvm.internal.m.f(yVar, "functionDescriptor");
        List<i1> listF = yVar.f();
        kotlin.jvm.internal.m.e(listF, "functionDescriptor.valueParameters");
        if (!(listF instanceof Collection) || !listF.isEmpty()) {
            for (i1 i1Var : listF) {
                kotlin.jvm.internal.m.e(i1Var, "it");
                if (!(!a.a(i1Var) && i1Var.l0() == null)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // kotlin.reflect.y.internal.j0.m.f
    public String getDescription() {
        return f24908b;
    }
}
