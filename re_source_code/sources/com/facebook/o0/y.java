package com.facebook.o0;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import cm.aptoide.pt.account.AccountAnalytics;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: AppEventQueue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ScheduledFuture<?> f10555f;
    public static final y a = new y();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10551b = y.class.getName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f10552c = 100;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile w f10553d = new w();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ScheduledExecutorService f10554e = Executors.newSingleThreadScheduledExecutor();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Runnable f10556g = new Runnable() { // from class: com.facebook.o0.d
        @Override // java.lang.Runnable
        public final void run() {
            y.i();
        }
    };

    private y() {
    }

    public static final void a(final t tVar, final v vVar) {
        kotlin.jvm.internal.m.f(tVar, "accessTokenAppId");
        kotlin.jvm.internal.m.f(vVar, "appEvent");
        f10554e.execute(new Runnable() { // from class: com.facebook.o0.e
            @Override // java.lang.Runnable
            public final void run() {
                y.b(tVar, vVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(t tVar, v vVar) {
        kotlin.jvm.internal.m.f(tVar, "$accessTokenAppId");
        kotlin.jvm.internal.m.f(vVar, "$appEvent");
        f10553d.a(tVar, vVar);
        if (a0.a.d() != a0.b.EXPLICIT_ONLY && f10553d.d() > f10552c) {
            h(d0.EVENT_THRESHOLD);
        } else if (f10555f == null) {
            f10555f = f10554e.schedule(f10556g, 15L, TimeUnit.SECONDS);
        }
    }

    public static final GraphRequest c(final t tVar, final i0 i0Var, boolean z, final f0 f0Var) {
        kotlin.jvm.internal.m.f(tVar, "accessTokenAppId");
        kotlin.jvm.internal.m.f(i0Var, "appEvents");
        kotlin.jvm.internal.m.f(f0Var, "flushState");
        String strB = tVar.b();
        com.facebook.internal.d0 d0Var = com.facebook.internal.d0.a;
        com.facebook.internal.c0 c0VarO = com.facebook.internal.d0.o(strB, false);
        GraphRequest.c cVar = GraphRequest.a;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String str = String.format("%s/activities", Arrays.copyOf(new Object[]{strB}, 1));
        kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
        final GraphRequest graphRequestA = cVar.A(null, str, null, null);
        graphRequestA.E(true);
        Bundle bundleT = graphRequestA.t();
        if (bundleT == null) {
            bundleT = new Bundle();
        }
        bundleT.putString("access_token", tVar.a());
        String strD = g0.a.d();
        if (strD != null) {
            bundleT.putString("device_token", strD);
        }
        String strI = b0.a.i();
        if (strI != null) {
            bundleT.putString("install_referrer", strI);
        }
        graphRequestA.H(bundleT);
        boolean zN = c0VarO != null ? c0VarO.n() : false;
        com.facebook.a0 a0Var = com.facebook.a0.a;
        int iE = i0Var.e(graphRequestA, com.facebook.a0.c(), zN, z);
        if (iE == 0) {
            return null;
        }
        f0Var.c(f0Var.a() + iE);
        graphRequestA.D(new GraphRequest.b() { // from class: com.facebook.o0.f
            @Override // com.facebook.GraphRequest.b
            public final void b(com.facebook.d0 d0Var2) {
                y.d(tVar, graphRequestA, i0Var, f0Var, d0Var2);
            }
        });
        return graphRequestA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(t tVar, GraphRequest graphRequest, i0 i0Var, f0 f0Var, com.facebook.d0 d0Var) {
        kotlin.jvm.internal.m.f(tVar, "$accessTokenAppId");
        kotlin.jvm.internal.m.f(graphRequest, "$postRequest");
        kotlin.jvm.internal.m.f(i0Var, "$appEvents");
        kotlin.jvm.internal.m.f(f0Var, "$flushState");
        kotlin.jvm.internal.m.f(d0Var, "response");
        k(tVar, graphRequest, d0Var, i0Var, f0Var);
    }

    public static final List<GraphRequest> e(w wVar, f0 f0Var) {
        kotlin.jvm.internal.m.f(wVar, "appEventCollection");
        kotlin.jvm.internal.m.f(f0Var, "flushResults");
        com.facebook.a0 a0Var = com.facebook.a0.a;
        boolean zQ = com.facebook.a0.q(com.facebook.a0.c());
        ArrayList arrayList = new ArrayList();
        for (t tVar : wVar.f()) {
            i0 i0VarC = wVar.c(tVar);
            if (i0VarC == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            GraphRequest graphRequestC = c(tVar, i0VarC, zQ, f0Var);
            if (graphRequestC != null) {
                arrayList.add(graphRequestC);
                if (com.facebook.o0.l0.f.a.e()) {
                    com.facebook.o0.l0.h hVar = com.facebook.o0.l0.h.a;
                    com.facebook.o0.l0.h.l(graphRequestC);
                }
            }
        }
        return arrayList;
    }

    public static final void f(final d0 d0Var) {
        kotlin.jvm.internal.m.f(d0Var, "reason");
        f10554e.execute(new Runnable() { // from class: com.facebook.o0.g
            @Override // java.lang.Runnable
            public final void run() {
                y.g(d0Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(d0 d0Var) {
        kotlin.jvm.internal.m.f(d0Var, "$reason");
        h(d0Var);
    }

    public static final void h(d0 d0Var) {
        kotlin.jvm.internal.m.f(d0Var, "reason");
        x xVar = x.a;
        f10553d.b(x.a());
        try {
            f0 f0VarU = u(d0Var, f10553d);
            if (f0VarU != null) {
                Intent intent = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
                intent.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", f0VarU.a());
                intent.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", f0VarU.b());
                com.facebook.a0 a0Var = com.facebook.a0.a;
                c.q.a.a.b(com.facebook.a0.c()).d(intent);
            }
        } catch (Exception e2) {
            Log.w(f10551b, "Caught unexpected exception while flushing app events: ", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        f10555f = null;
        if (a0.a.d() != a0.b.EXPLICIT_ONLY) {
            h(d0.TIMER);
        }
    }

    public static final Set<t> j() {
        return f10553d.f();
    }

    public static final void k(final t tVar, GraphRequest graphRequest, com.facebook.d0 d0Var, final i0 i0Var, f0 f0Var) {
        String str;
        String string;
        kotlin.jvm.internal.m.f(tVar, "accessTokenAppId");
        kotlin.jvm.internal.m.f(graphRequest, "request");
        kotlin.jvm.internal.m.f(d0Var, "response");
        kotlin.jvm.internal.m.f(i0Var, "appEvents");
        kotlin.jvm.internal.m.f(f0Var, "flushState");
        FacebookRequestError facebookRequestErrorB = d0Var.b();
        e0 e0Var = e0.SUCCESS;
        if (facebookRequestErrorB == null) {
            str = AccountAnalytics.SUCCESS;
        } else if (facebookRequestErrorB.b() == -1) {
            e0Var = e0.NO_CONNECTIVITY;
            str = "Failed: No Connectivity";
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            str = String.format("Failed:\n  Response: %s\n  Error %s", Arrays.copyOf(new Object[]{d0Var.toString(), facebookRequestErrorB.toString()}, 2));
            kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
            e0Var = e0.SERVER_ERROR;
        }
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (com.facebook.a0.y(com.facebook.g0.APP_EVENTS)) {
            try {
                string = new JSONArray((String) graphRequest.v()).toString(2);
                kotlin.jvm.internal.m.e(string, "{\n            val jsonArray = JSONArray(eventsJsonString)\n            jsonArray.toString(2)\n          }");
            } catch (JSONException unused) {
                string = "<Can't encode events for debug logging>";
            }
            com.facebook.internal.j0.a aVar = com.facebook.internal.j0.a;
            com.facebook.g0 g0Var = com.facebook.g0.APP_EVENTS;
            String str2 = f10551b;
            kotlin.jvm.internal.m.e(str2, "TAG");
            aVar.c(g0Var, str2, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", String.valueOf(graphRequest.p()), str, string);
        }
        i0Var.b(facebookRequestErrorB != null);
        e0 e0Var2 = e0.NO_CONNECTIVITY;
        if (e0Var == e0Var2) {
            com.facebook.a0 a0Var2 = com.facebook.a0.a;
            com.facebook.a0.k().execute(new Runnable() { // from class: com.facebook.o0.h
                @Override // java.lang.Runnable
                public final void run() {
                    y.l(tVar, i0Var);
                }
            });
        }
        if (e0Var == e0.SUCCESS || f0Var.b() == e0Var2) {
            return;
        }
        f0Var.d(e0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(t tVar, i0 i0Var) {
        kotlin.jvm.internal.m.f(tVar, "$accessTokenAppId");
        kotlin.jvm.internal.m.f(i0Var, "$appEvents");
        z zVar = z.a;
        z.a(tVar, i0Var);
    }

    public static final void s() {
        f10554e.execute(new Runnable() { // from class: com.facebook.o0.c
            @Override // java.lang.Runnable
            public final void run() {
                y.t();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t() {
        z zVar = z.a;
        z.b(f10553d);
        f10553d = new w();
    }

    public static final f0 u(d0 d0Var, w wVar) {
        kotlin.jvm.internal.m.f(d0Var, "reason");
        kotlin.jvm.internal.m.f(wVar, "appEventCollection");
        f0 f0Var = new f0();
        List<GraphRequest> listE = e(wVar, f0Var);
        if (!(!listE.isEmpty())) {
            return null;
        }
        com.facebook.internal.j0.a aVar = com.facebook.internal.j0.a;
        com.facebook.g0 g0Var = com.facebook.g0.APP_EVENTS;
        String str = f10551b;
        kotlin.jvm.internal.m.e(str, "TAG");
        aVar.c(g0Var, str, "Flushing %d events due to %s.", Integer.valueOf(f0Var.a()), d0Var.toString());
        Iterator<GraphRequest> it = listE.iterator();
        while (it.hasNext()) {
            it.next().j();
        }
        return f0Var;
    }
}
