package com.facebook.o0.u0;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;
import cm.aptoide.pt.networking.BodyInterceptorV3;
import cm.aptoide.pt.root.execution.Command;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SuggestedEventViewHierarchy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final g a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Class<? extends View>> f10523b = u.m(Switch.class, Spinner.class, DatePicker.class, TimePicker.class, RadioGroup.class, RatingBar.class, EditText.class, AdapterView.class);

    private g() {
    }

    public static final List<View> a(View view) {
        m.f(view, "view");
        ArrayList arrayList = new ArrayList();
        Iterator<Class<? extends View>> it = f10523b.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(view)) {
                return arrayList;
            }
        }
        if (view.isClickable()) {
            arrayList.add(view);
        }
        com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
        Iterator<View> it2 = com.facebook.o0.m0.n.f.b(view).iterator();
        while (it2.hasNext()) {
            arrayList.addAll(a(it2.next()));
        }
        return arrayList;
    }

    public static final JSONObject b(View view, View view2) {
        m.f(view, "view");
        m.f(view2, "clickedView");
        JSONObject jSONObject = new JSONObject();
        if (view == view2) {
            try {
                jSONObject.put("is_interacted", true);
            } catch (JSONException unused) {
            }
        }
        e(view, jSONObject);
        JSONArray jSONArray = new JSONArray();
        com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
        Iterator<View> it = com.facebook.o0.m0.n.f.b(view).iterator();
        while (it.hasNext()) {
            jSONArray.put(b(it.next(), view2));
        }
        jSONObject.put("childviews", jSONArray);
        return jSONObject;
    }

    private final List<String> c(View view) {
        ArrayList arrayList = new ArrayList();
        com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
        for (View view2 : com.facebook.o0.m0.n.f.b(view)) {
            com.facebook.o0.m0.n.f fVar2 = com.facebook.o0.m0.n.f.a;
            String strK = com.facebook.o0.m0.n.f.k(view2);
            if (strK.length() > 0) {
                arrayList.add(strK);
            }
            arrayList.addAll(c(view2));
        }
        return arrayList;
    }

    public static final String d(View view) {
        m.f(view, "hostView");
        com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
        String strK = com.facebook.o0.m0.n.f.k(view);
        if (strK.length() > 0) {
            return strK;
        }
        String strJoin = TextUtils.join(" ", a.c(view));
        m.e(strJoin, "join(\" \", childrenText)");
        return strJoin;
    }

    public static final void e(View view, JSONObject jSONObject) {
        m.f(view, "view");
        m.f(jSONObject, BodyInterceptorV3.RESPONSE_MODE_JSON);
        try {
            com.facebook.o0.m0.n.f fVar = com.facebook.o0.m0.n.f.a;
            String strK = com.facebook.o0.m0.n.f.k(view);
            String strI = com.facebook.o0.m0.n.f.i(view);
            jSONObject.put("classname", view.getClass().getSimpleName());
            jSONObject.put("classtypebitmask", com.facebook.o0.m0.n.f.c(view));
            boolean z = true;
            if (strK.length() > 0) {
                jSONObject.put(Command.CommandHandler.TEXT, strK);
            }
            if (strI.length() <= 0) {
                z = false;
            }
            if (z) {
                jSONObject.put("hint", strI);
            }
            if (view instanceof EditText) {
                jSONObject.put("inputtype", ((EditText) view).getInputType());
            }
        } catch (JSONException unused) {
        }
    }
}
