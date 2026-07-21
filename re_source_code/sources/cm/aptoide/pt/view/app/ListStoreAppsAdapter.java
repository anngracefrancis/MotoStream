package cm.aptoide.pt.view.app;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class ListStoreAppsAdapter extends RecyclerView.g<ListStoreAppViewHolder> {
    private final rx.s.b<Application> appClicks;
    private List<Application> list;

    public ListStoreAppsAdapter(List<Application> list, rx.s.b<Application> bVar) {
        this.list = list;
        this.appClicks = bVar;
    }

    public void addApps(List<Application> list) {
        int loadingPosition = getLoadingPosition();
        if (loadingPosition >= 0) {
            this.list.addAll(loadingPosition, list);
        } else {
            loadingPosition = this.list.size();
            this.list.addAll(list);
        }
        notifyItemRangeInserted(loadingPosition, list.size());
    }

    public Application getItem(int i2) {
        return this.list.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        return this.list.get(i2) instanceof AppLoading ? R.layout.search_ad_loading_list_item : R.layout.displayable_grid_app;
    }

    public int getLoadingPosition() {
        for (int size = this.list.size() - 1; size >= 0; size--) {
            if (this.list.get(size) instanceof AppLoading) {
                return size;
            }
        }
        return -1;
    }

    public void hideLoading() {
        int loadingPosition = getLoadingPosition();
        if (loadingPosition >= 0) {
            this.list.remove(loadingPosition);
            notifyItemRemoved(loadingPosition);
        }
    }

    public void setApps(List<Application> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void showLoading() {
        if (getLoadingPosition() < 0) {
            this.list.add(new AppLoading());
            notifyItemInserted(this.list.size() - 1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(ListStoreAppViewHolder listStoreAppViewHolder, int i2) {
        listStoreAppViewHolder.setApp(this.list.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public ListStoreAppViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i2 == R.layout.search_ad_loading_list_item ? new AppLoadingViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_ad_loading_list_item, viewGroup, false)) : new ApplicationViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.displayable_grid_app, viewGroup, false), this.appClicks);
    }
}
