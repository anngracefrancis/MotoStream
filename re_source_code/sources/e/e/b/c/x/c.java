package e.e.b.c.x;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.appcompat.widget.q0;

/* JADX INFO: compiled from: MaterialResources.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i2) {
        int color;
        int resourceId;
        ColorStateList colorStateListC;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (colorStateListC = c.a.k.a.a.c(context, resourceId)) == null) {
            return (Build.VERSION.SDK_INT > 15 || (color = typedArray.getColor(i2, -1)) == -1) ? typedArray.getColorStateList(i2) : ColorStateList.valueOf(color);
        }
        return colorStateListC;
    }

    public static ColorStateList b(Context context, q0 q0Var, int i2) {
        int iB;
        int iN;
        ColorStateList colorStateListC;
        if (!q0Var.s(i2) || (iN = q0Var.n(i2, 0)) == 0 || (colorStateListC = c.a.k.a.a.c(context, iN)) == null) {
            return (Build.VERSION.SDK_INT > 15 || (iB = q0Var.b(i2, -1)) == -1) ? q0Var.c(i2) : ColorStateList.valueOf(iB);
        }
        return colorStateListC;
    }

    public static int c(Context context, TypedArray typedArray, int i2, int i3) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i2, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i2, i3);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i3);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable d(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        Drawable drawableD;
        return (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (drawableD = c.a.k.a.a.d(context, resourceId)) == null) ? typedArray.getDrawable(i2) : drawableD;
    }

    static int e(TypedArray typedArray, int i2, int i3) {
        return typedArray.hasValue(i2) ? i2 : i3;
    }

    public static d f(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return new d(context, resourceId);
    }
}
