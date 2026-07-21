package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.x.m;
import c.x.s;
import java.util.Map;

/* JADX INFO: compiled from: TextScale.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends m {

    /* JADX INFO: compiled from: TextScale.java */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ TextView a;

        a(TextView textView) {
            this.a = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.a.setScaleX(fFloatValue);
            this.a.setScaleY(fFloatValue);
        }
    }

    private void k0(s sVar) {
        View view = sVar.f3608b;
        if (view instanceof TextView) {
            sVar.a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // c.x.m
    public void h(s sVar) {
        k0(sVar);
    }

    @Override // c.x.m
    public void k(s sVar) {
        k0(sVar);
    }

    @Override // c.x.m
    public Animator o(ViewGroup viewGroup, s sVar, s sVar2) {
        if (sVar == null || sVar2 == null || !(sVar.f3608b instanceof TextView)) {
            return null;
        }
        View view = sVar2.f3608b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        Map<String, Object> map = sVar.a;
        Map<String, Object> map2 = sVar2.a;
        float fFloatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        float fFloatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new a(textView));
        return valueAnimatorOfFloat;
    }
}
