package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public class ActivityTransitionResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionResult> CREATOR = new zzg();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final List<ActivityTransitionEvent> f17612f;

    @SafeParcelable.Constructor
    public ActivityTransitionResult(@SafeParcelable.Param(id = 1) List<ActivityTransitionEvent> list) {
        Preconditions.l(list, "transitionEvents list can't be null.");
        if (!list.isEmpty()) {
            for (int i2 = 1; i2 < list.size(); i2++) {
                Preconditions.a(list.get(i2).z() >= list.get(i2 + (-1)).z());
            }
        }
        this.f17612f = Collections.unmodifiableList(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f17612f.equals(((ActivityTransitionResult) obj).f17612f);
    }

    public int hashCode() {
        return this.f17612f.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.y(parcel, 1, y(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    public List<ActivityTransitionEvent> y() {
        return this.f17612f;
    }
}
