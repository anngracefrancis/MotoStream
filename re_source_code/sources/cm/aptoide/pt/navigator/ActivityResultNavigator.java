package cm.aptoide.pt.navigator;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.BaseActivity;
import cm.aptoide.pt.view.fragment.FragmentView;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultNavigator extends BaseActivity implements ActivityNavigator {

    @Inject
    AccountNavigator accountNavigator;
    private FragmentNavigator fragmentNavigator;
    private Map<Integer, Result> fragmentResultMap;
    private e.g.b.a<Map<Integer, Result>> fragmentResultRelay;

    @Inject
    @Named
    String marketName;
    private e.g.b.c<Result> resultRelay;

    @Inject
    public ThemeManager themeManager;

    public AccountNavigator getAccountNavigator() {
        return this.accountNavigator;
    }

    @Override // cm.aptoide.pt.navigator.ActivityNavigator
    public Activity getActivity() {
        return this;
    }

    public ActivityNavigator getActivityNavigator() {
        return this;
    }

    public FragmentNavigator getFragmentNavigator() {
        return this.fragmentNavigator;
    }

    public Map<Integer, Result> getFragmentResultMap() {
        return this.fragmentResultMap;
    }

    public e.g.b.a<Map<Integer, Result>> getFragmentResultRelay() {
        return this.fragmentResultRelay;
    }

    @Override // cm.aptoide.pt.navigator.ActivityNavigator
    public void navigateBack() {
        finish();
    }

    @Override // cm.aptoide.pt.navigator.ActivityNavigator
    public void navigateBackWithResult(int i2, Bundle bundle) {
        setResult(i2, new Intent().putExtras(bundle));
        finish();
    }

    @Override // cm.aptoide.pt.navigator.ActivityNavigator
    public void navigateForResult(Class<? extends Activity> cls, int i2, Bundle bundle) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this, cls));
        intent.putExtras(bundle);
        startActivityForResult(intent, i2);
    }

    @Override // cm.aptoide.pt.navigator.ActivityNavigator
    public rx.e<Result> navigateForResultWithOutput(String str, Uri uri, final int i2) {
        Intent intent = new Intent(str);
        if (intent.resolveActivity(getPackageManager()) == null) {
            return rx.e.B();
        }
        intent.putExtra("output", uri);
        startActivityForResult(intent, i2);
        return this.resultRelay.D(new rx.m.e() { // from class: cm.aptoide.pt.navigator.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Result) obj).getRequestCode() == i2);
            }
        });
    }

    @Override // cm.aptoide.pt.navigator.ActivityNavigator
    public void navigateTo(Class<? extends Activity> cls) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this, cls));
        startActivity(intent);
    }

    @Override // cm.aptoide.pt.navigator.ActivityNavigator
    public void navigateWithIntent(Intent intent) {
        startActivity(intent);
    }

    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.resultRelay.call(new Result(i2, i3, intent));
        Fragment fragment = getFragmentNavigator().getFragment();
        if (fragment == null || !(fragment instanceof FragmentView) || ((FragmentView) fragment).isStartActivityForResultCalled()) {
            return;
        }
        fragment.onActivityResult(i2, i3, intent);
    }

    @Override // cm.aptoide.pt.view.BaseActivity, com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.fragmentResultRelay = ((AptoideApplication) getApplicationContext()).getFragmentResultRelay();
        this.fragmentResultMap = ((AptoideApplication) getApplicationContext()).getFragmentResultMap();
        this.fragmentNavigator = new FragmentResultNavigator(getSupportFragmentManager(), R.id.fragment_placeholder, android.R.anim.fade_in, android.R.anim.fade_out, this.fragmentResultMap, this.fragmentResultRelay);
        super.onCreate(bundle);
        this.resultRelay = e.g.b.c.f1();
        getActivityComponent().inject(this);
    }

    @Override // cm.aptoide.pt.navigator.ActivityNavigator
    public rx.e<Result> results(final int i2) {
        return this.resultRelay.D(new rx.m.e() { // from class: cm.aptoide.pt.navigator.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Result) obj).getRequestCode() == i2);
            }
        });
    }

    @Override // cm.aptoide.pt.navigator.ActivityNavigator
    public rx.e<Result> results() {
        return this.resultRelay;
    }

    @Override // cm.aptoide.pt.navigator.ActivityNavigator
    public void navigateTo(Class<? extends Activity> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this, cls));
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override // cm.aptoide.pt.navigator.ActivityNavigator
    public void navigateForResult(Intent intent, int i2) {
        startActivityForResult(intent, i2);
    }

    @Override // cm.aptoide.pt.navigator.ActivityNavigator
    public rx.e<Result> navigateForResult(String str, Uri uri, final int i2) {
        startActivityForResult(new Intent(str, uri), i2);
        return this.resultRelay.D(new rx.m.e() { // from class: cm.aptoide.pt.navigator.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Result) obj).getRequestCode() == i2);
            }
        });
    }

    @Override // cm.aptoide.pt.navigator.ActivityNavigator
    public void navigateForResult(String str, Uri uri, int i2, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.setData(uri);
        intent.putExtra(str2, str3);
        startActivityForResult(intent, i2);
    }

    @Override // cm.aptoide.pt.navigator.ActivityNavigator
    public void navigateTo(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.setFlags(268435456);
        startActivity(intent);
    }
}
