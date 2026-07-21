package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class zzbai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbai> CREATOR = new zzbaj();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public String f14326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public int f14327g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public int f14328h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    public boolean f14329i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private boolean f14330j;

    public zzbai(int i2, int i3, boolean z) {
        this(i2, i3, z, false, false);
    }

    public static zzbai y() {
        return new zzbai(12451009, 12451009, true);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, this.f14326f, false);
        SafeParcelWriter.l(parcel, 3, this.f14327g);
        SafeParcelWriter.l(parcel, 4, this.f14328h);
        SafeParcelWriter.c(parcel, 5, this.f14329i);
        SafeParcelWriter.c(parcel, 6, this.f14330j);
        SafeParcelWriter.b(parcel, iA);
    }

    public zzbai(int i2, int i3, boolean z, boolean z2) {
        this(i2, i3, true, false, false);
    }

    private zzbai(int i2, int i3, boolean z, boolean z2, boolean z3) {
        String str = z ? "0" : "1";
        StringBuilder sb = new StringBuilder(str.length() + 36);
        sb.append("afma-sdk-a-v");
        sb.append(i2);
        sb.append(".");
        sb.append(i3);
        sb.append(".");
        sb.append(str);
        this(sb.toString(), i2, i3, z, false);
    }

    @SafeParcelable.Constructor
    zzbai(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) int i3, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) boolean z2) {
        this.f14326f = str;
        this.f14327g = i2;
        this.f14328h = i3;
        this.f14329i = z;
        this.f14330j = z2;
    }
}
