package cm.aptoide.pt.navigator;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public interface ActivityNavigator {
    Activity getActivity();

    void navigateBack();

    void navigateBackWithResult(int i2, Bundle bundle);

    rx.e<Result> navigateForResult(String str, Uri uri, int i2);

    void navigateForResult(Intent intent, int i2);

    void navigateForResult(Class<? extends Activity> cls, int i2, Bundle bundle);

    void navigateForResult(String str, Uri uri, int i2, String str2, String str3);

    rx.e<Result> navigateForResultWithOutput(String str, Uri uri, int i2);

    void navigateTo(Uri uri);

    void navigateTo(Class<? extends Activity> cls);

    void navigateTo(Class<? extends Activity> cls, Bundle bundle);

    void navigateWithIntent(Intent intent);

    rx.e<Result> results();

    rx.e<Result> results(int i2);
}
