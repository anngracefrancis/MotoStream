package cm.aptoide.pt.themes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import cm.aptoide.pt.R;
import cm.aptoide.pt.feature.NewFeatureDialogPresenter;
import cm.aptoide.pt.view.fragment.BaseBottomSheetDialogView;
import e.g.a.c.a;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;
import rx.e;

/* JADX INFO: compiled from: NewFeatureDialogFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Lcm/aptoide/pt/themes/NewFeatureDialogFragment;", "Lcm/aptoide/pt/view/fragment/BaseBottomSheetDialogView;", "Lcm/aptoide/pt/themes/NewFeatureDialogView;", "()V", "presenter", "Lcm/aptoide/pt/feature/NewFeatureDialogPresenter;", "getPresenter", "()Lcm/aptoide/pt/feature/NewFeatureDialogPresenter;", "setPresenter", "(Lcm/aptoide/pt/feature/NewFeatureDialogPresenter;)V", "clickDismiss", "Lrx/Observable;", "Ljava/lang/Void;", "clickTurnItOn", "dismissView", HttpUrl.FRAGMENT_ENCODE_SET, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NewFeatureDialogFragment extends BaseBottomSheetDialogView implements NewFeatureDialogView {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    @Inject
    public NewFeatureDialogPresenter presenter;

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

    @Override // cm.aptoide.pt.themes.NewFeatureDialogView
    public e<Void> clickDismiss() {
        e<Void> eVarA = a.a((Button) _$_findCachedViewById(R.id.dismissButton));
        m.e(eVarA, "clicks(dismissButton)");
        return eVarA;
    }

    @Override // cm.aptoide.pt.themes.NewFeatureDialogView
    public e<Void> clickTurnItOn() {
        e<Void> eVarA = a.a((Button) _$_findCachedViewById(R.id.turnItOnButton));
        m.e(eVarA, "clicks(turnItOnButton)");
        return eVarA;
    }

    @Override // cm.aptoide.pt.themes.NewFeatureDialogView
    public void dismissView() {
        dismiss();
    }

    public final NewFeatureDialogPresenter getPresenter() {
        NewFeatureDialogPresenter newFeatureDialogPresenter = this.presenter;
        if (newFeatureDialogPresenter != null) {
            return newFeatureDialogPresenter;
        }
        m.w("presenter");
        return null;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseBottomSheetDialogFragment, com.trello.rxlifecycle.h.a.b, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentComponent(savedInstanceState).inject(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m.f(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_new_feature, container, false);
    }

    @Override // com.trello.rxlifecycle.h.a.b, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.trello.rxlifecycle.h.a.b, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.f(view, "view");
        super.onViewCreated(view, savedInstanceState);
        attachPresenter(getPresenter());
    }

    public final void setPresenter(NewFeatureDialogPresenter newFeatureDialogPresenter) {
        m.f(newFeatureDialogPresenter, "<set-?>");
        this.presenter = newFeatureDialogPresenter;
    }
}
