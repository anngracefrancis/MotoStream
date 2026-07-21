package kotlin.reflect.y.internal.j0.d.b;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.a1;
import kotlin.p002reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.y.internal.j0.e.a0.a;
import kotlin.reflect.y.internal.j0.e.a0.b.e;
import kotlin.reflect.y.internal.j0.e.l;
import kotlin.reflect.y.internal.j0.e.z.c;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.i.u.d;
import kotlin.reflect.y.internal.j0.j.b.g0.f;
import kotlin.reflect.y.internal.j0.j.b.t;
import kotlin.text.v;

/* JADX INFO: compiled from: JvmPackagePartSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f23795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f23796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final t<e> f23797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f23798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.j.b.g0.e f23799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final q f23800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f23801h;

    public k(d dVar, d dVar2, l lVar, c cVar, t<e> tVar, boolean z, kotlin.reflect.y.internal.j0.j.b.g0.e eVar, q qVar) {
        String string;
        m.f(dVar, "className");
        m.f(lVar, "packageProto");
        m.f(cVar, "nameResolver");
        m.f(eVar, "abiStability");
        this.f23795b = dVar;
        this.f23796c = dVar2;
        this.f23797d = tVar;
        this.f23798e = z;
        this.f23799f = eVar;
        this.f23800g = qVar;
        h.f<l, Integer> fVar = a.m;
        m.e(fVar, "packageModuleName");
        Integer num = (Integer) kotlin.reflect.y.internal.j0.e.z.e.a(lVar, fVar);
        this.f23801h = (num == null || (string = cVar.getString(num.intValue())) == null) ? "main" : string;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.z0
    public a1 a() {
        a1 a1Var = a1.a;
        m.e(a1Var, "NO_SOURCE_FILE");
        return a1Var;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.f
    public String c() {
        return "Class '" + d().b().b() + '\'';
    }

    public final b d() {
        return new b(e().g(), h());
    }

    public d e() {
        return this.f23795b;
    }

    public d f() {
        return this.f23796c;
    }

    public final q g() {
        return this.f23800g;
    }

    public final kotlin.reflect.y.internal.j0.f.f h() {
        String strF = e().f();
        m.e(strF, "className.internalName");
        kotlin.reflect.y.internal.j0.f.f fVarX = kotlin.reflect.y.internal.j0.f.f.x(v.I0(strF, '/', null, 2, null));
        m.e(fVarX, "identifier(className.int….substringAfterLast('/'))");
        return fVarX;
    }

    public String toString() {
        return k.class.getSimpleName() + ": " + e();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public k(q qVar, l lVar, c cVar, t<e> tVar, boolean z, kotlin.reflect.y.internal.j0.j.b.g0.e eVar) {
        m.f(qVar, "kotlinClass");
        m.f(lVar, "packageProto");
        m.f(cVar, "nameResolver");
        m.f(eVar, "abiStability");
        d dVarB = d.b(qVar.e());
        m.e(dVarB, "byClassId(kotlinClass.classId)");
        String strE = qVar.a().e();
        d dVarD = null;
        if (strE != null) {
            if (strE.length() > 0) {
                dVarD = d.d(strE);
            }
        }
        this(dVarB, dVarD, lVar, cVar, tVar, z, eVar, qVar);
    }
}
