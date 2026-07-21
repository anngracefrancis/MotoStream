package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: VectorEnabledTintResources.java */
/* JADX INFO: loaded from: classes.dex */
public class v0 extends Resources {
    private static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference<Context> f664b;

    public v0(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f664b = new WeakReference<>(context);
    }

    public static boolean a() {
        return a;
    }

    public static boolean b() {
        return a() && Build.VERSION.SDK_INT <= 20;
    }

    final Drawable c(int i2) {
        return super.getDrawable(i2);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        Context context = this.f664b.get();
        return context != null ? g0.h().t(context, this, i2) : super.getDrawable(i2);
    }
}
