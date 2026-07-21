package cm.aptoide.pt.view.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.FlavourFragmentModule;
import cm.aptoide.pt.R;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.BaseActivity;
import cm.aptoide.pt.view.FragmentComponent;
import cm.aptoide.pt.view.FragmentModule;
import cm.aptoide.pt.view.MainActivity;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes.dex */
public class BaseDialogFragment extends com.trello.rxlifecycle.h.a.c {
    private FragmentComponent fragmentComponent;

    @Inject
    public ThemeManager themeManager;

    private FragmentModule getFragmentModule(BaseDialogFragment baseDialogFragment, Bundle bundle, Bundle bundle2, boolean z, String str) {
        return new FragmentModule(baseDialogFragment, bundle, bundle2, z, str);
    }

    public int getDialogStyle() {
        return R.attr.dialogsTheme;
    }

    public FragmentComponent getFragmentComponent(Bundle bundle) {
        if (this.fragmentComponent == null) {
            this.fragmentComponent = ((BaseActivity) getActivity()).getActivityComponent().plus(getFragmentModule(this, bundle, getArguments(), ((AptoideApplication) getContext().getApplicationContext()).isCreateStoreUserPrivacyEnabled(), getActivity().getApplicationContext().getPackageName()), new FlavourFragmentModule());
        }
        return this.fragmentComponent;
    }

    @Override // com.trello.rxlifecycle.h.a.c, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((MainActivity) getContext()).getActivityComponent().inject(this);
    }

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        if (getActivity() != null && shouldUseDefaultDialogStyle()) {
            setStyle(1, this.themeManager.getAttributeForTheme(getDialogStyle()).resourceId);
        }
        return super.onCreateDialog(bundle);
    }

    @Override // com.trello.rxlifecycle.h.a.c, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.dimAmount = 0.6f;
        getDialog().getWindow().setAttributes(attributes);
        getDialog().getWindow().addFlags(2);
    }

    public boolean shouldUseDefaultDialogStyle() {
        return true;
    }
}
