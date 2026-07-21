package com.google.android.material.internal;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.c0;
import androidx.core.view.p;
import androidx.core.view.u;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: compiled from: ViewUtils.java */
    static class a implements p {
        final /* synthetic */ c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f18721b;

        a(c cVar, d dVar) {
            this.a = cVar;
            this.f18721b = dVar;
        }

        @Override // androidx.core.view.p
        public c0 a(View view, c0 c0Var) {
            return this.a.a(view, c0Var, new d(this.f18721b));
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    static class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            u.f0(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    public interface c {
        c0 a(View view, c0 c0Var, d dVar);
    }

    public static void a(View view, c cVar) {
        u.v0(view, new a(cVar, new d(u.D(view), view.getPaddingTop(), u.C(view), view.getPaddingBottom())));
        f(view);
    }

    public static float b(Context context, int i2) {
        return TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
    }

    public static float c(View view) {
        float fT = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fT += u.t((View) parent);
        }
        return fT;
    }

    public static boolean d(View view) {
        return u.y(view) == 1;
    }

    public static PorterDuff.Mode e(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void f(View view) {
        if (u.N(view)) {
            u.f0(view);
        } else {
            view.addOnAttachStateChangeListener(new b());
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    public static class d {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f18722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f18723c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f18724d;

        public d(int i2, int i3, int i4, int i5) {
            this.a = i2;
            this.f18722b = i3;
            this.f18723c = i4;
            this.f18724d = i5;
        }

        public void a(View view) {
            u.w0(view, this.a, this.f18722b, this.f18723c, this.f18724d);
        }

        public d(d dVar) {
            this.a = dVar.a;
            this.f18722b = dVar.f18722b;
            this.f18723c = dVar.f18723c;
            this.f18724d = dVar.f18724d;
        }
    }
}
