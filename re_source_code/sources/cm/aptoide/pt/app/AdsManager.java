package cm.aptoide.pt.app;

import cm.aptoide.pt.ads.AdsRepository;
import cm.aptoide.pt.ads.MinimalAd;
import cm.aptoide.pt.ads.MinimalAdMapper;
import cm.aptoide.pt.database.RoomStoredMinimalAdPersistence;
import cm.aptoide.pt.dataprovider.ads.AdNetworkUtils;
import cm.aptoide.pt.dataprovider.exception.NoNetworkConnectionException;
import cm.aptoide.pt.search.model.SearchAdResult;
import cm.aptoide.pt.view.app.AppsList;
import java.util.List;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class AdsManager {
    private final MinimalAdMapper adMapper;
    private final AdsRepository adsRepository;
    private final RoomStoredMinimalAdPersistence storedMinimalAdPersistence;

    public AdsManager(AdsRepository adsRepository, RoomStoredMinimalAdPersistence roomStoredMinimalAdPersistence, MinimalAdMapper minimalAdMapper) {
        this.adsRepository = adsRepository;
        this.storedMinimalAdPersistence = roomStoredMinimalAdPersistence;
        this.adMapper = minimalAdMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createMinimalAdRequestResultError, reason: merged with bridge method [inline-methods] */
    public MinimalAdRequestResult a(Throwable th) {
        return th instanceof NoNetworkConnectionException ? new MinimalAdRequestResult(AppsList.Error.NETWORK) : new MinimalAdRequestResult(AppsList.Error.GENERIC);
    }

    public void handleAdsLogic(SearchAdResult searchAdResult) {
        this.storedMinimalAdPersistence.insert(this.adMapper.map(searchAdResult, null));
        AdNetworkUtils.knockCpc(this.adMapper.map(searchAdResult));
    }

    public Single<MinimalAdRequestResult> loadAd(String str, List<String> list) {
        return this.adsRepository.loadAdsFromAppviewSuggested(str, list).G(new rx.m.e() { // from class: cm.aptoide.pt.app.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return rx.e.S(new MinimalAdRequestResult((MinimalAd) ((List) obj).get(0)));
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.app.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4107f.a((Throwable) obj);
            }
        });
    }

    public Single<MinimalAd> loadAds(String str, String str2) {
        return this.adsRepository.loadAdsFromAppView(str, str2).Z0();
    }
}
