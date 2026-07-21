package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class CloudMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CloudMessage> CREATOR = new zzb();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private Intent f11569f;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
    /* JADX INFO: loaded from: classes.dex */
    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    @SafeParcelable.Constructor
    public CloudMessage(@SafeParcelable.Param(id = 1) Intent intent) {
        this.f11569f = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.f11569f, i2, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final Intent y() {
        return this.f11569f;
    }
}
