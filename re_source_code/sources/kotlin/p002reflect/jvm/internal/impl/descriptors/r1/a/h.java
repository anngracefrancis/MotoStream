package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.text.u;

/* JADX INFO: compiled from: ReflectKotlinClassFinder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(b bVar) {
        String strB = bVar.i().b();
        m.e(strB, "relativeClassName.asString()");
        String strZ = u.z(strB, '.', '$', false, 4, null);
        if (bVar.h().d()) {
            return strZ;
        }
        return bVar.h() + '.' + strZ;
    }
}
