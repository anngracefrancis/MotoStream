package cm.aptoide.pt.store.view;

import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.fragment.BaseDialogFragment_MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class PrivateStoreDialog_MembersInjector implements f.a<PrivateStoreDialog> {
    private final Provider<StoreUtilsProxy> storeUtilsProxyProvider;
    private final Provider<ThemeManager> themeManagerProvider;

    public PrivateStoreDialog_MembersInjector(Provider<ThemeManager> provider, Provider<StoreUtilsProxy> provider2) {
        this.themeManagerProvider = provider;
        this.storeUtilsProxyProvider = provider2;
    }

    public static f.a<PrivateStoreDialog> create(Provider<ThemeManager> provider, Provider<StoreUtilsProxy> provider2) {
        return new PrivateStoreDialog_MembersInjector(provider, provider2);
    }

    public static void injectStoreUtilsProxy(PrivateStoreDialog privateStoreDialog, StoreUtilsProxy storeUtilsProxy) {
        privateStoreDialog.storeUtilsProxy = storeUtilsProxy;
    }

    public void injectMembers(PrivateStoreDialog privateStoreDialog) {
        BaseDialogFragment_MembersInjector.injectThemeManager(privateStoreDialog, this.themeManagerProvider.get());
        injectStoreUtilsProxy(privateStoreDialog, this.storeUtilsProxyProvider.get());
    }
}
