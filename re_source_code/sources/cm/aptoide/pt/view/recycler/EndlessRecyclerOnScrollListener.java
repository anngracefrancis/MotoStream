package cm.aptoide.pt.view.recycler;

import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.ws.v7.Endless;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.view.recycler.displayable.ProgressBarDisplayable;
import java.util.LinkedList;
import java.util.List;
import rx.k;

/* JADX INFO: loaded from: classes.dex */
public class EndlessRecyclerOnScrollListener extends RecyclerView.t {
    private final BaseAdapter adapter;
    private final boolean bypassCache;
    private final boolean bypassServerCache;
    private boolean endCallbackCalled;
    private final ErrorRequestListener errorRequestListener;
    private boolean firstCallbackCalled;
    private int firstVisibleItem;
    private int lastTotal;
    private boolean loading;
    private final MultiLangPatch multiLangPatch;
    private int offset;
    private rx.m.a onEndOfListReachedListener;
    private final List<OnEndlessFinish> onEndlessFinishList;
    private BooleanAction onFirstLoadListener;
    private RecyclerViewPositionHelper recyclerViewPositionHelper;
    private boolean stableData;
    private k subscription;
    private rx.m.b successRequestListener;
    private int total;
    private int totalItemCount;
    private V7<? extends BaseV7EndlessResponse, ? extends Endless> v7request;
    private int visibleItemCount;
    private final int visibleThreshold;

    public interface BooleanAction<T extends BaseV7Response> {
        boolean call(T t);
    }

