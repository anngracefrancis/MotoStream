package cm.aptoide.pt.account.view.user;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.view.ImagePickerErrorHandler;
import cm.aptoide.pt.account.view.ImagePickerPresenter;
import cm.aptoide.pt.account.view.exception.InvalidImageException;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.orientation.ScreenOrientationManager;
import cm.aptoide.pt.presenter.CompositePresenter;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.utils.GenericDialogs;
import cm.aptoide.pt.view.BackButtonFragment;
import cm.aptoide.pt.view.NotBottomNavigationView;
import cm.aptoide.pt.view.dialog.ImagePickerDialog;
import com.google.android.material.snackbar.Snackbar;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class ManageUserFragment extends BackButtonFragment implements ManageUserView, NotBottomNavigationView {
    private static final int DEFAULT_IMAGE_PLACEHOLDER = 2131231053;
    private static final String EXTRA_IS_EDIT = "is_edit";
    private static final String EXTRA_USER_MODEL = "user_model";
    private Button cancelUserProfile;
    private Button createUserButton;
    private ViewModel currentModel;
    private ImagePickerDialog dialogFragment;
    private ImagePickerErrorHandler imagePickerErrorHandler;

    @Inject
    ImagePickerPresenter imagePickerPresenter;
    private boolean isEditProfile;

    @Inject
    ManageUserPresenter manageUserPresenter;

    @Inject
    NewsletterManager newsletterManager;

    @Inject
    ScreenOrientationManager orientationManager;

    @Inject
    ThemeManager themeManager;
    private Toolbar toolbar;
    private ProgressDialog uploadWaitDialog;
    private EditText userName;
    private ImageView userPicture;
    private RelativeLayout userPictureLayout;

    private void attachPresenters() {
        attachPresenter(new CompositePresenter(Arrays.asList(this.manageUserPresenter, this.imagePickerPresenter)));
    }

    private void bindViews(View view) {
        this.toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        this.userPictureLayout = (RelativeLayout) view.findViewById(R.id.create_user_image_action);
        this.userName = (EditText) view.findViewById(R.id.create_user_username_inserted);
        this.createUserButton = (Button) view.findViewById(R.id.create_user_create_profile);
        this.cancelUserProfile = (Button) view.findViewById(R.id.create_user_cancel_button);
        this.userPicture = (ImageView) view.findViewById(R.id.create_user_image);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$saveUserDataButtonClick$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ ViewModel e(Void r1) {
        return updateModelAndGet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showErrorMessage$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Snackbar f(String str) throws Exception {
        return Snackbar.a0(this.createUserButton, str, 0);
    }

    static /* synthetic */ rx.b lambda$showErrorMessage$2(Snackbar snackbar) {
        snackbar.P();
        return e.g.a.b.a.a.c.a(snackbar).X0();
    }

    static /* synthetic */ void lambda$showIconPropertiesError$3(GenericDialogs.EResponse eResponse) {
    }

    private static ManageUserFragment newInstance(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(EXTRA_IS_EDIT, z);
        ManageUserFragment manageUserFragment = new ManageUserFragment();
        manageUserFragment.setArguments(bundle);
        return manageUserFragment;
    }

    public static ManageUserFragment newInstanceToCreate() {
        return newInstance(false);
    }

    public static ManageUserFragment newInstanceToEdit() {
        return newInstance(true);
    }

    private void setupCalendar(Calendar calendar, int i2, int i3, int i4) {
        calendar.set(1, i2);
        calendar.set(2, i3);
        calendar.set(5, i4);
    }

    private void setupToolbar() {
        if (this.isEditProfile) {
            this.toolbar.setTitle(getString(R.string.edit_profile_title));
        } else {
            this.toolbar.setTitle(R.string.create_user_title);
        }
        ((androidx.appcompat.app.d) getActivity()).setSupportActionBar(this.toolbar);
        androidx.appcompat.app.a supportActionBar = ((androidx.appcompat.app.d) getActivity()).getSupportActionBar();
        supportActionBar.r(false);
        supportActionBar.v(this.toolbar.getTitle());
    }

    @Override // cm.aptoide.pt.account.view.user.ManageUserView
    public rx.e<Void> cancelButtonClick() {
        return e.g.a.c.a.a(this.cancelUserProfile);
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

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName());
    }

    @Override // cm.aptoide.pt.account.view.user.ManageUserView
    public void hideProgressDialog() {
        this.uploadWaitDialog.dismiss();
        this.orientationManager.unlock();
    }

    @Override // cm.aptoide.pt.account.view.ImagePickerView
    public void loadImage(String str) {
        loadImageStateless(str);
        this.currentModel.setNewPicture(true);
    }

    @Override // cm.aptoide.pt.account.view.user.ManageUserView
    public void loadImageStateless(String str) {
        this.currentModel.setPictureUri(str);
        ImageLoader.with(getActivity()).loadUsingCircleTransformAndPlaceholder(str, this.userPicture, R.drawable.create_user_avatar);
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        Context context = getContext();
        if (bundle == null || !bundle.containsKey(EXTRA_USER_MODEL)) {
            this.currentModel = new ViewModel();
        } else {
            this.currentModel = (ViewModel) org.parceler.d.a(bundle.getParcelable(EXTRA_USER_MODEL));
        }
        Bundle arguments = getArguments();
        boolean z = false;
        if (arguments != null && arguments.getBoolean(EXTRA_IS_EDIT, false)) {
            z = true;
        }
        this.isEditProfile = z;
        this.imagePickerErrorHandler = new ImagePickerErrorHandler(context, this.themeManager);
        this.dialogFragment = new ImagePickerDialog.Builder(new c.a.o.d(getContext(), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId), this.themeManager).setViewRes(R.layout.dialog_choose_avatar_source).setTitle(R.string.upload_dialog_title).setNegativeButton(R.string.cancel).setCameraButton(R.id.button_camera).setGalleryButton(R.id.button_gallery).build();
        this.uploadWaitDialog = GenericDialogs.createGenericPleaseWaitDialog(context, this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId, context.getString(R.string.please_wait_upload));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_manage_user, viewGroup, false);
    }

    @Override // com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ProgressDialog progressDialog = this.uploadWaitDialog;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.uploadWaitDialog.dismiss();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(EXTRA_USER_MODEL, org.parceler.d.c(this.currentModel));
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bindViews(view);
        setupToolbar();
        if (bundle == null || !bundle.containsKey(EXTRA_USER_MODEL)) {
            this.currentModel = new ViewModel();
        } else {
            ViewModel viewModel = (ViewModel) org.parceler.d.a(bundle.getParcelable(EXTRA_USER_MODEL));
            this.currentModel = viewModel;
            loadImageStateless(viewModel.getPictureUri());
            setUserName(this.currentModel.getName());
        }
        if (this.isEditProfile) {
            this.createUserButton.setText(getString(R.string.edit_profile_save_button));
            this.cancelUserProfile.setVisibility(0);
        }
        attachPresenters();
    }

    @Override // cm.aptoide.pt.account.view.user.ManageUserView
    public rx.e<ViewModel> saveUserDataButtonClick() {
        return e.g.a.c.a.a(this.createUserButton).X(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3965f.e((Void) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.account.view.ImagePickerView
    public rx.e<Void> selectStoreImageClick() {
        return e.g.a.c.a.a(this.userPictureLayout);
    }

    @Override // cm.aptoide.pt.account.view.user.ManageUserView
    public void setUserName(String str) {
        this.currentModel.setName(str);
        this.userName.setText(str);
    }

    @Override // cm.aptoide.pt.account.view.user.ManageUserView
    public rx.b showErrorMessage(final String str) {
        return Single.l(new Callable() { // from class: cm.aptoide.pt.account.view.user.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f3961f.f(str);
            }
        }).j(new rx.m.e() { // from class: cm.aptoide.pt.account.view.user.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ManageUserFragment.lambda$showErrorMessage$2((Snackbar) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.account.view.ImagePickerView
    public void showIconPropertiesError(InvalidImageException invalidImageException) {
        this.imagePickerErrorHandler.showIconPropertiesError(invalidImageException).f(bindUntilEvent(cm.aptoide.pt.presenter.View.LifecycleEvent.PAUSE)).H0(new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.a
            @Override // rx.m.b
            public final void call(Object obj) {
                ManageUserFragment.lambda$showIconPropertiesError$3((GenericDialogs.EResponse) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.account.view.user.e
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

    @Override // cm.aptoide.pt.account.view.user.ManageUserView
    public void showProgressDialog() {
        this.orientationManager.lock();
        hideKeyboard();
        this.uploadWaitDialog.show();
    }

    public ViewModel updateModelAndGet() {
        return ViewModel.from(this.currentModel, this.userName.getText().toString());
    }

    protected static class ViewModel {
        boolean hasNewPicture;
        String name;
        String pictureUri;

        public ViewModel() {
            this.name = HttpUrl.FRAGMENT_ENCODE_SET;
            this.pictureUri = HttpUrl.FRAGMENT_ENCODE_SET;
            this.hasNewPicture = false;
        }

        public static ViewModel from(ViewModel viewModel, String str) {
            viewModel.setName(str);
            return viewModel;
        }

        public String getName() {
            return this.name;
        }

        public String getPictureUri() {
            return this.pictureUri;
        }

        public boolean hasNewPicture() {
            return this.hasNewPicture;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setNewPicture(boolean z) {
            this.hasNewPicture = z;
        }

        public void setPictureUri(String str) {
            this.pictureUri = str;
        }

        public ViewModel(String str, String str2) {
            this.name = str;
            this.pictureUri = str2;
            this.hasNewPicture = false;
            this.hasNewPicture = false;
        }
    }
}
