package com.facebook.internal.t0;

import cm.aptoide.pt.install.installer.RootCommandOnSubscribe;
import com.facebook.GraphRequest;
import com.facebook.a0;
import com.facebook.c0;
import com.facebook.d0;
import com.facebook.internal.p0;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExceptionAnalyzer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static final h a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f9866b;

    private h() {
    }

    public static final void a() {
        h hVar = a;
        f9866b = true;
        a0 a0Var = a0.a;
        if (a0.g()) {
            hVar.e();
        }
    }

    public static final void b(Throwable th) {
        if (!f9866b || c() || th == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        StackTraceElement[] stackTrace = th.getStackTrace();
        m.e(stackTrace, "e.stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            com.facebook.internal.a0 a0Var = com.facebook.internal.a0.a;
            String className = stackTraceElement.getClassName();
            m.e(className, "it.className");
            com.facebook.internal.a0.b bVarD = com.facebook.internal.a0.d(className);
            if (bVarD != com.facebook.internal.a0.b.Unknown) {
                com.facebook.internal.a0.c(bVarD);
                hashSet.add(bVarD.toString());
            }
        }
        a0 a0Var2 = a0.a;
        if (a0.g() && (!hashSet.isEmpty())) {
            i.a aVar = i.a.a;
            i.a.c(new JSONArray((Collection) hashSet)).g();
        }
    }

    public static final boolean c() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(i iVar, d0 d0Var) {
        m.f(iVar, "$instrumentData");
        m.f(d0Var, "response");
        try {
            if (d0Var.b() == null) {
                JSONObject jSONObjectD = d0Var.d();
                if (m.a(jSONObjectD == null ? null : Boolean.valueOf(jSONObjectD.getBoolean(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION)), Boolean.TRUE)) {
                    iVar.a();
                }
            }
        } catch (JSONException unused) {
        }
    }

    public final void e() {
        p0 p0Var = p0.a;
        if (p0.X()) {
            return;
        }
        k kVar = k.a;
        File[] fileArrN = k.n();
        ArrayList arrayList = new ArrayList();
        int length = fileArrN.length;
        int i2 = 0;
        while (i2 < length) {
            File file = fileArrN[i2];
            i2++;
            i.a aVar = i.a.a;
            final i iVarD = i.a.d(file);
            if (iVarD.f()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("crash_shield", iVarD.toString());
                    GraphRequest.c cVar = GraphRequest.a;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                    a0 a0Var = a0.a;
                    String str = String.format("%s/instruments", Arrays.copyOf(new Object[]{a0.d()}, 1));
                    m.e(str, "java.lang.String.format(format, *args)");
                    arrayList.add(cVar.A(null, str, jSONObject, new GraphRequest.b() { // from class: com.facebook.internal.t0.a
                        @Override // com.facebook.GraphRequest.b
                        public final void b(d0 d0Var) {
                            h.f(iVarD, d0Var);
                        }
                    }));
                } catch (JSONException unused) {
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        new c0(arrayList).o();
    }
}
