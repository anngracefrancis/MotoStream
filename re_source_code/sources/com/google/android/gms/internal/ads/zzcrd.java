package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzk;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcrd implements zzcuz<Bundle> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzyd f15559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Parcelable> f15560c;

    public zzcrd(Context context, zzyd zzydVar, List<Parcelable> list) {
        this.a = context;
        this.f15559b = zzydVar;
        this.f15560c = list;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzk.zzlg();
        bundle2.putString("activity", zzaxi.z(this.a));
        Bundle bundle3 = new Bundle();
        bundle3.putInt("width", this.f15559b.f16991j);
        bundle3.putInt("height", this.f15559b.f16988g);
        bundle2.putBundle("size", bundle3);
        if (this.f15560c.size() > 0) {
            List<Parcelable> list = this.f15560c;
            bundle2.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
        }
    }
}
