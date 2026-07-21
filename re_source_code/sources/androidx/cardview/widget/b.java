package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: compiled from: CardViewApi21Impl.java */
/* JADX INFO: loaded from: classes.dex */
class b implements e {
    b() {
    }

    private f p(d dVar) {
        return (f) dVar.f();
    }

    @Override // androidx.cardview.widget.e
    public void a(d dVar, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        dVar.c(new f(colorStateList, f2));
        View viewG = dVar.g();
        viewG.setClipToOutline(true);
        viewG.setElevation(f3);
        o(dVar, f4);
    }

    @Override // androidx.cardview.widget.e
    public void b(d dVar, float f2) {
        p(dVar).h(f2);
    }

    @Override // androidx.cardview.widget.e
    public float c(d dVar) {
        return dVar.g().getElevation();
    }

    @Override // androidx.cardview.widget.e
    public float d(d dVar) {
        return p(dVar).d();
    }

    @Override // androidx.cardview.widget.e
    public void e(d dVar) {
        o(dVar, g(dVar));
    }

    @Override // androidx.cardview.widget.e
    public void f(d dVar, float f2) {
        dVar.g().setElevation(f2);
    }

    @Override // androidx.cardview.widget.e
    public float g(d dVar) {
        return p(dVar).c();
    }

    @Override // androidx.cardview.widget.e
    public ColorStateList h(d dVar) {
        return p(dVar).b();
    }

    @Override // androidx.cardview.widget.e
    public void i(d dVar) {
        if (!dVar.e()) {
            dVar.a(0, 0, 0, 0);
            return;
        }
        float fG = g(dVar);
        float fD = d(dVar);
        int iCeil = (int) Math.ceil(g.c(fG, fD, dVar.d()));
        int iCeil2 = (int) Math.ceil(g.d(fG, fD, dVar.d()));
        dVar.a(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // androidx.cardview.widget.e
    public void j() {
    }

    @Override // androidx.cardview.widget.e
    public float k(d dVar) {
        return d(dVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.e
    public float l(d dVar) {
        return d(dVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.e
    public void m(d dVar) {
        o(dVar, g(dVar));
    }

    @Override // androidx.cardview.widget.e
    public void n(d dVar, ColorStateList colorStateList) {
        p(dVar).f(colorStateList);
    }

    @Override // androidx.cardview.widget.e
    public void o(d dVar, float f2) {
        p(dVar).g(f2, dVar.e(), dVar.d());
        i(dVar);
    }
}
