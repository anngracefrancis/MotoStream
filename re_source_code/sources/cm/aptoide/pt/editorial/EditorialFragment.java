package cm.aptoide.pt.editorial;

import android.animation.Animator;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.aptoideviews.errors.ErrorView;
import cm.aptoide.aptoideviews.socialmedia.SocialMediaView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.app.DownloadModel;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.reactions.ReactionEvent;
import cm.aptoide.pt.reactions.ReactionMapper;
import cm.aptoide.pt.reactions.TopReactionsPreview;
import cm.aptoide.pt.reactions.data.ReactionType;
import cm.aptoide.pt.reactions.data.TopReaction;
import cm.aptoide.pt.reactions.ui.ReactionsPopup;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.util.AppBarStateChangeListener;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.GenericDialogs;
import cm.aptoide.pt.view.NotBottomNavigationView;
import cm.aptoide.pt.view.Translator;
import cm.aptoide.pt.view.fragment.NavigationTrackFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.Snackbar;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.HttpUrl;
import rx.exceptions.OnErrorNotImplementedException;

/* JADX INFO: loaded from: classes.dex */
public class EditorialFragment extends NavigationTrackFragment implements EditorialView, NotBottomNavigationView {
    public static final String CARD_ID = "cardId";
    public static final String FROM_HOME = "fromHome";
    public static final String SLUG = "slug";
    private static final String TAG = EditorialFragment.class.getName();
    private DownloadModel.Action action;
    private CardView actionItemCard;
    private EditorialItemsAdapter adapter;
    private AppBarLayout appBarLayout;
    private Button appCardButton;
    private ImageView appCardImage;
    private View appCardLayout;
    private TextView appCardTitle;
    private View appCardView;
    private ImageView appImage;
    private Drawable backArrow;
    private ImageView cancelDownload;

    @Inject
    CaptionBackgroundPainter captionBackgroundPainter;
    private RelativeLayout cardInfoLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private View downloadControlsLayout;
    private rx.s.b<EditorialDownloadEvent> downloadEventListener;
    private LinearLayout downloadInfoLayout;
    private ProgressBar downloadProgressBar;
    private TextView downloadProgressValue;
    private RecyclerView editorialItems;
    private View editorialItemsCard;
    private rx.k errorMessageSubscription;
    private ErrorView errorView;
    private rx.s.b<Void> installClickSubject;
    private TextView itemName;
    private rx.s.b<Boolean> movingCollapseSubject;
    private DecimalFormat oneDecimalFormatter;
    private ImageView pauseDownload;
    private List<Integer> placeHolderPositions;

    @Inject
    EditorialPresenter presenter;
    private ProgressBar progressBar;
    private ImageButton reactButton;
    private rx.s.b<ReactionEvent> reactionEventListener;
    private rx.s.b<Void> ready;
    private ImageView resumeDownload;

    @Inject
    @Named
    float screenHeight;

    @Inject
    @Named
    float screenWidth;
    private NestedScrollView scrollView;
    private boolean shouldAnimate;
    private rx.s.b<Void> snackListener;
    private SocialMediaView socialMediaView;

    @Inject
    ThemeManager themeManager;
    private Toolbar toolbar;
    private TextView toolbarTitle;
    private TopReactionsPreview topReactionsPreview;
    private rx.s.b<EditorialEvent> uiEventsListener;
    private Window window;

