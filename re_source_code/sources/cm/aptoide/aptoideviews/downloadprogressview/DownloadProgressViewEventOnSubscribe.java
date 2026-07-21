package cm.aptoide.aptoideviews.downloadprogressview;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;
import rx.e;
import rx.j;

/* JADX INFO: compiled from: EventObservable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u000bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcm/aptoide/aptoideviews/downloadprogressview/DownloadProgressViewEventOnSubscribe;", "Lrx/Observable$OnSubscribe;", "Lcm/aptoide/aptoideviews/downloadprogressview/DownloadEventListener$Action;", "view", "Lcm/aptoide/aptoideviews/downloadprogressview/DownloadProgressView;", "(Lcm/aptoide/aptoideviews/downloadprogressview/DownloadProgressView;)V", "getView", "()Lcm/aptoide/aptoideviews/downloadprogressview/DownloadProgressView;", "call", HttpUrl.FRAGMENT_ENCODE_SET, "subscriber", "Lrx/Subscriber;", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DownloadProgressViewEventOnSubscribe implements e.a<DownloadEventListener.Action> {
    private final DownloadProgressView view;

    public DownloadProgressViewEventOnSubscribe(DownloadProgressView downloadProgressView) {
        m.f(downloadProgressView, "view");
        this.view = downloadProgressView;
    }

    public final DownloadProgressView getView() {
        return this.view;
    }

    @Override // rx.m.b
    public void call(final j<? super DownloadEventListener.Action> jVar) {
        m.f(jVar, "subscriber");
        rx.l.a.verifyMainThread();
        DownloadEventListener downloadEventListener = new DownloadEventListener() { // from class: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressViewEventOnSubscribe$call$eventListener$1
            @Override // cm.aptoide.aptoideviews.downloadprogressview.DownloadEventListener
            public void onActionClick(DownloadEventListener.Action action) {
                m.f(action, "action");
                if (jVar.isUnsubscribed()) {
                    return;
                }
                jVar.onNext(action);
            }
        };
        jVar.add(new rx.l.a() { // from class: cm.aptoide.aptoideviews.downloadprogressview.DownloadProgressViewEventOnSubscribe.call.1
            @Override // rx.l.a
            protected void onUnsubscribe() {
                DownloadProgressViewEventOnSubscribe.this.getView().setEventListener(null);
            }
        });
        this.view.setEventListener(downloadEventListener);
    }
}
