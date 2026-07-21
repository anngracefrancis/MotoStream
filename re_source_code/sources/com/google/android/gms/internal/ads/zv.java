package com.google.android.gms.internal.ads;

import cm.aptoide.pt.database.room.RoomNotification;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
final class zv {
    static String a(zzdpk zzdpkVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        b(zzdpkVar, sb, 0);
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:80:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:81:0x01eb  */
    private static void b(zzdpk zzdpkVar, StringBuilder sb, int i2) {
        boolean zEquals;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzdpkVar.getClass().getDeclaredMethods()) {
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
                    c(sb, i2, d(strConcat), zzdob.s(method2, zzdpkVar, new Object[0]));
                }
            }
            if (strReplaceFirst.endsWith("Map") && !strReplaceFirst.equals("Map")) {
                String strValueOf3 = String.valueOf(strReplaceFirst.substring(0, 1).toLowerCase());
                String strValueOf4 = String.valueOf(strReplaceFirst.substring(1, strReplaceFirst.length() - 3));
                String strConcat2 = strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3);
                Method method3 = (Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    c(sb, i2, d(strConcat2), zzdob.s(method3, zzdpkVar, new Object[0]));
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
                    Object objS = zzdob.s(method4, zzdpkVar, new Object[0]);
                    if (method5 == null) {
                        if (objS instanceof Boolean) {
                            if (((Boolean) objS).booleanValue()) {
                                zEquals = false;
                            } else {
                                zEquals = true;
                            }
                        } else if (objS instanceof Integer) {
                            if (((Integer) objS).intValue() == 0) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objS instanceof Float) {
                            if (((Float) objS).floatValue() == 0.0f) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objS instanceof Double) {
                            if (((Double) objS).doubleValue() == 0.0d) {
                                zEquals = true;
                            } else {
                                zEquals = false;
                            }
                        } else if (objS instanceof String) {
                            zEquals = objS.equals(HttpUrl.FRAGMENT_ENCODE_SET);
                        } else if (objS instanceof zzdmr) {
                            zEquals = objS.equals(zzdmr.f15982f);
                        } else if (!(objS instanceof zzdpk) ? !((objS instanceof Enum) && ((Enum) objS).ordinal() == 0) : objS != ((zzdpk) objS).f()) {
                            zEquals = false;
                        } else {
                            zEquals = true;
                        }
                        if (zEquals) {
                            zBooleanValue = false;
                        }
                    } else {
                        zBooleanValue = ((Boolean) zzdob.s(method5, zzdpkVar, new Object[0])).booleanValue();
                    }
                    if (zBooleanValue) {
                        c(sb, i2, d(strConcat3), objS);
                    }
                }
            }
        }
        if (zzdpkVar instanceof zzdob.zzc) {
            Iterator<Map.Entry<FieldDescriptorType, Object>> itE = ((zzdob.zzc) zzdpkVar).zzhhj.e();
            if (itE.hasNext()) {
                ((Map.Entry) itE.next()).getKey();
                throw new NoSuchMethodError();
            }
        }
        zzdqu zzdquVar = ((zzdob) zzdpkVar).zzhhd;
        if (zzdquVar != null) {
            zzdquVar.c(sb, i2);
        }
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
            sb.append(zw.a(zzdmr.z((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzdmr) {
            sb.append(": \"");
            sb.append(zw.a((zzdmr) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzdob) {
            sb.append(" {");
            b((zzdob) obj, sb, i2 + 2);
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

    private static final String d(String str) {
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
}
