package kotlin.p002reflect.jvm.internal.impl.descriptors.o1;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: PlatformDependentTypeTransformer.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface e {

    /* JADX INFO: compiled from: PlatformDependentTypeTransformer.kt */
    public static final class a implements e {
        public static final a a = new a();

        private a() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o1.e
        public m0 a(b bVar, m0 m0Var) {
            m.f(bVar, "classId");
            m.f(m0Var, "computedType");
            return m0Var;
        }
    }

    m0 a(b bVar, m0 m0Var);
}
