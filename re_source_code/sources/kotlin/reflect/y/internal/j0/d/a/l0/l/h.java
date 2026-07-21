package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.q0;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.z;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.j0.d.a.l0.e;
import kotlin.reflect.y.internal.j0.d.a.l0.g;
import kotlin.reflect.y.internal.j0.d.a.n0.u;
import kotlin.reflect.y.internal.j0.d.b.p;
import kotlin.reflect.y.internal.j0.d.b.q;
import kotlin.reflect.y.internal.j0.d.b.r;
import kotlin.reflect.y.internal.j0.d.b.w;
import kotlin.reflect.y.internal.j0.i.u.d;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.s;

/* JADX INFO: compiled from: LazyJavaPackageFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends z {
    static final /* synthetic */ KProperty<Object>[] l = {g0.h(new y(g0.b(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), g0.h(new y(g0.b(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    private final u m;
    private final g n;
    private final i o;
    private final d p;
    private final i<List<kotlin.reflect.y.internal.j0.f.c>> q;
    private final kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g r;
    private final i s;

    /* JADX INFO: compiled from: LazyJavaPackageFragment.kt */
    static final class a extends Lambda implements Function0<Map<String, ? extends q>> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Map<String, q> invoke() {
            w wVarO = h.this.n.a().o();
            String strB = h.this.d().b();
            m.e(strB, "fqName.asString()");
            List<String> listA = wVarO.a(strB);
            h hVar = h.this;
            ArrayList arrayList = new ArrayList();
            for (String str : listA) {
                kotlin.reflect.y.internal.j0.f.b bVarM = kotlin.reflect.y.internal.j0.f.b.m(d.d(str).e());
                m.e(bVarM, "topLevel(JvmClassName.by…velClassMaybeWithDollars)");
                q qVarB = p.b(hVar.n.a().j(), bVarM);
                Pair pairA = qVarB != null ? s.a(str, qVarB) : null;
                if (pairA != null) {
                    arrayList.add(pairA);
                }
            }
            return q0.q(arrayList);
        }
    }

    /* JADX INFO: compiled from: LazyJavaPackageFragment.kt */
    static final class b extends Lambda implements Function0<HashMap<d, d>> {

        /* JADX INFO: compiled from: LazyJavaPackageFragment.kt */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a.values().length];
                iArr[kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a.MULTIFILE_CLASS_PART.ordinal()] = 1;
                iArr[kotlin.reflect.y.internal.j0.d.b.c0.a.EnumC0345a.FILE_FACADE.ordinal()] = 2;
                a = iArr;
            }
        }

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HashMap<d, d> invoke() {
            HashMap<d, d> map = new HashMap<>();
            for (Map.Entry<String, q> entry : h.this.N0().entrySet()) {
                String key = entry.getKey();
                q value = entry.getValue();
                d dVarD = d.d(key);
                m.e(dVarD, "byInternalName(partInternalName)");
                kotlin.reflect.y.internal.j0.d.b.c0.a aVarA = value.a();
                int i2 = a.a[aVarA.c().ordinal()];
                if (i2 == 1) {
                    String strE = aVarA.e();
                    if (strE != null) {
                        d dVarD2 = d.d(strE);
                        m.e(dVarD2, "byInternalName(header.mu…: continue@kotlinClasses)");
                        map.put(dVarD, dVarD2);
                    }
                } else if (i2 == 2) {
                    map.put(dVarD, dVarD);
                }
            }
            return map;
        }
    }

    /* JADX INFO: compiled from: LazyJavaPackageFragment.kt */
    static final class c extends Lambda implements Function0<List<? extends kotlin.reflect.y.internal.j0.f.c>> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends kotlin.reflect.y.internal.j0.f.c> invoke() {
            Collection<u> collectionA = h.this.m.A();
            ArrayList arrayList = new ArrayList(v.u(collectionA, 10));
            Iterator<T> it = collectionA.iterator();
            while (it.hasNext()) {
                arrayList.add(((u) it.next()).d());
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, u uVar) {
        super(gVar.d(), uVar.d());
        m.f(gVar, "outerContext");
        m.f(uVar, "jPackage");
        this.m = uVar;
        g gVarD = kotlin.reflect.y.internal.j0.d.a.l0.a.d(gVar, this, null, 0, 6, null);
        this.n = gVarD;
        this.o = gVarD.e().d(new a());
        this.p = new d(gVarD, uVar, this);
        this.q = gVarD.e().c(new c(), kotlin.collections.u.j());
        this.r = gVarD.a().i().b() ? kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b() : e.a(gVarD, uVar);
        this.s = gVarD.e().d(new b());
    }

    public final kotlin.p002reflect.jvm.internal.impl.descriptors.e M0(kotlin.reflect.y.internal.j0.d.a.n0.g gVar) {
        m.f(gVar, "jClass");
        return this.p.j().O(gVar);
    }

    public final Map<String, q> N0() {
        return (Map) kotlin.reflect.y.internal.j0.k.m.a(this.o, this, l[0]);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.k0
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public d q() {
        return this.p;
    }

    public final List<kotlin.reflect.y.internal.j0.f.c> P0() {
        return this.q.invoke();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.b, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a
    public kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g getAnnotations() {
        return this.r;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.z, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k, kotlin.p002reflect.jvm.internal.impl.descriptors.p
    public z0 t() {
        return new r(this);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.z, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.j
    public String toString() {
        return "Lazy Java package fragment: " + d() + " of module " + this.n.a().m();
    }
}
