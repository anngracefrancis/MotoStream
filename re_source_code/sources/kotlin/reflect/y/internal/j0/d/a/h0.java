package kotlin.reflect.y.internal.j0.d.a;

import cm.aptoide.pt.database.room.RoomInstalled;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.n0;
import kotlin.collections.p0;
import kotlin.collections.q0;
import kotlin.collections.v;
import kotlin.collections.w0;
import kotlin.collections.x0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import kotlin.reflect.y.internal.j0.d.b.x;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.u.e;
import kotlin.s;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SpecialGenericSignatures.kt */
/* JADX INFO: loaded from: classes2.dex */
public class h0 {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<a.C0327a> f23378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<String> f23379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<String> f23380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<a.C0327a, c> f23381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map<String, c> f23382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set<f> f23383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Set<String> f23384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final a.C0327a f23385i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<a.C0327a, f> f23386j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Map<String, f> f23387k;
    private static final List<f> l;
    private static final Map<f, f> m;

    /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
    public static final class a {

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.d.a.h0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
        public static final class C0327a {
            private final f a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f23388b;

            public C0327a(f fVar, String str) {
                m.f(fVar, "name");
                m.f(str, RoomInstalled.SIGNATURE);
                this.a = fVar;
                this.f23388b = str;
            }

            public final f a() {
                return this.a;
            }

            public final String b() {
                return this.f23388b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0327a)) {
                    return false;
                }
                C0327a c0327a = (C0327a) obj;
                return m.a(this.a, c0327a.a) && m.a(this.f23388b, c0327a.f23388b);
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.f23388b.hashCode();
            }

            public String toString() {
                return "NameAndSignature(name=" + this.a + ", signature=" + this.f23388b + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C0327a m(String str, String str2, String str3, String str4) {
            f fVarX = f.x(str2);
            m.e(fVarX, "identifier(name)");
            return new C0327a(fVarX, x.a.k(str, str2 + '(' + str3 + ')' + str4));
        }

        public final f b(f fVar) {
            m.f(fVar, "name");
            return f().get(fVar);
        }

        public final List<String> c() {
            return h0.f23379c;
        }

        public final Set<f> d() {
            return h0.f23383g;
        }

        public final Set<String> e() {
            return h0.f23384h;
        }

        public final Map<f, f> f() {
            return h0.m;
        }

        public final List<f> g() {
            return h0.l;
        }

        public final C0327a h() {
            return h0.f23385i;
        }

        public final Map<String, c> i() {
            return h0.f23382f;
        }

        public final Map<String, f> j() {
            return h0.f23387k;
        }

        public final boolean k(f fVar) {
            m.f(fVar, "<this>");
            return g().contains(fVar);
        }

        public final b l(String str) {
            m.f(str, "builtinSignature");
            if (c().contains(str)) {
                return b.ONE_COLLECTION_PARAMETER;
            }
            return ((c) n0.j(i(), str)) == c.f23395f ? b.OBJECT_PARAMETER_GENERIC : b.OBJECT_PARAMETER_NON_GENERIC;
        }
    }

    /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
    public enum b {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);


        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f23393j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final boolean f23394k;

