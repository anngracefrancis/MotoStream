package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzx extends r4 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f18246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private x7 f18247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Boolean f18248d;

    zzx(zzfx zzfxVar) {
        super(zzfxVar);
        this.f18247c = b.a;
        zzap.d(zzfxVar);
    }

    public static long N() {
        return zzap.K.a(null).longValue();
    }

    public static long U() {
        return zzap.f18080k.a(null).longValue();
    }

    public static boolean X() {
        return zzap.f18076g.a(null).booleanValue();
    }

    private final String i(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e2) {
            h().H().b("Could not find SystemProperties class", e2);
            return str2;
        } catch (IllegalAccessException e3) {
            h().H().b("Could not access SystemProperties.get()", e3);
            return str2;
        } catch (NoSuchMethodException e4) {
            h().H().b("Could not find SystemProperties.get() method", e4);
            return str2;
        } catch (InvocationTargetException e5) {
            h().H().b("SystemProperties.get() threw an exception", e5);
            return str2;
        }
    }

    @VisibleForTesting
    private final Bundle s() {
        try {
            if (f().getPackageManager() == null) {
                h().H().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfoC = Wrappers.a(f()).c(f().getPackageName(), 128);
            if (applicationInfoC != null) {
                return applicationInfoC.metaData;
            }
            h().H().a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            h().H().b("Failed to load metadata: Package name not found", e2);
            return null;
        }
    }

    static String z() {
        return zzap.f18077h.a(null);
    }

    public final boolean A(String str) {
        return "1".equals(this.f18247c.i(str, "measurement.event_sampling_enabled"));
    }

    public final boolean B(String str, zzem<Boolean> zzemVar) {
        return y(str, zzemVar);
    }

    public final long C() {
        G();
        return 18202L;
    }

    final boolean D(String str) {
        return y(str, zzap.U);
    }

    public final boolean E() {
        if (this.f18248d == null) {
            synchronized (this) {
                if (this.f18248d == null) {
                    ApplicationInfo applicationInfo = f().getApplicationInfo();
                    String strA = ProcessUtils.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f18248d = Boolean.valueOf(str != null && str.equals(strA));
                    }
                    if (this.f18248d == null) {
                        this.f18248d = Boolean.TRUE;
                        h().H().a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f18248d.booleanValue();
    }

    final boolean F(String str) {
        return y(str, zzap.O);
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    final String H(String str) {
        zzem<String> zzemVar = zzap.P;
        return str == null ? zzemVar.a(null) : zzemVar.a(this.f18247c.i(str, zzemVar.b()));
    }

    public final boolean I() {
        G();
        Boolean boolU = u("firebase_analytics_collection_deactivated");
        return boolU != null && boolU.booleanValue();
    }

    public final Boolean J() {
        G();
        return u("firebase_analytics_collection_enabled");
    }

    final boolean K(String str) {
        return y(str, zzap.V);
    }

    public final Boolean L() {
        b();
        Boolean boolU = u("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(boolU == null || boolU.booleanValue());
    }

    final boolean M(String str) {
        return y(str, zzap.X);
    }

    final boolean O(String str) {
        return y(str, zzap.W);
    }

    final boolean P(String str) {
        return y(str, zzap.Y);
    }

    final boolean Q(String str) {
        return y(str, zzap.Z);
    }

    final boolean R(String str) {
        return y(str, zzap.a0);
    }

    final boolean S(String str) {
        return y(str, zzap.b0);
    }

    final boolean T(String str) {
        return y(str, zzap.i0);
    }

    public final String V() {
        return i("debug.firebase.analytics.app", HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public final String W() {
        return i("debug.deferred.deeplink", HttpUrl.FRAGMENT_ENCODE_SET);
    }

    final boolean Y() {
        if (this.f18246b == null) {
            Boolean boolU = u("app_measurement_lite");
            this.f18246b = boolU;
            if (boolU == null) {
                this.f18246b = Boolean.FALSE;
            }
        }
        return this.f18246b.booleanValue() || !this.a.P();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.r4
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

    public final int o(String str) {
        return t(str, zzap.v);
    }

    public final long p(String str, zzem<Long> zzemVar) {
        if (str == null) {
            return zzemVar.a(null).longValue();
        }
        String strI = this.f18247c.i(str, zzemVar.b());
        if (TextUtils.isEmpty(strI)) {
            return zzemVar.a(null).longValue();
        }
        try {
            return zzemVar.a(Long.valueOf(Long.parseLong(strI))).longValue();
        } catch (NumberFormatException unused) {
            return zzemVar.a(null).longValue();
        }
    }

    final void q(x7 x7Var) {
        this.f18247c = x7Var;
    }

    public final boolean r(zzem<Boolean> zzemVar) {
        return y(null, zzemVar);
    }

    public final int t(String str, zzem<Integer> zzemVar) {
        if (str == null) {
            return zzemVar.a(null).intValue();
        }
        String strI = this.f18247c.i(str, zzemVar.b());
        if (TextUtils.isEmpty(strI)) {
            return zzemVar.a(null).intValue();
        }
        try {
            return zzemVar.a(Integer.valueOf(Integer.parseInt(strI))).intValue();
        } catch (NumberFormatException unused) {
            return zzemVar.a(null).intValue();
        }
    }

    @VisibleForTesting
    final Boolean u(String str) {
        Preconditions.g(str);
        Bundle bundleS = s();
        if (bundleS == null) {
            h().H().a("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleS.containsKey(str)) {
            return Boolean.valueOf(bundleS.getBoolean(str));
        }
        return null;
    }

    public final double v(String str, zzem<Double> zzemVar) {
        if (str == null) {
            return zzemVar.a(null).doubleValue();
        }
        String strI = this.f18247c.i(str, zzemVar.b());
        if (TextUtils.isEmpty(strI)) {
            return zzemVar.a(null).doubleValue();
        }
        try {
            return zzemVar.a(Double.valueOf(Double.parseDouble(strI))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzemVar.a(null).doubleValue();
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x003d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x003e A[Catch: NotFoundException -> 0x0043, TRY_LEAVE, TryCatch #0 {NotFoundException -> 0x0043, blocks: (B:12:0x002b, B:15:0x003e), top: B:20:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:20:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @VisibleForTesting
    final List<String> w(String str) {
        Integer numValueOf;
        String[] stringArray;
        Preconditions.g(str);
        Bundle bundleS = s();
        if (bundleS != null) {
            if (bundleS.containsKey(str)) {
                numValueOf = Integer.valueOf(bundleS.getInt(str));
            }
            if (numValueOf == null) {
                return null;
            }
            try {
                stringArray = f().getResources().getStringArray(numValueOf.intValue());
                if (stringArray == null) {
                    return null;
                }
                return Arrays.asList(stringArray);
            } catch (Resources.NotFoundException e2) {
                h().H().b("Failed to load string array from metadata: resource not found", e2);
                return null;
            }
        }
        h().H().a("Failed to load metadata: Metadata bundle is null");
        numValueOf = null;
        if (numValueOf == null) {
            return null;
        }
        stringArray = f().getResources().getStringArray(numValueOf.intValue());
        if (stringArray == null) {
            return null;
        }
        return Arrays.asList(stringArray);
    }

    public final boolean x(String str) {
        return "1".equals(this.f18247c.i(str, "gaia_collection_enabled"));
    }

    public final boolean y(String str, zzem<Boolean> zzemVar) {
        if (str == null) {
            return zzemVar.a(null).booleanValue();
        }
        String strI = this.f18247c.i(str, zzemVar.b());
        return TextUtils.isEmpty(strI) ? zzemVar.a(null).booleanValue() : zzemVar.a(Boolean.valueOf(Boolean.parseBoolean(strI))).booleanValue();
    }
}
