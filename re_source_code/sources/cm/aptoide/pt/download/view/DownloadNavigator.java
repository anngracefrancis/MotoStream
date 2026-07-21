package cm.aptoide.pt.download.view;

import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.fragment.app.Fragment;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceDialogFragment;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceNavigatorWrapper;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.navigator.Result;
import cm.aptoide.pt.utils.AptoideUtils;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DownloadNavigator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcm/aptoide/pt/download/view/DownloadNavigator;", HttpUrl.FRAGMENT_ENCODE_SET, "fragment", "Landroidx/fragment/app/Fragment;", "packageManager", "Landroid/content/pm/PackageManager;", "fragmentNavigator", "Lcm/aptoide/pt/navigator/FragmentNavigator;", "(Landroidx/fragment/app/Fragment;Landroid/content/pm/PackageManager;Lcm/aptoide/pt/navigator/FragmentNavigator;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "getFragmentNavigator", "()Lcm/aptoide/pt/navigator/FragmentNavigator;", "getPackageManager", "()Landroid/content/pm/PackageManager;", "openApp", "Lrx/Completable;", "packageName", HttpUrl.FRAGMENT_ENCODE_SET, "openOutOfSpaceDialog", "requiredSpace", HttpUrl.FRAGMENT_ENCODE_SET, "outOfSpaceDialogResult", "Lrx/Observable;", "Lcm/aptoide/pt/download/view/outofspace/OutOfSpaceNavigatorWrapper;", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DownloadNavigator {
    private final Fragment fragment;
    private final FragmentNavigator fragmentNavigator;
    private final PackageManager packageManager;

    public DownloadNavigator(Fragment fragment, PackageManager packageManager, FragmentNavigator fragmentNavigator) {
        kotlin.jvm.internal.m.f(fragment, "fragment");
        kotlin.jvm.internal.m.f(packageManager, "packageManager");
        kotlin.jvm.internal.m.f(fragmentNavigator, "fragmentNavigator");
        this.fragment = fragment;
        this.packageManager = packageManager;
        this.fragmentNavigator = fragmentNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: openApp$lambda-0, reason: not valid java name */
    public static final void m77openApp$lambda0(String str, DownloadNavigator downloadNavigator) {
        kotlin.jvm.internal.m.f(str, "$packageName");
        kotlin.jvm.internal.m.f(downloadNavigator, "this$0");
        AptoideUtils.SystemU.openApp(str, downloadNavigator.packageManager, downloadNavigator.fragment.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: openOutOfSpaceDialog$lambda-1, reason: not valid java name */
    public static final void m78openOutOfSpaceDialog$lambda1(DownloadNavigator downloadNavigator, long j2, String str) {
        kotlin.jvm.internal.m.f(downloadNavigator, "this$0");
        kotlin.jvm.internal.m.f(str, "$packageName");
        downloadNavigator.fragmentNavigator.navigateToDialogForResult(OutOfSpaceDialogFragment.INSTANCE.newInstance(j2, str), 1994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: outOfSpaceDialogResult$lambda-2, reason: not valid java name */
    public static final OutOfSpaceNavigatorWrapper m79outOfSpaceDialogResult$lambda2(Result result) {
        String str;
        kotlin.jvm.internal.m.f(result, "result");
        boolean z = result.getResultCode() == -1;
        if (result.getData() != null) {
            Intent data = result.getData();
            kotlin.jvm.internal.m.c(data);
            str = data.getPackage();
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return new OutOfSpaceNavigatorWrapper(z, str);
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final FragmentNavigator getFragmentNavigator() {
        return this.fragmentNavigator;
    }

    public final PackageManager getPackageManager() {
        return this.packageManager;
    }

    public final rx.b openApp(final String str) {
        kotlin.jvm.internal.m.f(str, "packageName");
        rx.b bVarT = rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.download.view.e
            @Override // rx.m.a
            public final void call() {
                DownloadNavigator.m77openApp$lambda0(str, this);
            }
        });
        kotlin.jvm.internal.m.e(bVarT, "fromAction {\n      Aptoi…, fragment.context)\n    }");
        return bVarT;
    }

    public final rx.b openOutOfSpaceDialog(final long j2, final String str) {
        kotlin.jvm.internal.m.f(str, "packageName");
        rx.b bVarT = rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.download.view.c
            @Override // rx.m.a
            public final void call() {
                DownloadNavigator.m78openOutOfSpaceDialog$lambda1(this.f5094f, j2, str);
            }
        });
        kotlin.jvm.internal.m.e(bVarT, "fromAction {\n      fragm…SPACE_REQUEST_CODE)\n    }");
        return bVarT;
    }

    public final rx.e<OutOfSpaceNavigatorWrapper> outOfSpaceDialogResult() {
        rx.e eVarX = this.fragmentNavigator.results(1994).X(new rx.m.e() { // from class: cm.aptoide.pt.download.view.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DownloadNavigator.m79outOfSpaceDialogResult$lambda2((Result) obj);
            }
        });
        kotlin.jvm.internal.m.e(eVarX, "fragmentNavigator.result…kage() else \"\")\n        }");
        return eVarX;
    }
}
