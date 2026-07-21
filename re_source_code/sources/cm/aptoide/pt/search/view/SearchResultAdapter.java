package cm.aptoide.pt.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.app.view.screenshots.ScreenShotClickEvent;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.download.view.DownloadClick;
import cm.aptoide.pt.search.SearchItemDiffCallback;
import cm.aptoide.pt.search.model.SearchAppResult;
import cm.aptoide.pt.search.model.SearchAppResultWrapper;
import cm.aptoide.pt.search.model.SearchItem;
import cm.aptoide.pt.search.model.SearchLoadingItem;
import cm.aptoide.pt.search.view.item.SearchLoadingViewHolder;
import cm.aptoide.pt.search.view.item.SearchResultItemView;
import cm.aptoide.pt.search.view.item.SearchResultViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SearchResultAdapter extends DiffUtilAdapter<SearchItem, SearchResultItemView> {
    private CrashReport crashReport;
    private final rx.s.b<DownloadClick> downloadClickPublishSubject;
    private final rx.s.b<SearchAppResultWrapper> onItemViewClick;
    private String query;
    private final rx.s.b<ScreenShotClickEvent> screenShotClick;
    private List<SearchItem> searchResults;

    /* JADX INFO: renamed from: cm.aptoide.pt.search.view.SearchResultAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$search$model$SearchItem$Type;

        static {
            int[] iArr = new int[SearchItem.Type.values().length];
            $SwitchMap$cm$aptoide$pt$search$model$SearchItem$Type = iArr;
            try {
                iArr[SearchItem.Type.APP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$search$model$SearchItem$Type[SearchItem.Type.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public SearchResultAdapter(rx.s.b<SearchAppResultWrapper> bVar, rx.s.b<DownloadClick> bVar2, rx.s.b<ScreenShotClickEvent> bVar3, List<SearchItem> list, CrashReport crashReport) {
        this.onItemViewClick = bVar;
        this.searchResults = list;
        this.crashReport = crashReport;
        this.downloadClickPublishSubject = bVar2;
        this.screenShotClick = bVar3;
    }

    private boolean hasLoadingItem() {
        Iterator<SearchItem> it = this.searchResults.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof SearchLoadingItem) {
                return true;
            }
        }
        return false;
    }

    public void addResultForSearch(String str, List<SearchAppResult> list, boolean z) {
        this.query = str;
        ArrayList arrayList = new ArrayList(list);
        applyDiffUtil(new DiffUtilAdapter.DiffRequest(arrayList, new SearchItemDiffCallback(new ArrayList(this.searchResults), arrayList)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cm.aptoide.pt.search.view.DiffUtilAdapter
    public void dispatchUpdates(List<? extends SearchItem> list, androidx.recyclerview.widget.f.c cVar) {
        this.searchResults = list;
        cVar.e(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.searchResults.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        return AnonymousClass1.$SwitchMap$cm$aptoide$pt$search$model$SearchItem$Type[this.searchResults.get(i2).getType().ordinal()] != 1 ? R.layout.search_ad_loading_list_item : R.layout.search_app_row;
    }

    public void setMoreLoading() {
        if (hasLoadingItem()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.searchResults);
        arrayList.add(new SearchLoadingItem());
        applyDiffUtil(new DiffUtilAdapter.DiffRequest(arrayList, new SearchItemDiffCallback(new ArrayList(this.searchResults), arrayList)));
    }

    public void setResultForSearch(RecyclerView recyclerView, String str, List<SearchAppResult> list, boolean z) {
        this.query = str;
        this.searchResults = new ArrayList(list);
        recyclerView.getRecycledViewPool().b();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.c0 c0Var, int i2, List list) {
        onBindViewHolder((SearchResultItemView) c0Var, i2, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public SearchResultItemView onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
        return i2 != R.layout.search_app_row ? new SearchLoadingViewHolder(viewInflate) : new SearchResultViewHolder(viewInflate, this.onItemViewClick, this.downloadClickPublishSubject, this.screenShotClick, this.query);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(SearchResultItemView searchResultItemView, int i2) {
        try {
            searchResultItemView.setup(this.searchResults.get(i2));
        } catch (ClassCastException e2) {
            this.crashReport.log(e2);
        }
    }

    public void onBindViewHolder(SearchResultItemView searchResultItemView, int i2, List<Object> list) {
        if ((searchResultItemView instanceof SearchResultViewHolder) && !list.isEmpty()) {
            ((SearchResultViewHolder) searchResultItemView).setDownloadStatus((SearchAppResult) list.get(0));
        } else {
            super.onBindViewHolder(searchResultItemView, i2, list);
        }
    }
}
