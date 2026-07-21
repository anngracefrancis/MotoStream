package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcvk implements zzcva<zzcvj> {
    private final zzbbl a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f15681b;

    public zzcvk(zzbbl zzbblVar, Context context) {
        this.a = zzbblVar;
        this.f15681b = context;
    }

    final /* synthetic */ zzcvj a() throws Exception {
        int i2;
        boolean zIsActiveNetworkMetered;
        int i3;
        int iOrdinal;
        TelephonyManager telephonyManager = (TelephonyManager) this.f15681b.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        int networkType = telephonyManager.getNetworkType();
        int phoneType = telephonyManager.getPhoneType();
        zzk.zzlg();
        int type = -1;
        if (zzaxi.f0(this.f15681b, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f15681b.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                type = activeNetworkInfo.getType();
                iOrdinal = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                iOrdinal = -1;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                i2 = type;
                i3 = iOrdinal;
                zIsActiveNetworkMetered = connectivityManager.isActiveNetworkMetered();
            } else {
                i2 = type;
                i3 = iOrdinal;
                zIsActiveNetworkMetered = false;
            }
        } else {
            i2 = -2;
            zIsActiveNetworkMetered = false;
            i3 = -1;
        }
        return new zzcvj(networkOperator, i2, networkType, phoneType, zIsActiveNetworkMetered, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcvj> b() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.ep

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcvk f12541f;

            {
                this.f12541f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f12541f.a();
            }
        });
    }
}
