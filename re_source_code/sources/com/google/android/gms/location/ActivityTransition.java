package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public class ActivityTransition extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new zzc();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f17602f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f17603g;

    public static class Builder {
        private int a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f17604b = -1;
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface SupportedActivityTransition {
    }

    @SafeParcelable.Constructor
    ActivityTransition(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3) {
        this.f17602f = i2;
        this.f17603g = i3;
    }

    public static void W(int i2) {
        boolean z = i2 >= 0 && i2 <= 1;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Transition type ");
        sb.append(i2);
        sb.append(" is not valid.");
        Preconditions.b(z, sb.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransition)) {
            return false;
        }
        ActivityTransition activityTransition = (ActivityTransition) obj;
        return this.f17602f == activityTransition.f17602f && this.f17603g == activityTransition.f17603g;
    }

    public int hashCode() {
        return Objects.b(Integer.valueOf(this.f17602f), Integer.valueOf(this.f17603g));
    }

    public String toString() {
        int i2 = this.f17602f;
        int i3 = this.f17603g;
        StringBuilder sb = new StringBuilder(75);
        sb.append("ActivityTransition [mActivityType=");
        sb.append(i2);
        sb.append(", mTransitionType=");
        sb.append(i3);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, y());
        SafeParcelWriter.l(parcel, 2, z());
        SafeParcelWriter.b(parcel, iA);
    }

    public int y() {
        return this.f17602f;
    }

    public int z() {
        return this.f17603g;
    }
}
