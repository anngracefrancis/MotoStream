package com.flurry.sdk;

import android.content.SharedPreferences;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends l2 {
    String o;
    boolean p;
    AtomicBoolean q;

    f() {
        super("AdvertisingIdProvider", i2.a(i2.b.PROVIDER));
        this.q = new AtomicBoolean(false);
        this.o = HttpUrl.FRAGMENT_ENCODE_SET;
        this.p = false;
    }

    private static AdvertisingIdClient.Info s() {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(b0.a());
            return new AdvertisingIdClient.Info(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (Exception e2) {
            d1.j("AdvertisingIdProvider", "GOOGLE PLAY SERVICES ERROR: " + e2.getMessage());
            d1.j("AdvertisingIdProvider", "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return null;
        } catch (NoClassDefFoundError unused) {
            d1.j("AdvertisingIdProvider", "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return null;
        }
    }

    public final void a() {
        AdvertisingIdClient.Info infoS = s();
        if (infoS != null) {
            this.o = infoS.getId();
            this.p = !infoS.isLimitAdTrackingEnabled();
            this.q.set(true);
            p2.d("advertising_id", infoS.getId());
            boolean zIsLimitAdTrackingEnabled = infoS.isLimitAdTrackingEnabled();
            SharedPreferences.Editor editorEdit = b0.a().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
            editorEdit.putBoolean(String.format(Locale.US, "com.flurry.sdk.%s", "ad_tracking_enabled"), zIsLimitAdTrackingEnabled);
            editorEdit.apply();
        }
    }
}
