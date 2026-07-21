package cm.aptoide.pt.account.view;

import android.content.DialogInterface;
import cm.aptoide.pt.account.view.exception.InvalidImageException;
import cm.aptoide.pt.presenter.View;

/* JADX INFO: loaded from: classes.dex */
public interface ImagePickerView extends View {
    rx.e<DialogInterface> dialogCameraSelected();

    rx.e<DialogInterface> dialogGallerySelected();

    void dismissLoadImageDialog();

    void loadImage(String str);

    rx.e<Void> selectStoreImageClick();

    void showIconPropertiesError(InvalidImageException invalidImageException);

    void showImagePickerDialog();
}
