package cm.aptoide.pt.comments.view;

import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.fragment.app.FragmentManager;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.comments.CommentAdder;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener;
import cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.model.v7.ListComments;
import cm.aptoide.pt.dataprovider.model.v7.Review;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.ListCommentsRequest;
import cm.aptoide.pt.dataprovider.ws.v7.SetReviewRatingRequest;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.navigator.ActivityResultNavigator;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.design.ShowMessage;
import cm.aptoide.pt.view.recycler.widget.Widget;
import java.util.Iterator;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class RateAndReviewCommentWidget extends Widget<RateAndReviewCommentDisplayable> {
    private static final int FULL_COMMENTS_LIMIT = 3;
    private static final String TAG = "RateAndReviewCommentWidget";
    private AptoideAccountManager accountManager;
    private AccountNavigator accountNavigator;
    private BodyInterceptor<BaseBody> bodyInterceptor;
    private Converter.Factory converterFactory;
    private ImageView helpfulButton;
    private OkHttpClient httpClient;
    private boolean isCommentsCollapsed;
    private ImageView notHelpfulButton;
    private AppCompatRatingBar ratingBar;
    private TextView reply;
    private TextView reviewDate;
    private TextView reviewText;
    private TextView reviewTitle;
    private TextView showHideReplies;
    private TokenInvalidator tokenInvalidator;
    private ImageView userImage;
    private TextView username;

    public RateAndReviewCommentWidget(View view) {
        super(view);
        this.isCommentsCollapsed = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(CommentAdder commentAdder, long j2, com.trello.rxlifecycle.g.b bVar) {
        ManagerPreferences.setForceServerRefreshFlag(true, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences());
        commentAdder.collapseComments();
        loadCommentsForThisReview(j2, 3, commentAdder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Review review, Void r3) {
        setReviewRating(review.getId(), false);
    }

    static /* synthetic */ void lambda$bindView$12(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(Review review, RateAndReviewCommentDisplayable rateAndReviewCommentDisplayable, Void r6) {
        if (this.isCommentsCollapsed) {
            loadCommentsForThisReview(review.getId(), 3, rateAndReviewCommentDisplayable.getCommentAdder());
            this.showHideReplies.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_up_arrow, 0);
            this.isCommentsCollapsed = false;
        } else {
            rateAndReviewCommentDisplayable.getCommentAdder().collapseComments();
            this.showHideReplies.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_down_arrow, 0);
            this.isCommentsCollapsed = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(View view) {
        this.accountNavigator.navigateToAccountView(AccountAnalytics.AccountOrigins.REPLY_REVIEW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(androidx.fragment.app.d dVar, Review review, String str, final CommentAdder commentAdder, final long j2, Void r9) {
        if (!this.accountManager.isLoggedIn()) {
            return ShowMessage.asObservableSnack(this.ratingBar, R.string.you_need_to_be_logged_in, R.string.login, new View.OnClickListener() { // from class: cm.aptoide.pt.comments.view.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f4806f.d(view);
                }
            }).M();
        }
        FragmentManager supportFragmentManager = dVar.getSupportFragmentManager();
        CommentDialogFragment commentDialogFragmentNewInstanceReviewReply = CommentDialogFragment.newInstanceReviewReply(review.getId(), str);
        commentDialogFragmentNewInstanceReviewReply.show(supportFragmentManager, "fragment_comment_dialog");
        return commentDialogFragmentNewInstanceReviewReply.lifecycle().D(new rx.m.e() { // from class: cm.aptoide.pt.comments.view.q0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((com.trello.rxlifecycle.g.b) obj).equals(com.trello.rxlifecycle.g.b.DESTROY_VIEW));
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.t0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4857f.a(commentAdder, j2, (com.trello.rxlifecycle.g.b) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.comments.view.r0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return rx.e.B();
            }
        });
    }

    static /* synthetic */ void lambda$bindView$5(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Review review, Void r3) {
        setReviewRating(review.getId(), true);
    }

    static /* synthetic */ void lambda$bindView$9(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadCommentsForThisReview$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(CommentAdder commentAdder, ListComments listComments) {
        if (listComments.isOk()) {
            commentAdder.addComment(listComments.getDataList().getList());
        } else {
            Logger.getInstance().e(TAG, "error loading comments");
            ShowMessage.asSnack(this.helpfulButton, R.string.unknown_error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadCommentsForThisReview$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(Throwable th) {
        Logger.getInstance().e(TAG, th);
        ShowMessage.asSnack(this.helpfulButton, R.string.unknown_error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setReviewRating$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(long j2, boolean z, BaseV7Response baseV7Response) {
        if (baseV7Response == null) {
            Logger.getInstance().e(TAG, "empty response");
            return;
        }
        if (baseV7Response.getError() != null) {
            Logger.getInstance().e(TAG, baseV7Response.getError().getDescription());
            return;
        }
        List<BaseV7Response.Error> errors = baseV7Response.getErrors();
        if (errors != null && !errors.isEmpty()) {
            Iterator<BaseV7Response.Error> it = errors.iterator();
            while (it.hasNext()) {
                Logger.getInstance().e(TAG, it.next().getDescription());
            }
            return;
        }
        Logger logger = Logger.getInstance();
        String str = TAG;
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j2);
        objArr[1] = z ? "positive" : "negative";
        logger.d(str, String.format("review %d was marked as %s", objArr));
        setHelpButtonsClickable(true);
        ShowMessage.asSnack(this.helpfulButton, R.string.thank_you_for_your_opinion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setReviewRating$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Throwable th) {
        ShowMessage.asSnack(this.helpfulButton, R.string.unknown_error);
        Logger.getInstance().e(TAG, th);
        setHelpButtonsClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setReviewRating$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(View view) {
        this.accountNavigator.navigateToAccountView(AccountAnalytics.AccountOrigins.REVIEW_FEEDBACK);
    }

    private void loadCommentsForThisReview(long j2, int i2, final CommentAdder commentAdder) {
        ListCommentsRequest.of(j2, i2, true, this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences()).execute(new SuccessRequestListener() { // from class: cm.aptoide.pt.comments.view.l0
            @Override // cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener, rx.m.b
            public final void call(Object obj) {
                this.f4832f.g(commentAdder, (ListComments) obj);
            }
        }, new ErrorRequestListener() { // from class: cm.aptoide.pt.comments.view.n0
            @Override // cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener
            public final void onError(Throwable th) {
                this.a.h(th);
            }
        }, true);
    }

    private void setHelpButtonsClickable(boolean z) {
        this.notHelpfulButton.setClickable(z);
        this.helpfulButton.setClickable(z);
    }

    private void setReviewRating(final long j2, final boolean z) {
        setHelpButtonsClickable(false);
        if (this.accountManager.isLoggedIn()) {
            SetReviewRatingRequest.of(j2, z, this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences()).execute(new SuccessRequestListener() { // from class: cm.aptoide.pt.comments.view.o0
                @Override // cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener, rx.m.b
                public final void call(Object obj) {
                    this.f4843f.i(j2, z, (BaseV7Response) obj);
                }
            }, new ErrorRequestListener() { // from class: cm.aptoide.pt.comments.view.s0
                @Override // cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener
                public final void onError(Throwable th) {
                    this.a.j(th);
                }
            }, true);
        } else {
            ShowMessage.asSnack(getContext(), R.string.you_need_to_be_logged_in, R.string.login, new View.OnClickListener() { // from class: cm.aptoide.pt.comments.view.j0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f4823f.k(view);
                }
            }, -1);
            setHelpButtonsClickable(true);
        }
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.reply = (TextView) view.findViewById(R.id.write_reply_btn);
        this.showHideReplies = (TextView) view.findViewById(R.id.show_replies_btn);
        this.ratingBar = (AppCompatRatingBar) view.findViewById(R.id.rating_bar);
        this.reviewTitle = (TextView) view.findViewById(R.id.comment_title);
        this.reviewDate = (TextView) view.findViewById(R.id.added_date);
        this.reviewText = (TextView) view.findViewById(R.id.comment);
        this.userImage = (ImageView) view.findViewById(R.id.user_icon);
        this.username = (TextView) view.findViewById(R.id.user_name);
        this.helpfulButton = (ImageView) view.findViewById(R.id.helpful_button);
        this.notHelpfulButton = (ImageView) view.findViewById(R.id.not_helpful_button);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(final RateAndReviewCommentDisplayable rateAndReviewCommentDisplayable, int i2) {
        final Review review = rateAndReviewCommentDisplayable.getPojo().getReview();
        final String appName = rateAndReviewCommentDisplayable.getPojo().getAppName();
        this.tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        this.httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        this.converterFactory = WebService.getDefaultConverter();
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        this.bodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        this.accountNavigator = ((ActivityResultNavigator) getContext()).getAccountNavigator();
        final androidx.fragment.app.d context = getContext();
        ImageLoader.with(context).loadWithCircleTransformAndPlaceHolderAvatarSize(review.getUser().getAvatar(), this.userImage, R.drawable.layer_1);
        this.username.setText(review.getUser().getName());
        this.ratingBar.setRating(review.getStats().getRating());
        this.reviewTitle.setText(review.getTitle());
        this.reviewText.setText(review.getBody());
        this.reviewDate.setText(AptoideUtils.DateTimeU.getInstance(getContext()).getTimeDiffString(context, review.getAdded().getTime(), getContext().getResources()));
        final CommentAdder commentAdder = rateAndReviewCommentDisplayable.getCommentAdder();
        final long id = review.getId();
        this.compositeSubscription.a(e.g.a.c.a.a(this.reply).G(new rx.m.e() { // from class: cm.aptoide.pt.comments.view.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4795f.e(context, review, appName, commentAdder, id, (Void) obj);
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.h0
            @Override // rx.m.b
            public final void call(Object obj) {
                RateAndReviewCommentWidget.lambda$bindView$5(obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.comments.view.u0
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }));
        this.compositeSubscription.a(e.g.a.c.a.a(this.helpfulButton).x(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.p0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4847f.f(review, (Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.f0
            @Override // rx.m.b
            public final void call(Object obj) {
                rateAndReviewCommentDisplayable.sendVoteUpEvent();
            }
        }).G0(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.v0
            @Override // rx.m.b
            public final void call(Object obj) {
                RateAndReviewCommentWidget.lambda$bindView$9((Void) obj);
            }
        }));
        this.compositeSubscription.a(e.g.a.c.a.a(this.notHelpfulButton).x(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.k0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4828f.b(review, (Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.m0
            @Override // rx.m.b
            public final void call(Object obj) {
                rateAndReviewCommentDisplayable.sendVoteDownEvent();
            }
        }).G0(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.i0
            @Override // rx.m.b
            public final void call(Object obj) {
                RateAndReviewCommentWidget.lambda$bindView$12((Void) obj);
            }
        }));
        this.compositeSubscription.a(e.g.a.c.a.a(this.showHideReplies).G0(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.w0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4867f.c(review, rateAndReviewCommentDisplayable, (Void) obj);
            }
        }));
        Resources.Theme theme = context.getTheme();
        Resources resources = context.getResources();
        TypedValue typedValue = new TypedValue();
        TypedValue typedValue2 = new TypedValue();
        theme.resolveAttribute(R.attr.widgetBackgroundColorPrimary, typedValue, true);
        theme.resolveAttribute(R.attr.widgetBackgroundColorSecondary, typedValue2, true);
        int i3 = getItemId() % 2 == 0 ? typedValue.resourceId : typedValue2.resourceId;
        if (Build.VERSION.SDK_INT >= 23) {
            this.itemView.setBackgroundColor(resources.getColor(i3, theme));
        } else {
            this.itemView.setBackgroundColor(resources.getColor(i3));
        }
        int numberComments = rateAndReviewCommentDisplayable.getNumberComments();
        if (numberComments <= 0) {
            this.showHideReplies.setVisibility(8);
        } else {
            this.showHideReplies.setVisibility(0);
            this.showHideReplies.setText(AptoideUtils.StringU.getFormattedString(R.string.reviews_expand_button, getContext().getResources(), Integer.valueOf(numberComments)));
        }
    }
}
