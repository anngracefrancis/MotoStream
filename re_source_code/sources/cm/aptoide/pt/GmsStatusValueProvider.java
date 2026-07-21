package cm.aptoide.pt;

import android.content.Context;
import cm.aptoide.pt.dataprovider.ads.AdNetworkUtils;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class GmsStatusValueProvider {
    private static final String HAS_GMS = "Has GMS";
    private static final String NO_GMS = "No GMS";
    private Context context;
    private String gmsValue = HttpUrl.FRAGMENT_ENCODE_SET;

    public GmsStatusValueProvider(Context context) {
        this.context = context;
    }

    public String getGmsValue() {
        String str = this.gmsValue;
        if (str == null || str.isEmpty()) {
            this.gmsValue = AdNetworkUtils.isGooglePlayServicesAvailable(this.context) ? HAS_GMS : NO_GMS;
        }
        return this.gmsValue;
    }
}
