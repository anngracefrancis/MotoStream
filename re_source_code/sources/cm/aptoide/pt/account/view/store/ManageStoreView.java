package cm.aptoide.pt.account.view.store;

import cm.aptoide.pt.account.view.ImagePickerView;

/* JADX INFO: loaded from: classes.dex */
public interface ManageStoreView extends ImagePickerView {
    rx.e<ManageStoreViewModel> cancelClick();

    void dismissWaitProgressBar();

    void loadImageStateless(String str);

    rx.e<ManageStoreViewModel> saveDataClick();

    void showError(String str);

    void showSuccessMessage();

    void showWaitProgressBar();
}
