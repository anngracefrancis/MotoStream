package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import cm.aptoide.pt.notification.PullingContentService;
import com.facebook.internal.p0;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AccessTokenManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class v {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static v f10572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c.q.a.a f10573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final u f10574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AccessToken f10575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f10576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Date f10577g;

    /* JADX INFO: compiled from: AccessTokenManager.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GraphRequest c(AccessToken accessToken, GraphRequest.b bVar) {
            e eVarF = f(accessToken);
            Bundle bundle = new Bundle();
            bundle.putString("grant_type", eVarF.a());
            bundle.putString("client_id", accessToken.c());
            bundle.putString("fields", "access_token,expires_at,expires_in,data_access_expiration_time,graph_domain");
            GraphRequest graphRequestX = GraphRequest.a.x(accessToken, eVarF.b(), bVar);
            graphRequestX.H(bundle);
            graphRequestX.G(e0.GET);
            return graphRequestX;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GraphRequest d(AccessToken accessToken, GraphRequest.b bVar) {
            Bundle bundle = new Bundle();
            bundle.putString("fields", "permission,status");
            GraphRequest graphRequestX = GraphRequest.a.x(accessToken, "me/permissions", bVar);
            graphRequestX.H(bundle);
            graphRequestX.G(e0.GET);
            return graphRequestX;
        }

        private final e f(AccessToken accessToken) {
            String strH = accessToken.h();
            if (strH == null) {
                strH = "facebook";
            }
            return kotlin.jvm.internal.m.a(strH, "instagram") ? new c() : new b();
        }

        public final v e() {
            v vVar;
            v vVar2 = v.f10572b;
            if (vVar2 != null) {
                return vVar2;
            }
            synchronized (this) {
                vVar = v.f10572b;
                if (vVar == null) {
                    a0 a0Var = a0.a;
                    c.q.a.a aVarB = c.q.a.a.b(a0.c());
                    kotlin.jvm.internal.m.e(aVarB, "getInstance(applicationContext)");
                    v vVar3 = new v(aVarB, new u());
                    a aVar = v.a;
                    v.f10572b = vVar3;
                    vVar = vVar3;
                }
            }
            return vVar;
        }
    }

    /* JADX INFO: compiled from: AccessTokenManager.kt */
    public static final class b implements e {
        private final String a = "oauth/access_token";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10578b = "fb_extend_sso_token";

        @Override // com.facebook.v.e
        public String a() {
            return this.f10578b;
        }

        @Override // com.facebook.v.e
        public String b() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: AccessTokenManager.kt */
    public static final class c implements e {
        private final String a = "refresh_access_token";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10579b = "ig_refresh_token";

        @Override // com.facebook.v.e
        public String a() {
            return this.f10579b;
        }

        @Override // com.facebook.v.e
        public String b() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AccessTokenManager.kt */
    static final class d {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f10580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f10581c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Long f10582d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f10583e;

        public final String a() {
            return this.a;
        }

        public final Long b() {
            return this.f10582d;
        }

        public final int c() {
            return this.f10580b;
        }

        public final int d() {
            return this.f10581c;
        }

        public final String e() {
            return this.f10583e;
        }

        public final void f(String str) {
            this.a = str;
        }

        public final void g(Long l) {
            this.f10582d = l;
        }

        public final void h(int i2) {
            this.f10580b = i2;
        }

        public final void i(int i2) {
            this.f10581c = i2;
        }

        public final void j(String str) {
            this.f10583e = str;
        }
    }

    /* JADX INFO: compiled from: AccessTokenManager.kt */
    public interface e {
        String a();

        String b();
    }

    public v(c.q.a.a aVar, u uVar) {
        kotlin.jvm.internal.m.f(aVar, "localBroadcastManager");
        kotlin.jvm.internal.m.f(uVar, "accessTokenCache");
        this.f10573c = aVar;
        this.f10574d = uVar;
        this.f10576f = new AtomicBoolean(false);
        this.f10577g = new Date(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(v vVar, AccessToken.a aVar) {
        kotlin.jvm.internal.m.f(vVar, "this$0");
        vVar.m(aVar);
    }

    private final void m(final AccessToken.a aVar) {
        final AccessToken accessTokenE = e();
        if (accessTokenE == null) {
            if (aVar == null) {
                return;
            }
            aVar.a(new FacebookException("No current access token to refresh"));
            return;
        }
        if (!this.f10576f.compareAndSet(false, true)) {
            if (aVar == null) {
                return;
            }
            aVar.a(new FacebookException("Refresh already in progress"));
            return;
        }
        this.f10577g = new Date();
        final HashSet hashSet = new HashSet();
        final HashSet hashSet2 = new HashSet();
        final HashSet hashSet3 = new HashSet();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final d dVar = new d();
        a aVar2 = a;
        c0 c0Var = new c0(aVar2.d(accessTokenE, new GraphRequest.b() { // from class: com.facebook.d
            @Override // com.facebook.GraphRequest.b
            public final void b(d0 d0Var) {
                v.n(atomicBoolean, hashSet, hashSet2, hashSet3, d0Var);
            }
        }), aVar2.c(accessTokenE, new GraphRequest.b() { // from class: com.facebook.b
            @Override // com.facebook.GraphRequest.b
            public final void b(d0 d0Var) {
                v.o(dVar, d0Var);
            }
        }));
        c0Var.g(new c0.a() { // from class: com.facebook.c
            @Override // com.facebook.c0.a
            public final void a(c0 c0Var2) throws Throwable {
                v.p(dVar, accessTokenE, aVar, atomicBoolean, hashSet, hashSet2, hashSet3, this, c0Var2);
            }
        });
        c0Var.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x00a4  */
    public static final void n(AtomicBoolean atomicBoolean, Set set, Set set2, Set set3, d0 d0Var) {
        JSONArray jSONArrayOptJSONArray;
        kotlin.jvm.internal.m.f(atomicBoolean, "$permissionsCallSucceeded");
        kotlin.jvm.internal.m.f(set, "$permissions");
        kotlin.jvm.internal.m.f(set2, "$declinedPermissions");
        kotlin.jvm.internal.m.f(set3, "$expiredPermissions");
        kotlin.jvm.internal.m.f(d0Var, "response");
        JSONObject jSONObjectD = d0Var.d();
        if (jSONObjectD == null || (jSONArrayOptJSONArray = jSONObjectD.optJSONArray("data")) == null) {
            return;
        }
        atomicBoolean.set(true);
        int i2 = 0;
        int length = jSONArrayOptJSONArray.length();
        if (length <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("permission");
                String strOptString2 = jSONObjectOptJSONObject.optString("status");
                p0 p0Var = p0.a;
                if (!p0.a0(strOptString) && !p0.a0(strOptString2)) {
                    kotlin.jvm.internal.m.e(strOptString2, "status");
                    Locale locale = Locale.US;
                    kotlin.jvm.internal.m.e(locale, "US");
                    String lowerCase = strOptString2.toLowerCase(locale);
                    kotlin.jvm.internal.m.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    kotlin.jvm.internal.m.e(lowerCase, "status");
                    int iHashCode = lowerCase.hashCode();
                    if (iHashCode != -1309235419) {
                        if (iHashCode != 280295099) {
                            if (iHashCode == 568196142 && lowerCase.equals("declined")) {
                                set2.add(strOptString);
                            } else {
                                Log.w("AccessTokenManager", kotlin.jvm.internal.m.n("Unexpected status: ", lowerCase));
                            }
                        } else if (lowerCase.equals("granted")) {
                            set.add(strOptString);
                        } else {
                            Log.w("AccessTokenManager", kotlin.jvm.internal.m.n("Unexpected status: ", lowerCase));
                        }
                    } else if (lowerCase.equals("expired")) {
                        set3.add(strOptString);
                    } else {
                        Log.w("AccessTokenManager", kotlin.jvm.internal.m.n("Unexpected status: ", lowerCase));
                    }
                }
            }
            if (i3 >= length) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(d dVar, d0 d0Var) {
        kotlin.jvm.internal.m.f(dVar, "$refreshResult");
        kotlin.jvm.internal.m.f(d0Var, "response");
        JSONObject jSONObjectD = d0Var.d();
        if (jSONObjectD == null) {
            return;
        }
        dVar.f(jSONObjectD.optString("access_token"));
        dVar.h(jSONObjectD.optInt("expires_at"));
        dVar.i(jSONObjectD.optInt("expires_in"));
        dVar.g(Long.valueOf(jSONObjectD.optLong("data_access_expiration_time")));
        dVar.j(jSONObjectD.optString("graph_domain", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(d dVar, AccessToken accessToken, AccessToken.a aVar, AtomicBoolean atomicBoolean, Set set, Set set2, Set set3, v vVar, c0 c0Var) throws Throwable {
        AccessToken accessToken2;
        kotlin.jvm.internal.m.f(dVar, "$refreshResult");
        kotlin.jvm.internal.m.f(atomicBoolean, "$permissionsCallSucceeded");
        kotlin.jvm.internal.m.f(set, "$permissions");
        kotlin.jvm.internal.m.f(set2, "$declinedPermissions");
        kotlin.jvm.internal.m.f(set3, "$expiredPermissions");
        kotlin.jvm.internal.m.f(vVar, "this$0");
        kotlin.jvm.internal.m.f(c0Var, "it");
        String strA = dVar.a();
        int iC = dVar.c();
        Long lB = dVar.b();
        String strE = dVar.e();
        try {
            a aVar2 = a;
            if (aVar2.e().e() != null) {
                AccessToken accessTokenE = aVar2.e().e();
                if ((accessTokenE == null ? null : accessTokenE.m()) == accessToken.m()) {
                    if (!atomicBoolean.get() && strA == null && iC == 0) {
                        if (aVar != null) {
                            aVar.a(new FacebookException("Failed to refresh access token"));
                        }
                        vVar.f10576f.set(false);
                        return;
                    }
                    Date dateG = accessToken.g();
                    if (dVar.c() != 0) {
                        dateG = new Date(((long) dVar.c()) * 1000);
                    } else if (dVar.d() != 0) {
                        dateG = new Date((((long) dVar.d()) * 1000) + new Date().getTime());
                    }
                    Date date = dateG;
                    if (strA == null) {
                        strA = accessToken.l();
                    }
                    String str = strA;
                    String strC = accessToken.c();
                    String strM = accessToken.m();
                    Set setJ = atomicBoolean.get() ? set : accessToken.j();
                    Set setE = atomicBoolean.get() ? set2 : accessToken.e();
                    Set setF = atomicBoolean.get() ? set3 : accessToken.f();
                    w wVarK = accessToken.k();
                    Date date2 = new Date();
                    Date date3 = lB != null ? new Date(lB.longValue() * 1000) : accessToken.d();
                    if (strE == null) {
                        strE = accessToken.h();
                    }
                    AccessToken accessToken3 = new AccessToken(str, strC, strM, setJ, setE, setF, wVarK, date, date2, date3, strE);
                    try {
                        aVar2.e().r(accessToken3);
                        vVar.f10576f.set(false);
                        if (aVar != null) {
                            aVar.b(accessToken3);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        accessToken2 = accessToken3;
                        vVar.f10576f.set(false);
                        if (aVar != null && accessToken2 != null) {
                            aVar.b(accessToken2);
                        }
                        throw th;
                    }
                }
            }
            if (aVar != null) {
                aVar.a(new FacebookException("No current access token to refresh"));
            }
            vVar.f10576f.set(false);
        } catch (Throwable th2) {
            th = th2;
            accessToken2 = null;
        }
    }

    private final void q(AccessToken accessToken, AccessToken accessToken2) {
        a0 a0Var = a0.a;
        Intent intent = new Intent(a0.c(), (Class<?>) CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", accessToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accessToken2);
        this.f10573c.d(intent);
    }

    private final void s(AccessToken accessToken, boolean z) {
        AccessToken accessToken2 = this.f10575e;
        this.f10575e = accessToken;
        this.f10576f.set(false);
        this.f10577g = new Date(0L);
        if (z) {
            if (accessToken != null) {
                this.f10574d.g(accessToken);
            } else {
                this.f10574d.a();
                p0 p0Var = p0.a;
                a0 a0Var = a0.a;
                p0.g(a0.c());
            }
        }
        p0 p0Var2 = p0.a;
        if (p0.c(accessToken2, accessToken)) {
            return;
        }
        q(accessToken2, accessToken);
        t();
    }

    private final void t() {
        a0 a0Var = a0.a;
        Context contextC = a0.c();
        AccessToken.c cVar = AccessToken.f9559f;
        AccessToken accessTokenE = cVar.e();
        AlarmManager alarmManager = (AlarmManager) contextC.getSystemService("alarm");
        if (cVar.g()) {
            if ((accessTokenE == null ? null : accessTokenE.g()) == null || alarmManager == null) {
                return;
            }
            Intent intent = new Intent(contextC, (Class<?>) CurrentAccessTokenExpirationBroadcastReceiver.class);
            intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
            try {
                alarmManager.set(1, accessTokenE.g().getTime(), Build.VERSION.SDK_INT >= 23 ? PendingIntent.getBroadcast(contextC, 0, intent, 67108864) : PendingIntent.getBroadcast(contextC, 0, intent, 0));
            } catch (Exception unused) {
            }
        }
    }

    private final boolean u() {
        AccessToken accessTokenE = e();
        if (accessTokenE == null) {
            return false;
        }
        long time = new Date().getTime();
        return accessTokenE.k().k() && time - this.f10577g.getTime() > 3600000 && time - accessTokenE.i().getTime() > PullingContentService.UPDATES_INTERVAL;
    }

    public final void c() {
        q(e(), e());
    }

    public final void d() {
        if (u()) {
            k(null);
        }
    }

    public final AccessToken e() {
        return this.f10575e;
    }

    public final boolean j() {
        AccessToken accessTokenF = this.f10574d.f();
        if (accessTokenF == null) {
            return false;
        }
        s(accessTokenF, false);
        return true;
    }

    public final void k(final AccessToken.a aVar) {
        if (kotlin.jvm.internal.m.a(Looper.getMainLooper(), Looper.myLooper())) {
            m(aVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.a
                @Override // java.lang.Runnable
                public final void run() {
                    v.l(this.f9642f, aVar);
                }
            });
        }
    }

    public final void r(AccessToken accessToken) {
        s(accessToken, true);
    }
}
