package kotlin.reflect.y.internal.j0.h;

import java.util.ArrayList;
import kotlin.collections.a0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.f.f;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ClassifierNamePolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: compiled from: ClassifierNamePolicy.kt */
    public static final class a implements b {
        public static final a a = new a();

        private a() {
        }

        @Override // kotlin.reflect.y.internal.j0.h.b
        public String a(h hVar, kotlin.reflect.y.internal.j0.h.c cVar) {
            m.f(hVar, "classifier");
            m.f(cVar, "renderer");
            if (hVar instanceof e1) {
                f name = ((e1) hVar).getName();
                m.e(name, "classifier.name");
                return cVar.v(name, false);
            }
            d dVarM = kotlin.reflect.y.internal.j0.i.d.m(hVar);
            m.e(dVarM, "getFqName(classifier)");
            return cVar.u(dVarM);
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.h.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClassifierNamePolicy.kt */
    public static final class C0372b implements b {
        public static final C0372b a = new C0372b();

        private C0372b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, kotlin.reflect.jvm.internal.impl.descriptors.h] */
        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.i0, kotlin.reflect.jvm.internal.impl.descriptors.m] */
        /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.m] */
        @Override // kotlin.reflect.y.internal.j0.h.b
        public String a(h hVar, kotlin.reflect.y.internal.j0.h.c cVar) {
            m.f(hVar, "classifier");
            m.f(cVar, "renderer");
            if (hVar instanceof e1) {
                f name = ((e1) hVar).getName();
                m.e(name, "classifier.name");
                return cVar.v(name, false);
            }
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(hVar.getName());
                hVar = hVar.b();
            } while (hVar instanceof e);
            return n.c(a0.F(arrayList));
        }
    }

    /* JADX INFO: compiled from: ClassifierNamePolicy.kt */
    public static final class c implements b {
        public static final c a = new c();

        private c() {
        }

        private final String b(h hVar) {
            f name = hVar.getName();
            m.e(name, "descriptor.name");
            String strB = n.b(name);
            if (hVar instanceof e1) {
                return strB;
            }
            kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = hVar.b();
            m.e(mVarB, "descriptor.containingDeclaration");
            String strC = c(mVarB);
            if (strC == null || m.a(strC, HttpUrl.FRAGMENT_ENCODE_SET)) {
                return strB;
            }
            return strC + '.' + strB;
        }

        private final String c(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
            if (mVar instanceof e) {
                return b((h) mVar);
            }
            if (!(mVar instanceof k0)) {
                return null;
            }
            d dVarJ = ((k0) mVar).d().j();
            m.e(dVarJ, "descriptor.fqName.toUnsafe()");
            return n.a(dVarJ);
        }

        @Override // kotlin.reflect.y.internal.j0.h.b
        public String a(h hVar, kotlin.reflect.y.internal.j0.h.c cVar) {
            m.f(hVar, "classifier");
            m.f(cVar, "renderer");
            return b(hVar);
        }
    }

    String a(h hVar, kotlin.reflect.y.internal.j0.h.c cVar);
}
