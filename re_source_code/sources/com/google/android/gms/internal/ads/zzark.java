package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class zzark extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzark> CREATOR = new zzarl();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f14099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final List<String> f14100g;

    public zzark() {
        this(false, Collections.emptyList());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.c(parcel, 2, this.f14099f);
        SafeParcelWriter.w(parcel, 3, this.f14100g, false);
        SafeParcelWriter.b(parcel, iA);
    }

    @SafeParcelable.Constructor
    public zzark(@SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) List<String> list) {
        this.f14099f = z;
        this.f14100g = list;
    }
}
