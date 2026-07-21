package cm.aptoide.pt.promotions;

import android.content.SharedPreferences;
import cm.aptoide.pt.aab.Split;
import cm.aptoide.pt.aab.SplitsMapper;
import cm.aptoide.pt.dataprovider.exception.AptoideWsV7Exception;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.ClaimPromotionRequest;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPackagePromotionsRequest;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPackagePromotionsResponse;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionAppsRequest;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionAppsResponse;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionsRequest;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionsResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class PromotionsService {
    private static final String ALREADY_CLAIMED = "PROMOTION-3";
    private static final String WALLET_NOT_VERIFIED = "PROMOTION-5";
    private static final String WRONG_ADDRESS = "PROMOTION-2";
    private final BodyInterceptor<BaseBody> bodyInterceptorPoolV7;
    private final Converter.Factory converterFactory;
    private final OkHttpClient okHttpClient;
    private final SharedPreferences sharedPreferences;
    private final SplitsMapper splitsMapper;
    private final TokenInvalidator tokenInvalidator;
    private String walletAddress;

    public PromotionsService(BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, TokenInvalidator tokenInvalidator, Converter.Factory factory, SharedPreferences sharedPreferences, SplitsMapper splitsMapper) {
        this.bodyInterceptorPoolV7 = bodyInterceptor;
        this.okHttpClient = okHttpClient;
        this.tokenInvalidator = tokenInvalidator;
        this.converterFactory = factory;
        this.sharedPreferences = sharedPreferences;
        this.splitsMapper = splitsMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$claimPromotion$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ ClaimStatusWrapper a(Throwable th) {
        if (th instanceof AptoideWsV7Exception) {
            return mapClaim(((AptoideWsV7Exception) th).getBaseResponse());
        }
        throw new RuntimeException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: map, reason: merged with bridge method [inline-methods] */
    public List<PromotionMeta> b(GetPromotionsResponse getPromotionsResponse) {
        ArrayList arrayList = new ArrayList();
        if (getPromotionsResponse.getDataList() != null && getPromotionsResponse.getDataList().getList() != null) {
            for (GetPromotionsResponse.PromotionModel promotionModel : getPromotionsResponse.getDataList().getList()) {
                arrayList.add(new PromotionMeta(promotionModel.getTitle(), promotionModel.getPromotionId(), promotionModel.getType(), promotionModel.getBackground(), promotionModel.getDialogDescription(), promotionModel.getDescription()));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ClaimStatusWrapper mapClaim(BaseV7Response baseV7Response) {
        return new ClaimStatusWrapper(mapStatus(baseV7Response.getInfo().getStatus()), mapError(baseV7Response.getErrors()));
    }

    private List<ClaimStatusWrapper.Error> mapError(List<BaseV7Response.Error> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (BaseV7Response.Error error : list) {
                if (error.getCode().equals(WRONG_ADDRESS)) {
                    arrayList.add(ClaimStatusWrapper.Error.WRONG_ADDRESS);
                } else if (error.getCode().equals(ALREADY_CLAIMED)) {
                    arrayList.add(ClaimStatusWrapper.Error.PROMOTION_CLAIMED);
                } else if (error.getCode().equals(WALLET_NOT_VERIFIED)) {
                    arrayList.add(ClaimStatusWrapper.Error.WALLET_NOT_VERIFIED);
                } else {
                    arrayList.add(ClaimStatusWrapper.Error.GENERIC);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<PromotionApp> mapPromotionsResponse(GetPromotionAppsResponse getPromotionAppsResponse) {
        ArrayList arrayList = new ArrayList();
        if (getPromotionAppsResponse != null && getPromotionAppsResponse.getDataList() != null && getPromotionAppsResponse.getDataList().getList() != null) {
            for (Iterator<GetPromotionAppsResponse.PromotionAppModel> it = getPromotionAppsResponse.getDataList().getList().iterator(); it.hasNext(); it = it) {
                GetPromotionAppsResponse.PromotionAppModel next = it.next();
                arrayList.add(new PromotionApp(next.getApp().getName(), next.getApp().getPackageName(), next.getApp().getId(), next.getApp().getFile().getPath(), next.getApp().getFile().getPathAlt(), next.getApp().getIcon(), next.getPromotionDescription(), next.getApp().getSize(), next.getApp().getStats().getRating().getAvg(), next.getApp().getStats().getDownloads(), next.getApp().getFile().getMd5sum(), next.getApp().getFile().getVercode(), next.isClaimed(), next.getApp().getFile().getVername(), next.getApp().getObb(), next.getAppc(), next.getApp().getFile().getSignature().getSha1(), next.getApp().hasAdvertising() || next.getApp().hasBilling(), next.getApp().hasSplits() ? this.splitsMapper.mapSplits(next.getApp().getAab().getSplits()) : Collections.emptyList(), next.getApp().hasSplits() ? next.getApp().getAab().getRequiredSplits() : Collections.emptyList(), next.getApp().getFile().getMalware().getRank().toString(), next.getApp().getStore().getName(), next.getFiat().getAmount(), next.getFiat().getSymbol(), next.getApp().getBdsFlags()));
            }
        }
        return arrayList;
    }

    private ClaimStatusWrapper.Status mapStatus(BaseV7Response.Info.Status status) {
        return status.equals(BaseV7Response.Info.Status.OK) ? ClaimStatusWrapper.Status.OK : ClaimStatusWrapper.Status.FAIL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Promotion> mapToPromotion(GetPackagePromotionsResponse getPackagePromotionsResponse) {
        ArrayList arrayList = new ArrayList();
        if (getPackagePromotionsResponse != null && getPackagePromotionsResponse.getDataList() != null && getPackagePromotionsResponse.getDataList().getList() != null) {
            for (GetPackagePromotionsResponse.PromotionAppModel promotionAppModel : getPackagePromotionsResponse.getDataList().getList()) {
                arrayList.add(new Promotion(promotionAppModel.isClaimed(), promotionAppModel.getAppc(), promotionAppModel.getPackageName(), promotionAppModel.getPromotionId(), Collections.emptyList()));
            }
        }
        return arrayList;
    }

    public Single<ClaimStatusWrapper> claimPromotion(String str, String str2, String str3) {
        return ClaimPromotionRequest.of(str, str2, str3, this.bodyInterceptorPoolV7, this.okHttpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(true).X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.w6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7202f.mapClaim((BaseV7Response) obj);
            }
        }).p0(new rx.m.e() { // from class: cm.aptoide.pt.promotions.t6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7176f.a((Throwable) obj);
            }
        }).Z0();
    }

    public Single<List<PromotionApp>> getPromotionApps(String str) {
        return GetPromotionAppsRequest.of(str, this.bodyInterceptorPoolV7, this.okHttpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(false, false).X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.v6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7194f.mapPromotionsResponse((GetPromotionAppsResponse) obj);
            }
        }).Z0();
    }

    public Single<List<PromotionMeta>> getPromotions(String str) {
        return GetPromotionsRequest.of(str, this.bodyInterceptorPoolV7, this.okHttpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe().X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.s6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7168f.b((GetPromotionsResponse) obj);
            }
        }).Z0();
    }

    public Single<List<Promotion>> getPromotionsForPackage(String str) {
        return GetPackagePromotionsRequest.of(str, this.bodyInterceptorPoolV7, this.okHttpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(false, false).X(new rx.m.e() { // from class: cm.aptoide.pt.promotions.u6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7185f.mapToPromotion((GetPackagePromotionsResponse) obj);
            }
        }).Z0();
    }

    public String getWalletAddress() {
        return this.walletAddress;
    }

    public void saveWalletAddress(String str) {
        this.walletAddress = str;
    }

    private List<Split> map(List<cm.aptoide.pt.dataprovider.model.v7.Split> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (cm.aptoide.pt.dataprovider.model.v7.Split split : list) {
            arrayList.add(new Split(split.getName(), split.getType(), split.getPath(), split.getFilesize(), split.getMd5sum()));
        }
        return arrayList;
    }
}
