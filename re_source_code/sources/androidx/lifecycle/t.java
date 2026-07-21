package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: ReportFragment.java */
/* JADX INFO: loaded from: classes.dex */
public class t extends Fragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f1767f;

    /* JADX INFO: compiled from: ReportFragment.java */
    interface a {
        void a();

        void onResume();

        void onStart();
    }

    /* JADX INFO: compiled from: ReportFragment.java */
    static class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        static void registerIn(Activity activity) {
            activity.registerActivityLifecycleCallbacks(new b());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            t.a(activity, g.b.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            t.a(activity, g.b.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            t.a(activity, g.b.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            t.a(activity, g.b.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            t.a(activity, g.b.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            t.a(activity, g.b.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void a(Activity activity, g.b bVar) {
        if (activity instanceof m) {
            ((m) activity).getLifecycle().h(bVar);
        } else if (activity instanceof k) {
            g lifecycle = ((k) activity).getLifecycle();
            if (lifecycle instanceof l) {
                ((l) lifecycle).h(bVar);
            }
        }
    }

    private void b(g.b bVar) {
        if (Build.VERSION.SDK_INT < 29) {
            a(getActivity(), bVar);
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            aVar.onResume();
        }
    }

    private void e(a aVar) {
        if (aVar != null) {
            aVar.onStart();
        }
    }

    static t f(Activity activity) {
        return (t) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    public static void g(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.registerIn(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new t(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    void h(a aVar) {
        this.f1767f = aVar;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        c(this.f1767f);
        b(g.b.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        b(g.b.ON_DESTROY);
        this.f1767f = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        b(g.b.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        d(this.f1767f);
        b(g.b.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        e(this.f1767f);
        b(g.b.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        b(g.b.ON_STOP);
    }
}
