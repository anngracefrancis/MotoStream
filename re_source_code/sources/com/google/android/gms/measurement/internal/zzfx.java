package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzkn;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzfx implements s4 {
    private static volatile zzfx a;
    private long A;
    private volatile Boolean B;

    @VisibleForTesting
    private Boolean C;

    @VisibleForTesting
    private Boolean D;
    private int E;
    private final long G;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f18153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f18155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f18156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f18157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzw f18158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzx f18159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final r3 f18160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzet f18161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzfu f18162k;
    private final zzjl l;
    private final zzkk m;
    private final zzer n;
    private final Clock o;
    private final zzif p;
    private final zzhc q;
    private final zzb r;
    private final zzia s;
    private zzep t;
    private zzik u;
    private zzah v;
    private zzeq w;
    private zzfm x;
    private Boolean z;
    private boolean y = false;
    private AtomicInteger F = new AtomicInteger(0);

    private zzfx(zzgz zzgzVar) {
        Bundle bundle;
        boolean z = false;
        Preconditions.k(zzgzVar);
        zzw zzwVar = new zzw(zzgzVar.a);
        this.f18158g = zzwVar;
        zzap.e(zzwVar);
        Context context = zzgzVar.a;
        this.f18153b = context;
        this.f18154c = zzgzVar.f18169b;
        this.f18155d = zzgzVar.f18170c;
        this.f18156e = zzgzVar.f18171d;
        this.f18157f = zzgzVar.f18175h;
        this.B = zzgzVar.f18172e;
        com.google.android.gms.internal.measurement.zzv zzvVar = zzgzVar.f18174g;
        if (zzvVar != null && (bundle = zzvVar.l) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.C = (Boolean) obj;
            }
            Object obj2 = zzvVar.l.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.D = (Boolean) obj2;
            }
        }
        zzcl.h(context);
        Clock clockC = DefaultClock.c();
        this.o = clockC;
        this.G = clockC.a();
        this.f18159h = new zzx(this);
        r3 r3Var = new r3(this);
        r3Var.q();
        this.f18160i = r3Var;
        zzet zzetVar = new zzet(this);
        zzetVar.q();
        this.f18161j = zzetVar;
        zzkk zzkkVar = new zzkk(this);
        zzkkVar.q();
        this.m = zzkkVar;
        zzer zzerVar = new zzer(this);
        zzerVar.q();
        this.n = zzerVar;
        this.r = new zzb(this);
        zzif zzifVar = new zzif(this);
        zzifVar.y();
        this.p = zzifVar;
        zzhc zzhcVar = new zzhc(this);
        zzhcVar.y();
        this.q = zzhcVar;
        zzjl zzjlVar = new zzjl(this);
        zzjlVar.y();
        this.l = zzjlVar;
        zzia zziaVar = new zzia(this);
        zziaVar.q();
        this.s = zziaVar;
        zzfu zzfuVar = new zzfu(this);
        zzfuVar.q();
        this.f18162k = zzfuVar;
        com.google.android.gms.internal.measurement.zzv zzvVar2 = zzgzVar.f18174g;
        if (zzvVar2 != null && zzvVar2.f17566g != 0) {
            z = true;
        }
        boolean z2 = !z;
        if (context.getApplicationContext() instanceof Application) {
            zzhc zzhcVarH = H();
            if (zzhcVarH.f().getApplicationContext() instanceof Application) {
                Application application = (Application) zzhcVarH.f().getApplicationContext();
                if (zzhcVarH.f18176c == null) {
                    zzhcVarH.f18176c = new l5(zzhcVarH, null);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(zzhcVarH.f18176c);
                    application.registerActivityLifecycleCallbacks(zzhcVarH.f18176c);
                    zzhcVarH.h().P().a("Registered activity lifecycle callback");
                }
            }
        } else {
            h().K().a("Application context is not an Application");
        }
        zzfuVar.z(new y3(this, zzgzVar));
    }

    private static void A(q4 q4Var) {
        if (q4Var == null) {
            throw new IllegalStateException("Component not created");
        }
        if (q4Var.t()) {
            return;
        }
        String strValueOf = String.valueOf(q4Var.getClass());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 27);
        sb.append("Component not initialized: ");
        sb.append(strValueOf);
        throw new IllegalStateException(sb.toString());
    }

    public static zzfx a(Context context, com.google.android.gms.internal.measurement.zzv zzvVar) {
        Bundle bundle;
        if (zzvVar != null && (zzvVar.f17569j == null || zzvVar.f17570k == null)) {
            zzvVar = new com.google.android.gms.internal.measurement.zzv(zzvVar.f17565f, zzvVar.f17566g, zzvVar.f17567h, zzvVar.f17568i, null, null, zzvVar.l);
        }
        Preconditions.k(context);
        Preconditions.k(context.getApplicationContext());
        if (a == null) {
            synchronized (zzfx.class) {
                if (a == null) {
                    a = new zzfx(new zzgz(context, zzvVar));
                }
            }
        } else if (zzvVar != null && (bundle = zzvVar.l) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            a.n(zzvVar.l.getBoolean("dataCollectionDefaultEnabled"));
        }
        return a;
    }

    @VisibleForTesting
    public static zzfx b(Context context, String str, String str2, Bundle bundle) {
        return a(context, new com.google.android.gms.internal.measurement.zzv(0L, 0L, true, null, null, null, bundle));
    }

    private static void k(r4 r4Var) {
        if (r4Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(zzgz zzgzVar) {
        String strConcat;
        zzev zzevVarN;
        g().d();
        zzx.z();
        zzah zzahVar = new zzah(this);
        zzahVar.q();
        this.v = zzahVar;
        zzeq zzeqVar = new zzeq(this, zzgzVar.f18173f);
        zzeqVar.y();
        this.w = zzeqVar;
        zzep zzepVar = new zzep(this);
        zzepVar.y();
        this.t = zzepVar;
        zzik zzikVar = new zzik(this);
        zzikVar.y();
        this.u = zzikVar;
        this.m.r();
        this.f18160i.r();
        this.x = new zzfm(this);
        this.w.z();
        h().N().b("App measurement is starting up, version", Long.valueOf(this.f18159h.C()));
        h().N().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strC = zzeqVar.C();
        if (TextUtils.isEmpty(this.f18154c)) {
            if (I().v0(strC)) {
                zzevVarN = h().N();
                strConcat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzev zzevVarN2 = h().N();
                String strValueOf = String.valueOf(strC);
                strConcat = strValueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(strValueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
                zzevVarN = zzevVarN2;
            }
            zzevVarN.a(strConcat);
        }
        h().O().a("Debug-level message logging enabled");
        if (this.E != this.F.get()) {
            h().H().c("Not all components initialized", Integer.valueOf(this.E), Integer.valueOf(this.F.get()));
        }
        this.y = true;
    }

    private final zzia w() {
        A(this.s);
        return this.s;
    }

    private final void x() {
        if (!this.y) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    private static void z(u2 u2Var) {
        if (u2Var == null) {
            throw new IllegalStateException("Component not created");
        }
        if (u2Var.w()) {
            return;
        }
        String strValueOf = String.valueOf(u2Var.getClass());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 27);
        sb.append("Component not initialized: ");
        sb.append(strValueOf);
        throw new IllegalStateException(sb.toString());
    }

    public final r3 B() {
        k(this.f18160i);
        return this.f18160i;
    }

    public final zzet C() {
        zzet zzetVar = this.f18161j;
        if (zzetVar == null || !zzetVar.t()) {
            return null;
        }
        return this.f18161j;
    }

    public final zzjl D() {
        z(this.l);
        return this.l;
    }

    public final zzfm E() {
        return this.x;
    }

    final zzfu F() {
        return this.f18162k;
    }

    @Override // com.google.android.gms.measurement.internal.s4
    public final zzw G() {
        return this.f18158g;
    }

    public final zzhc H() {
        z(this.q);
        return this.q;
    }

    public final zzkk I() {
        k(this.m);
        return this.m;
    }

    public final zzer J() {
        k(this.n);
        return this.n;
    }

    public final zzep K() {
        z(this.t);
        return this.t;
    }

    public final boolean L() {
        return TextUtils.isEmpty(this.f18154c);
    }

    public final String M() {
        return this.f18154c;
    }

    public final String N() {
        return this.f18155d;
    }

    public final String O() {
        return this.f18156e;
    }

    public final boolean P() {
        return this.f18157f;
    }

    public final zzif Q() {
        z(this.p);
        return this.p;
    }

    public final zzik R() {
        z(this.u);
        return this.u;
    }

    public final zzah S() {
        A(this.v);
        return this.v;
    }

    public final zzeq T() {
        z(this.w);
        return this.w;
    }

    public final zzb U() {
        zzb zzbVar = this.r;
        if (zzbVar != null) {
            return zzbVar;
        }
        throw new IllegalStateException("Component not created");
    }

    protected final void c() {
        g().d();
        if (B().f17922f.a() == 0) {
            B().f17922f.b(this.o.a());
        }
        if (Long.valueOf(B().f17927k.a()).longValue() == 0) {
            h().P().b("Persisting first open", Long.valueOf(this.G));
            B().f17927k.b(this.G);
        }
        if (u()) {
            if (!TextUtils.isEmpty(T().D()) || !TextUtils.isEmpty(T().E())) {
                I();
                if (zzkk.d0(T().D(), B().E(), T().E(), B().F())) {
                    h().N().a("Rechecking which service to use due to a GMP App Id change");
                    B().I();
                    K().I();
                    this.u.b0();
                    this.u.Z();
                    B().f17927k.b(this.G);
                    B().m.b(null);
                }
                B().A(T().D());
                B().C(T().E());
            }
            H().O(B().m.a());
            if (zzkb.b() && this.f18159h.r(zzap.X0) && !I().D0() && !TextUtils.isEmpty(B().C.a())) {
                h().K().a("Remote config removed with active feature rollouts");
                B().C.b(null);
            }
            if (!TextUtils.isEmpty(T().D()) || !TextUtils.isEmpty(T().E())) {
                boolean zP = p();
                if (!B().M() && !this.f18159h.I()) {
                    B().D(!zP);
                }
                if (zP) {
                    H().h0();
                }
                a7 a7Var = D().f18203d;
                if (a7Var.f17699b.n().R(a7Var.f17699b.q().C()) && zzkn.b() && a7Var.f17699b.n().B(a7Var.f17699b.q().C(), zzap.g0)) {
                    a7Var.f17699b.d();
                    if (a7Var.f17699b.m().x(a7Var.f17699b.j().a())) {
                        a7Var.f17699b.m().s.a(true);
                        if (Build.VERSION.SDK_INT >= 16) {
                            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                            ActivityManager.getMyMemoryState(runningAppProcessInfo);
                            if (runningAppProcessInfo.importance == 100) {
                                a7Var.f17699b.h().P().a("Detected application was in foreground");
                                a7Var.c(a7Var.f17699b.j().a(), false);
                            }
                        }
                    }
                }
                R().S(new AtomicReference<>());
            }
        } else if (p()) {
            if (!I().s0("android.permission.INTERNET")) {
                h().H().a("App is missing INTERNET permission");
            }
            if (!I().s0("android.permission.ACCESS_NETWORK_STATE")) {
                h().H().a("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!Wrappers.a(this.f18153b).f() && !this.f18159h.Y()) {
                if (!zzfn.b(this.f18153b)) {
                    h().H().a("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzkk.U(this.f18153b, false)) {
                    h().H().a("AppMeasurementService not registered/enabled");
                }
            }
            h().H().a("Uploading is not possible. App measurement disabled");
        }
        B().u.a(this.f18159h.r(zzap.s0));
        B().v.a(this.f18159h.r(zzap.t0));
    }

    final void d(u2 u2Var) {
        this.E++;
    }

    @Override // com.google.android.gms.measurement.internal.s4
    public final Context f() {
        return this.f18153b;
    }

    @Override // com.google.android.gms.measurement.internal.s4
    public final zzfu g() {
        A(this.f18162k);
        return this.f18162k;
    }

    @Override // com.google.android.gms.measurement.internal.s4
    public final zzet h() {
        A(this.f18161j);
        return this.f18161j;
    }

    final void i(q4 q4Var) {
        this.E++;
    }

    @Override // com.google.android.gms.measurement.internal.s4
    public final Clock j() {
        return this.o;
    }

    final /* synthetic */ void m(String str, int i2, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> listQueryIntentActivities;
        boolean z = true;
        if (!((i2 == 200 || i2 == 204 || i2 == 304) && th == null)) {
            h().K().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
            return;
        }
        B().A.a(true);
        if (bArr.length == 0) {
            h().O().a("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String strOptString = jSONObject.optString(DeepLinkIntentReceiver.DEEP_LINK, HttpUrl.FRAGMENT_ENCODE_SET);
            String strOptString2 = jSONObject.optString("gclid", HttpUrl.FRAGMENT_ENCODE_SET);
            double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(strOptString)) {
                h().O().a("Deferred Deep Link is empty.");
                return;
            }
            zzkk zzkkVarI = I();
            zzkkVarI.b();
            if (TextUtils.isEmpty(strOptString) || (listQueryIntentActivities = zzkkVarI.f().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(strOptString)), 0)) == null || listQueryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                h().K().c("Deferred Deep Link validation failed. gclid, deep link", strOptString2, strOptString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", strOptString2);
            bundle.putString("_cis", "ddp");
            this.q.S("auto", "_cmp", bundle);
            zzkk zzkkVarI2 = I();
            if (TextUtils.isEmpty(strOptString) || !zzkkVarI2.Z(strOptString, dOptDouble)) {
                return;
            }
            zzkkVarI2.f().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
        } catch (JSONException e2) {
            h().H().b("Failed to parse the Deferred Deep Link response. exception", e2);
        }
    }

    final void n(boolean z) {
        this.B = Boolean.valueOf(z);
    }

    public final boolean o() {
        return this.B != null && this.B.booleanValue();
    }

    public final boolean p() {
        boolean zBooleanValue;
        g().d();
        x();
        if (!this.f18159h.r(zzap.m0)) {
            if (this.f18159h.I()) {
                return false;
            }
            Boolean boolJ = this.f18159h.J();
            if (boolJ != null) {
                zBooleanValue = boolJ.booleanValue();
            } else {
                zBooleanValue = !GoogleServices.d();
                if (zBooleanValue && this.B != null && zzap.h0.a(null).booleanValue()) {
                    zBooleanValue = this.B.booleanValue();
                }
            }
            return B().B(zBooleanValue);
        }
        if (this.f18159h.I()) {
            return false;
        }
        Boolean bool = this.D;
        if (bool != null && bool.booleanValue()) {
            return false;
        }
        Boolean boolJ2 = B().J();
        if (boolJ2 != null) {
            return boolJ2.booleanValue();
        }
        Boolean boolJ3 = this.f18159h.J();
        if (boolJ3 != null) {
            return boolJ3.booleanValue();
        }
        Boolean bool2 = this.C;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        if (GoogleServices.d()) {
            return false;
        }
        if (!this.f18159h.r(zzap.h0) || this.B == null) {
            return true;
        }
        return this.B.booleanValue();
    }

    final long q() {
        Long lValueOf = Long.valueOf(B().f17927k.a());
        return lValueOf.longValue() == 0 ? this.G : Math.min(this.G, lValueOf.longValue());
    }

    final void r() {
    }

    final void s() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    final void t() {
        this.F.incrementAndGet();
    }

    protected final boolean u() {
        x();
        g().d();
        Boolean bool = this.z;
        if (bool == null || this.A == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.o.b() - this.A) > 1000)) {
            this.A = this.o.b();
            boolean z = true;
            Boolean boolValueOf = Boolean.valueOf(I().s0("android.permission.INTERNET") && I().s0("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.a(this.f18153b).f() || this.f18159h.Y() || (zzfn.b(this.f18153b) && zzkk.U(this.f18153b, false))));
            this.z = boolValueOf;
            if (boolValueOf.booleanValue()) {
                if (!I().r0(T().D(), T().E()) && TextUtils.isEmpty(T().E())) {
                    z = false;
                }
                this.z = Boolean.valueOf(z);
            }
        }
        return this.z.booleanValue();
    }

    public final void v() {
        g().d();
        A(w());
        String strC = T().C();
        Pair<String, Boolean> pairV = B().v(strC);
        if (!this.f18159h.L().booleanValue() || ((Boolean) pairV.second).booleanValue() || TextUtils.isEmpty((CharSequence) pairV.first)) {
            h().O().a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        if (!w().x()) {
            h().K().a("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        URL urlH = I().H(T().n().C(), strC, (String) pairV.first, B().B.a() - 1);
        zzia zziaVarW = w();
        o5 o5Var = new o5(this) { // from class: com.google.android.gms.measurement.internal.a4
            private final zzfx a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.measurement.internal.o5
            public final void a(String str, int i2, Throwable th, byte[] bArr, Map map) {
                this.a.m(str, i2, th, bArr, map);
            }
        };
        zziaVarW.d();
        zziaVarW.p();
        Preconditions.k(urlH);
        Preconditions.k(o5Var);
        zziaVarW.g().C(new r5(zziaVarW, strC, urlH, null, null, o5Var));
    }

    public final zzx y() {
        return this.f18159h;
    }
}
