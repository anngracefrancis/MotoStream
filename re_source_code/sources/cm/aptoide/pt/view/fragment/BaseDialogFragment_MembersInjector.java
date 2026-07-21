package cm.aptoide.pt.view.fragment;

import cm.aptoide.pt.themes.ThemeManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class BaseDialogFragment_MembersInjector implements f.a<BaseDialogFragment> {
    private final Provider<ThemeManager> themeManagerProvider;

    public BaseDialogFragment_MembersInjector(Provider<ThemeManager> provider) {
        this.themeManagerProvider = provider;
    }

    public static f.a<BaseDialogFragment> create(Provider<ThemeManager> provider) {
        return new BaseDialogFragment_MembersInjector(provider);
    }

    public static void injectThemeManager(BaseDialogFragment baseDialogFragment, ThemeManager themeManager) {
        baseDialogFragment.themeManager = themeManager;
    }

    public void injectMembers(BaseDialogFragment baseDialogFragment) {
        injectThemeManager(baseDialogFragment, this.themeManagerProvider.get());
    }
}
