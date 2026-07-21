package kotlin.reflect.y.internal.j0.j.b.f0;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.protobuf.f;
import kotlin.p002reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.y.internal.j0.e.c;
import kotlin.reflect.y.internal.j0.e.d;
import kotlin.reflect.y.internal.j0.e.g;
import kotlin.reflect.y.internal.j0.e.i;
import kotlin.reflect.y.internal.j0.e.l;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.s;
import kotlin.reflect.y.internal.j0.e.u;
import kotlin.reflect.y.internal.j0.e.y.b;

/* JADX INFO: compiled from: BuiltInSerializerProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends kotlin.reflect.y.internal.j0.j.a {
    public static final a n = new a();

    /* JADX WARN: Illegal instructions before constructor call */
    private a() {
        f fVarD = f.d();
        b.a(fVarD);
        m.e(fVarD, "newInstance().apply(Buil…f::registerAllExtensions)");
        h.f<l, Integer> fVar = b.a;
        m.e(fVar, "packageFqName");
        h.f<d, List<kotlin.reflect.y.internal.j0.e.b>> fVar2 = b.f24168c;
        m.e(fVar2, "constructorAnnotation");
        h.f<c, List<kotlin.reflect.y.internal.j0.e.b>> fVar3 = b.f24167b;
        m.e(fVar3, "classAnnotation");
        h.f<i, List<kotlin.reflect.y.internal.j0.e.b>> fVar4 = b.f24169d;
        m.e(fVar4, "functionAnnotation");
        h.f<n, List<kotlin.reflect.y.internal.j0.e.b>> fVar5 = b.f24170e;
        m.e(fVar5, "propertyAnnotation");
        h.f<n, List<kotlin.reflect.y.internal.j0.e.b>> fVar6 = b.f24171f;
        m.e(fVar6, "propertyGetterAnnotation");
        h.f<n, List<kotlin.reflect.y.internal.j0.e.b>> fVar7 = b.f24172g;
        m.e(fVar7, "propertySetterAnnotation");
        h.f<g, List<kotlin.reflect.y.internal.j0.e.b>> fVar8 = b.f24174i;
        m.e(fVar8, "enumEntryAnnotation");
        h.f<n, kotlin.reflect.y.internal.j0.e.b.C0361b.c> fVar9 = b.f24173h;
        m.e(fVar9, "compileTimeValue");
        h.f<u, List<kotlin.reflect.y.internal.j0.e.b>> fVar10 = b.f24175j;
        m.e(fVar10, "parameterAnnotation");
        h.f<q, List<kotlin.reflect.y.internal.j0.e.b>> fVar11 = b.f24176k;
        m.e(fVar11, "typeAnnotation");
        h.f<s, List<kotlin.reflect.y.internal.j0.e.b>> fVar12 = b.l;
        m.e(fVar12, "typeParameterAnnotation");
        super(fVarD, fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11, fVar12);
    }

    private final String o(kotlin.reflect.y.internal.j0.f.c cVar) {
        if (cVar.d()) {
            return "default-package";
        }
        String strK = cVar.g().k();
        m.e(strK, "fqName.shortName().asString()");
        return strK;
    }

    public final String m(kotlin.reflect.y.internal.j0.f.c cVar) {
        m.f(cVar, "fqName");
        return o(cVar) + ".kotlin_builtins";
    }

    public final String n(kotlin.reflect.y.internal.j0.f.c cVar) {
        m.f(cVar, "fqName");
        StringBuilder sb = new StringBuilder();
        String strB = cVar.b();
        m.e(strB, "fqName.asString()");
        sb.append(kotlin.text.u.z(strB, '.', '/', false, 4, null));
        sb.append('/');
        sb.append(m(cVar));
        return sb.toString();
    }
}
