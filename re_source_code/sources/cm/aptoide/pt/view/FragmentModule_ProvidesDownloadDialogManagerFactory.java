package cm.aptoide.pt.view;

import cm.aptoide.pt.download.view.DownloadDialogProvider;
import cm.aptoide.pt.themes.ThemeManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesDownloadDialogManagerFactory implements Provider {
    private final FragmentModule module;
    private final Provider<ThemeManager> themeManagerProvider;

    public FragmentModule_ProvidesDownloadDialogManagerFactory(FragmentModule fragmentModule, Provider<ThemeManager> provider) {
        this.module = fragmentModule;
        this.themeManagerProvider = provider;
    }

    public static FragmentModule_ProvidesDownloadDialogManagerFactory create(FragmentModule fragmentModule, Provider<ThemeManager> provider) {
        return new FragmentModule_ProvidesDownloadDialogManagerFactory(fragmentModule, provider);
    }

    public static DownloadDialogProvider providesDownloadDialogManager(FragmentModule fragmentModule, ThemeManager themeManager) {
        return (DownloadDialogProvider) f.b.b.c(fragmentModule.providesDownloadDialogManager(themeManager));
    }

    @Override // javax.inject.Provider
    public DownloadDialogProvider get() {
        return providesDownloadDialogManager(this.module, this.themeManagerProvider.get());
    }
}
