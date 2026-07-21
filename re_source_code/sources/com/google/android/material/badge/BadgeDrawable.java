package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.u;
import com.google.android.material.internal.h;
import com.google.android.material.internal.j;
import e.e.b.c.a0.g;
import e.e.b.c.b;
import e.e.b.c.d;
import e.e.b.c.i;
import e.e.b.c.k;
import java.lang.ref.WeakReference;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public class BadgeDrawable extends Drawable implements h.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f18407f = k.n;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f18408g = b.f20964c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final WeakReference<Context> f18409h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final g f18410i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final h f18411j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Rect f18412k;
    private final float l;
    private final float m;
    private final float n;
    private final SavedState o;
    private float p;
    private float q;
    private int r;
    private float s;
    private float t;
    private float u;
    private WeakReference<View> v;
    private WeakReference<ViewGroup> w;

    private BadgeDrawable(Context context) {
        this.f18409h = new WeakReference<>(context);
        j.c(context);
        Resources resources = context.getResources();
        this.f18412k = new Rect();
        this.f18410i = new g();
        this.l = resources.getDimensionPixelSize(d.s);
        this.n = resources.getDimensionPixelSize(d.r);
        this.m = resources.getDimensionPixelSize(d.u);
        h hVar = new h(this);
        this.f18411j = hVar;
        hVar.e().setTextAlign(Paint.Align.CENTER);
        this.o = new SavedState(context);
        s(k.f21032d);
    }

    private void b(Context context, Rect rect, View view) {
        int i2 = this.o.n;
        if (i2 == 8388691 || i2 == 8388693) {
            this.q = rect.bottom - this.o.p;
        } else {
            this.q = rect.top + this.o.p;
        }
        if (h() <= 9) {
            float f2 = !j() ? this.l : this.m;
            this.s = f2;
            this.u = f2;
            this.t = f2;
        } else {
            float f3 = this.m;
            this.s = f3;
            this.u = f3;
            this.t = (this.f18411j.f(e()) / 2.0f) + this.n;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(j() ? d.t : d.q);
        int i3 = this.o.n;
        if (i3 == 8388659 || i3 == 8388691) {
            this.p = u.y(view) == 0 ? (rect.left - this.t) + dimensionPixelSize + this.o.o : ((rect.right + this.t) - dimensionPixelSize) - this.o.o;
        } else {
            this.p = u.y(view) == 0 ? ((rect.right + this.t) - dimensionPixelSize) - this.o.o : (rect.left - this.t) + dimensionPixelSize + this.o.o;
        }
    }

    static BadgeDrawable c(Context context, SavedState savedState) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.k(savedState);
        return badgeDrawable;
    }

    private void d(Canvas canvas) {
        Rect rect = new Rect();
        String strE = e();
        this.f18411j.e().getTextBounds(strE, 0, strE.length(), rect);
        canvas.drawText(strE, this.p, this.q + (rect.height() / 2), this.f18411j.e());
    }

    private String e() {
        if (h() <= this.r) {
            return Integer.toString(h());
        }
        Context context = this.f18409h.get();
        return context == null ? HttpUrl.FRAGMENT_ENCODE_SET : context.getString(e.e.b.c.j.f21029k, Integer.valueOf(this.r), "+");
    }

    private void k(SavedState savedState) {
        p(savedState.f18417j);
        if (savedState.f18416i != -1) {
            q(savedState.f18416i);
        }
        l(savedState.f18413f);
        n(savedState.f18414g);
        m(savedState.n);
        o(savedState.o);
        t(savedState.p);
    }

    private void r(e.e.b.c.x.d dVar) {
        Context context;
        if (this.f18411j.d() == dVar || (context = this.f18409h.get()) == null) {
            return;
        }
        this.f18411j.h(dVar, context);
        v();
    }

    private void s(int i2) {
        Context context = this.f18409h.get();
        if (context == null) {
            return;
        }
        r(new e.e.b.c.x.d(context, i2));
    }

    private void v() {
        Context context = this.f18409h.get();
        WeakReference<View> weakReference = this.v;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.f18412k);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<ViewGroup> weakReference2 = this.w;
        ViewGroup viewGroup = weakReference2 != null ? weakReference2.get() : null;
        if (viewGroup != null || a.a) {
            if (viewGroup == null) {
                viewGroup = (ViewGroup) view.getParent();
            }
            viewGroup.offsetDescendantRectToMyCoords(view, rect2);
        }
        b(context, rect2, view);
        a.f(this.f18412k, this.p, this.q, this.t, this.u);
        this.f18410i.V(this.s);
        if (rect.equals(this.f18412k)) {
            return;
        }
        this.f18410i.setBounds(this.f18412k);
    }

    private void w() {
        double dG = g();
        Double.isNaN(dG);
        this.r = ((int) Math.pow(10.0d, dG - 1.0d)) - 1;
    }

    @Override // com.google.android.material.internal.h.b
    public void a() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f18410i.draw(canvas);
        if (j()) {
            d(canvas);
        }
    }

    public CharSequence f() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!j()) {
            return this.o.f18418k;
        }
        if (this.o.l <= 0 || (context = this.f18409h.get()) == null) {
            return null;
        }
        return h() <= this.r ? context.getResources().getQuantityString(this.o.l, h(), Integer.valueOf(h())) : context.getString(this.o.m, Integer.valueOf(this.r));
    }

    public int g() {
        return this.o.f18417j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.o.f18415h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f18412k.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f18412k.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int h() {
        if (j()) {
            return this.o.f18416i;
        }
        return 0;
    }

    public SavedState i() {
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public boolean j() {
        return this.o.f18416i != -1;
    }

    public void l(int i2) {
        this.o.f18413f = i2;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i2);
        if (this.f18410i.x() != colorStateListValueOf) {
            this.f18410i.X(colorStateListValueOf);
            invalidateSelf();
        }
    }

    public void m(int i2) {
        if (this.o.n != i2) {
            this.o.n = i2;
            WeakReference<View> weakReference = this.v;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            View view = this.v.get();
            WeakReference<ViewGroup> weakReference2 = this.w;
            u(view, weakReference2 != null ? weakReference2.get() : null);
        }
    }

    public void n(int i2) {
        this.o.f18414g = i2;
        if (this.f18411j.e().getColor() != i2) {
            this.f18411j.e().setColor(i2);
            invalidateSelf();
        }
    }

    public void o(int i2) {
        this.o.o = i2;
        v();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.h.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void p(int i2) {
        if (this.o.f18417j != i2) {
            this.o.f18417j = i2;
            w();
            this.f18411j.i(true);
            v();
            invalidateSelf();
        }
    }

    public void q(int i2) {
        int iMax = Math.max(0, i2);
        if (this.o.f18416i != iMax) {
            this.o.f18416i = iMax;
            this.f18411j.i(true);
            v();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.o.f18415h = i2;
        this.f18411j.e().setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void t(int i2) {
        this.o.p = i2;
        v();
    }

    public void u(View view, ViewGroup viewGroup) {
        this.v = new WeakReference<>(view);
        this.w = new WeakReference<>(viewGroup);
        v();
        invalidateSelf();
    }

    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f18413f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f18414g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f18415h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f18416i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f18417j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private CharSequence f18418k;
        private int l;
        private int m;
        private int n;
        private int o;
        private int p;

        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Context context) {
            this.f18415h = 255;
            this.f18416i = -1;
            this.f18414g = new e.e.b.c.x.d(context, k.f21032d).f21085b.getDefaultColor();
            this.f18418k = context.getString(e.e.b.c.j.f21026h);
            this.l = i.a;
            this.m = e.e.b.c.j.f21028j;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f18413f);
            parcel.writeInt(this.f18414g);
            parcel.writeInt(this.f18415h);
            parcel.writeInt(this.f18416i);
            parcel.writeInt(this.f18417j);
            parcel.writeString(this.f18418k.toString());
            parcel.writeInt(this.l);
            parcel.writeInt(this.n);
            parcel.writeInt(this.o);
            parcel.writeInt(this.p);
        }

        protected SavedState(Parcel parcel) {
            this.f18415h = 255;
            this.f18416i = -1;
            this.f18413f = parcel.readInt();
            this.f18414g = parcel.readInt();
            this.f18415h = parcel.readInt();
            this.f18416i = parcel.readInt();
            this.f18417j = parcel.readInt();
            this.f18418k = parcel.readString();
            this.l = parcel.readInt();
            this.n = parcel.readInt();
            this.o = parcel.readInt();
            this.p = parcel.readInt();
        }
    }
}
