package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f12181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f12182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f12183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f12184i;

    @SafeParcelable.Constructor
    zzq(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) int i3) {
        this.f12181f = z;
        this.f12182g = str;
        this.f12183h = n.a(i2) - 1;
        this.f12184i = b.a(i3) - 1;
    }

    public final int W() {
        return b.a(this.f12184i);
    }

    public final int Y() {
        return n.a(this.f12183h);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.c(parcel, 1, this.f12181f);
        SafeParcelWriter.u(parcel, 2, this.f12182g, false);
        SafeParcelWriter.l(parcel, 3, this.f12183h);
        SafeParcelWriter.l(parcel, 4, this.f12184i);
        SafeParcelWriter.b(parcel, iA);
    }

    public final String y() {
        return this.f12182g;
    }

    public final boolean z() {
        return this.f12181f;
    }
}
