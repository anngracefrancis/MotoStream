package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: CustomTabActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u000fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/facebook/CustomTabActivity;", "Landroid/app/Activity;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/u;", "onCreate", "(Landroid/os/Bundle;)V", HttpUrl.FRAGMENT_ENCODE_SET, "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onDestroy", "()V", "Landroid/content/BroadcastReceiver;", "i", "Landroid/content/BroadcastReceiver;", "closeReceiver", "<init>", "f", "a", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class CustomTabActivity extends Activity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9586g = kotlin.jvm.internal.m.n(CustomTabActivity.class.getSimpleName(), ".action_customTabRedirect");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9587h = kotlin.jvm.internal.m.n(CustomTabActivity.class.getSimpleName(), ".action_destroy");

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private BroadcastReceiver closeReceiver;

    /* JADX INFO: compiled from: CustomTabActivity.kt */
    public static final class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            kotlin.jvm.internal.m.f(context, "context");
            kotlin.jvm.internal.m.f(intent, "intent");
            CustomTabActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 0) {
            Intent intent = new Intent(f9586g);
            intent.putExtra(CustomTabMainActivity.f9593j, getIntent().getDataString());
            c.q.a.a.b(this).d(intent);
            b bVar = new b();
            c.q.a.a.b(this).c(bVar, new IntentFilter(f9587h));
            this.closeReceiver = bVar;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, (Class<?>) CustomTabMainActivity.class);
        intent.setAction(f9586g);
        intent.putExtra(CustomTabMainActivity.f9593j, getIntent().getDataString());
        intent.addFlags(603979776);
        startActivityForResult(intent, 2);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.closeReceiver;
        if (broadcastReceiver != null) {
            c.q.a.a.b(this).e(broadcastReceiver);
        }
        super.onDestroy();
    }
}
