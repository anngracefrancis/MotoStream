package cm.aptoide.pt.view.swipe;

import android.view.View;
import cm.aptoide.pt.R;
import cm.aptoide.pt.view.ReloadInterface;
import cm.aptoide.pt.view.fragment.GridRecyclerSwipeFragment;

/* JADX INFO: loaded from: classes.dex */
public class SwipeLoaderLayoutHandler extends LoaderLayoutHandler {
    private c.v.a.c swipeContainer;

    public SwipeLoaderLayoutHandler(int i2, ReloadInterface reloadInterface) {
        super(reloadInterface, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindViews$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d() {
        ((ReloadInterface) this.loadInterface).reload();
    }

    @Override // cm.aptoide.pt.view.swipe.LoaderLayoutHandler
    public void bindViews(View view) {
        super.bindViews(view);
        c.v.a.c cVar = (c.v.a.c) view.findViewById(R.id.swipe_container);
        this.swipeContainer = cVar;
        cVar.setOnRefreshListener(new c.v.a.c.j() { // from class: cm.aptoide.pt.view.swipe.f
            @Override // c.v.a.c.j
            public final void a() {
                this.a.d();
            }
        });
    }

    @Override // cm.aptoide.pt.view.swipe.LoaderLayoutHandler
    /* JADX INFO: renamed from: onFinishLoading */
    public void a(Throwable th) {
        super.a(th);
        this.swipeContainer.setRefreshing(false);
        this.swipeContainer.setEnabled(false);
    }

    @Override // cm.aptoide.pt.view.swipe.LoaderLayoutHandler
    public void restoreState() {
        super.restoreState();
        this.swipeContainer.setEnabled(true);
    }

    @Override // cm.aptoide.pt.view.swipe.LoaderLayoutHandler
    public void unbindViews() {
        this.swipeContainer.setOnRefreshListener(null);
        super.unbindViews();
    }

    public SwipeLoaderLayoutHandler(int[] iArr, GridRecyclerSwipeFragment gridRecyclerSwipeFragment) {
        super(gridRecyclerSwipeFragment, iArr);
    }

    @Override // cm.aptoide.pt.view.swipe.LoaderLayoutHandler
    protected void onFinishLoading() {
        super.onFinishLoading();
        this.swipeContainer.setRefreshing(false);
        this.swipeContainer.setEnabled(true);
    }
}
