package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class IdToken extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<IdToken> CREATOR = new zzk();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f11479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f11480g;

    @SafeParcelable.Constructor
    public IdToken(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        Preconditions.b(!TextUtils.isEmpty(str), "account type string cannot be null or empty");
        Preconditions.b(!TextUtils.isEmpty(str2), "id token string cannot be null or empty");
        this.f11479f = str;
        this.f11480g = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdToken)) {
            return false;
        }
        IdToken idToken = (IdToken) obj;
        return Objects.a(this.f11479f, idToken.f11479f) && Objects.a(this.f11480g, idToken.f11480g);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, y(), false);
        SafeParcelWriter.u(parcel, 2, z(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final String y() {
        return this.f11479f;
    }

    public final String z() {
        return this.f11480g;
    }
}
