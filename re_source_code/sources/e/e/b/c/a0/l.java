package e.e.b.c.a0;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;

/* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {
    private final m[] a = new m[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Matrix[] f20926b = new Matrix[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix[] f20927c = new Matrix[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PointF f20928d = new PointF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Path f20929e = new Path();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Path f20930f = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m f20931g = new m();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f20932h = new float[2];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f20933i = new float[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f20934j = true;

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    public interface a {
        void a(m mVar, Matrix matrix, int i2);

        void b(m mVar, Matrix matrix, int i2);
    }

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    static final class b {
        public final k a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f20935b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RectF f20936c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a f20937d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f20938e;

        b(k kVar, float f2, RectF rectF, a aVar, Path path) {
            this.f20937d = aVar;
            this.a = kVar;
            this.f20938e = f2;
            this.f20936c = rectF;
            this.f20935b = path;
        }
    }

    public l() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.a[i2] = new m();
            this.f20926b[i2] = new Matrix();
            this.f20927c[i2] = new Matrix();
        }
    }

    private float a(int i2) {
        return (i2 + 1) * 90;
    }

    private void b(b bVar, int i2) {
        this.f20932h[0] = this.a[i2].k();
        this.f20932h[1] = this.a[i2].l();
        this.f20926b[i2].mapPoints(this.f20932h);
        if (i2 == 0) {
            Path path = bVar.f20935b;
            float[] fArr = this.f20932h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = bVar.f20935b;
            float[] fArr2 = this.f20932h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.a[i2].d(this.f20926b[i2], bVar.f20935b);
        a aVar = bVar.f20937d;
        if (aVar != null) {
            aVar.a(this.a[i2], this.f20926b[i2], i2);
        }
    }

    private void c(b bVar, int i2) {
        int i3 = (i2 + 1) % 4;
        this.f20932h[0] = this.a[i2].i();
        this.f20932h[1] = this.a[i2].j();
        this.f20926b[i2].mapPoints(this.f20932h);
        this.f20933i[0] = this.a[i3].k();
        this.f20933i[1] = this.a[i3].l();
        this.f20926b[i3].mapPoints(this.f20933i);
        float[] fArr = this.f20932h;
        float f2 = fArr[0];
        float[] fArr2 = this.f20933i;
        float fMax = Math.max(((float) Math.hypot(f2 - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
        float fI = i(bVar.f20936c, i2);
        this.f20931g.n(0.0f, 0.0f);
        f fVarJ = j(i2, bVar.a);
        fVarJ.d(fMax, fI, bVar.f20938e, this.f20931g);
        Path path = new Path();
        this.f20931g.d(this.f20927c[i2], path);
        if (this.f20934j && Build.VERSION.SDK_INT >= 19 && (fVarJ.b() || k(path, i2) || k(path, i3))) {
            path.op(path, this.f20930f, Path.Op.DIFFERENCE);
            this.f20932h[0] = this.f20931g.k();
            this.f20932h[1] = this.f20931g.l();
            this.f20927c[i2].mapPoints(this.f20932h);
            Path path2 = this.f20929e;
            float[] fArr3 = this.f20932h;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.f20931g.d(this.f20927c[i2], this.f20929e);
        } else {
            this.f20931g.d(this.f20927c[i2], bVar.f20935b);
        }
        a aVar = bVar.f20937d;
        if (aVar != null) {
            aVar.b(this.f20931g, this.f20927c[i2], i2);
        }
    }

    private void f(int i2, RectF rectF, PointF pointF) {
        if (i2 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i2 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i2 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private c g(int i2, k kVar) {
        if (i2 == 1) {
            return kVar.l();
        }
        if (i2 != 2) {
            return i2 != 3 ? kVar.t() : kVar.r();
        }
        return kVar.j();
    }

    private d h(int i2, k kVar) {
        if (i2 == 1) {
            return kVar.k();
        }
        if (i2 != 2) {
            return i2 != 3 ? kVar.s() : kVar.q();
        }
        return kVar.i();
    }

    private float i(RectF rectF, int i2) {
        float[] fArr = this.f20932h;
        m[] mVarArr = this.a;
        fArr[0] = mVarArr[i2].f20940c;
        fArr[1] = mVarArr[i2].f20941d;
        this.f20926b[i2].mapPoints(fArr);
        return (i2 == 1 || i2 == 3) ? Math.abs(rectF.centerX() - this.f20932h[0]) : Math.abs(rectF.centerY() - this.f20932h[1]);
    }

    private f j(int i2, k kVar) {
        if (i2 == 1) {
            return kVar.h();
        }
        if (i2 != 2) {
            return i2 != 3 ? kVar.o() : kVar.p();
        }
        return kVar.n();
    }

    private boolean k(Path path, int i2) {
        Path path2 = new Path();
        this.a[i2].d(this.f20926b[i2], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void l(b bVar, int i2) {
        h(i2, bVar.a).b(this.a[i2], 90.0f, bVar.f20938e, bVar.f20936c, g(i2, bVar.a));
        float fA = a(i2);
        this.f20926b[i2].reset();
        f(i2, bVar.f20936c, this.f20928d);
        Matrix matrix = this.f20926b[i2];
        PointF pointF = this.f20928d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f20926b[i2].preRotate(fA);
    }

    private void m(int i2) {
        this.f20932h[0] = this.a[i2].i();
        this.f20932h[1] = this.a[i2].j();
        this.f20926b[i2].mapPoints(this.f20932h);
        float fA = a(i2);
        this.f20927c[i2].reset();
        Matrix matrix = this.f20927c[i2];
        float[] fArr = this.f20932h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f20927c[i2].preRotate(fA);
    }

    public void d(k kVar, float f2, RectF rectF, Path path) {
        e(kVar, f2, rectF, null, path);
    }

    public void e(k kVar, float f2, RectF rectF, a aVar, Path path) {
        path.rewind();
        this.f20929e.rewind();
        this.f20930f.rewind();
        this.f20930f.addRect(rectF, Path.Direction.CW);
        b bVar = new b(kVar, f2, rectF, aVar, path);
        for (int i2 = 0; i2 < 4; i2++) {
            l(bVar, i2);
            m(i2);
        }
        for (int i3 = 0; i3 < 4; i3++) {
            b(bVar, i3);
            c(bVar, i3);
        }
        path.close();
        this.f20929e.close();
        if (Build.VERSION.SDK_INT < 19 || this.f20929e.isEmpty()) {
            return;
        }
        path.op(this.f20929e, Path.Op.UNION);
    }
}
