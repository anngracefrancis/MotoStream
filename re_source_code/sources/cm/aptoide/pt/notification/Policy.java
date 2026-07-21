package cm.aptoide.pt.notification;

import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public interface Policy {
    Single<Boolean> shouldShow();
}
