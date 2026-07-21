package c.a.l.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;

/* JADX INFO: compiled from: DrawableContainer.java */
/* JADX INFO: loaded from: classes.dex */
class b extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c f2772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Rect f2773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Drawable f2774h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Drawable f2775i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2777k;
    private boolean m;
    private Runnable n;
    private long o;
    private long p;
    private C0062b q;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2776j = 255;
    private int l = -1;

    /* JADX INFO: compiled from: DrawableContainer.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: c.a.l.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DrawableContainer.java */
    static class C0062b implements Drawable.Callback {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Drawable.Callback f2779f;

        C0062b() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f2779f;
            this.f2779f = null;
            return callback;
        }

        public C0062b b(Drawable.Callback callback) {
            this.f2779f = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            Drawable.Callback callback = this.f2779f;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j2);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f2779f;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* JADX INFO: compiled from: DrawableContainer.java */
    static abstract class c extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;
        final b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Resources f2780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2781c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2782d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f2783e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        SparseArray<Drawable.ConstantState> f2784f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Drawable[] f2785g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f2786h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f2787i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f2788j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Rect f2789k;
        boolean l;
        boolean m;
        int n;
        int o;
        int p;
        int q;
        boolean r;
        int s;
        boolean t;
        boolean u;
        boolean v;
        boolean w;
        boolean x;
        boolean y;
        int z;

        c(c cVar, b bVar, Resources resources) {
            this.f2781c = 160;
            this.f2787i = false;
            this.l = false;
            this.x = true;
            this.A = 0;
            this.B = 0;
            this.a = bVar;
            this.f2780b = resources != null ? resources : cVar != null ? cVar.f2780b : null;
            int iF = b.f(resources, cVar != null ? cVar.f2781c : 0);
            this.f2781c = iF;
            if (cVar == null) {
                this.f2785g = new Drawable[10];
                this.f2786h = 0;
                return;
            }
            this.f2782d = cVar.f2782d;
            this.f2783e = cVar.f2783e;
            this.v = true;
            this.w = true;
            this.f2787i = cVar.f2787i;
            this.l = cVar.l;
            this.x = cVar.x;
            this.y = cVar.y;
            this.z = cVar.z;
            this.A = cVar.A;
            this.B = cVar.B;
            this.C = cVar.C;
            this.D = cVar.D;
            this.E = cVar.E;
            this.F = cVar.F;
            this.G = cVar.G;
            this.H = cVar.H;
            this.I = cVar.I;
            if (cVar.f2781c == iF) {
                if (cVar.f2788j) {
                    this.f2789k = new Rect(cVar.f2789k);
                    this.f2788j = true;
                }
                if (cVar.m) {
                    this.n = cVar.n;
                    this.o = cVar.o;
                    this.p = cVar.p;
                    this.q = cVar.q;
                    this.m = true;
                }
            }
            if (cVar.r) {
                this.s = cVar.s;
                this.r = true;
            }
            if (cVar.t) {
                this.u = cVar.u;
                this.t = true;
            }
            Drawable[] drawableArr = cVar.f2785g;
            this.f2785g = new Drawable[drawableArr.length];
            this.f2786h = cVar.f2786h;
            SparseArray<Drawable.ConstantState> sparseArray = cVar.f2784f;
            if (sparseArray != null) {
                this.f2784f = sparseArray.clone();
            } else {
                this.f2784f = new SparseArray<>(this.f2786h);
            }
            int i2 = this.f2786h;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3] != null) {
                    Drawable.ConstantState constantState = drawableArr[i3].getConstantState();
                    if (constantState != null) {
                        this.f2784f.put(i3, constantState);
                    } else {
                        this.f2785g[i3] = drawableArr[i3];
                    }
                }
            }
        }

        private void e() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f2784f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f2785g[this.f2784f.keyAt(i2)] = s(this.f2784f.valueAt(i2).newDrawable(this.f2780b));
                }
                this.f2784f = null;
            }
        }

        private Drawable s(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.z);
            }
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setCallback(this.a);
            return drawableMutate;
        }

        public final int a(Drawable drawable) {
            int i2 = this.f2786h;
            if (i2 >= this.f2785g.length) {
                o(i2, i2 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.a);
            this.f2785g[i2] = drawable;
            this.f2786h++;
            this.f2783e = drawable.getChangingConfigurations() | this.f2783e;
            p();
            this.f2789k = null;
            this.f2788j = false;
            this.m = false;
            this.v = false;
            return i2;
        }

        final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i2 = this.f2786h;
                Drawable[] drawableArr = this.f2785g;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null && drawableArr[i3].canApplyTheme()) {
                        drawableArr[i3].applyTheme(theme);
                        this.f2783e |= drawableArr[i3].getChangingConfigurations();
                    }
                }
                y(theme.getResources());
            }
        }

        public synchronized boolean c() {
            if (this.v) {
                return this.w;
            }
            e();
            this.v = true;
            int i2 = this.f2786h;
            Drawable[] drawableArr = this.f2785g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getConstantState() == null) {
                    this.w = false;
                    return false;
                }
            }
            this.w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i2 = this.f2786h;
            Drawable[] drawableArr = this.f2785g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f2784f.get(i3);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        protected void d() {
            this.m = true;
            e();
            int i2 = this.f2786h;
            Drawable[] drawableArr = this.f2785g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.n) {
                    this.n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.o) {
                    this.o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.p) {
                    this.p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.q) {
                    this.q = minimumHeight;
                }
            }
        }

        final int f() {
            return this.f2785g.length;
        }

        public final Drawable g(int i2) {
            int iIndexOfKey;
            Drawable drawable = this.f2785g[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f2784f;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable drawableS = s(this.f2784f.valueAt(iIndexOfKey).newDrawable(this.f2780b));
            this.f2785g[i2] = drawableS;
            this.f2784f.removeAt(iIndexOfKey);
            if (this.f2784f.size() == 0) {
                this.f2784f = null;
            }
            return drawableS;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2782d | this.f2783e;
        }

        public final int h() {
            return this.f2786h;
        }

        public final int i() {
            if (!this.m) {
                d();
            }
            return this.o;
        }

        public final int j() {
            if (!this.m) {
                d();
            }
            return this.q;
        }

        public final int k() {
            if (!this.m) {
                d();
            }
            return this.p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f2787i) {
                return null;
            }
            Rect rect2 = this.f2789k;
            if (rect2 != null || this.f2788j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i2 = this.f2786h;
            Drawable[] drawableArr = this.f2785g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i4 = rect3.left;
                    if (i4 > rect.left) {
                        rect.left = i4;
                    }
                    int i5 = rect3.top;
                    if (i5 > rect.top) {
                        rect.top = i5;
                    }
                    int i6 = rect3.right;
                    if (i6 > rect.right) {
                        rect.right = i6;
                    }
                    int i7 = rect3.bottom;
                    if (i7 > rect.bottom) {
                        rect.bottom = i7;
                    }
                }
            }
            this.f2788j = true;
            this.f2789k = rect;
            return rect;
        }

        public final int m() {
            if (!this.m) {
                d();
            }
            return this.n;
        }

        public final int n() {
            if (this.r) {
                return this.s;
            }
            e();
            int i2 = this.f2786h;
            Drawable[] drawableArr = this.f2785g;
            int opacity = i2 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i3 = 1; i3 < i2; i3++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i3].getOpacity());
            }
            this.s = opacity;
            this.r = true;
            return opacity;
        }

        public void o(int i2, int i3) {
            Drawable[] drawableArr = new Drawable[i3];
            System.arraycopy(this.f2785g, 0, drawableArr, 0, i2);
            this.f2785g = drawableArr;
        }

        void p() {
            this.r = false;
            this.t = false;
        }

        public final boolean q() {
            return this.l;
        }

        abstract void r();

        public final void t(boolean z) {
            this.l = z;
        }

        public final void u(int i2) {
            this.A = i2;
        }

        public final void v(int i2) {
            this.B = i2;
        }

        final boolean w(int i2, int i3) {
            int i4 = this.f2786h;
            Drawable[] drawableArr = this.f2785g;
            boolean z = false;
            for (int i5 = 0; i5 < i4; i5++) {
                if (drawableArr[i5] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i5].setLayoutDirection(i2) : false;
                    if (i5 == i3) {
                        z = layoutDirection;
                    }
                }
            }
            this.z = i2;
            return z;
        }

        public final void x(boolean z) {
            this.f2787i = z;
        }

        final void y(Resources resources) {
            if (resources != null) {
                this.f2780b = resources;
                int iF = b.f(resources, this.f2781c);
                int i2 = this.f2781c;
                this.f2781c = iF;
                if (i2 != iF) {
                    this.m = false;
                    this.f2788j = false;
                }
            }
        }
    }

    b() {
    }

    private void d(Drawable drawable) {
        if (this.q == null) {
            this.q = new C0062b();
        }
        drawable.setCallback(this.q.b(drawable.getCallback()));
        try {
            if (this.f2772f.A <= 0 && this.f2777k) {
                drawable.setAlpha(this.f2776j);
            }
            c cVar = this.f2772f;
            if (cVar.E) {
                drawable.setColorFilter(cVar.D);
            } else {
                if (cVar.H) {
                    androidx.core.graphics.drawable.a.o(drawable, cVar.F);
                }
                c cVar2 = this.f2772f;
                if (cVar2.I) {
                    androidx.core.graphics.drawable.a.p(drawable, cVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f2772f.x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (i2 >= 19) {
                drawable.setAutoMirrored(this.f2772f.C);
            }
            Rect rect = this.f2773g;
            if (i2 >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.q.a());
        }
    }

    private boolean e() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.f(this) == 1;
    }

    static int f(Resources resources, int i2) {
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
        }
        if (i2 == 0) {
            return 160;
        }
        return i2;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003f  */
    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    /* JADX WARN: Code duplicated, block: B:18:0x0049  */
    /* JADX WARN: Code duplicated, block: B:19:0x0052  */
    /* JADX WARN: Code duplicated, block: B:20:0x0065  */
    /* JADX WARN: Code duplicated, block: B:23:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    void a(boolean z) {
        boolean z2;
        Drawable drawable;
        long j2;
        boolean z3 = true;
        this.f2777k = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.f2774h;
        if (drawable2 != null) {
            long j3 = this.o;
            if (j3 != 0) {
                if (j3 <= jUptimeMillis) {
                    drawable2.setAlpha(this.f2776j);
                    this.o = 0L;
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j3 - jUptimeMillis) * 255)) / this.f2772f.A)) * this.f2776j) / 255);
                    z2 = true;
                }
            }
            drawable = this.f2775i;
            if (drawable != null) {
                j2 = this.p;
                if (j2 == 0) {
                    if (j2 <= jUptimeMillis) {
                        drawable.setVisible(false, false);
                        this.f2775i = null;
                        this.p = 0L;
                    } else {
                        drawable.setAlpha(((((int) ((j2 - jUptimeMillis) * 255)) / this.f2772f.B) * this.f2776j) / 255);
                    }
                }
                if (z || !z3) {
                }
                scheduleSelf(this.n, jUptimeMillis + 16);
                return;
            }
            this.p = 0L;
            z3 = z2;
            if (z) {
            }
        }
        this.o = 0L;
        z2 = false;
        drawable = this.f2775i;
        if (drawable != null) {
            j2 = this.p;
            if (j2 == 0) {
                if (j2 <= jUptimeMillis) {
                    drawable.setVisible(false, false);
                    this.f2775i = null;
                    this.p = 0L;
                } else {
                    drawable.setAlpha(((((int) ((j2 - jUptimeMillis) * 255)) / this.f2772f.B) * this.f2776j) / 255);
                }
            }
            if (z) {
            }
        }
        this.p = 0L;
        z3 = z2;
        if (z) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f2772f.b(theme);
    }

    c b() {
        throw null;
    }

    int c() {
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f2772f.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f2774h;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f2775i;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    boolean g(int i2) {
        if (i2 == this.l) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f2772f.B > 0) {
            Drawable drawable = this.f2775i;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f2774h;
            if (drawable2 != null) {
                this.f2775i = drawable2;
                this.p = ((long) this.f2772f.B) + jUptimeMillis;
            } else {
                this.f2775i = null;
                this.p = 0L;
            }
        } else {
            Drawable drawable3 = this.f2774h;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i2 >= 0) {
            c cVar = this.f2772f;
            if (i2 < cVar.f2786h) {
                Drawable drawableG = cVar.g(i2);
                this.f2774h = drawableG;
                this.l = i2;
                if (drawableG != null) {
                    int i3 = this.f2772f.A;
                    if (i3 > 0) {
                        this.o = jUptimeMillis + ((long) i3);
                    }
                    d(drawableG);
                }
            } else {
                this.f2774h = null;
                this.l = -1;
            }
        } else {
            this.f2774h = null;
            this.l = -1;
        }
        if (this.o != 0 || this.p != 0) {
            Runnable runnable = this.n;
            if (runnable == null) {
                this.n = new a();
            } else {
                unscheduleSelf(runnable);
            }
            a(true);
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2776j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f2772f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f2772f.c()) {
            return null;
        }
        this.f2772f.f2782d = getChangingConfigurations();
        return this.f2772f;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f2774h;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f2773g;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f2772f.q()) {
            return this.f2772f.i();
        }
        Drawable drawable = this.f2774h;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f2772f.q()) {
            return this.f2772f.m();
        }
        Drawable drawable = this.f2774h;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f2772f.q()) {
            return this.f2772f.j();
        }
        Drawable drawable = this.f2774h;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f2772f.q()) {
            return this.f2772f.k();
        }
        Drawable drawable = this.f2774h;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f2774h;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f2772f.n();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f2774h;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect rectL = this.f2772f.l();
        if (rectL != null) {
            rect.set(rectL);
            padding = (rectL.right | ((rectL.left | rectL.top) | rectL.bottom)) != 0;
        } else {
            Drawable drawable = this.f2774h;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (e()) {
            int i2 = rect.left;
            rect.left = rect.right;
            rect.right = i2;
        }
        return padding;
    }

    void h(c cVar) {
        this.f2772f = cVar;
        int i2 = this.l;
        if (i2 >= 0) {
            Drawable drawableG = cVar.g(i2);
            this.f2774h = drawableG;
            if (drawableG != null) {
                d(drawableG);
            }
        }
        this.f2775i = null;
    }

    final void i(Resources resources) {
        this.f2772f.y(resources);
    }

    public void invalidateDrawable(Drawable drawable) {
        c cVar = this.f2772f;
        if (cVar != null) {
            cVar.p();
        }
        if (drawable != this.f2774h || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f2772f.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f2775i;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f2775i = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f2774h;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f2777k) {
                this.f2774h.setAlpha(this.f2776j);
            }
        }
        if (this.p != 0) {
            this.p = 0L;
            z = true;
        }
        if (this.o != 0) {
            this.o = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.m && super.mutate() == this) {
            c cVarB = b();
            cVarB.r();
            h(cVarB);
            this.m = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2775i;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f2774h;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        return this.f2772f.w(i2, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        Drawable drawable = this.f2775i;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.f2774h;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f2775i;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f2774h;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        if (drawable != this.f2774h || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.f2777k && this.f2776j == i2) {
            return;
        }
        this.f2777k = true;
        this.f2776j = i2;
        Drawable drawable = this.f2774h;
        if (drawable != null) {
            if (this.o == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        c cVar = this.f2772f;
        if (cVar.C != z) {
            cVar.C = z;
            Drawable drawable = this.f2774h;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.j(drawable, z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        c cVar = this.f2772f;
        cVar.E = true;
        if (cVar.D != colorFilter) {
            cVar.D = colorFilter;
            Drawable drawable = this.f2774h;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        c cVar = this.f2772f;
        if (cVar.x != z) {
            cVar.x = z;
            Drawable drawable = this.f2774h;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f2774h;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, f2, f3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.f2773g;
        if (rect == null) {
            this.f2773g = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.f2774h;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.l(drawable, i2, i3, i4, i5);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        c cVar = this.f2772f;
        cVar.H = true;
        if (cVar.F != colorStateList) {
            cVar.F = colorStateList;
            androidx.core.graphics.drawable.a.o(this.f2774h, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f2772f;
        cVar.I = true;
        if (cVar.G != mode) {
            cVar.G = mode;
            androidx.core.graphics.drawable.a.p(this.f2774h, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f2775i;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f2774h;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f2774h || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
