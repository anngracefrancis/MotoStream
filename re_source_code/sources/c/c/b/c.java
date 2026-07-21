package c.c.b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: compiled from: CustomTabsIntent.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final Intent a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f2886b;

    /* JADX INFO: compiled from: CustomTabsIntent.java */
    public static final class a {
        private final Intent a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList<Bundle> f2887b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bundle f2888c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ArrayList<Bundle> f2889d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f2890e;

        public a() {
            this(null);
        }

        public a a() {
            this.a.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", true);
            return this;
        }

        public a b(String str, PendingIntent pendingIntent) {
            if (this.f2887b == null) {
                this.f2887b = new ArrayList<>();
            }
            Bundle bundle = new Bundle();
            bundle.putString("android.support.customtabs.customaction.MENU_ITEM_TITLE", str);
            bundle.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", pendingIntent);
            this.f2887b.add(bundle);
            return this;
        }

        public c c() {
            ArrayList<Bundle> arrayList = this.f2887b;
            if (arrayList != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f2889d;
            if (arrayList2 != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f2890e);
            return new c(this.a, this.f2888c);
        }

        public a d(Bitmap bitmap) {
            this.a.putExtra("android.support.customtabs.extra.CLOSE_BUTTON_ICON", bitmap);
            return this;
        }

        public a e(Context context, int i2, int i3) {
            this.a.putExtra("android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE", androidx.core.app.b.a(context, i2, i3).b());
            return this;
        }

        public a f(boolean z) {
            this.a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", z ? 1 : 0);
            return this;
        }

        public a g(Context context, int i2, int i3) {
            this.f2888c = androidx.core.app.b.a(context, i2, i3).b();
            return this;
        }

        public a h(int i2) {
            this.a.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", i2);
            return this;
        }

        public a(e eVar) {
            Intent intent = new Intent("android.intent.action.VIEW");
            this.a = intent;
            this.f2887b = null;
            this.f2888c = null;
            this.f2889d = null;
            this.f2890e = true;
            if (eVar != null) {
                intent.setPackage(eVar.b().getPackageName());
            }
            Bundle bundle = new Bundle();
            androidx.core.app.e.b(bundle, "android.support.customtabs.extra.SESSION", eVar != null ? eVar.a() : null);
            intent.putExtras(bundle);
        }
    }

    c(Intent intent, Bundle bundle) {
        this.a = intent;
        this.f2886b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.a.setData(uri);
        androidx.core.content.a.k(context, this.a, this.f2886b);
    }
}
