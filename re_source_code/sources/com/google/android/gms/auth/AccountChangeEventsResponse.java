package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public class AccountChangeEventsResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new zzc();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final List<AccountChangeEvent> f11388g;

    @SafeParcelable.Constructor
    AccountChangeEventsResponse(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) List<AccountChangeEvent> list) {
        this.f11387f = i2;
        this.f11388g = (List) Preconditions.k(list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f11387f);
        SafeParcelWriter.y(parcel, 2, this.f11388g, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