    /* JADX INFO: renamed from: cm.aptoide.pt.editorial.EditorialFragment$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action;
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState;
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$editorial$EditorialViewModel$Error;
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State;

        static {
            int[] iArr = new int[DownloadModel.DownloadState.values().length];
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState = iArr;
            try {
                iArr[DownloadModel.DownloadState.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadModel.DownloadState.INDETERMINATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadModel.DownloadState.COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[DownloadModel.DownloadState.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[DownloadModel.Action.values().length];
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action = iArr2;
            try {
                iArr2[DownloadModel.Action.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[DownloadModel.Action.INSTALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[DownloadModel.Action.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[DownloadModel.Action.DOWNGRADE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[EditorialViewModel.Error.values().length];
            $SwitchMap$cm$aptoide$pt$editorial$EditorialViewModel$Error = iArr3;
            try {
                iArr3[EditorialViewModel.Error.NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$editorial$EditorialViewModel$Error[EditorialViewModel.Error.GENERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr4 = new int[AppBarStateChangeListener.State.values().length];
            $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State = iArr4;
            try {
                iArr4[AppBarStateChangeListener.State.EXPANDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[AppBarStateChangeListener.State.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[AppBarStateChangeListener.State.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[AppBarStateChangeListener.State.COLLAPSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    private void configureAppCardAnimation(final View view, final View view2, float f2, final int i2, final boolean z) {
        view.animate().scaleY(f2).scaleX(f2).alpha(0.0f).setDuration(i2).setListener(new Animator.AnimatorListener() { // from class: cm.aptoide.pt.editorial.EditorialFragment.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (z) {
                    return;
                }
                view.setVisibility(4);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                view2.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(i2).setListener(new Animator.AnimatorListener() { // from class: cm.aptoide.pt.editorial.EditorialFragment.2.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator2) {
                        view2.setVisibility(0);
                    }
                }).start();
            }
        }).start();
    }

    private EditorialItemsViewHolder getViewHolderForAdapterPosition(int i2) {
        RecyclerView recyclerView;
        if (i2 == -1 || (recyclerView = this.editorialItems) == null) {
            return null;
        }
        EditorialItemsViewHolder editorialItemsViewHolder = (EditorialItemsViewHolder) recyclerView.findViewHolderForAdapterPosition(i2);
        if (editorialItemsViewHolder == null) {
            Log.e(TAG, "Unable to find editorialViewHolder");
        }
        return editorialItemsViewHolder;
    }

    private void handleDownloadError(DownloadModel.DownloadState downloadState) {
        showErrorDialog(HttpUrl.FRAGMENT_ENCODE_SET, getContext().getString(R.string.error_occured));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStatusBar(boolean z) {
        if (!z) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.window.setStatusBarColor(getResources().getColor(R.color.black_87_alpha));
                this.window.getDecorView().setSystemUiVisibility(0);
                return;
            }
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            if (i2 > 23 && !this.themeManager.isThemeDark()) {
                this.window.getDecorView().setSystemUiVisibility(8192);
            }
            this.window.setStatusBarColor(getResources().getColor(this.themeManager.getAttributeForTheme(R.attr.statusBarColorSecondary).resourceId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isItemShown() {
        EditorialItemsViewHolder viewHolderForAdapterPosition;
        List<Integer> list = this.placeHolderPositions;
        return (list == null || list.isEmpty() || (viewHolderForAdapterPosition = getViewHolderForAdapterPosition(this.placeHolderPositions.get(0).intValue())) == null || !viewHolderForAdapterPosition.isVisible(this.screenHeight, this.screenWidth)) ? false : true;
    }

    static /* synthetic */ EditorialEvent lambda$appCardClicked$1(EditorialViewModel editorialViewModel, Void r4) {
        return new EditorialEvent(EditorialEvent.Type.APPCARD, editorialViewModel.getBottomCardAppId(), editorialViewModel.getBottomCardPackageName());
    }

