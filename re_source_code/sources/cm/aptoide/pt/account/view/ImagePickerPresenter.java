package cm.aptoide.pt.account.view;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import cm.aptoide.pt.account.view.exception.InvalidImageException;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.permission.AccountPermissionProvider;
import cm.aptoide.pt.permission.PermissionProvider;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class ImagePickerPresenter implements Presenter {
    private static final int CAMERA_PICK = 6;
    private static final int GALLERY_PICK = 5;
    private final AccountPermissionProvider accountPermissionProvider;
    private final ContentResolver contentResolver;
    private final CrashReport crashReport;
    private final ImageLoader imageLoader;
    private final ImageValidator imageValidator;
    private final rx.h ioScheduler;
    private final ImagePickerNavigator navigator;
    private final PhotoFileGenerator photoFileGenerator;
    private final rx.h uiScheduler;
    private final UriToPathResolver uriToPathResolver;
    private final ImagePickerView view;

    public ImagePickerPresenter(ImagePickerView imagePickerView, CrashReport crashReport, AccountPermissionProvider accountPermissionProvider, PhotoFileGenerator photoFileGenerator, ImageValidator imageValidator, rx.h hVar, UriToPathResolver uriToPathResolver, ImagePickerNavigator imagePickerNavigator, ContentResolver contentResolver, ImageLoader imageLoader, rx.h hVar2) {
        this.view = imagePickerView;
        this.crashReport = crashReport;
        this.accountPermissionProvider = accountPermissionProvider;
        this.photoFileGenerator = photoFileGenerator;
        this.imageValidator = imageValidator;
        this.uiScheduler = hVar;
        this.uriToPathResolver = uriToPathResolver;
        this.navigator = imagePickerNavigator;
        this.contentResolver = contentResolver;
        this.imageLoader = imageLoader;
        this.ioScheduler = hVar2;
    }

    private Single<String> getFileNameFromCameraWithUri(final String str) {
        return this.navigator.navigateToCameraWithImageUri(6, Uri.parse(str)).E().j0(this.ioScheduler).L(new rx.m.e() { // from class: cm.aptoide.pt.account.view.l0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3859f.a(str, (Void) obj);
            }
        }).Z0();
    }

    private void handleCameraImageResult() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.s0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.f0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3847f.g((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.account.view.u
            @Override // rx.m.b
            public final void call(Object obj) {
                ImagePickerPresenter.lambda$handleCameraImageResult$35((String) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.account.view.d0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3843f.h((Throwable) obj);
            }
        });
    }

    private void handleCameraSelection() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.x
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.i0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3853f.k((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.account.view.o0
            @Override // rx.m.b
            public final void call(Object obj) {
                ImagePickerPresenter.lambda$handleCameraSelection$10((DialogInterface) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.account.view.k
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3856f.i((Throwable) obj);
            }
        });
    }

    private void handleGalleryImageResult() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3849f.p((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.account.view.q0
            @Override // rx.m.b
            public final void call(Object obj) {
                ImagePickerPresenter.lambda$handleGalleryImageResult$19((String) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.account.view.m0
            @Override // rx.m.b
            public final void call(Object obj) {
                ImagePickerPresenter.lambda$handleGalleryImageResult$20((Throwable) obj);
            }
        });
    }

    private void handleGallerySelection() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.v
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4028f.r((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.account.view.t
            @Override // rx.m.b
            public final void call(Object obj) {
                ImagePickerPresenter.lambda$handleGallerySelection$25((DialogInterface) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.account.view.j
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3854f.s((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getFileNameFromCameraWithUri$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single a(String str, Void r2) {
        return saveCameraPictureInPublicPhotos(str);
    }

    static /* synthetic */ Boolean lambda$handleCameraImageResult$28(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!((PermissionProvider.Permission) it.next()).isGranted()) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCameraImageResult$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(List list) {
        this.view.dismissLoadImageDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCameraImageResult$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single c(List list) {
        return this.photoFileGenerator.generateNewImageFileUriAsString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCameraImageResult$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b e(String str) {
        return getFileNameFromCameraWithUri(str).p(this.uiScheduler).j(new rx.m.e() { // from class: cm.aptoide.pt.account.view.h0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3851f.d((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCameraImageResult$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Throwable th) {
        if (th instanceof InvalidImageException) {
            this.view.showIconPropertiesError((InvalidImageException) th);
        } else {
            this.crashReport.log(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCameraImageResult$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e g(View.LifecycleEvent lifecycleEvent) {
        return this.accountPermissionProvider.permissionResultCamera(6).D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.w
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ImagePickerPresenter.lambda$handleCameraImageResult$28((List) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.t0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3950f.b((List) obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.account.view.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3891f.c((List) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.account.view.c0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3839f.e((String) obj);
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.account.view.k0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3857f.f((Throwable) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleCameraImageResult$35(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCameraImageResult$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(Throwable th) {
        this.crashReport.log(th);
    }

    static /* synthetic */ void lambda$handleCameraSelection$10(DialogInterface dialogInterface) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCameraSelection$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCameraSelection$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(DialogInterface dialogInterface) {
        this.accountPermissionProvider.requestCameraPermission(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCameraSelection$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e k(View.LifecycleEvent lifecycleEvent) {
        return this.view.dialogCameraSelected().x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.j0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3855f.j((DialogInterface) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGalleryImageResult$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(List list) {
        this.view.dismissLoadImageDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGalleryImageResult$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e m(List list) {
        return this.navigator.navigateToGalleryForImageUri(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGalleryImageResult$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(Throwable th) {
        this.crashReport.log(th);
        if (th instanceof InvalidImageException) {
            this.view.showIconPropertiesError((InvalidImageException) th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGalleryImageResult$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e p(View.LifecycleEvent lifecycleEvent) {
        return this.accountPermissionProvider.permissionResultCamera(5).D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((PermissionProvider.Permission) ((List) obj).get(0)).isGranted());
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.e0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3845f.l((List) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.a0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3833f.m((List) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.account.view.z
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4036f.n((String) obj);
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.account.view.r
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3900f.o((Throwable) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleGalleryImageResult$19(String str) {
    }

    static /* synthetic */ void lambda$handleGalleryImageResult$20(Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGallerySelection$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(DialogInterface dialogInterface) {
        this.accountPermissionProvider.requestGalleryPermission(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGallerySelection$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e r(View.LifecycleEvent lifecycleEvent) {
        return this.view.dialogGallerySelected().x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.b0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3836f.q((DialogInterface) obj);
            }
        });
    }

    static /* synthetic */ void lambda$handleGallerySelection$25(DialogInterface dialogInterface) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleGallerySelection$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePickImageClick$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(Void r1) {
        this.view.showImagePickerDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePickImageClick$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e u(View.LifecycleEvent lifecycleEvent) {
        return this.view.selectStoreImageClick().s0().x(new rx.m.b() { // from class: cm.aptoide.pt.account.view.q
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3898f.t((Void) obj);
            }
        });
    }

    static /* synthetic */ void lambda$handlePickImageClick$3(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handlePickImageClick$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadValidImageOrThrowForCamera$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String str) {
        this.view.loadImage(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadValidImageOrThrowForGallery$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(String str) {
        this.view.loadImage(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadValidImageOrThrowForCamera, reason: merged with bridge method [inline-methods] */
    public rx.b d(final String str) {
        return this.imageValidator.validateOrGetException(str).z(this.uiScheduler).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.y
            @Override // rx.m.a
            public final void call() {
                this.f4033f.w(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadValidImageOrThrowForGallery, reason: merged with bridge method [inline-methods] */
    public rx.b n(final String str) {
        return this.imageValidator.validateOrGetException(str).z(this.uiScheduler).m(new rx.m.a() { // from class: cm.aptoide.pt.account.view.n0
            @Override // rx.m.a
            public final void call() {
                this.f3892f.x(str);
            }
        });
    }

    private Single<String> saveCameraPictureInPublicPhotos(String str) {
        Bitmap bitmapLoadBitmap = this.imageLoader.loadBitmap(str);
        if (bitmapLoadBitmap == null) {
            return Single.m(str).v(this.ioScheduler);
        }
        String strInsertImage = MediaStore.Images.Media.insertImage(this.contentResolver, bitmapLoadBitmap, str.substring(str.lastIndexOf(File.pathSeparator)), (String) null);
        bitmapLoadBitmap.recycle();
        return Single.m(strInsertImage).v(this.ioScheduler);
    }

    public void handlePickImageClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.account.view.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.account.view.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3896f.u((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.account.view.p0
            @Override // rx.m.b
            public final void call(Object obj) {
                ImagePickerPresenter.lambda$handlePickImageClick$3((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.account.view.r0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3901f.v((Throwable) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        handlePickImageClick();
        handleCameraSelection();
        handleCameraImageResult();
        handleGallerySelection();
        handleGalleryImageResult();
    }
}
