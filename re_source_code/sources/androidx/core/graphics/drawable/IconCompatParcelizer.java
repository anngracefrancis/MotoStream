package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f964b = versionedParcel.p(iconCompat.f964b, 1);
        iconCompat.f966d = versionedParcel.j(iconCompat.f966d, 2);
        iconCompat.f967e = versionedParcel.r(iconCompat.f967e, 3);
        iconCompat.f968f = versionedParcel.p(iconCompat.f968f, 4);
        iconCompat.f969g = versionedParcel.p(iconCompat.f969g, 5);
        iconCompat.f970h = (ColorStateList) versionedParcel.r(iconCompat.f970h, 6);
        iconCompat.f972j = versionedParcel.t(iconCompat.f972j, 7);
        iconCompat.f973k = versionedParcel.t(iconCompat.f973k, 8);
        iconCompat.n();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(true, true);
        iconCompat.o(versionedParcel.f());
        int i2 = iconCompat.f964b;
        if (-1 != i2) {
            versionedParcel.F(i2, 1);
        }
        byte[] bArr = iconCompat.f966d;
        if (bArr != null) {
            versionedParcel.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f967e;
        if (parcelable != null) {
            versionedParcel.H(parcelable, 3);
        }
        int i3 = iconCompat.f968f;
        if (i3 != 0) {
            versionedParcel.F(i3, 4);
        }
        int i4 = iconCompat.f969g;
        if (i4 != 0) {
            versionedParcel.F(i4, 5);
        }
        ColorStateList colorStateList = iconCompat.f970h;
        if (colorStateList != null) {
            versionedParcel.H(colorStateList, 6);
        }
        String str = iconCompat.f972j;
        if (str != null) {
            versionedParcel.J(str, 7);
        }
        String str2 = iconCompat.f973k;
        if (str2 != null) {
            versionedParcel.J(str2, 8);
        }
    }
}
