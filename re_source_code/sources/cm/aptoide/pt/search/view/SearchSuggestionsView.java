package cm.aptoide.pt.search.view;

import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.search.model.Suggestion;
import cm.aptoide.pt.search.suggestions.SearchQueryEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface SearchSuggestionsView extends View {
    void collapseSearchBar(boolean z);

    void focusInSearchBar();

    String getCurrentQuery();

    rx.e<SearchQueryEvent> onQueryTextChanged();

    void setSuggestionsList(List<String> list);

    void setTrendingCursor(List<String> list);

    void setTrendingList(List<Suggestion> list);
}
