package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class s3 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzd f17946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ ServiceConnection f17947g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzfl f17948h;

    s3(zzfl zzflVar, zzd zzdVar, ServiceConnection serviceConnection) {
        this.f17948h = zzflVar;
        this.f17946f = zzdVar;
        this.f17947g = serviceConnection;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f1  */
    @Override // java.lang.Runnable
    public final void run() {
        zzfl zzflVar = this.f17948h;
        zzfm zzfmVar = zzflVar.f18135g;
        String str = zzflVar.f18134f;
        zzd zzdVar = this.f17946f;
        ServiceConnection serviceConnection = this.f17947g;
        Bundle bundleA = zzfmVar.a(str, zzdVar);
        zzfmVar.a.g().d();
        if (bundleA != null) {
            long j2 = bundleA.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j2 == 0) {
                zzfmVar.a.h().H().a("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundleA.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzfmVar.a.h().H().a("No referrer defined in install referrer response");
                } else {
                    zzfmVar.a.h().P().b("InstallReferrer API result", string);
                    Bundle bundleY = zzfmVar.a.I().y(Uri.parse(string.length() != 0 ? "?".concat(string) : new String("?")));
                    if (bundleY == null) {
                        zzfmVar.a.h().H().a("No campaign params defined in install referrer result");
                    } else {
                        String string2 = bundleY.getString("medium");
                        if ((string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) ? false : true) {
                            long j3 = bundleA.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j3 == 0) {
                                zzfmVar.a.h().H().a("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                bundleY.putLong("click_timestamp", j3);
                                if (j2 == zzfmVar.a.B().l.a()) {
                                    zzfmVar.a.G();
                                    zzfmVar.a.h().P().a("Campaign has already been logged");
                                } else {
                                    zzfmVar.a.B().l.b(j2);
                                    zzfmVar.a.G();
                                    zzfmVar.a.h().P().b("Logging Install Referrer campaign from sdk with ", "referrer API");
                                    bundleY.putString("_cis", "referrer API");
                                    zzfmVar.a.H().S("auto", "_cmp", bundleY);
                                }
                            }
                        } else if (j2 == zzfmVar.a.B().l.a()) {
                            zzfmVar.a.G();
                            zzfmVar.a.h().P().a("Campaign has already been logged");
                        } else {
                            zzfmVar.a.B().l.b(j2);
                            zzfmVar.a.G();
                            zzfmVar.a.h().P().b("Logging Install Referrer campaign from sdk with ", "referrer API");
                            bundleY.putString("_cis", "referrer API");
                            zzfmVar.a.H().S("auto", "_cmp", bundleY);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.b().c(zzfmVar.a.f(), serviceConnection);
        }
    }
}
