package cm.aptoide.pt.autoupdate;

import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.fragment.BaseDialogFragment_MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class AutoUpdateDialogFragment_MembersInjector implements f.a<AutoUpdateDialogFragment> {
    private final Provider<AutoUpdateDialogPresenter> presenterProvider;
    private final Provider<ThemeManager> themeManagerProvider;

    public AutoUpdateDialogFragment_MembersInjector(Provider<ThemeManager> provider, Provider<AutoUpdateDialogPresenter> provider2) {
        this.themeManagerProvider = provider;
        this.presenterProvider = provider2;
    }

    public static f.a<AutoUpdateDialogFragment> create(Provider<ThemeManager> provider, Provider<AutoUpdateDialogPresenter> provider2) {
        return new AutoUpdateDialogFragment_MembersInjector(provider, provider2);
    }

    public static void injectPresenter(AutoUpdateDialogFragment autoUpdateDialogFragment, AutoUpdateDialogPresenter autoUpdateDialogPresenter) {
        autoUpdateDialogFragment.presenter = autoUpdateDialogPresenter;
    }

    public void injectMembers(AutoUpdateDialogFragment autoUpdateDialogFragment) {
        BaseDialogFragment_MembersInjector.injectThemeManager(autoUpdateDialogFragment, this.themeManagerProvider.get());
        injectPresenter(autoUpdateDialogFragment, this.presenterProvider.get());
    }
}
