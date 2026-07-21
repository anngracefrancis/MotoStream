package kotlin.reflect.y.internal.j0.i;

import java.util.Collection;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t;

/* JADX INFO: compiled from: VisibilityUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p {
    public static final b a(Collection<? extends b> collection) {
        Integer numD;
        m.f(collection, "descriptors");
        collection.isEmpty();
        b bVar = null;
        for (b bVar2 : collection) {
            if (bVar == null || ((numD = t.d(bVar.getVisibility(), bVar2.getVisibility())) != null && numD.intValue() < 0)) {
                bVar = bVar2;
            }
        }
        m.c(bVar);
        return bVar;
    }
}
