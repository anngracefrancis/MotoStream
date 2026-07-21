package cm.aptoide.pt.view.rx;

import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.view.recycler.BaseAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class RxEndlessRecyclerView {
    private RxEndlessRecyclerView() {
        new AssertionError("No instances!");
    }

    public static rx.e<Integer> loadMore(RecyclerView recyclerView, BaseAdapter baseAdapter) {
        return rx.e.l(new EndlessRecyclerViewLoadMoreOnSubscribe(recyclerView, baseAdapter));
    }
}
