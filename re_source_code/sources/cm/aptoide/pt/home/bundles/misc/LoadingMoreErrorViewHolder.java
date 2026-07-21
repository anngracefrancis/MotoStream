package cm.aptoide.pt.home.bundles.misc;

import android.view.View;
import android.widget.Button;
import cm.aptoide.pt.R;
import cm.aptoide.pt.home.bundles.base.AppBundleViewHolder;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import rx.s.b;

/* JADX INFO: loaded from: classes.dex */
public class LoadingMoreErrorViewHolder extends AppBundleViewHolder {
    private Button retry;
    private b<HomeEvent> uiEventsListener;

    public LoadingMoreErrorViewHolder(View view, b<HomeEvent> bVar) {
        super(view);
        this.retry = (Button) view.findViewById(R.id.load_more_retry_button);
        this.uiEventsListener = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setBundle$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(HomeBundle homeBundle, int i2, View view) {
        this.uiEventsListener.onNext(new HomeEvent(homeBundle, i2, HomeEvent.Type.LOAD_MORE_RETRY));
    }

    @Override // cm.aptoide.pt.home.bundles.base.AppBundleViewHolder
    public void setBundle(final HomeBundle homeBundle, final int i2) {
        this.retry.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.home.bundles.misc.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5949f.a(homeBundle, i2, view);
            }
        });
    }
}
