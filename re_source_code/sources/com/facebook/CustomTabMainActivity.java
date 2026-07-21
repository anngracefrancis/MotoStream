package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.internal.p0;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: CustomTabMainActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u001a\u0010\u0011J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/facebook/CustomTabMainActivity;", "Landroid/app/Activity;", HttpUrl.FRAGMENT_ENCODE_SET, "resultCode", "Landroid/content/Intent;", "resultIntent", "Lkotlin/u;", "a", "(ILandroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onResume", "()V", "Landroid/content/BroadcastReceiver;", "o", "Landroid/content/BroadcastReceiver;", "redirectReceiver", HttpUrl.FRAGMENT_ENCODE_SET, "n", "Z", "shouldCloseCustomTab", "<init>", "f", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class CustomTabMainActivity extends Activity {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9590g = kotlin.jvm.internal.m.n(CustomTabMainActivity.class.getSimpleName(), ".extra_action");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9591h = kotlin.jvm.internal.m.n(CustomTabMainActivity.class.getSimpleName(), ".extra_params");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f9592i = kotlin.jvm.internal.m.n(CustomTabMainActivity.class.getSimpleName(), ".extra_chromePackage");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9593j = kotlin.jvm.internal.m.n(CustomTabMainActivity.class.getSimpleName(), ".extra_url");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9594k = kotlin.jvm.internal.m.n(CustomTabMainActivity.class.getSimpleName(), ".extra_targetApp");
    public static final String l = kotlin.jvm.internal.m.n(CustomTabMainActivity.class.getSimpleName(), ".action_refresh");
    public static final String m = kotlin.jvm.internal.m.n(CustomTabMainActivity.class.getSimpleName(), ".no_activity_exception");

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private boolean shouldCloseCustomTab = true;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private BroadcastReceiver redirectReceiver;

    /* JADX INFO: renamed from: com.facebook.CustomTabMainActivity$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: CustomTabMainActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bundle b(String str) {
            Uri uri = Uri.parse(str);
            p0 p0Var = p0.a;
            Bundle bundleO0 = p0.o0(uri.getQuery());
            bundleO0.putAll(p0.o0(uri.getFragment()));
            return bundleO0;
        }
    }

    /* JADX INFO: compiled from: CustomTabMainActivity.kt */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.facebook.login.z.valuesCustom().length];
            iArr[com.facebook.login.z.INSTAGRAM.ordinal()] = 1;
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: CustomTabMainActivity.kt */
    public static final class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            kotlin.jvm.internal.m.f(context, "context");
            kotlin.jvm.internal.m.f(intent, "intent");
            Intent intent2 = new Intent(CustomTabMainActivity.this, (Class<?>) CustomTabMainActivity.class);
            intent2.setAction(CustomTabMainActivity.l);
            String str = CustomTabMainActivity.f9593j;
            intent2.putExtra(str, intent.getStringExtra(str));
            intent2.addFlags(603979776);
            CustomTabMainActivity.this.startActivity(intent2);
        }
    }

    private final void a(int resultCode, Intent resultIntent) {
        BroadcastReceiver broadcastReceiver = this.redirectReceiver;
        if (broadcastReceiver != null) {
            c.q.a.a.b(this).e(broadcastReceiver);
        }
        if (resultIntent != null) {
            String stringExtra = resultIntent.getStringExtra(f9593j);
            Bundle bundleB = stringExtra != null ? INSTANCE.b(stringExtra) : new Bundle();
            com.facebook.internal.k0 k0Var = com.facebook.internal.k0.a;
            Intent intent = getIntent();
            kotlin.jvm.internal.m.e(intent, "intent");
            Intent intentL = com.facebook.internal.k0.l(intent, bundleB, null);
            if (intentL != null) {
                resultIntent = intentL;
            }
            setResult(resultCode, resultIntent);
        } else {
            com.facebook.internal.k0 k0Var2 = com.facebook.internal.k0.a;
            Intent intent2 = getIntent();
            kotlin.jvm.internal.m.e(intent2, "intent");
            setResult(resultCode, com.facebook.internal.k0.l(intent2, null, null));
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        String stringExtra;
        super.onCreate(savedInstanceState);
        String str = CustomTabActivity.f9586g;
        if (kotlin.jvm.internal.m.a(str, getIntent().getAction())) {
            setResult(0);
            finish();
            return;
        }
        if (savedInstanceState != null || (stringExtra = getIntent().getStringExtra(f9590g)) == null) {
            return;
        }
        Bundle bundleExtra = getIntent().getBundleExtra(f9591h);
        boolean zA = (b.a[com.facebook.login.z.f10065f.a(getIntent().getStringExtra(f9594k)).ordinal()] == 1 ? new com.facebook.internal.f0(stringExtra, bundleExtra) : new com.facebook.internal.u(stringExtra, bundleExtra)).a(this, getIntent().getStringExtra(f9592i));
        this.shouldCloseCustomTab = false;
        if (!zA) {
            setResult(0, getIntent().putExtra(m, true));
            finish();
        } else {
            c cVar = new c();
            this.redirectReceiver = cVar;
            c.q.a.a.b(this).c(cVar, new IntentFilter(str));
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        kotlin.jvm.internal.m.f(intent, "intent");
        super.onNewIntent(intent);
        if (kotlin.jvm.internal.m.a(l, intent.getAction())) {
            c.q.a.a.b(this).d(new Intent(CustomTabActivity.f9587h));
            a(-1, intent);
        } else if (kotlin.jvm.internal.m.a(CustomTabActivity.f9586g, intent.getAction())) {
            a(-1, intent);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.shouldCloseCustomTab) {
            a(0, null);
        }
        this.shouldCloseCustomTab = true;
    }
}
