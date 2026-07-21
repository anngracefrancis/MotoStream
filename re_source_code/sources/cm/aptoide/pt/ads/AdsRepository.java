package cm.aptoide.pt.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse;
import cm.aptoide.pt.dataprovider.ws.v2.aptwords.AdsApplicationVersionCodeProvider;
import cm.aptoide.pt.dataprovider.ws.v2.aptwords.GetAdsRequest;
import cm.aptoide.pt.dataprovider.ws.v2.aptwords.Location;
import cm.aptoide.pt.networking.IdsRepository;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.utils.q.QManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class AdsRepository {
    private final AptoideAccountManager accountManager;
    private final MinimalAdMapper adMapper;
    private final ConnectivityManager connectivityManager;
    private final Context context;
    private final Converter.Factory converterFactory;
    private final GooglePlayServicesAvailabilityChecker googlePlayServicesAvailabilityChecker;
    private final OkHttpClient httpClient;
    private final IdsRepository idsRepository;
    private final String partnerId;
    private final QManager qManager;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;
    private final AdsApplicationVersionCodeProvider versionCodeProvider;

    public AdsRepository(IdsRepository idsRepository, AptoideAccountManager aptoideAccountManager, OkHttpClient okHttpClient, Converter.Factory factory, QManager qManager, SharedPreferences sharedPreferences, Context context, ConnectivityManager connectivityManager, Resources resources, AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider, GooglePlayServicesAvailabilityChecker googlePlayServicesAvailabilityChecker, String str, MinimalAdMapper minimalAdMapper) {
        this.idsRepository = idsRepository;
        this.accountManager = aptoideAccountManager;
        this.versionCodeProvider = adsApplicationVersionCodeProvider;
        this.googlePlayServicesAvailabilityChecker = googlePlayServicesAvailabilityChecker;
        this.partnerId = str;
        this.httpClient = okHttpClient;
        this.converterFactory = factory;
        this.qManager = qManager;
        this.sharedPreferences = sharedPreferences;
        this.context = context;
        this.connectivityManager = connectivityManager;
        this.resources = resources;
        this.adMapper = minimalAdMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAdForShortcut$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e a(Account account, String str) {
        return mapRandomAd(GetAdsRequest.of(Location.homepage, "__NULL__", 10, str, this.googlePlayServicesAvailabilityChecker.isAvailable(this.context), this.partnerId, account.isAdultContentEnabled(), this.httpClient, this.converterFactory, this.qManager.getFilters(ManagerPreferences.getHWSpecsFilter(this.sharedPreferences)), this.sharedPreferences, this.connectivityManager, this.resources, this.versionCodeProvider).observe());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAdForShortcut$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e b(final Account account) {
        return this.idsRepository.getUniqueIdentifier().k(new rx.m.e() { // from class: cm.aptoide.pt.ads.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4070f.a(account, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAdsFromHomepageMore$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(Account account, boolean z, String str) {
        return mapToMinimalAds(GetAdsRequest.ofHomepageMore(str, this.googlePlayServicesAvailabilityChecker.isAvailable(this.context), this.partnerId, account.isAdultContentEnabled(), this.httpClient, this.converterFactory, this.qManager.getFilters(ManagerPreferences.getHWSpecsFilter(this.sharedPreferences)), this.sharedPreferences, this.connectivityManager, this.resources, this.versionCodeProvider).observe(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAdsFromHomepageMore$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(final boolean z, final Account account) {
        return this.idsRepository.getUniqueIdentifier().k(new rx.m.e() { // from class: cm.aptoide.pt.ads.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4057f.c(account, z, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAdsFromSearch$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(String str, Account account, String str2) {
        return mapToMinimalAd(GetAdsRequest.ofSearch(str, str2, this.googlePlayServicesAvailabilityChecker.isAvailable(this.context), this.partnerId, account.isAdultContentEnabled(), this.httpClient, this.converterFactory, this.qManager.getFilters(ManagerPreferences.getHWSpecsFilter(this.sharedPreferences)), this.sharedPreferences, this.connectivityManager, this.resources, this.versionCodeProvider).observe());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAdsFromSearch$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e f(final String str, final Account account) {
        return this.idsRepository.getUniqueIdentifier().k(new rx.m.e() { // from class: cm.aptoide.pt.ads.v
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4089f.e(str, account, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAdsFromSecondInstall$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e g(String str, Account account, String str2) {
        return mapToMinimalAd(GetAdsRequest.ofSecondInstall(str, str2, this.googlePlayServicesAvailabilityChecker.isAvailable(this.context), this.partnerId, account.isAdultContentEnabled(), this.httpClient, this.converterFactory, this.qManager.getFilters(ManagerPreferences.getHWSpecsFilter(this.sharedPreferences)), this.sharedPreferences, this.connectivityManager, this.resources, this.versionCodeProvider).observe());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAdsFromSecondInstall$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h(final String str, final Account account) {
        return this.idsRepository.getUniqueIdentifier().k(new rx.m.e() { // from class: cm.aptoide.pt.ads.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4067f.g(str, account, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAdsFromSecondTry$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e i(String str, Account account, String str2) {
        return mapToMinimalAd(GetAdsRequest.ofSecondTry(str, str2, this.googlePlayServicesAvailabilityChecker.isAvailable(this.context), this.partnerId, account.isAdultContentEnabled(), this.httpClient, this.converterFactory, this.qManager.getFilters(ManagerPreferences.getHWSpecsFilter(this.sharedPreferences)), this.sharedPreferences, this.connectivityManager, this.resources, this.versionCodeProvider).observe());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAdsFromSecondTry$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e j(final String str, final Account account) {
        return this.idsRepository.getUniqueIdentifier().k(new rx.m.e() { // from class: cm.aptoide.pt.ads.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4064f.i(str, account, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadAdsFromAppView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e k(String str, String str2, Account account, String str3) {
        return mapToMinimalAd(GetAdsRequest.ofAppviewOrganic(str, str2, str3, this.googlePlayServicesAvailabilityChecker.isAvailable(this.context), this.partnerId, account.isAdultContentEnabled(), this.httpClient, this.converterFactory, this.qManager.getFilters(ManagerPreferences.getHWSpecsFilter(this.sharedPreferences)), this.sharedPreferences, this.connectivityManager, this.resources, this.versionCodeProvider).observe());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadAdsFromAppView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e l(final String str, final String str2, final Account account) {
        return this.idsRepository.getUniqueIdentifier().k(new rx.m.e() { // from class: cm.aptoide.pt.ads.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4060f.k(str, str2, account, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadAdsFromAppviewSuggested$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e m(List list, String str, Account account, String str2) {
        return mapToMinimalAds(GetAdsRequest.ofAppviewSuggested(list, str2, this.googlePlayServicesAvailabilityChecker.isAvailable(this.context), str, this.partnerId, account.isAdultContentEnabled(), this.httpClient, this.converterFactory, this.qManager.getFilters(ManagerPreferences.getHWSpecsFilter(this.sharedPreferences)), this.sharedPreferences, this.connectivityManager, this.resources, this.versionCodeProvider).observe()).I0(Schedulers.io());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadAdsFromAppviewSuggested$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e n(final List list, final String str, final Account account) {
        return this.idsRepository.getUniqueIdentifier().k(new rx.m.e() { // from class: cm.aptoide.pt.ads.w
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4092f.m(list, str, account, (String) obj);
            }
        });
    }

    static /* synthetic */ rx.e lambda$mapRandomAd$21(Random random, List list) {
        return !validAds((List<GetAdsResponse.Ad>) list) ? rx.e.C(new IllegalStateException("Invalid ads returned from server")) : rx.e.S((GetAdsResponse.Ad) list.get(random.nextInt(10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$mapRandomAd$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ MinimalAd o(GetAdsResponse.Ad ad) {
        return this.adMapper.map(ad);
    }

    static /* synthetic */ rx.e lambda$mapToMinimalAd$3(List list) {
        return !validAds((List<GetAdsResponse.Ad>) list) ? rx.e.C(new IllegalStateException("Invalid ads returned from server")) : rx.e.S((GetAdsResponse.Ad) list.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$mapToMinimalAd$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ MinimalAd p(GetAdsResponse.Ad ad) {
        return this.adMapper.map(ad);
    }

    static /* synthetic */ rx.e lambda$mapToMinimalAds$7(GetAdsResponse getAdsResponse) {
        return !validAds(getAdsResponse) ? rx.e.C(new IllegalStateException("Invalid ads returned from server")) : rx.e.S(getAdsResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$mapToMinimalAds$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ List q(List list) {
        LinkedList linkedList = new LinkedList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(this.adMapper.map((GetAdsResponse.Ad) it.next()));
        }
        return linkedList;
    }

    private rx.e<MinimalAd> mapRandomAd(rx.e<GetAdsResponse> eVar) {
        final Random random = new Random();
        return eVar.X(new rx.m.e() { // from class: cm.aptoide.pt.ads.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((GetAdsResponse) obj).getAds();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.ads.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AdsRepository.lambda$mapRandomAd$21(random, (List) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.ads.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4053f.o((GetAdsResponse.Ad) obj);
            }
        });
    }

    private rx.e<MinimalAd> mapToMinimalAd(rx.e<GetAdsResponse> eVar) {
        return eVar.X(new rx.m.e() { // from class: cm.aptoide.pt.ads.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((GetAdsResponse) obj).getAds();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.ads.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AdsRepository.lambda$mapToMinimalAd$3((List) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.ads.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4052f.p((GetAdsResponse.Ad) obj);
            }
        });
    }

    private rx.e<List<MinimalAd>> mapToMinimalAds(rx.e<GetAdsResponse> eVar) {
        return eVar.G(new rx.m.e() { // from class: cm.aptoide.pt.ads.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AdsRepository.lambda$mapToMinimalAds$7((GetAdsResponse) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.ads.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((GetAdsResponse) obj).getAds();
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.ads.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4079f.q((List) obj);
            }
        });
    }

    public static boolean validAds(List<GetAdsResponse.Ad> list) {
        return (list == null || list.isEmpty() || list.get(0) == null || list.get(0).getPartner() == null || list.get(0).getPartner().getData() == null) ? false : true;
    }

    public rx.e<MinimalAd> getAdForShortcut() {
        return this.accountManager.accountStatus().E().G(new rx.m.e() { // from class: cm.aptoide.pt.ads.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4073f.b((Account) obj);
            }
        });
    }

    public rx.e<List<MinimalAd>> getAdsFromHomepageMore(final boolean z) {
        return this.accountManager.accountStatus().E().G(new rx.m.e() { // from class: cm.aptoide.pt.ads.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4077f.d(z, (Account) obj);
            }
        });
    }

    public rx.e<MinimalAd> getAdsFromSearch(final String str) {
        return this.accountManager.accountStatus().E().G(new rx.m.e() { // from class: cm.aptoide.pt.ads.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4050f.f(str, (Account) obj);
            }
        });
    }

    public rx.e<MinimalAd> getAdsFromSecondInstall(final String str) {
        return this.accountManager.accountStatus().E().G(new rx.m.e() { // from class: cm.aptoide.pt.ads.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4080f.h(str, (Account) obj);
            }
        });
    }

    public rx.e<MinimalAd> getAdsFromSecondTry(final String str) {
        return this.accountManager.accountStatus().E().G(new rx.m.e() { // from class: cm.aptoide.pt.ads.u
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4087f.j(str, (Account) obj);
            }
        });
    }

    public rx.e<MinimalAd> loadAdsFromAppView(final String str, final String str2) {
        return this.accountManager.accountStatus().E().G(new rx.m.e() { // from class: cm.aptoide.pt.ads.r
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4082f.l(str, str2, (Account) obj);
            }
        });
    }

    public rx.e<List<MinimalAd>> loadAdsFromAppviewSuggested(final String str, final List<String> list) {
        return this.accountManager.accountStatus().E().G(new rx.m.e() { // from class: cm.aptoide.pt.ads.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4074f.n(list, str, (Account) obj);
            }
        });
    }

    public static boolean validAds(GetAdsResponse getAdsResponse) {
        return getAdsResponse != null && validAds(getAdsResponse.getAds());
    }
}
