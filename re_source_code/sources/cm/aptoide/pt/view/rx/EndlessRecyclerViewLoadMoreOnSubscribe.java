package cm.aptoide.pt.view.rx;

import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.view.recycler.BaseAdapter;
import cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener;
import rx.j;

/* JADX INFO: loaded from: classes.dex */
public class EndlessRecyclerViewLoadMoreOnSubscribe implements rx.e.a<Integer> {
    private final BaseAdapter adapter;
    private final RecyclerView recyclerView;

    public EndlessRecyclerViewLoadMoreOnSubscribe(RecyclerView recyclerView, BaseAdapter baseAdapter) {
        this.recyclerView = recyclerView;
        this.adapter = baseAdapter;
    }

    @Override // rx.m.b
    public void call(final j<? super Integer> jVar) {
        rx.l.a.verifyMainThread();
        final EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener(this.adapter) { // from class: cm.aptoide.pt.view.rx.EndlessRecyclerViewLoadMoreOnSubscribe.1
            @Override // cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener
            protected boolean hasMoreElements() {
                return true;
            }

            @Override // cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener
            public void onLoadMore(boolean z, boolean z2) {
                if (jVar.isUnsubscribed()) {
                    return;
                }
                jVar.onNext(Integer.valueOf(getAdapter().getItemCount()));
            }
        };
        this.recyclerView.addOnScrollListener(endlessRecyclerOnScrollListener);
        jVar.add(new rx.l.a() { // from class: cm.aptoide.pt.view.rx.EndlessRecyclerViewLoadMoreOnSubscribe.2
            @Override // rx.l.a
            protected void onUnsubscribe() {
                EndlessRecyclerViewLoadMoreOnSubscribe.this.recyclerView.removeOnScrollListener(endlessRecyclerOnScrollListener);
            }
        });
    }
}
