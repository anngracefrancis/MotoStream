package cm.aptoide.pt.search.suggestions;

import java.util.List;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class SearchSuggestionService {
    private final SearchSuggestionRemoteRepository repository;

    public SearchSuggestionService(SearchSuggestionRemoteRepository searchSuggestionRemoteRepository) {
        this.repository = searchSuggestionRemoteRepository;
    }

    public Single<List<String>> getAppSuggestionsForQuery(String str) {
        return this.repository.getSuggestionForApp(str).n(new rx.m.e() { // from class: cm.aptoide.pt.search.suggestions.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((Suggestions) obj).getData();
            }
        });
    }

    public Single<List<String>> getStoreSuggestionsForQuery(String str) {
        return this.repository.getSuggestionForStore(str).n(new rx.m.e() { // from class: cm.aptoide.pt.search.suggestions.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((Suggestions) obj).getData();
            }
        });
    }
}
