package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonCreator;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.dynamic.RemoteCreator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11642f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11643g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f11644h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View.OnClickListener f11645i;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    public final void a(int i2, int i3) {
        this.f11642f = i2;
        this.f11643g = i3;
        Context context = getContext();
        View view = this.f11644h;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f11644h = SignInButtonCreator.c(context, this.f11642f, this.f11643g);
        } catch (RemoteCreator.RemoteCreatorException unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i4 = this.f11642f;
            int i5 = this.f11643g;
            SignInButtonImpl signInButtonImpl = new SignInButtonImpl(context);
            signInButtonImpl.a(context.getResources(), i4, i5);
            this.f11644h = signInButtonImpl;
        }
        addView(this.f11644h);
        this.f11644h.setEnabled(isEnabled());
        this.f11644h.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.f11645i;
        if (onClickListener == null || view != this.f11644h) {
            return;
        }
        onClickListener.onClick(this);
    }

    public final void setColorScheme(int i2) {
        a(this.f11642f, i2);
    }

    @Override // android.view.View
    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f11644h.setEnabled(z);
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f11645i = onClickListener;
        View view = this.f11644h;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public final void setScopes(Scope[] scopeArr) {
        a(this.f11642f, this.f11643g);
    }

    public final void setSize(int i2) {
        a(i2, this.f11643g);
    }
}
