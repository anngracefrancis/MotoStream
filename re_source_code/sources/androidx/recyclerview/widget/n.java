package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: OrientationHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {
    protected final RecyclerView.o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Rect f2097c;

    /* JADX INFO: compiled from: OrientationHelper.java */
    static class a extends n {
        a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.n
        public int d(View view) {
            return this.a.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.n
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.n
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.n
        public int g(View view) {
            return this.a.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.n
        public int h() {
            return this.a.getWidth();
        }

        @Override // androidx.recyclerview.widget.n
        public int i() {
            return this.a.getWidth() - this.a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.n
        public int j() {
            return this.a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.n
        public int k() {
            return this.a.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.n
        public int l() {
            return this.a.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.n
        public int m() {
            return this.a.getPaddingLeft();
        }

        @Override // androidx.recyclerview.widget.n
        public int n() {
            return (this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.n
        public int p(View view) {
            this.a.getTransformedBoundingBox(view, true, this.f2097c);
            return this.f2097c.right;
        }

        @Override // androidx.recyclerview.widget.n
        public int q(View view) {
            this.a.getTransformedBoundingBox(view, true, this.f2097c);
            return this.f2097c.left;
        }

        @Override // androidx.recyclerview.widget.n
        public void r(int i2) {
            this.a.offsetChildrenHorizontal(i2);
        }
    }

    /* JADX INFO: compiled from: OrientationHelper.java */
    static class b extends n {
        b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.n
        public int d(View view) {
            return this.a.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.n
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.n
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.n
        public int g(View view) {
            return this.a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.n
        public int h() {
            return this.a.getHeight();
        }

        @Override // androidx.recyclerview.widget.n
        public int i() {
            return this.a.getHeight() - this.a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.n
        public int j() {
            return this.a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.n
        public int k() {
            return this.a.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.n
        public int l() {
            return this.a.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.n
        public int m() {
            return this.a.getPaddingTop();
        }

        @Override // androidx.recyclerview.widget.n
        public int n() {
            return (this.a.getHeight() - this.a.getPaddingTop()) - this.a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.n
        public int p(View view) {
            this.a.getTransformedBoundingBox(view, true, this.f2097c);
            return this.f2097c.bottom;
        }

        @Override // androidx.recyclerview.widget.n
        public int q(View view) {
            this.a.getTransformedBoundingBox(view, true, this.f2097c);
            return this.f2097c.top;
        }

        @Override // androidx.recyclerview.widget.n
        public void r(int i2) {
            this.a.offsetChildrenVertical(i2);
        }
    }

    /* synthetic */ n(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static n a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static n b(RecyclerView.o oVar, int i2) {
        if (i2 == 0) {
            return a(oVar);
        }
        if (i2 == 1) {
            return c(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static n c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f2096b) {
            return 0;
        }
        return n() - this.f2096b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i2);

    public void s() {
        this.f2096b = n();
    }

    private n(RecyclerView.o oVar) {
        this.f2096b = Integer.MIN_VALUE;
        this.f2097c = new Rect();
        this.a = oVar;
    }
}
