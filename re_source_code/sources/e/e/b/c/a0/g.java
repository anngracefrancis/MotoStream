package e.e.b.c.a0;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.util.BitSet;

/* JADX INFO: compiled from: MaterialShapeDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends Drawable implements androidx.core.graphics.drawable.b, n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f20889f = g.class.getSimpleName();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Paint f20890g = new Paint(1);
    private PorterDuffColorFilter A;
    private final RectF B;
    private boolean C;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c f20891h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final m.g[] f20892i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final m.g[] f20893j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final BitSet f20894k;
    private boolean l;
    private final Matrix m;
    private final Path n;
    private final Path o;
    private final RectF p;
    private final RectF q;
    private final Region r;
    private final Region s;
    private k t;
    private final Paint u;
    private final Paint v;
    private final e.e.b.c.z.a w;
    private final l.a x;
    private final l y;
    private PorterDuffColorFilter z;

    /* JADX INFO: compiled from: MaterialShapeDrawable.java */
    class a implements l.a {
        a() {
        }

        @Override // e.e.b.c.a0.l.a
        public void a(m mVar, Matrix matrix, int i2) {
            g.this.f20894k.set(i2, mVar.e());
            g.this.f20892i[i2] = mVar.f(matrix);
        }

        @Override // e.e.b.c.a0.l.a
        public void b(m mVar, Matrix matrix, int i2) {
            g.this.f20894k.set(i2 + 4, mVar.e());
            g.this.f20893j[i2] = mVar.f(matrix);
        }
    }

    /* JADX INFO: compiled from: MaterialShapeDrawable.java */
    class b implements k.c {
        final /* synthetic */ float a;

        b(float f2) {
            this.a = f2;
        }

        @Override // e.e.b.c.a0.k.c
        public e.e.b.c.a0.c a(e.e.b.c.a0.c cVar) {
            return cVar instanceof i ? cVar : new e.e.b.c.a0.b(this.a, cVar);
        }
    }

    /* synthetic */ g(c cVar, a aVar) {
        this(cVar);
    }

    private float E() {
        if (M()) {
            return this.v.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean K() {
        c cVar = this.f20891h;
        int i2 = cVar.q;
        return i2 != 1 && cVar.r > 0 && (i2 == 2 || U());
    }

    private boolean L() {
        Paint.Style style = this.f20891h.v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean M() {
        Paint.Style style = this.f20891h.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.v.getStrokeWidth() > 0.0f;
    }

    private void O() {
        super.invalidateSelf();
    }

    private void R(Canvas canvas) {
        if (K()) {
            canvas.save();
            T(canvas);
            if (!this.C) {
                n(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.B.width() - getBounds().width());
            int iHeight = (int) (this.B.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.B.width()) + (this.f20891h.r * 2) + iWidth, ((int) this.B.height()) + (this.f20891h.r * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f2 = (getBounds().left - this.f20891h.r) - iWidth;
            float f3 = (getBounds().top - this.f20891h.r) - iHeight;
            canvas2.translate(-f2, -f3);
            n(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f2, f3, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    private static int S(int i2, int i3) {
        return (i2 * (i3 + (i3 >>> 7))) >>> 8;
    }

    private void T(Canvas canvas) {
        int iA = A();
        int iB = B();
        if (Build.VERSION.SDK_INT < 21 && this.C) {
            Rect clipBounds = canvas.getClipBounds();
            int i2 = this.f20891h.r;
            clipBounds.inset(-i2, -i2);
            clipBounds.offset(iA, iB);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate(iA, iB);
    }

    private PorterDuffColorFilter f(Paint paint, boolean z) {
        int color;
        int iL;
        if (!z || (iL = l((color = paint.getColor()))) == color) {
            return null;
        }
        return new PorterDuffColorFilter(iL, PorterDuff.Mode.SRC_IN);
    }

    private void g(RectF rectF, Path path) {
        h(rectF, path);
        if (this.f20891h.f20904j != 1.0f) {
            this.m.reset();
            Matrix matrix = this.m;
            float f2 = this.f20891h.f20904j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.m);
        }
        path.computeBounds(this.B, true);
    }

    private void i() {
        k kVarX = D().x(new b(-E()));
        this.t = kVarX;
        this.y.d(kVarX, this.f20891h.f20905k, v(), this.o);
    }

    private boolean i0(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f20891h.f20898d == null || color2 == (colorForState2 = this.f20891h.f20898d.getColorForState(iArr, (color2 = this.u.getColor())))) {
            z = false;
        } else {
            this.u.setColor(colorForState2);
            z = true;
        }
        if (this.f20891h.f20899e == null || color == (colorForState = this.f20891h.f20899e.getColorForState(iArr, (color = this.v.getColor())))) {
            return z;
        }
        this.v.setColor(colorForState);
        return true;
    }

    private PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = l(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private boolean j0() {
        PorterDuffColorFilter porterDuffColorFilter = this.z;
        PorterDuffColorFilter porterDuffColorFilter2 = this.A;
        c cVar = this.f20891h;
        this.z = k(cVar.f20901g, cVar.f20902h, this.u, true);
        c cVar2 = this.f20891h;
        this.A = k(cVar2.f20900f, cVar2.f20902h, this.v, false);
        c cVar3 = this.f20891h;
        if (cVar3.u) {
            this.w.d(cVar3.f20901g.getColorForState(getState(), 0));
        }
        return (c.i.j.d.a(porterDuffColorFilter, this.z) && c.i.j.d.a(porterDuffColorFilter2, this.A)) ? false : true;
    }

    private PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        return (colorStateList == null || mode == null) ? f(paint, z) : j(colorStateList, mode, z);
    }

    private void k0() {
        float fJ = J();
        this.f20891h.r = (int) Math.ceil(0.75f * fJ);
        this.f20891h.s = (int) Math.ceil(fJ * 0.25f);
        j0();
        O();
    }

    private int l(int i2) {
        float fJ = J() + z();
        e.e.b.c.t.a aVar = this.f20891h.f20896b;
        return aVar != null ? aVar.c(i2, fJ) : i2;
    }

    public static g m(Context context, float f2) {
        int iB = e.e.b.c.q.a.b(context, e.e.b.c.b.o, g.class.getSimpleName());
        g gVar = new g();
        gVar.N(context);
        gVar.X(ColorStateList.valueOf(iB));
        gVar.W(f2);
        return gVar;
    }

    private void n(Canvas canvas) {
        if (this.f20894k.cardinality() > 0) {
            Log.w(f20889f, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f20891h.s != 0) {
            canvas.drawPath(this.n, this.w.c());
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.f20892i[i2].b(this.w, this.f20891h.r, canvas);
            this.f20893j[i2].b(this.w, this.f20891h.r, canvas);
        }
        if (this.C) {
            int iA = A();
            int iB = B();
            canvas.translate(-iA, -iB);
            canvas.drawPath(this.n, f20890g);
            canvas.translate(iA, iB);
        }
    }

    private void o(Canvas canvas) {
        q(canvas, this.u, this.n, this.f20891h.a, u());
    }

    private void q(Canvas canvas, Paint paint, Path path, k kVar, RectF rectF) {
        if (!kVar.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = kVar.t().a(rectF) * this.f20891h.f20905k;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    private void r(Canvas canvas) {
        q(canvas, this.v, this.o, this.t, v());
    }

    private RectF v() {
        this.q.set(u());
        float fE = E();
        this.q.inset(fE, fE);
        return this.q;
    }

    public int A() {
        c cVar = this.f20891h;
        double d2 = cVar.s;
        double dSin = Math.sin(Math.toRadians(cVar.t));
        Double.isNaN(d2);
        return (int) (d2 * dSin);
    }

    public int B() {
        c cVar = this.f20891h;
        double d2 = cVar.s;
        double dCos = Math.cos(Math.toRadians(cVar.t));
        Double.isNaN(d2);
        return (int) (d2 * dCos);
    }

    public int C() {
        return this.f20891h.r;
    }

    public k D() {
        return this.f20891h.a;
    }

    public ColorStateList F() {
        return this.f20891h.f20901g;
    }

    public float G() {
        return this.f20891h.a.r().a(u());
    }

    public float H() {
        return this.f20891h.a.t().a(u());
    }

    public float I() {
        return this.f20891h.p;
    }

    public float J() {
        return w() + I();
    }

    public void N(Context context) {
        this.f20891h.f20896b = new e.e.b.c.t.a(context);
        k0();
    }

    public boolean P() {
        e.e.b.c.t.a aVar = this.f20891h.f20896b;
        return aVar != null && aVar.d();
    }

    public boolean Q() {
        return this.f20891h.a.u(u());
    }

    public boolean U() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 < 21 || !(Q() || this.n.isConvex() || i2 >= 29);
    }

    public void V(float f2) {
        setShapeAppearanceModel(this.f20891h.a.w(f2));
    }

    public void W(float f2) {
        c cVar = this.f20891h;
        if (cVar.o != f2) {
            cVar.o = f2;
            k0();
        }
    }

    public void X(ColorStateList colorStateList) {
        c cVar = this.f20891h;
        if (cVar.f20898d != colorStateList) {
            cVar.f20898d = colorStateList;
            onStateChange(getState());
        }
    }

    public void Y(float f2) {
        c cVar = this.f20891h;
        if (cVar.f20905k != f2) {
            cVar.f20905k = f2;
            this.l = true;
            invalidateSelf();
        }
    }

    public void Z(int i2, int i3, int i4, int i5) {
        c cVar = this.f20891h;
        if (cVar.f20903i == null) {
            cVar.f20903i = new Rect();
        }
        this.f20891h.f20903i.set(i2, i3, i4, i5);
        invalidateSelf();
    }

    public void a0(float f2) {
        c cVar = this.f20891h;
        if (cVar.n != f2) {
            cVar.n = f2;
            k0();
        }
    }

    public void b0(boolean z) {
        this.C = z;
    }

    public void c0(int i2) {
        this.w.d(i2);
        this.f20891h.u = false;
        O();
    }

    public void d0(int i2) {
        c cVar = this.f20891h;
        if (cVar.t != i2) {
            cVar.t = i2;
            O();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.u.setColorFilter(this.z);
        int alpha = this.u.getAlpha();
        this.u.setAlpha(S(alpha, this.f20891h.m));
        this.v.setColorFilter(this.A);
        this.v.setStrokeWidth(this.f20891h.l);
        int alpha2 = this.v.getAlpha();
        this.v.setAlpha(S(alpha2, this.f20891h.m));
        if (this.l) {
            i();
            g(u(), this.n);
            this.l = false;
        }
        R(canvas);
        if (L()) {
            o(canvas);
        }
        if (M()) {
            r(canvas);
        }
        this.u.setAlpha(alpha);
        this.v.setAlpha(alpha2);
    }

    public void e0(float f2, int i2) {
        h0(f2);
        g0(ColorStateList.valueOf(i2));
    }

    public void f0(float f2, ColorStateList colorStateList) {
        h0(f2);
        g0(colorStateList);
    }

    public void g0(ColorStateList colorStateList) {
        c cVar = this.f20891h;
        if (cVar.f20899e != colorStateList) {
            cVar.f20899e = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f20891h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f20891h.q == 2) {
            return;
        }
        if (Q()) {
            outline.setRoundRect(getBounds(), G() * this.f20891h.f20905k);
            return;
        }
        g(u(), this.n);
        if (this.n.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.n);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f20891h.f20903i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.r.set(getBounds());
        g(u(), this.n);
        this.s.setPath(this.n, this.r);
        this.r.op(this.s, Region.Op.DIFFERENCE);
        return this.r;
    }

    protected final void h(RectF rectF, Path path) {
        l lVar = this.y;
        c cVar = this.f20891h;
        lVar.e(cVar.a, cVar.f20905k, rectF, this.x, path);
    }

    public void h0(float f2) {
        this.f20891h.l = f2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.l = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f20891h.f20901g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f20891h.f20900f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f20891h.f20899e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f20891h.f20898d) != null && colorStateList4.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f20891h = new c(this.f20891h);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.l = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.h.b
    protected boolean onStateChange(int[] iArr) {
        boolean z = i0(iArr) || j0();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    protected void p(Canvas canvas, Paint paint, Path path, RectF rectF) {
        q(canvas, paint, path, this.f20891h.a, rectF);
    }

    public float s() {
        return this.f20891h.a.j().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        c cVar = this.f20891h;
        if (cVar.m != i2) {
            cVar.m = i2;
            O();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f20891h.f20897c = colorFilter;
        O();
    }

    @Override // e.e.b.c.a0.n
    public void setShapeAppearanceModel(k kVar) {
        this.f20891h.a = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f20891h.f20901g = colorStateList;
        j0();
        O();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f20891h;
        if (cVar.f20902h != mode) {
            cVar.f20902h = mode;
            j0();
            O();
        }
    }

    public float t() {
        return this.f20891h.a.l().a(u());
    }

    protected RectF u() {
        this.p.set(getBounds());
        return this.p;
    }

    public float w() {
        return this.f20891h.o;
    }

    public ColorStateList x() {
        return this.f20891h.f20898d;
    }

    public float y() {
        return this.f20891h.f20905k;
    }

    public float z() {
        return this.f20891h.n;
    }

    public g() {
        this(new k());
    }

    public g(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(k.e(context, attributeSet, i2, i3).m());
    }

    public g(k kVar) {
        this(new c(kVar, null));
    }

    private g(c cVar) {
        this.f20892i = new m.g[4];
        this.f20893j = new m.g[4];
        this.f20894k = new BitSet(8);
        this.m = new Matrix();
        this.n = new Path();
        this.o = new Path();
        this.p = new RectF();
        this.q = new RectF();
        this.r = new Region();
        this.s = new Region();
        Paint paint = new Paint(1);
        this.u = paint;
        Paint paint2 = new Paint(1);
        this.v = paint2;
        this.w = new e.e.b.c.z.a();
        this.y = new l();
        this.B = new RectF();
        this.C = true;
        this.f20891h = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = f20890g;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        j0();
        i0(getState());
        this.x = new a();
    }

    /* JADX INFO: compiled from: MaterialShapeDrawable.java */
    static final class c extends Drawable.ConstantState {
        public k a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e.e.b.c.t.a f20896b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorFilter f20897c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ColorStateList f20898d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ColorStateList f20899e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ColorStateList f20900f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ColorStateList f20901g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f20902h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Rect f20903i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f20904j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f20905k;
        public float l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;

        public c(k kVar, e.e.b.c.t.a aVar) {
            this.f20898d = null;
            this.f20899e = null;
            this.f20900f = null;
            this.f20901g = null;
            this.f20902h = PorterDuff.Mode.SRC_IN;
            this.f20903i = null;
            this.f20904j = 1.0f;
            this.f20905k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = kVar;
            this.f20896b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this, null);
            gVar.l = true;
            return gVar;
        }

        public c(c cVar) {
            this.f20898d = null;
            this.f20899e = null;
            this.f20900f = null;
            this.f20901g = null;
            this.f20902h = PorterDuff.Mode.SRC_IN;
            this.f20903i = null;
            this.f20904j = 1.0f;
            this.f20905k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = cVar.a;
            this.f20896b = cVar.f20896b;
            this.l = cVar.l;
            this.f20897c = cVar.f20897c;
            this.f20898d = cVar.f20898d;
            this.f20899e = cVar.f20899e;
            this.f20902h = cVar.f20902h;
            this.f20901g = cVar.f20901g;
            this.m = cVar.m;
            this.f20904j = cVar.f20904j;
            this.s = cVar.s;
            this.q = cVar.q;
            this.u = cVar.u;
            this.f20905k = cVar.f20905k;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
            this.r = cVar.r;
            this.t = cVar.t;
            this.f20900f = cVar.f20900f;
            this.v = cVar.v;
            if (cVar.f20903i != null) {
                this.f20903i = new Rect(cVar.f20903i);
            }
        }
    }
}
