package kotlin.reflect.y.internal.j0.l.u1;

import java.util.List;
import kotlin.collections.u;
import kotlin.collections.v0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.j1;
import kotlin.reflect.y.internal.j0.l.l1;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ErrorClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends h {
    /* JADX WARN: Illegal instructions before constructor call */
    public a(f fVar) {
        m.f(fVar, "name");
        k kVar = k.a;
        g0 g0VarI = kVar.i();
        d0 d0Var = d0.OPEN;
        kotlin.p002reflect.jvm.internal.impl.descriptors.f fVar2 = kotlin.p002reflect.jvm.internal.impl.descriptors.f.CLASS;
        List listJ = u.j();
        z0 z0Var = z0.a;
        super(g0VarI, fVar, d0Var, fVar2, listJ, z0Var, false, kotlin.reflect.y.internal.j0.k.f.f24650b);
        kotlin.p002reflect.jvm.internal.impl.descriptors.p1.f fVarO1 = kotlin.p002reflect.jvm.internal.impl.descriptors.p1.f.o1(this, g.f25179c.b(), true, z0Var);
        fVarO1.r1(u.j(), t.f25367d);
        m.e(fVarO1, "create(this, Annotations…          )\n            }");
        g gVar = g.SCOPE_FOR_ERROR_CLASS;
        String string = fVarO1.getName().toString();
        m.e(string, "errorConstructor.name.toString()");
        kotlin.reflect.y.internal.j0.i.w.h hVarB = k.b(gVar, string, HttpUrl.FRAGMENT_ENCODE_SET);
        j jVar = j.w0;
        fVarO1.h1(new h(kVar.e(jVar, new String[0]), hVarB, jVar, null, false, new String[0], 24, null));
        L0(hVarB, v0.c(fVarO1), fVarO1);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.a, kotlin.p002reflect.jvm.internal.impl.descriptors.b1
    /* JADX INFO: renamed from: A0 */
    public e c(l1 l1Var) {
        m.f(l1Var, "substitutor");
        return this;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.h
    public String toString() {
        String strK = getName().k();
        m.e(strK, "name.asString()");
        return strK;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.a, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.t
    public kotlin.reflect.y.internal.j0.i.w.h v(j1 j1Var, kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        m.f(j1Var, "typeSubstitution");
        m.f(gVar, "kotlinTypeRefiner");
        g gVar2 = g.SCOPE_FOR_ERROR_CLASS;
        String string = getName().toString();
        m.e(string, "name.toString()");
        return k.b(gVar2, string, j1Var.toString());
    }
}
