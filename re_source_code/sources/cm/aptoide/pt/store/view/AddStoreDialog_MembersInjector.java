package cm.aptoide.pt.store.view;

import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.fragment.BaseDialogFragment_MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class AddStoreDialog_MembersInjector implements f.a<AddStoreDialog> {
    private final Provider<StoreCredentialsProvider> storeCredentialsProvider;
    private final Provider<StoreUtilsProxy> storeUtilsProxyProvider;
    private final Provider<ThemeManager> themeManagerProvider;

    public AddStoreDialog_MembersInjector(Provider<ThemeManager> provider, Provider<StoreCredentialsProvider> provider2, Provider<StoreUtilsProxy> provider3) {
        this.themeManagerProvider = provider;
        this.storeCredentialsProvider = provider2;
        this.storeUtilsProxyProvider = provider3;
    }

    public static f.a<AddStoreDialog> create(Provider<ThemeManager> provider, Provider<StoreCredentialsProvider> provider2, Provider<StoreUtilsProxy> provider3) {
        return new AddStoreDialog_MembersInjector(provider, provider2, provider3);
    }

    public static void injectStoreCredentialsProvider(AddStoreDialog addStoreDialog, StoreCredentialsProvider storeCredentialsProvider) {
        addStoreDialog.storeCredentialsProvider = storeCredentialsProvider;
    }

    public static void injectStoreUtilsProxy(AddStoreDialog addStoreDialog, StoreUtilsProxy storeUtilsProxy) {
        addStoreDialog.storeUtilsProxy = storeUtilsProxy;
    }

    public void injectMembers(AddStoreDialog addStoreDialog) {
        BaseDialogFragment_MembersInjector.injectThemeManager(addStoreDialog, this.themeManagerProvider.get());
        injectStoreCredentialsProvider(addStoreDialog, this.storeCredentialsProvider.get());
        injectStoreUtilsProxy(addStoreDialog, this.storeUtilsProxyProvider.get());
    }
}
