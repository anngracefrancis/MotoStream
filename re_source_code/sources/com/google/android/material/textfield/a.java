package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import e.e.b.c.j;

/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends com.google.android.material.textfield.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextWatcher f18774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final View.OnFocusChangeListener f18775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextInputLayout.f f18776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextInputLayout.g f18777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AnimatorSet f18778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ValueAnimator f18779i;

    /* JADX INFO: renamed from: com.google.android.material.textfield.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class C0202a implements TextWatcher {
        C0202a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.a.getSuffixText() != null) {
                return;
            }
            a.this.i(a.l(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            a.this.i((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z);
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class c implements TextInputLayout.f {
        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(a.l(editText.getText()));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.this.f18775e);
            editText.removeTextChangedListener(a.this.f18774d);
            editText.addTextChangedListener(a.this.f18774d);
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class d implements TextInputLayout.g {
        d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i2 != 2) {
                return;
            }
            editText.removeTextChangedListener(a.this.f18774d);
            if (editText.getOnFocusChangeListener() == a.this.f18775e) {
                editText.setOnFocusChangeListener(null);
            }
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = a.this.a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.a.setEndIconVisible(true);
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.a.setEndIconVisible(false);
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f18800c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f18800c.setScaleX(fFloatValue);
            a.this.f18800c.setScaleY(fFloatValue);
        }
    }

    a(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f18774d = new C0202a();
        this.f18775e = new b();
        this.f18776f = new c();
        this.f18777g = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z) {
        boolean z2 = this.a.isEndIconVisible() == z;
        if (z) {
            this.f18779i.cancel();
            this.f18778h.start();
            if (z2) {
                this.f18778h.end();
                return;
            }
            return;
        }
        this.f18778h.cancel();
        this.f18779i.start();
        if (z2) {
            this.f18779i.end();
        }
    }

    private ValueAnimator j(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(e.e.b.c.m.a.a);
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.addUpdateListener(new h());
        return valueAnimatorOfFloat;
    }

    private ValueAnimator k() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(e.e.b.c.m.a.f21052d);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new i());
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(Editable editable) {
        return editable.length() > 0;
    }

    private void m() {
        ValueAnimator valueAnimatorK = k();
        ValueAnimator valueAnimatorJ = j(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f18778h = animatorSet;
        animatorSet.playTogether(valueAnimatorK, valueAnimatorJ);
        this.f18778h.addListener(new f());
        ValueAnimator valueAnimatorJ2 = j(1.0f, 0.0f);
        this.f18779i = valueAnimatorJ2;
        valueAnimatorJ2.addListener(new g());
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        this.a.setEndIconDrawable(c.a.k.a.a.d(this.f18799b, e.e.b.c.e.f20997g));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(j.f21022d));
        this.a.setEndIconOnClickListener(new e());
        this.a.addOnEditTextAttachedListener(this.f18776f);
        this.a.addOnEndIconChangedListener(this.f18777g);
        m();
    }

    @Override // com.google.android.material.textfield.e
    void c(boolean z) {
        if (this.a.getSuffixText() == null) {
            return;
        }
        i(z);
    }
}