    public interface OnEndlessFinish {
        void onEndlessFinish(EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BaseV7EndlessResponse> EndlessRecyclerOnScrollListener(BaseAdapter baseAdapter, V7<T, ? extends Endless> v7, rx.m.b<T> bVar, ErrorRequestListener errorRequestListener) {
        this.stableData = false;
        this.adapter = baseAdapter;
        this.v7request = v7;
        this.successRequestListener = bVar;
        this.errorRequestListener = errorRequestListener;
        this.visibleThreshold = 6;
        this.bypassCache = false;
        this.onFirstLoadListener = null;
        this.onEndOfListReachedListener = null;
        this.endCallbackCalled = false;
        this.firstCallbackCalled = false;
        this.multiLangPatch = new MultiLangPatch();
        this.onEndlessFinishList = new LinkedList();
        this.bypassServerCache = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLoadMoreErrorAfterWebRequest(Throwable th) {
        th.printStackTrace();
        popProgressBarDisplayable();
        this.errorRequestListener.onError(th);
        this.loading = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleLoadMoreResponseAfterWebRequest, reason: merged with bridge method [inline-methods] */
    public void c(boolean z, BaseV7EndlessResponse baseV7EndlessResponse) {
        if (baseV7EndlessResponse.hasData()) {
            boolean zHasStableTotal = baseV7EndlessResponse.hasStableTotal();
            this.stableData = zHasStableTotal;
            if (zHasStableTotal) {
                this.total = baseV7EndlessResponse.getTotal();
                this.offset = baseV7EndlessResponse.getNextSize();
            } else {
                int i2 = this.total;
                int total = baseV7EndlessResponse.getTotal();
                this.lastTotal = total;
                this.total = i2 + total;
                this.offset += baseV7EndlessResponse.getNextSize();
            }
            ((Endless) this.v7request.getBody()).setOffset(this.offset);
        }
        BooleanAction booleanAction = this.onFirstLoadListener;
        if (booleanAction == null || this.firstCallbackCalled) {
            this.successRequestListener.call(baseV7EndlessResponse);
        } else {
            if (!booleanAction.call(baseV7EndlessResponse)) {
                this.successRequestListener.call(baseV7EndlessResponse);
            }
            this.firstCallbackCalled = true;
        }
        this.loading = false;
        RecyclerViewPositionHelper recyclerViewPositionHelper = this.recyclerViewPositionHelper;
        if (recyclerViewPositionHelper != null) {
            this.totalItemCount = recyclerViewPositionHelper.getItemCount();
        }
        if (!hasMoreElements()) {
            rx.m.a aVar = this.onEndOfListReachedListener;
            if (aVar != null && !this.endCallbackCalled) {
                aVar.call();
                this.endCallbackCalled = true;
            }
            List<OnEndlessFinish> list = this.onEndlessFinishList;
            if (list != null) {
                for (OnEndlessFinish onEndlessFinish : list) {
                    if (onEndlessFinish != null) {
                        onEndlessFinish.onEndlessFinish(this);
                    }
                }
            }
        }
        if (shouldLoadMore()) {
            onLoadMore(z, this.bypassServerCache);
        }
    }

    private boolean isNearTheEndOfTheList() {
        return this.totalItemCount - this.visibleItemCount < (this.firstVisibleItem + this.visibleThreshold) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onLoadMore$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(BaseV7EndlessResponse baseV7EndlessResponse) {
        popProgressBarDisplayable();
        this.multiLangPatch.updateTotal(baseV7EndlessResponse);
    }

    private void popProgressBarDisplayable() {
        if (this.adapter.getItemCount() > 0) {
            BaseAdapter baseAdapter = this.adapter;
            if (baseAdapter.getDisplayable(baseAdapter.getItemCount() - 1) instanceof ProgressBarDisplayable) {
                this.adapter.popDisplayable();
            }
        }
    }

    private boolean shouldLoadMore() {
        RecyclerViewPositionHelper recyclerViewPositionHelper;
        return !this.loading && (recyclerViewPositionHelper = this.recyclerViewPositionHelper) != null && recyclerViewPositionHelper.recyclerView.isAttachedToWindow() && isNearTheEndOfTheList() && hasMoreElements();
    }

    public void addOnEndlessFinishListener(OnEndlessFinish onEndlessFinish) {
        this.onEndlessFinishList.add(onEndlessFinish);
    }

    public BaseAdapter getAdapter() {
        return this.adapter;
    }

    protected boolean hasMoreElements() {
        if (this.stableData) {
            if (this.offset < this.total) {
                return true;
            }
        } else if (this.lastTotal != 0) {
            return true;
        }
        return false;
    }

    public void onLoadMore(final boolean z, boolean z2) {
        if (this.loading) {
            return;
        }
        this.loading = true;
        this.adapter.addDisplayable(new ProgressBarDisplayable());
        V7<? extends BaseV7EndlessResponse, ? extends Endless> v7 = this.v7request;
        if (v7 != null) {
            this.subscription = v7.observe(z, z2).j0(rx.l.c.a.b()).x(new rx.m.b() { // from class: cm.aptoide.pt.view.recycler.i
                @Override // rx.m.b
                public final void call(Object obj) {
                    this.f8113f.b((BaseV7EndlessResponse) obj);
                }
            }).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.recycler.j
                @Override // rx.m.b
                public final void call(Object obj) {
                    this.f8114f.c(z, (BaseV7EndlessResponse) obj);
                }
            }, new rx.m.b() { // from class: cm.aptoide.pt.view.recycler.h
                @Override // rx.m.b
                public final void call(Object obj) {
                    this.f8112f.handleLoadMoreErrorAfterWebRequest((Throwable) obj);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        super.onScrolled(recyclerView, i2, i3);
        if (this.recyclerViewPositionHelper == null) {
            this.recyclerViewPositionHelper = RecyclerViewPositionHelper.createHelper(recyclerView);
        }
        this.visibleItemCount = recyclerView.getChildCount();
        int iFindFirstVisibleItemPosition = this.recyclerViewPositionHelper.findFirstVisibleItemPosition();
        if (iFindFirstVisibleItemPosition == -1) {
            iFindFirstVisibleItemPosition = 0;
        }
        this.firstVisibleItem = iFindFirstVisibleItemPosition;
        if (shouldLoadMore()) {
            onLoadMore(this.bypassCache, this.bypassServerCache);
        }
    }

    public void removeListeners() {
        this.onFirstLoadListener = null;
        this.onEndOfListReachedListener = null;
        this.successRequestListener = null;
    }

    public void reset(V7<? extends BaseV7EndlessResponse, ? extends Endless> v7) {
        this.v7request = v7;
        this.multiLangPatch.updateOffset();
        this.offset = -1;
        this.total = 0;
    }

    public void stopLoading() {
        k kVar = this.subscription;
        if (kVar != null && !kVar.isUnsubscribed()) {
            this.subscription.unsubscribe();
        }
        popProgressBarDisplayable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BaseV7EndlessResponse> EndlessRecyclerOnScrollListener(BaseAdapter baseAdapter, V7<T, ? extends Endless> v7, rx.m.b<T> bVar, ErrorRequestListener errorRequestListener, int i2, boolean z, BooleanAction<T> booleanAction, rx.m.a aVar) {
        this.stableData = false;
        this.multiLangPatch = new MultiLangPatch();
        this.onEndlessFinishList = new LinkedList();
        this.adapter = baseAdapter;
        this.v7request = v7;
        this.successRequestListener = bVar;
        this.errorRequestListener = errorRequestListener;
        this.visibleThreshold = i2;
        this.bypassCache = z;
        this.onFirstLoadListener = booleanAction;
        this.onEndOfListReachedListener = aVar;
        this.endCallbackCalled = false;
        this.firstCallbackCalled = false;
        this.bypassServerCache = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BaseV7EndlessResponse> EndlessRecyclerOnScrollListener(BaseAdapter baseAdapter, V7<T, ? extends Endless> v7, rx.m.b<T> bVar, ErrorRequestListener errorRequestListener, boolean z, boolean z2) {
        this.stableData = false;
        this.adapter = baseAdapter;
        this.v7request = v7;
        this.successRequestListener = bVar;
        this.errorRequestListener = errorRequestListener;
        this.bypassServerCache = z2;
        this.visibleThreshold = 6;
        this.bypassCache = z;
        this.onFirstLoadListener = null;
        this.onEndOfListReachedListener = null;
        this.endCallbackCalled = false;
        this.firstCallbackCalled = false;
        this.multiLangPatch = new MultiLangPatch();
        this.onEndlessFinishList = new LinkedList();
    }

    public EndlessRecyclerOnScrollListener(BaseAdapter baseAdapter) {
        this.stableData = false;
        this.adapter = baseAdapter;
        this.v7request = null;
        this.successRequestListener = null;
        this.errorRequestListener = null;
        this.visibleThreshold = 0;
        this.bypassCache = false;
        this.onFirstLoadListener = null;
        this.onEndOfListReachedListener = null;
        this.endCallbackCalled = false;
        this.firstCallbackCalled = false;
        this.multiLangPatch = new MultiLangPatch();
        this.onEndlessFinishList = new LinkedList();
        this.bypassServerCache = false;
    }
}
