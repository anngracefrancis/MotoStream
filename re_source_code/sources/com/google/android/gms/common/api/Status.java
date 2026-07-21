package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {

    @SafeParcelable.VersionField
    final int n;

    @SafeParcelable.Field
    private final int o;

    @SafeParcelable.Field
    private final String p;

    @SafeParcelable.Field
    private final PendingIntent q;

    @SafeParcelable.Field
    private final ConnectionResult r;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @ShowFirstParty
    @VisibleForTesting
    @KeepForSdk
    public static final Status f11687f = new Status(-1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @ShowFirstParty
    @VisibleForTesting
    @KeepForSdk
    public static final Status f11688g = new Status(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @ShowFirstParty
    @KeepForSdk
    public static final Status f11689h = new Status(14);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @ShowFirstParty
    @KeepForSdk
    public static final Status f11690i = new Status(8);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @ShowFirstParty
    @KeepForSdk
    public static final Status f11691j = new Status(15);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @ShowFirstParty
    @KeepForSdk
    public static final Status f11692k = new Status(16);

    @ShowFirstParty
    public static final Status m = new Status(17);

    @KeepForSdk
    public static final Status l = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new zzb();

    public Status(int i2) {
        this(i2, null);
    }

    @SafeParcelable.Constructor
    Status(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) int i3, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) PendingIntent pendingIntent, @SafeParcelable.Param(id = 4) ConnectionResult connectionResult) {
        this.n = i2;
        this.o = i3;
        this.p = str;
        this.q = pendingIntent;
        this.r = connectionResult;
    }

    public String W() {
        return this.p;
    }

    @VisibleForTesting
    public boolean Y() {
        return this.q != null;
    }

    public boolean e0() {
        return this.o <= 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.n == status.n && this.o == status.o && Objects.a(this.p, status.p) && Objects.a(this.q, status.q) && Objects.a(this.r, status.r);
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this;
    }

    public int hashCode() {
        return Objects.b(Integer.valueOf(this.n), Integer.valueOf(this.o), this.p, this.q, this.r);
    }

    public void i0(Activity activity, int i2) throws IntentSender.SendIntentException {
        if (Y()) {
            PendingIntent pendingIntent = this.q;
            Preconditions.k(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i2, null, 0, 0, 0);
        }
    }

    public final String p0() {
        String str = this.p;
        return str != null ? str : CommonStatusCodes.a(this.o);
    }

    public String toString() {
        Objects.ToStringHelper toStringHelperC = Objects.c(this);
        toStringHelperC.a("statusCode", p0());
        toStringHelperC.a("resolution", this.q);
        return toStringHelperC.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, z());
        SafeParcelWriter.u(parcel, 2, W(), false);
        SafeParcelWriter.s(parcel, 3, this.q, i2, false);
        SafeParcelWriter.s(parcel, 4, y(), i2, false);
        SafeParcelWriter.l(parcel, 1000, this.n);
        SafeParcelWriter.b(parcel, iA);
    }

    public ConnectionResult y() {
        return this.r;
    }

    public int z() {
        return this.o;
    }

    public Status(int i2, String str) {
        this(1, i2, str, null, null);
    }

    public Status(int i2, String str, PendingIntent pendingIntent) {
        this(1, i2, str, pendingIntent, null);
    }
}
