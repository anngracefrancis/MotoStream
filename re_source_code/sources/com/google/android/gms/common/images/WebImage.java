package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new zae();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11929f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final Uri f11930g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f11931h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f11932i;

    @SafeParcelable.Constructor
    WebImage(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) Uri uri, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) int i4) {
        this.f11929f = i2;
        this.f11930g = uri;
        this.f11931h = i3;
        this.f11932i = i4;
    }

    public final int W() {
        return this.f11931h;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (Objects.a(this.f11930g, webImage.f11930g) && this.f11931h == webImage.f11931h && this.f11932i == webImage.f11932i) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.b(this.f11930g, Integer.valueOf(this.f11931h), Integer.valueOf(this.f11932i));
    }

    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.f11931h), Integer.valueOf(this.f11932i), this.f11930g.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f11929f);
        SafeParcelWriter.s(parcel, 2, z(), i2, false);
        SafeParcelWriter.l(parcel, 3, W());
        SafeParcelWriter.l(parcel, 4, y());
        SafeParcelWriter.b(parcel, iA);
    }

    public final int y() {
        return this.f11932i;
    }

    public final Uri z() {
        return this.f11930g;
    }
}
