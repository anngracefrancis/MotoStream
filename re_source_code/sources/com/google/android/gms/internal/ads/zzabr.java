package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzabr extends zzaac {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzait f13780f;

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void B2(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final float C4() throws RemoteException {
        return 1.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final String H3() {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final boolean J3() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void N2(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void O0(zzamp zzampVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final List<zzaio> T2() throws RemoteException {
        return Collections.EMPTY_LIST;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void Y1(zzait zzaitVar) throws RemoteException {
        this.f13780f = zzaitVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void a() throws RemoteException {
        zzbad.g("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzazt.a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.h

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzabr f12673f;

            {
                this.f12673f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12673f.h7();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void c2(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void e5(String str) throws RemoteException {
    }

    final /* synthetic */ void h7() {
        zzait zzaitVar = this.f13780f;
        if (zzaitVar != null) {
            try {
                zzaitVar.u0(Collections.EMPTY_LIST);
            } catch (RemoteException e2) {
                zzbad.d("Could not notify onComplete event.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void t6(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void v5(float f2) throws RemoteException {
    }
}
