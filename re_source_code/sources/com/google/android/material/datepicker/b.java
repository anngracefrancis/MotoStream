package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;

/* JADX INFO: compiled from: CalendarStyle.java */
/* JADX INFO: loaded from: classes2.dex */
final class b {
    final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a f18566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final a f18567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final a f18568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final a f18569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final a f18570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final a f18571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Paint f18572h;

    b(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(e.e.b.c.x.b.c(context, e.e.b.c.b.v, e.class.getCanonicalName()), e.e.b.c.l.O2);
        this.a = a.a(context, typedArrayObtainStyledAttributes.getResourceId(e.e.b.c.l.R2, 0));
        this.f18571g = a.a(context, typedArrayObtainStyledAttributes.getResourceId(e.e.b.c.l.P2, 0));
        this.f18566b = a.a(context, typedArrayObtainStyledAttributes.getResourceId(e.e.b.c.l.Q2, 0));
        this.f18567c = a.a(context, typedArrayObtainStyledAttributes.getResourceId(e.e.b.c.l.S2, 0));
        ColorStateList colorStateListA = e.e.b.c.x.c.a(context, typedArrayObtainStyledAttributes, e.e.b.c.l.T2);
        this.f18568d = a.a(context, typedArrayObtainStyledAttributes.getResourceId(e.e.b.c.l.V2, 0));
        this.f18569e = a.a(context, typedArrayObtainStyledAttributes.getResourceId(e.e.b.c.l.U2, 0));
        this.f18570f = a.a(context, typedArrayObtainStyledAttributes.getResourceId(e.e.b.c.l.W2, 0));
        Paint paint = new Paint();
        this.f18572h = paint;
        paint.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
