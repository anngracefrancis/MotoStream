package kotlin.reflect.y.internal.j0.j.b.f0;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Pair;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.b.b;
import kotlin.reflect.y.internal.j0.j.b.q;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: BuiltInsPackageFragmentImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends q implements b {
    public static final a s = new a(null);
    private final boolean t;

    /* JADX INFO: compiled from: BuiltInsPackageFragmentImpl.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a(kotlin.reflect.y.internal.j0.f.c cVar, n nVar, g0 g0Var, InputStream inputStream, boolean z) throws IOException {
            m.f(cVar, "fqName");
            m.f(nVar, "storageManager");
            m.f(g0Var, "module");
            m.f(inputStream, "inputStream");
            Pair<kotlin.reflect.y.internal.j0.e.m, kotlin.reflect.y.internal.j0.e.y.a> pairA = kotlin.reflect.y.internal.j0.e.y.c.a(inputStream);
            kotlin.reflect.y.internal.j0.e.m mVarA = pairA.a();
            kotlin.reflect.y.internal.j0.e.y.a aVarB = pairA.b();
            if (mVarA != null) {
                return new c(cVar, nVar, g0Var, mVarA, aVarB, z, null);
            }
            throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + kotlin.reflect.y.internal.j0.e.y.a.f24165h + ", actual " + aVarB + ". Please update Kotlin");
        }
    }

    private c(kotlin.reflect.y.internal.j0.f.c cVar, n nVar, g0 g0Var, kotlin.reflect.y.internal.j0.e.m mVar, kotlin.reflect.y.internal.j0.e.y.a aVar, boolean z) {
        super(cVar, nVar, g0Var, mVar, aVar, null);
        this.t = z;
    }

    public /* synthetic */ c(kotlin.reflect.y.internal.j0.f.c cVar, n nVar, g0 g0Var, kotlin.reflect.y.internal.j0.e.m mVar, kotlin.reflect.y.internal.j0.e.y.a aVar, boolean z, g gVar) {
        this(cVar, nVar, g0Var, mVar, aVar, z);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.z, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.j
    public String toString() {
        return "builtins package fragment for " + d() + " from " + kotlin.reflect.y.internal.j0.i.t.a.l(this);
    }
}
