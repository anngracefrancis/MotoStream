package com.facebook.internal;

import com.facebook.FacebookRequestError;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: FacebookRequestErrorClassification.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class x {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static x f9911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Integer, Set<Integer>> f9912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Integer, Set<Integer>> f9913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<Integer, Set<Integer>> f9914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f9915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f9916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f9917h;

    /* JADX INFO: compiled from: FacebookRequestErrorClassification.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final x c() {
            return new x(null, kotlin.collections.q0.k(kotlin.s.a(2, null), kotlin.s.a(4, null), kotlin.s.a(9, null), kotlin.s.a(17, null), kotlin.s.a(341, null)), kotlin.collections.q0.k(kotlin.s.a(102, null), kotlin.s.a(190, null), kotlin.s.a(412, null)), null, null, null);
        }

        private final Map<Integer, Set<Integer>> d(JSONObject jSONObject) {
            int iOptInt;
            HashSet hashSet;
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("items");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                return null;
            }
            HashMap map = new HashMap();
            int length = jSONArrayOptJSONArray.length();
            if (length > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null && (iOptInt = jSONObjectOptJSONObject.optInt("code")) != 0) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("subcodes");
                        if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                            hashSet = null;
                        } else {
                            hashSet = new HashSet();
                            int length2 = jSONArrayOptJSONArray2.length();
                            if (length2 > 0) {
                                int i4 = 0;
                                while (true) {
                                    int i5 = i4 + 1;
                                    int iOptInt2 = jSONArrayOptJSONArray2.optInt(i4);
                                    if (iOptInt2 != 0) {
                                        hashSet.add(Integer.valueOf(iOptInt2));
                                    }
                                    if (i5 >= length2) {
                                        break;
                                    }
                                    i4 = i5;
                                }
                            }
                        }
                        map.put(Integer.valueOf(iOptInt), hashSet);
                    }
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            return map;
        }

        public final x a(JSONArray jSONArray) {
            Map<Integer, Set<Integer>> map;
            Map<Integer, Set<Integer>> map2;
            Map<Integer, Set<Integer>> map3;
            String str;
            String str2;
            String str3;
            String strOptString;
            if (jSONArray == null) {
                return null;
            }
            int i2 = 0;
            int length = jSONArray.length();
            if (length > 0) {
                Map<Integer, Set<Integer>> mapD = null;
                Map<Integer, Set<Integer>> mapD2 = null;
                Map<Integer, Set<Integer>> mapD3 = null;
                String strOptString2 = null;
                String strOptString3 = null;
                String strOptString4 = null;
                while (true) {
                    int i3 = i2 + 1;
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null && (strOptString = jSONObjectOptJSONObject.optString("name")) != null) {
                        if (kotlin.text.u.q(strOptString, "other", true)) {
                            strOptString2 = jSONObjectOptJSONObject.optString("recovery_message", null);
                            mapD = d(jSONObjectOptJSONObject);
                        } else if (kotlin.text.u.q(strOptString, "transient", true)) {
                            strOptString3 = jSONObjectOptJSONObject.optString("recovery_message", null);
                            mapD2 = d(jSONObjectOptJSONObject);
                        } else if (kotlin.text.u.q(strOptString, "login_recoverable", true)) {
                            strOptString4 = jSONObjectOptJSONObject.optString("recovery_message", null);
                            mapD3 = d(jSONObjectOptJSONObject);
                        }
                    }
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
                map = mapD;
                map2 = mapD2;
                map3 = mapD3;
                str = strOptString2;
                str2 = strOptString3;
                str3 = strOptString4;
            } else {
                map = null;
                map2 = null;
                map3 = null;
                str = null;
                str2 = null;
                str3 = null;
            }
            return new x(map, map2, map3, str, str2, str3);
        }

        public final synchronized x b() {
            x xVar;
            if (x.f9911b == null) {
                x.f9911b = c();
            }
            xVar = x.f9911b;
            if (xVar == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.FacebookRequestErrorClassification");
            }
            return xVar;
        }
    }

    /* JADX INFO: compiled from: FacebookRequestErrorClassification.kt */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FacebookRequestError.a.valuesCustom().length];
            iArr[FacebookRequestError.a.OTHER.ordinal()] = 1;
            iArr[FacebookRequestError.a.LOGIN_RECOVERABLE.ordinal()] = 2;
            iArr[FacebookRequestError.a.TRANSIENT.ordinal()] = 3;
            a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(Map<Integer, ? extends Set<Integer>> map, Map<Integer, ? extends Set<Integer>> map2, Map<Integer, ? extends Set<Integer>> map3, String str, String str2, String str3) {
        this.f9912c = map;
        this.f9913d = map2;
        this.f9914e = map3;
        this.f9915f = str;
        this.f9916g = str2;
        this.f9917h = str3;
    }

    public final FacebookRequestError.a c(int i2, int i3, boolean z) {
        Set<Integer> set;
        Set<Integer> set2;
        Set<Integer> set3;
        if (z) {
            return FacebookRequestError.a.TRANSIENT;
        }
        Map<Integer, Set<Integer>> map = this.f9912c;
        if (map != null && map.containsKey(Integer.valueOf(i2)) && ((set3 = this.f9912c.get(Integer.valueOf(i2))) == null || set3.contains(Integer.valueOf(i3)))) {
            return FacebookRequestError.a.OTHER;
        }
        Map<Integer, Set<Integer>> map2 = this.f9914e;
        if (map2 != null && map2.containsKey(Integer.valueOf(i2)) && ((set2 = this.f9914e.get(Integer.valueOf(i2))) == null || set2.contains(Integer.valueOf(i3)))) {
            return FacebookRequestError.a.LOGIN_RECOVERABLE;
        }
        Map<Integer, Set<Integer>> map3 = this.f9913d;
        return (map3 != null && map3.containsKey(Integer.valueOf(i2)) && ((set = this.f9913d.get(Integer.valueOf(i2))) == null || set.contains(Integer.valueOf(i3)))) ? FacebookRequestError.a.TRANSIENT : FacebookRequestError.a.OTHER;
    }

    public final String d(FacebookRequestError.a aVar) {
        int i2 = aVar == null ? -1 : b.a[aVar.ordinal()];
        if (i2 == 1) {
            return this.f9915f;
        }
        if (i2 == 2) {
            return this.f9917h;
        }
        if (i2 != 3) {
            return null;
        }
        return this.f9916g;
    }
}
