package cm.aptoide.pt.navigator;

import android.content.Context;
import cm.aptoide.pt.R;
import cm.aptoide.pt.link.CustomTabsHelper;
import cm.aptoide.pt.themes.ThemeManager;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ExternalNavigator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcm/aptoide/pt/navigator/ExternalNavigator;", HttpUrl.FRAGMENT_ENCODE_SET, "context", "Landroid/content/Context;", "themeManager", "Lcm/aptoide/pt/themes/ThemeManager;", "(Landroid/content/Context;Lcm/aptoide/pt/themes/ThemeManager;)V", "getContext", "()Landroid/content/Context;", "getThemeManager", "()Lcm/aptoide/pt/themes/ThemeManager;", "navigateToExternalWebsite", HttpUrl.FRAGMENT_ENCODE_SET, "url", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ExternalNavigator {
    private final Context context;
    private final ThemeManager themeManager;

    public ExternalNavigator(Context context, ThemeManager themeManager) {
        m.f(context, "context");
        m.f(themeManager, "themeManager");
        this.context = context;
        this.themeManager = themeManager;
    }

    public final Context getContext() {
        return this.context;
    }

    public final ThemeManager getThemeManager() {
        return this.themeManager;
    }

    public final void navigateToExternalWebsite(String url) {
        m.f(url, "url");
        CustomTabsHelper.getInstance().openInChromeCustomTab(url, this.context, this.themeManager.getAttributeForTheme(R.attr.colorPrimary).resourceId);
    }
}
