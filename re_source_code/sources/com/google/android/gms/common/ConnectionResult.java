package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class ConnectionResult extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.VersionField
    final int f11620g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f11621h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final PendingIntent f11622i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f11623j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @ShowFirstParty
    @KeepForSdk
    public static final ConnectionResult f11619f = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new zzb();

    public ConnectionResult(int i2) {
        this(i2, null, null);
    }

    @SafeParcelable.Constructor
    ConnectionResult(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) PendingIntent pendingIntent, @SafeParcelable.Param(id = 4) String str) {
        this.f11620g = i2;
        this.f11621h = i3;
        this.f11622i = pendingIntent;
        this.f11623j = str;
    }

    static String p0(int i2) {
        if (i2 == 99) {
            return "UNFINISHED";
        }
        if (i2 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i2) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i2) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i2 + ")";
                }
        }
    }

    public PendingIntent W() {
        return this.f11622i;
    }

    public boolean Y() {
        return (this.f11621h == 0 || this.f11622i == null) ? false : true;
    }

    public boolean e0() {
        return this.f11621h == 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f11621h == connectionResult.f11621h && Objects.a(this.f11622i, connectionResult.f11622i) && Objects.a(this.f11623j, connectionResult.f11623j);
    }

    public int hashCode() {
        return Objects.b(Integer.valueOf(this.f11621h), this.f11622i, this.f11623j);
    }

    public void i0(Activity activity, int i2) throws IntentSender.SendIntentException {
        if (Y()) {
            PendingIntent pendingIntent = this.f11622i;
            Preconditions.k(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i2, null, 0, 0, 0);
        }
    }

    public String toString() {
        Objects.ToStringHelper toStringHelperC = Objects.c(this);
        toStringHelperC.a("statusCode", p0(this.f11621h));
        toStringHelperC.a("resolution", this.f11622i);
        toStringHelperC.a("message", this.f11623j);
        return toStringHelperC.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f11620g);
        SafeParcelWriter.l(parcel, 2, y());
        SafeParcelWriter.s(parcel, 3, W(), i2, false);
        SafeParcelWriter.u(parcel, 4, z(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    public int y() {
        return this.f11621h;
    }

    public String z() {
        return this.f11623j;
    }

    public ConnectionResult(int i2, PendingIntent pendingIntent) {
        this(i2, pendingIntent, null);
    }

    public ConnectionResult(int i2, PendingIntent pendingIntent, String str) {
        this(1, i2, pendingIntent, str);
    }
}
