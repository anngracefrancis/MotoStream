package kotlin.reflect.y.internal.j0.d.b;

import java.util.Collection;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: descriptorBasedTypeSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface y<T> {

    /* JADX INFO: compiled from: descriptorBasedTypeSignatureMapping.kt */
    public static final class a {
        public static <T> String a(y<? extends T> yVar, e eVar) {
            m.f(eVar, "classDescriptor");
            return null;
        }

        public static <T> e0 b(y<? extends T> yVar, e0 e0Var) {
            m.f(e0Var, "kotlinType");
            return null;
        }
    }

    T a(e eVar);

    String b(e eVar);

    e0 c(Collection<e0> collection);

    String d(e eVar);

    e0 e(e0 e0Var);

    void f(e0 e0Var, e eVar);
}
