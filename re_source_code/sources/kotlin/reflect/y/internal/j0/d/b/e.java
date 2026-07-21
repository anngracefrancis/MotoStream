package kotlin.reflect.y.internal.j0.d.b;

import com.google.android.gms.ads.AdRequest;
import kotlin.collections.u;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.j0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.i;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.x;
import kotlin.reflect.y.internal.j0.b.q.h;
import kotlin.reflect.y.internal.j0.d.a.l0.j;
import kotlin.reflect.y.internal.j0.d.a.m0.b;
import kotlin.reflect.y.internal.j0.d.a.o;
import kotlin.reflect.y.internal.j0.i.u.c;
import kotlin.reflect.y.internal.j0.j.b.k;
import kotlin.reflect.y.internal.j0.j.b.l;
import kotlin.reflect.y.internal.j0.j.b.r;
import kotlin.reflect.y.internal.j0.j.b.v;
import kotlin.reflect.y.internal.j0.k.f;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: DeserializationComponentsForJava.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f23785b;

    /* JADX INFO: compiled from: DeserializationComponentsForJava.kt */
    public static final class a {

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.d.b.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DeserializationComponentsForJava.kt */
        public static final class C0350a {
            private final e a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final g f23786b;

            public C0350a(e eVar, g gVar) {
                m.f(eVar, "deserializationComponentsForJava");
                m.f(gVar, "deserializedDescriptorResolver");
                this.a = eVar;
                this.f23786b = gVar;
            }

            public final e a() {
                return this.a;
            }

            public final g b() {
                return this.f23786b;
            }
        }

        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final C0350a a(o oVar, o oVar2, o oVar3, String str, r rVar, b bVar) {
            m.f(oVar, "kotlinClassFinder");
            m.f(oVar2, "jvmBuiltInsKotlinClassFinder");
            m.f(oVar3, "javaClassFinder");
            m.f(str, "moduleName");
            m.f(rVar, "errorReporter");
            m.f(bVar, "javaSourceElementFactory");
            f fVar = new f("DeserializationComponentsForJava.ModuleData");
            kotlin.reflect.y.internal.j0.b.q.f fVar2 = new kotlin.reflect.y.internal.j0.b.q.f(fVar, kotlin.f0.y.e.j0.b.q.f.a.FROM_DEPENDENCIES);
            kotlin.reflect.y.internal.j0.f.f fVarD = kotlin.reflect.y.internal.j0.f.f.D('<' + str + '>');
            m.e(fVarD, "special(\"<$moduleName>\")");
            x xVar = new x(fVarD, fVar, fVar2, null, null, null, 56, null);
            fVar2.D0(xVar);
            fVar2.I0(xVar, true);
            g gVar = new g();
            j jVar = new j();
            j0 j0Var = new j0(fVar, xVar);
            kotlin.reflect.y.internal.j0.d.a.l0.f fVarB = f.b(oVar3, xVar, fVar, j0Var, oVar, gVar, rVar, bVar, jVar, (AdRequest.MAX_CONTENT_URL_LENGTH & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? w.a.a : null);
            e eVarA = f.a(xVar, fVar, j0Var, fVarB, oVar, gVar, rVar);
            gVar.l(eVarA);
            kotlin.reflect.y.internal.j0.d.a.j0.g gVar2 = kotlin.reflect.y.internal.j0.d.a.j0.g.a;
            m.e(gVar2, "EMPTY");
            c cVar = new c(fVarB, gVar2);
            jVar.c(cVar);
            h hVar = new h(fVar, oVar2, xVar, j0Var, fVar2.H0(), fVar2.H0(), l.a.a, kotlin.reflect.y.internal.j0.l.t1.l.f24802b.a(), new kotlin.reflect.y.internal.j0.i.v.b(fVar, u.j()));
            xVar.Z0(xVar);
            xVar.T0(new i(u.m(cVar.a(), hVar), "CompositeProvider@RuntimeModuleData for " + xVar));
            return new C0350a(eVarA, gVar);
        }
    }

    public e(n nVar, g0 g0Var, l lVar, h hVar, c cVar, kotlin.reflect.y.internal.j0.d.a.l0.f fVar, j0 j0Var, r rVar, kotlin.reflect.y.internal.j0.c.b.c cVar2, kotlin.reflect.y.internal.j0.j.b.j jVar, kotlin.reflect.y.internal.j0.l.t1.l lVar2, kotlin.reflect.y.internal.j0.l.v1.a aVar) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.o1.c cVarH0;
        kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a aVarH0;
        m.f(nVar, "storageManager");
        m.f(g0Var, "moduleDescriptor");
        m.f(lVar, "configuration");
        m.f(hVar, "classDataFinder");
        m.f(cVar, "annotationAndConstantLoader");
        m.f(fVar, "packageFragmentProvider");
        m.f(j0Var, "notFoundClasses");
        m.f(rVar, "errorReporter");
        m.f(cVar2, "lookupTracker");
        m.f(jVar, "contractDeserializer");
        m.f(lVar2, "kotlinTypeChecker");
        m.f(aVar, "typeAttributeTranslators");
        kotlin.reflect.y.internal.j0.b.h hVarO = g0Var.o();
        kotlin.reflect.y.internal.j0.b.q.f fVar2 = hVarO instanceof kotlin.reflect.y.internal.j0.b.q.f ? (kotlin.reflect.y.internal.j0.b.q.f) hVarO : null;
        this.f23785b = new k(nVar, g0Var, lVar, hVar, cVar, fVar, v.a.a, rVar, cVar2, i.a, u.j(), j0Var, jVar, (fVar2 == null || (aVarH0 = fVar2.H0()) == null) ? kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a.C0408a.a : aVarH0, (fVar2 == null || (cVarH0 = fVar2.H0()) == null) ? kotlin.reflect.jvm.internal.impl.descriptors.o1.c.b.a : cVarH0, kotlin.reflect.y.internal.j0.e.a0.b.i.a.a(), lVar2, new kotlin.reflect.y.internal.j0.i.v.b(nVar, u.j()), null, aVar.a(), 262144, null);
    }

    public final k a() {
        return this.f23785b;
    }
}
