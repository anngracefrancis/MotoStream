package cm.aptoide.pt;

import cm.aptoide.pt.search.suggestions.SearchSuggestionRemoteRepository;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesSearchSuggestionRemoteRepositoryFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ApplicationModule_ProvidesSearchSuggestionRemoteRepositoryFactory(ApplicationModule applicationModule, Provider<Retrofit> provider) {
        this.module = applicationModule;
        this.retrofitProvider = provider;
    }

    public static ApplicationModule_ProvidesSearchSuggestionRemoteRepositoryFactory create(ApplicationModule applicationModule, Provider<Retrofit> provider) {
        return new ApplicationModule_ProvidesSearchSuggestionRemoteRepositoryFactory(applicationModule, provider);
    }

    public static SearchSuggestionRemoteRepository providesSearchSuggestionRemoteRepository(ApplicationModule applicationModule, Retrofit retrofit) {
        return (SearchSuggestionRemoteRepository) f.b.b.c(applicationModule.providesSearchSuggestionRemoteRepository(retrofit));
    }

    @Override // javax.inject.Provider
    public SearchSuggestionRemoteRepository get() {
        return providesSearchSuggestionRemoteRepository(this.module, this.retrofitProvider.get());
    }
}
