package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public class TokenData extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<TokenData> CREATOR = new zzk();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f11392g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final Long f11393h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f11394i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f11395j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private final List<String> f11396k;

    @SafeParcelable.Field
    private final String l;

    @SafeParcelable.Constructor
    TokenData(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) Long l, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) List<String> list, @SafeParcelable.Param(id = 7) String str2) {
        this.f11391f = i2;
        this.f11392g = Preconditions.g(str);
        this.f11393h = l;
        this.f11394i = z;
        this.f11395j = z2;
        this.f11396k = list;
        this.l = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.f11392g, tokenData.f11392g) && Objects.a(this.f11393h, tokenData.f11393h) && this.f11394i == tokenData.f11394i && this.f11395j == tokenData.f11395j && Objects.a(this.f11396k, tokenData.f11396k) && Objects.a(this.l, tokenData.l);
    }

    public int hashCode() {
        return Objects.b(this.f11392g, this.f11393h, Boolean.valueOf(this.f11394i), Boolean.valueOf(this.f11395j), this.f11396k, this.l);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f11391f);
        SafeParcelWriter.u(parcel, 2, this.f11392g, false);
        SafeParcelWriter.q(parcel, 3, this.f11393h, false);
        SafeParcelWriter.c(parcel, 4, this.f11394i);
        SafeParcelWriter.c(parcel, 5, this.f11395j);
        SafeParcelWriter.w(parcel, 6, this.f11396k, false);
        SafeParcelWriter.u(parcel, 7, this.l, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
