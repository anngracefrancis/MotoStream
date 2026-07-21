package kotlin.reflect.y.internal.j0.j.b;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.e.z.c;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: NameResolverUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x {
    public static final b a(c cVar, int i2) {
        m.f(cVar, "<this>");
        b bVarF = b.f(cVar.a(i2), cVar.b(i2));
        m.e(bVarF, "fromString(getQualifiedC… isLocalClassName(index))");
        return bVarF;
    }

    public static final f b(c cVar, int i2) {
        m.f(cVar, "<this>");
        f fVarV = f.v(cVar.getString(i2));
        m.e(fVarV, "guessByFirstCharacter(getString(index))");
        return fVarV;
    }
}
