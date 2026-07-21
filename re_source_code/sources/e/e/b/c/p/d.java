package e.e.b.c.p;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* JADX INFO: compiled from: CircularRevealWidget.java */
/* JADX INFO: loaded from: classes2.dex */
public interface d {

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class b implements TypeEvaluator<e> {
        public static final TypeEvaluator<e> a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e f21068b = new e();

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f2, e eVar, e eVar2) {
            this.f21068b.a(e.e.b.c.v.a.c(eVar.a, eVar2.a, f2), e.e.b.c.v.a.c(eVar.f21069b, eVar2.f21069b, f2), e.e.b.c.v.a.c(eVar.f21070c, eVar2.f21070c, f2));
            return this.f21068b;
        }
    }

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class c extends Property<d, e> {
        public static final Property<d, e> a = new c("circularReveal");

        private c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(d dVar) {
            return dVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, e eVar) {
            dVar.setRevealInfo(eVar);
        }
    }

    /* JADX INFO: renamed from: e.e.b.c.p.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class C0261d extends Property<d, Integer> {
        public static final Property<d, Integer> a = new C0261d("circularRevealScrimColor");

        private C0261d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class e {
        public float a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f21069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f21070c;

        public void a(float f2, float f3, float f4) {
            this.a = f2;
            this.f21069b = f3;
            this.f21070c = f4;
        }

        private e() {
        }

        public e(float f2, float f3, float f4) {
            this.a = f2;
            this.f21069b = f3;
            this.f21070c = f4;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i2);

    void setRevealInfo(e eVar);
}
