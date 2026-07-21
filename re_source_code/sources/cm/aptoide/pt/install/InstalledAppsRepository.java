package cm.aptoide.pt.install;

import java.util.List;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: InstalledAppsRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&¨\u0006\u0006"}, d2 = {"Lcm/aptoide/pt/install/InstalledAppsRepository;", HttpUrl.FRAGMENT_ENCODE_SET, "getInstalledAppsNames", "Lio/reactivex/Single;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface InstalledAppsRepository {
    h.a.s<List<String>> getInstalledAppsNames();
}
