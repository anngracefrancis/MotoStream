package kotlin.reflect.y.internal.j0.h;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: RenderingUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static final String a(d dVar) {
        m.f(dVar, "<this>");
        List<f> listH = dVar.h();
        m.e(listH, "pathSegments()");
        return c(listH);
    }

    public static final String b(f fVar) {
        m.f(fVar, "<this>");
        if (!d(fVar)) {
            String strK = fVar.k();
            m.e(strK, "asString()");
            return strK;
        }
        StringBuilder sb = new StringBuilder();
        String strK2 = fVar.k();
        m.e(strK2, "asString()");
        sb.append('`' + strK2);
        sb.append('`');
        return sb.toString();
    }

    public static final String c(List<f> list) {
        m.f(list, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (f fVar : list) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(b(fVar));
        }
        String string = sb.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:22:? A[RETURN, SYNTHETIC] */
    private static final boolean d(f fVar) {
        boolean z;
        String strK = fVar.k();
        m.e(strK, "asString()");
        if (!i.a.contains(strK)) {
            for (int i2 = 0; i2 < strK.length(); i2++) {
                char cCharAt = strK.charAt(i2);
                if ((Character.isLetterOrDigit(cCharAt) || cCharAt == '_') ? false : true) {
                    z = true;
                    if (z) {
                        return false;
                    }
                }
            }
            z = false;
            if (z) {
                return false;
            }
        }
        return true;
    }
}
