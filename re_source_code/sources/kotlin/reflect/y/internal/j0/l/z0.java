package kotlin.reflect.y.internal.j0.l;

import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;

/* JADX INFO: compiled from: TypeAttributeTranslator.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface z0 {

    /* JADX INFO: compiled from: TypeAttributeTranslator.kt */
    public static final class a {
        public static /* synthetic */ a1 a(z0 z0Var, g gVar, e1 e1Var, m mVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toAttributes");
            }
            if ((i2 & 2) != 0) {
                e1Var = null;
            }
            if ((i2 & 4) != 0) {
                mVar = null;
            }
            return z0Var.a(gVar, e1Var, mVar);
        }
    }

    a1 a(g gVar, e1 e1Var, m mVar);
}
