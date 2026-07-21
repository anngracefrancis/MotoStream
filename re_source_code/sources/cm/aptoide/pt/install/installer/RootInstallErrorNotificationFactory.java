package cm.aptoide.pt.install.installer;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import cm.aptoide.pt.R;
import cm.aptoide.pt.install.Install;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RootInstallErrorNotificationFactory {
    private final PendingIntent dismissAction;
    private final Bitmap icon;
    private final androidx.core.app.i.a notificationAction;
    private final int notificationId;

    public RootInstallErrorNotificationFactory(int i2, Bitmap bitmap, androidx.core.app.i.a aVar, PendingIntent pendingIntent) {
        this.notificationId = i2;
        this.icon = bitmap;
        this.notificationAction = aVar;
        this.dismissAction = pendingIntent;
    }

    private String getNotificationTitle(Context context, List<Install> list) {
        return list.size() == 1 ? context.getString(R.string.generalscreen_short_root_install_single_app_timeout_error_message) : context.getString(R.string.generalscreen_short_root_install_timeout_error_message, Integer.valueOf(list.size()));
    }

    public RootInstallErrorNotification create(Context context, List<Install> list) {
        return new RootInstallErrorNotification(this.notificationId, this.icon, getNotificationTitle(context, list), this.notificationAction, this.dismissAction);
    }
}
