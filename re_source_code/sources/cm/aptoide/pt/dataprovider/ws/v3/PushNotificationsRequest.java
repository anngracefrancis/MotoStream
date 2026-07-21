package cm.aptoide.pt.dataprovider.ws.v3;

import android.content.SharedPreferences;
import android.text.TextUtils;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.networking.BodyInterceptorV3;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public class PushNotificationsRequest extends V3<GetPushNotificationsResponse> {
    protected PushNotificationsRequest(BaseBody baseBody, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator) {
        super("https://webservices.aptoide.com/webservices/3/", baseBody, bodyInterceptor, tokenInvalidator);
    }

    public static PushNotificationsRequest of(SharedPreferences sharedPreferences, String str, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, int i2, int i3, String str2) {
        BaseBody baseBody = new BaseBody();
        baseBody.put("oem_id", str);
        baseBody.put("mode", BodyInterceptorV3.RESPONSE_MODE_JSON);
        baseBody.put("limit", "1");
        baseBody.put("lang", str2);
        if (ManagerPreferences.isDebug(sharedPreferences)) {
            String notificationType = ManagerPreferences.getNotificationType(sharedPreferences);
            if (TextUtils.isEmpty(notificationType)) {
                notificationType = "aptoide_tests";
            }
            baseBody.put("notification_type", notificationType);
        } else {
            baseBody.put("notification_type", "aptoide_vanilla");
        }
        baseBody.put(DeepLinkIntentReceiver.DeepLinksKeys.ID, String.valueOf(i3));
        baseBody.put("aptoide_vercode", Integer.toString(i2));
        return new PushNotificationsRequest(baseBody, bodyInterceptor, tokenInvalidator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.dataprovider.WebService
    public e<GetPushNotificationsResponse> loadDataFromNetwork(Service service, boolean z) {
        return service.getPushNotifications(this.map, z);
    }
}
