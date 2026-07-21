package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.t;
import androidx.core.view.u;
import androidx.core.widget.k;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: IndicatorViewController.java */
/* JADX INFO: loaded from: classes2.dex */
final class f {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextInputLayout f18801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinearLayout f18802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FrameLayout f18804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Animator f18806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f18807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18808i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f18809j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f18810k;
    private boolean l;
    private TextView m;
    private CharSequence n;
    private int o;
    private ColorStateList p;
    private CharSequence q;
    private boolean r;
    private TextView s;
    private int t;
    private ColorStateList u;
    private Typeface v;

    /* JADX INFO: compiled from: IndicatorViewController.java */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f18811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f18812c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f18813d;

        a(int i2, TextView textView, int i3, TextView textView2) {
            this.a = i2;
            this.f18811b = textView;
            this.f18812c = i3;
            this.f18813d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f18808i = this.a;
            f.this.f18806g = null;
            TextView textView = this.f18811b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f18812c == 1 && f.this.m != null) {
                    f.this.m.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f18813d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f18813d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f18813d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public f(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.a = context;
        this.f18801b = textInputLayout;
        this.f18807h = context.getResources().getDimensionPixelSize(e.e.b.c.d.p);
    }

    private void B(int i2, int i3) {
        TextView textViewL;
        TextView textViewL2;
        if (i2 == i3) {
            return;
        }
        if (i3 != 0 && (textViewL2 = l(i3)) != null) {
            textViewL2.setVisibility(0);
            textViewL2.setAlpha(1.0f);
        }
        if (i2 != 0 && (textViewL = l(i2)) != null) {
            textViewL.setVisibility(4);
            if (i2 == 1) {
                textViewL.setText((CharSequence) null);
            }
        }
        this.f18808i = i3;
    }

    private void J(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void L(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean M(TextView textView, CharSequence charSequence) {
        return u.O(this.f18801b) && this.f18801b.isEnabled() && !(this.f18809j == this.f18808i && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void P(int i2, int i3, boolean z) {
        if (i2 == i3) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f18806g = animatorSet;
            ArrayList arrayList = new ArrayList();
            h(arrayList, this.r, this.s, 2, i2, i3);
            h(arrayList, this.l, this.m, 1, i2, i3);
            e.e.b.c.m.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i3, l(i2), i2, l(i3)));
            animatorSet.start();
        } else {
            B(i2, i3);
        }
        this.f18801b.updateEditTextBackground();
        this.f18801b.updateLabelState(z);
        this.f18801b.updateTextInputBoxState();
    }

    private boolean f() {
        return (this.f18802c == null || this.f18801b.getEditText() == null) ? false : true;
    }

    private void h(List<Animator> list, boolean z, TextView textView, int i2, int i3, int i4) {
        if (textView == null || !z) {
            return;
        }
        if (i2 == i4 || i2 == i3) {
            list.add(i(textView, i4 == i2));
            if (i4 == i2) {
                list.add(j(textView));
            }
        }
    }

    private ObjectAnimator i(TextView textView, boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(167L);
        objectAnimatorOfFloat.setInterpolator(e.e.b.c.m.a.a);
        return objectAnimatorOfFloat;
    }

    private ObjectAnimator j(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f18807h, 0.0f);
        objectAnimatorOfFloat.setDuration(217L);
        objectAnimatorOfFloat.setInterpolator(e.e.b.c.m.a.f21052d);
        return objectAnimatorOfFloat;
    }

    private TextView l(int i2) {
        if (i2 == 1) {
            return this.m;
        }
        if (i2 != 2) {
            return null;
        }
        return this.s;
    }

    private boolean v(int i2) {
        return (i2 != 1 || this.m == null || TextUtils.isEmpty(this.f18810k)) ? false : true;
    }

    private boolean w(int i2) {
        return (i2 != 2 || this.s == null || TextUtils.isEmpty(this.q)) ? false : true;
    }

    void A(TextView textView, int i2) {
        FrameLayout frameLayout;
        if (this.f18802c == null) {
            return;
        }
        if (!x(i2) || (frameLayout = this.f18804e) == null) {
            this.f18802c.removeView(textView);
        } else {
            int i3 = this.f18805f - 1;
            this.f18805f = i3;
            L(frameLayout, i3);
            this.f18804e.removeView(textView);
        }
        int i4 = this.f18803d - 1;
        this.f18803d = i4;
        L(this.f18802c, i4);
    }

    void C(CharSequence charSequence) {
        this.n = charSequence;
        TextView textView = this.m;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    void D(boolean z) {
        if (this.l == z) {
            return;
        }
        g();
        if (z) {
            t tVar = new t(this.a);
            this.m = tVar;
            tVar.setId(e.e.b.c.f.E);
            if (Build.VERSION.SDK_INT >= 17) {
                this.m.setTextAlignment(5);
            }
            Typeface typeface = this.v;
            if (typeface != null) {
                this.m.setTypeface(typeface);
            }
            E(this.o);
            F(this.p);
            C(this.n);
            this.m.setVisibility(4);
            u.k0(this.m, 1);
            d(this.m, 0);
        } else {
            t();
            A(this.m, 0);
            this.m = null;
            this.f18801b.updateEditTextBackground();
            this.f18801b.updateTextInputBoxState();
        }
        this.l = z;
    }

    void E(int i2) {
        this.o = i2;
        TextView textView = this.m;
        if (textView != null) {
            this.f18801b.setTextAppearanceCompatWithErrorFallback(textView, i2);
        }
    }

    void F(ColorStateList colorStateList) {
        this.p = colorStateList;
        TextView textView = this.m;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void G(int i2) {
        this.t = i2;
        TextView textView = this.s;
        if (textView != null) {
            k.n(textView, i2);
        }
    }

    void H(boolean z) {
        if (this.r == z) {
            return;
        }
        g();
        if (z) {
            t tVar = new t(this.a);
            this.s = tVar;
            tVar.setId(e.e.b.c.f.F);
            if (Build.VERSION.SDK_INT >= 17) {
                this.s.setTextAlignment(5);
            }
            Typeface typeface = this.v;
            if (typeface != null) {
                this.s.setTypeface(typeface);
            }
            this.s.setVisibility(4);
            u.k0(this.s, 1);
            G(this.t);
            I(this.u);
            d(this.s, 1);
        } else {
            u();
            A(this.s, 1);
            this.s = null;
            this.f18801b.updateEditTextBackground();
            this.f18801b.updateTextInputBoxState();
        }
        this.r = z;
    }

    void I(ColorStateList colorStateList) {
        this.u = colorStateList;
        TextView textView = this.s;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void K(Typeface typeface) {
        if (typeface != this.v) {
            this.v = typeface;
            J(this.m, typeface);
            J(this.s, typeface);
        }
    }

    void N(CharSequence charSequence) {
        g();
        this.f18810k = charSequence;
        this.m.setText(charSequence);
        int i2 = this.f18808i;
        if (i2 != 1) {
            this.f18809j = 1;
        }
        P(i2, this.f18809j, M(this.m, charSequence));
    }

    void O(CharSequence charSequence) {
        g();
        this.q = charSequence;
        this.s.setText(charSequence);
        int i2 = this.f18808i;
        if (i2 != 2) {
            this.f18809j = 2;
        }
        P(i2, this.f18809j, M(this.s, charSequence));
    }

    void d(TextView textView, int i2) {
        if (this.f18802c == null && this.f18804e == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            this.f18802c = linearLayout;
            linearLayout.setOrientation(0);
            this.f18801b.addView(this.f18802c, -1, -2);
            this.f18804e = new FrameLayout(this.a);
            this.f18802c.addView(this.f18804e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f18801b.getEditText() != null) {
                e();
            }
        }
        if (x(i2)) {
            this.f18804e.setVisibility(0);
            this.f18804e.addView(textView);
            this.f18805f++;
        } else {
            this.f18802c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f18802c.setVisibility(0);
        this.f18803d++;
    }

    void e() {
        if (f()) {
            u.w0(this.f18802c, u.D(this.f18801b.getEditText()), 0, u.C(this.f18801b.getEditText()), 0);
        }
    }

    void g() {
        Animator animator = this.f18806g;
        if (animator != null) {
            animator.cancel();
        }
    }

    boolean k() {
        return v(this.f18809j);
    }

    CharSequence m() {
        return this.n;
    }

    CharSequence n() {
        return this.f18810k;
    }

    int o() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    ColorStateList p() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    CharSequence q() {
        return this.q;
    }

    int r() {
        TextView textView = this.s;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    boolean s() {
        return w(this.f18808i);
    }

    void t() {
        this.f18810k = null;
        g();
        if (this.f18808i == 1) {
            if (!this.r || TextUtils.isEmpty(this.q)) {
                this.f18809j = 0;
            } else {
                this.f18809j = 2;
            }
        }
        P(this.f18808i, this.f18809j, M(this.m, null));
    }

    void u() {
        g();
        int i2 = this.f18808i;
        if (i2 == 2) {
            this.f18809j = 0;
        }
        P(i2, this.f18809j, M(this.s, null));
    }

    boolean x(int i2) {
        return i2 == 0 || i2 == 1;
    }

    boolean y() {
        return this.l;
    }

    boolean z() {
        return this.r;
    }
}
