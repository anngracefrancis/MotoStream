package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import androidx.core.view.u;

/* JADX INFO: compiled from: CalendarItemStyle.java */
/* JADX INFO: loaded from: classes2.dex */
final class a {
    private final Rect a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorStateList f18561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ColorStateList f18562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ColorStateList f18563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f18564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e.e.b.c.a0.k f18565f;

    private a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i2, e.e.b.c.a0.k kVar, Rect rect) {
        c.i.j.i.b(rect.left);
        c.i.j.i.b(rect.top);
        c.i.j.i.b(rect.right);
        c.i.j.i.b(rect.bottom);
        this.a = rect;
        this.f18561b = colorStateList2;
        this.f18562c = colorStateList;
        this.f18563d = colorStateList3;
        this.f18564e = i2;
        this.f18565f = kVar;
    }

    static a a(Context context, int i2) {
        c.i.j.i.a(i2 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, e.e.b.c.l.X2);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(e.e.b.c.l.Y2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(e.e.b.c.l.a3, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(e.e.b.c.l.Z2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(e.e.b.c.l.b3, 0));
        ColorStateList colorStateListA = e.e.b.c.x.c.a(context, typedArrayObtainStyledAttributes, e.e.b.c.l.c3);
        ColorStateList colorStateListA2 = e.e.b.c.x.c.a(context, typedArrayObtainStyledAttributes, e.e.b.c.l.h3);
        ColorStateList colorStateListA3 = e.e.b.c.x.c.a(context, typedArrayObtainStyledAttributes, e.e.b.c.l.f3);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(e.e.b.c.l.g3, 0);
        e.e.b.c.a0.k kVarM = e.e.b.c.a0.k.b(context, typedArrayObtainStyledAttributes.getResourceId(e.e.b.c.l.d3, 0), typedArrayObtainStyledAttributes.getResourceId(e.e.b.c.l.e3, 0)).m();
        typedArrayObtainStyledAttributes.recycle();
        return new a(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, kVarM, rect);
    }

    int b() {
        return this.a.bottom;
    }

    int c() {
        return this.a.top;
    }

    void d(TextView textView) {
        e.e.b.c.a0.g gVar = new e.e.b.c.a0.g();
        e.e.b.c.a0.g gVar2 = new e.e.b.c.a0.g();
        gVar.setShapeAppearanceModel(this.f18565f);
        gVar2.setShapeAppearanceModel(this.f18565f);
        gVar.X(this.f18562c);
        gVar.f0(this.f18564e, this.f18563d);
        textView.setTextColor(this.f18561b);
        Drawable rippleDrawable = Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.f18561b.withAlpha(30), gVar, gVar2) : gVar;
        Rect rect = this.a;
        u.m0(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
