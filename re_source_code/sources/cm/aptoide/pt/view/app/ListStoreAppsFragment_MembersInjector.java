package cm.aptoide.pt.view.app;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ListStoreAppsFragment_MembersInjector implements f.a<ListStoreAppsFragment> {
    private final Provider<AppCenter> appCenterProvider;
    private final Provider<ListStoreAppsNavigator> listStoreAppsNavigatorProvider;

    public ListStoreAppsFragment_MembersInjector(Provider<ListStoreAppsNavigator> provider, Provider<AppCenter> provider2) {
        this.listStoreAppsNavigatorProvider = provider;
        this.appCenterProvider = provider2;
    }

    public static f.a<ListStoreAppsFragment> create(Provider<ListStoreAppsNavigator> provider, Provider<AppCenter> provider2) {
        return new ListStoreAppsFragment_MembersInjector(provider, provider2);
    }

    public static void injectAppCenter(ListStoreAppsFragment listStoreAppsFragment, AppCenter appCenter) {
        listStoreAppsFragment.appCenter = appCenter;
    }

    public static void injectListStoreAppsNavigator(ListStoreAppsFragment listStoreAppsFragment, ListStoreAppsNavigator listStoreAppsNavigator) {
        listStoreAppsFragment.listStoreAppsNavigator = listStoreAppsNavigator;
    }

    public void injectMembers(ListStoreAppsFragment listStoreAppsFragment) {
        injectListStoreAppsNavigator(listStoreAppsFragment, this.listStoreAppsNavigatorProvider.get());
        injectAppCenter(listStoreAppsFragment, this.appCenterProvider.get());
    }
}
