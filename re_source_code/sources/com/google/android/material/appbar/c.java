package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: ViewOffsetBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
class c<V extends View> extends CoordinatorLayout.c<V> {
    private d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f18400c;

    public c() {
        this.f18399b = 0;
        this.f18400c = 0;
    }

    public int E() {
        d dVar = this.a;
        if (dVar != null) {
            return dVar.c();
        }
        return 0;
    }

    protected void F(CoordinatorLayout coordinatorLayout, V v, int i2) {
        coordinatorLayout.I(v, i2);
    }

    public boolean G(int i2) {
        d dVar = this.a;
        if (dVar != null) {
            return dVar.f(i2);
        }
        this.f18399b = i2;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i2) {
        F(coordinatorLayout, v, i2);
        if (this.a == null) {
            this.a = new d(v);
        }
        this.a.d();
        this.a.a();
        int i3 = this.f18399b;
        if (i3 != 0) {
            this.a.f(i3);
            this.f18399b = 0;
        }
        int i4 = this.f18400c;
        if (i4 == 0) {
            return true;
        }
        this.a.e(i4);
        this.f18400c = 0;
        return true;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18399b = 0;
        this.f18400c = 0;
    }
}
