package com.airbnb.lottie.q.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ContentGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements d, l, com.airbnb.lottie.q.b.a.InterfaceC0118a, com.airbnb.lottie.s.f {
    private final Matrix a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f8577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RectF f8578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<b> f8580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.f f8581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<l> f8582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.airbnb.lottie.q.b.o f8583h;

    public c(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar, com.airbnb.lottie.s.j.n nVar) {
        this(fVar, aVar, nVar.c(), e(fVar, aVar, nVar.b()), i(nVar.b()));
    }

    private static List<b> e(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar, List<com.airbnb.lottie.s.j.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVarA = list.get(i2).a(fVar, aVar);
            if (bVarA != null) {
                arrayList.add(bVarA);
            }
        }
        return arrayList;
    }

    static com.airbnb.lottie.s.i.l i(List<com.airbnb.lottie.s.j.b> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.airbnb.lottie.s.j.b bVar = list.get(i2);
            if (bVar instanceof com.airbnb.lottie.s.i.l) {
                return (com.airbnb.lottie.s.i.l) bVar;
            }
        }
        return null;
    }

    @Override // com.airbnb.lottie.q.b.a.InterfaceC0118a
    public void a() {
        this.f8581f.invalidateSelf();
    }

    @Override // com.airbnb.lottie.q.a.b
    public void b(List<b> list, List<b> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f8580e.size());
        arrayList.addAll(list);
        for (int size = this.f8580e.size() - 1; size >= 0; size--) {
            b bVar = this.f8580e.get(size);
            bVar.b(arrayList, this.f8580e.subList(0, size));
            arrayList.add(bVar);
        }
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
                int iE = i2 + eVar.e(getName(), i2);
                for (int i3 = 0; i3 < this.f8580e.size(); i3++) {
                    b bVar = this.f8580e.get(i3);
                    if (bVar instanceof com.airbnb.lottie.s.f) {
                        ((com.airbnb.lottie.s.f) bVar).c(eVar, iE, list, eVar2);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.q.a.d
    public void d(RectF rectF, Matrix matrix) {
        this.a.set(matrix);
        com.airbnb.lottie.q.b.o oVar = this.f8583h;
        if (oVar != null) {
            this.a.preConcat(oVar.e());
        }
        this.f8578c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f8580e.size() - 1; size >= 0; size--) {
            b bVar = this.f8580e.get(size);
            if (bVar instanceof d) {
                ((d) bVar).d(this.f8578c, this.a);
                if (rectF.isEmpty()) {
                    rectF.set(this.f8578c);
                } else {
                    rectF.set(Math.min(rectF.left, this.f8578c.left), Math.min(rectF.top, this.f8578c.top), Math.max(rectF.right, this.f8578c.right), Math.max(rectF.bottom, this.f8578c.bottom));
                }
            }
        }
    }

    @Override // com.airbnb.lottie.q.a.d
    public void f(Canvas canvas, Matrix matrix, int i2) {
        this.a.set(matrix);
        com.airbnb.lottie.q.b.o oVar = this.f8583h;
        if (oVar != null) {
            this.a.preConcat(oVar.e());
            i2 = (int) ((((this.f8583h.g().h().intValue() / 100.0f) * i2) / 255.0f) * 255.0f);
        }
        for (int size = this.f8580e.size() - 1; size >= 0; size--) {
            b bVar = this.f8580e.get(size);
            if (bVar instanceof d) {
                ((d) bVar).f(canvas, this.a, i2);
            }
        }
    }

    @Override // com.airbnb.lottie.q.a.l
    public Path g() {
        this.a.reset();
        com.airbnb.lottie.q.b.o oVar = this.f8583h;
        if (oVar != null) {
            this.a.set(oVar.e());
        }
        this.f8577b.reset();
        for (int size = this.f8580e.size() - 1; size >= 0; size--) {
            b bVar = this.f8580e.get(size);
            if (bVar instanceof l) {
                this.f8577b.addPath(((l) bVar).g(), this.a);
            }
        }
        return this.f8577b;
    }

    @Override // com.airbnb.lottie.q.a.b
    public String getName() {
        return this.f8579d;
    }

    @Override // com.airbnb.lottie.s.f
    public <T> void h(T t, com.airbnb.lottie.w.c<T> cVar) {
        com.airbnb.lottie.q.b.o oVar = this.f8583h;
        if (oVar != null) {
            oVar.c(t, cVar);
        }
    }

    List<l> j() {
        if (this.f8582g == null) {
            this.f8582g = new ArrayList();
            for (int i2 = 0; i2 < this.f8580e.size(); i2++) {
                b bVar = this.f8580e.get(i2);
                if (bVar instanceof l) {
                    this.f8582g.add((l) bVar);
                }
            }
        }
        return this.f8582g;
    }

    Matrix k() {
        com.airbnb.lottie.q.b.o oVar = this.f8583h;
        if (oVar != null) {
            return oVar.e();
        }
        this.a.reset();
        return this.a;
    }

    c(com.airbnb.lottie.f fVar, com.airbnb.lottie.s.k.a aVar, String str, List<b> list, com.airbnb.lottie.s.i.l lVar) {
        this.a = new Matrix();
        this.f8577b = new Path();
        this.f8578c = new RectF();
        this.f8579d = str;
        this.f8581f = fVar;
        this.f8580e = list;
        if (lVar != null) {
            com.airbnb.lottie.q.b.o oVarB = lVar.b();
            this.f8583h = oVarB;
            oVarB.a(aVar);
            this.f8583h.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            b bVar = list.get(size);
            if (bVar instanceof i) {
                arrayList.add((i) bVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((i) arrayList.get(size2)).e(list.listIterator(list.size()));
        }
    }
}
