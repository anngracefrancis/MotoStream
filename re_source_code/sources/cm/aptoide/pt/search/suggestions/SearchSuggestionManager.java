package cm.aptoide.pt.search.suggestions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class SearchSuggestionManager {
    private final rx.h ioScheduler;
    private final SearchSuggestionService service;
    private final int timeout;
    private final TimeUnit timeoutTimeUnit;

    public SearchSuggestionManager(SearchSuggestionService searchSuggestionService, rx.h hVar) {
        this.service = searchSuggestionService;
        this.ioScheduler = hVar;
        this.timeout = 10;
        this.timeoutTimeUnit = TimeUnit.SECONDS;
    }

    public Single<List<String>> getSuggestionsForApp(String str) {
        return this.service.getAppSuggestionsForQuery(str).w(this.timeout, this.timeoutTimeUnit).v(this.ioScheduler);
    }

    public Single<List<String>> getSuggestionsForStore(String str) {
        return this.service.getStoreSuggestionsForQuery(str).w(this.timeout, this.timeoutTimeUnit).v(this.ioScheduler);
    }

    public SearchSuggestionManager(SearchSuggestionService searchSuggestionService, int i2, TimeUnit timeUnit, rx.h hVar) {
        this.service = searchSuggestionService;
        this.ioScheduler = hVar;
        this.timeout = i2;
        this.timeoutTimeUnit = timeUnit;
    }
}
