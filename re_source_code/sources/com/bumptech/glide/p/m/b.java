package com.bumptech.glide.p.m;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

/* JADX INFO: compiled from: DrawableCrossFadeTransition.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements d<Drawable> {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f9535b;

    public b(int i2, boolean z) {
        this.a = i2;
        this.f9535b = z;
    }

    @Override // com.bumptech.glide.p.m.d
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(Drawable drawable, d.a aVar) {
        Drawable drawableB = aVar.b();
        if (drawableB == null) {
            drawableB = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawableB, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f9535b);
        transitionDrawable.startTransition(this.a);
        aVar.a(transitionDrawable);
        return true;
    }
}
