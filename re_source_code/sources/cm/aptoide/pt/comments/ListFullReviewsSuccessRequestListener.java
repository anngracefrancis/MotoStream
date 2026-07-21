package cm.aptoide.pt.comments;

import android.content.SharedPreferences;
import cm.aptoide.pt.UserFeedbackAnalytics;
import cm.aptoide.pt.comments.view.CommentsAdapter;
import cm.aptoide.pt.comments.view.ConcreteItemCommentAdder;
import cm.aptoide.pt.comments.view.RateAndReviewCommentDisplayable;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.ListComments;
import cm.aptoide.pt.dataprovider.model.v7.ListReviews;
import cm.aptoide.pt.dataprovider.model.v7.Review;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.ListCommentsRequest;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.store.StoreUtils;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import java.util.LinkedList;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.e;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class ListFullReviewsSuccessRequestListener implements SuccessRequestListener<ListReviews> {
    private final BodyInterceptor<BaseBody> bodyBodyInterceptor;
    private final Converter.Factory converterFactory;
    private final RateAndReviewsFragment fragment;
    private final OkHttpClient httpClient;
    private final SharedPreferences sharedPreferences;
    private final StoreCredentialsProvider storeCredentialsProvider;
    private final TokenInvalidator tokenInvalidator;
    private final UserFeedbackAnalytics userFeedbackAnalytics;

    public ListFullReviewsSuccessRequestListener(RateAndReviewsFragment rateAndReviewsFragment, StoreCredentialsProvider storeCredentialsProvider, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, UserFeedbackAnalytics userFeedbackAnalytics) {
        this.fragment = rateAndReviewsFragment;
        this.httpClient = okHttpClient;
        this.storeCredentialsProvider = storeCredentialsProvider;
        this.bodyBodyInterceptor = bodyInterceptor;
        this.converterFactory = factory;
        this.tokenInvalidator = tokenInvalidator;
        this.sharedPreferences = sharedPreferences;
        this.userFeedbackAnalytics = userFeedbackAnalytics;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addRateAndReviewDisplayables(List<Review> list, List<Displayable> list2) {
        int i2 = -1;
        int i3 = 0;
        for (Review review : list) {
            list2.add(new RateAndReviewCommentDisplayable(new ReviewWithAppName(this.fragment.getAppName(), review), new ConcreteItemCommentAdder(i3, this.fragment, review), review.getCommentList().getTotal(), this.userFeedbackAnalytics));
            if (review.getId() == this.fragment.getReviewId()) {
                i2 = i3;
            }
            if (review.getCommentList() != null && review.getCommentList().getDataList() != null && review.getCommentList().getDataList().getLimit() != null) {
                this.fragment.createDisplayableComments(review.getCommentList().getDataList().getList(), list2);
                if (review.getCommentList().getDataList().getList().size() > 2) {
                    list2.add(this.fragment.createReadMoreDisplayable(i3, review));
                }
            }
            i3++;
        }
        int i4 = ((CommentsAdapter) this.fragment.getAdapter()).getItemCount() != 0 ? i2 : 0;
        this.fragment.checkAndRemoveProgressBarDisplayable();
        this.fragment.addDisplayables(list2);
        if (i4 >= 0) {
            this.fragment.getLayoutManager().scrollToPosition(((CommentsAdapter) this.fragment.getAdapter()).getItemPosition(i4));
        }
    }

    static /* synthetic */ Review lambda$call$0(Review review, ListComments listComments) {
        review.setCommentList(listComments);
        return review;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$call$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ e a(final Review review) {
        return ListCommentsRequest.of(review.getComments().getView(), review.getId(), 3, StoreUtils.getStoreCredentials(this.fragment.getStoreName(), this.storeCredentialsProvider), true, this.bodyBodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe().I0(Schedulers.io()).X(new rx.m.e() { // from class: cm.aptoide.pt.comments.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                Review review2 = review;
                ListFullReviewsSuccessRequestListener.lambda$call$0(review2, (ListComments) obj);
                return review2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$call$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(List list, List list2, List list3) {
        addRateAndReviewDisplayables(list, list2);
    }

    @Override // cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener, rx.m.b
    public void call(ListReviews listReviews) {
        final List<Review> list = listReviews.getDataList().getList();
        final LinkedList linkedList = new LinkedList();
        e.N(list).G(new rx.m.e() { // from class: cm.aptoide.pt.comments.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4773f.a((Review) obj);
            }
        }).Y0().j0(rx.l.c.a.b()).f(this.fragment.bindUntilEvent(com.trello.rxlifecycle.g.b.DESTROY_VIEW)).H0(new rx.m.b() { // from class: cm.aptoide.pt.comments.b
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4770f.b(list, linkedList, (List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.comments.a
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
    }
}
