package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a;

import java.io.InputStream;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.d.b.o;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.j.b.f0.a;
import kotlin.reflect.y.internal.j0.j.b.f0.d;

/* JADX INFO: compiled from: ReflectKotlinClassFinder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements o {
    private final ClassLoader a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f25318b;

    public g(ClassLoader classLoader) {
        m.f(classLoader, "classLoader");
        this.a = classLoader;
        this.f25318b = new d();
    }

    private final o.a d(String str) {
        f fVarA;
        Class<?> clsA = e.a(this.a, str);
        if (clsA == null || (fVarA = f.a.a(clsA)) == null) {
            return null;
        }
        return new o.a.b(fVarA, null, 2, null);
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.o
    public o.a a(kotlin.reflect.y.internal.j0.d.a.n0.g gVar) {
        String strB;
        m.f(gVar, "javaClass");
        c cVarD = gVar.d();
        if (cVarD == null || (strB = cVarD.b()) == null) {
            return null;
        }
        return d(strB);
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.u
    public InputStream b(c cVar) {
        m.f(cVar, "packageFqName");
        if (cVar.i(k.q)) {
            return this.f25318b.a(a.n.n(cVar));
        }
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.o
    public o.a c(b bVar) {
        m.f(bVar, "classId");
        return d(h.b(bVar));
    }
}
