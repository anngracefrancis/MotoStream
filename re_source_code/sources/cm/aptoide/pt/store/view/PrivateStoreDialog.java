package cm.aptoide.pt.store.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.exception.AptoideWsV7Exception;
import cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener;
import cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStoreMeta;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreMetaRequest;
import cm.aptoide.pt.store.StoreError;
import cm.aptoide.pt.store.StoreUtils;
import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.GenericDialogs;
import cm.aptoide.pt.view.fragment.BaseDialogFragment;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class PrivateStoreDialog extends BaseDialogFragment {
    public static final String TAG = "PrivateStoreDialog";
    private AptoideAccountManager accountManager;
    private BodyInterceptor<BaseBody> bodyInterceptor;
    private Converter.Factory converterFactory;
    private OkHttpClient httpClient;
    private boolean isInsideStore;
    private ProgressDialog loadingDialog;
    private String storeName;
    private String storePassSha1;
    private String storeUser;

    @Inject
    StoreUtilsProxy storeUtilsProxy;
    private TokenInvalidator tokenInvalidator;

    /* JADX INFO: renamed from: cm.aptoide.pt.store.view.PrivateStoreDialog$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$store$StoreError;

        static {
            int[] iArr = new int[StoreError.values().length];
            $SwitchMap$cm$aptoide$pt$store$StoreError = iArr;
            try {
                iArr[StoreError.PRIVATE_STORE_WRONG_CREDENTIALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private enum BundleArgs {
        STORE_NAME
    }

    private GetStoreMetaRequest buildRequest() {
        return GetStoreMetaRequest.of(new BaseRequestWithStore.StoreCredentials(this.storeName, this.storeUser, this.storePassSha1), this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences());
    }

    private void dismissLoadingDialog() {
        this.loadingDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateDialog$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(GetStoreMeta getStoreMeta) {
        getTargetFragment().onActivityResult(getTargetRequestCode(), -1, null);
        dismissLoadingDialog();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateDialog$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(Throwable th) {
        dismissLoadingDialog();
        if (!(th instanceof AptoideWsV7Exception)) {
            th.printStackTrace();
            getTargetFragment().onActivityResult(getTargetRequestCode(), 22, null);
            dismiss();
            return;
        }
        if (AnonymousClass1.$SwitchMap$cm$aptoide$pt$store$StoreError[StoreUtils.getErrorType(((AptoideWsV7Exception) th).getBaseResponse().getError().getCode()).ordinal()] != 1) {
            getTargetFragment().onActivityResult(getTargetRequestCode(), 22, null);
            dismiss();
        } else {
            this.storeUser = null;
            this.storePassSha1 = null;
            getTargetFragment().onActivityResult(getTargetRequestCode(), 21, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateDialog$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view, DialogInterface dialogInterface, int i2) {
        this.storeUser = ((EditText) view.findViewById(R.id.edit_store_username)).getText().toString();
        this.storePassSha1 = AptoideUtils.AlgorithmU.computeSha1(((EditText) view.findViewById(R.id.edit_store_password)).getText().toString());
        this.storeUtilsProxy.subscribeStore(buildRequest(), new SuccessRequestListener() { // from class: cm.aptoide.pt.store.view.c1
            @Override // cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener, rx.m.b
            public final void call(Object obj) {
                this.f7595f.d((GetStoreMeta) obj);
            }
        }, new ErrorRequestListener() { // from class: cm.aptoide.pt.store.view.b1
            @Override // cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener
            public final void onError(Throwable th) {
                this.a.e(th);
            }
        }, this.storeName, this.accountManager, this.storeUser, this.storePassSha1);
        showLoadingDialog();
    }

    public static PrivateStoreDialog newInstance(Fragment fragment, int i2, String str, boolean z) {
        PrivateStoreDialog privateStoreDialog = new PrivateStoreDialog();
        Bundle bundle = new Bundle();
        bundle.putString(BundleArgs.STORE_NAME.name(), str);
        privateStoreDialog.setArguments(bundle);
        privateStoreDialog.setIsInsideStore(z);
        privateStoreDialog.setRetainInstance(true);
        privateStoreDialog.setTargetFragment(fragment, i2);
        return privateStoreDialog;
    }

    private void showLoadingDialog() {
        if (this.loadingDialog == null) {
            this.loadingDialog = GenericDialogs.createGenericPleaseWaitDialog(getActivity(), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId);
        }
        this.loadingDialog.show();
    }

    @Override // cm.aptoide.pt.view.fragment.BaseDialogFragment, com.trello.rxlifecycle.h.a.c, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        this.tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        this.httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        this.converterFactory = WebService.getDefaultConverter();
        this.bodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.storeName = arguments.getString(BundleArgs.STORE_NAME.name());
        }
    }

    @Override // cm.aptoide.pt.view.fragment.BaseDialogFragment, androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        androidx.fragment.app.d activity = getActivity();
        final View viewInflate = LayoutInflater.from(activity).inflate(R.layout.dialog_add_pvt_store, (ViewGroup) null, false);
        return new androidx.appcompat.app.c.a(new ContextThemeWrapper(activity, this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId)).u(R.string.subscribe_pvt_store).w(viewInflate).q(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: cm.aptoide.pt.store.view.d1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f7598f.f(viewInflate, dialogInterface, i2);
            }
        }).a();
    }

    @Override // com.trello.rxlifecycle.h.a.c, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.isInsideStore) {
            getActivity().onBackPressed();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(BundleArgs.STORE_NAME.name(), this.storeName);
    }

    public void setIsInsideStore(boolean z) {
        this.isInsideStore = z;
    }
}
