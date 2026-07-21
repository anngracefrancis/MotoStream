package cm.aptoide.pt;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: UpdateLaunchManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcm/aptoide/pt/UpdateLaunchManager;", HttpUrl.FRAGMENT_ENCODE_SET, "followedStoresManager", "Lcm/aptoide/pt/FollowedStoresManager;", "(Lcm/aptoide/pt/FollowedStoresManager;)V", "getFollowedStoresManager", "()Lcm/aptoide/pt/FollowedStoresManager;", "runUpdateLaunch", "Lrx/Completable;", "previousVersionCode", HttpUrl.FRAGMENT_ENCODE_SET, "currentVersionCode", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdateLaunchManager {
    private final FollowedStoresManager followedStoresManager;

    public UpdateLaunchManager(FollowedStoresManager followedStoresManager) {
        kotlin.jvm.internal.m.f(followedStoresManager, "followedStoresManager");
        this.followedStoresManager = followedStoresManager;
    }

    public final FollowedStoresManager getFollowedStoresManager() {
        return this.followedStoresManager;
    }

    public final rx.b runUpdateLaunch(int i2, int i3) {
        rx.b bVarE = rx.b.e();
        if (i2 < 10013) {
            bVarE = bVarE.a(this.followedStoresManager.setDefaultFollowedStores());
        }
        kotlin.jvm.internal.m.e(bVarE, "completable");
        return bVarE;
    }
}
