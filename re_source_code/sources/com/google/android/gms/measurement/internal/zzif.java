package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzif extends u2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    protected zzig f18183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile zzig f18184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzig f18185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Activity, zzig> f18186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzig f18187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f18188h;

    public zzif(zzfx zzfxVar) {
        super(zzfxVar);
        this.f18186f = new c.e.a();
    }

    @VisibleForTesting
    private static String B(String str) {
        String[] strArrSplit = str.split("\\.");
        String str2 = strArrSplit.length > 0 ? strArrSplit[strArrSplit.length - 1] : HttpUrl.FRAGMENT_ENCODE_SET;
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    private final void E(Activity activity, zzig zzigVar, boolean z) {
        zzig zzigVar2 = this.f18184d == null ? this.f18185e : this.f18184d;
        if (zzigVar.f18189b == null) {
            zzigVar = new zzig(zzigVar.a, B(activity.getClass().getCanonicalName()), zzigVar.f18190c);
        }
        this.f18185e = this.f18184d;
        this.f18184d = zzigVar;
        g().z(new u5(this, z, zzigVar2, zzigVar));
    }

    public static void I(zzig zzigVar, Bundle bundle, boolean z) {
        if (bundle != null && zzigVar != null && (!bundle.containsKey("_sc") || z)) {
            String str = zzigVar.a;
            if (str != null) {
                bundle.putString("_sn", str);
            } else {
                bundle.remove("_sn");
            }
            bundle.putString("_sc", zzigVar.f18189b);
            bundle.putLong("_si", zzigVar.f18190c);
            return;
        }
        if (bundle != null && zzigVar == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(zzig zzigVar, boolean z) {
        o().v(j().b());
        if (u().E(zzigVar.f18191d, z)) {
            zzigVar.f18191d = false;
        }
    }

    private final zzig Q(Activity activity) {
        Preconditions.k(activity);
        zzig zzigVar = this.f18186f.get(activity);
        if (zzigVar != null) {
            return zzigVar;
        }
        zzig zzigVar2 = new zzig(null, B(activity.getClass().getCanonicalName()), l().w0());
        this.f18186f.put(activity, zzigVar2);
        return zzigVar2;
    }

    @Override // com.google.android.gms.measurement.internal.u2
    protected final boolean A() {
        return false;
    }

    public final void C(Activity activity) {
        E(activity, Q(activity), false);
        zzb zzbVarO = o();
        zzbVarO.g().z(new s0(zzbVarO, zzbVarO.j().b()));
    }

    public final void D(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f18186f.put(activity, new zzig(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong(DeepLinkIntentReceiver.DeepLinksKeys.ID)));
    }

    public final void F(Activity activity, String str, String str2) {
        if (this.f18184d == null) {
            h().M().a("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.f18186f.get(activity) == null) {
            h().M().a("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = B(activity.getClass().getCanonicalName());
        }
        boolean zEquals = this.f18184d.f18189b.equals(str2);
        boolean zT0 = zzkk.t0(this.f18184d.a, str);
        if (zEquals && zT0) {
            h().M().a("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > 100)) {
            h().M().b("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > 100)) {
            h().M().b("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        h().P().c("Setting current screen to name, class", str == null ? "null" : str, str2);
        zzig zzigVar = new zzig(str, str2, l().w0());
        this.f18186f.put(activity, zzigVar);
        E(activity, zzigVar, true);
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    public final void K(String str, zzig zzigVar) {
        d();
        synchronized (this) {
            String str2 = this.f18188h;
            if (str2 == null || str2.equals(str) || zzigVar != null) {
                this.f18188h = str;
                this.f18187g = zzigVar;
            }
        }
    }

    public final zzig L() {
        x();
        d();
        return this.f18183c;
    }

    public final zzig M() {
        b();
        return this.f18184d;
    }

    public final void N(Activity activity) {
        zzig zzigVarQ = Q(activity);
        this.f18185e = this.f18184d;
        this.f18184d = null;
        g().z(new t5(this, zzigVarQ));
    }

    public final void O(Activity activity, Bundle bundle) {
        zzig zzigVar;
        if (bundle == null || (zzigVar = this.f18186f.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(DeepLinkIntentReceiver.DeepLinksKeys.ID, zzigVar.f18190c);
        bundle2.putString("name", zzigVar.a);
        bundle2.putString("referrer_name", zzigVar.f18189b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    public final void P(Activity activity) {
        this.f18186f.remove(activity);
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
}
