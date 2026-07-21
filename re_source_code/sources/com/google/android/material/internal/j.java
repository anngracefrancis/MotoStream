package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.q0;

/* JADX INFO: compiled from: ThemeEnforcement.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j {
    private static final int[] a = {e.e.b.c.b.m};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f18720b = {e.e.b.c.b.n};

    public static void a(Context context) {
        e(context, a, "Theme.AppCompat");
    }

    private static void b(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.e.b.c.l.W5, i2, i3);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(e.e.b.c.l.Y5, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(e.e.b.c.b.t, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context);
            }
        }
        a(context);
    }

    public static void c(Context context) {
        e(context, f18720b, "Theme.MaterialComponents");
    }

    private static void d(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        boolean zF;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.e.b.c.l.W5, i2, i3);
        if (!typedArrayObtainStyledAttributes.getBoolean(e.e.b.c.l.Z5, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            zF = typedArrayObtainStyledAttributes.getResourceId(e.e.b.c.l.X5, -1) != -1;
        } else {
            zF = f(context, attributeSet, iArr, i2, i3, iArr2);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!zF) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static void e(Context context, int[] iArr, String str) {
        if (g(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    private static boolean f(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        for (int i4 : iArr2) {
            if (typedArrayObtainStyledAttributes.getResourceId(i4, -1) == -1) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    private static boolean g(Context context, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i2)) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    public static TypedArray h(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        b(context, attributeSet, i2, i3);
        d(context, attributeSet, iArr, i2, i3, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
    }

    public static q0 i(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        b(context, attributeSet, i2, i3);
        d(context, attributeSet, iArr, i2, i3, iArr2);
        return q0.v(context, attributeSet, iArr, i2, i3);
    }
}
