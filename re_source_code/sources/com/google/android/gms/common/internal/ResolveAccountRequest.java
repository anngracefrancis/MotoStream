package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new zam();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final Account f11995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f11996h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final GoogleSignInAccount f11997i;

    @SafeParcelable.Constructor
    ResolveAccountRequest(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) Account account, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) GoogleSignInAccount googleSignInAccount) {
        this.f11994f = i2;
        this.f11995g = account;
        this.f11996h = i3;
        this.f11997i = googleSignInAccount;
    }

    public Account getAccount() {
        return this.f11995g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f11994f);
        SafeParcelWriter.s(parcel, 2, getAccount(), i2, false);
        SafeParcelWriter.l(parcel, 3, y());
        SafeParcelWriter.s(parcel, 4, z(), i2, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public int y() {
        return this.f11996h;
    }

    public GoogleSignInAccount z() {
        return this.f11997i;
    }

    public ResolveAccountRequest(Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i2, googleSignInAccount);
    }
}
