package androidx.core.content.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import c.i.j.i;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ResourcesCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    private static final ThreadLocal<TypedValue> a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<b, SparseArray<a>> f954b = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f955c = new Object();

    /* JADX INFO: compiled from: ResourcesCompat.java */
    private static class a {
        final ColorStateList a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Configuration f956b;

        a(ColorStateList colorStateList, Configuration configuration) {
            this.a = colorStateList;
            this.f956b = configuration;
        }
    }

    /* JADX INFO: compiled from: ResourcesCompat.java */
    private static final class b {
        final Resources a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Resources.Theme f957b;

        b(Resources resources, Resources.Theme theme) {
            this.a = resources;
            this.f957b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.a.equals(bVar.a) && c.i.j.d.a(this.f957b, bVar.f957b);
        }

        public int hashCode() {
            return c.i.j.d.b(this.a, this.f957b);
        }
    }

    /* JADX INFO: compiled from: ResourcesCompat.java */
    public static abstract class c {

        /* JADX INFO: compiled from: ResourcesCompat.java */
        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Typeface f958f;

            a(Typeface typeface) {
                this.f958f = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.e(this.f958f);
            }
        }

        /* JADX INFO: compiled from: ResourcesCompat.java */
        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f960f;

            b(int i2) {
                this.f960f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.d(this.f960f);
            }
        }

        public static Handler c(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void a(int i2, Handler handler) {
            c(handler).post(new b(i2));
        }

        public final void b(Typeface typeface, Handler handler) {
            c(handler).post(new a(typeface));
        }

        public abstract void d(int i2);

        public abstract void e(Typeface typeface);
    }

    /* JADX INFO: compiled from: ResourcesCompat.java */
    public static final class d {

        /* JADX INFO: compiled from: ResourcesCompat.java */
        static class a {
            private static final Object a = new Object();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static Method f962b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static boolean f963c;

            /* JADX WARN: Code duplicated, block: B:30:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            static void a(Resources.Theme theme) {
                Method method;
                synchronized (a) {
                    if (f963c) {
                        method = f962b;
                        if (method != null) {
                            method.invoke(theme, new Object[0]);
                        }
                    } else {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f962b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e2) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e2);
                        }
                        f963c = true;
                        method = f962b;
                        if (method != null) {
                            try {
                                method.invoke(theme, new Object[0]);
                            } catch (IllegalAccessException | InvocationTargetException e3) {
                                Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e3);
                                f962b = null;
                            }
                        }
                    }
                    throw th;
                }
            }
        }

        /* JADX INFO: compiled from: ResourcesCompat.java */
        static class b {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                b.a(theme);
            } else if (i2 >= 23) {
                a.a(theme);
            }
        }
    }

    private static void a(b bVar, int i2, ColorStateList colorStateList) {
        synchronized (f955c) {
            WeakHashMap<b, SparseArray<a>> weakHashMap = f954b;
            SparseArray<a> sparseArray = weakHashMap.get(bVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(bVar, sparseArray);
            }
            sparseArray.append(i2, new a(colorStateList, bVar.a.getConfiguration()));
        }
    }

    private static ColorStateList b(b bVar, int i2) {
        a aVar;
        synchronized (f955c) {
            SparseArray<a> sparseArray = f954b.get(bVar);
            if (sparseArray != null && sparseArray.size() > 0 && (aVar = sparseArray.get(i2)) != null) {
                if (aVar.f956b.equals(bVar.a.getConfiguration())) {
                    return aVar.a;
                }
                sparseArray.remove(i2);
            }
            return null;
        }
    }

    public static ColorStateList c(Resources resources, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColorStateList(i2, theme);
        }
        b bVar = new b(resources, theme);
        ColorStateList colorStateListB = b(bVar, i2);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListI = i(resources, i2, theme);
        if (colorStateListI == null) {
            return resources.getColorStateList(i2);
        }
        a(bVar, i2, colorStateListI);
        return colorStateListI;
    }

    public static Drawable d(Resources resources, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i2, theme) : resources.getDrawable(i2);
    }

    public static Typeface e(Context context, int i2) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return k(context, i2, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface f(Context context, int i2, TypedValue typedValue, int i3, c cVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return k(context, i2, typedValue, i3, cVar, null, true, false);
    }

    public static void g(Context context, int i2, c cVar, Handler handler) throws Resources.NotFoundException {
        i.c(cVar);
        if (context.isRestricted()) {
            cVar.a(-4, handler);
        } else {
            k(context, i2, new TypedValue(), 0, cVar, handler, false, false);
        }
    }

    private static TypedValue h() {
        ThreadLocal<TypedValue> threadLocal = a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList i(Resources resources, int i2, Resources.Theme theme) {
        if (j(resources, i2)) {
            return null;
        }
        try {
            return androidx.core.content.d.a.a(resources, resources.getXml(i2), theme);
        } catch (Exception e2) {
            Log.e("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    private static boolean j(Resources resources, int i2) {
        TypedValue typedValueH = h();
        resources.getValue(i2, typedValueH, true);
        int i3 = typedValueH.type;
        return i3 >= 28 && i3 <= 31;
    }

    private static Typeface k(Context context, int i2, TypedValue typedValue, int i3, c cVar, Handler handler, boolean z, boolean z2) {
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        Typeface typefaceL = l(context, resources, typedValue, i2, i3, cVar, handler, z, z2);
        if (typefaceL != null || cVar != null || z2) {
            return typefaceL;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i2) + " could not be retrieved.");
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00a6  */
    private static Typeface l(Context context, Resources resources, TypedValue typedValue, int i2, int i3, c cVar, Handler handler, boolean z, boolean z2) {
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i2) + "\" (" + Integer.toHexString(i2) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        if (!string.startsWith("res/")) {
            if (cVar != null) {
                cVar.a(-3, handler);
            }
            return null;
        }
        Typeface typefaceF = c.i.e.d.f(resources, i2, i3);
        if (typefaceF != null) {
            if (cVar != null) {
                cVar.b(typefaceF, handler);
            }
            return typefaceF;
        }
        if (z2) {
            return null;
        }
        try {
            if (!string.toLowerCase().endsWith(".xml")) {
                Typeface typefaceD = c.i.e.d.d(context, resources, i2, string, i3);
                if (cVar != null) {
                    if (typefaceD != null) {
                        cVar.b(typefaceD, handler);
                    } else {
                        cVar.a(-3, handler);
                    }
                }
                return typefaceD;
            }
            androidx.core.content.d.c.a aVarB = androidx.core.content.d.c.b(resources.getXml(i2), resources);
            if (aVarB != null) {
                return c.i.e.d.c(context, aVarB, resources, i2, i3, cVar, handler, z);
            }
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            if (cVar != null) {
                cVar.a(-3, handler);
            }
            return null;
        } catch (IOException e2) {
            Log.e("ResourcesCompat", "Failed to read xml resource " + string, e2);
            if (cVar != null) {
                cVar.a(-3, handler);
            }
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("ResourcesCompat", "Failed to parse xml resource " + string, e3);
            if (cVar != null) {
                cVar.a(-3, handler);
            }
            return null;
        }
    }
}
