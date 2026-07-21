package kotlin.reflect.y.internal.j0.d.a;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.y.internal.j0.d.a.k0.e;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i0 {
    public static final boolean a(b bVar) {
        m.f(bVar, "memberDescriptor");
        return (bVar instanceof y) && m.a(bVar.i0(e.K), Boolean.TRUE);
    }

    public static final boolean b(w wVar) {
        m.f(wVar, "javaTypeEnhancementState");
        return wVar.c().invoke(u.e()) == f0.STRICT;
    }

    public static final u c(m1 m1Var) {
        m.f(m1Var, "<this>");
        u uVarG = r.g(m1Var);
        m.e(uVarG, "toDescriptorVisibility(this)");
        return uVarG;
    }
}
