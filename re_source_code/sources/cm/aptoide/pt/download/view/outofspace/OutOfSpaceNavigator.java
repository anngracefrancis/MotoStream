package cm.aptoide.pt.download.view.outofspace;

import android.content.Intent;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.navigator.Result;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: OutOfSpaceNavigator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcm/aptoide/pt/download/view/outofspace/OutOfSpaceNavigator;", HttpUrl.FRAGMENT_ENCODE_SET, "fragmentNavigator", "Lcm/aptoide/pt/navigator/FragmentNavigator;", "packageName", HttpUrl.FRAGMENT_ENCODE_SET, "(Lcm/aptoide/pt/navigator/FragmentNavigator;Ljava/lang/String;)V", "clearedEnoughSpace", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OutOfSpaceNavigator {
    private final FragmentNavigator fragmentNavigator;
    private final String packageName;

    public OutOfSpaceNavigator(FragmentNavigator fragmentNavigator, String str) {
        kotlin.jvm.internal.m.f(fragmentNavigator, "fragmentNavigator");
        kotlin.jvm.internal.m.f(str, "packageName");
        this.fragmentNavigator = fragmentNavigator;
        this.packageName = str;
    }

    public final void clearedEnoughSpace() {
        this.fragmentNavigator.popDialogWithResult(new Result(1994, -1, new Intent().setPackage(this.packageName)));
    }
}
