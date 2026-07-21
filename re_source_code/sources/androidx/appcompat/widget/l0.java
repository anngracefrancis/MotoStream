package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: compiled from: ThemeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class l0 {
    private static final ThreadLocal<TypedValue> a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f576b = {-16842910};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int[] f577c = {R.attr.state_focused};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[] f578d = {R.attr.state_activated};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f579e = {R.attr.state_pressed};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[] f580f = {R.attr.state_checked};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int[] f581g = {R.attr.state_selected};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int[] f582h = {-16842919, -16842908};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int[] f583i = new int[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f584j = new int[1];

    public static void a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(c.a.j.z0);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(c.a.j.E0)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i2) {
        ColorStateList colorStateListE = e(context, i2);
        if (colorStateListE != null && colorStateListE.isStateful()) {
            return colorStateListE.getColorForState(f576b, colorStateListE.getDefaultColor());
        }
        TypedValue typedValueF = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueF, true);
        return d(context, i2, typedValueF.getFloat());
    }

    public static int c(Context context, int i2) {
        int[] iArr = f584j;
        iArr[0] = i2;
        q0 q0VarU = q0.u(context, null, iArr);
        try {
            return q0VarU.b(0, 0);
        } finally {
            q0VarU.w();
        }
    }

    static int d(Context context, int i2, float f2) {
        int iC = c(context, i2);
        return c.i.e.a.o(iC, Math.round(Color.alpha(iC) * f2));
    }

    public static ColorStateList e(Context context, int i2) {
        int[] iArr = f584j;
        iArr[0] = i2;
        q0 q0VarU = q0.u(context, null, iArr);
        try {
            return q0VarU.c(0);
        } finally {
            q0VarU.w();
        }
    }

    private static TypedValue f() {
        ThreadLocal<TypedValue> threadLocal = a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
