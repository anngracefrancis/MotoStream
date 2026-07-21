package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.u;
import e.e.b.c.a0.g;
import e.e.b.c.a0.h;
import e.e.b.c.k;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialToolbar extends Toolbar {
    private static final int U = k.x;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.e.b.c.b.K);
    }

    private void P(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            g gVar = new g();
            gVar.X(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            gVar.N(context);
            gVar.W(u.t(this));
            u.m0(this, gVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        h.d(this, f2);
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, U), attributeSet, i2);
        P(getContext());
    }
}
