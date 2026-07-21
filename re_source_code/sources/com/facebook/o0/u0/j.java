package com.facebook.o0.u0;

import android.os.Bundle;
import android.view.View;
import com.facebook.GraphRequest;
import com.facebook.a0;
import com.facebook.internal.p0;
import com.facebook.o0.g0;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.m;
import kotlin.text.u;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ViewOnClickListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10532f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set<Integer> f10533g = new HashSet();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final View.OnClickListener f10534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final WeakReference<View> f10535i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final WeakReference<View> f10536j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f10537k;

    /* JADX INFO: compiled from: ViewOnClickListener.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(String str, String str2, float[] fArr) {
            h hVar = h.a;
            if (h.e(str)) {
                a0 a0Var = a0.a;
                new g0(a0.c()).e(str, str2);
            } else if (h.d(str)) {
                h(str, str2, fArr);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean f(String str, final String str2) {
            f fVar = f.a;
            final String strD = f.d(str);
            if (strD == null) {
                return false;
            }
            if (m.a(strD, "other")) {
                return true;
            }
            p0 p0Var = p0.a;
            p0.B0(new Runnable() { // from class: com.facebook.o0.u0.c
                @Override // java.lang.Runnable
                public final void run() {
                    j.a.g(strD, str2);
                }
            });
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(String str, String str2) {
            m.f(str, "$queriedEvent");
            m.f(str2, "$buttonText");
            j.f10532f.e(str, str2, new float[0]);
        }

        private final void h(String str, String str2, float[] fArr) {
            Bundle bundle = new Bundle();
            try {
                bundle.putString("event_name", str);
                JSONObject jSONObject = new JSONObject();
                StringBuilder sb = new StringBuilder();
                int length = fArr.length;
                int i2 = 0;
                while (i2 < length) {
                    float f2 = fArr[i2];
                    i2++;
                    sb.append(f2);
                    sb.append(",");
                }
                jSONObject.put("dense", sb.toString());
                jSONObject.put("button_text", str2);
                bundle.putString("metadata", jSONObject.toString());
                GraphRequest.c cVar = GraphRequest.a;
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                Locale locale = Locale.US;
                a0 a0Var = a0.a;
                String str3 = String.format(locale, "%s/suggested_events", Arrays.copyOf(new Object[]{a0.d()}, 1));
                m.e(str3, "java.lang.String.format(locale, format, *args)");
                GraphRequest graphRequestA = cVar.A(null, str3, null, null);
                graphRequestA.H(bundle);
                graphRequestA.j();
            } catch (JSONException unused) {
            }
        }

        public final void c(View view, View view2, String str) {
            m.f(view, "hostView");
            m.f(view2, "rootView");
            m.f(str, "activityName");
            int iHashCode = view.hashCode();
            if (j.f10533g.contains(Integer.valueOf(iHashCode))) {
                return;
            }
            com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
            com.facebook.o0.m0.n.f.r(view, new j(view, view2, str, null));
            j.f10533g.add(Integer.valueOf(iHashCode));
        }
    }

    private j(View view, View view2, String str) {
        com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
        this.f10534h = com.facebook.o0.m0.n.f.g(view);
        this.f10535i = new WeakReference<>(view2);
        this.f10536j = new WeakReference<>(view);
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase();
        m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
        this.f10537k = u.A(lowerCase, "activity", HttpUrl.FRAGMENT_ENCODE_SET, false, 4, null);
    }

    public /* synthetic */ j(View view, View view2, String str, kotlin.jvm.internal.g gVar) {
        this(view, view2, str);
    }

    private final void c(final String str, final String str2, final JSONObject jSONObject) {
        p0 p0Var = p0.a;
        p0.B0(new Runnable() { // from class: com.facebook.o0.u0.d
            @Override // java.lang.Runnable
            public final void run() {
                j.d(jSONObject, str2, this, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(JSONObject jSONObject, String str, j jVar, String str2) {
        m.f(jSONObject, "$viewData");
        m.f(str, "$buttonText");
        m.f(jVar, "this$0");
        m.f(str2, "$pathID");
        try {
            p0 p0Var = p0.a;
            a0 a0Var = a0.a;
            String strS = p0.s(a0.c());
            if (strS == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strS.toLowerCase();
            m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
            e eVar = e.a;
            float[] fArrA = e.a(jSONObject, lowerCase);
            String strC = e.c(str, jVar.f10537k, lowerCase);
            if (fArrA == null) {
                return;
            }
            com.facebook.o0.r0.h hVar = com.facebook.o0.r0.h.a;
            String[] strArrQ = com.facebook.o0.r0.h.q(com.facebook.o0.r0.h.a.MTML_APP_EVENT_PREDICTION, new float[][]{fArrA}, new String[]{strC});
            if (strArrQ == null) {
                return;
            }
            String str3 = strArrQ[0];
            f fVar = f.a;
            f.a(str2, str3);
            if (m.a(str3, "other")) {
                return;
            }
            f10532f.e(str3, str, fArrA);
        } catch (Exception unused) {
        }
    }

    private final void e() {
        View view = this.f10535i.get();
        View view2 = this.f10536j.get();
        if (view == null || view2 == null) {
            return;
        }
        try {
            g gVar = g.a;
            String strD = g.d(view2);
            f fVar = f.a;
            String strB = f.b(view2, strD);
            if (strB == null || f10532f.f(strB, strD)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("view", g.b(view, view2));
            jSONObject.put("screenname", this.f10537k);
            c(strB, strD, jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m.f(view, "view");
        View.OnClickListener onClickListener = this.f10534h;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        e();
    }
}
