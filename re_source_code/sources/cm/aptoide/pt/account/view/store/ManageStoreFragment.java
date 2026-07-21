package cm.aptoide.pt.account.view.store;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.view.ImagePickerErrorHandler;
import cm.aptoide.pt.account.view.ImagePickerPresenter;
import cm.aptoide.pt.account.view.exception.InvalidImageException;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.orientation.ScreenOrientationManager;
import cm.aptoide.pt.presenter.CompositePresenter;
import cm.aptoide.pt.themes.StoreTheme;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.GenericDialogs;
import cm.aptoide.pt.view.BackButtonFragment;
import cm.aptoide.pt.view.NotBottomNavigationView;
import cm.aptoide.pt.view.custom.DividerItemDecoration;
import cm.aptoide.pt.view.dialog.ImagePickerDialog;
import com.google.android.material.snackbar.Snackbar;
import java.util.Arrays;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes.dex */
public class ManageStoreFragment extends BackButtonFragment implements ManageStoreView, NotBottomNavigationView {
    private static final String EXTRA_GO_TO_HOME = "go_to_home";
    private static final String EXTRA_STORE_MODEL = "store_model";
    private static final float SPACE_BETWEEN = 0.0f;
    private static final float STROKE_SIZE = 0.04f;
    private Button cancelChangesButton;
    private TextView chooseStoreNameTitle;
    private ManageStoreViewModel currentModel;
    private ImagePickerDialog dialogFragment;
    private boolean goToHome;
    private ImagePickerErrorHandler imagePickerErrorHandler;

    @Inject
    ImagePickerPresenter imagePickerPresenter;

    @Inject
    ManageStorePresenter manageStorePresenter;

    @Inject
    ScreenOrientationManager orientationManager;
    private Button saveDataButton;
    private View selectStoreImageButton;
    private EditText storeDescription;
    private ImageView storeImage;
    private EditText storeName;

    @Inject
    ThemeManager themeManager;
    private ThemeSelectorViewAdapter themeSelectorAdapter;
    private RecyclerView themeSelectorView;
    private Toolbar toolbar;
    private ProgressDialog waitDialog;

    private void attachPresenters() {
        attachPresenter(new CompositePresenter(Arrays.asList(this.imagePickerPresenter, this.manageStorePresenter)));
    }

