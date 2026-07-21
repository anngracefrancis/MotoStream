package c.i.e;

import android.graphics.Insets;
import android.graphics.Rect;

/* JADX INFO: compiled from: Insets.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b a = new b(0, 0, 0, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3191e;

    private b(int i2, int i3, int i4, int i5) {
        this.f3188b = i2;
        this.f3189c = i3;
        this.f3190d = i4;
        this.f3191e = i5;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f3188b, bVar2.f3188b), Math.max(bVar.f3189c, bVar2.f3189c), Math.max(bVar.f3190d, bVar2.f3190d), Math.max(bVar.f3191e, bVar2.f3191e));
    }

    public static b b(int i2, int i3, int i4, int i5) {
        return (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) ? a : new b(i2, i3, i4, i5);
    }

    public static b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return Insets.of(this.f3188b, this.f3189c, this.f3190d, this.f3191e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3191e == bVar.f3191e && this.f3188b == bVar.f3188b && this.f3190d == bVar.f3190d && this.f3189c == bVar.f3189c;
    }

    public int hashCode() {
        return (((((this.f3188b * 31) + this.f3189c) * 31) + this.f3190d) * 31) + this.f3191e;
    }

    public String toString() {
        return "Insets{left=" + this.f3188b + ", top=" + this.f3189c + ", right=" + this.f3190d + ", bottom=" + this.f3191e + '}';
    }
}
