package androidx.core.app;

import android.app.ActivityOptions;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: ActivityOptionsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: compiled from: ActivityOptionsCompat.java */
    private static class a extends b {
        private final ActivityOptions a;

        a(ActivityOptions activityOptions) {
            this.a = activityOptions;
        }

        @Override // androidx.core.app.b
        public Bundle b() {
            return this.a.toBundle();
        }
    }

    protected b() {
    }

    public static b a(Context context, int i2, int i3) {
        return Build.VERSION.SDK_INT >= 16 ? new a(ActivityOptions.makeCustomAnimation(context, i2, i3)) : new b();
    }

    public Bundle b() {
        return null;
    }
}
