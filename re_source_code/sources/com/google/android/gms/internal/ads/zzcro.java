package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcro implements zzcuz<Bundle> {
    private final zzyd a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f15570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f15571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f15572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f15573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f15574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f15575h;

    public zzcro(zzyd zzydVar, String str, boolean z, String str2, float f2, int i2, int i3, String str3) {
        Preconditions.l(zzydVar, "the adSize must not be null");
        this.a = zzydVar;
        this.f15569b = str;
        this.f15570c = z;
        this.f15571d = str2;
        this.f15572e = f2;
        this.f15573f = i2;
        this.f15574g = i3;
        this.f15575h = str3;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzcxz.f(bundle2, "smart_w", "full", this.a.f16991j == -1);
        zzcxz.f(bundle2, "smart_h", "auto", this.a.f16988g == -2);
        zzcxz.c(bundle2, "ene", Boolean.TRUE, this.a.o);
        zzcxz.e(bundle2, "format", this.f15569b);
        zzcxz.f(bundle2, "fluid", "height", this.f15570c);
        String str = this.f15571d;
        zzcxz.f(bundle2, "sz", str, !TextUtils.isEmpty(str));
        bundle2.putFloat("u_sd", this.f15572e);
        bundle2.putInt("sw", this.f15573f);
        bundle2.putInt("sh", this.f15574g);
        String str2 = this.f15575h;
        zzcxz.f(bundle2, "sc", str2, true ^ TextUtils.isEmpty(str2));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        zzyd[] zzydVarArr = this.a.l;
        if (zzydVarArr == null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt("height", this.a.f16988g);
            bundle3.putInt("width", this.a.f16991j);
            bundle3.putBoolean("is_fluid_height", this.a.n);
            arrayList.add(bundle3);
        } else {
            for (zzyd zzydVar : zzydVarArr) {
                Bundle bundle4 = new Bundle();
                bundle4.putBoolean("is_fluid_height", zzydVar.n);
                bundle4.putInt("height", zzydVar.f16988g);
                bundle4.putInt("width", zzydVar.f16991j);
                arrayList.add(bundle4);
            }
        }
        bundle2.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
