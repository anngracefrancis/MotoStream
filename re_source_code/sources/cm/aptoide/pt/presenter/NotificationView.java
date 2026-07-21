package cm.aptoide.pt.presenter;

import cm.aptoide.pt.notification.NotificationInfo;

/* JADX INFO: loaded from: classes.dex */
public interface NotificationView extends View {
    rx.e<NotificationInfo> getActionBootCompleted();

    rx.e<NotificationInfo> getNotificationClick();

    rx.e<NotificationInfo> getNotificationDismissed();
}
