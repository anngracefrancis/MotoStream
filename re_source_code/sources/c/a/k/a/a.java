package c.a.k.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.g0;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: AppCompatResources.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public final class a {
    private static final ThreadLocal<TypedValue> a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<Context, SparseArray<C0060a>> f2766b = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f2767c = new Object();

    /* JADX INFO: renamed from: c.a.k.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppCompatResources.java */
    private static class C0060a {
        final ColorStateList a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Configuration f2768b;

        C0060a(ColorStateList colorStateList, Configuration configuration) {
            this.a = colorStateList;
            this.f2768b = configuration;
        }
    }

    private static void a(Context context, int i2, ColorStateList colorStateList) {
        synchronized (f2767c) {
            WeakHashMap<Context, SparseArray<C0060a>> weakHashMap = f2766b;
            SparseArray<C0060a> sparseArray = weakHashMap.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(context, sparseArray);
            }
            sparseArray.append(i2, new C0060a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static ColorStateList b(Context context, int i2) {
        C0060a c0060a;
        synchronized (f2767c) {
            SparseArray<C0060a> sparseArray = f2766b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (c0060a = sparseArray.get(i2)) != null) {
                if (c0060a.f2768b.equals(context.getResources().getConfiguration())) {
                    return c0060a.a;
                }
                sparseArray.remove(i2);
            }
            return null;
        }
    }

    public static ColorStateList c(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        ColorStateList colorStateListB = b(context, i2);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListF = f(context, i2);
        if (colorStateListF == null) {
            return androidx.core.content.a.e(context, i2);
        }
        a(context, i2, colorStateListF);
        return colorStateListF;
    }

    public static Drawable d(Context context, int i2) {
        return g0.h().j(context, i2);
    }

    private static TypedValue e() {
        ThreadLocal<TypedValue> threadLocal = a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList f(Context context, int i2) {
        if (g(context, i2)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return androidx.core.content.d.a.a(resources, resources.getXml(i2), context.getTheme());
        } catch (Exception e2) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    private static boolean g(Context context, int i2) {
        Resources resources = context.getResources();
        TypedValue typedValueE = e();
        resources.getValue(i2, typedValueE, true);
        int i3 = typedValueE.type;
        return i3 >= 28 && i3 <= 31;
    }
}
