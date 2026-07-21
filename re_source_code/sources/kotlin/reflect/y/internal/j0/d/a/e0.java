package kotlin.reflect.y.internal.j0.d.a;

import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.m.u.a;
import kotlin.text.v;

/* JADX INFO: compiled from: propertiesConventionUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e0 {
    public static final List<f> a(f fVar) {
        m.f(fVar, "name");
        String strK = fVar.k();
        m.e(strK, "name.asString()");
        if (z.c(strK)) {
            return u.n(b(fVar));
        }
        return z.d(strK) ? f(fVar) : g.a.b(fVar);
    }

    public static final f b(f fVar) {
        m.f(fVar, "methodName");
        f fVarE = e(fVar, "get", false, null, 12, null);
        return fVarE == null ? e(fVar, "is", false, null, 8, null) : fVarE;
    }

    public static final f c(f fVar, boolean z) {
        m.f(fVar, "methodName");
        return e(fVar, "set", false, z ? "is" : null, 4, null);
    }

    private static final f d(f fVar, String str, boolean z, String str2) {
        if (fVar.y()) {
            return null;
        }
        String strU = fVar.u();
        m.e(strU, "methodName.identifier");
        boolean z2 = false;
        if (!kotlin.text.u.E(strU, str, false, 2, null) || strU.length() == str.length()) {
            return null;
        }
        char cCharAt = strU.charAt(str.length());
        if ('a' <= cCharAt && cCharAt < '{') {
            z2 = true;
        }
        if (z2) {
            return null;
        }
        if (str2 != null) {
            return f.x(str2 + v.m0(strU, str));
        }
        if (!z) {
            return fVar;
        }
        String strC = a.c(v.m0(strU, str), true);
        if (f.A(strC)) {
            return f.x(strC);
        }
        return null;
    }

    static /* synthetic */ f e(f fVar, String str, boolean z, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        return d(fVar, str, z, str2);
    }

    public static final List<f> f(f fVar) {
        m.f(fVar, "methodName");
        return u.o(c(fVar, false), c(fVar, true));
    }
}
