package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: ScrollbarHelper.java */
/* JADX INFO: loaded from: classes.dex */
class p {
    static int a(RecyclerView.z zVar, n nVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.getChildCount() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(oVar.getPosition(view) - oVar.getPosition(view2)) + 1;
        }
        return Math.min(nVar.n(), nVar.d(view2) - nVar.g(view));
    }

    static int b(RecyclerView.z zVar, n nVar, View view, View view2, RecyclerView.o oVar, boolean z, boolean z2) {
        if (oVar.getChildCount() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (zVar.b() - Math.max(oVar.getPosition(view), oVar.getPosition(view2))) - 1) : Math.max(0, Math.min(oVar.getPosition(view), oVar.getPosition(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(nVar.d(view2) - nVar.g(view)) / (Math.abs(oVar.getPosition(view) - oVar.getPosition(view2)) + 1))) + (nVar.m() - nVar.g(view)));
        }
        return iMax;
    }

    static int c(RecyclerView.z zVar, n nVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.getChildCount() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return zVar.b();
        }
        return (int) (((nVar.d(view2) - nVar.g(view)) / (Math.abs(oVar.getPosition(view) - oVar.getPosition(view2)) + 1)) * zVar.b());
    }
}
