package e.e.b.c.a0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: compiled from: ShapeAppearanceModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {
    public static final e.e.b.c.a0.c a = new i(0.5f);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    d f20906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    d f20907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    d f20908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    d f20909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    e.e.b.c.a0.c f20910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    e.e.b.c.a0.c f20911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    e.e.b.c.a0.c f20912h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    e.e.b.c.a0.c f20913i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    f f20914j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    f f20915k;
    f l;
    f m;

    /* JADX INFO: compiled from: ShapeAppearanceModel.java */
    public interface c {
        e.e.b.c.a0.c a(e.e.b.c.a0.c cVar);
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i2, int i3) {
        return c(context, i2, i3, 0);
    }

    private static b c(Context context, int i2, int i3, int i4) {
        return d(context, i2, i3, new e.e.b.c.a0.a(i4));
    }

    private static b d(Context context, int i2, int i3, e.e.b.c.a0.c cVar) {
        if (i3 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
            i2 = i3;
            context = contextThemeWrapper;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, e.e.b.c.l.T3);
        try {
            int i4 = typedArrayObtainStyledAttributes.getInt(e.e.b.c.l.U3, 0);
            int i5 = typedArrayObtainStyledAttributes.getInt(e.e.b.c.l.X3, i4);
            int i6 = typedArrayObtainStyledAttributes.getInt(e.e.b.c.l.Y3, i4);
            int i7 = typedArrayObtainStyledAttributes.getInt(e.e.b.c.l.W3, i4);
            int i8 = typedArrayObtainStyledAttributes.getInt(e.e.b.c.l.V3, i4);
            e.e.b.c.a0.c cVarM = m(typedArrayObtainStyledAttributes, e.e.b.c.l.Z3, cVar);
            e.e.b.c.a0.c cVarM2 = m(typedArrayObtainStyledAttributes, e.e.b.c.l.c4, cVarM);
            e.e.b.c.a0.c cVarM3 = m(typedArrayObtainStyledAttributes, e.e.b.c.l.d4, cVarM);
            e.e.b.c.a0.c cVarM4 = m(typedArrayObtainStyledAttributes, e.e.b.c.l.b4, cVarM);
            return new b().x(i5, cVarM2).B(i6, cVarM3).t(i7, cVarM4).p(i8, m(typedArrayObtainStyledAttributes, e.e.b.c.l.a4, cVarM));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i2, int i3) {
        return f(context, attributeSet, i2, i3, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i2, int i3, int i4) {
        return g(context, attributeSet, i2, i3, new e.e.b.c.a0.a(i4));
    }

    public static b g(Context context, AttributeSet attributeSet, int i2, int i3, e.e.b.c.a0.c cVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.e.b.c.l.w3, i2, i3);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(e.e.b.c.l.x3, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(e.e.b.c.l.y3, 0);
        typedArrayObtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    private static e.e.b.c.a0.c m(TypedArray typedArray, int i2, e.e.b.c.a0.c cVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        if (typedValuePeekValue == null) {
            return cVar;
        }
        int i3 = typedValuePeekValue.type;
        if (i3 == 5) {
            return new e.e.b.c.a0.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i3 == 6 ? new i(typedValuePeekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public f h() {
        return this.l;
    }

    public d i() {
        return this.f20909e;
    }

    public e.e.b.c.a0.c j() {
        return this.f20913i;
    }

    public d k() {
        return this.f20908d;
    }

    public e.e.b.c.a0.c l() {
        return this.f20912h;
    }

    public f n() {
        return this.m;
    }

    public f o() {
        return this.f20915k;
    }

    public f p() {
        return this.f20914j;
    }

    public d q() {
        return this.f20906b;
    }

    public e.e.b.c.a0.c r() {
        return this.f20910f;
    }

    public d s() {
        return this.f20907c;
    }

    public e.e.b.c.a0.c t() {
        return this.f20911g;
    }

    public boolean u(RectF rectF) {
        boolean z = this.m.getClass().equals(f.class) && this.f20915k.getClass().equals(f.class) && this.f20914j.getClass().equals(f.class) && this.l.getClass().equals(f.class);
        float fA = this.f20910f.a(rectF);
        return z && ((this.f20911g.a(rectF) > fA ? 1 : (this.f20911g.a(rectF) == fA ? 0 : -1)) == 0 && (this.f20913i.a(rectF) > fA ? 1 : (this.f20913i.a(rectF) == fA ? 0 : -1)) == 0 && (this.f20912h.a(rectF) > fA ? 1 : (this.f20912h.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f20907c instanceof j) && (this.f20906b instanceof j) && (this.f20908d instanceof j) && (this.f20909e instanceof j));
    }

    public b v() {
        return new b(this);
    }

    public k w(float f2) {
        return v().o(f2).m();
    }

    public k x(c cVar) {
        return v().A(cVar.a(r())).E(cVar.a(t())).s(cVar.a(j())).w(cVar.a(l())).m();
    }

    private k(b bVar) {
        this.f20906b = bVar.a;
        this.f20907c = bVar.f20916b;
        this.f20908d = bVar.f20917c;
        this.f20909e = bVar.f20918d;
        this.f20910f = bVar.f20919e;
        this.f20911g = bVar.f20920f;
        this.f20912h = bVar.f20921g;
        this.f20913i = bVar.f20922h;
        this.f20914j = bVar.f20923i;
        this.f20915k = bVar.f20924j;
        this.l = bVar.f20925k;
        this.m = bVar.l;
    }

    /* JADX INFO: compiled from: ShapeAppearanceModel.java */
    public static final class b {
        private d a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d f20916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private d f20917c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d f20918d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private e.e.b.c.a0.c f20919e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private e.e.b.c.a0.c f20920f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private e.e.b.c.a0.c f20921g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private e.e.b.c.a0.c f20922h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private f f20923i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private f f20924j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private f f20925k;
        private f l;

        public b() {
            this.a = h.b();
            this.f20916b = h.b();
            this.f20917c = h.b();
            this.f20918d = h.b();
            this.f20919e = new e.e.b.c.a0.a(0.0f);
            this.f20920f = new e.e.b.c.a0.a(0.0f);
            this.f20921g = new e.e.b.c.a0.a(0.0f);
            this.f20922h = new e.e.b.c.a0.a(0.0f);
            this.f20923i = h.c();
            this.f20924j = h.c();
            this.f20925k = h.c();
            this.l = h.c();
        }

        private static float n(d dVar) {
            if (dVar instanceof j) {
                return ((j) dVar).a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).a;
            }
            return -1.0f;
        }

        public b A(e.e.b.c.a0.c cVar) {
            this.f20919e = cVar;
            return this;
        }

        public b B(int i2, e.e.b.c.a0.c cVar) {
            return C(h.a(i2)).E(cVar);
        }

        public b C(d dVar) {
            this.f20916b = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                D(fN);
            }
            return this;
        }

        public b D(float f2) {
            this.f20920f = new e.e.b.c.a0.a(f2);
            return this;
        }

        public b E(e.e.b.c.a0.c cVar) {
            this.f20920f = cVar;
            return this;
        }

        public k m() {
            return new k(this);
        }

        public b o(float f2) {
            return z(f2).D(f2).v(f2).r(f2);
        }

        public b p(int i2, e.e.b.c.a0.c cVar) {
            return q(h.a(i2)).s(cVar);
        }

        public b q(d dVar) {
            this.f20918d = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                r(fN);
            }
            return this;
        }

        public b r(float f2) {
            this.f20922h = new e.e.b.c.a0.a(f2);
            return this;
        }

        public b s(e.e.b.c.a0.c cVar) {
            this.f20922h = cVar;
            return this;
        }

        public b t(int i2, e.e.b.c.a0.c cVar) {
            return u(h.a(i2)).w(cVar);
        }

        public b u(d dVar) {
            this.f20917c = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                v(fN);
            }
            return this;
        }

        public b v(float f2) {
            this.f20921g = new e.e.b.c.a0.a(f2);
            return this;
        }

        public b w(e.e.b.c.a0.c cVar) {
            this.f20921g = cVar;
            return this;
        }

        public b x(int i2, e.e.b.c.a0.c cVar) {
            return y(h.a(i2)).A(cVar);
        }

        public b y(d dVar) {
            this.a = dVar;
            float fN = n(dVar);
            if (fN != -1.0f) {
                z(fN);
            }
            return this;
        }

        public b z(float f2) {
            this.f20919e = new e.e.b.c.a0.a(f2);
            return this;
        }

        public b(k kVar) {
            this.a = h.b();
            this.f20916b = h.b();
            this.f20917c = h.b();
            this.f20918d = h.b();
            this.f20919e = new e.e.b.c.a0.a(0.0f);
            this.f20920f = new e.e.b.c.a0.a(0.0f);
            this.f20921g = new e.e.b.c.a0.a(0.0f);
            this.f20922h = new e.e.b.c.a0.a(0.0f);
            this.f20923i = h.c();
            this.f20924j = h.c();
            this.f20925k = h.c();
            this.l = h.c();
            this.a = kVar.f20906b;
            this.f20916b = kVar.f20907c;
            this.f20917c = kVar.f20908d;
            this.f20918d = kVar.f20909e;
            this.f20919e = kVar.f20910f;
            this.f20920f = kVar.f20911g;
            this.f20921g = kVar.f20912h;
            this.f20922h = kVar.f20913i;
            this.f20923i = kVar.f20914j;
            this.f20924j = kVar.f20915k;
            this.f20925k = kVar.l;
            this.l = kVar.m;
        }
    }

    public k() {
        this.f20906b = h.b();
        this.f20907c = h.b();
        this.f20908d = h.b();
        this.f20909e = h.b();
        this.f20910f = new e.e.b.c.a0.a(0.0f);
        this.f20911g = new e.e.b.c.a0.a(0.0f);
        this.f20912h = new e.e.b.c.a0.a(0.0f);
        this.f20913i = new e.e.b.c.a0.a(0.0f);
        this.f20914j = h.c();
        this.f20915k = h.c();
        this.l = h.c();
        this.m = h.c();
    }
}
