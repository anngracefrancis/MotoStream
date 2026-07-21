package cm.aptoide.pt.themes;

import cm.aptoide.pt.presenter.View;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import rx.e;

/* JADX INFO: compiled from: NewFeatureDialogView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcm/aptoide/pt/themes/NewFeatureDialogView;", "Lcm/aptoide/pt/presenter/View;", "clickDismiss", "Lrx/Observable;", "Ljava/lang/Void;", "clickTurnItOn", "dismissView", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface NewFeatureDialogView extends View {
    e<Void> clickDismiss();

    e<Void> clickTurnItOn();

    void dismissView();
}
