package com.google.android.gms.common.images;

/* JADX INFO: loaded from: classes2.dex */
public final class Size {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11928b;

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            if (this.a == size.a && this.f11928b == size.f11928b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.f11928b;
        int i3 = this.a;
        return i2 ^ ((i3 >>> 16) | (i3 << 16));
    }

    public final String toString() {
        int i2 = this.a;
        int i3 = this.f11928b;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i2);
        sb.append("x");
        sb.append(i3);
        return sb.toString();
    }
}
