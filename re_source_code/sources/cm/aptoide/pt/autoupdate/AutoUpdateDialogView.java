package cm.aptoide.pt.autoupdate;

import cm.aptoide.pt.presenter.View;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoUpdateDialogView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\b"}, d2 = {"Lcm/aptoide/pt/autoupdate/AutoUpdateDialogView;", "Lcm/aptoide/pt/presenter/View;", "dismissDialog", HttpUrl.FRAGMENT_ENCODE_SET, "notNowClicked", "Lrx/Observable;", "Ljava/lang/Void;", "updateClicked", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AutoUpdateDialogView extends View {
    void dismissDialog();

    rx.e<Void> notNowClicked();

    rx.e<Void> updateClicked();
}
