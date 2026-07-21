package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.u;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {
    private int a;

    class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f18825f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f18826g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ e.e.b.c.u.a f18827h;

        a(View view, int i2, e.e.b.c.u.a aVar) {
            this.f18825f = view;
            this.f18826g = i2;
            this.f18827h = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f18825f.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.a == this.f18826g) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                e.e.b.c.u.a aVar = this.f18827h;
                expandableBehavior.H((View) aVar, this.f18825f, aVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.a = 0;
    }

    private boolean F(boolean z) {
        if (!z) {
            return this.a == 1;
        }
        int i2 = this.a;
        return i2 == 0 || i2 == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected e.e.b.c.u.a G(CoordinatorLayout coordinatorLayout, View view) {
        List<View> listR = coordinatorLayout.r(view);
        int size = listR.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = listR.get(i2);
            if (e(coordinatorLayout, view, view2)) {
                return (e.e.b.c.u.a) view2;
            }
        }
        return null;
    }

    protected abstract boolean H(View view, View view2, boolean z, boolean z2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        e.e.b.c.u.a aVar = (e.e.b.c.u.a) view2;
        if (!F(aVar.a())) {
            return false;
        }
        this.a = aVar.a() ? 1 : 2;
        return H((View) aVar, view, aVar.a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i2) {
        e.e.b.c.u.a aVarG;
        if (u.O(view) || (aVarG = G(coordinatorLayout, view)) == null || !F(aVarG.a())) {
            return false;
        }
        int i3 = aVarG.a() ? 1 : 2;
        this.a = i3;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i3, aVarG));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
    }
}
