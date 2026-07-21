package kotlin.reflect.y.internal.j0.b.q;

import java.io.InputStream;
import kotlin.collections.u;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.j0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o1.c;
import kotlin.reflect.y.internal.j0.d.b.o;
import kotlin.reflect.y.internal.j0.j.b.d;
import kotlin.reflect.y.internal.j0.j.b.j;
import kotlin.reflect.y.internal.j0.j.b.k;
import kotlin.reflect.y.internal.j0.j.b.l;
import kotlin.reflect.y.internal.j0.j.b.p;
import kotlin.reflect.y.internal.j0.j.b.r;
import kotlin.reflect.y.internal.j0.j.b.s;
import kotlin.reflect.y.internal.j0.j.b.v;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: JvmBuiltInsPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends kotlin.reflect.y.internal.j0.j.b.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f23300f = new a(null);

    /* JADX INFO: compiled from: JvmBuiltInsPackageFragmentProvider.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(n nVar, o oVar, g0 g0Var, j0 j0Var, kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a aVar, c cVar, l lVar, kotlin.reflect.y.internal.j0.l.t1.l lVar2, kotlin.reflect.y.internal.j0.i.v.a aVar2) {
        super(nVar, oVar, g0Var);
        m.f(nVar, "storageManager");
        m.f(oVar, "finder");
        m.f(g0Var, "moduleDescriptor");
        m.f(j0Var, "notFoundClasses");
        m.f(aVar, "additionalClassPartsProvider");
        m.f(cVar, "platformDependentDeclarationFilter");
        m.f(lVar, "deserializationConfiguration");
        m.f(lVar2, "kotlinTypeChecker");
        m.f(aVar2, "samConversionResolver");
        kotlin.reflect.y.internal.j0.j.b.o oVar2 = new kotlin.reflect.y.internal.j0.j.b.o(this);
        kotlin.reflect.y.internal.j0.j.b.f0.a aVar3 = kotlin.reflect.y.internal.j0.j.b.f0.a.n;
        d dVar = new d(g0Var, j0Var, aVar3);
        v.a aVar4 = v.a.a;
        r rVar = r.a;
        m.e(rVar, "DO_NOTHING");
        i(new k(nVar, g0Var, lVar, oVar2, dVar, this, aVar4, rVar, kotlin.f0.y.e.j0.c.b.c.a.a, s.a.a, u.m(new kotlin.reflect.y.internal.j0.b.p.a(nVar, g0Var), new e(nVar, g0Var, null, 4, null)), j0Var, j.a.a(), aVar, cVar, aVar3.e(), lVar2, aVar2, null, null, 786432, null));
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.a
    protected p d(kotlin.reflect.y.internal.j0.f.c cVar) {
        m.f(cVar, "fqName");
        InputStream inputStreamB = f().b(cVar);
        if (inputStreamB != null) {
            return kotlin.reflect.y.internal.j0.j.b.f0.c.s.a(cVar, h(), g(), inputStreamB, false);
        }
        return null;
    }
}
