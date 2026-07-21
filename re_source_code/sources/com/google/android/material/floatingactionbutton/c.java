package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import c.i.j.i;
import e.e.b.c.a0.g;
import e.e.b.c.a0.k;
import java.util.ArrayList;

/* JADX INFO: compiled from: FloatingActionButtonImplLollipop.java */
/* JADX INFO: loaded from: classes2.dex */
class c extends b {

    /* JADX INFO: compiled from: FloatingActionButtonImplLollipop.java */
    static class a extends g {
        a(k kVar) {
            super(kVar);
        }

        @Override // e.e.b.c.a0.g, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    c(FloatingActionButton floatingActionButton, e.e.b.c.z.b bVar) {
        super(floatingActionButton, bVar);
    }

    private Animator j0(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.F, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(b.a);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void A() {
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void C() {
        f0();
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void E(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (!this.F.isEnabled()) {
                this.F.setElevation(0.0f);
                this.F.setTranslationZ(0.0f);
                return;
            }
            this.F.setElevation(this.o);
            if (this.F.isPressed()) {
                this.F.setTranslationZ(this.q);
            } else if (this.F.isFocused() || this.F.isHovered()) {
                this.F.setTranslationZ(this.p);
            } else {
                this.F.setTranslationZ(0.0f);
            }
        }
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void F(float f2, float f3, float f4) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 21) {
            this.F.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(b.f18652b, j0(f2, f4));
            stateListAnimator.addState(b.f18653c, j0(f2, f3));
            stateListAnimator.addState(b.f18654d, j0(f2, f3));
            stateListAnimator.addState(b.f18655e, j0(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.F, "elevation", f2).setDuration(0L));
            if (i2 >= 22 && i2 <= 24) {
                FloatingActionButton floatingActionButton = this.F;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(b.a);
            stateListAnimator.addState(b.f18656f, animatorSet);
            stateListAnimator.addState(b.f18657g, j0(0.0f, 0.0f));
            this.F.setStateListAnimator(stateListAnimator);
        }
        if (Z()) {
            f0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.b
    boolean K() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void V(ColorStateList colorStateList) {
        Drawable drawable = this.f18660j;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(e.e.b.c.y.b.d(colorStateList));
        } else {
            super.V(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.b
    boolean Z() {
        return this.G.c() || !b0();
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void d0() {
    }

    com.google.android.material.floatingactionbutton.a i0(int i2, ColorStateList colorStateList) {
        Context context = this.F.getContext();
        com.google.android.material.floatingactionbutton.a aVar = new com.google.android.material.floatingactionbutton.a((k) i.c(this.f18658h));
        aVar.e(androidx.core.content.a.d(context, e.e.b.c.c.f20977f), androidx.core.content.a.d(context, e.e.b.c.c.f20976e), androidx.core.content.a.d(context, e.e.b.c.c.f20974c), androidx.core.content.a.d(context, e.e.b.c.c.f20975d));
        aVar.d(i2);
        aVar.c(colorStateList);
        return aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    g j() {
        return new a((k) i.c(this.f18658h));
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public float n() {
        return this.F.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void s(Rect rect) {
        if (this.G.c()) {
            super.s(rect);
        } else if (b0()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.r - this.F.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void x(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable layerDrawable;
        g gVarJ = j();
        this.f18659i = gVarJ;
        gVarJ.setTintList(colorStateList);
        if (mode != null) {
            this.f18659i.setTintMode(mode);
        }
        this.f18659i.N(this.F.getContext());
        if (i2 > 0) {
            this.f18661k = i0(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{(Drawable) i.c(this.f18661k), (Drawable) i.c(this.f18659i)});
        } else {
            this.f18661k = null;
            layerDrawable = this.f18659i;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(e.e.b.c.y.b.d(colorStateList2), layerDrawable, null);
        this.f18660j = rippleDrawable;
        this.l = rippleDrawable;
    }
}
