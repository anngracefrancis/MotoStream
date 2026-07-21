package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzami extends zzbjg {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicBoolean f13966f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AppMeasurementSdk f13967g;

    private zzami(AppMeasurementSdk appMeasurementSdk) {
        this.f13967g = appMeasurementSdk;
    }

    public static void h7(final Context context, final String str) {
        if (f13966f.compareAndSet(false, true)) {
            new Thread(new Runnable(context, str) { // from class: com.google.android.gms.internal.ads.q2

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final Context f13214f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private final String f13215g;

                {
                    this.f13214f = context;
                    this.f13215g = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzami.i7(this.f13214f, this.f13215g);
                }
            }).start();
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x002a  */
    static final /* synthetic */ void i7(Context context, String str) {
        boolean z;
        zzacu.a(context);
        if (((Boolean) zzyt.e().c(zzacu.H0)).booleanValue()) {
            z = true;
        } else {
            if (((Boolean) zzyt.e().c(zzacu.G0)).booleanValue()) {
                z = true;
            } else {
                z = false;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("measurementEnabled", z);
        try {
            ((zzbjh) zzbae.a(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", r2.a)).A1(new zzami(AppMeasurementSdk.k(context, "Ads", "am", str, bundle)));
        } catch (RemoteException | zzbag | NullPointerException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final long E2() throws RemoteException {
        return this.f13967g.d();
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final int I3(String str) throws RemoteException {
        return this.f13967g.l(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final String J2() throws RemoteException {
        return this.f13967g.i();
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final List L4(String str, String str2) throws RemoteException {
        return this.f13967g.g(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void N5(String str, String str2, IObjectWrapper iObjectWrapper) throws RemoteException {
        this.f13967g.s(str, str2, iObjectWrapper != null ? ObjectWrapper.k0(iObjectWrapper) : null);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final String O4() throws RemoteException {
        return this.f13967g.h();
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void O5(String str) throws RemoteException {
        this.f13967g.a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void Q4(Bundle bundle) throws RemoteException {
        this.f13967g.q(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void V6(String str) throws RemoteException {
        this.f13967g.c(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        this.f13967g.b(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final Map d4(String str, String str2, boolean z) throws RemoteException {
        return this.f13967g.m(str, str2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void e1(Bundle bundle) throws RemoteException {
        this.f13967g.o(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final String g2() throws RemoteException {
        return this.f13967g.f();
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final String l4() throws RemoteException {
        return this.f13967g.e();
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void m0(String str, String str2, Bundle bundle) throws RemoteException {
        this.f13967g.n(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final String o4() throws RemoteException {
        return this.f13967g.j();
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final Bundle s2(Bundle bundle) throws RemoteException {
        return this.f13967g.p(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final void z4(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        this.f13967g.r(iObjectWrapper != null ? (Activity) ObjectWrapper.k0(iObjectWrapper) : null, str, str2);
    }
}
