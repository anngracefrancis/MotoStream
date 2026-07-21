package kotlin.reflect.y.internal.j0.l.t1;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.d1;

/* JADX INFO: compiled from: ClassicTypeCheckerState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final d1 a(boolean z, boolean z2, b bVar, f fVar, g gVar) {
        m.f(bVar, "typeSystemContext");
        m.f(fVar, "kotlinTypePreparator");
        m.f(gVar, "kotlinTypeRefiner");
        return new d1(z, z2, true, bVar, fVar, gVar);
    }

    public static /* synthetic */ d1 b(boolean z, boolean z2, b bVar, f fVar, g gVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        if ((i2 & 4) != 0) {
            bVar = q.a;
        }
        if ((i2 & 8) != 0) {
            fVar = f.a.a;
        }
        if ((i2 & 16) != 0) {
            gVar = g.a.a;
        }
        return a(z, z2, bVar, fVar, gVar);
    }
}
