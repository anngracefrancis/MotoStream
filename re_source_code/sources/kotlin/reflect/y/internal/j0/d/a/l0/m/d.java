package kotlin.reflect.y.internal.j0.d.a.l0.m;

import kotlin.collections.v0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.y.internal.j0.d.a.j0.k;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.i1;
import kotlin.reflect.y.internal.j0.l.s0;
import kotlin.reflect.y.internal.j0.l.t0;

/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static final c a = new c("java.lang.Class");

    public static final g1 b(e1 e1Var, a aVar) {
        m.f(e1Var, "typeParameter");
        m.f(aVar, "attr");
        return aVar.e() == k.SUPERTYPE ? new i1(t0.b(e1Var)) : new s0(e1Var);
    }

    public static final a c(k kVar, boolean z, e1 e1Var) {
        m.f(kVar, "<this>");
        return new a(kVar, null, z, e1Var != null ? v0.c(e1Var) : null, null, 18, null);
    }

    public static /* synthetic */ a d(k kVar, boolean z, e1 e1Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            e1Var = null;
        }
        return c(kVar, z, e1Var);
    }
}
