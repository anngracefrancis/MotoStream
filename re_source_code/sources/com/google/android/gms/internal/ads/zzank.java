package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzank implements MediationAdRequest {
    private final Date a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<String> f13996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f13997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Location f13998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f13999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f14000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f14001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f14002i;

    public zzank(Date date, int i2, Set<String> set, Location location, boolean z, int i3, boolean z2, int i4, String str) {
        this.a = date;
        this.f13995b = i2;
        this.f13996c = set;
        this.f13998e = location;
        this.f13997d = z;
        this.f13999f = i3;
        this.f14000g = z2;
        this.f14001h = i4;
        this.f14002i = str;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final Date getBirthday() {
        return this.a;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final int getGender() {
        return this.f13995b;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set<String> getKeywords() {
        return this.f13996c;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Location getLocation() {
        return this.f13998e;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.f14000g;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isTesting() {
        return this.f13997d;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.f13999f;
    }
}
