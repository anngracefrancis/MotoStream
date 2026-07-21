package cm.aptoide.pt.updates.view.excluded;

import cm.aptoide.pt.updates.UpdatePersistence;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ExcludedUpdatesFragment_MembersInjector implements f.a<ExcludedUpdatesFragment> {
    private final Provider<UpdatePersistence> updatesPersistenceProvider;

    public ExcludedUpdatesFragment_MembersInjector(Provider<UpdatePersistence> provider) {
        this.updatesPersistenceProvider = provider;
    }

    public static f.a<ExcludedUpdatesFragment> create(Provider<UpdatePersistence> provider) {
        return new ExcludedUpdatesFragment_MembersInjector(provider);
    }

    public static void injectUpdatesPersistence(ExcludedUpdatesFragment excludedUpdatesFragment, UpdatePersistence updatePersistence) {
        excludedUpdatesFragment.updatesPersistence = updatePersistence;
    }

    public void injectMembers(ExcludedUpdatesFragment excludedUpdatesFragment) {
        injectUpdatesPersistence(excludedUpdatesFragment, this.updatesPersistenceProvider.get());
    }
}
