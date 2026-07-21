package cm.aptoide.pt.account.view.user;

import cm.aptoide.pt.account.view.ImagePickerView;

/* JADX INFO: loaded from: classes.dex */
public interface ManageUserView extends ImagePickerView {
    rx.e<Void> cancelButtonClick();

    void hideProgressDialog();

    void loadImageStateless(String str);

    rx.e<ManageUserFragment.ViewModel> saveUserDataButtonClick();

    void setUserName(String str);

    rx.b showErrorMessage(String str);

    void showProgressDialog();
}
