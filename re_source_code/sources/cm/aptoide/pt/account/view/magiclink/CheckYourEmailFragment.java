package cm.aptoide.pt.account.view.magiclink;

import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.aptoideviews.common.NonbreakingSpan;
import cm.aptoide.pt.R;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import cm.aptoide.pt.view.NotBottomNavigationView;
import cm.aptoide.pt.view.fragment.BaseToolbarFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: CheckYourEmailFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 02\u00020\u00012\u00020\u00022\u00020\u0003:\u00010B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001eH\u0014J\u0012\u0010'\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010,\u001a\u00020\u001a2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020\u001aH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u00061"}, d2 = {"Lcm/aptoide/pt/account/view/magiclink/CheckYourEmailFragment;", "Lcm/aptoide/pt/view/fragment/BaseToolbarFragment;", "Lcm/aptoide/pt/account/view/magiclink/CheckYourEmailView;", "Lcm/aptoide/pt/view/NotBottomNavigationView;", "()V", CheckYourEmailFragment.EMAIL, HttpUrl.FRAGMENT_ENCODE_SET, "openEmailAppButton", "Landroid/widget/Button;", "getOpenEmailAppButton", "()Landroid/widget/Button;", "setOpenEmailAppButton", "(Landroid/widget/Button;)V", "openEmailBody", "Landroid/widget/TextView;", "getOpenEmailBody", "()Landroid/widget/TextView;", "setOpenEmailBody", "(Landroid/widget/TextView;)V", "presenter", "Lcm/aptoide/pt/account/view/magiclink/CheckYourEmailPresenter;", "getPresenter", "()Lcm/aptoide/pt/account/view/magiclink/CheckYourEmailPresenter;", "setPresenter", "(Lcm/aptoide/pt/account/view/magiclink/CheckYourEmailPresenter;)V", "bindViews", HttpUrl.FRAGMENT_ENCODE_SET, "view", "Landroid/view/View;", "displayHomeUpAsEnabled", HttpUrl.FRAGMENT_ENCODE_SET, "getCheckYourEmailClick", "Lrx/Observable;", "Ljava/lang/Void;", "getContentViewId", HttpUrl.FRAGMENT_ENCODE_SET, "getHistoryTracker", "Lcm/aptoide/analytics/implementation/navigation/ScreenTagHistory;", "hasToolbar", "loadExtras", "args", "Landroid/os/Bundle;", "onCreate", "savedInstanceState", "setupToolbarDetails", StoreTabGridRecyclerFragment.BundleCons.TOOLBAR, "Landroidx/appcompat/widget/Toolbar;", "setupViews", "Companion", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckYourEmailFragment extends BaseToolbarFragment implements CheckYourEmailView, NotBottomNavigationView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EMAIL = "email";
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private String email;
    public Button openEmailAppButton;
    public TextView openEmailBody;

    @Inject
    public CheckYourEmailPresenter presenter;

    /* JADX INFO: compiled from: CheckYourEmailFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcm/aptoide/pt/account/view/magiclink/CheckYourEmailFragment$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "EMAIL", HttpUrl.FRAGMENT_ENCODE_SET, "newInstance", "Lcm/aptoide/pt/account/view/magiclink/CheckYourEmailFragment;", CheckYourEmailFragment.EMAIL, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final CheckYourEmailFragment newInstance(String email) {
            kotlin.jvm.internal.m.f(email, CheckYourEmailFragment.EMAIL);
            CheckYourEmailFragment checkYourEmailFragment = new CheckYourEmailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(CheckYourEmailFragment.EMAIL, email);
            checkYourEmailFragment.setArguments(bundle);
            return checkYourEmailFragment;
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View viewFindViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (viewFindViewById = view2.findViewById(i2)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void bindViews(View view) {
        super.bindViews(view);
        if (view != null) {
            View viewFindViewById = view.findViewById(R.id.open_email_app_button);
            kotlin.jvm.internal.m.e(viewFindViewById, "v.findViewById(R.id.open_email_app_button)");
            setOpenEmailAppButton((Button) viewFindViewById);
            View viewFindViewById2 = view.findViewById(R.id.check_your_email_body_text);
            kotlin.jvm.internal.m.e(viewFindViewById2, "v.findViewById(R.id.check_your_email_body_text)");
            setOpenEmailBody((TextView) viewFindViewById2);
            String str = this.email;
            if (str != null) {
                String string = getString(R.string.login_check_email_body, str);
                kotlin.jvm.internal.m.e(string, "getString(R.string.login_check_email_body, e)");
                SpannableString spannableString = new SpannableString(string);
                spannableString.setSpan(new NonbreakingSpan(), kotlin.text.v.W(string, str, 0, false, 6, null), kotlin.text.v.W(string, str, 0, false, 6, null) + str.length(), 33);
                getOpenEmailBody().setText(spannableString);
            }
        }
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment
    protected boolean displayHomeUpAsEnabled() {
        return true;
    }

    @Override // cm.aptoide.pt.account.view.magiclink.CheckYourEmailView
    public rx.e<Void> getCheckYourEmailClick() {
        rx.e<Void> eVarA = e.g.a.c.a.a(getOpenEmailAppButton());
        kotlin.jvm.internal.m.e(eVarA, "clicks(openEmailAppButton)");
        return eVarA;
    }

    @Override // cm.aptoide.pt.view.fragment.UiComponent
    public int getContentViewId() {
        return R.layout.fragment_check_your_email;
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(CheckYourEmailFragment.class.getSimpleName());
    }

    public final Button getOpenEmailAppButton() {
        Button button = this.openEmailAppButton;
        if (button != null) {
            return button;
        }
        kotlin.jvm.internal.m.w("openEmailAppButton");
        return null;
    }

    public final TextView getOpenEmailBody() {
        TextView textView = this.openEmailBody;
        if (textView != null) {
            return textView;
        }
        kotlin.jvm.internal.m.w("openEmailBody");
        return null;
    }

    public final CheckYourEmailPresenter getPresenter() {
        CheckYourEmailPresenter checkYourEmailPresenter = this.presenter;
        if (checkYourEmailPresenter != null) {
            return checkYourEmailPresenter;
        }
        kotlin.jvm.internal.m.w("presenter");
        return null;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment
    protected boolean hasToolbar() {
        return true;
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void loadExtras(Bundle args) {
        super.loadExtras(args);
        this.email = args != null ? args.getString(EMAIL) : null;
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentComponent(savedInstanceState).inject(this);
        setHasOptionsMenu(true);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void setOpenEmailAppButton(Button button) {
        kotlin.jvm.internal.m.f(button, "<set-?>");
        this.openEmailAppButton = button;
    }

    public final void setOpenEmailBody(TextView textView) {
        kotlin.jvm.internal.m.f(textView, "<set-?>");
        this.openEmailBody = textView;
    }

    public final void setPresenter(CheckYourEmailPresenter checkYourEmailPresenter) {
        kotlin.jvm.internal.m.f(checkYourEmailPresenter, "<set-?>");
        this.presenter = checkYourEmailPresenter;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment
    protected void setupToolbarDetails(Toolbar toolbar) {
        if (toolbar == null) {
            return;
        }
        toolbar.setTitle(HttpUrl.FRAGMENT_ENCODE_SET);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseToolbarFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void setupViews() {
        super.setupViews();
        attachPresenter(getPresenter());
    }
}
