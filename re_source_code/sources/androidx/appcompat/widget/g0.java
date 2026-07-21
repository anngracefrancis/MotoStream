package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ResourceManagerInternal.java */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static g0 f522b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakHashMap<Context, c.e.h<ColorStateList>> f524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c.e.g<String, d> f525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c.e.h<String> f526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WeakHashMap<Context, c.e.d<WeakReference<Drawable.ConstantState>>> f527g = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TypedValue f528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private e f530j;
    private static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f523c = new c(6);

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    static class a implements d {
        a() {
        }

        @Override // androidx.appcompat.widget.g0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return c.a.l.a.a.m(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    private static class b implements d {
        b() {
        }

        @Override // androidx.appcompat.widget.g0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return c.y.a.a.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    private static class c extends c.e.e<Integer, PorterDuffColorFilter> {
        public c(int i2) {
            super(i2);
        }

        private static int h(int i2, PorterDuff.Mode mode) {
            return ((i2 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter i(int i2, PorterDuff.Mode mode) {
            return c(Integer.valueOf(h(i2, mode)));
        }

        PorterDuffColorFilter j(int i2, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return d(Integer.valueOf(h(i2, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    private interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    interface e {
        boolean a(Context context, int i2, Drawable drawable);

        PorterDuff.Mode b(int i2);

        Drawable c(g0 g0Var, Context context, int i2);

        ColorStateList d(Context context, int i2);

        boolean e(Context context, int i2, Drawable drawable);
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    private static class f implements d {
        f() {
        }

        @Override // androidx.appcompat.widget.g0.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return c.y.a.a.i.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    private void a(String str, d dVar) {
        if (this.f525e == null) {
            this.f525e = new c.e.g<>();
        }
        this.f525e.put(str, dVar);
    }

    private synchronized boolean b(Context context, long j2, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        c.e.d<WeakReference<Drawable.ConstantState>> dVar = this.f527g.get(context);
        if (dVar == null) {
            dVar = new c.e.d<>();
            this.f527g.put(context, dVar);
        }
        dVar.k(j2, new WeakReference<>(constantState));
        return true;
    }

    private void c(Context context, int i2, ColorStateList colorStateList) {
        if (this.f524d == null) {
            this.f524d = new WeakHashMap<>();
        }
        c.e.h<ColorStateList> hVar = this.f524d.get(context);
        if (hVar == null) {
            hVar = new c.e.h<>();
            this.f524d.put(context, hVar);
        }
        hVar.b(i2, colorStateList);
    }

    private void d(Context context) {
        if (this.f529i) {
            return;
        }
        this.f529i = true;
        Drawable drawableJ = j(context, c.a.m.a.a);
        if (drawableJ == null || !q(drawableJ)) {
            this.f529i = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long e(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable f(Context context, int i2) {
        if (this.f528h == null) {
            this.f528h = new TypedValue();
        }
        TypedValue typedValue = this.f528h;
        context.getResources().getValue(i2, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        e eVar = this.f530j;
        Drawable drawableC = eVar == null ? null : eVar.c(this, context, i2);
        if (drawableC != null) {
            drawableC.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, jE, drawableC);
        }
        return drawableC;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized g0 h() {
        if (f522b == null) {
            g0 g0Var = new g0();
            f522b = g0Var;
            p(g0Var);
        }
        return f522b;
    }

    private synchronized Drawable i(Context context, long j2) {
        c.e.d<WeakReference<Drawable.ConstantState>> dVar = this.f527g.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReferenceG = dVar.g(j2);
        if (weakReferenceG != null) {
            Drawable.ConstantState constantState = weakReferenceG.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            dVar.l(j2);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter l(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterI;
        c cVar = f523c;
        porterDuffColorFilterI = cVar.i(i2, mode);
        if (porterDuffColorFilterI == null) {
            porterDuffColorFilterI = new PorterDuffColorFilter(i2, mode);
            cVar.j(i2, mode, porterDuffColorFilterI);
        }
        return porterDuffColorFilterI;
    }

    private ColorStateList n(Context context, int i2) {
        c.e.h<ColorStateList> hVar;
        WeakHashMap<Context, c.e.h<ColorStateList>> weakHashMap = this.f524d;
        if (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return hVar.g(i2);
    }

    private static void p(g0 g0Var) {
        if (Build.VERSION.SDK_INT < 24) {
            g0Var.a("vector", new f());
            g0Var.a("animated-vector", new b());
            g0Var.a("animated-selector", new a());
        }
    }

    private static boolean q(Drawable drawable) {
        return (drawable instanceof c.y.a.a.i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable r(Context context, int i2) {
        int next;
        c.e.g<String, d> gVar = this.f525e;
        if (gVar == null || gVar.isEmpty()) {
            return null;
        }
        c.e.h<String> hVar = this.f526f;
        if (hVar != null) {
            String strG = hVar.g(i2);
            if ("appcompat_skip_skip".equals(strG) || (strG != null && this.f525e.get(strG) == null)) {
                return null;
            }
        } else {
            this.f526f = new c.e.h<>();
        }
        if (this.f528h == null) {
            this.f528h = new TypedValue();
        }
        TypedValue typedValue = this.f528h;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f526f.b(i2, name);
                d dVar = this.f525e.get(name);
                if (dVar != null) {
                    drawableI = dVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableI != null) {
                    drawableI.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, jE, drawableI);
                }
            } catch (Exception e2) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e2);
            }
        }
        if (drawableI == null) {
            this.f526f.b(i2, "appcompat_skip_skip");
        }
        return drawableI;
    }

    private Drawable v(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList colorStateListM = m(context, i2);
        if (colorStateListM == null) {
            e eVar = this.f530j;
            if ((eVar == null || !eVar.e(context, i2, drawable)) && !x(context, i2, drawable) && z) {
                return null;
            }
            return drawable;
        }
        if (y.a(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable drawableR = androidx.core.graphics.drawable.a.r(drawable);
        androidx.core.graphics.drawable.a.o(drawableR, colorStateListM);
        PorterDuff.Mode modeO = o(i2);
        if (modeO == null) {
            return drawableR;
        }
        androidx.core.graphics.drawable.a.p(drawableR, modeO);
        return drawableR;
    }

    static void w(Drawable drawable, o0 o0Var, int[] iArr) {
        if (y.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        boolean z = o0Var.f596d;
        if (z || o0Var.f595c) {
            drawable.setColorFilter(g(z ? o0Var.a : null, o0Var.f595c ? o0Var.f594b : a, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public synchronized Drawable j(Context context, int i2) {
        return k(context, i2, false);
    }

    synchronized Drawable k(Context context, int i2, boolean z) {
        Drawable drawableR;
        d(context);
        drawableR = r(context, i2);
        if (drawableR == null) {
            drawableR = f(context, i2);
        }
        if (drawableR == null) {
            drawableR = androidx.core.content.a.f(context, i2);
        }
        if (drawableR != null) {
            drawableR = v(context, i2, z, drawableR);
        }
        if (drawableR != null) {
            y.b(drawableR);
        }
        return drawableR;
    }

    synchronized ColorStateList m(Context context, int i2) {
        ColorStateList colorStateListN;
        colorStateListN = n(context, i2);
        if (colorStateListN == null) {
            e eVar = this.f530j;
            colorStateListN = eVar == null ? null : eVar.d(context, i2);
            if (colorStateListN != null) {
                c(context, i2, colorStateListN);
            }
        }
        return colorStateListN;
    }

    PorterDuff.Mode o(int i2) {
        e eVar = this.f530j;
        if (eVar == null) {
            return null;
        }
        return eVar.b(i2);
    }

    public synchronized void s(Context context) {
        c.e.d<WeakReference<Drawable.ConstantState>> dVar = this.f527g.get(context);
        if (dVar != null) {
            dVar.d();
        }
    }

    synchronized Drawable t(Context context, v0 v0Var, int i2) {
        Drawable drawableR = r(context, i2);
        if (drawableR == null) {
            drawableR = v0Var.c(i2);
        }
        if (drawableR == null) {
            return null;
        }
        return v(context, i2, false, drawableR);
    }

    public synchronized void u(e eVar) {
        this.f530j = eVar;
    }

    boolean x(Context context, int i2, Drawable drawable) {
        e eVar = this.f530j;
        return eVar != null && eVar.a(context, i2, drawable);
    }
}
