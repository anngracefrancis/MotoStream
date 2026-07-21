package cm.aptoide.pt.view;

import cm.aptoide.pt.AppCoinsManager;
import cm.aptoide.pt.editorialList.EditorialCardListRepository;
import cm.aptoide.pt.editorialList.EditorialListManager;
import cm.aptoide.pt.reactions.ReactionsManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesEditorialListManagerFactory implements Provider {
    private final Provider<AppCoinsManager> appCoinsManagerProvider;
    private final Provider<EditorialCardListRepository> editorialCardListRepositoryProvider;
    private final FragmentModule module;
    private final Provider<ReactionsManager> reactionsManagerProvider;

    public FragmentModule_ProvidesEditorialListManagerFactory(FragmentModule fragmentModule, Provider<EditorialCardListRepository> provider, Provider<ReactionsManager> provider2, Provider<AppCoinsManager> provider3) {
        this.module = fragmentModule;
        this.editorialCardListRepositoryProvider = provider;
        this.reactionsManagerProvider = provider2;
        this.appCoinsManagerProvider = provider3;
    }

    public static FragmentModule_ProvidesEditorialListManagerFactory create(FragmentModule fragmentModule, Provider<EditorialCardListRepository> provider, Provider<ReactionsManager> provider2, Provider<AppCoinsManager> provider3) {
        return new FragmentModule_ProvidesEditorialListManagerFactory(fragmentModule, provider, provider2, provider3);
    }

    public static EditorialListManager providesEditorialListManager(FragmentModule fragmentModule, EditorialCardListRepository editorialCardListRepository, ReactionsManager reactionsManager, AppCoinsManager appCoinsManager) {
        return (EditorialListManager) f.b.b.c(fragmentModule.providesEditorialListManager(editorialCardListRepository, reactionsManager, appCoinsManager));
    }

    @Override // javax.inject.Provider
    public EditorialListManager get() {
        return providesEditorialListManager(this.module, this.editorialCardListRepositoryProvider.get(), this.reactionsManagerProvider.get(), this.appCoinsManagerProvider.get());
    }
}
