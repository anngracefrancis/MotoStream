package kotlin.p002reflect.jvm.internal.impl.descriptors.o1;

import java.util.Collection;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: AdditionalClassPartsProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.descriptors.o1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdditionalClassPartsProvider.kt */
    public static final class C0408a implements a {
        public static final C0408a a = new C0408a();

        private C0408a() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a
        public Collection<d> a(e eVar) {
            m.f(eVar, "classDescriptor");
            return u.j();
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a
        public Collection<y0> b(f fVar, e eVar) {
            m.f(fVar, "name");
            m.f(eVar, "classDescriptor");
            return u.j();
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a
        public Collection<e0> d(e eVar) {
            m.f(eVar, "classDescriptor");
            return u.j();
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a
        public Collection<f> e(e eVar) {
            m.f(eVar, "classDescriptor");
            return u.j();
        }
    }

    Collection<d> a(e eVar);

    Collection<y0> b(f fVar, e eVar);

    Collection<e0> d(e eVar);

    Collection<f> e(e eVar);
}
