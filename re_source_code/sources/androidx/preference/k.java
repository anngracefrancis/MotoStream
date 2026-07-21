package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: PreferenceRecyclerViewAccessibilityDelegate.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class k extends androidx.recyclerview.widget.o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final RecyclerView f1858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final androidx.core.view.a f1859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final androidx.core.view.a f1860h;

    /* JADX INFO: compiled from: PreferenceRecyclerViewAccessibilityDelegate.java */
    class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.d0.c cVar) {
            Preference preferenceJ;
            k.this.f1859g.g(view, cVar);
            int childAdapterPosition = k.this.f1858f.getChildAdapterPosition(view);
            RecyclerView.g adapter = k.this.f1858f.getAdapter();
            if ((adapter instanceof h) && (preferenceJ = ((h) adapter).j(childAdapterPosition)) != null) {
                preferenceJ.p0(cVar);
            }
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i2, Bundle bundle) {
            return k.this.f1859g.j(view, i2, bundle);
        }
    }

    public k(RecyclerView recyclerView) {
        super(recyclerView);
        this.f1859g = super.n();
        this.f1860h = new a();
        this.f1858f = recyclerView;
    }

    @Override // androidx.recyclerview.widget.o
    public androidx.core.view.a n() {
        return this.f1860h;
    }
}
