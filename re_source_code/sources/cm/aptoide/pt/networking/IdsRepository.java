package cm.aptoide.pt.networking;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cm.aptoide.pt.dataprovider.ads.AdNetworkUtils;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.utils.AptoideUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.security.SecureRandom;
import java.util.UUID;
import okhttp3.HttpUrl;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class IdsRepository {
    private static final String ADVERTISING_ID_CLIENT = "advertisingIdClient";
    private static final String ANDROID_ID_CLIENT = "androidId";
    private static final String APTOIDE_CLIENT_UUID = "aptoide_client_uuid";
    private static final String GOOGLE_ADVERTISING_ID_CLIENT = "googleAdvertisingId";
    private static final String GOOGLE_ADVERTISING_ID_CLIENT_SET = "googleAdvertisingIdSet";
    private static final String TAG = "IdsRepository";
    private final String androidId;
    private final Context context;
    private final SharedPreferences sharedPreferences;

    public IdsRepository(SharedPreferences sharedPreferences, Context context, String str) {
        this.sharedPreferences = sharedPreferences;
        this.context = context;
        this.androidId = str;
    }

    private String generateRandomAdvertisingId() {
        byte[] bArr = new byte[16];
        String string = this.androidId;
        if (string == null) {
            string = UUID.randomUUID().toString();
        }
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(string.hashCode());
        secureRandom.nextBytes(bArr);
        return UUID.nameUUIDFromBytes(bArr).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAdvertisingId$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String a(String str) {
        return !TextUtils.isEmpty(str) ? str : generateRandomAdvertisingId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAdvertisingId$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(String str, String str2) {
        this.sharedPreferences.edit().putString(ADVERTISING_ID_CLIENT, str).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getGoogleAdvertisingId$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (AptoideUtils.ThreadU.isUiThread()) {
            throw new IllegalStateException("You cannot run this method from the main thread");
        }
        if (!AdNetworkUtils.isGooglePlayServicesAvailable(this.context)) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(this.context).getId();
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getGoogleAdvertisingId$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(String str) {
        if (str.equals(HttpUrl.FRAGMENT_ENCODE_SET)) {
            return;
        }
        this.sharedPreferences.edit().putString(GOOGLE_ADVERTISING_ID_CLIENT, str).apply();
        this.sharedPreferences.edit().putBoolean(GOOGLE_ADVERTISING_ID_CLIENT_SET, true).apply();
    }

    static /* synthetic */ String lambda$getUniqueIdentifier$0(String str) {
        return !TextUtils.isEmpty(str) ? str : UUID.randomUUID().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getUniqueIdentifier$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(String str) {
        this.sharedPreferences.edit().putString(APTOIDE_CLIENT_UUID, str).apply();
    }

    public synchronized Single<String> getAdvertisingId() {
        final String string = this.sharedPreferences.getString(ADVERTISING_ID_CLIENT, null);
        if (TextUtils.isEmpty(string)) {
            return getGoogleAdvertisingId().n(new rx.m.e() { // from class: cm.aptoide.pt.networking.n
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return this.f6657f.a((String) obj);
                }
            }).g(new rx.m.b() { // from class: cm.aptoide.pt.networking.j
                @Override // rx.m.b
                public final void call(Object obj) {
                    this.f6652f.b(string, (String) obj);
                }
            });
        }
        return Single.m(string);
    }

    public synchronized String getAndroidId() {
        String string = this.sharedPreferences.getString(ANDROID_ID_CLIENT, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String str = this.androidId;
        if (this.sharedPreferences.getString(ANDROID_ID_CLIENT, null) != null) {
            throw new RuntimeException("Android ID already set!");
        }
        this.sharedPreferences.edit().putString(ANDROID_ID_CLIENT, str).apply();
        return str;
    }

    public synchronized Single<String> getGoogleAdvertisingId() {
        return Single.m(this.sharedPreferences.getString(GOOGLE_ADVERTISING_ID_CLIENT, null)).n(new rx.m.e() { // from class: cm.aptoide.pt.networking.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6656f.c((String) obj);
            }
        }).g(new rx.m.b() { // from class: cm.aptoide.pt.networking.i
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6648f.d((String) obj);
            }
        }).v(Schedulers.newThread());
    }

    public synchronized Single<String> getUniqueIdentifier() {
        String string = this.sharedPreferences.getString(APTOIDE_CLIENT_UUID, null);
        if (TextUtils.isEmpty(string)) {
            return getGoogleAdvertisingId().n(new rx.m.e() { // from class: cm.aptoide.pt.networking.k
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return IdsRepository.lambda$getUniqueIdentifier$0((String) obj);
                }
            }).g(new rx.m.b() { // from class: cm.aptoide.pt.networking.l
                @Override // rx.m.b
                public final void call(Object obj) {
                    this.f6655f.e((String) obj);
                }
            });
        }
        Logger.getInstance().v(TAG, "getUniqueIdentifier: in sharedPreferences: " + string);
        return Single.m(string);
    }
}
