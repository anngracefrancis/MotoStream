package cm.aptoide.pt.editorialList;

import cm.aptoide.pt.bonus.BonusAppcModel;
import cm.aptoide.pt.home.bundles.editorial.EditorialHomeEvent;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.reactions.ReactionsHomeEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface EditorialListView extends View {
    rx.e<EditorialHomeEvent> editorialCardClicked();

    void hideLoadMore();

    void hideLoading();

    void hideRefresh();

    rx.e<Void> imageClick();

    rx.e<EditorialHomeEvent> onPopupDismiss();

    void populateView(List<CurationCard> list, BonusAppcModel bonusAppcModel);

    rx.e<Object> reachesBottom();

    rx.e<EditorialHomeEvent> reactionButtonLongPress();

    rx.e<ReactionsHomeEvent> reactionClicked();

    rx.e<EditorialHomeEvent> reactionsButtonClicked();

    rx.e<Void> refreshes();

    rx.e<Void> retryClicked();

    void setDefaultUserImage();

    void setScrollEnabled(Boolean bool);

    void setUserImage(String str);

    void showAvatar();

    void showGenericError();

    void showGenericErrorToast();

    void showLoadMore();

    void showLoading();

    void showLogInDialog();

    void showNetworkError();

    void showNetworkErrorToast();

    void showReactionsPopup(String str, String str2, int i2);

    rx.e<Void> snackLogInClick();

    void update(List<CurationCard> list);

    void updateEditorialCard(CurationCard curationCard);

    rx.e<EditorialListEvent> visibleCards();
}
