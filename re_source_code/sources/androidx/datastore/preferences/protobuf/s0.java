package androidx.datastore.preferences.protobuf;

import cm.aptoide.pt.database.room.RoomNotification;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: MessageLiteToString.java */
/* JADX INFO: loaded from: classes.dex */
final class s0 {
    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }

    private static boolean b(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0;
        }
        if (obj instanceof Float) {
            return ((Float) obj).floatValue() == 0.0f;
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == 0.0d;
        }
        if (obj instanceof String) {
            return obj.equals(HttpUrl.FRAGMENT_ENCODE_SET);
        }
        if (obj instanceof h) {
            return obj.equals(h.f1298f);
        }
        if (obj instanceof q0) {
            return obj == ((q0) obj).b();
        }
        return (obj instanceof Enum) && ((Enum) obj).ordinal() == 0;
    }

    static final void c(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                c(sb, i2, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                c(sb, i2, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(k1.c((String) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof h) {
            sb.append(": \"");
            sb.append(k1.a((h) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof y) {
            sb.append(" {");
            d((y) obj, sb, i2 + 2);
            sb.append("\n");
            while (i3 < i2) {
                sb.append(' ');
                i3++;
            }
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj.toString());
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i5 = i2 + 2;
        c(sb, i5, RoomNotification.KEY, entry.getKey());
        c(sb, i5, "value", entry.getValue());
        sb.append("\n");
        while (i3 < i2) {
            sb.append(' ');
            i3++;
        }
        sb.append("}");
    }

    private static void d(q0 q0Var, StringBuilder sb, int i2) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : q0Var.getClass().getDeclaredMethods()) {
            map2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                map.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String strReplaceFirst = str.replaceFirst("get", HttpUrl.FRAGMENT_ENCODE_SET);
            boolean zBooleanValue = true;
            if (strReplaceFirst.endsWith("List") && !strReplaceFirst.endsWith("OrBuilderList") && !strReplaceFirst.equals("List")) {
                String str2 = strReplaceFirst.substring(0, 1).toLowerCase() + strReplaceFirst.substring(1, strReplaceFirst.length() - 4);
                Method method2 = (Method) map.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    c(sb, i2, a(str2), y.y(method2, q0Var, new Object[0]));
                }
            }
            if (strReplaceFirst.endsWith("Map") && !strReplaceFirst.equals("Map")) {
                String str3 = strReplaceFirst.substring(0, 1).toLowerCase() + strReplaceFirst.substring(1, strReplaceFirst.length() - 3);
                Method method3 = (Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    c(sb, i2, a(str3), y.y(method3, q0Var, new Object[0]));
                }
            }
            if (((Method) map2.get("set" + strReplaceFirst)) != null) {
                if (strReplaceFirst.endsWith("Bytes")) {
                    if (map.containsKey("get" + strReplaceFirst.substring(0, strReplaceFirst.length() - 5))) {
                    }
                }
                String str4 = strReplaceFirst.substring(0, 1).toLowerCase() + strReplaceFirst.substring(1);
                Method method4 = (Method) map.get("get" + strReplaceFirst);
                Method method5 = (Method) map.get("has" + strReplaceFirst);
                if (method4 != null) {
                    Object objY = y.y(method4, q0Var, new Object[0]);
                    if (method5 != null) {
                        zBooleanValue = ((Boolean) y.y(method5, q0Var, new Object[0])).booleanValue();
                    } else if (b(objY)) {
                        zBooleanValue = false;
                    }
                    if (zBooleanValue) {
                        c(sb, i2, a(str4), objY);
                    }
                }
            }
        }
        if (q0Var instanceof y.c) {
            Iterator<Map.Entry<T, Object>> itS = ((y.c) q0Var).extensions.s();
            while (itS.hasNext()) {
                Map.Entry entry = (Map.Entry) itS.next();
                c(sb, i2, "[" + ((y.d) entry.getKey()).f() + "]", entry.getValue());
            }
        }
        m1 m1Var = ((y) q0Var).unknownFields;
        if (m1Var != null) {
            m1Var.m(sb, i2);
        }
    }

    static String e(q0 q0Var, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        d(q0Var, sb, 0);
        return sb.toString();
    }
}
