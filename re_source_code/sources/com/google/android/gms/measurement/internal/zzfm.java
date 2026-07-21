package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzd;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfm {
    final zzfx a;

    zzfm(zzfx zzfxVar) {
        this.a = zzfxVar;
    }

    @VisibleForTesting
    private final boolean c() {
        try {
            PackageManagerWrapper packageManagerWrapperA = Wrappers.a(this.a.f());
            if (packageManagerWrapperA != null) {
                return packageManagerWrapperA.e("com.android.vending", 128).versionCode >= 80837300;
            }
            this.a.h().N().a("Failed to retrieve Package Manager to check Play Store compatibility");
            return false;
        } catch (Exception e2) {
            this.a.h().N().b("Failed to retrieve Play Store version", e2);
            return false;
        }
    }

    @VisibleForTesting
    final Bundle a(String str, zzd zzdVar) {
        this.a.g().d();
        if (zzdVar == null) {
            this.a.h().K().a("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle bundleJ = zzdVar.J(bundle);
            if (bundleJ != null) {
                return bundleJ;
            }
            this.a.h().H().a("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e2) {
            this.a.h().H().b("Exception occurred while retrieving the Install Referrer", e2.getMessage());
            return null;
        }
    }

    protected final void b(String str) {
        if (str == null || str.isEmpty()) {
            this.a.h().N().a("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.a.g().d();
        if (!c()) {
            this.a.h().N().a("Install Referrer Reporter is not available");
            return;
        }
        this.a.h().N().a("Install Referrer Reporter is initializing");
        zzfl zzflVar = new zzfl(this, str);
        this.a.g().d();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.a.f().getPackageManager();
        if (packageManager == null) {
            this.a.h().K().a("Failed to obtain Package Manager to verify binding conditions");
            return;
        }
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            this.a.h().N().a("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
        if (serviceInfo != null) {
            String str2 = serviceInfo.packageName;
            if (serviceInfo.name == null || !"com.android.vending".equals(str2) || !c()) {
                this.a.h().N().a("Play Store missing or incompatible. Version 8.3.73 or later required");
                return;
            }
            try {
                this.a.h().N().b("Install Referrer Service is", ConnectionTracker.b().a(this.a.f(), new Intent(intent), zzflVar, 1) ? "available" : "not available");
            } catch (Exception e2) {
                this.a.h().H().b("Exception occurred while binding to Install Referrer Service", e2.getMessage());
            }
        }
    }
}
