package cm.aptoide.pt.navigator;

import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
public interface FragmentNavigator {
    public static final String REQUEST_CODE_EXTRA = "cm.aptoide.pt.view.navigator.extra.REQUEST_CODE";

    void cleanBackStack();

    int getBackStackEntryCount();

    Fragment getFragment();

    Fragment getFragment(String str);

    String getTagByBackStackEntry(int i2);

    void navigateForResult(Fragment fragment, int i2, boolean z);

    String navigateTo(Fragment fragment, boolean z);

    void navigateToCleaningBackStack(Fragment fragment, boolean z);

    void navigateToDialogForResult(androidx.fragment.app.c cVar, int i2);

    void navigateToDialogFragment(androidx.fragment.app.c cVar);

    void navigateToWithoutBackSave(Fragment fragment, boolean z);

    Fragment peekLast();

    boolean popBackStack();

    void popBackStackUntil(String str);

    void popDialogWithResult(Result result);

    void popWithResult(Result result);

    rx.e<Result> results(int i2);
}
