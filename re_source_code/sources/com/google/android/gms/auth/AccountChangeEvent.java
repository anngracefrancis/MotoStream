package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final long f11378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f11379h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f11380i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f11381j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f11382k;

    @SafeParcelable.Constructor
    AccountChangeEvent(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) int i3, @SafeParcelable.Param(id = 5) int i4, @SafeParcelable.Param(id = 6) String str2) {
        this.f11377f = i2;
        this.f11378g = j2;
        this.f11379h = (String) Preconditions.k(str);
        this.f11380i = i3;
        this.f11381j = i4;
        this.f11382k = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AccountChangeEvent) {
            AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
            if (this.f11377f == accountChangeEvent.f11377f && this.f11378g == accountChangeEvent.f11378g && Objects.a(this.f11379h, accountChangeEvent.f11379h) && this.f11380i == accountChangeEvent.f11380i && this.f11381j == accountChangeEvent.f11381j && Objects.a(this.f11382k, accountChangeEvent.f11382k)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(Integer.valueOf(this.f11377f), Long.valueOf(this.f11378g), this.f11379h, Integer.valueOf(this.f11380i), Integer.valueOf(this.f11381j), this.f11382k);
    }

    public String toString() {
        String str;
        int i2 = this.f11380i;
        if (i2 == 1) {
            str = "ADDED";
        } else if (i2 == 2) {
            str = "REMOVED";
        } else if (i2 != 3) {
            str = i2 != 4 ? "UNKNOWN" : "RENAMED_TO";
        } else {
            str = "RENAMED_FROM";
        }
        String str2 = this.f11379h;
        String str3 = this.f11382k;
        int i3 = this.f11381j;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 91 + str.length() + String.valueOf(str3).length());
        sb.append("AccountChangeEvent {accountName = ");
        sb.append(str2);
        sb.append(", changeType = ");
        sb.append(str);
        sb.append(", changeData = ");
        sb.append(str3);
        sb.append(", eventIndex = ");
        sb.append(i3);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f11377f);
        SafeParcelWriter.p(parcel, 2, this.f11378g);
        SafeParcelWriter.u(parcel, 3, this.f11379h, false);
        SafeParcelWriter.l(parcel, 4, this.f11380i);
        SafeParcelWriter.l(parcel, 5, this.f11381j);
        SafeParcelWriter.u(parcel, 6, this.f11382k, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
