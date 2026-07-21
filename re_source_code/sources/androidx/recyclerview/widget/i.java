package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: LayoutState.java */
/* JADX INFO: loaded from: classes.dex */
class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f2091e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f2094h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f2095i;
    boolean a = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f2092f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f2093g = 0;

    i() {
    }

    boolean a(RecyclerView.z zVar) {
        int i2 = this.f2089c;
        return i2 >= 0 && i2 < zVar.b();
    }

    View b(RecyclerView.v vVar) {
        View viewO = vVar.o(this.f2089c);
        this.f2089c += this.f2090d;
        return viewO;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2088b + ", mCurrentPosition=" + this.f2089c + ", mItemDirection=" + this.f2090d + ", mLayoutDirection=" + this.f2091e + ", mStartLine=" + this.f2092f + ", mEndLine=" + this.f2093g + '}';
    }
}
