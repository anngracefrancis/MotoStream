package cm.aptoide.pt.comments.view;

import cm.aptoide.pt.UserFeedbackAnalytics;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.fragment.BaseDialogFragment_MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class CommentDialogFragment_MembersInjector implements f.a<CommentDialogFragment> {
    private final Provider<ThemeManager> themeManagerProvider;
    private final Provider<UserFeedbackAnalytics> userFeedbackAnalyticsProvider;

    public CommentDialogFragment_MembersInjector(Provider<ThemeManager> provider, Provider<UserFeedbackAnalytics> provider2) {
        this.themeManagerProvider = provider;
        this.userFeedbackAnalyticsProvider = provider2;
    }

    public static f.a<CommentDialogFragment> create(Provider<ThemeManager> provider, Provider<UserFeedbackAnalytics> provider2) {
        return new CommentDialogFragment_MembersInjector(provider, provider2);
    }

    public static void injectUserFeedbackAnalytics(CommentDialogFragment commentDialogFragment, UserFeedbackAnalytics userFeedbackAnalytics) {
        commentDialogFragment.userFeedbackAnalytics = userFeedbackAnalytics;
    }

    public void injectMembers(CommentDialogFragment commentDialogFragment) {
        BaseDialogFragment_MembersInjector.injectThemeManager(commentDialogFragment, this.themeManagerProvider.get());
        injectUserFeedbackAnalytics(commentDialogFragment, this.userFeedbackAnalyticsProvider.get());
    }
}
