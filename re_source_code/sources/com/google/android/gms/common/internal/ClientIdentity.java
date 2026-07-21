package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
@SafeParcelable.Class
@SafeParcelable.Reserved
public class ClientIdentity extends AbstractSafeParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new zab();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f11942f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f11943g;

    @SafeParcelable.Constructor
    public ClientIdentity(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str) {
        this.f11942f = i2;
        this.f11943g = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof ClientIdentity)) {
            ClientIdentity clientIdentity = (ClientIdentity) obj;
            if (clientIdentity.f11942f == this.f11942f && Objects.a(clientIdentity.f11943g, this.f11943g)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f11942f;
    }

    public String toString() {
        int i2 = this.f11942f;
        String str = this.f11943g;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(i2);
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f11942f);
        SafeParcelWriter.u(parcel, 2, this.f11943g, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
