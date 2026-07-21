package cm.aptoide.pt.networking;

import android.content.SharedPreferences;
import android.text.TextUtils;
import cm.aptoide.pt.dataprovider.NetworkOperatorManager;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v3.BaseBody;
import cm.aptoide.pt.preferences.AptoideMd5Manager;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.preferences.toolbox.ToolboxManager;
import cm.aptoide.pt.utils.q.QManager;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class BodyInterceptorV3 implements BodyInterceptor<BaseBody> {
    public static final String RESPONSE_MODE_JSON = "json";
    private final int androidVersion;
    private final AptoideMd5Manager aptoideMd5Manager;
    private final String aptoidePackage;
    private final AuthenticationPersistence authenticationPersistence;
    private final IdsRepository idsRepository;
    private final NetworkOperatorManager operatorManager;
    private final QManager qManager;
    private final String responseMode;
    private final SharedPreferences sharedPreferences;

    public BodyInterceptorV3(IdsRepository idsRepository, AptoideMd5Manager aptoideMd5Manager, String str, QManager qManager, SharedPreferences sharedPreferences, String str2, int i2, NetworkOperatorManager networkOperatorManager, AuthenticationPersistence authenticationPersistence) {
        this.idsRepository = idsRepository;
        this.aptoideMd5Manager = aptoideMd5Manager;
        this.aptoidePackage = str;
        this.authenticationPersistence = authenticationPersistence;
        this.qManager = qManager;
        this.sharedPreferences = sharedPreferences;
        this.responseMode = str2;
        this.androidVersion = i2;
        this.operatorManager = networkOperatorManager;
    }

    private /* synthetic */ BaseBody lambda$intercept$0(BaseBody baseBody, Authentication authentication, String str) {
        baseBody.setAndroidVersion(this.androidVersion);
        String aptoideMd5 = this.aptoideMd5Manager.getAptoideMd5();
        if (!aptoideMd5.isEmpty()) {
            baseBody.setAptoideMd5sum(aptoideMd5);
        }
        baseBody.setAptoidePackage(this.aptoidePackage);
        baseBody.setAptoideUid(str);
        baseBody.setQ(this.qManager.getFilters(ManagerPreferences.getHWSpecsFilter(this.sharedPreferences)));
        baseBody.setResponseMode(this.responseMode);
        if (authentication.isAuthenticated()) {
            baseBody.setAccessToken(authentication.getAccessToken());
        }
        String forceCountry = ToolboxManager.getForceCountry(this.sharedPreferences);
        if (!TextUtils.isEmpty(forceCountry)) {
            baseBody.setSimCountryISOCode(forceCountry);
        } else if (this.operatorManager.isSimStateReady()) {
            baseBody.setMobileCountryCode(this.operatorManager.getMobileCountryCode());
            baseBody.setMobileNetworkCode(this.operatorManager.getMobileNetworkCode());
            baseBody.setSimCountryISOCode(this.operatorManager.getSimCountryISO());
        }
        return baseBody;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$intercept$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single b(final BaseBody baseBody, final Authentication authentication) {
        return this.idsRepository.getUniqueIdentifier().n(new rx.m.e() { // from class: cm.aptoide.pt.networking.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                BodyInterceptorV3 bodyInterceptorV3 = this.f6638f;
                BaseBody baseBody2 = baseBody;
                bodyInterceptorV3.a(baseBody2, authentication, (String) obj);
                return baseBody2;
            }
        });
    }

    public /* synthetic */ BaseBody a(BaseBody baseBody, Authentication authentication, String str) {
        lambda$intercept$0(baseBody, authentication, str);
        return baseBody;
    }

    @Override // cm.aptoide.pt.dataprovider.ws.BodyInterceptor
    public Single<BaseBody> intercept(final BaseBody baseBody) {
        return this.authenticationPersistence.getAuthentication().i(new rx.m.e() { // from class: cm.aptoide.pt.networking.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6641f.b(baseBody, (Authentication) obj);
            }
        }).v(Schedulers.computation());
    }
}
