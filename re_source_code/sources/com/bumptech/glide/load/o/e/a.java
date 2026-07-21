package com.bumptech.glide.load.o.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: DrawableDecoderCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static volatile boolean a = true;

    public static Drawable a(Context context, int i2, Resources.Theme theme) {
        return c(context, context, i2, theme);
    }

    public static Drawable b(Context context, Context context2, int i2) {
        return c(context, context2, i2, null);
    }

    private static Drawable c(Context context, Context context2, int i2, Resources.Theme theme) {
        try {
            if (a) {
                return e(context2, i2, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e2) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e2;
            }
            return androidx.core.content.a.f(context2, i2);
        } catch (NoClassDefFoundError unused2) {
            a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i2, theme);
    }

    private static Drawable d(Context context, int i2, Resources.Theme theme) {
        return androidx.core.content.d.f.d(context.getResources(), i2, theme);
    }

    private static Drawable e(Context context, int i2, Resources.Theme theme) {
        if (theme != null) {
            context = new c.a.o.d(context, theme);
        }
        return c.a.k.a.a.d(context, i2);
    }
}
