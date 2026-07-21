package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public class ActivityRecognitionResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new zzb();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private List<DetectedActivity> f17597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private long f17598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private long f17599h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private int f17600i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private Bundle f17601j;

    @SafeParcelable.Constructor
    public ActivityRecognitionResult(@SafeParcelable.Param(id = 1) List<DetectedActivity> list, @SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 3) long j3, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) Bundle bundle) {
        Preconditions.b(list != null && list.size() > 0, "Must have at least 1 detected activity");
        Preconditions.b(j2 > 0 && j3 > 0, "Must set times");
        this.f17597f = list;
        this.f17598g = j2;
        this.f17599h = j3;
        this.f17600i = i2;
        this.f17601j = bundle;
    }

    private static boolean y(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return true;
        }
        if ((bundle == null && bundle2 != null) || ((bundle != null && bundle2 == null) || bundle.size() != bundle2.size())) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            if (bundle.get(str) == null) {
                if (bundle2.get(str) != null) {
                    return false;
                }
            } else if (bundle.get(str) instanceof Bundle) {
                if (!y(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else if (!bundle.get(str).equals(bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
            if (this.f17598g == activityRecognitionResult.f17598g && this.f17599h == activityRecognitionResult.f17599h && this.f17600i == activityRecognitionResult.f17600i && Objects.a(this.f17597f, activityRecognitionResult.f17597f) && y(this.f17601j, activityRecognitionResult.f17601j)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(Long.valueOf(this.f17598g), Long.valueOf(this.f17599h), Integer.valueOf(this.f17600i), this.f17597f, this.f17601j);
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f17597f);
        long j2 = this.f17598g;
        long j3 = this.f17599h;
        StringBuilder sb = new StringBuilder(strValueOf.length() + 124);
        sb.append("ActivityRecognitionResult [probableActivities=");
        sb.append(strValueOf);
        sb.append(", timeMillis=");
        sb.append(j2);
        sb.append(", elapsedRealtimeMillis=");
        sb.append(j3);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.y(parcel, 1, this.f17597f, false);
        SafeParcelWriter.p(parcel, 2, this.f17598g);
        SafeParcelWriter.p(parcel, 3, this.f17599h);
        SafeParcelWriter.l(parcel, 4, this.f17600i);
        SafeParcelWriter.e(parcel, 5, this.f17601j, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
