package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public class DetectedActivity extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private int f17617j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private int f17618k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Comparator<DetectedActivity> f17613f = new d();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f17614g = {9, 10};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f17615h = {0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17, 18, 19};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f17616i = {0, 1, 2, 3, 7, 8, 16, 17};
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new zzi();

    @SafeParcelable.Constructor
    public DetectedActivity(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3) {
        this.f17617j = i2;
        this.f17618k = i3;
    }

    public static void W(int i2) {
        boolean z = false;
        for (int i3 : f17616i) {
            if (i3 == i2) {
                z = true;
            }
        }
        if (z) {
            return;
        }
        StringBuilder sb = new StringBuilder(81);
        sb.append(i2);
        sb.append(" is not a valid DetectedActivity supported by Activity Transition API.");
        Log.w("DetectedActivity", sb.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DetectedActivity detectedActivity = (DetectedActivity) obj;
            if (this.f17617j == detectedActivity.f17617j && this.f17618k == detectedActivity.f17618k) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(Integer.valueOf(this.f17617j), Integer.valueOf(this.f17618k));
    }

    public String toString() {
        String string;
        int iZ = z();
        if (iZ == 0) {
            string = "IN_VEHICLE";
        } else if (iZ == 1) {
            string = "ON_BICYCLE";
        } else if (iZ == 2) {
            string = "ON_FOOT";
        } else if (iZ == 3) {
            string = "STILL";
        } else if (iZ == 4) {
            string = "UNKNOWN";
        } else if (iZ == 5) {
            string = "TILTING";
        } else if (iZ == 7) {
            string = "WALKING";
        } else if (iZ != 8) {
            switch (iZ) {
                case 16:
                    string = "IN_ROAD_VEHICLE";
                    break;
                case 17:
                    string = "IN_RAIL_VEHICLE";
                    break;
                case 18:
                    string = "IN_TWO_WHEELER_VEHICLE";
                    break;
                case 19:
                    string = "IN_FOUR_WHEELER_VEHICLE";
                    break;
                default:
                    string = Integer.toString(iZ);
                    break;
            }
        } else {
            string = "RUNNING";
        }
        int i2 = this.f17618k;
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 48);
        sb.append("DetectedActivity [type=");
        sb.append(string);
        sb.append(", confidence=");
        sb.append(i2);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f17617j);
        SafeParcelWriter.l(parcel, 2, this.f17618k);
        SafeParcelWriter.b(parcel, iA);
    }

    public int y() {
        return this.f17618k;
    }

    public int z() {
        int i2 = this.f17617j;
        if (i2 > 19 || i2 < 0) {
            return 4;
        }
        return i2;
    }
}
