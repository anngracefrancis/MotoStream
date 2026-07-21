package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new zab();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f12105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final StringToIntConverter f12106g;

    @SafeParcelable.Constructor
    zaa(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) StringToIntConverter stringToIntConverter) {
        this.f12105f = i2;
        this.f12106g = stringToIntConverter;
    }

    public static zaa y(FastJsonResponse.FieldConverter<?, ?> fieldConverter) {
        if (fieldConverter instanceof StringToIntConverter) {
            return new zaa((StringToIntConverter) fieldConverter);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f12105f);
        SafeParcelWriter.s(parcel, 2, this.f12106g, i2, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final FastJsonResponse.FieldConverter<?, ?> z() {
        StringToIntConverter stringToIntConverter = this.f12106g;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    private zaa(StringToIntConverter stringToIntConverter) {
        this.f12105f = 1;
        this.f12106g = stringToIntConverter;
    }
}
