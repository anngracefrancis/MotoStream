package cm.aptoide.pt.editorialList;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.bonus.BonusAppcModel;
import cm.aptoide.pt.editorial.CaptionBackgroundPainter;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.home.bundles.editorial.EditorialBundleViewHolder;
import cm.aptoide.pt.home.bundles.editorial.EditorialViewHolder;
import cm.aptoide.pt.themes.ThemeManager;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class EditorialListAdapter extends RecyclerView.g<EditorialViewHolder> {
    private static final int EDITORIAL_CARD = 2131493005;
    private static final int LOADING = 2131493141;
    private BonusAppcModel bonusAppcModel;
    private final CaptionBackgroundPainter captionBackgroundPainter;
    private List<CurationCard> editorialListItems;
    private final ProgressCard progressBundle;
    private final ThemeManager themeAttributeProvider;
    private final rx.s.b<HomeEvent> uiEventsListener;

    public EditorialListAdapter(List<CurationCard> list, ProgressCard progressCard, rx.s.b<HomeEvent> bVar, CaptionBackgroundPainter captionBackgroundPainter, ThemeManager themeManager) {
        this.editorialListItems = list;
        this.progressBundle = progressCard;
        this.uiEventsListener = bVar;
        this.captionBackgroundPainter = captionBackgroundPainter;
        this.themeAttributeProvider = themeManager;
    }

    public void add(List<CurationCard> list, BonusAppcModel bonusAppcModel) {
        int size = this.editorialListItems.size();
        this.editorialListItems.addAll(list);
        this.bonusAppcModel = bonusAppcModel;
        notifyItemRangeInserted(size, list.size());
    }

    public void addLoadMore() {
        if (getLoadingPosition() < 0) {
            this.editorialListItems.add(this.progressBundle);
            notifyItemInserted(this.editorialListItems.size() - 1);
        }
    }

    public CurationCard getCard(int i2) {
        return this.editorialListItems.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.editorialListItems.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        return this.editorialListItems.get(i2) instanceof ProgressCard ? R.layout.progress_item : R.layout.editorial_action_item;
    }

    public synchronized int getLoadingPosition() {
        for (int size = this.editorialListItems.size() - 1; size >= 0; size--) {
            if (this.editorialListItems.get(size) instanceof ProgressCard) {
                return size;
            }
        }
        return -1;
    }

    public void removeLoadMore() {
        int loadingPosition = getLoadingPosition();
        if (loadingPosition >= 0) {
            this.editorialListItems.remove(loadingPosition);
            notifyItemRemoved(loadingPosition);
        }
    }

    public void update(List<CurationCard> list) {
        this.editorialListItems = list;
        notifyDataSetChanged();
    }

    public void updateEditorialCard(CurationCard curationCard) {
        for (int i2 = 0; i2 < this.editorialListItems.size(); i2++) {
            if (curationCard != null && this.editorialListItems.get(i2).getId().equals(curationCard.getId())) {
                this.editorialListItems.set(i2, curationCard);
                notifyItemChanged(i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(EditorialViewHolder editorialViewHolder, int i2) {
        if (editorialViewHolder instanceof EditorialBundleViewHolder) {
            ((EditorialBundleViewHolder) editorialViewHolder).setEditorialCard(this.editorialListItems.get(i2), i2, this.bonusAppcModel);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public EditorialViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i2 == R.layout.editorial_action_item ? new EditorialBundleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.editorial_action_item, viewGroup, false), this.uiEventsListener, this.captionBackgroundPainter, this.themeAttributeProvider) : new LoadingViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.progress_item, viewGroup, false), this.uiEventsListener, this.captionBackgroundPainter);
    }
}