    private String getViewTitle(ManageStoreViewModel manageStoreViewModel) {
        return !manageStoreViewModel.storeExists() ? getString(R.string.create_store_title) : getString(R.string.edit_store_title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$cancelClick$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ ManageStoreViewModel e(Void r1) {
        return this.currentModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$cancelClick$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(ManageStoreViewModel manageStoreViewModel) {
        hideKeyboard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$saveDataClick$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ ManageStoreViewModel g(Void r1) {
        return updateAndGetStoreModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$saveDataClick$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(ManageStoreViewModel manageStoreViewModel) {
        hideKeyboard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupThemeSelector$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(StoreTheme storeTheme) {
        this.currentModel.setStoreTheme(storeTheme);
    }

    static /* synthetic */ void lambda$showIconPropertiesError$0(GenericDialogs.EResponse eResponse) {
    }

    public static ManageStoreFragment newInstance(ManageStoreViewModel manageStoreViewModel, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_STORE_MODEL, org.parceler.d.c(manageStoreViewModel));
        bundle.putBoolean(EXTRA_GO_TO_HOME, z);
        ManageStoreFragment manageStoreFragment = new ManageStoreFragment();
        manageStoreFragment.setArguments(bundle);
        return manageStoreFragment;
    }

    private void setupViewsDefaultDataUsingCurrentModel() {
        this.storeName.setText(this.currentModel.getStoreName());
        if (!this.currentModel.storeExists()) {
            this.chooseStoreNameTitle.setText(R.string.create_store_name);
            return;
        }
        this.chooseStoreNameTitle.setText(AptoideUtils.StringU.getFormattedString(R.string.description, getResources(), new Object[0]));
        this.storeName.setVisibility(8);
        this.storeDescription.setVisibility(0);
        this.storeDescription.setText(this.currentModel.getStoreDescription());
        loadImageStateless(this.currentModel.getPictureUri());
        this.saveDataButton.setText(R.string.save_edit_store);
        this.cancelChangesButton.setText(R.string.cancel);
    }

    private ManageStoreViewModel updateAndGetStoreModel() {
        ManageStoreViewModel manageStoreViewModelUpdate = ManageStoreViewModel.update(this.currentModel, this.storeName.getText().toString(), this.storeDescription.getText().toString());
        this.currentModel = manageStoreViewModelUpdate;
        manageStoreViewModelUpdate.setStoreTheme(this.themeSelectorAdapter.getSelectedTheme());
        return this.currentModel;
    }

    public void bindViews(View view) {
        this.chooseStoreNameTitle = (TextView) view.findViewById(R.id.create_store_choose_name_title);
        this.selectStoreImageButton = view.findViewById(R.id.create_store_image_action);
        this.storeImage = (ImageView) view.findViewById(R.id.create_store_image);
        this.storeName = (EditText) view.findViewById(R.id.create_store_name);
        this.storeDescription = (EditText) view.findViewById(R.id.edit_store_description);
        this.cancelChangesButton = (Button) view.findViewById(R.id.create_store_skip);
        this.saveDataButton = (Button) view.findViewById(R.id.create_store_action);
        this.themeSelectorView = (RecyclerView) view.findViewById(R.id.theme_selector);
        this.waitDialog = GenericDialogs.createGenericPleaseWaitDialog(getActivity(), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId, getActivity().getApplicationContext().getString(R.string.please_wait_upload));
        this.toolbar = (Toolbar) view.findViewById(R.id.toolbar);
    }

    @Override // cm.aptoide.pt.account.view.store.ManageStoreView
    public rx.e<ManageStoreViewModel> cancelClick() {
        return e.g.a.c.a.a(this.cancelChangesButton).X(new rx.m.e() { // from class: cm.aptoide.pt.account.view.store.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3921f.e((Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.store.e
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3917f.f((ManageStoreViewModel) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.account.view.ImagePickerView
    public rx.e<DialogInterface> dialogCameraSelected() {
        return this.dialogFragment.cameraSelected();
    }

    @Override // cm.aptoide.pt.account.view.ImagePickerView
    public rx.e<DialogInterface> dialogGallerySelected() {
        return this.dialogFragment.gallerySelected();
    }

    @Override // cm.aptoide.pt.account.view.ImagePickerView
    public void dismissLoadImageDialog() {
        this.dialogFragment.dismiss();
    }

    @Override // cm.aptoide.pt.account.view.store.ManageStoreView
    public void dismissWaitProgressBar() {
        this.orientationManager.unlock();
        ProgressDialog progressDialog = this.waitDialog;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.waitDialog.dismiss();
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName());
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, cm.aptoide.pt.presenter.LoginSignUpCredentialsView
    public void hideKeyboard() {
        super.hideKeyboard();
    }

    @Override // cm.aptoide.pt.account.view.ImagePickerView
    public void loadImage(String str) {
        loadImageStateless(str);
        this.currentModel.setNewAvatar(true);
    }

    @Override // cm.aptoide.pt.account.view.store.ManageStoreView
    public void loadImageStateless(String str) {
        ImageLoader.with(getActivity()).loadWithShadowCircleTransform(str, this.storeImage, this.themeManager.getAttributeForTheme(R.attr.colorPrimary).data, SPACE_BETWEEN, STROKE_SIZE);
        this.currentModel.setPictureUri(str);
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        this.currentModel = (ManageStoreViewModel) org.parceler.d.a(getArguments().getParcelable(EXTRA_STORE_MODEL));
        this.goToHome = getArguments().getBoolean(EXTRA_GO_TO_HOME, true);
        this.dialogFragment = new ImagePickerDialog.Builder(new c.a.o.d(getContext(), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId), this.themeManager).setViewRes(R.layout.dialog_choose_avatar_source).setTitle(R.string.upload_dialog_title).setNegativeButton(R.string.cancel).setCameraButton(R.id.button_camera).setGalleryButton(R.id.button_gallery).build();
        this.imagePickerErrorHandler = new ImagePickerErrorHandler(getContext(), this.themeManager);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_manage_store, viewGroup, false);
    }

    @Override // com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        dismissWaitProgressBar();
        ImagePickerDialog imagePickerDialog = this.dialogFragment;
        if (imagePickerDialog != null) {
            imagePickerDialog.dismiss();
            this.dialogFragment = null;
        }
        hideKeyboard();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(EXTRA_STORE_MODEL, org.parceler.d.c(this.currentModel));
        bundle.putBoolean(EXTRA_GO_TO_HOME, this.goToHome);
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bindViews(view);
        setupToolbarTitle();
        setupThemeSelector();
        setupViewsDefaultDataUsingCurrentModel();
        attachPresenters();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            try {
                this.currentModel = (ManageStoreViewModel) org.parceler.d.a(bundle.getParcelable(EXTRA_STORE_MODEL));
            } catch (NullPointerException unused) {
                this.currentModel = new ManageStoreViewModel();
            }
            this.goToHome = bundle.getBoolean(EXTRA_GO_TO_HOME, true);
        }
    }

    @Override // cm.aptoide.pt.account.view.store.ManageStoreView
    public rx.e<ManageStoreViewModel> saveDataClick() {
        return e.g.a.c.a.a(this.saveDataButton).X(new rx.m.e() { // from class: cm.aptoide.pt.account.view.store.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3922f.g((Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.store.c
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3913f.h((ManageStoreViewModel) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.account.view.ImagePickerView
    public rx.e<Void> selectStoreImageClick() {
        return e.g.a.c.a.a(this.selectStoreImageButton);
    }

    public void setupThemeSelector() {
        this.themeSelectorView.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        ThemeSelectorViewAdapter themeSelectorViewAdapter = new ThemeSelectorViewAdapter(e.g.b.c.f1(), StoreTheme.getThemesFromVersion(8), this.themeManager);
        this.themeSelectorAdapter = themeSelectorViewAdapter;
        this.themeSelectorView.setAdapter(themeSelectorViewAdapter);
        this.themeSelectorAdapter.storeThemeSelection().x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.store.d
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3915f.i((StoreTheme) obj);
            }
        }).f(bindUntilEvent(com.trello.rxlifecycle.g.b.DESTROY_VIEW)).D0();
        this.themeSelectorView.addItemDecoration(new DividerItemDecoration(getContext(), 8.0f, 3));
        this.themeSelectorAdapter.g(this.currentModel.getStoreTheme());
    }

    public void setupToolbarTitle() {
        this.toolbar.setTitle(getViewTitle(this.currentModel));
        ((androidx.appcompat.app.d) getActivity()).setSupportActionBar(this.toolbar);
        androidx.appcompat.app.a supportActionBar = ((androidx.appcompat.app.d) getActivity()).getSupportActionBar();
        supportActionBar.r(false);
        supportActionBar.v(this.toolbar.getTitle());
    }

    @Override // cm.aptoide.pt.account.view.store.ManageStoreView
    public void showError(String str) {
        Snackbar.a0(this.saveDataButton, str, 0).P();
    }

    @Override // cm.aptoide.pt.account.view.ImagePickerView
    public void showIconPropertiesError(InvalidImageException invalidImageException) {
        this.imagePickerErrorHandler.showIconPropertiesError(invalidImageException).f(bindUntilEvent(cm.aptoide.pt.presenter.View.LifecycleEvent.PAUSE)).H0(new rx.m.b() { // from class: cm.aptoide.pt.account.view.store.g
            @Override // rx.m.b
            public final void call(Object obj) {
                ManageStoreFragment.lambda$showIconPropertiesError$0((GenericDialogs.EResponse) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.account.view.store.f
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.account.view.ImagePickerView
    public void showImagePickerDialog() {
        this.dialogFragment.show();
    }

    @Override // cm.aptoide.pt.account.view.store.ManageStoreView
    public void showSuccessMessage() {
        Snackbar.a0(this.saveDataButton, getString(R.string.done), 0).P();
    }

    @Override // cm.aptoide.pt.account.view.store.ManageStoreView
    public void showWaitProgressBar() {
        this.orientationManager.lock();
        ProgressDialog progressDialog = this.waitDialog;
        if (progressDialog == null || progressDialog.isShowing()) {
            return;
        }
        this.waitDialog.show();
    }
}
