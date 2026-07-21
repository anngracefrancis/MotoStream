package kotlin.reflect.y.internal.j0.b.q;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.f.e;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.f.h;
import kotlin.reflect.y.internal.j0.f.i;
import kotlin.text.t;
import kotlin.text.v;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: JavaToKotlinClassMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f23243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f23244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f23245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f23246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final b f23247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.c f23248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final b f23249h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final b f23250i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final b f23251j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final HashMap<d, b> f23252k;
    private static final HashMap<d, b> l;
    private static final HashMap<d, kotlin.reflect.y.internal.j0.f.c> m;
    private static final HashMap<d, kotlin.reflect.y.internal.j0.f.c> n;
    private static final HashMap<b, b> o;
    private static final HashMap<b, b> p;
    private static final List<a> q;

    /* JADX INFO: compiled from: JavaToKotlinClassMap.kt */
    public static final class a {
        private final b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f23253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final b f23254c;

        public a(b bVar, b bVar2, b bVar3) {
            m.f(bVar, "javaClass");
            m.f(bVar2, "kotlinReadOnly");
            m.f(bVar3, "kotlinMutable");
            this.a = bVar;
            this.f23253b = bVar2;
            this.f23254c = bVar3;
        }

        public final b a() {
            return this.a;
        }

        public final b b() {
            return this.f23253b;
        }

        public final b c() {
            return this.f23254c;
        }

        public final b d() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(this.a, aVar.a) && m.a(this.f23253b, aVar.f23253b) && m.a(this.f23254c, aVar.f23254c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.f23253b.hashCode()) * 31) + this.f23254c.hashCode();
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.a + ", kotlinReadOnly=" + this.f23253b + ", kotlinMutable=" + this.f23254c + ')';
        }
    }

    static {
        c cVar = new c();
        a = cVar;
        StringBuilder sb = new StringBuilder();
        kotlin.reflect.y.internal.j0.b.p.c cVar2 = kotlin.reflect.y.internal.j0.b.p.c.f23233g;
        sb.append(cVar2.q().toString());
        sb.append('.');
        sb.append(cVar2.k());
        f23243b = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        kotlin.reflect.y.internal.j0.b.p.c cVar3 = kotlin.reflect.y.internal.j0.b.p.c.f23235i;
        sb2.append(cVar3.q().toString());
        sb2.append('.');
        sb2.append(cVar3.k());
        f23244c = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        kotlin.reflect.y.internal.j0.b.p.c cVar4 = kotlin.reflect.y.internal.j0.b.p.c.f23234h;
        sb3.append(cVar4.q().toString());
        sb3.append('.');
        sb3.append(cVar4.k());
        f23245d = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        kotlin.reflect.y.internal.j0.b.p.c cVar5 = kotlin.reflect.y.internal.j0.b.p.c.f23236j;
        sb4.append(cVar5.q().toString());
        sb4.append('.');
        sb4.append(cVar5.k());
        f23246e = sb4.toString();
        b bVarM = b.m(new kotlin.reflect.y.internal.j0.f.c("kotlin.jvm.functions.FunctionN"));
        m.e(bVarM, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        f23247f = bVarM;
        kotlin.reflect.y.internal.j0.f.c cVarB = bVarM.b();
        m.e(cVarB, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        f23248g = cVarB;
        i iVar = i.a;
        f23249h = iVar.i();
        f23250i = iVar.h();
        f23251j = cVar.g(Class.class);
        f23252k = new HashMap<>();
        l = new HashMap<>();
        m = new HashMap<>();
        n = new HashMap<>();
        o = new HashMap<>();
        p = new HashMap<>();
        b bVarM2 = b.m(k.a.T);
        m.e(bVarM2, "topLevel(FqNames.iterable)");
        kotlin.reflect.y.internal.j0.f.c cVar6 = k.a.b0;
        kotlin.reflect.y.internal.j0.f.c cVarH = bVarM2.h();
        kotlin.reflect.y.internal.j0.f.c cVarH2 = bVarM2.h();
        m.e(cVarH2, "kotlinReadOnly.packageFqName");
        kotlin.reflect.y.internal.j0.f.c cVarG = e.g(cVar6, cVarH2);
        b bVar = new b(cVarH, cVarG, false);
        b bVarM3 = b.m(k.a.S);
        m.e(bVarM3, "topLevel(FqNames.iterator)");
        kotlin.reflect.y.internal.j0.f.c cVar7 = k.a.a0;
        kotlin.reflect.y.internal.j0.f.c cVarH3 = bVarM3.h();
        kotlin.reflect.y.internal.j0.f.c cVarH4 = bVarM3.h();
        m.e(cVarH4, "kotlinReadOnly.packageFqName");
        b bVar2 = new b(cVarH3, e.g(cVar7, cVarH4), false);
        b bVarM4 = b.m(k.a.U);
        m.e(bVarM4, "topLevel(FqNames.collection)");
        kotlin.reflect.y.internal.j0.f.c cVar8 = k.a.c0;
        kotlin.reflect.y.internal.j0.f.c cVarH5 = bVarM4.h();
        kotlin.reflect.y.internal.j0.f.c cVarH6 = bVarM4.h();
        m.e(cVarH6, "kotlinReadOnly.packageFqName");
        b bVar3 = new b(cVarH5, e.g(cVar8, cVarH6), false);
        b bVarM5 = b.m(k.a.V);
        m.e(bVarM5, "topLevel(FqNames.list)");
        kotlin.reflect.y.internal.j0.f.c cVar9 = k.a.d0;
        kotlin.reflect.y.internal.j0.f.c cVarH7 = bVarM5.h();
        kotlin.reflect.y.internal.j0.f.c cVarH8 = bVarM5.h();
        m.e(cVarH8, "kotlinReadOnly.packageFqName");
        b bVar4 = new b(cVarH7, e.g(cVar9, cVarH8), false);
        b bVarM6 = b.m(k.a.X);
        m.e(bVarM6, "topLevel(FqNames.set)");
        kotlin.reflect.y.internal.j0.f.c cVar10 = k.a.f0;
        kotlin.reflect.y.internal.j0.f.c cVarH9 = bVarM6.h();
        kotlin.reflect.y.internal.j0.f.c cVarH10 = bVarM6.h();
        m.e(cVarH10, "kotlinReadOnly.packageFqName");
        b bVar5 = new b(cVarH9, e.g(cVar10, cVarH10), false);
        b bVarM7 = b.m(k.a.W);
        m.e(bVarM7, "topLevel(FqNames.listIterator)");
        kotlin.reflect.y.internal.j0.f.c cVar11 = k.a.e0;
        kotlin.reflect.y.internal.j0.f.c cVarH11 = bVarM7.h();
        kotlin.reflect.y.internal.j0.f.c cVarH12 = bVarM7.h();
        m.e(cVarH12, "kotlinReadOnly.packageFqName");
        b bVar6 = new b(cVarH11, e.g(cVar11, cVarH12), false);
        kotlin.reflect.y.internal.j0.f.c cVar12 = k.a.Y;
        b bVarM8 = b.m(cVar12);
        m.e(bVarM8, "topLevel(FqNames.map)");
        kotlin.reflect.y.internal.j0.f.c cVar13 = k.a.g0;
        kotlin.reflect.y.internal.j0.f.c cVarH13 = bVarM8.h();
        kotlin.reflect.y.internal.j0.f.c cVarH14 = bVarM8.h();
        m.e(cVarH14, "kotlinReadOnly.packageFqName");
        b bVar7 = new b(cVarH13, e.g(cVar13, cVarH14), false);
        b bVarD = b.m(cVar12).d(k.a.Z.g());
        m.e(bVarD, "topLevel(FqNames.map).cr…mes.mapEntry.shortName())");
        kotlin.reflect.y.internal.j0.f.c cVar14 = k.a.h0;
        kotlin.reflect.y.internal.j0.f.c cVarH15 = bVarD.h();
        kotlin.reflect.y.internal.j0.f.c cVarH16 = bVarD.h();
        m.e(cVarH16, "kotlinReadOnly.packageFqName");
        List<a> listM = u.m(new a(cVar.g(Iterable.class), bVarM2, bVar), new a(cVar.g(Iterator.class), bVarM3, bVar2), new a(cVar.g(Collection.class), bVarM4, bVar3), new a(cVar.g(List.class), bVarM5, bVar4), new a(cVar.g(Set.class), bVarM6, bVar5), new a(cVar.g(ListIterator.class), bVarM7, bVar6), new a(cVar.g(Map.class), bVarM8, bVar7), new a(cVar.g(Map.Entry.class), bVarD, new b(cVarH15, e.g(cVar14, cVarH16), false)));
        q = listM;
        cVar.f(Object.class, k.a.f23201b);
        cVar.f(String.class, k.a.f23207h);
        cVar.f(CharSequence.class, k.a.f23206g);
        cVar.e(Throwable.class, k.a.u);
        cVar.f(Cloneable.class, k.a.f23203d);
        cVar.f(Number.class, k.a.r);
        cVar.e(Comparable.class, k.a.v);
        cVar.f(Enum.class, k.a.s);
        cVar.e(Annotation.class, k.a.G);
        Iterator<a> it = listM.iterator();
        while (it.hasNext()) {
            a.d(it.next());
        }
        for (kotlin.reflect.y.internal.j0.i.u.e eVar : kotlin.reflect.y.internal.j0.i.u.e.values()) {
            c cVar15 = a;
            b bVarM9 = b.m(eVar.y());
            m.e(bVarM9, "topLevel(jvmType.wrapperFqName)");
            kotlin.reflect.y.internal.j0.b.i iVarX = eVar.x();
            m.e(iVarX, "jvmType.primitiveType");
            b bVarM10 = b.m(k.c(iVarX));
            m.e(bVarM10, "topLevel(StandardNames.g…e(jvmType.primitiveType))");
            cVar15.a(bVarM9, bVarM10);
        }
        for (b bVar8 : kotlin.reflect.y.internal.j0.b.c.a.a()) {
            c cVar16 = a;
            b bVarM11 = b.m(new kotlin.reflect.y.internal.j0.f.c("kotlin.jvm.internal." + bVar8.j().k() + "CompanionObject"));
            m.e(bVarM11, "topLevel(FqName(\"kotlin.…g() + \"CompanionObject\"))");
            b bVarD2 = bVar8.d(h.f24218d);
            m.e(bVarD2, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
            cVar16.a(bVarM11, bVarD2);
        }
        for (int i2 = 0; i2 < 23; i2++) {
            c cVar17 = a;
            b bVarM12 = b.m(new kotlin.reflect.y.internal.j0.f.c("kotlin.jvm.functions.Function" + i2));
            m.e(bVarM12, "topLevel(FqName(\"kotlin.…m.functions.Function$i\"))");
            cVar17.a(bVarM12, k.a(i2));
            cVar17.c(new kotlin.reflect.y.internal.j0.f.c(f23244c + i2), f23249h);
        }
        for (int i3 = 0; i3 < 22; i3++) {
            kotlin.reflect.y.internal.j0.b.p.c cVar18 = kotlin.reflect.y.internal.j0.b.p.c.f23236j;
            a.c(new kotlin.reflect.y.internal.j0.f.c((cVar18.q().toString() + '.' + cVar18.k()) + i3), f23249h);
        }
        c cVar19 = a;
        kotlin.reflect.y.internal.j0.f.c cVarL = k.a.f23202c.l();
        m.e(cVarL, "nothing.toSafe()");
        cVar19.c(cVarL, cVar19.g(Void.class));
    }

    private c() {
    }

    private final void a(b bVar, b bVar2) {
        b(bVar, bVar2);
        kotlin.reflect.y.internal.j0.f.c cVarB = bVar2.b();
        m.e(cVarB, "kotlinClassId.asSingleFqName()");
        c(cVarB, bVar);
    }

    private final void b(b bVar, b bVar2) {
        HashMap<d, b> map = f23252k;
        d dVarJ = bVar.b().j();
        m.e(dVarJ, "javaClassId.asSingleFqName().toUnsafe()");
        map.put(dVarJ, bVar2);
    }

    private final void c(kotlin.reflect.y.internal.j0.f.c cVar, b bVar) {
        HashMap<d, b> map = l;
        d dVarJ = cVar.j();
        m.e(dVarJ, "kotlinFqNameUnsafe.toUnsafe()");
        map.put(dVarJ, bVar);
    }

    private final void d(a aVar) {
        b bVarA = aVar.a();
        b bVarB = aVar.b();
        b bVarC = aVar.c();
        a(bVarA, bVarB);
        kotlin.reflect.y.internal.j0.f.c cVarB = bVarC.b();
        m.e(cVarB, "mutableClassId.asSingleFqName()");
        c(cVarB, bVarA);
        o.put(bVarC, bVarB);
        p.put(bVarB, bVarC);
        kotlin.reflect.y.internal.j0.f.c cVarB2 = bVarB.b();
        m.e(cVarB2, "readOnlyClassId.asSingleFqName()");
        kotlin.reflect.y.internal.j0.f.c cVarB3 = bVarC.b();
        m.e(cVarB3, "mutableClassId.asSingleFqName()");
        HashMap<d, kotlin.reflect.y.internal.j0.f.c> map = m;
        d dVarJ = bVarC.b().j();
        m.e(dVarJ, "mutableClassId.asSingleFqName().toUnsafe()");
        map.put(dVarJ, cVarB2);
        HashMap<d, kotlin.reflect.y.internal.j0.f.c> map2 = n;
        d dVarJ2 = cVarB2.j();
        m.e(dVarJ2, "readOnlyFqName.toUnsafe()");
        map2.put(dVarJ2, cVarB3);
    }

    private final void e(Class<?> cls, kotlin.reflect.y.internal.j0.f.c cVar) {
        b bVarG = g(cls);
        b bVarM = b.m(cVar);
        m.e(bVarM, "topLevel(kotlinFqName)");
        a(bVarG, bVarM);
    }

    private final void f(Class<?> cls, d dVar) {
        kotlin.reflect.y.internal.j0.f.c cVarL = dVar.l();
        m.e(cVarL, "kotlinFqName.toSafe()");
        e(cls, cVarL);
    }

    private final b g(Class<?> cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            b bVarM = b.m(new kotlin.reflect.y.internal.j0.f.c(cls.getCanonicalName()));
            m.e(bVarM, "topLevel(FqName(clazz.canonicalName))");
            return bVarM;
        }
        b bVarD = g(declaringClass).d(f.x(cls.getSimpleName()));
        m.e(bVarD, "classId(outer).createNes…tifier(clazz.simpleName))");
        return bVarD;
    }

    private final boolean j(d dVar, String str) {
        Integer numJ;
        String strB = dVar.b();
        m.e(strB, "kotlinFqName.asString()");
        String strE0 = v.E0(strB, str, HttpUrl.FRAGMENT_ENCODE_SET);
        return (strE0.length() > 0) && !v.A0(strE0, '0', false, 2, null) && (numJ = t.j(strE0)) != null && numJ.intValue() >= 23;
    }

    public final kotlin.reflect.y.internal.j0.f.c h() {
        return f23248g;
    }

    public final List<a> i() {
        return q;
    }

    public final boolean k(d dVar) {
        return m.containsKey(dVar);
    }

    public final boolean l(d dVar) {
        return n.containsKey(dVar);
    }

    public final b m(kotlin.reflect.y.internal.j0.f.c cVar) {
        m.f(cVar, "fqName");
        return f23252k.get(cVar.j());
    }

    public final b n(d dVar) {
        m.f(dVar, "kotlinFqName");
        if (!j(dVar, f23243b) && !j(dVar, f23245d)) {
            if (!j(dVar, f23244c) && !j(dVar, f23246e)) {
                return l.get(dVar);
            }
            return f23249h;
        }
        return f23247f;
    }

    public final kotlin.reflect.y.internal.j0.f.c o(d dVar) {
        return m.get(dVar);
    }

    public final kotlin.reflect.y.internal.j0.f.c p(d dVar) {
        return n.get(dVar);
    }
}
