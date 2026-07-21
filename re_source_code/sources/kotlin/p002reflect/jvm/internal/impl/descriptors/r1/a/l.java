package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.a1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.p;
import kotlin.reflect.y.internal.j0.d.a.m0.b;

/* JADX INFO: compiled from: RuntimeSourceElementFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements b {
    public static final l a = new l();

    /* JADX INFO: compiled from: RuntimeSourceElementFactory.kt */
    public static final class a implements kotlin.reflect.y.internal.j0.d.a.m0.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final p f25322b;

        public a(p pVar) {
            m.f(pVar, "javaElement");
            this.f25322b = pVar;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.z0
        public a1 a() {
            a1 a1Var = a1.a;
            m.e(a1Var, "NO_SOURCE_FILE");
            return a1Var;
        }

        @Override // kotlin.reflect.y.internal.j0.d.a.m0.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public p b() {
            return this.f25322b;
        }

        public String toString() {
            return a.class.getName() + ": " + b();
        }
    }

    private l() {
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.m0.b
    public kotlin.reflect.y.internal.j0.d.a.m0.a a(kotlin.reflect.y.internal.j0.d.a.n0.l lVar) {
        m.f(lVar, "javaElement");
        return new a((p) lVar);
    }
}
