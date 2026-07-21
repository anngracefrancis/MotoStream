package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a;

import java.util.Set;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.l;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.w;
import kotlin.reflect.y.internal.j0.d.a.n0.g;
import kotlin.reflect.y.internal.j0.d.a.o;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.text.u;

/* JADX INFO: compiled from: ReflectJavaClassFinder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements o {
    private final ClassLoader a;

    public d(ClassLoader classLoader) {
        m.f(classLoader, "classLoader");
        this.a = classLoader;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o
    public g a(o.b bVar) {
        m.f(bVar, "request");
        b bVarA = bVar.a();
        c cVarH = bVarA.h();
        m.e(cVarH, "classId.packageFqName");
        String strB = bVarA.i().b();
        m.e(strB, "classId.relativeClassName.asString()");
        String strZ = u.z(strB, '.', '$', false, 4, null);
        if (!cVarH.d()) {
            strZ = cVarH.b() + '.' + strZ;
        }
        Class<?> clsA = e.a(this.a, strZ);
        if (clsA != null) {
            return new l(clsA);
        }
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o
    public Set<String> b(c cVar) {
        m.f(cVar, "packageFqName");
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o
    public kotlin.reflect.y.internal.j0.d.a.n0.u c(c cVar, boolean z) {
        m.f(cVar, "fqName");
        return new w(cVar);
    }
}
