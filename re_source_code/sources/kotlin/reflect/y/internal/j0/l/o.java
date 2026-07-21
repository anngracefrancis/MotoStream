package kotlin.reflect.y.internal.j0.l;

import kotlin.collections.t;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;

/* JADX INFO: compiled from: TypeAttributeTranslator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements z0 {
    public static final o a = new o();

    private o() {
    }

    @Override // kotlin.reflect.y.internal.j0.l.z0
    public a1 a(g gVar, e1 e1Var, m mVar) {
        kotlin.jvm.internal.m.f(gVar, "annotations");
        return gVar.isEmpty() ? a1.f24676g.h() : a1.f24676g.g(t.e(new j(gVar)));
    }
}
