package kotlin.p002reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.collections.s;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.y.internal.j0.c.b.d;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.n;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.sequences.l;

/* JADX INFO: compiled from: findClassInModule.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: compiled from: findClassInModule.kt */
    /* synthetic */ class a extends i implements Function1<kotlin.reflect.y.internal.j0.f.b, kotlin.reflect.y.internal.j0.f.b> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f25375h = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public final String getM() {
            return "getOuterClassId";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(kotlin.reflect.y.internal.j0.f.b.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.y.internal.j0.f.b invoke(kotlin.reflect.y.internal.j0.f.b bVar) {
            m.f(bVar, "p0");
            return bVar.g();
        }
    }

    /* JADX INFO: compiled from: findClassInModule.kt */
    static final class b extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.b, Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f25376f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(kotlin.reflect.y.internal.j0.f.b bVar) {
            m.f(bVar, "it");
            return 0;
        }
    }

    public static final e a(g0 g0Var, kotlin.reflect.y.internal.j0.f.b bVar) {
        m.f(g0Var, "<this>");
        m.f(bVar, "classId");
        h hVarB = b(g0Var, bVar);
        if (hVarB instanceof e) {
            return (e) hVarB;
        }
        return null;
    }

    public static final h b(g0 g0Var, kotlin.reflect.y.internal.j0.f.b bVar) {
        h hVarF;
        m.f(g0Var, "<this>");
        m.f(bVar, "classId");
        g0 g0VarA = n.a(g0Var);
        if (g0VarA == null) {
            c cVarH = bVar.h();
            m.e(cVarH, "classId.packageFqName");
            p0 p0VarN = g0Var.N(cVarH);
            List<f> listF = bVar.i().f();
            m.e(listF, "classId.relativeClassName.pathSegments()");
            h hVarQ = p0VarN.q();
            Object objU = s.U(listF);
            m.e(objU, "segments.first()");
            hVarF = hVarQ.f((f) objU, d.FROM_DESERIALIZATION);
            if (hVarF == null) {
                return null;
            }
            for (f fVar : listF.subList(1, listF.size())) {
                if (!(hVarF instanceof e)) {
                    return null;
                }
                h hVarY0 = ((e) hVarF).y0();
                m.e(fVar, "name");
                h hVarF2 = hVarY0.f(fVar, d.FROM_DESERIALIZATION);
                hVarF = hVarF2 instanceof e ? (e) hVarF2 : null;
                if (hVarF == null) {
                    return null;
                }
            }
        } else {
            c cVarH2 = bVar.h();
            m.e(cVarH2, "classId.packageFqName");
            p0 p0VarN2 = g0VarA.N(cVarH2);
            List<f> listF2 = bVar.i().f();
            m.e(listF2, "classId.relativeClassName.pathSegments()");
            h hVarQ2 = p0VarN2.q();
            Object objU2 = s.U(listF2);
            m.e(objU2, "segments.first()");
            h hVarF3 = hVarQ2.f((f) objU2, d.FROM_DESERIALIZATION);
            if (hVarF3 == null) {
                hVarF3 = null;
                break;
            }
            for (f fVar2 : listF2.subList(1, listF2.size())) {
                if (hVarF3 instanceof e) {
                    h hVarY1 = ((e) hVarF3).y0();
                    m.e(fVar2, "name");
                    h hVarF4 = hVarY1.f(fVar2, d.FROM_DESERIALIZATION);
                    hVarF3 = hVarF4 instanceof e ? (e) hVarF4 : null;
                    if (hVarF3 != null) {
                    }
                }
                hVarF3 = null;
            }
            if (hVarF3 != null) {
                return hVarF3;
            }
            c cVarH3 = bVar.h();
            m.e(cVarH3, "classId.packageFqName");
            p0 p0VarN3 = g0Var.N(cVarH3);
            List<f> listF3 = bVar.i().f();
            m.e(listF3, "classId.relativeClassName.pathSegments()");
            h hVarQ3 = p0VarN3.q();
            Object objU3 = s.U(listF3);
            m.e(objU3, "segments.first()");
            hVarF = hVarQ3.f((f) objU3, d.FROM_DESERIALIZATION);
            if (hVarF == null) {
                return null;
            }
            for (f fVar3 : listF3.subList(1, listF3.size())) {
                if (!(hVarF instanceof e)) {
                    return null;
                }
                h hVarY2 = ((e) hVarF).y0();
                m.e(fVar3, "name");
                h hVarF5 = hVarY2.f(fVar3, d.FROM_DESERIALIZATION);
                hVarF = hVarF5 instanceof e ? (e) hVarF5 : null;
                if (hVarF == null) {
                    return null;
                }
            }
        }
        return hVarF;
    }

    public static final e c(g0 g0Var, kotlin.reflect.y.internal.j0.f.b bVar, j0 j0Var) {
        m.f(g0Var, "<this>");
        m.f(bVar, "classId");
        m.f(j0Var, "notFoundClasses");
        e eVarA = a(g0Var, bVar);
        return eVarA != null ? eVarA : j0Var.d(bVar, kotlin.sequences.n.A(kotlin.sequences.n.u(l.f(bVar, a.f25375h), b.f25376f)));
    }

    public static final d1 d(g0 g0Var, kotlin.reflect.y.internal.j0.f.b bVar) {
        m.f(g0Var, "<this>");
        m.f(bVar, "classId");
        h hVarB = b(g0Var, bVar);
        if (hVarB instanceof d1) {
            return (d1) hVarB;
        }
        return null;
    }
}
