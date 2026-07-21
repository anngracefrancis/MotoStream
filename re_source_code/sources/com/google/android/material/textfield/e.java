package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: EndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class e {
    TextInputLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Context f18799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    CheckableImageButton f18800c;

    e(TextInputLayout textInputLayout) {
        this.a = textInputLayout;
        this.f18799b = textInputLayout.getContext();
        this.f18800c = textInputLayout.getEndIconView();
    }

    abstract void a();

    boolean b(int i2) {
        return true;
    }

    void c(boolean z) {
    }

    boolean d() {
        return false;
    }
}
