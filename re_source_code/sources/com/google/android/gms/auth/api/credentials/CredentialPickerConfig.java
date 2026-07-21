package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zze();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f11456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f11457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f11458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    @Deprecated
    private final boolean f11459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f11460j;

    public static class Builder {
        private boolean a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f11461b = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f11462c = 1;

        public CredentialPickerConfig a() {
            return new CredentialPickerConfig(this);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Prompt {
    }

    @SafeParcelable.Constructor
    CredentialPickerConfig(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) boolean z2, @SafeParcelable.Param(id = 3) boolean z3, @SafeParcelable.Param(id = 4) int i3) {
        this.f11456f = i2;
        this.f11457g = z;
        this.f11458h = z2;
        if (i2 < 2) {
            this.f11459i = z3;
            this.f11460j = z3 ? 3 : 1;
        } else {
            this.f11459i = i3 == 3;
            this.f11460j = i3;
        }
    }

    public final boolean W() {
        return this.f11458h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.c(parcel, 1, z());
        SafeParcelWriter.c(parcel, 2, W());
        SafeParcelWriter.c(parcel, 3, y());
        SafeParcelWriter.l(parcel, 4, this.f11460j);
        SafeParcelWriter.l(parcel, 1000, this.f11456f);
        SafeParcelWriter.b(parcel, iA);
    }

    @Deprecated
    public final boolean y() {
        return this.f11460j == 3;
    }

    public final boolean z() {
        return this.f11457g;
    }

    private CredentialPickerConfig(Builder builder) {
        this(2, builder.a, builder.f11461b, false, builder.f11462c);
    }
}
