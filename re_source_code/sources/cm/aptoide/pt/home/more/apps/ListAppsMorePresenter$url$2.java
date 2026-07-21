package cm.aptoide.pt.home.more.apps;

import cm.aptoide.pt.dataprovider.ws.v7.V7;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.text.u;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ListAppsMorePresenter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ListAppsMorePresenter$url$2 extends Lambda implements Function0<String> {
    final /* synthetic */ ListAppsMorePresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ListAppsMorePresenter$url$2(ListAppsMorePresenter listAppsMorePresenter) {
        super(0);
        this.this$0 = listAppsMorePresenter;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        if (this.this$0.listAppsConfiguration.getAction() == null) {
            return null;
        }
        ListAppsMorePresenter listAppsMorePresenter = this.this$0;
        if (V7.isUrlBaseCache(listAppsMorePresenter.listAppsConfiguration.getAction())) {
            String action = listAppsMorePresenter.listAppsConfiguration.getAction();
            String cacheHost = V7.getCacheHost(listAppsMorePresenter.sharedPreferences);
            m.e(cacheHost, "getCacheHost(sharedPreferences)");
            return u.A(action, cacheHost, HttpUrl.FRAGMENT_ENCODE_SET, false, 4, null);
        }
        String action2 = listAppsMorePresenter.listAppsConfiguration.getAction();
        String host = V7.getHost(listAppsMorePresenter.sharedPreferences);
        m.e(host, "getHost(sharedPreferences)");
        return u.A(action2, host, HttpUrl.FRAGMENT_ENCODE_SET, false, 4, null);
    }
}
