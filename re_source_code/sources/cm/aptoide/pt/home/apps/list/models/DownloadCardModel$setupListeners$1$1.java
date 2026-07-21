package cm.aptoide.pt.home.apps.list.models;

import cm.aptoide.pt.home.apps.AppClick;
import cm.aptoide.pt.home.apps.model.DownloadApp;
import cm.aptoide.pt.home.apps.model.StateApp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DownloadCardModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class DownloadCardModel$setupListeners$1$1 extends Lambda implements Function0<u> {
    final /* synthetic */ DownloadApp $app;
    final /* synthetic */ DownloadCardModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadCardModel$setupListeners$1$1(DownloadApp downloadApp, DownloadCardModel downloadCardModel) {
        super(0);
        this.$app = downloadApp;
        this.this$0 = downloadCardModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AppClick.ClickType clickType = AppClick.ClickType.CARD_CLICK;
        StateApp.Status status = this.$app.getStatus();
        if (status != null && status == StateApp.Status.STANDBY) {
            clickType = AppClick.ClickType.INSTALL_CLICK;
        }
        rx.s.b<AppClick> eventSubject = this.this$0.getEventSubject();
        if (eventSubject != null) {
            eventSubject.onNext(new AppClick(this.$app, clickType));
        }
    }
}
