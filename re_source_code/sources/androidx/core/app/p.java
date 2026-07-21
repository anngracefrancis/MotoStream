package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: TaskStackBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public final class p implements Iterable<Intent> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayList<Intent> f934f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f935g;

    /* JADX INFO: compiled from: TaskStackBuilder.java */
    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private p(Context context) {
        this.f935g = context;
    }

    public static p h(Context context) {
        return new p(context);
    }

    public p c(Intent intent) {
        this.f934f.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p f(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = g.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f935g.getPackageManager());
            }
            g(component);
            c(supportParentActivityIntent);
        }
        return this;
    }

    public p g(ComponentName componentName) {
        int size = this.f934f.size();
        try {
            Intent intentB = g.b(this.f935g, componentName);
            while (intentB != null) {
                this.f934f.add(size, intentB);
                intentB = g.b(this.f935g, intentB.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    public void i() {
        n(null);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f934f.iterator();
    }

    public void n(Bundle bundle) {
        if (this.f934f.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        ArrayList<Intent> arrayList = this.f934f;
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (androidx.core.content.a.j(this.f935g, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f935g.startActivity(intent);
    }
}
