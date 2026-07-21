package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcgy implements zzdti<zzbbh<zzarx>> {
    private final zzdtu<zzczt> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbh<Bundle>> f15215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbai> f15216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<ApplicationInfo> f15217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<String> f15218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdtu<List<String>> f15219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzdtu<PackageInfo> f15220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzdtu<zzbbh<String>> f15221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzdtu<zzaxb> f15222i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzdtu<String> f15223j;

    private zzcgy(zzdtu<zzczt> zzdtuVar, zzdtu<zzbbh<Bundle>> zzdtuVar2, zzdtu<zzbai> zzdtuVar3, zzdtu<ApplicationInfo> zzdtuVar4, zzdtu<String> zzdtuVar5, zzdtu<List<String>> zzdtuVar6, zzdtu<PackageInfo> zzdtuVar7, zzdtu<zzbbh<String>> zzdtuVar8, zzdtu<zzaxb> zzdtuVar9, zzdtu<String> zzdtuVar10) {
        this.a = zzdtuVar;
        this.f15215b = zzdtuVar2;
        this.f15216c = zzdtuVar3;
        this.f15217d = zzdtuVar4;
        this.f15218e = zzdtuVar5;
        this.f15219f = zzdtuVar6;
        this.f15220g = zzdtuVar7;
        this.f15221h = zzdtuVar8;
        this.f15222i = zzdtuVar9;
        this.f15223j = zzdtuVar10;
    }

    public static zzcgy a(zzdtu<zzczt> zzdtuVar, zzdtu<zzbbh<Bundle>> zzdtuVar2, zzdtu<zzbai> zzdtuVar3, zzdtu<ApplicationInfo> zzdtuVar4, zzdtu<String> zzdtuVar5, zzdtu<List<String>> zzdtuVar6, zzdtu<PackageInfo> zzdtuVar7, zzdtu<zzbbh<String>> zzdtuVar8, zzdtu<zzaxb> zzdtuVar9, zzdtu<String> zzdtuVar10) {
        return new zzcgy(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6, zzdtuVar7, zzdtuVar8, zzdtuVar9, zzdtuVar10);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzczt zzcztVar = this.a.get();
        final zzbbh<Bundle> zzbbhVar = this.f15215b.get();
        final zzbai zzbaiVar = this.f15216c.get();
        final ApplicationInfo applicationInfo = this.f15217d.get();
        final String str = this.f15218e.get();
        final List<String> list = this.f15219f.get();
        final PackageInfo packageInfo = this.f15220g.get();
        final zzbbh<String> zzbbhVar2 = this.f15221h.get();
        final zzaxb zzaxbVar = this.f15222i.get();
        final String str2 = this.f15223j.get();
        return (zzbbh) zzdto.b(zzcztVar.b(zzczs.REQUEST_PARCEL, zzbbhVar, zzbbhVar2).a(new Callable(zzbbhVar, zzbaiVar, applicationInfo, str, list, packageInfo, zzbbhVar2, zzaxbVar, str2) { // from class: com.google.android.gms.internal.ads.zi

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbbh f13708f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzbai f13709g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final ApplicationInfo f13710h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private final String f13711i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private final List f13712j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private final PackageInfo f13713k;
            private final zzbbh l;
            private final zzaxb m;
            private final String n;

            {
                this.f13708f = zzbbhVar;
                this.f13709g = zzbaiVar;
                this.f13710h = applicationInfo;
                this.f13711i = str;
                this.f13712j = list;
                this.f13713k = packageInfo;
                this.l = zzbbhVar2;
                this.m = zzaxbVar;
                this.n = str2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzbbh zzbbhVar3 = this.f13708f;
                zzbai zzbaiVar2 = this.f13709g;
                ApplicationInfo applicationInfo2 = this.f13710h;
                String str3 = this.f13711i;
                List list2 = this.f13712j;
                PackageInfo packageInfo2 = this.f13713k;
                zzbbh zzbbhVar4 = this.l;
                zzaxb zzaxbVar2 = this.m;
                return new zzarx((Bundle) zzbbhVar3.get(), zzbaiVar2, applicationInfo2, str3, list2, packageInfo2, (String) zzbbhVar4.get(), zzaxbVar2.w(), this.n);
            }
        }).f(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
