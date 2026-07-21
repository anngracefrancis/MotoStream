package kotlin.reflect.y.internal.j0.i;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.a;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.j1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: inlineClassesUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private static final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f24325b;

    static {
        c cVar = new c("kotlin.jvm.JvmInline");
        a = cVar;
        b bVarM = b.m(cVar);
        m.e(bVarM, "topLevel(JVM_INLINE_ANNOTATION_FQ_NAME)");
        f24325b = bVarM;
    }

    public static final boolean a(a aVar) {
        m.f(aVar, "<this>");
        if (aVar instanceof u0) {
            t0 t0VarB0 = ((u0) aVar).B0();
            m.e(t0VarB0, "correspondingProperty");
            if (d(t0VarB0)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        return (mVar instanceof e) && (((e) mVar).z0() instanceof z);
    }

    public static final boolean c(e0 e0Var) {
        m.f(e0Var, "<this>");
        h hVarW = e0Var.O0().w();
        if (hVarW != null) {
            return b(hVarW);
        }
        return false;
    }

    public static final boolean d(j1 j1Var) {
        z<m0> zVarJ;
        m.f(j1Var, "<this>");
        if (j1Var.m0() == null) {
            kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = j1Var.b();
            kotlin.reflect.y.internal.j0.f.f fVarC = null;
            e eVar = mVarB instanceof e ? (e) mVarB : null;
            if (eVar != null && (zVarJ = kotlin.reflect.y.internal.j0.i.t.a.j(eVar)) != null) {
                fVarC = zVarJ.c();
            }
            if (m.a(fVarC, j1Var.getName())) {
                return true;
            }
        }
        return false;
    }

    public static final e0 e(e0 e0Var) {
        z<m0> zVarJ;
        m.f(e0Var, "<this>");
        h hVarW = e0Var.O0().w();
        if (!(hVarW instanceof e)) {
            hVarW = null;
        }
        e eVar = (e) hVarW;
        if (eVar == null || (zVarJ = kotlin.reflect.y.internal.j0.i.t.a.j(eVar)) == null) {
            return null;
        }
        return (m0) zVarJ.d();
    }
}
