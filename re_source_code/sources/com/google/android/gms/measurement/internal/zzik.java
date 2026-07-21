package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public final class zzik extends u2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzjc f18192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzel f18193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile Boolean f18194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final f f18195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c7 f18196g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<Runnable> f18197h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final f f18198i;

    protected zzik(zzfx zzfxVar) {
        super(zzfxVar);
        this.f18197h = new ArrayList();
        this.f18196g = new c7(zzfxVar.j());
        this.f18192c = new zzjc(this);
        this.f18195f = new v5(this, zzfxVar);
        this.f18198i = new e6(this, zzfxVar);
    }

    static /* synthetic */ zzel B(zzik zzikVar, zzel zzelVar) {
        zzikVar.f18193d = null;
        return null;
    }

    private final zzm D(boolean z) {
        G();
        return q().B(z ? h().Q() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(ComponentName componentName) {
        d();
        if (this.f18193d != null) {
            this.f18193d = null;
            h().P().b("Disconnected from device MeasurementService", componentName);
            d();
            Z();
        }
    }

    private final void R(Runnable runnable) throws IllegalStateException {
        d();
        if (V()) {
            runnable.run();
        } else {
            if (this.f18197h.size() >= 1000) {
                h().H().a("Discarding data. Max runnable queue size reached");
                return;
            }
            this.f18197h.add(runnable);
            this.f18198i.c(60000L);
            Z();
        }
    }

    private final boolean c0() {
        G();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        d();
        this.f18196g.a();
        this.f18195f.c(zzap.N.a(null).longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        d();
        if (V()) {
            h().P().a("Inactivity, disconnecting from the service");
            b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        d();
        h().P().b("Processing queued up service tasks", Integer.valueOf(this.f18197h.size()));
        Iterator<Runnable> it = this.f18197h.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (Exception e2) {
                h().H().b("Task exception while flushing queue", e2);
            }
        }
        this.f18197h.clear();
        this.f18198i.e();
    }

    @Override // com.google.android.gms.measurement.internal.u2
    protected final boolean A() {
        return false;
    }

    public final void F(zzn zznVar) {
        d();
        x();
        R(new a6(this, D(false), zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    public final void H(zzn zznVar, zzan zzanVar, String str) {
        d();
        x();
        if (l().u(12451000) == 0) {
            R(new b6(this, zzanVar, str, zznVar));
        } else {
            h().K().a("Not bundling data. Service unavailable or out of date");
            l().S(zznVar, new byte[0]);
        }
    }

    protected final void I(zzn zznVar, String str, String str2) {
        d();
        x();
        R(new h6(this, str, str2, D(false), zznVar));
    }

    protected final void J(zzn zznVar, String str, String str2, boolean z) {
        d();
        x();
        R(new j6(this, str, str2, z, D(false), zznVar));
    }

    protected final void K(zzan zzanVar, String str) {
        Preconditions.k(zzanVar);
        d();
        x();
        boolean zC0 = c0();
        R(new g6(this, zC0, zC0 && t().E(zzanVar), zzanVar, D(true), str));
    }

    @VisibleForTesting
    protected final void L(zzel zzelVar) {
        d();
        Preconditions.k(zzelVar);
        this.f18193d = zzelVar;
        d0();
        f0();
    }

    @VisibleForTesting
    final void M(zzel zzelVar, AbstractSafeParcelable abstractSafeParcelable, zzm zzmVar) {
        int size;
        List<AbstractSafeParcelable> listC;
        d();
        b();
        x();
        boolean zC0 = c0();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            if (!zC0 || (listC = t().C(100)) == null) {
                size = 0;
            } else {
                arrayList.addAll(listC);
                size = listC.size();
            }
            if (abstractSafeParcelable != null && size < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size2 = arrayList.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj = arrayList.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzan) {
                    try {
                        zzelVar.Z5((zzan) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e2) {
                        h().H().b("Failed to send event to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkj) {
                    try {
                        zzelVar.b4((zzkj) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e3) {
                        h().H().b("Failed to send attribute to the service", e3);
                    }
                } else if (abstractSafeParcelable2 instanceof zzv) {
                    try {
                        zzelVar.h2((zzv) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e4) {
                        h().H().b("Failed to send conditional property to the service", e4);
                    }
                } else {
                    h().H().a("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = size;
        }
    }

    protected final void N(zzig zzigVar) {
        d();
        x();
        R(new c6(this, zzigVar));
    }

    protected final void P(zzkj zzkjVar) {
        d();
        x();
        R(new w5(this, c0() && t().F(zzkjVar), zzkjVar, D(true)));
    }

    protected final void Q(zzv zzvVar) {
        Preconditions.k(zzvVar);
        d();
        x();
        G();
        R(new f6(this, true, t().H(zzvVar), new zzv(zzvVar), D(true), zzvVar));
    }

    public final void S(AtomicReference<String> atomicReference) {
        d();
        x();
        R(new x5(this, atomicReference, D(false)));
    }

    protected final void T(AtomicReference<List<zzv>> atomicReference, String str, String str2, String str3) {
        d();
        x();
        R(new i6(this, atomicReference, str, str2, str3, D(false)));
    }

    protected final void U(AtomicReference<List<zzkj>> atomicReference, String str, String str2, String str3, boolean z) {
        d();
        x();
        R(new l6(this, atomicReference, str, str2, str3, z, D(false)));
    }

    public final boolean V() {
        d();
        x();
        return this.f18193d != null;
    }

    protected final void W() {
        d();
        x();
        R(new d6(this, D(true)));
    }

    protected final void X() {
        d();
        b();
        x();
        zzm zzmVarD = D(false);
        if (c0()) {
            t().I();
        }
        R(new y5(this, zzmVarD));
    }

    protected final void Y() {
        d();
        x();
        zzm zzmVarD = D(true);
        boolean zR = n().r(zzap.G0);
        if (zR) {
            t().J();
        }
        R(new z5(this, zzmVarD, zR));
    }

    final void Z() {
        boolean z;
        boolean z2;
        d();
        x();
        if (V()) {
            return;
        }
        boolean z3 = false;
        if (this.f18194e == null) {
            d();
            x();
            Boolean boolH = m().H();
            if (boolH == null || !boolH.booleanValue()) {
                G();
                if (q().H() == 1) {
                    z = true;
                    z2 = true;
                } else {
                    h().P().a("Checking service availability");
                    int iU = l().u(12451000);
                    if (iU != 0) {
                        if (iU != 1) {
                            if (iU == 2) {
                                h().O().a("Service container out of date");
                                if (l().B0() >= 17443) {
                                    Boolean boolH2 = m().H();
                                    z = boolH2 == null || boolH2.booleanValue();
                                    z2 = false;
                                }
                            } else if (iU == 3) {
                                h().K().a("Service disabled");
                            } else if (iU == 9) {
                                h().K().a("Service invalid");
                            } else if (iU != 18) {
                                h().K().b("Unexpected service status", Integer.valueOf(iU));
                            } else {
                                h().K().a("Service updating");
                            }
                            z2 = false;
                        } else {
                            h().P().a("Service missing");
                        }
                        z = false;
                        z2 = true;
                    } else {
                        h().P().a("Service available");
                    }
                    z = true;
                    z2 = true;
                }
                if (!z && n().Y()) {
                    h().H().a("No way to upload. Consider using the full version of Analytics");
                    z2 = false;
                }
                if (z2) {
                    m().w(z);
                }
            } else {
                z = true;
            }
            this.f18194e = Boolean.valueOf(z);
        }
        if (this.f18194e.booleanValue()) {
            this.f18192c.d();
            return;
        }
        if (n().Y()) {
            return;
        }
        G();
        List<ResolveInfo> listQueryIntentServices = f().getPackageManager().queryIntentServices(new Intent().setClassName(f(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
            z3 = true;
        }
        if (!z3) {
            h().H().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        Context contextF = f();
        G();
        intent.setComponent(new ComponentName(contextF, "com.google.android.gms.measurement.AppMeasurementService"));
        this.f18192c.b(intent);
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    final Boolean a0() {
        return this.f18194e;
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    public final void b0() {
        d();
        x();
        this.f18192c.a();
        try {
            ConnectionTracker.b().c(f(), this.f18192c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f18193d = null;
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
