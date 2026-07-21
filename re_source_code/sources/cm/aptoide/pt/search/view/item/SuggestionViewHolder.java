package cm.aptoide.pt.search.view.item;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.search.model.Suggestion;
import cm.aptoide.pt.search.suggestions.SearchQueryEvent;

/* JADX INFO: loaded from: classes.dex */
public class SuggestionViewHolder extends RecyclerView.c0 {
    private ImageView suggestionIcon;
    private TextView suggestionName;
    private rx.s.b<SearchQueryEvent> suggestionPublishSubject;

    public SuggestionViewHolder(View view, rx.s.b<SearchQueryEvent> bVar) {
        super(view);
        this.suggestionPublishSubject = bVar;
        this.suggestionName = (TextView) view.findViewById(R.id.search_suggestion_app_name);
        this.suggestionIcon = (ImageView) view.findViewById(R.id.search_suggestion_app_icon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setSuggestion$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(Suggestion suggestion, int i2, View view) {
        this.suggestionPublishSubject.onNext(new SearchQueryEvent(suggestion.getName(), i2, true, true));
    }

    public void setSuggestion(final Suggestion suggestion, final int i2) {
        this.suggestionName.setText(suggestion.getName().trim());
        if (suggestion.getIcon() != null) {
            this.suggestionIcon.setImageResource(R.drawable.ic_suggestions_trending);
        } else {
            this.suggestionIcon.setImageResource(R.drawable.ic_stat_aptoide_notification);
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.search.view.item.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7408f.a(suggestion, i2, view);
            }
        });
    }
}
