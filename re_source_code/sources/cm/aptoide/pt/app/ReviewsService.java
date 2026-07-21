package cm.aptoide.pt.app;

import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.exception.NoNetworkConnectionException;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.ListReviews;
import cm.aptoide.pt.dataprovider.model.v7.Review;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.ListReviewsRequest;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class ReviewsService {
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Converter.Factory converterFactory;
    private final OkHttpClient httpClient;
    private boolean loading;
    private final SharedPreferences sharedPreferences;
    private final StoreCredentialsProvider storeCredentialsProvider;
    private final TokenInvalidator tokenInvalidator;

    public ReviewsService(StoreCredentialsProvider storeCredentialsProvider, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        this.storeCredentialsProvider = storeCredentialsProvider;
        this.bodyInterceptor = bodyInterceptor;
        this.httpClient = okHttpClient;
        this.converterFactory = factory;
        this.tokenInvalidator = tokenInvalidator;
        this.sharedPreferences = sharedPreferences;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createReviewRequestResultError, reason: merged with bridge method [inline-methods] */
    public ReviewRequestResult e(Throwable th) {
        return th instanceof NoNetworkConnectionException ? new ReviewRequestResult(ReviewRequestResult.Error.NETWORK) : new ReviewRequestResult(ReviewRequestResult.Error.GENERIC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadReviews$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a() {
        this.loading = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadReviews$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() {
        this.loading = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadReviews$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c() {
        this.loading = false;
    }

    private List<AppReview> map(List<Review> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Review review : list) {
                Review.Stats stats = review.getStats();
                Review.User user = review.getUser();
                arrayList.add(new AppReview(review.getId(), review.getTitle(), review.getBody(), review.getAdded(), review.getModified(), new ReviewStats(stats.getComments(), stats.getLikes(), stats.getPoints(), stats.getRating()), new ReviewComment(review.getComments().getView(), review.getComments().getTotal()), new ReviewUser(user.getId(), user.getAvatar(), user.getName())));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: mapListReviews, reason: merged with bridge method [inline-methods] */
    public rx.e<ReviewRequestResult> d(ListReviews listReviews) {
        return listReviews.isOk() ? rx.e.S(new ReviewRequestResult(map(listReviews.getDataList().getList()))) : rx.e.C(new IllegalStateException("Could not obtain request from server."));
    }

    public Single<ReviewRequestResult> loadReviews(String str, String str2, int i2, String str3) {
        return this.loading ? Single.m(new ReviewRequestResult(true)) : ListReviewsRequest.ofTopReviews(str, str2, i2, this.storeCredentialsProvider.get(str), this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, str3).observe().y(new rx.m.a() { // from class: cm.aptoide.pt.app.v0
            @Override // rx.m.a
            public final void call() {
                this.f4184f.a();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.app.t0
            @Override // rx.m.a
            public final void call() {
                this.f4180f.b();
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.app.r0
            @Override // rx.m.a
            public final void call() {
                this.f4171f.c();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.app.s0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4173f.d((ListReviews) obj);
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.app.u0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4181f.e((Throwable) obj);
            }
        });
    }
}
