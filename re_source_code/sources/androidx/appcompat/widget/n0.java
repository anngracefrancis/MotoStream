package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: TintContextWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class n0 extends ContextWrapper {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ArrayList<WeakReference<n0>> f589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Resources f590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Resources.Theme f591d;

    private n0(Context context) {
        super(context);
        if (!v0.b()) {
            this.f590c = new p0(this, context.getResources());
            this.f591d = null;
            return;
        }
        v0 v0Var = new v0(this, context.getResources());
        this.f590c = v0Var;
        Resources.Theme themeNewTheme = v0Var.newTheme();
        this.f591d = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    private static boolean a(Context context) {
        if ((context instanceof n0) || (context.getResources() instanceof p0) || (context.getResources() instanceof v0)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || v0.b();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (a) {
            ArrayList<WeakReference<n0>> arrayList = f589b;
            if (arrayList == null) {
                f589b = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference<n0> weakReference = f589b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f589b.remove(size);
                    }
                }
                for (int size2 = f589b.size() - 1; size2 >= 0; size2--) {
                    WeakReference<n0> weakReference2 = f589b.get(size2);
                    n0 n0Var = weakReference2 != null ? weakReference2.get() : null;
                    if (n0Var != null && n0Var.getBaseContext() == context) {
                        return n0Var;
                    }
                }
            }
            n0 n0Var2 = new n0(context);
            f589b.add(new WeakReference<>(n0Var2));
            return n0Var2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f590c.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f590c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f591d;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        Resources.Theme theme = this.f591d;
        if (theme == null) {
            super.setTheme(i2);
        } else {
            theme.applyStyle(i2, true);
        }
    }
}
