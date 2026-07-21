package kotlin.reflect.y.internal.j0.j.b.f0;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.j0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.l0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o1.c;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.j.b.d;
import kotlin.reflect.y.internal.j0.j.b.j;
import kotlin.reflect.y.internal.j0.j.b.l;
import kotlin.reflect.y.internal.j0.j.b.o;
import kotlin.reflect.y.internal.j0.j.b.r;
import kotlin.reflect.y.internal.j0.j.b.s;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: BuiltInsLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements kotlin.reflect.y.internal.j0.b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f24489b = new d();

    /* JADX INFO: compiled from: BuiltInsLoaderImpl.kt */
    /* synthetic */ class a extends i implements Function1<String, InputStream> {
        a(Object obj) {
            super(1, obj);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public final String getM() {
            return "loadResource";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(d.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final InputStream invoke(String str) {
            m.f(str, "p0");
            return ((d) this.receiver).a(str);
        }
    }

    @Override // kotlin.reflect.y.internal.j0.b.a
    public l0 a(n nVar, kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0Var, Iterable<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.o1.b> iterable, c cVar, kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a aVar, boolean z) {
        m.f(nVar, "storageManager");
        m.f(g0Var, "builtInsModule");
        m.f(iterable, "classDescriptorFactories");
        m.f(cVar, "platformDependentDeclarationFilter");
        m.f(aVar, "additionalClassPartsProvider");
        return b(nVar, g0Var, k.x, iterable, cVar, aVar, z, new a(this.f24489b));
    }

    public final l0 b(n nVar, kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0Var, Set<kotlin.reflect.y.internal.j0.f.c> set, Iterable<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.o1.b> iterable, c cVar, kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a aVar, boolean z, Function1<? super String, ? extends InputStream> function1) {
        m.f(nVar, "storageManager");
        m.f(g0Var, "module");
        m.f(set, "packageFqNames");
        m.f(iterable, "classDescriptorFactories");
        m.f(cVar, "platformDependentDeclarationFilter");
        m.f(aVar, "additionalClassPartsProvider");
        m.f(function1, "loadResource");
        ArrayList arrayList = new ArrayList(v.u(set, 10));
        for (kotlin.reflect.y.internal.j0.f.c cVar2 : set) {
            String strN = kotlin.reflect.y.internal.j0.j.b.f0.a.n.n(cVar2);
            InputStream inputStreamInvoke = function1.invoke(strN);
            if (inputStreamInvoke == null) {
                throw new IllegalStateException("Resource not found in classpath: " + strN);
            }
            arrayList.add(c.s.a(cVar2, nVar, g0Var, inputStreamInvoke, z));
        }
        m0 m0Var = new m0(arrayList);
        j0 j0Var = new j0(nVar, g0Var);
        l.a aVar2 = l.a.a;
        o oVar = new o(m0Var);
        kotlin.reflect.y.internal.j0.j.b.f0.a aVar3 = kotlin.reflect.y.internal.j0.j.b.f0.a.n;
        d dVar = new d(g0Var, j0Var, aVar3);
        kotlin.f0.y.e.j0.j.b.v.a aVar4 = kotlin.f0.y.e.j0.j.b.v.a.a;
        r rVar = r.a;
        m.e(rVar, "DO_NOTHING");
        kotlin.reflect.y.internal.j0.j.b.k kVar = new kotlin.reflect.y.internal.j0.j.b.k(nVar, g0Var, aVar2, oVar, dVar, m0Var, aVar4, rVar, kotlin.f0.y.e.j0.c.b.c.a.a, s.a.a, iterable, j0Var, j.a.a(), aVar, cVar, aVar3.e(), null, new kotlin.reflect.y.internal.j0.i.v.b(nVar, u.j()), null, null, 851968, null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).M0(kVar);
        }
        return m0Var;
    }
}
