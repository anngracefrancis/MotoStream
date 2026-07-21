package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: TintResources.java */
/* JADX INFO: loaded from: classes.dex */
class p0 extends h0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference<Context> f598b;

    public p0(Context context, Resources resources) {
        super(resources);
        this.f598b = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.h0, android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i2);
        Context context = this.f598b.get();
        if (drawable != null && context != null) {
            g0.h().x(context, i2, drawable);
        }
        return drawable;
    }
}
