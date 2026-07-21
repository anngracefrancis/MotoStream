package cm.aptoide.pt.autoupdate;

import kotlin.Metadata;
import okhttp3.HttpUrl;
import retrofit2.http.GET;
import retrofit2.http.Path;

/* JADX INFO: compiled from: AutoUpdateService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcm/aptoide/pt/autoupdate/Service;", HttpUrl.FRAGMENT_ENCODE_SET, "getAutoUpdateResponse", "Lrx/Observable;", "Lcm/aptoide/pt/autoupdate/AutoUpdateJsonResponse;", "packageName", HttpUrl.FRAGMENT_ENCODE_SET, "clientSdkVersion", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Service {
    @GET("apks/package/autoupdate/get/package_name={package_name}/sdk={client_sdk_version}")
    rx.e<AutoUpdateJsonResponse> getAutoUpdateResponse(@Path("package_name") String str, @Path("client_sdk_version") int i2);
}
