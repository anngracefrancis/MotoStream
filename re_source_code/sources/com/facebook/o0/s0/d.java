package com.facebook.o0.s0;

import android.os.Bundle;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import com.facebook.internal.d0;
import com.facebook.internal.p0;
import com.facebook.o0.v;
import java.util.List;
import kotlin.collections.c0;
import kotlin.jvm.internal.m;
import org.json.JSONArray;

/* JADX INFO: compiled from: RemoteServiceParametersHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final d a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10479b = e.class.getSimpleName();

    private d() {
    }

    public static final Bundle a(e.a aVar, String str, List<v> list) {
        m.f(aVar, "eventType");
        m.f(str, "applicationId");
        m.f(list, "appEvents");
        Bundle bundle = new Bundle();
        bundle.putString("event", aVar.toString());
        bundle.putString(RateAndReviewsFragment.BundleCons.APP_ID, str);
        if (e.a.CUSTOM_APP_EVENTS == aVar) {
            JSONArray jSONArrayB = a.b(list, str);
            if (jSONArrayB.length() == 0) {
                return null;
            }
            bundle.putString("custom_events", jSONArrayB.toString());
        }
        return bundle;
    }

    private final JSONArray b(List<v> list, String str) {
        JSONArray jSONArray = new JSONArray();
        List<v> listG0 = c0.G0(list);
        com.facebook.o0.n0.a aVar = com.facebook.o0.n0.a.a;
        com.facebook.o0.n0.a.d(listG0);
        boolean zC = c(str);
        for (v vVar : listG0) {
            if (!vVar.g()) {
                p0 p0Var = p0.a;
                p0.j0(f10479b, m.n("Event with invalid checksum: ", vVar));
            } else if ((!vVar.h()) || (vVar.h() && zC)) {
                jSONArray.put(vVar.e());
            }
        }
        return jSONArray;
    }

    private final boolean c(String str) {
        d0 d0Var = d0.a;
        com.facebook.internal.c0 c0VarO = d0.o(str, false);
        if (c0VarO != null) {
            return c0VarO.n();
        }
        return false;
    }
}
