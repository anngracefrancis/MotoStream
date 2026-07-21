package com.facebook.o0.o0;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.a0;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.text.v;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: InAppPurchaseEventManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static final i a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<String, Method> f10371b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashMap<String, Class<?>> f10372c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SharedPreferences f10374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SharedPreferences f10375f;

    static {
        a0 a0Var = a0.a;
        f10373d = a0.c().getPackageName();
        f10374e = a0.c().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
        f10375f = a0.c().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
    }

    private i() {
    }

    public static final Object a(Context context, IBinder iBinder) {
        kotlin.jvm.internal.m.f(context, "context");
        return a.n(context, "com.android.vending.billing.IInAppBillingService$Stub", "asInterface", null, new Object[]{iBinder});
    }

    public static final void b() {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences sharedPreferences = f10374e;
        long j2 = sharedPreferences.getLong("LAST_CLEARED_TIME", 0L);
        if (j2 == 0) {
            sharedPreferences.edit().putLong("LAST_CLEARED_TIME", jCurrentTimeMillis).apply();
        } else if (jCurrentTimeMillis - j2 > 604800) {
            sharedPreferences.edit().clear().putLong("LAST_CLEARED_TIME", jCurrentTimeMillis).apply();
        }
    }

    private final ArrayList<String> c(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        SharedPreferences.Editor editorEdit = f10375f.edit();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        for (String str : arrayList) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("productId");
                long j2 = jSONObject.getLong("purchaseTime");
                String string2 = jSONObject.getString("purchaseToken");
                if (jCurrentTimeMillis - (j2 / 1000) <= 86400 && !kotlin.jvm.internal.m.a(f10375f.getString(string, HttpUrl.FRAGMENT_ENCODE_SET), string2)) {
                    editorEdit.putString(string, string2);
                    arrayList2.add(str);
                }
            } catch (JSONException unused) {
            }
        }
        editorEdit.apply();
        return arrayList2;
    }

    private final Class<?> d(Context context, String str) {
        HashMap<String, Class<?>> map = f10372c;
        Class<?> cls = map.get(str);
        if (cls != null) {
            return cls;
        }
        m mVar = m.a;
        Class<?> clsB = m.b(context, str);
        if (clsB != null) {
            map.put(str, clsB);
        }
        return clsB;
    }

    private final Method e(Class<?> cls, String str) {
        Class[] clsArr;
        Method methodC;
        HashMap<String, Method> map = f10371b;
        Method method = map.get(str);
        if (method != null) {
            return method;
        }
        switch (str) {
            case "getPurchases":
                Class cls2 = Integer.TYPE;
                kotlin.jvm.internal.m.e(cls2, "TYPE");
                clsArr = new Class[]{cls2, String.class, String.class, String.class};
                break;
            case "isBillingSupported":
                Class cls3 = Integer.TYPE;
                kotlin.jvm.internal.m.e(cls3, "TYPE");
                clsArr = new Class[]{cls3, String.class, String.class};
                break;
            case "asInterface":
                clsArr = new Class[]{IBinder.class};
                break;
            case "getPurchaseHistory":
                Class cls4 = Integer.TYPE;
                kotlin.jvm.internal.m.e(cls4, "TYPE");
                clsArr = new Class[]{cls4, String.class, String.class, String.class, Bundle.class};
                break;
            case "getSkuDetails":
                Class cls5 = Integer.TYPE;
                kotlin.jvm.internal.m.e(cls5, "TYPE");
                clsArr = new Class[]{cls5, String.class, String.class, Bundle.class};
                break;
            default:
                clsArr = null;
                break;
        }
        if (clsArr == null) {
            m mVar = m.a;
            methodC = m.c(cls, str, null);
        } else {
            m mVar2 = m.a;
            methodC = m.c(cls, str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        }
        if (methodC != null) {
            map.put(str, methodC);
        }
        return methodC;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x008c  */
    private final ArrayList<String> f(Context context, Object obj, String str) {
        ArrayList<String> stringArrayList;
        ArrayList<String> arrayList = new ArrayList<>();
        if (o(context, obj, str)) {
            String string = null;
            int i2 = 0;
            boolean z = false;
            do {
                Object objN = n(context, "com.android.vending.billing.IInAppBillingService", "getPurchaseHistory", obj, new Object[]{6, f10373d, str, string, new Bundle()});
                if (objN != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                    Bundle bundle = (Bundle) objN;
                    if (bundle.getInt("RESPONSE_CODE") != 0 || (stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST")) == null) {
                        string = null;
                    } else {
                        for (String str2 : stringArrayList) {
                            try {
                                if (jCurrentTimeMillis - (new JSONObject(str2).getLong("purchaseTime") / 1000) > 1200) {
                                    z = true;
                                    break;
                                }
                                arrayList.add(str2);
                                i2++;
                            } catch (JSONException unused) {
                            }
                        }
                        string = bundle.getString("INAPP_CONTINUATION_TOKEN");
                    }
                } else {
                    string = null;
                }
                if (i2 >= 30 || string == null) {
                    break;
                }
            } while (!z);
        }
        return arrayList;
    }

    public static final ArrayList<String> g(Context context, Object obj) {
        i iVar;
        Class<?> clsD;
        kotlin.jvm.internal.m.f(context, "context");
        ArrayList<String> arrayList = new ArrayList<>();
        return (obj == null || (clsD = (iVar = a).d(context, "com.android.vending.billing.IInAppBillingService")) == null || iVar.e(clsD, "getPurchaseHistory") == null) ? arrayList : iVar.c(iVar.f(context, obj, "inapp"));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0054  */
    /* JADX WARN: Code duplicated, block: B:18:0x0059 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:20:0x005b A[EDGE_INSN: B:20:0x005b->B:19:0x005b BREAK  A[LOOP:0: B:8:0x0012->B:23:?], SYNTHETIC] */
    private final ArrayList<String> h(Context context, Object obj, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (obj != null && o(context, obj, str)) {
            String string = null;
            int size = 0;
            do {
                Object objN = n(context, "com.android.vending.billing.IInAppBillingService", "getPurchases", obj, new Object[]{3, f10373d, str, string});
                if (objN == null) {
                    string = null;
                    if (size < 30) {
                        break;
                        break;
                    }
                } else {
                    Bundle bundle = (Bundle) objN;
                    if (bundle.getInt("RESPONSE_CODE") == 0) {
                        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                        if (stringArrayList == null) {
                            break;
                        }
                        size += stringArrayList.size();
                        arrayList.addAll(stringArrayList);
                        string = bundle.getString("INAPP_CONTINUATION_TOKEN");
                    } else {
                        string = null;
                    }
                    if (size < 30) {
                        break;
                    }
                }
            } while (string != null);
        }
        return arrayList;
    }

    public static final ArrayList<String> i(Context context, Object obj) {
        kotlin.jvm.internal.m.f(context, "context");
        i iVar = a;
        return iVar.c(iVar.h(context, obj, "inapp"));
    }

    public static final ArrayList<String> j(Context context, Object obj) {
        kotlin.jvm.internal.m.f(context, "context");
        i iVar = a;
        return iVar.c(iVar.h(context, obj, "subs"));
    }

    public static final Map<String, String> k(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(arrayList, "skuList");
        Map<String, String> mapP = a.p(arrayList);
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (String str : arrayList) {
            if (!mapP.containsKey(str)) {
                arrayList2.add(str);
            }
        }
        mapP.putAll(a.l(context, arrayList2, obj, z));
        return mapP;
    }

    private final Map<String, String> l(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        int size;
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        if (obj != null && !arrayList.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            Object[] objArr = new Object[4];
            int i2 = 0;
            objArr[0] = 3;
            objArr[1] = f10373d;
            objArr[2] = z ? "subs" : "inapp";
            objArr[3] = bundle;
            Object objN = n(context, "com.android.vending.billing.IInAppBillingService", "getSkuDetails", obj, objArr);
            if (objN != null) {
                Bundle bundle2 = (Bundle) objN;
                if (bundle2.getInt("RESPONSE_CODE") == 0) {
                    ArrayList<String> stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                    if (stringArrayList != null && arrayList.size() == stringArrayList.size() && (size = arrayList.size() - 1) >= 0) {
                        while (true) {
                            int i3 = i2 + 1;
                            String str = arrayList.get(i2);
                            kotlin.jvm.internal.m.e(str, "skuList[i]");
                            String str2 = stringArrayList.get(i2);
                            kotlin.jvm.internal.m.e(str2, "skuDetailsList[i]");
                            linkedHashMap.put(str, str2);
                            if (i3 > size) {
                                break;
                            }
                            i2 = i3;
                        }
                    }
                    q(linkedHashMap);
                }
            }
        }
        return linkedHashMap;
    }

    private final Object n(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method methodE;
        Class<?> clsD = d(context, str);
        if (clsD == null || (methodE = e(clsD, str2)) == null) {
            return null;
        }
        m mVar = m.a;
        return m.e(clsD, methodE, obj, Arrays.copyOf(objArr, objArr.length));
    }

    private final boolean o(Context context, Object obj, String str) {
        Object objN;
        return (obj == null || (objN = n(context, "com.android.vending.billing.IInAppBillingService", "isBillingSupported", obj, new Object[]{3, f10373d, str})) == null || ((Integer) objN).intValue() != 0) ? false : true;
    }

    private final Map<String, String> p(ArrayList<String> arrayList) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        for (String str : arrayList) {
            String string = f10374e.getString(str, null);
            if (string != null) {
                List listV0 = v.v0(string, new String[]{";"}, false, 2, 2, null);
                if (jCurrentTimeMillis - Long.parseLong((String) listV0.get(0)) < 43200) {
                    kotlin.jvm.internal.m.e(str, "sku");
                    linkedHashMap.put(str, listV0.get(1));
                }
            }
        }
        return linkedHashMap;
    }

    private final void q(Map<String, String> map) {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences.Editor editorEdit = f10374e.edit();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            editorEdit.putString(entry.getKey(), jCurrentTimeMillis + ';' + entry.getValue());
        }
        editorEdit.apply();
    }

    public final boolean m(String str) {
        kotlin.jvm.internal.m.f(str, "skuDetail");
        try {
            String strOptString = new JSONObject(str).optString("freeTrialPeriod");
            if (strOptString != null) {
                return strOptString.length() > 0;
            }
            return false;
        } catch (JSONException unused) {
            return false;
        }
    }
}
