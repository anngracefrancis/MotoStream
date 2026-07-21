package cm.aptoide.pt.view;

import cm.aptoide.pt.account.view.LoginSignUpCredentialsFragment;
import cm.aptoide.pt.account.view.magiclink.CheckYourEmailFragment;
import cm.aptoide.pt.account.view.store.ManageStoreFragment;
import cm.aptoide.pt.account.view.user.ManageUserFragment;
import cm.aptoide.pt.account.view.user.ProfileStepOneFragment;
import cm.aptoide.pt.account.view.user.ProfileStepTwoFragment;
import cm.aptoide.pt.app.view.AppCoinsInfoFragment;
import cm.aptoide.pt.app.view.AppViewFragment;
import cm.aptoide.pt.app.view.MoreBundleFragment;
import cm.aptoide.pt.app.view.OtherVersionsFragment;
import cm.aptoide.pt.autoupdate.AutoUpdateDialogFragment;
import cm.aptoide.pt.comments.view.CommentDialogFragment;
import cm.aptoide.pt.comments.view.CommentListFragment;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceDialogFragment;
import cm.aptoide.pt.editorial.EditorialFragment;
import cm.aptoide.pt.editorialList.EditorialListFragment;
import cm.aptoide.pt.home.HomeContainerFragment;
import cm.aptoide.pt.home.HomeFragment;
import cm.aptoide.pt.home.apps.AppsFragment;
import cm.aptoide.pt.home.more.appcoins.EarnAppcListFragment;
import cm.aptoide.pt.home.more.apps.ListAppsMoreFragment;
import cm.aptoide.pt.notification.view.InboxFragment;
import cm.aptoide.pt.promotions.ClaimPromotionDialogFragment;
import cm.aptoide.pt.promotions.PromotionsFragment;
import cm.aptoide.pt.reviews.LatestReviewsFragment;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import cm.aptoide.pt.search.view.SearchResultFragment;
import cm.aptoide.pt.store.view.AddStoreDialog;
import cm.aptoide.pt.store.view.ListStoresFragment;
import cm.aptoide.pt.store.view.PrivateStoreDialog;
import cm.aptoide.pt.store.view.StoreFragment;
import cm.aptoide.pt.store.view.StoreTabWidgetsGridRecyclerFragment;
import cm.aptoide.pt.store.view.TopStoresFragment;
import cm.aptoide.pt.store.view.my.MyStoresFragment;
import cm.aptoide.pt.store.view.my.MyStoresSubscribedFragment;
import cm.aptoide.pt.store.view.recommended.RecommendedStoresFragment;
import cm.aptoide.pt.themes.NewFeatureDialogFragment;
import cm.aptoide.pt.timeline.view.follow.TimeLineFollowersFragment;
import cm.aptoide.pt.timeline.view.follow.TimeLineFollowingFragment;
import cm.aptoide.pt.updates.view.excluded.ExcludedUpdatesFragment;
import cm.aptoide.pt.view.app.ListStoreAppsFragment;
import cm.aptoide.pt.view.feedback.SendFeedbackFragment;
import cm.aptoide.pt.view.fragment.DescriptionFragment;
import cm.aptoide.pt.view.fragment.GridRecyclerSwipeWithToolbarFragment;
import cm.aptoide.pt.view.settings.MyAccountFragment;
import cm.aptoide.pt.view.settings.SettingsFragment;
import cm.aptoide.pt.view.wizard.WizardFragment;
import cm.aptoide.pt.view.wizard.WizardFragmentProvider;
import cm.aptoide.pt.view.wizard.WizardPageTwoFragment;

/* JADX INFO: loaded from: classes.dex */
@FragmentScope
public interface FragmentComponent {
    void inject(LoginSignUpCredentialsFragment loginSignUpCredentialsFragment);

    void inject(CheckYourEmailFragment checkYourEmailFragment);

    void inject(ManageStoreFragment manageStoreFragment);

    void inject(ManageUserFragment manageUserFragment);

    void inject(ProfileStepOneFragment profileStepOneFragment);

    void inject(ProfileStepTwoFragment profileStepTwoFragment);

    void inject(AppCoinsInfoFragment appCoinsInfoFragment);

    void inject(AppViewFragment appViewFragment);

    void inject(MoreBundleFragment moreBundleFragment);

    void inject(OtherVersionsFragment otherVersionsFragment);

    void inject(AutoUpdateDialogFragment autoUpdateDialogFragment);

    void inject(CommentDialogFragment commentDialogFragment);

    void inject(CommentListFragment commentListFragment);

    void inject(OutOfSpaceDialogFragment outOfSpaceDialogFragment);

    void inject(EditorialFragment editorialFragment);

    void inject(EditorialListFragment editorialListFragment);

    void inject(HomeContainerFragment homeContainerFragment);

    void inject(HomeFragment homeFragment);

    void inject(AppsFragment appsFragment);

    void inject(EarnAppcListFragment earnAppcListFragment);

    void inject(ListAppsMoreFragment listAppsMoreFragment);

    void inject(InboxFragment inboxFragment);

    void inject(ClaimPromotionDialogFragment claimPromotionDialogFragment);

    void inject(PromotionsFragment promotionsFragment);

    void inject(LatestReviewsFragment latestReviewsFragment);

    void inject(RateAndReviewsFragment rateAndReviewsFragment);

    void inject(SearchResultFragment searchResultFragment);

    void inject(AddStoreDialog addStoreDialog);

    void inject(ListStoresFragment listStoresFragment);

    void inject(PrivateStoreDialog privateStoreDialog);

    void inject(StoreFragment storeFragment);

    void inject(StoreTabWidgetsGridRecyclerFragment storeTabWidgetsGridRecyclerFragment);

    void inject(TopStoresFragment topStoresFragment);

    void inject(MyStoresFragment myStoresFragment);

    void inject(MyStoresSubscribedFragment myStoresSubscribedFragment);

    void inject(RecommendedStoresFragment recommendedStoresFragment);

    void inject(NewFeatureDialogFragment newFeatureDialogFragment);

    void inject(TimeLineFollowersFragment timeLineFollowersFragment);

    void inject(TimeLineFollowingFragment timeLineFollowingFragment);

    void inject(ExcludedUpdatesFragment excludedUpdatesFragment);

    void inject(ListStoreAppsFragment listStoreAppsFragment);

    void inject(SendFeedbackFragment sendFeedbackFragment);

    void inject(DescriptionFragment descriptionFragment);

    void inject(GridRecyclerSwipeWithToolbarFragment gridRecyclerSwipeWithToolbarFragment);

    void inject(MyAccountFragment myAccountFragment);

    void inject(SettingsFragment settingsFragment);

    void inject(WizardFragment wizardFragment);

    void inject(WizardFragmentProvider wizardFragmentProvider);

    void inject(WizardPageTwoFragment wizardPageTwoFragment);
}