        b(String str, boolean z) {
            this.f23393j = str;
            this.f23394k = z;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
    public static final class c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f23395f = new c("NULL", 0, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f23396g = new c("INDEX", 1, -1);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f23397h = new c("FALSE", 2, Boolean.FALSE);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f23398i = new a("MAP_GET_OR_DEFAULT", 3);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ c[] f23399j = g();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final Object f23400k;

        /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
        static final class a extends c {
            /* JADX WARN: Illegal instructions before constructor call */
            a(String str, int i2) {
                g gVar = null;
                super(str, i2, gVar, gVar);
            }
        }

        private c(String str, int i2, Object obj) {
            super(str, i2);
            this.f23400k = obj;
        }

        public /* synthetic */ c(String str, int i2, Object obj, g gVar) {
            this(str, i2, obj);
        }

        private static final /* synthetic */ c[] g() {
            return new c[]{f23395f, f23396g, f23397h, f23398i};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f23399j.clone();
        }
    }

    static {
        Set<String> setI = w0.i("containsAll", "removeAll", "retainAll");
        ArrayList arrayList = new ArrayList(v.u(setI, 10));
        for (String str : setI) {
            a aVar = a;
            String strU = e.BOOLEAN.u();
            m.e(strU, "BOOLEAN.desc");
            arrayList.add(aVar.m("java/util/Collection", str, "Ljava/util/Collection;", strU));
        }
        f23378b = arrayList;
        ArrayList arrayList2 = new ArrayList(v.u(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((a.C0327a) it.next()).b());
        }
        f23379c = arrayList2;
        List<a.C0327a> list = f23378b;
        ArrayList arrayList3 = new ArrayList(v.u(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((a.C0327a) it2.next()).a().k());
        }
        f23380d = arrayList3;
        x xVar = x.a;
        a aVar2 = a;
        String strI = xVar.i("Collection");
        e eVar = e.BOOLEAN;
        String strU2 = eVar.u();
        m.e(strU2, "BOOLEAN.desc");
        a.C0327a c0327aM = aVar2.m(strI, "contains", "Ljava/lang/Object;", strU2);
        c cVar = c.f23397h;
        String strI2 = xVar.i("Collection");
        String strU3 = eVar.u();
        m.e(strU3, "BOOLEAN.desc");
        String strI3 = xVar.i("Map");
        String strU4 = eVar.u();
        m.e(strU4, "BOOLEAN.desc");
        String strI4 = xVar.i("Map");
        String strU5 = eVar.u();
        m.e(strU5, "BOOLEAN.desc");
        String strI5 = xVar.i("Map");
        String strU6 = eVar.u();
        m.e(strU6, "BOOLEAN.desc");
        a.C0327a c0327aM2 = aVar2.m(xVar.i("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        c cVar2 = c.f23395f;
        String strI6 = xVar.i("List");
        e eVar2 = e.INT;
        String strU7 = eVar2.u();
        m.e(strU7, "INT.desc");
        a.C0327a c0327aM3 = aVar2.m(strI6, "indexOf", "Ljava/lang/Object;", strU7);
        c cVar3 = c.f23396g;
        String strI7 = xVar.i("List");
        String strU8 = eVar2.u();
        m.e(strU8, "INT.desc");
        Map<a.C0327a, c> mapL = q0.l(s.a(c0327aM, cVar), s.a(aVar2.m(strI2, "remove", "Ljava/lang/Object;", strU3), cVar), s.a(aVar2.m(strI3, "containsKey", "Ljava/lang/Object;", strU4), cVar), s.a(aVar2.m(strI4, "containsValue", "Ljava/lang/Object;", strU5), cVar), s.a(aVar2.m(strI5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", strU6), cVar), s.a(aVar2.m(xVar.i("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), c.f23398i), s.a(c0327aM2, cVar2), s.a(aVar2.m(xVar.i("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), cVar2), s.a(c0327aM3, cVar3), s.a(aVar2.m(strI7, "lastIndexOf", "Ljava/lang/Object;", strU8), cVar3));
        f23381e = mapL;
        LinkedHashMap linkedHashMap = new LinkedHashMap(p0.e(mapL.size()));
        Iterator<T> it3 = mapL.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            linkedHashMap.put(((a.C0327a) entry.getKey()).b(), entry.getValue());
        }
        f23382f = linkedHashMap;
        Set setL = x0.l(f23381e.keySet(), f23378b);
        ArrayList arrayList4 = new ArrayList(v.u(setL, 10));
        Iterator it4 = setL.iterator();
        while (it4.hasNext()) {
            arrayList4.add(((a.C0327a) it4.next()).a());
        }
        f23383g = c0.I0(arrayList4);
        ArrayList arrayList5 = new ArrayList(v.u(setL, 10));
        Iterator it5 = setL.iterator();
        while (it5.hasNext()) {
            arrayList5.add(((a.C0327a) it5.next()).b());
        }
        f23384h = c0.I0(arrayList5);
        a aVar3 = a;
        e eVar3 = e.INT;
        String strU9 = eVar3.u();
        m.e(strU9, "INT.desc");
        a.C0327a c0327aM4 = aVar3.m("java/util/List", "removeAt", strU9, "Ljava/lang/Object;");
        f23385i = c0327aM4;
        x xVar2 = x.a;
        String strH = xVar2.h("Number");
        String strU10 = e.BYTE.u();
        m.e(strU10, "BYTE.desc");
        String strH2 = xVar2.h("Number");
        String strU11 = e.SHORT.u();
        m.e(strU11, "SHORT.desc");
        String strH3 = xVar2.h("Number");
        String strU12 = eVar3.u();
        m.e(strU12, "INT.desc");
        String strH4 = xVar2.h("Number");
        String strU13 = e.LONG.u();
        m.e(strU13, "LONG.desc");
        String strH5 = xVar2.h("Number");
        String strU14 = e.FLOAT.u();
        m.e(strU14, "FLOAT.desc");
        String strH6 = xVar2.h("Number");
        String strU15 = e.DOUBLE.u();
        m.e(strU15, "DOUBLE.desc");
        String strH7 = xVar2.h("CharSequence");
        String strU16 = eVar3.u();
        m.e(strU16, "INT.desc");
        String strU17 = e.CHAR.u();
        m.e(strU17, "CHAR.desc");
        Map<a.C0327a, f> mapL2 = q0.l(s.a(aVar3.m(strH, "toByte", HttpUrl.FRAGMENT_ENCODE_SET, strU10), f.x("byteValue")), s.a(aVar3.m(strH2, "toShort", HttpUrl.FRAGMENT_ENCODE_SET, strU11), f.x("shortValue")), s.a(aVar3.m(strH3, "toInt", HttpUrl.FRAGMENT_ENCODE_SET, strU12), f.x("intValue")), s.a(aVar3.m(strH4, "toLong", HttpUrl.FRAGMENT_ENCODE_SET, strU13), f.x("longValue")), s.a(aVar3.m(strH5, "toFloat", HttpUrl.FRAGMENT_ENCODE_SET, strU14), f.x("floatValue")), s.a(aVar3.m(strH6, "toDouble", HttpUrl.FRAGMENT_ENCODE_SET, strU15), f.x("doubleValue")), s.a(c0327aM4, f.x("remove")), s.a(aVar3.m(strH7, "get", strU16, strU17), f.x("charAt")));
        f23386j = mapL2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(p0.e(mapL2.size()));
        Iterator<T> it6 = mapL2.entrySet().iterator();
        while (it6.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it6.next();
            linkedHashMap2.put(((a.C0327a) entry2.getKey()).b(), entry2.getValue());
        }
        f23387k = linkedHashMap2;
        Set<a.C0327a> setKeySet = f23386j.keySet();
        ArrayList arrayList6 = new ArrayList(v.u(setKeySet, 10));
        Iterator<T> it7 = setKeySet.iterator();
        while (it7.hasNext()) {
            arrayList6.add(((a.C0327a) it7.next()).a());
        }
        l = arrayList6;
        Set<Map.Entry<a.C0327a, f>> setEntrySet = f23386j.entrySet();
        ArrayList<Pair> arrayList7 = new ArrayList(v.u(setEntrySet, 10));
        Iterator<T> it8 = setEntrySet.iterator();
        while (it8.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it8.next();
            arrayList7.add(new Pair(((a.C0327a) entry3.getKey()).a(), entry3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(l.b(p0.e(v.u(arrayList7, 10)), 16));
        for (Pair pair : arrayList7) {
            linkedHashMap3.put((f) pair.d(), (f) pair.c());
        }
        m = linkedHashMap3;
    }
}
