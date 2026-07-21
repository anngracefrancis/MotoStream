package cm.aptoide.aptoideviews.downloadprogressview;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DownloadProgressView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class DownloadProgressView$setupClickListeners$1$1 extends Lambda implements Function0<u> {
    final /* synthetic */ DownloadProgressView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadProgressView$setupClickListeners$1$1(DownloadProgressView downloadProgressView) {
        super(0);
        this.this$0 = downloadProgressView;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.stateMachine.g(Event.CancelClick.INSTANCE);
    }
}
