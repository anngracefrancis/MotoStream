package cm.aptoide.pt.account.view;

import android.net.Uri;
import android.provider.MediaStore;
import cm.aptoide.pt.navigator.ActivityNavigator;
import cm.aptoide.pt.navigator.Result;

/* JADX INFO: loaded from: classes.dex */
public class ImagePickerNavigator {
    private final ActivityNavigator activityNavigator;

    public ImagePickerNavigator(ActivityNavigator activityNavigator) {
        this.activityNavigator = activityNavigator;
    }

    static /* synthetic */ Void lambda$navigateToCameraWithImageUri$3(Result result) {
        return null;
    }

    public rx.e<Void> navigateToCameraWithImageUri(int i2, Uri uri) {
        return this.activityNavigator.navigateForResultWithOutput("android.media.action.IMAGE_CAPTURE", uri, i2).D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Result) obj).getResultCode() == -1);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.account.view.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                ImagePickerNavigator.lambda$navigateToCameraWithImageUri$3((Result) obj);
                return null;
            }
        });
    }

    public rx.e<String> navigateToGalleryForImageUri(int i2) {
        return this.activityNavigator.navigateForResult("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI, i2).D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Result) obj).getResultCode() == -1);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.account.view.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((Result) obj).getData().getData().toString();
            }
        });
    }
}
