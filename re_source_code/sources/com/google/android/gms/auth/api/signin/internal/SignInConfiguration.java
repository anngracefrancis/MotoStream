package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzx();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f11527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private GoogleSignInOptions f11528g;

    @SafeParcelable.Constructor
    public SignInConfiguration(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 5) GoogleSignInOptions googleSignInOptions) {
        this.f11527f = Preconditions.g(str);
        this.f11528g = googleSignInOptions;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f11527f.equals(signInConfiguration.f11527f)) {
            GoogleSignInOptions googleSignInOptions = this.f11528g;
            if (googleSignInOptions == null) {
                if (signInConfiguration.f11528g == null) {
                    return true;
                }
            } else if (googleSignInOptions.equals(signInConfiguration.f11528g)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return new HashAccumulator().a(this.f11527f).a(this.f11528g).b();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, this.f11527f, false);
        SafeParcelWriter.s(parcel, 5, this.f11528g, i2, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final GoogleSignInOptions y() {
        return this.f11528g;
    }
}
