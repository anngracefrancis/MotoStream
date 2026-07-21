package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* JADX INFO: compiled from: AppCompatDrawableManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    private static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static h f531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g0 f532c;

    /* JADX INFO: compiled from: AppCompatDrawableManager.java */
    class a implements g0.e {
        private final int[] a = {c.a.e.S, c.a.e.Q, c.a.e.a};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f533b = {c.a.e.o, c.a.e.B, c.a.e.t, c.a.e.p, c.a.e.q, c.a.e.s, c.a.e.r};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f534c = {c.a.e.P, c.a.e.R, c.a.e.f2721k, c.a.e.I, c.a.e.J, c.a.e.L, c.a.e.N, c.a.e.K, c.a.e.M, c.a.e.O};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f535d = {c.a.e.w, c.a.e.f2719i, c.a.e.v};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f536e = {c.a.e.H, c.a.e.T};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int[] f537f = {c.a.e.f2713c, c.a.e.f2717g, c.a.e.f2714d, c.a.e.f2718h};

        a() {
        }

        private boolean f(int[] iArr, int i2) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i2) {
            int iC = l0.c(context, c.a.a.v);
            return new ColorStateList(new int[][]{l0.f576b, l0.f579e, l0.f577c, l0.f583i}, new int[]{l0.b(context, c.a.a.t), c.i.e.a.j(iC, i2), c.i.e.a.j(iC, i2), i2});
        }

        private ColorStateList i(Context context) {
            return h(context, l0.c(context, c.a.a.s));
        }

        private ColorStateList j(Context context) {
            return h(context, l0.c(context, c.a.a.t));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i2 = c.a.a.y;
            ColorStateList colorStateListE = l0.e(context, i2);
            if (colorStateListE == null || !colorStateListE.isStateful()) {
                iArr[0] = l0.f576b;
                iArr2[0] = l0.b(context, i2);
                iArr[1] = l0.f580f;
                iArr2[1] = l0.c(context, c.a.a.u);
                iArr[2] = l0.f583i;
                iArr2[2] = l0.c(context, i2);
            } else {
                iArr[0] = l0.f576b;
                iArr2[0] = colorStateListE.getColorForState(iArr[0], 0);
                iArr[1] = l0.f580f;
                iArr2[1] = l0.c(context, c.a.a.u);
                iArr[2] = l0.f583i;
                iArr2[2] = colorStateListE.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private void l(Drawable drawable, int i2, PorterDuff.Mode mode) {
            if (y.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = h.a;
            }
            drawable.setColorFilter(h.e(i2, mode));
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0046  */
        /* JADX WARN: Code duplicated, block: B:23:0x004c  */
        /* JADX WARN: Code duplicated, block: B:26:0x005d  */
        /* JADX WARN: Code duplicated, block: B:28:0x0061 A[RETURN] */
        @Override // androidx.appcompat.widget.g0.e
        public boolean a(Context context, int i2, Drawable drawable) {
            int iRound;
            boolean z;
            PorterDuff.Mode mode = h.a;
            boolean zF = f(this.a, i2);
            int i3 = R.attr.colorBackground;
            if (zF) {
                i3 = c.a.a.w;
            } else if (f(this.f534c, i2)) {
                i3 = c.a.a.u;
            } else {
                if (!f(this.f535d, i2)) {
                    if (i2 == c.a.e.u) {
                        i3 = R.attr.colorForeground;
                        iRound = Math.round(40.8f);
                        z = true;
                    } else if (i2 != c.a.e.l) {
                        iRound = -1;
                        z = false;
                        i3 = 0;
                    }
                    if (z) {
                        return false;
                    }
                    if (y.a(drawable)) {
                        drawable = drawable.mutate();
                    }
                    drawable.setColorFilter(h.e(l0.c(context, i3), mode));
                    if (iRound != -1) {
                        drawable.setAlpha(iRound);
                    }
                    return true;
                }
                mode = PorterDuff.Mode.MULTIPLY;
            }
            iRound = -1;
            z = true;
            if (z) {
                return false;
            }
            if (y.a(drawable)) {
                drawable = drawable.mutate();
            }
            drawable.setColorFilter(h.e(l0.c(context, i3), mode));
            if (iRound != -1) {
                drawable.setAlpha(iRound);
            }
            return true;
        }

        @Override // androidx.appcompat.widget.g0.e
        public PorterDuff.Mode b(int i2) {
            if (i2 == c.a.e.F) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.g0.e
        public Drawable c(g0 g0Var, Context context, int i2) {
            if (i2 == c.a.e.f2720j) {
                return new LayerDrawable(new Drawable[]{g0Var.j(context, c.a.e.f2719i), g0Var.j(context, c.a.e.f2721k)});
            }
            return null;
        }

        @Override // androidx.appcompat.widget.g0.e
        public ColorStateList d(Context context, int i2) {
            if (i2 == c.a.e.m) {
                return c.a.k.a.a.c(context, c.a.c.f2698e);
            }
            if (i2 == c.a.e.G) {
                return c.a.k.a.a.c(context, c.a.c.f2701h);
            }
            if (i2 == c.a.e.F) {
                return k(context);
            }
            if (i2 == c.a.e.f2716f) {
                return j(context);
            }
            if (i2 == c.a.e.f2712b) {
                return g(context);
            }
            if (i2 == c.a.e.f2715e) {
                return i(context);
            }
            if (i2 == c.a.e.D || i2 == c.a.e.E) {
                return c.a.k.a.a.c(context, c.a.c.f2700g);
            }
            if (f(this.f533b, i2)) {
                return l0.e(context, c.a.a.w);
            }
            if (f(this.f536e, i2)) {
                return c.a.k.a.a.c(context, c.a.c.f2697d);
            }
            if (f(this.f537f, i2)) {
                return c.a.k.a.a.c(context, c.a.c.f2696c);
            }
            if (i2 == c.a.e.A) {
                return c.a.k.a.a.c(context, c.a.c.f2699f);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.g0.e
        public boolean e(Context context, int i2, Drawable drawable) {
            if (i2 == c.a.e.C) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background);
                int i3 = c.a.a.w;
                l(drawableFindDrawableByLayerId, l0.c(context, i3), h.a);
                l(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), l0.c(context, i3), h.a);
                l(layerDrawable.findDrawableByLayerId(R.id.progress), l0.c(context, c.a.a.u), h.a);
                return true;
            }
            if (i2 != c.a.e.y && i2 != c.a.e.x && i2 != c.a.e.z) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            l(layerDrawable2.findDrawableByLayerId(R.id.background), l0.b(context, c.a.a.w), h.a);
            Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress);
            int i4 = c.a.a.u;
            l(drawableFindDrawableByLayerId2, l0.c(context, i4), h.a);
            l(layerDrawable2.findDrawableByLayerId(R.id.progress), l0.c(context, i4), h.a);
            return true;
        }
    }

    public static synchronized h b() {
        if (f531b == null) {
            h();
        }
        return f531b;
    }

    public static synchronized PorterDuffColorFilter e(int i2, PorterDuff.Mode mode) {
        return g0.l(i2, mode);
    }

    public static synchronized void h() {
        if (f531b == null) {
            h hVar = new h();
            f531b = hVar;
            hVar.f532c = g0.h();
            f531b.f532c.u(new a());
        }
    }

    static void i(Drawable drawable, o0 o0Var, int[] iArr) {
        g0.w(drawable, o0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i2) {
        return this.f532c.j(context, i2);
    }

    synchronized Drawable d(Context context, int i2, boolean z) {
        return this.f532c.k(context, i2, z);
    }

    synchronized ColorStateList f(Context context, int i2) {
        return this.f532c.m(context, i2);
    }

    public synchronized void g(Context context) {
        this.f532c.s(context);
    }
}
