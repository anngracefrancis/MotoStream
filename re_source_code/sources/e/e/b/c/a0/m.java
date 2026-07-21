package e.e.b.c.a0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ShapePath.java */
/* JADX INFO: loaded from: classes2.dex */
public class m {

    @Deprecated
    public float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f20939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f20940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f20941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f20942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f20943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<f> f20944g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<g> f20945h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f20946i;

    /* JADX INFO: compiled from: ShapePath.java */
    class a extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f20947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Matrix f20948c;

        a(List list, Matrix matrix) {
            this.f20947b = list;
            this.f20948c = matrix;
        }

        @Override // e.e.b.c.a0.m.g
        public void a(Matrix matrix, e.e.b.c.z.a aVar, int i2, Canvas canvas) {
            Iterator it = this.f20947b.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(this.f20948c, aVar, i2, canvas);
            }
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    static class b extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f20950b;

        public b(d dVar) {
            this.f20950b = dVar;
        }

        @Override // e.e.b.c.a0.m.g
        public void a(Matrix matrix, e.e.b.c.z.a aVar, int i2, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f20950b.k(), this.f20950b.o(), this.f20950b.l(), this.f20950b.j()), i2, this.f20950b.m(), this.f20950b.n());
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    static class c extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e f20951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f20952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f20953d;

        public c(e eVar, float f2, float f3) {
            this.f20951b = eVar;
            this.f20952c = f2;
            this.f20953d = f3;
        }

        @Override // e.e.b.c.a0.m.g
        public void a(Matrix matrix, e.e.b.c.z.a aVar, int i2, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f20951b.f20962c - this.f20953d, this.f20951b.f20961b - this.f20952c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f20952c, this.f20953d);
            matrix2.preRotate(c());
            aVar.b(canvas, matrix2, rectF, i2);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f20951b.f20962c - this.f20953d) / (this.f20951b.f20961b - this.f20952c)));
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class d extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final RectF f20954b = new RectF();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f20955c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f20956d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f20957e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f20958f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f20959g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Deprecated
        public float f20960h;

        public d(float f2, float f3, float f4, float f5) {
            q(f2);
            u(f3);
            r(f4);
            p(f5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f20958f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.f20955c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f20957e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f20959g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f20960h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f20956d;
        }

        private void p(float f2) {
            this.f20958f = f2;
        }

        private void q(float f2) {
            this.f20955c = f2;
        }

        private void r(float f2) {
            this.f20957e = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f2) {
            this.f20959g = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f2) {
            this.f20960h = f2;
        }

        private void u(float f2) {
            this.f20956d = f2;
        }

        @Override // e.e.b.c.a0.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f20954b;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class e extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f20961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f20962c;

        @Override // e.e.b.c.a0.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f20961b, this.f20962c);
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static abstract class f {
        protected final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: compiled from: ShapePath.java */
    static abstract class g {
        static final Matrix a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, e.e.b.c.z.a aVar, int i2, Canvas canvas);

        public final void b(e.e.b.c.z.a aVar, int i2, Canvas canvas) {
            a(a, aVar, i2, canvas);
        }
    }

    public m() {
        n(0.0f, 0.0f);
    }

    private void b(float f2) {
        if (g() == f2) {
            return;
        }
        float fG = ((f2 - g()) + 360.0f) % 360.0f;
        if (fG > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(fG);
        this.f20945h.add(new b(dVar));
        p(f2);
    }

    private void c(g gVar, float f2, float f3) {
        b(f2);
        this.f20945h.add(gVar);
        p(f3);
    }

    private float g() {
        return this.f20942e;
    }

    private float h() {
        return this.f20943f;
    }

    private void p(float f2) {
        this.f20942e = f2;
    }

    private void q(float f2) {
        this.f20943f = f2;
    }

    private void r(float f2) {
        this.f20940c = f2;
    }

    private void s(float f2) {
        this.f20941d = f2;
    }

    private void t(float f2) {
        this.a = f2;
    }

    private void u(float f2) {
        this.f20939b = f2;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        d dVar = new d(f2, f3, f4, f5);
        dVar.s(f6);
        dVar.t(f7);
        this.f20944g.add(dVar);
        b bVar = new b(dVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        c(bVar, f6, z ? (180.0f + f8) % 360.0f : f8);
        double d2 = f8;
        r(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))));
        s(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f20944g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f20944g.get(i2).a(matrix, path);
        }
    }

    boolean e() {
        return this.f20946i;
    }

    g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f20945h), matrix);
    }

    float i() {
        return this.f20940c;
    }

    float j() {
        return this.f20941d;
    }

    float k() {
        return this.a;
    }

    float l() {
        return this.f20939b;
    }

    public void m(float f2, float f3) {
        e eVar = new e();
        eVar.f20961b = f2;
        eVar.f20962c = f3;
        this.f20944g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f2);
        s(f3);
    }

    public void n(float f2, float f3) {
        o(f2, f3, 270.0f, 0.0f);
    }

    public void o(float f2, float f3, float f4, float f5) {
        t(f2);
        u(f3);
        r(f2);
        s(f3);
        p(f4);
        q((f4 + f5) % 360.0f);
        this.f20944g.clear();
        this.f20945h.clear();
        this.f20946i = false;
    }
}
