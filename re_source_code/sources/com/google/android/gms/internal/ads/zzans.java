package com.google.android.gms.internal.ads;

import android.location.Location;
import cm.aptoide.pt.account.AdultContentAnalytics;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzans implements NativeMediationAdRequest {
    private final Date a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<String> f14016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f14017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Location f14018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f14019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzady f14020g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f14022i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f14024k;
    private final String l;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<String> f14021h = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map<String, Boolean> f14023j = new HashMap();

    public zzans(Date date, int i2, Set<String> set, Location location, boolean z, int i3, zzady zzadyVar, List<String> list, boolean z2, int i4, String str) {
        this.a = date;
        this.f14015b = i2;
        this.f14016c = set;
        this.f14018e = location;
        this.f14017d = z;
        this.f14019f = i3;
        this.f14020g = zzadyVar;
        this.f14022i = z2;
        this.f14024k = i4;
        this.l = str;
        if (list != null) {
            for (String str2 : list) {
                if (str2.startsWith("custom:")) {
                    String[] strArrSplit = str2.split(":", 3);
                    if (strArrSplit.length == 3) {
                        if ("true".equals(strArrSplit[2])) {
                            this.f14023j.put(strArrSplit[1], Boolean.TRUE);
                        } else if (AdultContentAnalytics.UNLOCK.equals(strArrSplit[2])) {
                            this.f14023j.put(strArrSplit[1], Boolean.FALSE);
                        }
                    }
                } else {
                    this.f14021h.add(str2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final float getAdVolume() {
        return zzabe.j().h();
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final Date getBirthday() {
        return this.a;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final int getGender() {
        return this.f14015b;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set<String> getKeywords() {
        return this.f14016c;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Location getLocation() {
        return this.f14018e;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final NativeAdOptions getNativeAdOptions() {
        zzacd zzacdVar;
        if (this.f14020g == null) {
            return null;
        }
        NativeAdOptions.Builder requestMultipleImages = new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.f14020g.f13846g).setImageOrientation(this.f14020g.f13847h).setRequestMultipleImages(this.f14020g.f13848i);
        zzady zzadyVar = this.f14020g;
        if (zzadyVar.f13845f >= 2) {
            requestMultipleImages.setAdChoicesPlacement(zzadyVar.f13849j);
        }
        zzady zzadyVar2 = this.f14020g;
        if (zzadyVar2.f13845f >= 3 && (zzacdVar = zzadyVar2.f13850k) != null) {
            requestMultipleImages.setVideoOptions(new VideoOptions(zzacdVar));
        }
        return requestMultipleImages.build();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAdMuted() {
        return zzabe.j().i();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAppInstallAdRequested() {
        List<String> list = this.f14021h;
        if (list != null) {
            return list.contains("2") || this.f14021h.contains("6");
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isContentAdRequested() {
        List<String> list = this.f14021h;
        if (list != null) {
            return list.contains("1") || this.f14021h.contains("6");
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.f14022i;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isTesting() {
        return this.f14017d;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isUnifiedNativeAdRequested() {
        List<String> list = this.f14021h;
        return list != null && list.contains("6");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.f14019f;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean zzsu() {
        List<String> list = this.f14021h;
        return list != null && list.contains("3");
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final Map<String, Boolean> zzsv() {
        return this.f14023j;
    }
}
