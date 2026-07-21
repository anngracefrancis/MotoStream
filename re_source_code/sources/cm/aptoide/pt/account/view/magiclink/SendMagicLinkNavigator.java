package cm.aptoide.pt.account.view.magiclink;

import android.content.Context;
import cm.aptoide.pt.R;
import cm.aptoide.pt.link.CustomTabsHelper;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.themes.ThemeManager;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SendMagicLinkNavigator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcm/aptoide/pt/account/view/magiclink/SendMagicLinkNavigator;", HttpUrl.FRAGMENT_ENCODE_SET, "fragmentNavigator", "Lcm/aptoide/pt/navigator/FragmentNavigator;", "context", "Landroid/content/Context;", "themeManager", "Lcm/aptoide/pt/themes/ThemeManager;", "(Lcm/aptoide/pt/navigator/FragmentNavigator;Landroid/content/Context;Lcm/aptoide/pt/themes/ThemeManager;)V", "getContext", "()Landroid/content/Context;", "getThemeManager", "()Lcm/aptoide/pt/themes/ThemeManager;", "navigateToBlog", HttpUrl.FRAGMENT_ENCODE_SET, "navigateToCheckYourEmail", "email", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SendMagicLinkNavigator {
    private final Context context;
    private final FragmentNavigator fragmentNavigator;
    private final ThemeManager themeManager;

    public SendMagicLinkNavigator(FragmentNavigator fragmentNavigator, Context context, ThemeManager themeManager) {
        kotlin.jvm.internal.m.f(fragmentNavigator, "fragmentNavigator");
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(themeManager, "themeManager");
        this.fragmentNavigator = fragmentNavigator;
        this.context = context;
        this.themeManager = themeManager;
    }

    public final Context getContext() {
        return this.context;
    }

    public final ThemeManager getThemeManager() {
        return this.themeManager;
    }

    public final void navigateToBlog() {
        CustomTabsHelper.getInstance().openInChromeCustomTab("https://blog.aptoide.com/aptoide-new-authentication-system-no-user-data-storage/", this.context, this.themeManager.getAttributeForTheme(R.attr.colorPrimary).resourceId);
    }

    public final void navigateToCheckYourEmail(String email) {
        kotlin.jvm.internal.m.f(email, "email");
        this.fragmentNavigator.navigateTo(CheckYourEmailFragment.INSTANCE.newInstance(email), true);
    }
}
