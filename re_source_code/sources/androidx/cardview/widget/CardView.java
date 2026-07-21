package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f678f = {R.attr.colorBackground};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final e f679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f680h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f681i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f682j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f683k;
    final Rect l;
    final Rect m;
    private final d n;

    class a implements d {
        private Drawable a;

        a() {
        }

        @Override // androidx.cardview.widget.d
        public void a(int i2, int i3, int i4, int i5) {
            CardView.this.m.set(i2, i3, i4, i5);
            CardView cardView = CardView.this;
            Rect rect = cardView.l;
            CardView.super.setPadding(i2 + rect.left, i3 + rect.top, i4 + rect.right, i5 + rect.bottom);
        }

        @Override // androidx.cardview.widget.d
        public void b(int i2, int i3) {
            CardView cardView = CardView.this;
            if (i2 > cardView.f682j) {
                CardView.super.setMinimumWidth(i2);
            }
            CardView cardView2 = CardView.this;
            if (i3 > cardView2.f683k) {
                CardView.super.setMinimumHeight(i3);
            }
        }

        @Override // androidx.cardview.widget.d
        public void c(Drawable drawable) {
            this.a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // androidx.cardview.widget.d
        public boolean d() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // androidx.cardview.widget.d
        public boolean e() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // androidx.cardview.widget.d
        public Drawable f() {
            return this.a;
        }

        @Override // androidx.cardview.widget.d
        public View g() {
            return CardView.this;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f679g = new b();
        } else if (i2 >= 17) {
            f679g = new androidx.cardview.widget.a();
        } else {
            f679g = new c();
        }
        f679g.j();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.d.a.a);
    }

    public void f(int i2, int i3, int i4, int i5) {
        this.l.set(i2, i3, i4, i5);
        f679g.i(this.n);
    }

    public ColorStateList getCardBackgroundColor() {
        return f679g.h(this.n);
    }

    public float getCardElevation() {
        return f679g.c(this.n);
    }

    public int getContentPaddingBottom() {
        return this.l.bottom;
    }

    public int getContentPaddingLeft() {
        return this.l.left;
    }

    public int getContentPaddingRight() {
        return this.l.right;
    }

    public int getContentPaddingTop() {
        return this.l.top;
    }

    public float getMaxCardElevation() {
        return f679g.g(this.n);
    }

    public boolean getPreventCornerOverlap() {
        return this.f681i;
    }

    public float getRadius() {
        return f679g.d(this.n);
    }

    public boolean getUseCompatPadding() {
        return this.f680h;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        e eVar = f679g;
        if (eVar instanceof b) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(eVar.l(this.n)), View.MeasureSpec.getSize(i2)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(eVar.k(this.n)), View.MeasureSpec.getSize(i3)), mode2);
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        f679g.n(this.n, ColorStateList.valueOf(i2));
    }

    public void setCardElevation(float f2) {
        f679g.f(this.n, f2);
    }

    public void setMaxCardElevation(float f2) {
        f679g.o(this.n, f2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        this.f683k = i2;
        super.setMinimumHeight(i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i2) {
        this.f682j = i2;
        super.setMinimumWidth(i2);
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f681i) {
            this.f681i = z;
            f679g.m(this.n);
        }
    }

    public void setRadius(float f2) {
        f679g.b(this.n, f2);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f680h != z) {
            this.f680h = z;
            f679g.e(this.n);
        }
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i2);
        Rect rect = new Rect();
        this.l = rect;
        this.m = new Rect();
        a aVar = new a();
        this.n = aVar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.d.e.a, i2, c.d.d.a);
        int i3 = c.d.e.f2900d;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(i3);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f678f);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(c.d.b.f2895b) : getResources().getColor(c.d.b.a));
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(c.d.e.f2901e, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(c.d.e.f2902f, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(c.d.e.f2903g, 0.0f);
        this.f680h = typedArrayObtainStyledAttributes.getBoolean(c.d.e.f2905i, false);
        this.f681i = typedArrayObtainStyledAttributes.getBoolean(c.d.e.f2904h, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(c.d.e.f2906j, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(c.d.e.l, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(c.d.e.n, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(c.d.e.m, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(c.d.e.f2907k, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f682j = typedArrayObtainStyledAttributes.getDimensionPixelSize(c.d.e.f2898b, 0);
        this.f683k = typedArrayObtainStyledAttributes.getDimensionPixelSize(c.d.e.f2899c, 0);
        typedArrayObtainStyledAttributes.recycle();
        f679g.a(aVar, context, colorStateList, dimension, dimension2, f2);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f679g.n(this.n, colorStateList);
    }
}