    static /* synthetic */ EditorialDownloadEvent lambda$cancelDownload$11(EditorialViewModel editorialViewModel, Void r8) {
        return new EditorialDownloadEvent(EditorialEvent.Type.CANCEL, editorialViewModel.getBottomCardPackageName(), editorialViewModel.getBottomCardMd5(), editorialViewModel.getBottomCardVersionCode(), editorialViewModel.getBottomCardAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$installButtonClick$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ EditorialDownloadEvent e(EditorialViewModel editorialViewModel, Void r3) {
        return new EditorialDownloadEvent(editorialViewModel, this.action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onViewCreated$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        this.installClickSubject.onNext(null);
    }

    static /* synthetic */ EditorialDownloadEvent lambda$pauseDownload$7(EditorialViewModel editorialViewModel, Void r8) {
        return new EditorialDownloadEvent(EditorialEvent.Type.PAUSE, editorialViewModel.getBottomCardPackageName(), editorialViewModel.getBottomCardMd5(), editorialViewModel.getBottomCardVersionCode(), editorialViewModel.getBottomCardAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$placeHolderVisibilityChange$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean g(Object obj) {
        return Boolean.valueOf(isItemShown());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$placeHolderVisibilityChange$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h(Object obj) {
        return rx.e.S(obj).X(new rx.m.e() { // from class: cm.aptoide.pt.editorial.p
            @Override // rx.m.e
            public final Object call(Object obj2) {
                return this.f5426f.g(obj2);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.editorial.a
            @Override // rx.m.e
            public final Object call(Object obj2) {
                return new ScrollEvent((Boolean) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ EditorialDownloadEvent i(EditorialViewModel editorialViewModel, Void r10) {
        return new EditorialDownloadEvent(EditorialEvent.Type.RESUME, editorialViewModel.getBottomCardPackageName(), editorialViewModel.getBottomCardMd5(), editorialViewModel.getBottomCardVersionCode(), editorialViewModel.getBottomCardAppId(), this.action);
    }

    static /* synthetic */ void lambda$showErrorDialog$20(GenericDialogs.EResponse eResponse) {
    }

    static /* synthetic */ void lambda$showErrorDialog$21(Throwable th) {
        new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showLoginDialog$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(View view) {
        this.snackListener.onNext(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showReactionsPopup$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(String str, String str2, ReactionsPopup reactionsPopup, ReactionType reactionType) {
        this.reactionEventListener.onNext(new ReactionEvent(str, ReactionMapper.mapUserReaction(reactionType), str2));
        reactionsPopup.dismiss();
        reactionsPopup.setOnReactionsItemClickListener(null);
    }

    private void populateAppContent(EditorialViewModel editorialViewModel) {
        this.placeHolderPositions = editorialViewModel.getPlaceHolderPositions();
        this.shouldAnimate = editorialViewModel.shouldHaveAnimation();
        if (editorialViewModel.hasBackgroundImage()) {
            ImageLoader.with(getContext()).load(editorialViewModel.getBackgroundImage(), this.appImage);
        } else {
            this.appImage.setBackgroundColor(getResources().getColor(R.color.grey_fog_normal));
        }
        String caption = editorialViewModel.getCaption();
        this.toolbar.setTitle(caption);
        this.toolbarTitle.setText(editorialViewModel.getTitle());
        this.appImage.setVisibility(0);
        this.itemName.setText(Translator.translate(caption, getContext(), HttpUrl.FRAGMENT_ENCODE_SET));
        this.captionBackgroundPainter.addColorBackgroundToCaption(this.actionItemCard, editorialViewModel.getCaptionColor());
        this.itemName.setVisibility(0);
        this.actionItemCard.setVisibility(0);
        setBottomAppCardInfo(editorialViewModel);
    }

    private void populateCardContent(EditorialViewModel editorialViewModel) {
        if (editorialViewModel.hasContent()) {
            this.editorialItemsCard.setVisibility(0);
            this.adapter.add(editorialViewModel.getContentList(), editorialViewModel.shouldHaveAnimation());
        }
    }

    private void setBottomAppCardInfo(EditorialViewModel editorialViewModel) {
        if (editorialViewModel.shouldHaveAnimation()) {
            this.appCardTitle.setText(editorialViewModel.getBottomCardAppName());
            this.appCardTitle.setVisibility(0);
            ImageLoader.with(getContext()).load(editorialViewModel.getBottomCardIcon(), this.appCardImage);
            this.appCardView.setVisibility(0);
        }
    }

    private void setButtonText(DownloadModel downloadModel) {
        int i2 = AnonymousClass3.$SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[downloadModel.getAction().ordinal()];
        if (i2 == 1) {
            this.appCardButton.setText(getResources().getString(R.string.appview_button_update));
            return;
        }
        if (i2 == 2) {
            this.appCardButton.setText(getResources().getString(R.string.appview_button_install));
        } else if (i2 == 3) {
            this.appCardButton.setText(getResources().getString(R.string.appview_button_open));
        } else {
            if (i2 != 4) {
                return;
            }
            this.appCardButton.setText(getResources().getString(R.string.appview_button_downgrade));
        }
    }

    private void setDownloadState(int i2, DownloadModel.DownloadState downloadState) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 4.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1, 2.0f);
        int i3 = AnonymousClass3.$SwitchMap$cm$aptoide$pt$app$DownloadModel$DownloadState[downloadState.ordinal()];
        if (i3 == 1) {
            this.downloadProgressBar.setIndeterminate(false);
            this.downloadProgressBar.setProgress(i2);
            this.downloadProgressValue.setText(i2 + "%");
            this.pauseDownload.setVisibility(0);
            this.cancelDownload.setVisibility(8);
            this.resumeDownload.setVisibility(8);
            this.downloadControlsLayout.setLayoutParams(layoutParams);
            return;
        }
        if (i3 == 2 || i3 == 3) {
            this.downloadProgressBar.setIndeterminate(true);
            this.pauseDownload.setVisibility(0);
            this.cancelDownload.setVisibility(8);
            this.resumeDownload.setVisibility(8);
            this.downloadControlsLayout.setLayoutParams(layoutParams);
            return;
        }
        if (i3 != 4) {
            return;
        }
        this.downloadProgressBar.setIndeterminate(false);
        this.downloadProgressBar.setProgress(i2);
        this.downloadProgressValue.setText(i2 + "%");
        this.pauseDownload.setVisibility(8);
        this.cancelDownload.setVisibility(0);
        this.resumeDownload.setVisibility(0);
        this.downloadControlsLayout.setLayoutParams(layoutParams2);
    }

    private void showErrorDialog(String str, String str2) {
        this.errorMessageSubscription = GenericDialogs.createGenericOkMessage(getContext(), str, str2, this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId).I0(rx.l.c.a.b()).H0(new rx.m.b() { // from class: cm.aptoide.pt.editorial.s
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialFragment.lambda$showErrorDialog$20((GenericDialogs.EResponse) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.editorial.v
            @Override // rx.m.b
            public final void call(Object obj) {
                EditorialFragment.lambda$showErrorDialog$21((Throwable) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<EditorialEvent> actionButtonClicked() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((EditorialEvent) obj).getClickType().equals(EditorialEvent.Type.ACTION));
            }
        });
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void addBottomCardAnimation() {
        EditorialItemsViewHolder viewHolderForAdapterPosition;
        View placeHolder;
        List<Integer> list = this.placeHolderPositions;
        if (list == null || list.isEmpty() || (viewHolderForAdapterPosition = getViewHolderForAdapterPosition(this.placeHolderPositions.get(0).intValue())) == null || (placeHolder = viewHolderForAdapterPosition.getPlaceHolder()) == null || !this.shouldAnimate) {
            return;
        }
        configureAppCardAnimation(placeHolder, this.appCardLayout, 0.1f, 300, false);
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<EditorialEvent> appCardClicked(final EditorialViewModel editorialViewModel) {
        return e.g.a.c.a.a(this.appCardView).X(new rx.m.e() { // from class: cm.aptoide.pt.editorial.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EditorialFragment.lambda$appCardClicked$1(editorialViewModel, (Void) obj);
            }
        }).i0(this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((EditorialEvent) obj).getClickType().equals(EditorialEvent.Type.APPCARD));
            }
        }));
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<EditorialDownloadEvent> cancelDownload(final EditorialViewModel editorialViewModel) {
        return e.g.a.c.a.a(this.cancelDownload).X(new rx.m.e() { // from class: cm.aptoide.pt.editorial.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EditorialFragment.lambda$cancelDownload$11(editorialViewModel, (Void) obj);
            }
        }).i0(this.downloadEventListener.D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.r
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((EditorialDownloadEvent) obj).getClickType().equals(EditorialEvent.Type.CANCEL));
            }
        }));
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public String getAction() {
        return this.action.toString();
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName(), HttpUrl.FRAGMENT_ENCODE_SET, StoreContext.home.name());
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<Boolean> handleMovingCollapse() {
        return this.movingCollapseSubject.t();
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void hideLoading() {
        this.actionItemCard.setVisibility(8);
        this.editorialItemsCard.setVisibility(8);
        this.appCardView.setVisibility(8);
        this.itemName.setVisibility(8);
        this.errorView.setVisibility(8);
        this.progressBar.setVisibility(8);
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<EditorialDownloadEvent> installButtonClick(final EditorialViewModel editorialViewModel) {
        return this.installClickSubject.X(new rx.m.e() { // from class: cm.aptoide.pt.editorial.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5354f.e(editorialViewModel, (Void) obj);
            }
        }).i0(this.downloadEventListener.D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((EditorialDownloadEvent) obj).getClickType().equals(EditorialEvent.Type.BUTTON));
            }
        }));
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<Void> isViewReady() {
        return this.ready;
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void manageMediaListDescriptionAnimationVisibility(EditorialEvent editorialEvent) {
        EditorialItemsViewHolder editorialItemsViewHolder = (EditorialItemsViewHolder) this.editorialItems.findViewHolderForAdapterPosition(editorialEvent.getPosition());
        if (editorialItemsViewHolder != null) {
            editorialItemsViewHolder.manageDescriptionAnimationVisibility(editorialEvent.getFirstVisiblePosition(), editorialEvent.getMedia());
        }
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void managePlaceHolderVisibity() {
        EditorialItemsViewHolder viewHolderForAdapterPosition;
        List<Integer> list = this.placeHolderPositions;
        if (list == null || list.isEmpty() || (viewHolderForAdapterPosition = getViewHolderForAdapterPosition(this.placeHolderPositions.get(0).intValue())) == null || !viewHolderForAdapterPosition.isVisible(this.screenHeight, this.screenWidth)) {
            return;
        }
        removeBottomCardAnimation();
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<EditorialEvent> mediaContentClicked() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((EditorialEvent) obj).getClickType().equals(EditorialEvent.Type.MEDIA));
            }
        });
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<EditorialEvent> mediaListDescriptionChanged() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((EditorialEvent) obj).getClickType().equals(EditorialEvent.Type.MEDIA_LIST));
            }
        }).u(new rx.m.e() { // from class: cm.aptoide.pt.editorial.x6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Integer.valueOf(((EditorialEvent) obj).getFirstVisiblePosition());
            }
        });
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oneDecimalFormatter = new DecimalFormat("0.0");
        this.window = getActivity().getWindow();
        this.ready = rx.s.b.g1();
        this.uiEventsListener = rx.s.b.g1();
        this.downloadEventListener = rx.s.b.g1();
        this.movingCollapseSubject = rx.s.b.g1();
        this.reactionEventListener = rx.s.b.g1();
        this.installClickSubject = rx.s.b.g1();
        this.snackListener = rx.s.b.g1();
        this.topReactionsPreview = new TopReactionsPreview();
        setHasOptionsMenu(true);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_empty, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_editorial, viewGroup, false);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.uiEventsListener = null;
        this.installClickSubject = null;
        this.snackListener = null;
        this.reactionEventListener = null;
        this.downloadEventListener = null;
        super.onDestroy();
        rx.k kVar = this.errorMessageSubscription;
        if (kVar != null && !kVar.isUnsubscribed()) {
            this.errorMessageSubscription.unsubscribe();
        }
        this.ready = null;
        this.window = null;
        this.oneDecimalFormatter = null;
        this.movingCollapseSubject = null;
        this.socialMediaView = null;
    }

    @Override // com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.themeManager.resetStatusBarColor();
        if (Build.VERSION.SDK_INT >= 16) {
            this.window.getDecorView().setSystemUiVisibility(256);
        }
        this.toolbar = null;
        this.appImage = null;
        this.itemName = null;
        this.actionItemCard = null;
        this.appCardView = null;
        this.appCardImage = null;
        this.appCardTitle = null;
        this.appCardButton = null;
        this.editorialItemsCard = null;
        this.editorialItems = null;
        this.errorView = null;
        this.progressBar = null;
        this.collapsingToolbarLayout = null;
        this.appBarLayout = null;
        this.adapter = null;
        this.backArrow = null;
        this.reactButton = null;
        this.cardInfoLayout = null;
        this.downloadControlsLayout = null;
        this.downloadInfoLayout = null;
        this.downloadProgressBar = null;
        this.downloadProgressValue = null;
        this.cancelDownload = null;
        this.resumeDownload = null;
        this.pauseDownload = null;
        this.scrollView = null;
        this.appCardLayout = null;
        this.topReactionsPreview.onDestroy();
        super.onDestroyView();
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().onBackPressed();
        return true;
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getFragmentComponent(bundle).inject(this);
        if (Build.VERSION.SDK_INT >= 21) {
            this.window.setStatusBarColor(getResources().getColor(R.color.black_87_alpha));
        }
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        this.toolbar = toolbar;
        toolbar.setTitle(HttpUrl.FRAGMENT_ENCODE_SET);
        androidx.appcompat.app.d dVar = (androidx.appcompat.app.d) getActivity();
        dVar.setSupportActionBar(this.toolbar);
        androidx.appcompat.app.a supportActionBar = dVar.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(true);
        }
        this.backArrow = this.toolbar.getNavigationIcon();
        this.scrollView = (NestedScrollView) view.findViewById(R.id.nested_scroll_view);
        this.appBarLayout = (AppBarLayout) view.findViewById(R.id.app_bar_layout);
        this.appImage = (ImageView) view.findViewById(R.id.app_graphic);
        this.itemName = (TextView) view.findViewById(R.id.action_item_name);
        this.appCardLayout = view.findViewById(R.id.app_cardview_layout);
        View viewFindViewById = view.findViewById(R.id.app_cardview);
        this.appCardView = viewFindViewById;
        this.appCardImage = (ImageView) viewFindViewById.findViewById(R.id.app_icon_imageview);
        this.appCardTitle = (TextView) this.appCardView.findViewById(R.id.app_title_textview);
        this.appCardButton = (Button) this.appCardView.findViewById(R.id.appview_install_button);
        this.actionItemCard = (CardView) view.findViewById(R.id.action_item_card);
        this.editorialItemsCard = view.findViewById(R.id.card_info_layout);
        this.editorialItems = (RecyclerView) view.findViewById(R.id.editorial_items);
        this.errorView = (ErrorView) view.findViewById(R.id.error_view);
        this.progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.adapter = new EditorialItemsAdapter(new ArrayList(), this.oneDecimalFormatter, this.uiEventsListener, this.downloadEventListener);
        this.editorialItems.setLayoutManager(linearLayoutManager);
        this.editorialItems.setAdapter(this.adapter);
        this.reactButton = (ImageButton) view.findViewById(R.id.add_reactions);
        this.topReactionsPreview.initialReactionsSetup(view);
        this.cardInfoLayout = (RelativeLayout) view.findViewById(R.id.card_info_install_layout);
        this.downloadControlsLayout = view.findViewById(R.id.install_controls_layout);
        this.downloadInfoLayout = (LinearLayout) view.findViewById(R.id.appview_transfer_info);
        this.downloadProgressBar = (ProgressBar) view.findViewById(R.id.appview_download_progress_bar);
        this.downloadProgressValue = (TextView) view.findViewById(R.id.appview_download_progress_number);
        this.cancelDownload = (ImageView) view.findViewById(R.id.appview_download_cancel_button);
        this.resumeDownload = (ImageView) view.findViewById(R.id.appview_download_resume_download);
        this.pauseDownload = (ImageView) view.findViewById(R.id.appview_download_pause_download);
        this.toolbarTitle = (TextView) view.findViewById(R.id.toolbar_title);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar_layout);
        this.collapsingToolbarLayout = collapsingToolbarLayout;
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.transparent));
        this.collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.transparent));
        this.appBarLayout.b(new AppBarStateChangeListener() { // from class: cm.aptoide.pt.editorial.EditorialFragment.1
            private void configureAppBarLayout(Drawable drawable, int i2, boolean z) {
                EditorialFragment.this.toolbar.setBackgroundDrawable(drawable);
                EditorialFragment.this.toolbarTitle.setTextColor(i2);
                if (Build.VERSION.SDK_INT >= 21) {
                    EditorialFragment.this.handleStatusBar(z);
                }
                if (EditorialFragment.this.backArrow != null) {
                    EditorialFragment.this.backArrow.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
                }
            }

            @Override // cm.aptoide.pt.util.AppBarStateChangeListener
            public void onStateChanged(AppBarLayout appBarLayout, AppBarStateChangeListener.State state) {
                Resources resources = EditorialFragment.this.getResources();
                int i2 = AnonymousClass3.$SwitchMap$cm$aptoide$pt$util$AppBarStateChangeListener$State[state.ordinal()];
                if (i2 == 1) {
                    EditorialFragment.this.movingCollapseSubject.onNext(Boolean.valueOf(EditorialFragment.this.isItemShown()));
                } else if (i2 != 4) {
                    EditorialFragment.this.movingCollapseSubject.onNext(Boolean.valueOf(EditorialFragment.this.isItemShown()));
                    configureAppBarLayout(resources.getDrawable(R.drawable.editorial_up_bottom_black_gradient), resources.getColor(R.color.white), false);
                } else {
                    EditorialFragment.this.movingCollapseSubject.onNext(Boolean.valueOf(EditorialFragment.this.isItemShown()));
                    configureAppBarLayout(resources.getDrawable(EditorialFragment.this.themeManager.getAttributeForTheme(R.attr.toolbarBackgroundSecondary).resourceId), resources.getColor(EditorialFragment.this.themeManager.getAttributeForTheme(R.attr.textColorBlackAlpha).resourceId), true);
                }
            }
        });
        this.appCardButton.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.editorial.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f5390f.f(view2);
            }
        });
        this.socialMediaView = (SocialMediaView) view.findViewById(R.id.social_media_view);
        attachPresenter(this.presenter);
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void openApp(String str) {
        AptoideUtils.SystemU.openApp(str, getContext().getPackageManager(), getContext());
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<EditorialDownloadEvent> pauseDownload(final EditorialViewModel editorialViewModel) {
        return e.g.a.c.a.a(this.pauseDownload).X(new rx.m.e() { // from class: cm.aptoide.pt.editorial.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EditorialFragment.lambda$pauseDownload$7(editorialViewModel, (Void) obj);
            }
        }).i0(this.downloadEventListener.D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((EditorialDownloadEvent) obj).getClickType().equals(EditorialEvent.Type.PAUSE));
            }
        }));
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<ScrollEvent> placeHolderVisibilityChange() {
        return rx.e.f0(e.g.a.b.b.a.b.a(this.scrollView), e.g.a.b.a.a.b.a(this.appBarLayout)).G(new rx.m.e() { // from class: cm.aptoide.pt.editorial.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5287f.h(obj);
            }
        }).u(new rx.m.e() { // from class: cm.aptoide.pt.editorial.q6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((ScrollEvent) obj).getItemShown();
            }
        });
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void populateView(EditorialViewModel editorialViewModel) {
        populateAppContent(editorialViewModel);
        populateCardContent(editorialViewModel);
        this.ready.onNext(null);
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<ReactionEvent> reactionClicked() {
        return this.reactionEventListener;
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<Void> reactionsButtonClicked() {
        return e.g.a.c.a.a(this.reactButton);
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<Void> reactionsButtonLongPressed() {
        return e.g.a.c.a.c(this.reactButton);
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void removeBottomCardAnimation() {
        EditorialItemsViewHolder viewHolderForAdapterPosition;
        View placeHolder;
        List<Integer> list = this.placeHolderPositions;
        if (list == null || list.isEmpty() || (viewHolderForAdapterPosition = getViewHolderForAdapterPosition(this.placeHolderPositions.get(0).intValue())) == null || (placeHolder = viewHolderForAdapterPosition.getPlaceHolder()) == null || !this.shouldAnimate) {
            return;
        }
        configureAppCardAnimation(this.appCardLayout, placeHolder, 0.0f, 300, true);
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<EditorialDownloadEvent> resumeDownload(final EditorialViewModel editorialViewModel) {
        return e.g.a.c.a.a(this.resumeDownload).X(new rx.m.e() { // from class: cm.aptoide.pt.editorial.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5379f.i(editorialViewModel, (Void) obj);
            }
        }).i0(this.downloadEventListener.D(new rx.m.e() { // from class: cm.aptoide.pt.editorial.x
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((EditorialDownloadEvent) obj).getClickType().equals(EditorialEvent.Type.RESUME));
            }
        }));
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<Void> retryClicked() {
        return this.errorView.retryClick();
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void setMediaListDescriptionsVisible(EditorialEvent editorialEvent) {
        EditorialItemsViewHolder editorialItemsViewHolder = (EditorialItemsViewHolder) this.editorialItems.findViewHolderForAdapterPosition(editorialEvent.getPosition());
        if (editorialItemsViewHolder != null) {
            editorialItemsViewHolder.setAllDescriptionsVisible();
        }
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void setUserReaction(String str) {
        if (this.topReactionsPreview.isReactionValid(str)) {
            this.reactButton.setImageResource(ReactionMapper.mapReaction(str));
        } else {
            this.reactButton.setImageResource(this.themeManager.getAttributeForTheme(R.attr.reactionInputDrawable).resourceId);
        }
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<Boolean> showDowngradeMessage() {
        return GenericDialogs.createGenericContinueCancelMessage(getContext(), null, getContext().getResources().getString(R.string.downgrade_warning_dialog), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId).X(new rx.m.e() { // from class: cm.aptoide.pt.editorial.u
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((GenericDialogs.EResponse) obj).equals(GenericDialogs.EResponse.YES));
            }
        });
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void showDowngradingMessage() {
        Snackbar.Z(getView(), R.string.downgrading_msg, -1).P();
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void showDownloadError(EditorialDownloadModel editorialDownloadModel) {
        if (editorialDownloadModel.hasError()) {
            handleDownloadError(editorialDownloadModel.getDownloadState());
        }
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void showDownloadModel(EditorialDownloadModel editorialDownloadModel) {
        this.action = editorialDownloadModel.getAction();
        EditorialItemsViewHolder viewHolderForAdapterPosition = getViewHolderForAdapterPosition(editorialDownloadModel.getPosition());
        if (editorialDownloadModel.isDownloading()) {
            this.downloadInfoLayout.setVisibility(0);
            this.cardInfoLayout.setVisibility(8);
            setDownloadState(editorialDownloadModel.getProgress(), editorialDownloadModel.getDownloadState());
            if (viewHolderForAdapterPosition != null) {
                viewHolderForAdapterPosition.setPlaceHolderDownloadingInfo(editorialDownloadModel);
                return;
            }
            return;
        }
        this.downloadInfoLayout.setVisibility(8);
        this.cardInfoLayout.setVisibility(0);
        setButtonText(editorialDownloadModel);
        if (viewHolderForAdapterPosition != null) {
            viewHolderForAdapterPosition.setPlaceHolderDefaultStateInfo(editorialDownloadModel, getResources().getString(R.string.appview_button_update), getResources().getString(R.string.appview_button_install), getResources().getString(R.string.appview_button_open), getResources().getString(R.string.appview_button_downgrade));
        }
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void showError(EditorialViewModel.Error error) {
        int i2 = AnonymousClass3.$SwitchMap$cm$aptoide$pt$editorial$EditorialViewModel$Error[error.ordinal()];
        if (i2 == 1) {
            this.errorView.setError(ErrorView.Error.NO_NETWORK);
            this.errorView.setVisibility(0);
        } else {
            if (i2 != 2) {
                return;
            }
            this.errorView.setError(ErrorView.Error.GENERIC);
            this.errorView.setVisibility(0);
        }
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void showGenericErrorToast() {
        Snackbar.a0(getView(), getString(R.string.error_occured), 0).P();
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void showLoading() {
        this.actionItemCard.setVisibility(8);
        this.editorialItemsCard.setVisibility(8);
        this.appCardView.setVisibility(8);
        this.itemName.setVisibility(8);
        this.errorView.setVisibility(8);
        this.progressBar.setVisibility(0);
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void showLoginDialog() {
        Snackbar.a0(getView(), getString(R.string.editorial_reactions_login_short), 0).b0(R.string.login, new View.OnClickListener() { // from class: cm.aptoide.pt.editorial.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5315f.j(view);
            }
        }).P();
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void showNetworkErrorToast() {
        Snackbar.a0(getView(), getString(R.string.connection_error), 0).P();
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void showReactionsPopup(final String str, final String str2) {
        final ReactionsPopup reactionsPopup = new ReactionsPopup(getContext(), this.reactButton);
        reactionsPopup.show();
        reactionsPopup.setOnReactionsItemClickListener(new ReactionsPopup.OnReactionClickListener() { // from class: cm.aptoide.pt.editorial.w
            @Override // cm.aptoide.pt.reactions.ui.ReactionsPopup.OnReactionClickListener
            public final void onReactionItemClick(ReactionType reactionType) {
                this.a.k(str, str2, reactionsPopup, reactionType);
            }
        });
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<Boolean> showRootInstallWarningPopup() {
        return GenericDialogs.createGenericYesNoCancelMessage(getContext(), null, getResources().getString(R.string.root_access_dialog), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId).X(new rx.m.e() { // from class: cm.aptoide.pt.editorial.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((GenericDialogs.EResponse) obj).equals(GenericDialogs.EResponse.YES));
            }
        });
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public void showTopReactions(String str, List<TopReaction> list, int i2) {
        setUserReaction(str);
        this.topReactionsPreview.setReactions(list, i2, getContext());
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<Void> snackLoginClick() {
        return this.snackListener;
    }

    @Override // cm.aptoide.pt.editorial.EditorialView
    public rx.e<SocialMediaView.SocialMediaType> socialMediaClick() {
        return this.socialMediaView.onSocialMediaClick();
    }
}
