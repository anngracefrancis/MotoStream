package cm.aptoide.pt.account.view;

import android.app.Dialog;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.View;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.permission.PermissionServiceFragment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

/* JADX INFO: loaded from: classes.dex */
public abstract class GooglePlayServicesFragment extends PermissionServiceFragment implements GooglePlayServicesView {
    private static final int RESOLVE_CONNECTION_ERROR_REQUEST_CODE = 1;
    private GoogleApiAvailability apiAvailability;
    private Dialog errorDialog;

    private void showConnectionErrorMessage(int i2) {
        Dialog dialog = this.errorDialog;
        if (dialog == null || !dialog.isShowing()) {
            Dialog dialogN = this.apiAvailability.n(getActivity(), i2, 1);
            this.errorDialog = dialogN;
            dialogN.show();
        }
    }

    private void showResolution(ConnectionResult connectionResult) {
        try {
            connectionResult.i0(getActivity(), 1);
        } catch (IntentSender.SendIntentException e2) {
            CrashReport.getInstance().log(e2);
        }
    }

    @Override // com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.errorDialog;
        if (dialog != null) {
            dialog.dismiss();
            this.errorDialog = null;
        }
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.apiAvailability = GoogleApiAvailability.q();
    }

    @Override // cm.aptoide.pt.account.view.GooglePlayServicesView
    public void showConnectionError(ConnectionResult connectionResult) {
        if (connectionResult.Y()) {
            showResolution(connectionResult);
        } else {
            showConnectionErrorMessage(connectionResult.y());
        }
    }
}
