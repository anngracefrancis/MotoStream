package com.airbnb.lottie.q.a;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: PolystarContent.java */
/* JADX INFO: loaded from: classes.dex */
public class m implements l, com.airbnb.lottie.q.b.a.InterfaceC0118a, j {
    private final Path a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.f f8615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.s.j.i.a f8616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, PointF> f8618f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8619g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8620h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8621i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8622j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.airbnb.lottie.q.b.a<?, Float> f8623k;
    private r l;
    private boolean m;

    /* JADX INFO: compiled from: PolystarContent.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.airbnb.lottie.s.j.i.a.values().length];
            a = iArr;
            try {
                iArr[com.airbnb.lottie.s.j.i.a.Star.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.airbnb.lottie.s.j.i.a.Polygon.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public m(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar, com.airbnb.lottie.s.j.i iVar) {
        this.f8615c = fVar;
        this.f8614b = iVar.d();
        com.airbnb.lottie.s.j.i.a aVarJ = iVar.j();
        this.f8616d = aVarJ;
        com.airbnb.lottie.q.b.a<Float, Float> aVarA = iVar.g().a();
        this.f8617e = aVarA;
        com.airbnb.lottie.q.b.a<PointF, PointF> aVarA2 = iVar.h().a();
        this.f8618f = aVarA2;
        com.airbnb.lottie.q.b.a<Float, Float> aVarA3 = iVar.i().a();
        this.f8619g = aVarA3;
        com.airbnb.lottie.q.b.a<Float, Float> aVarA4 = iVar.e().a();
        this.f8621i = aVarA4;
        com.airbnb.lottie.q.b.a<Float, Float> aVarA5 = iVar.f().a();
        this.f8623k = aVarA5;
        com.airbnb.lottie.s.j.i.a aVar2 = com.airbnb.lottie.s.j.i.a.Star;
        if (aVarJ == aVar2) {
            this.f8620h = iVar.b().a();
            this.f8622j = iVar.c().a();
        } else {
            this.f8620h = null;
            this.f8622j = null;
        }
        aVar.i(aVarA);
        aVar.i(aVarA2);
        aVar.i(aVarA3);
        aVar.i(aVarA4);
        aVar.i(aVarA5);
        if (aVarJ == aVar2) {
            aVar.i(this.f8620h);
            aVar.i(this.f8622j);
        }
        aVarA.a(this);
        aVarA2.a(this);
        aVarA3.a(this);
        aVarA4.a(this);
        aVarA5.a(this);
        if (aVarJ == aVar2) {
            this.f8620h.a(this);
            this.f8622j.a(this);
        }
    }

    private void e() {
        int iFloor = (int) Math.floor(this.f8617e.h().floatValue());
        com.airbnb.lottie.q.b.a<?, Float> aVar = this.f8619g;
        double radians = Math.toRadians((aVar == null ? 0.0d : aVar.h().floatValue()) - 90.0d);
        double d2 = iFloor;
        Double.isNaN(d2);
        float fFloatValue = this.f8623k.h().floatValue() / 100.0f;
        float fFloatValue2 = this.f8621i.h().floatValue();
        double d3 = fFloatValue2;
        double dCos = Math.cos(radians);
        Double.isNaN(d3);
        float f2 = (float) (dCos * d3);
        double dSin = Math.sin(radians);
        Double.isNaN(d3);
        float f3 = (float) (dSin * d3);
        this.a.moveTo(f2, f3);
        double d4 = (float) (6.283185307179586d / d2);
        Double.isNaN(d4);
        double d5 = radians + d4;
        double dCeil = Math.ceil(d2);
        int i2 = 0;
        while (i2 < dCeil) {
            double dCos2 = Math.cos(d5);
            Double.isNaN(d3);
            float f4 = (float) (dCos2 * d3);
            double dSin2 = Math.sin(d5);
            Double.isNaN(d3);
            double d6 = dCeil;
            float f5 = (float) (d3 * dSin2);
            if (fFloatValue != 0.0f) {
                double dAtan2 = (float) (Math.atan2(f3, f2) - 1.5707963267948966d);
                float fCos = (float) Math.cos(dAtan2);
                float fSin = (float) Math.sin(dAtan2);
                double dAtan3 = (float) (Math.atan2(f5, f4) - 1.5707963267948966d);
                float f6 = fFloatValue2 * fFloatValue * 0.25f;
                this.a.cubicTo(f2 - (fCos * f6), f3 - (fSin * f6), f4 + (((float) Math.cos(dAtan3)) * f6), f5 + (f6 * ((float) Math.sin(dAtan3))), f4, f5);
            } else {
                this.a.lineTo(f4, f5);
            }
            Double.isNaN(d4);
            d5 += d4;
            i2++;
            f3 = f5;
            f2 = f4;
            dCeil = d6;
            d3 = d3;
            d4 = d4;
        }
        PointF pointFH = this.f8618f.h();
        this.a.offset(pointFH.x, pointFH.y);
        this.a.close();
    }

    private void i() {
        float f2;
        float f3;
        float f4;
        float f5;
        double d2;
        float f6;
        float f7;
        float f8;
        float f9;
        float fFloatValue = this.f8617e.h().floatValue();
        com.airbnb.lottie.q.b.a<?, Float> aVar = this.f8619g;
        double radians = Math.toRadians((aVar == null ? 0.0d : aVar.h().floatValue()) - 90.0d);
        double d3 = fFloatValue;
        Double.isNaN(d3);
        float f10 = (float) (6.283185307179586d / d3);
        float f11 = f10 / 2.0f;
        float f12 = fFloatValue - ((int) fFloatValue);
        if (f12 != 0.0f) {
            double d4 = (1.0f - f12) * f11;
            Double.isNaN(d4);
            radians += d4;
        }
        float fFloatValue2 = this.f8621i.h().floatValue();
        float fFloatValue3 = this.f8620h.h().floatValue();
        com.airbnb.lottie.q.b.a<?, Float> aVar2 = this.f8622j;
        float fFloatValue4 = aVar2 != null ? aVar2.h().floatValue() / 100.0f : 0.0f;
        com.airbnb.lottie.q.b.a<?, Float> aVar3 = this.f8623k;
        float fFloatValue5 = aVar3 != null ? aVar3.h().floatValue() / 100.0f : 0.0f;
        if (f12 != 0.0f) {
            float f13 = ((fFloatValue2 - fFloatValue3) * f12) + fFloatValue3;
            double d5 = f13;
            double dCos = Math.cos(radians);
            Double.isNaN(d5);
            float f14 = (float) (d5 * dCos);
            double dSin = Math.sin(radians);
            Double.isNaN(d5);
            float f15 = (float) (d5 * dSin);
            this.a.moveTo(f14, f15);
            double d6 = (f10 * f12) / 2.0f;
            Double.isNaN(d6);
            d2 = radians + d6;
            f4 = f14;
            f6 = f13;
            f2 = fFloatValue2;
            f5 = f15;
            f3 = f11;
        } else {
            f2 = fFloatValue2;
            double d7 = f2;
            double dCos2 = Math.cos(radians);
            Double.isNaN(d7);
            f3 = f11;
            f4 = (float) (d7 * dCos2);
            double dSin2 = Math.sin(radians);
            Double.isNaN(d7);
            f5 = (float) (d7 * dSin2);
            this.a.moveTo(f4, f5);
            double d8 = f3;
            Double.isNaN(d8);
            d2 = radians + d8;
            f6 = 0.0f;
        }
        double dCeil = Math.ceil(d3) * 2.0d;
        int i2 = 0;
        float f16 = fFloatValue5;
        boolean z = false;
        while (true) {
            double d9 = i2;
            if (d9 >= dCeil) {
                PointF pointFH = this.f8618f.h();
                this.a.offset(pointFH.x, pointFH.y);
                this.a.close();
                return;
            }
            float f17 = z ? f2 : fFloatValue3;
            float f18 = (f6 == 0.0f || d9 != dCeil - 2.0d) ? f3 : (f10 * f12) / 2.0f;
            double d10 = (f6 == 0.0f || d9 != dCeil - 1.0d) ? f17 : f6;
            double dCos3 = Math.cos(d2);
            Double.isNaN(d10);
            float f19 = (float) (d10 * dCos3);
            double dSin3 = Math.sin(d2);
            Double.isNaN(d10);
            float f20 = (float) (d10 * dSin3);
            if (fFloatValue4 == 0.0f && f16 == 0.0f) {
                this.a.lineTo(f19, f20);
                f7 = fFloatValue3;
                f8 = fFloatValue4;
                f9 = f3;
            } else {
                f7 = fFloatValue3;
                f8 = fFloatValue4;
                double dAtan2 = (float) (Math.atan2(f5, f4) - 1.5707963267948966d);
                float fCos = (float) Math.cos(dAtan2);
                float fSin = (float) Math.sin(dAtan2);
                f9 = f3;
                double dAtan3 = (float) (Math.atan2(f20, f19) - 1.5707963267948966d);
                float fCos2 = (float) Math.cos(dAtan3);
                float fSin2 = (float) Math.sin(dAtan3);
                float f21 = z ? f8 : f16;
                float f22 = z ? f16 : f8;
                float f23 = (z ? f7 : f2) * f21 * 0.47829f;
                float f24 = fCos * f23;
                float f25 = f23 * fSin;
                float f26 = (z ? f2 : f7) * f22 * 0.47829f;
                float f27 = fCos2 * f26;
                float f28 = f26 * fSin2;
                if (f12 != 0.0f) {
                    if (i2 == 0) {
                        f24 *= f12;
                        f25 *= f12;
                    } else if (d9 == dCeil - 1.0d) {
                        f27 *= f12;
                        f28 *= f12;
                    }
                }
                this.a.cubicTo(f4 - f24, f5 - f25, f19 + f27, f20 + f28, f19, f20);
            }
            double d11 = f18;
            Double.isNaN(d11);
            z = !z;
            i2++;
            f5 = f20;
            d2 += d11;
            f3 = f9;
            f4 = f19;
            f2 = f2;
            f10 = f10;
            fFloatValue3 = f7;
            fFloatValue4 = f8;
        }
    }

    private void j() {
        this.m = false;
        this.f8615c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.q.b.a.InterfaceC0118a
    public void a() {
        j();
    }

    @Override // com.airbnb.lottie.q.a.b
    public void b(List<b> list, List<b> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.j() == com.airbnb.lottie.s.j.q.a.Simultaneously) {
                    this.l = rVar;
                    rVar.c(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.s.f
    public void c(com.airbnb.lottie.s.e eVar, int i2, List<com.airbnb.lottie.s.e> list, com.airbnb.lottie.s.e eVar2) {
        com.airbnb.lottie.v.e.l(eVar, i2, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.q.a.l
    public Path g() {
        if (this.m) {
            return this.a;
        }
        this.a.reset();
        int i2 = a.a[this.f8616d.ordinal()];
        if (i2 == 1) {
            i();
        } else if (i2 == 2) {
            e();
        }
        this.a.close();
        com.airbnb.lottie.v.f.b(this.a, this.l);
        this.m = true;
        return this.a;
    }

    @Override // com.airbnb.lottie.q.a.b
    public String getName() {
        return this.f8614b;
    }

    @Override // com.airbnb.lottie.s.f
    public <T> void h(T t, com.airbnb.lottie.w.c<T> cVar) {
        com.airbnb.lottie.q.b.a<?, Float> aVar;
        com.airbnb.lottie.q.b.a<?, Float> aVar2;
        if (t == com.airbnb.lottie.j.o) {
            this.f8617e.m(cVar);
            return;
        }
        if (t == com.airbnb.lottie.j.p) {
            this.f8619g.m(cVar);
            return;
        }
        if (t == com.airbnb.lottie.j.f8538h) {
            this.f8618f.m(cVar);
            return;
        }
        if (t == com.airbnb.lottie.j.q && (aVar2 = this.f8620h) != null) {
            aVar2.m(cVar);
            return;
        }
        if (t == com.airbnb.lottie.j.r) {
            this.f8621i.m(cVar);
            return;
        }
        if (t == com.airbnb.lottie.j.s && (aVar = this.f8622j) != null) {
            aVar.m(cVar);
        } else if (t == com.airbnb.lottie.j.t) {
            this.f8623k.m(cVar);
        }
    }
}
