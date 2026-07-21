package cm.aptoide.pt.search.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.search.model.Suggestion;
import cm.aptoide.pt.search.suggestions.SearchQueryEvent;
import cm.aptoide.pt.search.view.item.SuggestionViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SearchSuggestionsAdapter extends RecyclerView.g<SuggestionViewHolder> {
    private List<Suggestion> suggestions;
    private rx.s.b<SearchQueryEvent> suggestionsPublishSubject;

    public SearchSuggestionsAdapter(List<Suggestion> list, rx.s.b<SearchQueryEvent> bVar) {
        this.suggestions = list;
        this.suggestionsPublishSubject = bVar;
    }

    public void addSuggestions(List<Suggestion> list) {
        this.suggestions = list;
        notifyDataSetChanged();
    }

    public void addSuggestionsFromString(List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Suggestion(it.next(), null));
        }
        this.suggestions = arrayList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.suggestions.size();
    }

    public List<Suggestion> getSuggestions() {
        return this.suggestions;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(SuggestionViewHolder suggestionViewHolder, int i2) {
        suggestionViewHolder.setSuggestion(this.suggestions.get(i2), i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public SuggestionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new SuggestionViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_suggestion_item, viewGroup, false), this.suggestionsPublishSubject);
    }
}
