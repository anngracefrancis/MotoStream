package cm.aptoide.pt.account.view.magiclink;

import cm.aptoide.pt.presenter.View;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: MagicLinkView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\tH&¨\u0006\u000f"}, d2 = {"Lcm/aptoide/pt/account/view/magiclink/MagicLinkView;", "Lcm/aptoide/pt/presenter/View;", "getEmailTextChangeEvent", "Lrx/Observable;", HttpUrl.FRAGMENT_ENCODE_SET, "getMagicLinkClick", "getSecureLoginTextClick", "Ljava/lang/Void;", "removeLoadingScreen", HttpUrl.FRAGMENT_ENCODE_SET, "removeTextFieldError", "setEmailInvalidError", "setInitialState", "setLoadingScreen", "showUnknownError", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MagicLinkView extends View {
    rx.e<String> getEmailTextChangeEvent();

    rx.e<String> getMagicLinkClick();

    rx.e<Void> getSecureLoginTextClick();

    void removeLoadingScreen();

    void removeTextFieldError();

    void setEmailInvalidError();

    void setInitialState();

    void setLoadingScreen();

    void showUnknownError();
}
