package kotlin.p002reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.u;

/* JADX INFO: compiled from: SupertypeLoopChecker.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface c1 {

    /* JADX INFO: compiled from: SupertypeLoopChecker.kt */
    public static final class a implements c1 {
        public static final a a = new a();

        private a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c1
        public Collection<e0> a(e1 e1Var, Collection<? extends e0> collection, Function1<? super e1, ? extends Iterable<? extends e0>> function1, Function1<? super e0, u> function2) {
            m.f(e1Var, "currentTypeConstructor");
            m.f(collection, "superTypes");
            m.f(function1, "neighbors");
            m.f(function2, "reportLoop");
            return collection;
        }
    }

    Collection<e0> a(e1 e1Var, Collection<? extends e0> collection, Function1<? super e1, ? extends Iterable<? extends e0>> function1, Function1<? super e0, u> function2);
}
