package com.google.android.gms.internal.measurement;

import cm.aptoide.pt.database.room.RoomNotification;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class f3 {
    static String a(zzgo zzgoVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        c(zzgoVar, sb, 0);
        return sb.toString();
    }

    private static final String b(String str) {
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

    /* JADX WARN: Code duplicated, block: B:80:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:81:0x01eb  */
    private static void c(zzgo zzgoVar, StringBuilder sb, int i2) {
        boolean zEquals;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzgoVar.getClass().getDeclaredMethods()) {
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
                String strValueOf = String.valueOf(strReplaceFirst.substring(0, 1).toLowerCase());
                String strValueOf2 = String.valueOf(strReplaceFirst.substring(1, strReplaceFirst.length() - 4));
                String strConcat = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                Method method2 = (Method) map.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    d(sb, i2, b(strConcat), zzfd.r(method2, zzgoVar, new Object[0]));
                }
            }
            if (strReplaceFirst.endsWith("Map") && !strReplaceFirst.equals("Map")) {
                String strValueOf3 = String.valueOf(strReplaceFirst.substring(0, 1).toLowerCase());
                String strValueOf4 = String.valueOf(strReplaceFirst.substring(1, strReplaceFirst.length() - 3));
                String strConcat2 = strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3);
                Method method3 = (Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    d(sb, i2, b(strConcat2), zzfd.r(method3, zzgoVar, new Object[0]));
                }
            }
            if (((Method) map2.get(strReplaceFirst.length() != 0 ? "set".concat(strReplaceFirst) : new String("set"))) != null) {
                if (strReplaceFirst.endsWith("Bytes")) {
                    String strValueOf5 = String.valueOf(strReplaceFirst.substring(0, strReplaceFirst.length() - 5));
                    if (!map.containsKey(strValueOf5.length() != 0 ? "get".concat(strValueOf5) : new String("get"))) {
                    }
                }
                String strValueOf6 = String.valueOf(strReplaceFirst.substring(0, 1).toLowerCase());
                String strValueOf7 = String.valueOf(strReplaceFirst.substring(1));
                String strConcat3 = strValueOf7.length() != 0 ? strValueOf6.concat(strValueOf7) : new String(strValueOf6);
                Method method4 = (Method) map.get(strReplaceFirst.length() != 0 ? "get".concat(strReplaceFirst) : new String("get"));
                Method method5 = (Method) map.get(strReplaceFirst.length() != 0 ? "has".concat(strReplaceFirst) : new String("has"));
                if (method4 != null) {
                    Object objR = zzfd.r(method4, zzgoVar, new Object[0]);
                    if (method5 == null) {
                        if (objR instanceof Boolean) {
                            if (((Boolean) objR).booleanValue()) {
                                zEquals = false;
                            } else {
                                zEquals = true;
                            }
                        } else if (objR instanceof Integer) {
                            if (((Integer) objR).intValue() == 0) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objR instanceof Float) {
                            if (((Float) objR).floatValue() == 0.0f) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objR instanceof Double) {
                            if (((Double) objR).doubleValue() == 0.0d) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objR instanceof String) {
                            zEquals = objR.equals(HttpUrl.FRAGMENT_ENCODE_SET);
                        } else if (objR instanceof zzdu) {
                            zEquals = objR.equals(zzdu.f17368f);
                        } else if (!(objR instanceof zzgo) ? !((objR instanceof Enum) && ((Enum) objR).ordinal() == 0) : objR != ((zzgo) objR).d()) {
                            zEquals = false;
                        } else {
                            zEquals = true;
                        }
                        if (zEquals) {
                            zBooleanValue = false;
                        }
                    } else {
                        zBooleanValue = ((Boolean) zzfd.r(method5, zzgoVar, new Object[0])).booleanValue();
                    }
                    if (zBooleanValue) {
                        d(sb, i2, b(strConcat3), objR);
                    }
                }
            }
        }
        if (zzgoVar instanceof zzfd.zzd) {
            Iterator<Map.Entry<T, Object>> itO = ((zzfd.zzd) zzgoVar).zzc.o();
            if (itO.hasNext()) {
                throw new NoSuchMethodError();
            }
        }
        zzhy zzhyVar = ((zzfd) zzgoVar).zzb;
        if (zzhyVar != null) {
            zzhyVar.f(sb, i2);
        }
    }

    static final void d(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                d(sb, i2, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                d(sb, i2, str, (Map.Entry) it2.next());
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
            sb.append(d4.a(zzdu.n((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzdu) {
            sb.append(": \"");
            sb.append(d4.a((zzdu) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzfd) {
            sb.append(" {");
            c((zzfd) obj, sb, i2 + 2);
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
        d(sb, i5, RoomNotification.KEY, entry.getKey());
        d(sb, i5, "value", entry.getValue());
        sb.append("\n");
        while (i3 < i2) {
            sb.append(' ');
            i3++;
        }
        sb.append("}");
    }
}
