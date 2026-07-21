package kotlin.p002reflect.jvm.internal.impl.descriptors.n1;

import java.util.Map;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.r.g;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.u1.k;

/* JADX INFO: compiled from: AnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface c {

    /* JADX INFO: compiled from: AnnotationDescriptor.kt */
    public static final class a {
        public static kotlin.reflect.y.internal.j0.f.c a(c cVar) {
            e eVarE = kotlin.reflect.y.internal.j0.i.t.a.e(cVar);
            if (eVarE == null) {
                return null;
            }
            if (k.m(eVarE)) {
                eVarE = null;
            }
            if (eVarE != null) {
                return kotlin.reflect.y.internal.j0.i.t.a.d(eVarE);
            }
            return null;
        }
    }

    Map<f, g<?>> a();

    kotlin.reflect.y.internal.j0.f.c d();

    e0 getType();

    z0 t();
}
