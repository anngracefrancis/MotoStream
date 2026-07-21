package cm.aptoide.pt.search.suggestions;

import cm.aptoide.pt.dataprovider.model.v7.ListApps;
import cm.aptoide.pt.dataprovider.model.v7.listapp.App;
import cm.aptoide.pt.search.model.Suggestion;
import java.util.List;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class TrendingManager {
    private static final int SUGGESTION_COUNT = 10;
    private static final int SUGGESTION_STORE_ID = 15;
    private final TrendingService trendingService;

    public TrendingManager(TrendingService trendingService) {
        this.trendingService = trendingService;
    }

    static /* synthetic */ Iterable lambda$getTrendingCursorSuggestions$4(List list) {
        return list;
    }

    static /* synthetic */ Iterable lambda$getTrendingListSuggestions$1(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: mapToSuggestion, reason: merged with bridge method [inline-methods] */
    public Suggestion a(App app) {
        return new Suggestion(app.getName(), app.getIcon());
    }

    public Single<List<String>> getTrendingCursorSuggestions() {
        return this.trendingService.getTrendingApps(10, 15).X(new rx.m.e() { // from class: cm.aptoide.pt.search.suggestions.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((ListApps) obj).getDataList().getList();
            }
        }).J(new rx.m.e() { // from class: cm.aptoide.pt.search.suggestions.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                TrendingManager.lambda$getTrendingCursorSuggestions$4(list);
                return list;
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.search.suggestions.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((App) obj).getName();
            }
        }).Y0().E().Z0();
    }

    public Single<List<Suggestion>> getTrendingListSuggestions() {
        return this.trendingService.getTrendingApps(10, 15).X(new rx.m.e() { // from class: cm.aptoide.pt.search.suggestions.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((ListApps) obj).getDataList().getList();
            }
        }).J(new rx.m.e() { // from class: cm.aptoide.pt.search.suggestions.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                TrendingManager.lambda$getTrendingListSuggestions$1(list);
                return list;
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.search.suggestions.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7311f.a((App) obj);
            }
        }).Y0().E().Z0();
    }
}
