package cm.aptoide.pt.search.suggestions;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public interface SearchSuggestionRemoteRepository {
    @GET("suggestion/app/{query}")
    Single<Suggestions> getSuggestionForApp(@Path("query") String str);

    @GET("suggestion/store/{query}")
    Single<Suggestions> getSuggestionForStore(@Path("query") String str);
}
