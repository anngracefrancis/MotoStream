package c.a.o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;

/* JADX INFO: compiled from: ContextThemeWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends ContextWrapper {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Resources.Theme f2804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LayoutInflater f2805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Configuration f2806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Resources f2807e;

    public d() {
        super(null);
    }

    private Resources b() {
        if (this.f2807e == null) {
            Configuration configuration = this.f2806d;
            if (configuration == null) {
                this.f2807e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f2807e = createConfigurationContext(configuration).getResources();
            } else {
                Resources resources = super.getResources();
                Configuration configuration2 = new Configuration(resources.getConfiguration());
                configuration2.updateFrom(this.f2806d);
                this.f2807e = new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration2);
            }
        }
        return this.f2807e;
    }

    private void d() {
        boolean z = this.f2804b == null;
        if (z) {
            this.f2804b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f2804b.setTo(theme);
            }
        }
        e(this.f2804b, this.a, z);
    }

    public void a(Configuration configuration) {
        if (this.f2807e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f2806d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f2806d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.a;
    }

    protected void e(Resources.Theme theme, int i2, boolean z) {
        theme.applyStyle(i2, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f2805c == null) {
            this.f2805c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f2805c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f2804b;
        if (theme != null) {
            return theme;
        }
        if (this.a == 0) {
            this.a = c.a.i.f2755e;
        }
        d();
        return this.f2804b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        if (this.a != i2) {
            this.a = i2;
            d();
        }
    }

    public d(Context context, int i2) {
        super(context);
        this.a = i2;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f2804b = theme;
    }
}
