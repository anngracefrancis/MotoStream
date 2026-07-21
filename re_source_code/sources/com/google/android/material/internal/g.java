package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: StaticLayoutBuilderCompat.java */
/* JADX INFO: loaded from: classes2.dex */
final class g {
    private static boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Constructor<StaticLayout> f18704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Object f18705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CharSequence f18706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextPaint f18707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f18708f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f18710h;
    private boolean l;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18709g = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Layout.Alignment f18711i = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f18712j = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f18713k = true;
    private TextUtils.TruncateAt m = null;

    /* JADX INFO: compiled from: StaticLayoutBuilderCompat.java */
    static class a extends Exception {
        a(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    private g(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.f18706d = charSequence;
        this.f18707e = textPaint;
        this.f18708f = i2;
        this.f18710h = charSequence.length();
    }

    private void b() throws a {
        Class<?> cls;
        if (a) {
            return;
        }
        try {
            boolean z = this.l && Build.VERSION.SDK_INT >= 23;
            if (Build.VERSION.SDK_INT >= 18) {
                cls = TextDirectionHeuristic.class;
                f18705c = z ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            } else {
                ClassLoader classLoader = g.class.getClassLoader();
                String str = this.l ? "RTL" : "LTR";
                Class<?> clsLoadClass = classLoader.loadClass("android.text.TextDirectionHeuristic");
                Class<?> clsLoadClass2 = classLoader.loadClass("android.text.TextDirectionHeuristics");
                f18705c = clsLoadClass2.getField(str).get(clsLoadClass2);
                cls = clsLoadClass;
            }
            Class cls2 = Integer.TYPE;
            Class cls3 = Float.TYPE;
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls2, cls2, TextPaint.class, cls2, Layout.Alignment.class, cls, cls3, cls3, Boolean.TYPE, TextUtils.TruncateAt.class, cls2, cls2);
            f18704b = declaredConstructor;
            declaredConstructor.setAccessible(true);
            a = true;
        } catch (Exception e2) {
            throw new a(e2);
        }
    }

    public static g c(CharSequence charSequence, TextPaint textPaint, int i2) {
        return new g(charSequence, textPaint, i2);
    }

    public StaticLayout a() throws a {
        if (this.f18706d == null) {
            this.f18706d = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        int iMax = Math.max(0, this.f18708f);
        CharSequence charSequenceEllipsize = this.f18706d;
        if (this.f18712j == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f18707e, iMax, this.m);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f18710h);
        this.f18710h = iMin;
        if (Build.VERSION.SDK_INT < 23) {
            b();
            try {
                return (StaticLayout) ((Constructor) c.i.j.i.c(f18704b)).newInstance(charSequenceEllipsize, Integer.valueOf(this.f18709g), Integer.valueOf(this.f18710h), this.f18707e, Integer.valueOf(iMax), this.f18711i, c.i.j.i.c(f18705c), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f18713k), null, Integer.valueOf(iMax), Integer.valueOf(this.f18712j));
            } catch (Exception e2) {
                throw new a(e2);
            }
        }
        if (this.l) {
            this.f18711i = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.f18709g, iMin, this.f18707e, iMax);
        builderObtain.setAlignment(this.f18711i);
        builderObtain.setIncludePad(this.f18713k);
        builderObtain.setTextDirection(this.l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.m;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f18712j);
        return builderObtain.build();
    }

    public g d(Layout.Alignment alignment) {
        this.f18711i = alignment;
        return this;
    }

    public g e(TextUtils.TruncateAt truncateAt) {
        this.m = truncateAt;
        return this;
    }

    public g f(boolean z) {
        this.f18713k = z;
        return this;
    }

    public g g(boolean z) {
        this.l = z;
        return this;
    }

    public g h(int i2) {
        this.f18712j = i2;
        return this;
    }
}
