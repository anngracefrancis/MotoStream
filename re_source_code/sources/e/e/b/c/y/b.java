package e.e.b.c.y;

import android.R;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;

/* JADX INFO: compiled from: RippleUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f21100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f21101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f21102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f21103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f21104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f21105g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f21106h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f21107i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f21108j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f21109k;
    static final String l;

    static {
        a = Build.VERSION.SDK_INT >= 21;
        f21100b = new int[]{R.attr.state_pressed};
        f21101c = new int[]{R.attr.state_hovered, R.attr.state_focused};
        f21102d = new int[]{R.attr.state_focused};
        f21103e = new int[]{R.attr.state_hovered};
        f21104f = new int[]{R.attr.state_selected, R.attr.state_pressed};
        f21105g = new int[]{R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
        f21106h = new int[]{R.attr.state_selected, R.attr.state_focused};
        f21107i = new int[]{R.attr.state_selected, R.attr.state_hovered};
        f21108j = new int[]{R.attr.state_selected};
        f21109k = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        l = b.class.getSimpleName();
    }

    private b() {
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (a) {
            return new ColorStateList(new int[][]{f21108j, StateSet.NOTHING}, new int[]{c(colorStateList, f21104f), c(colorStateList, f21100b)});
        }
        int[] iArr = f21104f;
        int[] iArr2 = f21105g;
        int[] iArr3 = f21106h;
        int[] iArr4 = f21107i;
        int[] iArr5 = f21100b;
        int[] iArr6 = f21101c;
        int[] iArr7 = f21102d;
        int[] iArr8 = f21103e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f21108j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{c(colorStateList, iArr), c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), 0, c(colorStateList, iArr5), c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), 0});
    }

    @TargetApi(21)
    private static int b(int i2) {
        return c.i.e.a.o(i2, Math.min(Color.alpha(i2) * 2, 255));
    }

    private static int c(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return a ? b(colorForState) : colorForState;
    }

    public static ColorStateList d(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22 && i2 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f21109k, 0)) != 0) {
            Log.w(l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean e(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
