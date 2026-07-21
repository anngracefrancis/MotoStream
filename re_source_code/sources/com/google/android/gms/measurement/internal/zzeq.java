package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.measurement.zzky;
import com.google.android.gms.internal.measurement.zzmo;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeq extends u2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f18093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f18094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f18095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f18096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f18097g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f18098h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f18099i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f18100j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<String> f18101k;
    private int l;
    private String m;
    private String n;
    private String o;

    zzeq(zzfx zzfxVar, long j2) {
        super(zzfxVar);
        this.f18100j = j2;
    }

    @VisibleForTesting
    private final String J() {
        if (zzmo.b() && n().r(zzap.Q0)) {
            h().P().a("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> clsLoadClass = f().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (clsLoadClass == null) {
                return null;
            }
            try {
                Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, f());
                if (objInvoke == null) {
                    return null;
                }
                try {
                    return (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                } catch (Exception unused) {
                    h().M().a("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                h().L().a("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    @Override // com.google.android.gms.measurement.internal.u2
    protected final boolean A() {
        return true;
    }

    final zzm B(String str) {
        String str2;
        Boolean boolU;
        d();
        b();
        String strC = C();
        String strD = D();
        x();
        String str3 = this.f18094d;
        long jF = F();
        x();
        String str4 = this.f18096f;
        long jC = n().C();
        x();
        d();
        if (this.f18098h == 0) {
            this.f18098h = this.a.I().w(f(), f().getPackageName());
        }
        long j2 = this.f18098h;
        boolean zP = this.a.p();
        boolean z = !m().y;
        d();
        b();
        String strJ = !this.a.p() ? null : J();
        x();
        long j3 = this.f18099i;
        long jQ = this.a.q();
        int iH = H();
        boolean zBooleanValue = n().L().booleanValue();
        zzx zzxVarN = n();
        zzxVarN.b();
        Boolean boolU2 = zzxVarN.u("google_analytics_ssaid_collection_enabled");
        boolean zBooleanValue2 = Boolean.valueOf(boolU2 == null || boolU2.booleanValue()).booleanValue();
        boolean zL = m().L();
        String strE = E();
        Boolean boolValueOf = (!n().B(C(), zzap.k0) || (boolU = n().u("google_analytics_default_allow_ad_personalization_signals")) == null) ? null : Boolean.valueOf(!boolU.booleanValue());
        long j4 = this.f18100j;
        List<String> list = n().B(C(), zzap.v0) ? this.f18101k : null;
        if (zzky.b() && n().B(C(), zzap.N0)) {
            x();
            str2 = this.o;
        } else {
            str2 = null;
        }
        return new zzm(strC, strD, str3, jF, str4, jC, j2, str, zP, z, strJ, j3, jQ, iH, zBooleanValue, zBooleanValue2, zL, strE, boolValueOf, j4, list, str2);
    }

    final String C() {
        x();
        return this.f18093c;
    }

    final String D() {
        x();
        return this.m;
    }

    final String E() {
        x();
        return this.n;
    }

    final int F() {
        x();
        return this.f18095e;
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    final int H() {
        x();
        return this.l;
    }

    final List<String> I() {
        return this.f18101k;
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzah e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Context f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzfu g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzet h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Clock j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzer k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzkk l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ r3 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzx n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzb o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzhc p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzeq q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzik r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzif s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzep t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzjl u() {
        return super.u();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0254  */
    /* JADX WARN: Code duplicated, block: B:103:0x025e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0273  */
    /* JADX WARN: Code duplicated, block: B:110:0x027b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x027d  */
    /* JADX WARN: Code duplicated, block: B:113:0x0288  */
    /* JADX WARN: Code duplicated, block: B:115:0x028b  */
    /* JADX WARN: Code duplicated, block: B:126:0x0252 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:? A[LOOP:0: B:101:0x0258->B:127:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:37:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:44:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:46:0x0110  */
    /* JADX WARN: Code duplicated, block: B:48:0x0118  */
    /* JADX WARN: Code duplicated, block: B:49:0x0126  */
    /* JADX WARN: Code duplicated, block: B:55:0x0144 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x0146  */
    /* JADX WARN: Code duplicated, block: B:60:0x0169  */
    /* JADX WARN: Code duplicated, block: B:68:0x019f  */
    /* JADX WARN: Code duplicated, block: B:69:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:84:0x01e4 A[Catch: IllegalStateException -> 0x020d, TryCatch #3 {IllegalStateException -> 0x020d, blocks: (B:66:0x0195, B:70:0x01a2, B:73:0x01ac, B:75:0x01b8, B:79:0x01cf, B:81:0x01d7, B:88:0x01fb, B:83:0x01dd, B:84:0x01e4, B:86:0x01ea), top: B:123:0x0195 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01ea A[Catch: IllegalStateException -> 0x020d, TryCatch #3 {IllegalStateException -> 0x020d, blocks: (B:66:0x0195, B:70:0x01a2, B:73:0x01ac, B:75:0x01b8, B:79:0x01cf, B:81:0x01d7, B:88:0x01fb, B:83:0x01dd, B:84:0x01e4, B:86:0x01ea), top: B:123:0x0195 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01fb A[Catch: IllegalStateException -> 0x020d, TRY_LEAVE, TryCatch #3 {IllegalStateException -> 0x020d, blocks: (B:66:0x0195, B:70:0x01a2, B:73:0x01ac, B:75:0x01b8, B:79:0x01cf, B:81:0x01d7, B:88:0x01fb, B:83:0x01dd, B:84:0x01e4, B:86:0x01ea), top: B:123:0x0195 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0230  */
    /* JADX WARN: Code duplicated, block: B:96:0x023f  */
    /* JADX WARN: Code duplicated, block: B:98:0x0245  */
    @Override // com.google.android.gms.measurement.internal.u2
    protected final void v() {
        String str;
        String string;
        Status statusC;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        List<String> listW;
        Iterator<String> it;
        String strB;
        String str2;
        Boolean boolJ;
        String packageName = f().getPackageName();
        PackageManager packageManager = f().getPackageManager();
        String str3 = "Unknown";
        String str4 = HttpUrl.FRAGMENT_ENCODE_SET;
        String installerPackageName = "unknown";
        int i2 = Integer.MIN_VALUE;
        try {
            if (packageManager != null) {
                try {
                    installerPackageName = packageManager.getInstallerPackageName(packageName);
                } catch (IllegalArgumentException unused) {
                    h().H().b("Error retrieving app installer package name. appId", zzet.x(packageName));
                }
                if (installerPackageName == null) {
                    installerPackageName = "manual_install";
                } else if ("com.android.vending".equals(installerPackageName)) {
                    installerPackageName = HttpUrl.FRAGMENT_ENCODE_SET;
                }
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(f().getPackageName(), 0);
                    if (packageInfo != null) {
                        CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                        string = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : "Unknown";
                        try {
                            str3 = packageInfo.versionName;
                            i2 = packageInfo.versionCode;
                        } catch (PackageManager.NameNotFoundException unused2) {
                            str = str3;
                            str3 = string;
                            h().H().c("Error retrieving package info. appId, appName", zzet.x(packageName), str3);
                            string = str3;
                            str3 = str;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused3) {
                    str = "Unknown";
                }
                this.f18093c = packageName;
                this.f18096f = installerPackageName;
                this.f18094d = str3;
                this.f18095e = i2;
                this.f18097g = string;
                this.f18098h = 0L;
                G();
                statusC = GoogleServices.c(f());
                z = true;
                if (statusC == null && statusC.e0()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (TextUtils.isEmpty(this.a.M()) && "am".equals(this.a.N())) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 = z2 | z3;
                if (!z4) {
                    if (statusC == null) {
                        h().H().a("GoogleService failed to initialize (no status)");
                    } else {
                        h().H().c("GoogleService failed to initialize, status", Integer.valueOf(statusC.z()), statusC.W());
                    }
                }
                if (z4) {
                    boolJ = n().J();
                    if (n().I()) {
                        if (this.a.L()) {
                            h().N().a("Collection disabled with firebase_analytics_collection_deactivated=1");
                        }
                    } else if (boolJ != null || boolJ.booleanValue()) {
                        if (boolJ == null || !GoogleServices.d()) {
                            h().P().a("Collection enabled");
                            z5 = true;
                        } else {
                            h().N().a("Collection disabled with google_app_measurement_enable=0");
                        }
                    } else if (this.a.L()) {
                        h().N().a("Collection disabled with firebase_analytics_collection_enabled=0");
                    }
                    z5 = false;
                } else {
                    z5 = false;
                }
                this.m = HttpUrl.FRAGMENT_ENCODE_SET;
                this.n = HttpUrl.FRAGMENT_ENCODE_SET;
                this.o = HttpUrl.FRAGMENT_ENCODE_SET;
                this.f18099i = 0L;
                G();
                if (!TextUtils.isEmpty(this.a.M()) && "am".equals(this.a.N())) {
                    this.n = this.a.M();
                }
                strB = GoogleServices.b();
                if (TextUtils.isEmpty(strB)) {
                    str2 = HttpUrl.FRAGMENT_ENCODE_SET;
                } else {
                    str2 = strB;
                }
                this.m = str2;
                if (!zzky.b() && n().B(packageName, zzap.N0)) {
                    StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(f());
                    String strA = stringResourceValueReader.a("ga_app_id");
                    if (!TextUtils.isEmpty(strA)) {
                        str4 = strA;
                    }
                    this.o = str4;
                    if (!TextUtils.isEmpty(strB) || !TextUtils.isEmpty(strA)) {
                        this.n = stringResourceValueReader.a("admob_app_id");
                    }
                } else if (!TextUtils.isEmpty(strB)) {
                    this.n = new StringResourceValueReader(f()).a("admob_app_id");
                }
                if (z5) {
                    h().P().c("App package, google app id", this.f18093c, this.m);
                }
                this.f18101k = null;
                if (n().B(this.f18093c, zzap.v0)) {
                    G();
                    listW = n().w("analytics.safelisted_events");
                    if (listW != null) {
                        if (listW.size() == 0) {
                            h().K().a("Safelisted event list cannot be empty. Ignoring");
                        } else {
                            it = listW.iterator();
                            while (it.hasNext()) {
                                if (!l().n0("safelisted event", it.next())) {
                                }
                            }
                        }
                        z = false;
                        break;
                    }
                    if (z) {
                        this.f18101k = listW;
                    }
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    this.l = 0;
                } else if (packageManager != null) {
                    this.l = InstantApps.a(f()) ? 1 : 0;
                } else {
                    this.l = 0;
                }
            }
            h().H().b("PackageManager is null, app identity information might be inaccurate. appId", zzet.x(packageName));
            strB = GoogleServices.b();
            if (TextUtils.isEmpty(strB)) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            } else {
                str2 = strB;
            }
            this.m = str2;
            if (!zzky.b()) {
                if (!TextUtils.isEmpty(strB)) {
                    this.n = new StringResourceValueReader(f()).a("admob_app_id");
                }
            } else if (!TextUtils.isEmpty(strB)) {
                this.n = new StringResourceValueReader(f()).a("admob_app_id");
            }
            if (z5) {
                h().P().c("App package, google app id", this.f18093c, this.m);
            }
        } catch (IllegalStateException e2) {
            h().H().c("getGoogleAppId or isMeasurementEnabled failed with exception. appId", zzet.x(packageName), e2);
        }
        string = "Unknown";
        this.f18093c = packageName;
        this.f18096f = installerPackageName;
        this.f18094d = str3;
        this.f18095e = i2;
        this.f18097g = string;
        this.f18098h = 0L;
        G();
        statusC = GoogleServices.c(f());
        z = true;
        if (statusC == null) {
            z2 = false;
        } else {
            z2 = false;
        }
        if (TextUtils.isEmpty(this.a.M())) {
            z3 = false;
        } else {
            z3 = false;
        }
        z4 = z2 | z3;
        if (!z4) {
            if (statusC == null) {
                h().H().a("GoogleService failed to initialize (no status)");
            } else {
                h().H().c("GoogleService failed to initialize, status", Integer.valueOf(statusC.z()), statusC.W());
            }
        }
        if (z4) {
            boolJ = n().J();
            if (n().I()) {
                if (this.a.L()) {
                    h().N().a("Collection disabled with firebase_analytics_collection_deactivated=1");
                }
            } else if (boolJ != null) {
                if (boolJ == null) {
                }
                h().P().a("Collection enabled");
                z5 = true;
            } else {
                if (boolJ == null) {
                }
                h().P().a("Collection enabled");
                z5 = true;
            }
            z5 = false;
        } else {
            z5 = false;
        }
        this.m = HttpUrl.FRAGMENT_ENCODE_SET;
        this.n = HttpUrl.FRAGMENT_ENCODE_SET;
        this.o = HttpUrl.FRAGMENT_ENCODE_SET;
        this.f18099i = 0L;
        G();
        if (!TextUtils.isEmpty(this.a.M())) {
            this.n = this.a.M();
        }
        this.f18101k = null;
        if (n().B(this.f18093c, zzap.v0)) {
            G();
            listW = n().w("analytics.safelisted_events");
            if (listW != null) {
                if (listW.size() == 0) {
                    h().K().a("Safelisted event list cannot be empty. Ignoring");
                } else {
                    it = listW.iterator();
                    while (it.hasNext()) {
                        if (!l().n0("safelisted event", it.next())) {
                        }
                    }
                }
                z = false;
                break;
            }
            if (z) {
                this.f18101k = listW;
            }
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.l = 0;
        } else if (packageManager != null) {
            this.l = InstantApps.a(f()) ? 1 : 0;
        } else {
            this.l = 0;
        }
    }
}
