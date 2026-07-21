package cm.aptoide.pt.home.more.apps;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ListAppsMoreFragment_MembersInjector implements f.a<ListAppsMoreFragment> {
    private final Provider<ListAppsMorePresenter> presenterProvider;

    public ListAppsMoreFragment_MembersInjector(Provider<ListAppsMorePresenter> provider) {
        this.presenterProvider = provider;
    }

    public static f.a<ListAppsMoreFragment> create(Provider<ListAppsMorePresenter> provider) {
        return new ListAppsMoreFragment_MembersInjector(provider);
    }

    public static void injectPresenter(ListAppsMoreFragment listAppsMoreFragment, ListAppsMorePresenter listAppsMorePresenter) {
        listAppsMoreFragment.presenter = listAppsMorePresenter;
    }

    public void injectMembers(ListAppsMoreFragment listAppsMoreFragment) {
        injectPresenter(listAppsMoreFragment, this.presenterProvider.get());
    }
}
