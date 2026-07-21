package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: DrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f976d;

    public static void a(Drawable drawable, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static boolean b(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            drawable.clearColorFilter();
            return;
        }
        if (i2 < 21) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            c(((InsetDrawable) drawable).getDrawable());
            return;
        }
        if (drawable instanceof c) {
            c(((c) drawable).b());
            return;
        }
        if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
            return;
        }
        int childCount = drawableContainerState.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Drawable child = drawableContainerState.getChild(i3);
            if (child != null) {
                c(child);
            }
        }
    }

    public static int d(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    public static ColorFilter e(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    public static int f(Drawable drawable) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return drawable.getLayoutDirection();
        }
        if (i2 >= 17) {
            if (!f976d) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    f975c = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e2);
                }
                f976d = true;
            }
            Method method = f975c;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Exception e3) {
                    Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e3);
                    f975c = null;
                }
            }
        }
        return 0;
    }

    public static void g(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    public static boolean h(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    @Deprecated
    public static void i(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void j(Drawable drawable, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    public static void k(Drawable drawable, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f2, f3);
        }
    }

    public static void l(Drawable drawable, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i2, i3, i4, i5);
        }
    }

    public static boolean m(Drawable drawable, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            return drawable.setLayoutDirection(i2);
        }
        if (i3 >= 17) {
            if (!f974b) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                    a = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e2);
                }
                f974b = true;
            }
            Method method = a;
            if (method != null) {
                try {
                    method.invoke(drawable, Integer.valueOf(i2));
                    return true;
                } catch (Exception e3) {
                    Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e3);
                    a = null;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void n(Drawable drawable, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(i2);
        } else if (drawable instanceof b) {
            ((b) drawable).setTint(i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void o(Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (drawable instanceof b) {
            ((b) drawable).setTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void p(Drawable drawable, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (drawable instanceof b) {
            ((b) drawable).setTintMode(mode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T q(Drawable drawable) {
        return drawable instanceof c ? (T) ((c) drawable).b() : drawable;
    }

    public static Drawable r(Drawable drawable) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return drawable;
        }
        if (i2 >= 21) {
            return !(drawable instanceof b) ? new e(drawable) : drawable;
        }
        return !(drawable instanceof b) ? new d(drawable) : drawable;
    }
}
