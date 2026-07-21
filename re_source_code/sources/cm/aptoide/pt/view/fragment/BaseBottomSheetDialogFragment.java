package cm.aptoide.pt.view.fragment;

import android.app.Dialog;
import android.os.Bundle;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.FlavourFragmentModule;
import cm.aptoide.pt.view.BaseActivity;
import cm.aptoide.pt.view.FragmentComponent;
import cm.aptoide.pt.view.FragmentModule;
import cm.aptoide.pt.view.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public class BaseBottomSheetDialogFragment extends com.trello.rxlifecycle.h.a.b {
    private FragmentComponent fragmentComponent;

    private FragmentModule getFragmentModule(BaseBottomSheetDialogFragment baseBottomSheetDialogFragment, Bundle bundle, Bundle bundle2, boolean z, String str) {
        return new FragmentModule(baseBottomSheetDialogFragment, bundle, bundle2, z, str);
    }

    public FragmentComponent getFragmentComponent(Bundle bundle) {
        if (this.fragmentComponent == null) {
            this.fragmentComponent = ((BaseActivity) getActivity()).getActivityComponent().plus(getFragmentModule(this, bundle, getArguments(), ((AptoideApplication) getContext().getApplicationContext()).isCreateStoreUserPrivacyEnabled(), getActivity().getApplicationContext().getPackageName()), new FlavourFragmentModule());
        }
        return this.fragmentComponent;
    }

    @Override // com.trello.rxlifecycle.h.a.b, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((MainActivity) getContext()).getActivityComponent().inject(this);
    }

    @Override // androidx.appcompat.app.i, androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(requireContext(), getTheme());
    }
}
