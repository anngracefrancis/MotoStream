package e.e.b.c.m;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: DrawableAlphaProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakHashMap<Drawable, Integer> f21054b;

    private e() {
        super(Integer.class, "drawableAlphaCompat");
        this.f21054b = new WeakHashMap<>();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.f21054b.containsKey(drawable)) {
            return this.f21054b.get(drawable);
        }
        return 255;
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(Drawable drawable, Integer num) {
        if (Build.VERSION.SDK_INT < 19) {
            this.f21054b.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }
}
