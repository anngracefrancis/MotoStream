package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfo;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfr extends f7 implements x7 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    private static int f18136d = 65535;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    private static int f18137e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, Map<String, String>> f18138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f18139g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f18140h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, zzbo.zzb> f18141i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map<String, Map<String, Integer>> f18142j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map<String, String> f18143k;

    zzfr(zzkc zzkcVar) {
        super(zzkcVar);
        this.f18138f = new c.e.a();
        this.f18139g = new c.e.a();
        this.f18140h = new c.e.a();
        this.f18141i = new c.e.a();
        this.f18143k = new c.e.a();
        this.f18142j = new c.e.a();
    }

    private final void M(String str) throws Throwable {
        t();
        d();
        Preconditions.g(str);
        if (this.f18141i.get(str) == null) {
            byte[] bArrR0 = q().r0(str);
            if (bArrR0 != null) {
                zzbo.zzb.zza zzaVarV = x(str, bArrR0).v();
                z(str, zzaVarV);
                this.f18138f.put(str, y((zzbo.zzb) ((zzfd) zzaVarV.y())));
                this.f18141i.put(str, (zzbo.zzb) ((zzfd) zzaVarV.y()));
                this.f18143k.put(str, null);
                return;
            }
            this.f18138f.put(str, null);
            this.f18139g.put(str, null);
            this.f18140h.put(str, null);
            this.f18141i.put(str, null);
            this.f18143k.put(str, null);
            this.f18142j.put(str, null);
        }
    }

    private final zzbo.zzb x(String str, byte[] bArr) {
        if (bArr == null) {
            return zzbo.zzb.O();
        }
        try {
            zzbo.zzb zzbVar = (zzbo.zzb) ((zzfd) ((zzbo.zzb.zza) zzkg.A(zzbo.zzb.N(), bArr)).y());
            h().P().c("Parsed config. version, gmp_app_id", zzbVar.F() ? Long.valueOf(zzbVar.G()) : null, zzbVar.H() ? zzbVar.I() : null);
            return zzbVar;
        } catch (zzfo e2) {
            h().K().c("Unable to merge remote config. appId", zzet.x(str), e2);
            return zzbo.zzb.O();
        } catch (RuntimeException e3) {
            h().K().c("Unable to merge remote config. appId", zzet.x(str), e3);
            return zzbo.zzb.O();
        }
    }

    private static Map<String, String> y(zzbo.zzb zzbVar) {
        c.e.a aVar = new c.e.a();
        if (zzbVar != null) {
            for (zzbo.zzc zzcVar : zzbVar.J()) {
                aVar.put(zzcVar.B(), zzcVar.C());
            }
        }
        return aVar;
    }

    private final void z(String str, zzbo.zzb.zza zzaVar) {
        c.e.a aVar = new c.e.a();
        c.e.a aVar2 = new c.e.a();
        c.e.a aVar3 = new c.e.a();
        if (zzaVar != null) {
            for (int i2 = 0; i2 < zzaVar.w(); i2++) {
                zzbo.zza.C0190zza c0190zzaV = zzaVar.A(i2).v();
                if (TextUtils.isEmpty(c0190zzaV.A())) {
                    h().K().a("EventConfig contained null event name");
                } else {
                    String strB = zzgw.b(c0190zzaV.A());
                    if (!TextUtils.isEmpty(strB)) {
                        c0190zzaV = c0190zzaV.w(strB);
                        zzaVar.B(i2, c0190zzaV);
                    }
                    aVar.put(c0190zzaV.A(), Boolean.valueOf(c0190zzaV.B()));
                    aVar2.put(c0190zzaV.A(), Boolean.valueOf(c0190zzaV.C()));
                    if (c0190zzaV.D()) {
                        if (c0190zzaV.E() < f18137e || c0190zzaV.E() > f18136d) {
                            h().K().c("Invalid sampling rate. Event name, sample rate", c0190zzaV.A(), Integer.valueOf(c0190zzaV.E()));
                        } else {
                            aVar3.put(c0190zzaV.A(), Integer.valueOf(c0190zzaV.E()));
                        }
                    }
                }
            }
        }
        this.f18139g.put(str, aVar);
        this.f18140h.put(str, aVar2);
        this.f18142j.put(str, aVar3);
    }

    protected final boolean A(String str, byte[] bArr, String str2) {
        byte[] bArrJ;
        boolean z;
        t();
        d();
        Preconditions.g(str);
        zzbo.zzb.zza zzaVarV = x(str, bArr).v();
        if (zzaVarV == null) {
            return false;
        }
        z(str, zzaVarV);
        this.f18141i.put(str, (zzbo.zzb) ((zzfd) zzaVarV.y()));
        this.f18143k.put(str, str2);
        this.f18138f.put(str, y((zzbo.zzb) ((zzfd) zzaVarV.y())));
        q7 q7VarO = o();
        ArrayList arrayList = new ArrayList(zzaVarV.C());
        Preconditions.k(arrayList);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            zzbj.zza.C0189zza c0189zzaV = arrayList.get(i2).v();
            if (c0189zzaV.D() != 0) {
                for (int i3 = 0; i3 < c0189zzaV.D(); i3++) {
                    zzbj.zzb.zza zzaVarV2 = c0189zzaV.E(i3).v();
                    zzbj.zzb.zza zzaVar = (zzbj.zzb.zza) ((zzfd.zzb) zzaVarV2.clone());
                    String strB = zzgw.b(zzaVarV2.C());
                    if (strB != null) {
                        zzaVar.A(strB);
                        z = true;
                    } else {
                        z = false;
                    }
                    for (int i4 = 0; i4 < zzaVarV2.D(); i4++) {
                        zzbj.zzc zzcVarB = zzaVarV2.B(i4);
                        String strA = zzgv.a(zzcVarB.J());
                        if (strA != null) {
                            zzaVar.w(i4, (zzbj.zzc) ((zzfd) zzcVarB.v().w(strA).y()));
                            z = true;
                        }
                    }
                    if (z) {
                        c0189zzaV = c0189zzaV.A(i3, zzaVar);
                        arrayList.set(i2, (zzbj.zza) ((zzfd) c0189zzaV.y()));
                    }
                }
            }
            if (c0189zzaV.w() != 0) {
                for (int i5 = 0; i5 < c0189zzaV.w(); i5++) {
                    zzbj.zze zzeVarC = c0189zzaV.C(i5);
                    String strA2 = zzgy.a(zzeVarC.F());
                    if (strA2 != null) {
                        c0189zzaV = c0189zzaV.B(i5, zzeVarC.v().w(strA2));
                        arrayList.set(i2, (zzbj.zza) ((zzfd) c0189zzaV.y()));
                    }
                }
            }
        }
        q7VarO.q().P(str, arrayList);
        try {
            zzaVarV.D();
            bArrJ = ((zzbo.zzb) ((zzfd) zzaVarV.y())).j();
        } catch (RuntimeException e2) {
            h().K().c("Unable to serialize reduced-size config. Storing full config instead. appId", zzet.x(str), e2);
            bArrJ = bArr;
        }
        c cVarQ = q();
        Preconditions.g(str);
        cVarQ.d();
        cVarQ.t();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArrJ);
        try {
            if (cVarQ.x().update(DeepLinkIntentReceiver.DeepLinksTargets.APPS, contentValues, "app_id = ?", new String[]{str}) == 0) {
                cVarQ.h().H().b("Failed to update remote config (got 0). appId", zzet.x(str));
            }
        } catch (SQLiteException e3) {
            cVarQ.h().H().c("Error storing remote config. appId", zzet.x(str), e3);
        }
        this.f18141i.put(str, (zzbo.zzb) ((zzfd) zzaVarV.y()));
        return true;
    }

    protected final String B(String str) {
        d();
        return this.f18143k.get(str);
    }

    final boolean C(String str, String str2) throws Throwable {
        Boolean bool;
        d();
        M(str);
        if (K(str) && zzkk.u0(str2)) {
            return true;
        }
        if (L(str) && zzkk.Y(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f18139g.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    protected final void D(String str) {
        d();
        this.f18143k.put(str, null);
    }

    final boolean E(String str, String str2) throws Throwable {
        Boolean bool;
        d();
        M(str);
        if ("ecommerce_purchase".equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f18140h.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final int F(String str, String str2) throws Throwable {
        Integer num;
        d();
        M(str);
        Map<String, Integer> map = this.f18142j.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    final void H(String str) {
        d();
        this.f18141i.remove(str);
    }

    final boolean I(String str) {
        d();
        zzbo.zzb zzbVarW = w(str);
        if (zzbVarW == null) {
            return false;
        }
        return zzbVarW.M();
    }

    final long J(String str) throws Throwable {
        String strI = i(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(strI)) {
            return 0L;
        }
        try {
            return Long.parseLong(strI);
        } catch (NumberFormatException e2) {
            h().K().c("Unable to parse timezone offset. appId", zzet.x(str), e2);
            return 0L;
        }
    }

    final boolean K(String str) {
        return "1".equals(i(str, "measurement.upload.blacklist_internal"));
    }

    final boolean L(String str) {
        return "1".equals(i(str, "measurement.upload.blacklist_public"));
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

    @Override // com.google.android.gms.measurement.internal.x7
    public final String i(String str, String str2) throws Throwable {
        d();
        M(str);
        Map<String, String> map = this.f18138f.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
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

    @Override // com.google.android.gms.measurement.internal.h7
    public final /* bridge */ /* synthetic */ q7 o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.h7
    public final /* bridge */ /* synthetic */ zzkg p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.h7
    public final /* bridge */ /* synthetic */ c q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.h7
    public final /* bridge */ /* synthetic */ zzfr r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.f7
    protected final boolean v() {
        return false;
    }

    protected final zzbo.zzb w(String str) {
        t();
        d();
        Preconditions.g(str);
        M(str);
        return this.f18141i.get(str);
    }
}
