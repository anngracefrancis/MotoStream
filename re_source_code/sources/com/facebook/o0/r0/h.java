package com.facebook.o0.r0;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.facebook.a0;
import com.facebook.internal.p0;
import com.facebook.o0.q0.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.IntIterator;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;
import kotlin.text.v;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ModelManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static final h a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, b> f10457b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<String> f10458c = u.m("other", "fb_mobile_complete_registration", "fb_mobile_add_to_cart", "fb_mobile_purchase", "fb_mobile_initiated_checkout");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<String> f10459d = u.m("none", "address", "health");

    /* JADX INFO: compiled from: ModelManager.kt */
    public enum a {
        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;

        /* JADX INFO: renamed from: com.facebook.o0.r0.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ModelManager.kt */
        public /* synthetic */ class C0150a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[a.valuesCustom().length];
                iArr[a.MTML_INTEGRITY_DETECT.ordinal()] = 1;
                iArr[a.MTML_APP_EVENT_PREDICTION.ordinal()] = 2;
                a = iArr;
            }
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            return (a[]) Arrays.copyOf(aVarArrValuesCustom, aVarArrValuesCustom.length);
        }

        public final String k() {
            int i2 = C0150a.a[ordinal()];
            if (i2 == 1) {
                return "integrity_detect";
            }
            if (i2 == 2) {
                return "app_event_pred";
            }
            throw new NoWhenBranchMatchedException();
        }

        public final String q() {
            int i2 = C0150a.a[ordinal()];
            if (i2 == 1) {
                return "MTML_INTEGRITY_DETECT";
            }
            if (i2 == 2) {
                return "MTML_APP_EVENT_PRED";
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: ModelManager.kt */
    public static final class b {
        public static final a a = new a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f10463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f10464c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f10465d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f10466e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float[] f10467f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private File f10468g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private g f10469h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Runnable f10470i;

        /* JADX INFO: compiled from: ModelManager.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }

            private final void b(String str, int i2) {
                File[] fileArrListFiles;
                j jVar = j.a;
                File fileA = j.a();
                if (fileA == null || (fileArrListFiles = fileA.listFiles()) == null) {
                    return;
                }
                if (fileArrListFiles.length == 0) {
                    return;
                }
                String str2 = str + '_' + i2;
                int length = fileArrListFiles.length;
                int i3 = 0;
                while (i3 < length) {
                    File file = fileArrListFiles[i3];
                    i3++;
                    String name = file.getName();
                    m.e(name, "name");
                    if (kotlin.text.u.E(name, str, false, 2, null) && !kotlin.text.u.E(name, str2, false, 2, null)) {
                        file.delete();
                    }
                }
            }

            private final void c(String str, String str2, k.a aVar) {
                j jVar = j.a;
                File file = new File(j.a(), str2);
                if (str == null || file.exists()) {
                    aVar.a(file);
                } else {
                    new k(str, file, aVar).execute(new String[0]);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void e(List list, File file) {
                m.f(list, "$slaves");
                m.f(file, "file");
                final g gVarA = g.a.a(file);
                if (gVarA != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        final b bVar = (b) it.next();
                        b.a.c(bVar.e(), bVar.g() + '_' + bVar.h() + "_rule", new k.a() { // from class: com.facebook.o0.r0.c
                            @Override // com.facebook.o0.q0.k.a
                            public final void a(File file2) {
                                h.b.a.f(bVar, gVarA, file2);
                            }
                        });
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void f(b bVar, g gVar, File file) {
                m.f(bVar, "$slave");
                m.f(file, "file");
                bVar.i(gVar);
                bVar.k(file);
                Runnable runnable = bVar.f10470i;
                if (runnable == null) {
                    return;
                }
                runnable.run();
            }

            public final b a(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return null;
                }
                try {
                    String string = jSONObject.getString("use_case");
                    String string2 = jSONObject.getString("asset_uri");
                    String strOptString = jSONObject.optString("rules_uri", null);
                    int i2 = jSONObject.getInt("version_id");
                    float[] fArrO = h.a.o(jSONObject.getJSONArray("thresholds"));
                    m.e(string, "useCase");
                    m.e(string2, "assetUri");
                    return new b(string, string2, strOptString, i2, fArrO);
                } catch (Exception unused) {
                    return null;
                }
            }

            public final void d(b bVar, final List<b> list) {
                m.f(bVar, "master");
                m.f(list, "slaves");
                b(bVar.g(), bVar.h());
                c(bVar.b(), bVar.g() + '_' + bVar.h(), new k.a() { // from class: com.facebook.o0.r0.b
                    @Override // com.facebook.o0.q0.k.a
                    public final void a(File file) {
                        h.b.a.e(list, file);
                    }
                });
            }
        }

        public b(String str, String str2, String str3, int i2, float[] fArr) {
            m.f(str, "useCase");
            m.f(str2, "assetUri");
            this.f10463b = str;
            this.f10464c = str2;
            this.f10465d = str3;
            this.f10466e = i2;
            this.f10467f = fArr;
        }

        public final String b() {
            return this.f10464c;
        }

        public final g c() {
            return this.f10469h;
        }

        public final File d() {
            return this.f10468g;
        }

        public final String e() {
            return this.f10465d;
        }

        public final float[] f() {
            return this.f10467f;
        }

        public final String g() {
            return this.f10463b;
        }

        public final int h() {
            return this.f10466e;
        }

        public final void i(g gVar) {
            this.f10469h = gVar;
        }

        public final b j(Runnable runnable) {
            this.f10470i = runnable;
            return this;
        }

        public final void k(File file) {
            this.f10468g = file;
        }
    }

    /* JADX INFO: compiled from: ModelManager.kt */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.valuesCustom().length];
            iArr[a.MTML_APP_EVENT_PREDICTION.ordinal()] = 1;
            iArr[a.MTML_INTEGRITY_DETECT.ordinal()] = 2;
            a = iArr;
        }
    }

    private h() {
    }

    private final void b(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            try {
                b bVarA = b.a.a(jSONObject.getJSONObject(itKeys.next()));
                if (bVarA != null) {
                    f10457b.put(bVarA.g(), bVarA);
                }
            } catch (JSONException unused) {
                return;
            }
        }
    }

    public static final void c() {
        p0 p0Var = p0.a;
        p0.B0(new Runnable() { // from class: com.facebook.o0.r0.e
            @Override // java.lang.Runnable
            public final void run() {
                h.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        JSONObject jSONObject;
        try {
            a0 a0Var = a0.a;
            SharedPreferences sharedPreferences = a0.c().getSharedPreferences("com.facebook.internal.MODEL_STORE", 0);
            String string = sharedPreferences.getString("models", null);
            if (string != null) {
                jSONObject = string.length() == 0 ? new JSONObject() : new JSONObject(string);
            }
            long j2 = sharedPreferences.getLong("model_request_timestamp", 0L);
            com.facebook.internal.a0 a0Var2 = com.facebook.internal.a0.a;
            if (!com.facebook.internal.a0.g(com.facebook.internal.a0.b.ModelRequest) || jSONObject.length() == 0 || !a.k(j2)) {
                jSONObject = a.h();
                if (jSONObject == null) {
                    return;
                } else {
                    sharedPreferences.edit().putString("models", jSONObject.toString()).putLong("model_request_timestamp", System.currentTimeMillis()).apply();
                }
            }
            h hVar = a;
            hVar.b(jSONObject);
            hVar.e();
        } catch (Exception unused) {
        }
    }

    private final void e() {
        ArrayList arrayList = new ArrayList();
        String strB = null;
        int iMax = 0;
        for (Map.Entry<String, b> entry : f10457b.entrySet()) {
            String key = entry.getKey();
            b value = entry.getValue();
            if (m.a(key, a.MTML_APP_EVENT_PREDICTION.q())) {
                String strB2 = value.b();
                int iMax2 = Math.max(iMax, value.h());
                com.facebook.internal.a0 a0Var = com.facebook.internal.a0.a;
                if (com.facebook.internal.a0.g(com.facebook.internal.a0.b.SuggestedEvents) && j()) {
                    arrayList.add(value.j(new Runnable() { // from class: com.facebook.o0.r0.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            h.f();
                        }
                    }));
                }
                strB = strB2;
                iMax = iMax2;
            }
            if (m.a(key, a.MTML_INTEGRITY_DETECT.q())) {
                strB = value.b();
                iMax = Math.max(iMax, value.h());
                com.facebook.internal.a0 a0Var2 = com.facebook.internal.a0.a;
                if (com.facebook.internal.a0.g(com.facebook.internal.a0.b.IntelligentIntegrity)) {
                    arrayList.add(value.j(new Runnable() { // from class: com.facebook.o0.r0.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            h.g();
                        }
                    }));
                }
            }
        }
        if (strB == null || iMax <= 0 || arrayList.isEmpty()) {
            return;
        }
        b.a.d(new b("MTML", strB, null, iMax, null), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        com.facebook.o0.u0.h hVar = com.facebook.o0.u0.h.a;
        com.facebook.o0.u0.h.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        com.facebook.o0.p0.a aVar = com.facebook.o0.p0.a.a;
        com.facebook.o0.p0.a.a();
    }

    private final JSONObject h() {
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", new String[]{"use_case", "version_id", "asset_uri", "rules_uri", "thresholds"}));
        GraphRequest graphRequestX = GraphRequest.a.x(null, "app/model_asset", null);
        graphRequestX.H(bundle);
        JSONObject jSONObjectC = graphRequestX.j().c();
        if (jSONObjectC == null) {
            return null;
        }
        return p(jSONObjectC);
    }

    public static final File i(a aVar) {
        m.f(aVar, "task");
        b bVar = f10457b.get(aVar.q());
        if (bVar == null) {
            return null;
        }
        return bVar.d();
    }

    private final boolean j() {
        p0 p0Var = p0.a;
        Locale localeL = p0.L();
        if (localeL != null) {
            String language = localeL.getLanguage();
            m.e(language, "locale.language");
            if (!v.J(language, "en", false, 2, null)) {
                return false;
            }
        }
        return true;
    }

    private final boolean k(long j2) {
        return j2 != 0 && System.currentTimeMillis() - j2 < 259200000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float[] o(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        float[] fArr = new float[jSONArray.length()];
        int i2 = 0;
        int length = jSONArray.length();
        if (length > 0) {
            while (true) {
                int i3 = i2 + 1;
                try {
                    String string = jSONArray.getString(i2);
                    m.e(string, "jsonArray.getString(i)");
                    fArr[i2] = Float.parseFloat(string);
                } catch (JSONException unused) {
                }
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return fArr;
    }

    private final JSONObject p(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            int i2 = 0;
            int length = jSONArray.length();
            if (length <= 0) {
                return jSONObject2;
            }
            while (true) {
                int i3 = i2 + 1;
                JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("version_id", jSONObject3.getString("version_id"));
                jSONObject4.put("use_case", jSONObject3.getString("use_case"));
                jSONObject4.put("thresholds", jSONObject3.getJSONArray("thresholds"));
                jSONObject4.put("asset_uri", jSONObject3.getString("asset_uri"));
                if (jSONObject3.has("rules_uri")) {
                    jSONObject4.put("rules_uri", jSONObject3.getString("rules_uri"));
                }
                jSONObject2.put(jSONObject3.getString("use_case"), jSONObject4);
                if (i3 >= length) {
                    return jSONObject2;
                }
                i2 = i3;
            }
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public static final String[] q(a aVar, float[][] fArr, String[] strArr) {
        m.f(aVar, "task");
        m.f(fArr, "denses");
        m.f(strArr, "texts");
        b bVar = f10457b.get(aVar.q());
        g gVarC = bVar == null ? null : bVar.c();
        if (gVarC == null) {
            return null;
        }
        float[] fArrF = bVar.f();
        int length = strArr.length;
        int length2 = fArr[0].length;
        f fVar = new f(new int[]{length, length2});
        if (length > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                System.arraycopy(fArr[i2], 0, fVar.a(), i2 * length2, length2);
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        f fVarB = gVarC.b(fVar, strArr, aVar.k());
        if (fVarB == null || fArrF == null) {
            return null;
        }
        if (fVarB.a().length == 0) {
            return null;
        }
        if (fArrF.length == 0) {
            return null;
        }
        int i4 = c.a[aVar.ordinal()];
        if (i4 == 1) {
            return a.s(fVarB, fArrF);
        }
        if (i4 == 2) {
            return a.r(fVarB, fArrF);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String[] r(f fVar, float[] fArr) {
        int iB = fVar.b(0);
        int iB2 = fVar.b(1);
        float[] fArrA = fVar.a();
        if (iB2 != fArr.length) {
            return null;
        }
        IntRange intRangeK = l.k(0, iB);
        ArrayList arrayList = new ArrayList(kotlin.collections.v.u(intRangeK, 10));
        Iterator<Integer> it = intRangeK.iterator();
        while (it.hasNext()) {
            int iB3 = ((IntIterator) it).b();
            int length = fArr.length;
            String str = "none";
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = i3 + 1;
                if (fArrA[(iB3 * iB2) + i3] >= fArr[i2]) {
                    str = f10459d.get(i3);
                }
                i2++;
                i3 = i4;
            }
            arrayList.add(str);
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final String[] s(f fVar, float[] fArr) {
        int iB = fVar.b(0);
        int iB2 = fVar.b(1);
        float[] fArrA = fVar.a();
        if (iB2 != fArr.length) {
            return null;
        }
        IntRange intRangeK = l.k(0, iB);
        ArrayList arrayList = new ArrayList(kotlin.collections.v.u(intRangeK, 10));
        Iterator<Integer> it = intRangeK.iterator();
        while (it.hasNext()) {
            int iB3 = ((IntIterator) it).b();
            int length = fArr.length;
            String str = "other";
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = i3 + 1;
                if (fArrA[(iB3 * iB2) + i3] >= fArr[i2]) {
                    str = f10458c.get(i3);
                }
                i2++;
                i3 = i4;
            }
            arrayList.add(str);
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
