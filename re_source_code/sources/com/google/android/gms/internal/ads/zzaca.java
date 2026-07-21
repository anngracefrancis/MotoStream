package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class zzaca extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaca> CREATOR = new zzacb();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f13783f;

    public zzaca(SearchAdRequest searchAdRequest) {
        this.f13783f = searchAdRequest.getQuery();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 15, this.f13783f, false);
        SafeParcelWriter.b(parcel, iA);
    }

    @SafeParcelable.Constructor
    zzaca(@SafeParcelable.Param(id = 15) String str) {
        this.f13783f = str;
    }
}
