package cm.aptoide.pt.store.view;

import android.os.Bundle;
import cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse;
import cm.aptoide.pt.dataprovider.ws.v7.Endless;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class GetStoreEndlessFragment<T extends BaseV7EndlessResponse> extends StoreTabWidgetsGridRecyclerFragment {
    protected EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener;
    private V7<T, ? extends Endless> v7request;

    private void setupEndless(V7<T, ? extends Endless> v7, rx.m.b<T> bVar, boolean z) {
        getRecyclerView().clearOnScrollListeners();
        EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = this.endlessRecyclerOnScrollListener;
        if (endlessRecyclerOnScrollListener != null) {
            endlessRecyclerOnScrollListener.stopLoading();
        }
        this.endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener(getAdapter(), v7, bVar, getErrorRequestListener());
        getRecyclerView().addOnScrollListener(this.endlessRecyclerOnScrollListener);
        this.endlessRecyclerOnScrollListener.onLoadMore(z, z);
    }

    protected abstract rx.m.b<T> buildAction();

    @Override // cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment
    protected rx.e<List<Displayable>> buildDisplayables(boolean z, String str, boolean z2) {
        V7<T, ? extends Endless> v7BuildRequest = buildRequest(z, str);
        this.v7request = v7BuildRequest;
        setupEndless(v7BuildRequest, buildAction(), z);
        return null;
    }

    protected abstract V7<T, ? extends Endless> buildRequest(boolean z, String str);

    protected ErrorRequestListener getErrorRequestListener() {
        return new ErrorRequestListener() { // from class: cm.aptoide.pt.store.view.b0
            @Override // cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener
            public final void onError(Throwable th) {
                this.a.finishLoading(th);
            }
        };
    }

    @Override // cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment, cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.LoadInterface
    public void load(boolean z, boolean z2, Bundle bundle) {
        super.load(z, z2, bundle);
        if (z) {
            return;
        }
        setupEndless(this.v7request, buildAction(), z2);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = this.endlessRecyclerOnScrollListener;
        if (endlessRecyclerOnScrollListener != null) {
            endlessRecyclerOnScrollListener.stopLoading();
            this.endlessRecyclerOnScrollListener = null;
        }
        super.onDestroyView();
    }
}
