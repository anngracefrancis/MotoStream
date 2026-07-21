package com.airbnb.lottie.s.k;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.airbnb.lottie.q.b.o;
import com.airbnb.lottie.s.j.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: BaseLayer.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements com.airbnb.lottie.q.a.d, com.airbnb.lottie.q.b.a.InterfaceC0118a, com.airbnb.lottie.s.f {
    private final Path a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Matrix f8808b = new Matrix();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f8809c = new Paint(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Paint f8810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Paint f8811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Paint f8812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f8813g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final RectF f8814h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final RectF f8815i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final RectF f8816j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final RectF f8817k;
    private final String l;
    final Matrix m;
    final com.airbnb.lottie.f n;
    final d o;
    private com.airbnb.lottie.q.b.g p;
    private a q;
    private a r;
    private List<a> s;
    private final List<com.airbnb.lottie.q.b.a<?, ?>> t;
    final o u;
    private boolean v;

    /* JADX INFO: renamed from: com.airbnb.lottie.s.k.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseLayer.java */
    class C0119a implements com.airbnb.lottie.q.b.a.InterfaceC0118a {
        final /* synthetic */ com.airbnb.lottie.q.b.c a;

        C0119a(com.airbnb.lottie.q.b.c cVar) {
            this.a = cVar;
        }

        @Override // com.airbnb.lottie.q.b.a.InterfaceC0118a
        public void a() {
            a.this.B(this.a.h().floatValue() == 1.0f);
        }
    }

    /* JADX INFO: compiled from: BaseLayer.java */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f8819b;

        static {
            int[] iArr = new int[com.airbnb.lottie.s.j.g.a.values().length];
            f8819b = iArr;
            try {
                iArr[com.airbnb.lottie.s.j.g.a.MaskModeSubtract.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8819b[com.airbnb.lottie.s.j.g.a.MaskModeIntersect.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8819b[com.airbnb.lottie.s.j.g.a.MaskModeAdd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.a.values().length];
            a = iArr2;
            try {
                iArr2[d.a.Shape.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[d.a.PreComp.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[d.a.Solid.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[d.a.Image.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[d.a.Null.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[d.a.Text.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[d.a.Unknown.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    a(com.airbnb.lottie.f fVar, d dVar) {
        Paint paint = new Paint(1);
        this.f8810d = paint;
        Paint paint2 = new Paint(1);
        this.f8811e = paint2;
        Paint paint3 = new Paint(1);
        this.f8812f = paint3;
        Paint paint4 = new Paint();
        this.f8813g = paint4;
        this.f8814h = new RectF();
        this.f8815i = new RectF();
        this.f8816j = new RectF();
        this.f8817k = new RectF();
        this.m = new Matrix();
        this.t = new ArrayList();
        this.v = true;
        this.n = fVar;
        this.o = dVar;
        this.l = dVar.g() + "#draw";
        paint4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (dVar.f() == d.b.Invert) {
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        o oVarB = dVar.u().b();
        this.u = oVarB;
        oVarB.b(this);
        if (dVar.e() != null && !dVar.e().isEmpty()) {
            com.airbnb.lottie.q.b.g gVar = new com.airbnb.lottie.q.b.g(dVar.e());
            this.p = gVar;
            Iterator<com.airbnb.lottie.q.b.a<l, Path>> it = gVar.a().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            for (com.airbnb.lottie.q.b.a<Integer, Integer> aVar : this.p.c()) {
                i(aVar);
                aVar.a(this);
            }
        }
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(boolean z) {
        if (z != this.v) {
            this.v = z;
            u();
        }
    }

    private void C() {
        if (this.o.c().isEmpty()) {
            B(true);
            return;
        }
        com.airbnb.lottie.q.b.c cVar = new com.airbnb.lottie.q.b.c(this.o.c());
        cVar.k();
        cVar.a(new C0119a(cVar));
        B(cVar.h().floatValue() == 1.0f);
        i(cVar);
    }

    private void j(Canvas canvas, Matrix matrix) {
        k(canvas, matrix, com.airbnb.lottie.s.j.g.a.MaskModeAdd);
        k(canvas, matrix, com.airbnb.lottie.s.j.g.a.MaskModeIntersect);
        k(canvas, matrix, com.airbnb.lottie.s.j.g.a.MaskModeSubtract);
    }

    private void k(Canvas canvas, Matrix matrix, com.airbnb.lottie.s.j.g.a aVar) {
        boolean z = true;
        Paint paint = b.f8819b[aVar.ordinal()] != 1 ? this.f8810d : this.f8811e;
        int size = this.p.b().size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                z = false;
                break;
            } else if (this.p.b().get(i2).a() == aVar) {
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            com.airbnb.lottie.c.a("Layer#drawMask");
            com.airbnb.lottie.c.a("Layer#saveLayer");
            x(canvas, this.f8814h, paint, false);
            com.airbnb.lottie.c.c("Layer#saveLayer");
            m(canvas);
            for (int i3 = 0; i3 < size; i3++) {
                if (this.p.b().get(i3).a() == aVar) {
                    this.a.set(this.p.a().get(i3).h());
                    this.a.transform(matrix);
                    com.airbnb.lottie.q.b.a<Integer, Integer> aVar2 = this.p.c().get(i3);
                    int alpha = this.f8809c.getAlpha();
                    this.f8809c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
                    canvas.drawPath(this.a, this.f8809c);
                    this.f8809c.setAlpha(alpha);
                }
            }
            com.airbnb.lottie.c.a("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.c.c("Layer#restoreLayer");
            com.airbnb.lottie.c.c("Layer#drawMask");
        }
    }

    private void l() {
        if (this.s != null) {
            return;
        }
        if (this.r == null) {
            this.s = Collections.emptyList();
            return;
        }
        this.s = new ArrayList();
        for (a aVar = this.r; aVar != null; aVar = aVar.r) {
            this.s.add(aVar);
        }
    }

    private void m(Canvas canvas) {
        com.airbnb.lottie.c.a("Layer#clearLayer");
        RectF rectF = this.f8814h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f8813g);
        com.airbnb.lottie.c.c("Layer#clearLayer");
    }

    static a o(d dVar, com.airbnb.lottie.f fVar, com.airbnb.lottie.d dVar2) {
        switch (b.a[dVar.d().ordinal()]) {
            case 1:
                return new f(fVar, dVar);
            case 2:
                return new com.airbnb.lottie.s.k.b(fVar, dVar, dVar2.l(dVar.k()), dVar2);
            case 3:
                return new g(fVar, dVar);
            case 4:
                return new c(fVar, dVar);
            case 5:
                return new e(fVar, dVar);
            case 6:
                return new h(fVar, dVar);
            default:
                com.airbnb.lottie.c.d("Unknown layer type " + dVar.d());
                return null;
        }
    }

    private void s(RectF rectF, Matrix matrix) {
        this.f8815i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (q()) {
            int size = this.p.b().size();
            for (int i2 = 0; i2 < size; i2++) {
                com.airbnb.lottie.s.j.g gVar = this.p.b().get(i2);
                this.a.set(this.p.a().get(i2).h());
                this.a.transform(matrix);
                int i3 = b.f8819b[gVar.a().ordinal()];
                if (i3 == 1 || i3 == 2) {
                    return;
                }
                this.a.computeBounds(this.f8817k, false);
                if (i2 == 0) {
                    this.f8815i.set(this.f8817k);
                } else {
                    RectF rectF2 = this.f8815i;
                    rectF2.set(Math.min(rectF2.left, this.f8817k.left), Math.min(this.f8815i.top, this.f8817k.top), Math.max(this.f8815i.right, this.f8817k.right), Math.max(this.f8815i.bottom, this.f8817k.bottom));
                }
            }
            rectF.set(Math.max(rectF.left, this.f8815i.left), Math.max(rectF.top, this.f8815i.top), Math.min(rectF.right, this.f8815i.right), Math.min(rectF.bottom, this.f8815i.bottom));
        }
    }

    private void t(RectF rectF, Matrix matrix) {
        if (r() && this.o.f() != d.b.Invert) {
            this.q.d(this.f8816j, matrix);
            rectF.set(Math.max(rectF.left, this.f8816j.left), Math.max(rectF.top, this.f8816j.top), Math.min(rectF.right, this.f8816j.right), Math.min(rectF.bottom, this.f8816j.bottom));
        }
    }

    private void u() {
        this.n.invalidateSelf();
    }

    private void v(float f2) {
        this.n.j().k().a(this.o.g(), f2);
    }

    @SuppressLint({"WrongConstant"})
    private void x(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    void A(float f2) {
        this.u.i(f2);
        if (this.p != null) {
            for (int i2 = 0; i2 < this.p.a().size(); i2++) {
                this.p.a().get(i2).l(f2);
            }
        }
        if (this.o.t() != 0.0f) {
            f2 /= this.o.t();
        }
        a aVar = this.q;
        if (aVar != null) {
            this.q.A(aVar.o.t() * f2);
        }
        for (int i3 = 0; i3 < this.t.size(); i3++) {
            this.t.get(i3).l(f2);
        }
    }

    @Override // com.airbnb.lottie.q.b.a.InterfaceC0118a
    public void a() {
        u();
    }

    @Override // com.airbnb.lottie.q.a.b
    public void b(List<com.airbnb.lottie.q.a.b> list, List<com.airbnb.lottie.q.a.b> list2) {
    }

    @Override // com.airbnb.lottie.s.f
    public void c(com.airbnb.lottie.s.e eVar, int i2, List<com.airbnb.lottie.s.e> list, com.airbnb.lottie.s.e eVar2) {
        if (eVar.g(getName(), i2)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.a(getName());
                if (eVar.c(getName(), i2)) {
                    list.add(eVar2.i(this));
                }
            }
            if (eVar.h(getName(), i2)) {
                w(eVar, i2 + eVar.e(getName(), i2), list, eVar2);
            }
        }
    }

    @Override // com.airbnb.lottie.q.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.m.set(matrix);
        this.m.preConcat(this.u.e());
    }

    @Override // com.airbnb.lottie.q.a.d
    public void f(Canvas canvas, Matrix matrix, int i2) {
        com.airbnb.lottie.c.a(this.l);
        if (!this.v) {
            com.airbnb.lottie.c.c(this.l);
            return;
        }
        l();
        com.airbnb.lottie.c.a("Layer#parentMatrix");
        this.f8808b.reset();
        this.f8808b.set(matrix);
        for (int size = this.s.size() - 1; size >= 0; size--) {
            this.f8808b.preConcat(this.s.get(size).u.e());
        }
        com.airbnb.lottie.c.c("Layer#parentMatrix");
        int iIntValue = (int) ((((i2 / 255.0f) * this.u.g().h().intValue()) / 100.0f) * 255.0f);
        if (!r() && !q()) {
            this.f8808b.preConcat(this.u.e());
            com.airbnb.lottie.c.a("Layer#drawLayer");
            n(canvas, this.f8808b, iIntValue);
            com.airbnb.lottie.c.c("Layer#drawLayer");
            v(com.airbnb.lottie.c.c(this.l));
            return;
        }
        com.airbnb.lottie.c.a("Layer#computeBounds");
        this.f8814h.set(0.0f, 0.0f, 0.0f, 0.0f);
        d(this.f8814h, this.f8808b);
        t(this.f8814h, this.f8808b);
        this.f8808b.preConcat(this.u.e());
        s(this.f8814h, this.f8808b);
        this.f8814h.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.airbnb.lottie.c.c("Layer#computeBounds");
        com.airbnb.lottie.c.a("Layer#saveLayer");
        x(canvas, this.f8814h, this.f8809c, true);
        com.airbnb.lottie.c.c("Layer#saveLayer");
        m(canvas);
        com.airbnb.lottie.c.a("Layer#drawLayer");
        n(canvas, this.f8808b, iIntValue);
        com.airbnb.lottie.c.c("Layer#drawLayer");
        if (q()) {
            j(canvas, this.f8808b);
        }
        if (r()) {
            com.airbnb.lottie.c.a("Layer#drawMatte");
            com.airbnb.lottie.c.a("Layer#saveLayer");
            x(canvas, this.f8814h, this.f8812f, false);
            com.airbnb.lottie.c.c("Layer#saveLayer");
            m(canvas);
            this.q.f(canvas, matrix, iIntValue);
            com.airbnb.lottie.c.a("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.c.c("Layer#restoreLayer");
            com.airbnb.lottie.c.c("Layer#drawMatte");
        }
        com.airbnb.lottie.c.a("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.c.c("Layer#restoreLayer");
        v(com.airbnb.lottie.c.c(this.l));
    }

    @Override // com.airbnb.lottie.q.a.b
    public String getName() {
        return this.o.g();
    }

    @Override // com.airbnb.lottie.s.f
    public <T> void h(T t, com.airbnb.lottie.w.c<T> cVar) {
        this.u.c(t, cVar);
    }

    public void i(com.airbnb.lottie.q.b.a<?, ?> aVar) {
        this.t.add(aVar);
    }

    abstract void n(Canvas canvas, Matrix matrix, int i2);

    d p() {
        return this.o;
    }

    boolean q() {
        com.airbnb.lottie.q.b.g gVar = this.p;
        return (gVar == null || gVar.a().isEmpty()) ? false : true;
    }

    boolean r() {
        return this.q != null;
    }

    void w(com.airbnb.lottie.s.e eVar, int i2, List<com.airbnb.lottie.s.e> list, com.airbnb.lottie.s.e eVar2) {
    }

    void y(a aVar) {
        this.q = aVar;
    }

    void z(a aVar) {
        this.r = aVar;
    }
}
