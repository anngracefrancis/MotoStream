package e.g.a.c;

import android.view.View;

/* JADX INFO: compiled from: ViewScrollChangeEvent.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends c<View> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f21175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f21176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f21177e;

    protected f(View view, int i2, int i3, int i4, int i5) {
        super(view);
        this.f21174b = i2;
        this.f21175c = i3;
        this.f21176d = i4;
        this.f21177e = i5;
    }

    public static f b(View view, int i2, int i3, int i4, int i5) {
        return new f(view, i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return fVar.a() == a() && fVar.f21174b == this.f21174b && fVar.f21175c == this.f21175c && fVar.f21176d == this.f21176d && fVar.f21177e == this.f21177e;
    }

    public int hashCode() {
        return ((((((((629 + a().hashCode()) * 37) + this.f21174b) * 37) + this.f21175c) * 37) + this.f21176d) * 37) + this.f21177e;
    }

    public String toString() {
        return "ViewScrollChangeEvent{scrollX=" + this.f21174b + ", scrollY=" + this.f21175c + ", oldScrollX=" + this.f21176d + ", oldScrollY=" + this.f21177e + '}';
    }
}
