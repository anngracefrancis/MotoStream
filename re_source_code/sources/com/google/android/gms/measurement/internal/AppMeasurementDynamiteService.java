package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzl;
import com.google.android.gms.internal.measurement.zzn;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.internal.measurement.zzt;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
@DynamiteApi
public class AppMeasurementDynamiteService extends zzl {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    zzfx f17687f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<Integer, zzha> f17688g = new c.e.a();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@17.2.0 */
    class a implements zzgx {
        private zzs a;

        a(zzs zzsVar) {
            this.a = zzsVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzgx
        public final void a(String str, String str2, Bundle bundle, long j2) {
            try {
                this.a.q4(str, str2, bundle, j2);
            } catch (RemoteException e2) {
                AppMeasurementDynamiteService.this.f17687f.h().K().b("Event interceptor threw exception", e2);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@17.2.0 */
    class b implements zzha {
        private zzs a;

        b(zzs zzsVar) {
            this.a = zzsVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzha
        public final void a(String str, String str2, Bundle bundle, long j2) {
            try {
                this.a.q4(str, str2, bundle, j2);
            } catch (RemoteException e2) {
                AppMeasurementDynamiteService.this.f17687f.h().K().b("Event listener threw exception", e2);
            }
        }
    }

    private final void P(zzn zznVar, String str) {
        this.f17687f.I().P(zznVar, str);
    }

    private final void a() {
        if (this.f17687f == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void beginAdUnitExposure(String str, long j2) throws RemoteException {
        a();
        this.f17687f.U().z(str, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        a();
        this.f17687f.H().y0(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void endAdUnitExposure(String str, long j2) throws RemoteException {
        a();
        this.f17687f.U().D(str, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void generateEventId(zzn zznVar) throws RemoteException {
        a();
        this.f17687f.I().N(zznVar, this.f17687f.I().w0());
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getAppInstanceId(zzn zznVar) throws RemoteException {
        a();
        this.f17687f.g().z(new p5(this, zznVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getCachedAppInstanceId(zzn zznVar) throws RemoteException {
        a();
        P(zznVar, this.f17687f.H().g0());
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getConditionalUserProperties(String str, String str2, zzn zznVar) throws RemoteException {
        a();
        this.f17687f.g().z(new k6(this, zznVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getCurrentScreenClass(zzn zznVar) throws RemoteException {
        a();
        P(zznVar, this.f17687f.H().j0());
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getCurrentScreenName(zzn zznVar) throws RemoteException {
        a();
        P(zznVar, this.f17687f.H().i0());
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getGmpAppId(zzn zznVar) throws RemoteException {
        a();
        P(zznVar, this.f17687f.H().k0());
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getMaxUserProperties(String str, zzn zznVar) throws RemoteException {
        a();
        this.f17687f.H();
        Preconditions.g(str);
        this.f17687f.I().M(zznVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getTestFlag(zzn zznVar, int i2) throws RemoteException {
        a();
        if (i2 == 0) {
            this.f17687f.I().P(zznVar, this.f17687f.H().c0());
            return;
        }
        if (i2 == 1) {
            this.f17687f.I().N(zznVar, this.f17687f.H().d0().longValue());
            return;
        }
        if (i2 != 2) {
            if (i2 == 3) {
                this.f17687f.I().M(zznVar, this.f17687f.H().e0().intValue());
                return;
            } else {
                if (i2 != 4) {
                    return;
                }
                this.f17687f.I().R(zznVar, this.f17687f.H().b0().booleanValue());
                return;
            }
        }
        zzkk zzkkVarI = this.f17687f.I();
        double dDoubleValue = this.f17687f.H().f0().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", dDoubleValue);
        try {
            zznVar.J(bundle);
        } catch (RemoteException e2) {
            zzkkVarI.a.h().K().b("Error returning double value to wrapper", e2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getUserProperties(String str, String str2, boolean z, zzn zznVar) throws RemoteException {
        a();
        this.f17687f.g().z(new g7(this, zznVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void initForTests(Map map) throws RemoteException {
        a();
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzv zzvVar, long j2) throws RemoteException {
        Context context = (Context) ObjectWrapper.k0(iObjectWrapper);
        zzfx zzfxVar = this.f17687f;
        if (zzfxVar == null) {
            this.f17687f = zzfx.a(context, zzvVar);
        } else {
            zzfxVar.h().K().a("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void isDataCollectionEnabled(zzn zznVar) throws RemoteException {
        a();
        this.f17687f.g().z(new p7(this, zznVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2) throws RemoteException {
        a();
        this.f17687f.H().U(str, str2, bundle, z, z2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void logEventAndBundle(String str, String str2, Bundle bundle, zzn zznVar, long j2) throws RemoteException {
        a();
        Preconditions.g(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.f17687f.g().z(new t4(this, zznVar, new zzan(str2, new zzam(bundle), "app", j2), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void logHealthData(int i2, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        a();
        this.f17687f.h().B(i2, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.k0(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.k0(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.k0(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j2) throws RemoteException {
        a();
        l5 l5Var = this.f17687f.H().f18176c;
        if (l5Var != null) {
            this.f17687f.H().a0();
            l5Var.onActivityCreated((Activity) ObjectWrapper.k0(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        a();
        l5 l5Var = this.f17687f.H().f18176c;
        if (l5Var != null) {
            this.f17687f.H().a0();
            l5Var.onActivityDestroyed((Activity) ObjectWrapper.k0(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        a();
        l5 l5Var = this.f17687f.H().f18176c;
        if (l5Var != null) {
            this.f17687f.H().a0();
            l5Var.onActivityPaused((Activity) ObjectWrapper.k0(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        a();
        l5 l5Var = this.f17687f.H().f18176c;
        if (l5Var != null) {
            this.f17687f.H().a0();
            l5Var.onActivityResumed((Activity) ObjectWrapper.k0(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzn zznVar, long j2) throws RemoteException {
        a();
        l5 l5Var = this.f17687f.H().f18176c;
        Bundle bundle = new Bundle();
        if (l5Var != null) {
            this.f17687f.H().a0();
            l5Var.onActivitySaveInstanceState((Activity) ObjectWrapper.k0(iObjectWrapper), bundle);
        }
        try {
            zznVar.J(bundle);
        } catch (RemoteException e2) {
            this.f17687f.h().K().b("Error returning bundle value to wrapper", e2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        a();
        l5 l5Var = this.f17687f.H().f18176c;
        if (l5Var != null) {
            this.f17687f.H().a0();
            l5Var.onActivityStarted((Activity) ObjectWrapper.k0(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        a();
        l5 l5Var = this.f17687f.H().f18176c;
        if (l5Var != null) {
            this.f17687f.H().a0();
            l5Var.onActivityStopped((Activity) ObjectWrapper.k0(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void performAction(Bundle bundle, zzn zznVar, long j2) throws RemoteException {
        a();
        zznVar.J(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void registerOnMeasurementEventListener(zzs zzsVar) throws RemoteException {
        a();
        zzha bVar = this.f17688g.get(Integer.valueOf(zzsVar.a()));
        if (bVar == null) {
            bVar = new b(zzsVar);
            this.f17688g.put(Integer.valueOf(zzsVar.a()), bVar);
        }
        this.f17687f.H().K(bVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void resetAnalyticsData(long j2) throws RemoteException {
        a();
        this.f17687f.H().z0(j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setConditionalUserProperty(Bundle bundle, long j2) throws RemoteException {
        a();
        if (bundle == null) {
            this.f17687f.h().H().a("Conditional user property must not be null");
        } else {
            this.f17687f.H().I(bundle, j2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j2) throws RemoteException {
        a();
        this.f17687f.Q().F((Activity) ObjectWrapper.k0(iObjectWrapper), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        a();
        this.f17687f.H().w0(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setEventInterceptor(zzs zzsVar) throws RemoteException {
        a();
        zzhc zzhcVarH = this.f17687f.H();
        a aVar = new a(zzsVar);
        zzhcVarH.b();
        zzhcVarH.x();
        zzhcVarH.g().z(new a5(zzhcVarH, aVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setInstanceIdProvider(zzt zztVar) throws RemoteException {
        a();
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setMeasurementEnabled(boolean z, long j2) throws RemoteException {
        a();
        this.f17687f.H().Z(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setMinimumSessionDuration(long j2) throws RemoteException {
        a();
        this.f17687f.H().F(j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setSessionTimeoutDuration(long j2) throws RemoteException {
        a();
        this.f17687f.H().o0(j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setUserId(String str, long j2) throws RemoteException {
        a();
        this.f17687f.H().X(null, "_id", str, true, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j2) throws RemoteException {
        a();
        this.f17687f.H().X(str, str2, ObjectWrapper.k0(iObjectWrapper), z, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void unregisterOnMeasurementEventListener(zzs zzsVar) throws RemoteException {
        a();
        zzha zzhaVarRemove = this.f17688g.remove(Integer.valueOf(zzsVar.a()));
        if (zzhaVarRemove == null) {
            zzhaVarRemove = new b(zzsVar);
        }
        this.f17687f.H().r0(zzhaVarRemove);
    }
}
