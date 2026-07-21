package kotlin.reflect.y.internal.j0.i.w;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.y.internal.j0.c.b.b;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: ResolutionScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface k {

    /* JADX INFO: compiled from: ResolutionScope.kt */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection a(k kVar, d dVar, Function1 function1, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
            }
            if ((i2 & 1) != 0) {
                dVar = d.m;
            }
            if ((i2 & 2) != 0) {
                function1 = h.a.a();
            }
            return kVar.g(dVar, function1);
        }
    }

    h f(f fVar, b bVar);

    Collection<m> g(d dVar, Function1<? super f, Boolean> function1);
}
