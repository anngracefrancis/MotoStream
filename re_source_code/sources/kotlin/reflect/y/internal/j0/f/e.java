package kotlin.reflect.y.internal.j0.f;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.m;
import kotlin.text.u;

/* JADX INFO: compiled from: FqNamesUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: compiled from: FqNamesUtil.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[k.values().length];
            iArr[k.BEGINNING.ordinal()] = 1;
            iArr[k.AFTER_DOT.ordinal()] = 2;
            iArr[k.MIDDLE.ordinal()] = 3;
            a = iArr;
        }
    }

    public static final <V> V a(c cVar, Map<c, ? extends V> map) {
        Object next;
        m.f(cVar, "<this>");
        m.f(map, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<c, ? extends V>> it = map.entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<c, ? extends V> next2 = it.next();
            c key = next2.getKey();
            if (!m.a(cVar, key) && !b(cVar, key)) {
                z = false;
            }
            if (z) {
                linkedHashMap.put(next2.getKey(), next2.getValue());
            }
        }
        if (!(!linkedHashMap.isEmpty())) {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            return null;
        }
        Iterator it2 = linkedHashMap.entrySet().iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                int length = g((c) ((Map.Entry) next).getKey(), cVar).b().length();
                do {
                    Object next3 = it2.next();
                    int length2 = g((c) ((Map.Entry) next3).getKey(), cVar).b().length();
                    if (length > length2) {
                        next = next3;
                        length = length2;
                    }
                } while (it2.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (V) entry.getValue();
        }
        return null;
    }

    public static final boolean b(c cVar, c cVar2) {
        m.f(cVar, "<this>");
        m.f(cVar2, "packageName");
        return m.a(f(cVar), cVar2);
    }

    private static final boolean c(String str, String str2) {
        return u.E(str, str2, false, 2, null) && str.charAt(str2.length()) == '.';
    }

    public static final boolean d(c cVar, c cVar2) {
        m.f(cVar, "<this>");
        m.f(cVar2, "packageName");
        if (m.a(cVar, cVar2) || cVar2.d()) {
            return true;
        }
        String strB = cVar.b();
        m.e(strB, "this.asString()");
        String strB2 = cVar2.b();
        m.e(strB2, "packageName.asString()");
        return c(strB, strB2);
    }

    public static final boolean e(String str) {
        if (str == null) {
            return false;
        }
        k kVar = k.BEGINNING;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            int i3 = a.a[kVar.ordinal()];
            if (i3 == 1 || i3 == 2) {
                if (!Character.isJavaIdentifierPart(cCharAt)) {
                    return false;
                }
                kVar = k.MIDDLE;
            } else if (i3 != 3) {
                continue;
            } else if (cCharAt == '.') {
                kVar = k.AFTER_DOT;
            } else if (!Character.isJavaIdentifierPart(cCharAt)) {
                return false;
            }
        }
        return kVar != k.AFTER_DOT;
    }

    public static final c f(c cVar) {
        m.f(cVar, "<this>");
        if (cVar.d()) {
            return null;
        }
        return cVar.e();
    }

    public static final c g(c cVar, c cVar2) {
        m.f(cVar, "<this>");
        m.f(cVar2, "prefix");
        if (!d(cVar, cVar2) || cVar2.d()) {
            return cVar;
        }
        if (m.a(cVar, cVar2)) {
            c cVar3 = c.a;
            m.e(cVar3, "ROOT");
            return cVar3;
        }
        String strB = cVar.b();
        m.e(strB, "asString()");
        String strSubstring = strB.substring(cVar2.b().length() + 1);
        m.e(strSubstring, "this as java.lang.String).substring(startIndex)");
        return new c(strSubstring);
    }
}
