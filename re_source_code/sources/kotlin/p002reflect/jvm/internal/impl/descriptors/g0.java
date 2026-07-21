package kotlin.p002reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: ModuleDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface g0 extends m {

    /* JADX INFO: compiled from: ModuleDescriptor.kt */
    public static final class a {
        public static <R, D> R a(g0 g0Var, o<R, D> oVar, D d2) {
            m.f(oVar, "visitor");
            return oVar.j(g0Var, d2);
        }

        public static m b(g0 g0Var) {
            return null;
        }
    }

    <T> T I0(f0<T> f0Var);

    p0 N(c cVar);

    boolean e0(g0 g0Var);

    h o();

    Collection<c> p(c cVar, Function1<? super f, Boolean> function1);

    List<g0> t0();
}
