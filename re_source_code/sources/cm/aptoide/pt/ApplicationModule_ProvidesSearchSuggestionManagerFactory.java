package cm.aptoide.pt;

import cm.aptoide.pt.search.suggestions.SearchSuggestionManager;
import cm.aptoide.pt.search.suggestions.SearchSuggestionRemoteRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesSearchSuggestionManagerFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<SearchSuggestionRemoteRepository> remoteRepositoryProvider;

    public ApplicationModule_ProvidesSearchSuggestionManagerFactory(ApplicationModule applicationModule, Provider<SearchSuggestionRemoteRepository> provider) {
        this.module = applicationModule;
        this.remoteRepositoryProvider = provider;
    }

    public static ApplicationModule_ProvidesSearchSuggestionManagerFactory create(ApplicationModule applicationModule, Provider<SearchSuggestionRemoteRepository> provider) {
        return new ApplicationModule_ProvidesSearchSuggestionManagerFactory(applicationModule, provider);
    }

    public static SearchSuggestionManager providesSearchSuggestionManager(ApplicationModule applicationModule, SearchSuggestionRemoteRepository searchSuggestionRemoteRepository) {
        return (SearchSuggestionManager) f.b.b.c(applicationModule.providesSearchSuggestionManager(searchSuggestionRemoteRepository));
    }

    @Override // javax.inject.Provider
    public SearchSuggestionManager get() {
        return providesSearchSuggestionManager(this.module, this.remoteRepositoryProvider.get());
    }
}
