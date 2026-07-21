package cm.aptoide.pt.view.swipe;

import android.view.View;
import android.widget.ProgressBar;
import cm.aptoide.aptoideviews.errors.ErrorView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.util.ErrorUtils;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.LoadInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function0;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
public class LoaderLayoutHandler {
    private ErrorView errorView;
    final LoadInterface loadInterface;
    protected ProgressBar progressBar;
    private List<View> viewsToShowAfterLoading;
    private final List<Integer> viewsToShowAfterLoadingId;

    public LoaderLayoutHandler(LoadInterface loadInterface, int i2) {
        ArrayList arrayList = new ArrayList();
        this.viewsToShowAfterLoadingId = arrayList;
        this.viewsToShowAfterLoading = new ArrayList();
        arrayList.add(Integer.valueOf(i2));
        this.loadInterface = loadInterface;
    }

    private void hideViewsToShowAfterLoading() {
        for (View view : this.viewsToShowAfterLoading) {
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    private /* synthetic */ Object lambda$finishLoading$2() throws Exception {
        onFinishLoading();
        return null;
    }

    static /* synthetic */ void lambda$finishLoading$3(Object obj) {
    }

    private /* synthetic */ u lambda$onFinishLoading$1() {
        restoreState();
        this.loadInterface.load(true, false, null);
        return null;
    }

    private void showViewsToShowAfterLoading() {
        Iterator<View> it = this.viewsToShowAfterLoading.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(0);
        }
    }

    public /* synthetic */ Object b() throws Exception {
        lambda$finishLoading$2();
        return null;
    }

    public void bindViews(View view) {
        Iterator<Integer> it = this.viewsToShowAfterLoadingId.iterator();
        while (it.hasNext()) {
            this.viewsToShowAfterLoading.add(view.findViewById(it.next().intValue()));
        }
        hideViewsToShowAfterLoading();
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        this.progressBar = progressBar;
        progressBar.setVisibility(0);
        this.errorView = (ErrorView) view.findViewById(R.id.error_view);
    }

    public /* synthetic */ u c() {
        lambda$onFinishLoading$1();
        return null;
    }

    public void finishLoading(final Throwable th) {
        CrashReport.getInstance().log(th);
        AptoideUtils.ThreadU.runOnUiThread(new Runnable() { // from class: cm.aptoide.pt.view.swipe.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f8289f.a(th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onFinishLoading, reason: merged with bridge method [inline-methods] */
    public void a(Throwable th) {
        this.progressBar.setVisibility(8);
        hideViewsToShowAfterLoading();
        if (ErrorUtils.isNoNetworkConnection(th)) {
            this.errorView.setError(ErrorView.Error.NO_NETWORK);
        } else {
            this.errorView.setError(ErrorView.Error.GENERIC);
        }
        this.errorView.setVisibility(0);
        this.errorView.setRetryAction(new Function0() { // from class: cm.aptoide.pt.view.swipe.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                this.f8287f.c();
                return null;
            }
        });
    }

    protected void restoreState() {
        this.errorView.setVisibility(8);
        this.progressBar.setVisibility(0);
    }

    public void unbindViews() {
        this.errorView = null;
        this.progressBar = null;
    }

    public void finishLoading() {
        rx.e.P(new Callable() { // from class: cm.aptoide.pt.view.swipe.a
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.f8285f.b();
                return null;
            }
        }).I0(rx.l.c.a.b()).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.swipe.b
            @Override // rx.m.b
            public final void call(Object obj) {
                LoaderLayoutHandler.lambda$finishLoading$3(obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.swipe.d
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
    }

    public LoaderLayoutHandler(LoadInterface loadInterface, int... iArr) {
        this.viewsToShowAfterLoadingId = new ArrayList();
        this.viewsToShowAfterLoading = new ArrayList();
        for (int i2 : iArr) {
            this.viewsToShowAfterLoadingId.add(Integer.valueOf(i2));
        }
        this.loadInterface = loadInterface;
    }

    protected void onFinishLoading() {
        this.progressBar.setVisibility(8);
        showViewsToShowAfterLoading();
    }
}
