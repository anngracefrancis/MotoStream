package c.a.o;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
import c.a.j;

/* JADX INFO: compiled from: ActionBarPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private Context a;

    private a(Context context) {
        this.a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public boolean a() {
        return this.a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.a.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600) {
            return 5;
        }
        if (i2 > 960 && i3 > 720) {
            return 5;
        }
        if (i2 > 720 && i3 > 960) {
            return 5;
        }
        if (i2 >= 500) {
            return 4;
        }
        if (i2 > 640 && i3 > 480) {
            return 4;
        }
        if (i2 <= 480 || i3 <= 640) {
            return i2 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public int e() {
        return this.a.getResources().getDimensionPixelSize(c.a.d.f2702b);
    }

    public int f() {
        TypedArray typedArrayObtainStyledAttributes = this.a.obtainStyledAttributes(null, j.a, c.a.a.f2686c, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(j.f2764j, 0);
        Resources resources = this.a.getResources();
        if (!g()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(c.a.d.a));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean g() {
        return this.a.getResources().getBoolean(c.a.b.a);
    }

    public boolean h() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.a).hasPermanentMenuKey();
    }
}
