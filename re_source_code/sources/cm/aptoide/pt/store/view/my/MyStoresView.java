package cm.aptoide.pt.store.view.my;

import cm.aptoide.pt.presenter.View;

/* JADX INFO: loaded from: classes.dex */
public interface MyStoresView extends View {
    rx.e<Void> imageClick();

    void scrollToTop();

    void setDefaultUserImage();

    void setUserImage(String str);

    void showAvatar();
}
