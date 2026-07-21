package cm.aptoide.pt.notification.policies;

import cm.aptoide.pt.notification.Policy;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class DefaultPolicy implements Policy {
    @Override // cm.aptoide.pt.notification.Policy
    public Single<Boolean> shouldShow() {
        return Single.m(Boolean.FALSE);
    }
}
