package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public class ActivityTransitionEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new zzd();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f17605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f17606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final long f17607h;

    @SafeParcelable.Constructor
    public ActivityTransitionEvent(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) long j2) {
        DetectedActivity.W(i2);
        ActivityTransition.W(i3);
        this.f17605f = i2;
        this.f17606g = i3;
        this.f17607h = j2;
    }

    public int W() {
        return this.f17606g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransitionEvent)) {
            return false;
        }
        ActivityTransitionEvent activityTransitionEvent = (ActivityTransitionEvent) obj;
        return this.f17605f == activityTransitionEvent.f17605f && this.f17606g == activityTransitionEvent.f17606g && this.f17607h == activityTransitionEvent.f17607h;
    }

    public int hashCode() {
        return Objects.b(Integer.valueOf(this.f17605f), Integer.valueOf(this.f17606g), Long.valueOf(this.f17607h));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i2 = this.f17605f;
        StringBuilder sb2 = new StringBuilder(24);
        sb2.append("ActivityType ");
        sb2.append(i2);
        sb.append(sb2.toString());
        sb.append(" ");
        int i3 = this.f17606g;
        StringBuilder sb3 = new StringBuilder(26);
        sb3.append("TransitionType ");
        sb3.append(i3);
        sb.append(sb3.toString());
        sb.append(" ");
        long j2 = this.f17607h;
        StringBuilder sb4 = new StringBuilder(41);
        sb4.append("ElapsedRealTimeNanos ");
        sb4.append(j2);
        sb.append(sb4.toString());
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, y());
        SafeParcelWriter.l(parcel, 2, W());
        SafeParcelWriter.p(parcel, 3, z());
        SafeParcelWriter.b(parcel, iA);
    }

    public int y() {
        return this.f17605f;
    }

    public long z() {
        return this.f17607h;
    }
}
