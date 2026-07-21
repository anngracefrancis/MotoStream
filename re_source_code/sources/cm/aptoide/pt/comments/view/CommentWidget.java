package cm.aptoide.pt.comments.view;

import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.comments.ComplexComment;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.model.v7.Comment;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.recycler.widget.Widget;
import com.google.android.material.snackbar.Snackbar;

/* JADX INFO: loaded from: classes.dex */
public class CommentWidget extends Widget<CommentDisplayable> {
    private static final int MARGIN_IN_DIP = 15;
    private TextView comment;
    private TextView datePos1;
    private TextView datePos2;
    private View outerLayout;
    private View replyLayout;
    private ImageView userAvatar;
    private TextView userName;

    public CommentWidget(View view) {
        super(view);
    }

    private void bindComplexComment(final ComplexComment complexComment) {
        androidx.fragment.app.d context = getContext();
        Resources.Theme theme = context.getTheme();
        TypedValue typedValue = new TypedValue();
        TypedValue typedValue2 = new TypedValue();
        theme.resolveAttribute(R.attr.widgetBackgroundColorPrimary, typedValue, true);
        theme.resolveAttribute(R.attr.widgetBackgroundColorSecondary, typedValue2, true);
        int i2 = complexComment.getLevel() == 1 ? typedValue.resourceId : typedValue2.resourceId;
        this.outerLayout.setBackgroundColor(Build.VERSION.SDK_INT >= 23 ? context.getColor(i2) : context.getResources().getColor(i2));
        setLayoutLeftPadding(complexComment);
        if (complexComment.getLevel() == 1) {
            this.replyLayout.setVisibility(0);
            this.compositeSubscription.a(e.g.a.c.a.a(this.replyLayout).G(new rx.m.e() { // from class: cm.aptoide.pt.comments.view.b0
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return this.f4781f.b(complexComment, (Void) obj);
                }
            }).s0().H0(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.x
                @Override // rx.m.b
                public final void call(Object obj) {
                    CommentWidget.lambda$bindComplexComment$5(obj);
                }
            }, new rx.m.b() { // from class: cm.aptoide.pt.comments.view.w
                @Override // rx.m.b
                public final void call(Object obj) {
                    CrashReport.getInstance().log((Throwable) obj);
                }
            }));
        } else {
            this.replyLayout.setVisibility(8);
            this.userAvatar.setScaleX(0.7f);
            this.userAvatar.setScaleY(0.7f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindComplexComment$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(Throwable th) {
        Snackbar.Z(this.userAvatar, R.string.error_occured, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindComplexComment$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e b(ComplexComment complexComment, Void r2) {
        return complexComment.observeReplySubmission().n(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.v
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4864f.a((Throwable) obj);
            }
        }).M();
    }

    static /* synthetic */ void lambda$bindComplexComment$5(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(CommentDisplayable commentDisplayable, Void r2) {
        commentDisplayable.itemClicked(this.itemView);
    }

    static /* synthetic */ void lambda$bindView$1(Void r0) {
    }

    private void setLayoutLeftPadding(ComplexComment complexComment) {
        int level = complexComment.getLevel();
        int pixelsForDip = AptoideUtils.ScreenU.getPixelsForDip(15, getContext().getResources());
        int i2 = level < 2 ? pixelsForDip : level * pixelsForDip;
        View view = this.outerLayout;
        view.setPadding(i2, view.getPaddingTop(), pixelsForDip, this.outerLayout.getPaddingBottom());
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.userAvatar = (ImageView) view.findViewById(R.id.user_icon);
        this.outerLayout = view.findViewById(R.id.outer_layout);
        this.userName = (TextView) view.findViewById(R.id.user_name);
        this.datePos1 = (TextView) view.findViewById(R.id.added_date_pos1);
        this.datePos2 = (TextView) view.findViewById(R.id.added_date_pos2);
        this.comment = (TextView) view.findViewById(R.id.comment);
        this.replyLayout = view.findViewById(R.id.reply_layout);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(final CommentDisplayable commentDisplayable, int i2) {
        Comment comment = commentDisplayable.getComment();
        androidx.fragment.app.d context = getContext();
        ImageLoader.with(context).loadWithCircleTransformAndPlaceHolderAvatarSize(comment.getUser().getAvatar(), this.userAvatar, R.drawable.layer_1);
        this.userName.setText(comment.getUser().getName());
        String timeDiffString = AptoideUtils.DateTimeU.getInstance(getContext()).getTimeDiffString(context, comment.getAdded().getTime(), getContext().getResources());
        this.datePos1.setText(timeDiffString);
        this.datePos2.setText(timeDiffString);
        this.comment.setText(comment.getBody());
        if (ComplexComment.class.isAssignableFrom(comment.getClass())) {
            this.datePos2.setVisibility(0);
            bindComplexComment((ComplexComment) comment);
        } else {
            this.datePos1.setVisibility(0);
        }
        this.compositeSubscription.a(e.g.a.c.a.a(this.itemView).x(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.a0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4776f.c(commentDisplayable, (Void) obj);
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.y
            @Override // rx.m.b
            public final void call(Object obj) {
                CommentWidget.lambda$bindView$1((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.comments.view.z
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }));
    }
}
