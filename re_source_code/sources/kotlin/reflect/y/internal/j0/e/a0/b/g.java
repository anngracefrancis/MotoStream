package kotlin.reflect.y.internal.j0.e.a0.b;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.IndexedValue;
import kotlin.collections.c0;
import kotlin.collections.p0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import kotlin.reflect.y.internal.j0.e.z.c;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: JvmNameResolverBase.kt */
/* JADX INFO: loaded from: classes3.dex */
public class g implements c {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f23893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<String> f23894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, Integer> f23895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String[] f23896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<Integer> f23897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<kotlin.f0.y.e.j0.e.a0.a.e.c> f23898g;

    /* JADX INFO: compiled from: JvmNameResolverBase.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: JvmNameResolverBase.kt */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[kotlin.f0.y.e.j0.e.a0.a.e.c.EnumC0359c.values().length];
            iArr[kotlin.f0.y.e.j0.e.a0.a.e.c.EnumC0359c.NONE.ordinal()] = 1;
            iArr[kotlin.f0.y.e.j0.e.a0.a.e.c.EnumC0359c.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            iArr[kotlin.f0.y.e.j0.e.a0.a.e.c.EnumC0359c.DESC_TO_CLASS_ID.ordinal()] = 3;
            a = iArr;
        }
    }

    static {
        String strE0 = c0.e0(u.m('k', 'o', 't', 'l', 'i', 'n'), HttpUrl.FRAGMENT_ENCODE_SET, null, null, 0, null, null, 62, null);
        f23893b = strE0;
        List<String> listM = u.m(strE0 + "/Any", strE0 + "/Nothing", strE0 + "/Unit", strE0 + "/Throwable", strE0 + "/Number", strE0 + "/Byte", strE0 + "/Double", strE0 + "/Float", strE0 + "/Int", strE0 + "/Long", strE0 + "/Short", strE0 + "/Boolean", strE0 + "/Char", strE0 + "/CharSequence", strE0 + "/String", strE0 + "/Comparable", strE0 + "/Enum", strE0 + "/Array", strE0 + "/ByteArray", strE0 + "/DoubleArray", strE0 + "/FloatArray", strE0 + "/IntArray", strE0 + "/LongArray", strE0 + "/ShortArray", strE0 + "/BooleanArray", strE0 + "/CharArray", strE0 + "/Cloneable", strE0 + "/Annotation", strE0 + "/collections/Iterable", strE0 + "/collections/MutableIterable", strE0 + "/collections/Collection", strE0 + "/collections/MutableCollection", strE0 + "/collections/List", strE0 + "/collections/MutableList", strE0 + "/collections/Set", strE0 + "/collections/MutableSet", strE0 + "/collections/Map", strE0 + "/collections/MutableMap", strE0 + "/collections/Map.Entry", strE0 + "/collections/MutableMap.MutableEntry", strE0 + "/collections/Iterator", strE0 + "/collections/MutableIterator", strE0 + "/collections/ListIterator", strE0 + "/collections/MutableListIterator");
        f23894c = listM;
        Iterable<IndexedValue> iterableK0 = c0.K0(listM);
        LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(p0.e(v.u(iterableK0, 10)), 16));
        for (IndexedValue indexedValue : iterableK0) {
            linkedHashMap.put((String) indexedValue.d(), Integer.valueOf(indexedValue.c()));
        }
        f23895d = linkedHashMap;
    }

    public g(String[] strArr, Set<Integer> set, List<kotlin.f0.y.e.j0.e.a0.a.e.c> list) {
        m.f(strArr, "strings");
        m.f(set, "localNameIndices");
        m.f(list, "records");
        this.f23896e = strArr;
        this.f23897f = set;
        this.f23898g = list;
    }

    @Override // kotlin.reflect.y.internal.j0.e.z.c
    public String a(int i2) {
        return getString(i2);
    }

    @Override // kotlin.reflect.y.internal.j0.e.z.c
    public boolean b(int i2) {
        return this.f23897f.contains(Integer.valueOf(i2));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003d  */
    @Override // kotlin.reflect.y.internal.j0.e.z.c
    public String getString(int i2) {
        String strSubstring;
        kotlin.f0.y.e.j0.e.a0.a.e.c cVar = this.f23898g.get(i2);
        if (cVar.P()) {
            strSubstring = cVar.I();
        } else if (cVar.N()) {
            List<String> list = f23894c;
            int size = list.size();
            int iE = cVar.E();
            if (iE >= 0 && iE < size) {
                strSubstring = list.get(cVar.E());
            } else {
                strSubstring = this.f23896e[i2];
            }
        } else {
            strSubstring = this.f23896e[i2];
        }
        if (cVar.K() >= 2) {
            List<Integer> listL = cVar.L();
            m.e(listL, "substringIndexList");
            Integer num = listL.get(0);
            Integer num2 = listL.get(1);
            m.e(num, "begin");
            if (num.intValue() >= 0) {
                int iIntValue = num.intValue();
                m.e(num2, "end");
                if (iIntValue <= num2.intValue() && num2.intValue() <= strSubstring.length()) {
                    m.e(strSubstring, "string");
                    strSubstring = strSubstring.substring(num.intValue(), num2.intValue());
                    m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                }
            }
        }
        String strZ = strSubstring;
        if (cVar.G() >= 2) {
            List<Integer> listH = cVar.H();
            m.e(listH, "replaceCharList");
            Integer num3 = listH.get(0);
            Integer num4 = listH.get(1);
            m.e(strZ, "string");
            strZ = kotlin.text.u.z(strZ, (char) num3.intValue(), (char) num4.intValue(), false, 4, null);
        }
        String strZ2 = strZ;
        kotlin.f0.y.e.j0.e.a0.a.e.c.EnumC0359c enumC0359cD = cVar.D();
        if (enumC0359cD == null) {
            enumC0359cD = kotlin.f0.y.e.j0.e.a0.a.e.c.EnumC0359c.NONE;
        }
        int i3 = b.a[enumC0359cD.ordinal()];
        if (i3 == 2) {
            m.e(strZ2, "string");
            strZ2 = kotlin.text.u.z(strZ2, '$', '.', false, 4, null);
        } else if (i3 == 3) {
            if (strZ2.length() >= 2) {
                m.e(strZ2, "string");
                strZ2 = strZ2.substring(1, strZ2.length() - 1);
                m.e(strZ2, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            String str = strZ2;
            m.e(str, "string");
            strZ2 = kotlin.text.u.z(str, '$', '.', false, 4, null);
        }
        m.e(strZ2, "string");
        return strZ2;
    }
}
