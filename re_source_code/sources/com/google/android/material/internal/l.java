package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: compiled from: VisibilityAwareImageButton.java */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"AppCompatCustomView"})
public class l extends ImageButton {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18725f;

    public l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void b(int i2, boolean z) {
        super.setVisibility(i2);
        if (z) {
            this.f18725f = i2;
        }
    }

    public final int getUserSetVisibility() {
        return this.f18725f;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i2) {
        b(i2, true);
    }

    public l(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18725f = getVisibility();
    }
}
