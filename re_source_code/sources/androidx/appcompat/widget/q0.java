package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: compiled from: TintTypedArray.java */
/* JADX INFO: loaded from: classes.dex */
public class q0 {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypedArray f605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TypedValue f606c;

    private q0(Context context, TypedArray typedArray) {
        this.a = context;
        this.f605b = typedArray;
    }

    public static q0 t(Context context, int i2, int[] iArr) {
        return new q0(context, context.obtainStyledAttributes(i2, iArr));
    }

    public static q0 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new q0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static q0 v(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3) {
        return new q0(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i3));
    }

    public boolean a(int i2, boolean z) {
        return this.f605b.getBoolean(i2, z);
    }

    public int b(int i2, int i3) {
        return this.f605b.getColor(i2, i3);
    }

    public ColorStateList c(int i2) {
        int resourceId;
        ColorStateList colorStateListC;
        return (!this.f605b.hasValue(i2) || (resourceId = this.f605b.getResourceId(i2, 0)) == 0 || (colorStateListC = c.a.k.a.a.c(this.a, resourceId)) == null) ? this.f605b.getColorStateList(i2) : colorStateListC;
    }

    public float d(int i2, float f2) {
        return this.f605b.getDimension(i2, f2);
    }

    public int e(int i2, int i3) {
        return this.f605b.getDimensionPixelOffset(i2, i3);
    }

    public int f(int i2, int i3) {
        return this.f605b.getDimensionPixelSize(i2, i3);
    }

    public Drawable g(int i2) {
        int resourceId;
        return (!this.f605b.hasValue(i2) || (resourceId = this.f605b.getResourceId(i2, 0)) == 0) ? this.f605b.getDrawable(i2) : c.a.k.a.a.d(this.a, resourceId);
    }

    public Drawable h(int i2) {
        int resourceId;
        if (!this.f605b.hasValue(i2) || (resourceId = this.f605b.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return h.b().d(this.a, resourceId, true);
    }

    public float i(int i2, float f2) {
        return this.f605b.getFloat(i2, f2);
    }

    public Typeface j(int i2, int i3, androidx.core.content.d.f.c cVar) {
        int resourceId = this.f605b.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f606c == null) {
            this.f606c = new TypedValue();
        }
        return androidx.core.content.d.f.f(this.a, resourceId, this.f606c, i3, cVar);
    }

    public int k(int i2, int i3) {
        return this.f605b.getInt(i2, i3);
    }

    public int l(int i2, int i3) {
        return this.f605b.getInteger(i2, i3);
    }

    public int m(int i2, int i3) {
        return this.f605b.getLayoutDimension(i2, i3);
    }

    public int n(int i2, int i3) {
        return this.f605b.getResourceId(i2, i3);
    }

    public String o(int i2) {
        return this.f605b.getString(i2);
    }

    public CharSequence p(int i2) {
        return this.f605b.getText(i2);
    }

    public CharSequence[] q(int i2) {
        return this.f605b.getTextArray(i2);
    }

    public TypedArray r() {
        return this.f605b;
    }

    public boolean s(int i2) {
        return this.f605b.hasValue(i2);
    }

    public void w() {
        this.f605b.recycle();
    }
}
