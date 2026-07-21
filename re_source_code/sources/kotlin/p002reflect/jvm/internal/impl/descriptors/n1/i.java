package kotlin.p002reflect.jvm.internal.impl.descriptors.n1;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static final g a(g gVar, g gVar2) {
        m.f(gVar, "first");
        m.f(gVar2, "second");
        if (gVar.isEmpty()) {
            return gVar2;
        }
        return gVar2.isEmpty() ? gVar : new k(gVar, gVar2);
    }
}
