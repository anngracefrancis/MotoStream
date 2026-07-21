package cm.aptoide.pt.view;

import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.store.view.my.MyStoresNavigator;
import cm.aptoide.pt.store.view.my.MyStoresPresenter;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesMyStorePresenterFactory implements Provider {
    private final Provider<AptoideAccountManager> aptoideAccountManagerProvider;
    private final FragmentModule module;
    private final Provider<MyStoresNavigator> navigatorProvider;

    public FragmentModule_ProvidesMyStorePresenterFactory(FragmentModule fragmentModule, Provider<AptoideAccountManager> provider, Provider<MyStoresNavigator> provider2) {
        this.module = fragmentModule;
        this.aptoideAccountManagerProvider = provider;
        this.navigatorProvider = provider2;
    }

    public static FragmentModule_ProvidesMyStorePresenterFactory create(FragmentModule fragmentModule, Provider<AptoideAccountManager> provider, Provider<MyStoresNavigator> provider2) {
        return new FragmentModule_ProvidesMyStorePresenterFactory(fragmentModule, provider, provider2);
    }

    public static MyStoresPresenter providesMyStorePresenter(FragmentModule fragmentModule, AptoideAccountManager aptoideAccountManager, MyStoresNavigator myStoresNavigator) {
        return (MyStoresPresenter) f.b.b.c(fragmentModule.providesMyStorePresenter(aptoideAccountManager, myStoresNavigator));
    }

    @Override // javax.inject.Provider
    public MyStoresPresenter get() {
        return providesMyStorePresenter(this.module, this.aptoideAccountManagerProvider.get(), this.navigatorProvider.get());
    }
}
