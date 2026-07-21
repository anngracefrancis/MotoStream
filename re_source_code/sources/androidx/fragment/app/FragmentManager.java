package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentManager {
    private static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static boolean f1494b = true;
    private androidx.activity.result.b<Intent> B;
    private androidx.activity.result.b<IntentSenderRequest> C;
    private androidx.activity.result.b<String[]> D;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private ArrayList<androidx.fragment.app.a> K;
    private ArrayList<Boolean> L;
    private ArrayList<Fragment> M;
    private ArrayList<q> N;
    private androidx.fragment.app.n O;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1496d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList<androidx.fragment.app.a> f1498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList<Fragment> f1499g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private OnBackPressedDispatcher f1501i;
    private ArrayList<n> n;
    private androidx.fragment.app.j<?> t;
    private androidx.fragment.app.f u;
    private Fragment v;
    Fragment w;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<o> f1495c = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final t f1497e = new t();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final androidx.fragment.app.k f1500h = new androidx.fragment.app.k(this);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final androidx.activity.b f1502j = new c(false);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicInteger f1503k = new AtomicInteger();
    private final Map<String, Bundle> l = Collections.synchronizedMap(new HashMap());
    private final Map<String, ?> m = Collections.synchronizedMap(new HashMap());
    private Map<Fragment, HashSet<androidx.core.os.b>> o = Collections.synchronizedMap(new HashMap());
    private final v.g p = new d();
    private final androidx.fragment.app.l q = new androidx.fragment.app.l(this);
    private final CopyOnWriteArrayList<androidx.fragment.app.o> r = new CopyOnWriteArrayList<>();
    int s = -1;
    private androidx.fragment.app.i x = null;
    private androidx.fragment.app.i y = new e();
    private b0 z = null;
    private b0 A = new f();
    ArrayDeque<LaunchedFragmentInfo> E = new ArrayDeque<>();
    private Runnable P = new g();

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentManager$6, reason: invalid class name */
    class AnonymousClass6 implements androidx.lifecycle.i {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.fragment.app.q f1504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ androidx.lifecycle.g f1505c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ FragmentManager f1506d;

        @Override // androidx.lifecycle.i
        public void a(androidx.lifecycle.k kVar, androidx.lifecycle.g.b bVar) {
            Bundle bundle;
            if (bVar == androidx.lifecycle.g.b.ON_START && (bundle = (Bundle) this.f1506d.l.get(this.a)) != null) {
                this.f1504b.a(this.a, bundle);
                this.f1506d.r(this.a);
            }
            if (bVar == androidx.lifecycle.g.b.ON_DESTROY) {
                this.f1505c.c(this);
                this.f1506d.m.remove(this.a);
            }
        }
    }

    class a implements androidx.activity.result.a<ActivityResult> {
        a() {
        }

        @Override // androidx.activity.result.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.E.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f1507f;
            int i2 = launchedFragmentInfoPollFirst.f1508g;
            Fragment fragmentI = FragmentManager.this.f1497e.i(str);
            if (fragmentI != null) {
                fragmentI.onActivityResult(i2, activityResult.b(), activityResult.a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    class b implements androidx.activity.result.a<Map<String, Boolean>> {
        b() {
        }

        @Override // androidx.activity.result.a
        @SuppressLint({"SyntheticAccessor"})
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map<String, Boolean> map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.E.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f1507f;
            int i3 = launchedFragmentInfoPollFirst.f1508g;
            Fragment fragmentI = FragmentManager.this.f1497e.i(str);
            if (fragmentI != null) {
                fragmentI.onRequestPermissionsResult(i3, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    class c extends androidx.activity.b {
        c(boolean z) {
            super(z);
        }

        @Override // androidx.activity.b
        public void b() {
            FragmentManager.this.E0();
        }
    }

    class d implements v.g {
        d() {
        }

        @Override // androidx.fragment.app.v.g
        public void a(Fragment fragment, androidx.core.os.b bVar) {
            if (bVar.b()) {
                return;
            }
            FragmentManager.this.f1(fragment, bVar);
        }

        @Override // androidx.fragment.app.v.g
        public void b(Fragment fragment, androidx.core.os.b bVar) {
            FragmentManager.this.f(fragment, bVar);
        }
    }

    class e extends androidx.fragment.app.i {
        e() {
        }

        @Override // androidx.fragment.app.i
        public Fragment a(ClassLoader classLoader, String str) {
            return FragmentManager.this.w0().b(FragmentManager.this.w0().f(), str, null);
        }
    }

    class f implements b0 {
        f() {
        }

        @Override // androidx.fragment.app.b0
        public a0 a(ViewGroup viewGroup) {
            return new androidx.fragment.app.b(viewGroup);
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.b0(true);
        }
    }

    class h extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1512b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f1513c;

        h(ViewGroup viewGroup, View view, Fragment fragment) {
            this.a = viewGroup;
            this.f1512b = view;
            this.f1513c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.endViewTransition(this.f1512b);
            animator.removeListener(this);
            Fragment fragment = this.f1513c;
            View view = fragment.mView;
            if (view == null || !fragment.mHidden) {
                return;
            }
            view.setVisibility(8);
        }
    }

    class i implements androidx.fragment.app.o {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Fragment f1515f;

        i(Fragment fragment) {
            this.f1515f = fragment;
        }

        @Override // androidx.fragment.app.o
        public void a(FragmentManager fragmentManager, Fragment fragment) {
            this.f1515f.onAttachFragment(fragment);
        }
    }

    class j implements androidx.activity.result.a<ActivityResult> {
        j() {
        }

        @Override // androidx.activity.result.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.E.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f1507f;
            int i2 = launchedFragmentInfoPollFirst.f1508g;
            Fragment fragmentI = FragmentManager.this.f1497e.i(str);
            if (fragmentI != null) {
                fragmentI.onActivityResult(i2, activityResult.b(), activityResult.a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    public interface k {
        String getName();
    }

    static class l extends androidx.activity.result.d.a<IntentSenderRequest, ActivityResult> {
        l() {
        }

        @Override // androidx.activity.result.d.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intentA = intentSenderRequest.a();
            if (intentA != null && (bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intentA.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.b(intentSenderRequest.d()).b(null).c(intentSenderRequest.c(), intentSenderRequest.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // androidx.activity.result.d.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ActivityResult c(int i2, Intent intent) {
            return new ActivityResult(i2, intent);
        }
    }

    public static abstract class m {
    }

    public interface n {
        void a();
    }

    interface o {
        boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    private class p implements o {
        final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f1517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f1518c;

        p(String str, int i2, int i3) {
            this.a = str;
            this.f1517b = i2;
            this.f1518c = i3;
        }

        @Override // androidx.fragment.app.FragmentManager.o
        public boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.w;
            if (fragment == null || this.f1517b >= 0 || this.a != null || !fragment.getChildFragmentManager().a1()) {
                return FragmentManager.this.c1(arrayList, arrayList2, this.a, this.f1517b, this.f1518c);
            }
            return false;
        }
    }

    static class q implements Fragment.k {
        final boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final androidx.fragment.app.a f1520b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1521c;

        q(androidx.fragment.app.a aVar, boolean z) {
            this.a = z;
            this.f1520b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.k
        public void a() {
            this.f1521c++;
        }

        @Override // androidx.fragment.app.Fragment.k
        public void b() {
            int i2 = this.f1521c - 1;
            this.f1521c = i2;
            if (i2 != 0) {
                return;
            }
            this.f1520b.t.o1();
        }

        void c() {
            androidx.fragment.app.a aVar = this.f1520b;
            aVar.t.u(aVar, this.a, false, false);
        }

        void d() {
            boolean z = this.f1521c > 0;
            for (Fragment fragment : this.f1520b.t.v0()) {
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            androidx.fragment.app.a aVar = this.f1520b;
            aVar.t.u(aVar, this.a, !z, true);
        }

        public boolean e() {
            return this.f1521c == 0;
        }
    }

    static Fragment C0(View view) {
        Object tag = view.getTag(c.m.b.a);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    static boolean H0(int i2) {
        return a || Log.isLoggable("FragmentManager", i2);
    }

    private boolean I0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.o();
    }

    private void M(Fragment fragment) {
        if (fragment == null || !fragment.equals(h0(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    private void Q0(c.e.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragmentQ = bVar.q(i2);
            if (!fragmentQ.mAdded) {
                View viewRequireView = fragmentQ.requireView();
                fragmentQ.mPostponedAlpha = viewRequireView.getAlpha();
                viewRequireView.setAlpha(0.0f);
            }
        }
    }

    private void T(int i2) {
        try {
            this.f1496d = true;
            this.f1497e.d(i2);
            S0(i2, false);
            if (f1494b) {
                Iterator<a0> it = s().iterator();
                while (it.hasNext()) {
                    it.next().j();
                }
            }
            this.f1496d = false;
            b0(true);
        } catch (Throwable th) {
            this.f1496d = false;
            throw th;
        }
    }

    private void W() {
        if (this.J) {
            this.J = false;
            u1();
        }
    }

    private void Y() {
        if (f1494b) {
            Iterator<a0> it = s().iterator();
            while (it.hasNext()) {
                it.next().j();
            }
        } else {
            if (this.o.isEmpty()) {
                return;
            }
            for (Fragment fragment : this.o.keySet()) {
                n(fragment);
                T0(fragment);
            }
        }
    }

    private void a0(boolean z) {
        if (this.f1496d) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.t == null) {
            if (!this.I) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.t.g().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            p();
        }
        if (this.K == null) {
            this.K = new ArrayList<>();
            this.L = new ArrayList<>();
        }
        this.f1496d = true;
        try {
            g0(null, null);
        } finally {
            this.f1496d = false;
        }
    }

    private boolean b1(String str, int i2, int i3) {
        b0(false);
        a0(true);
        Fragment fragment = this.w;
        if (fragment != null && i2 < 0 && str == null && fragment.getChildFragmentManager().a1()) {
            return true;
        }
        boolean zC1 = c1(this.K, this.L, str, i2, i3);
        if (zC1) {
            this.f1496d = true;
            try {
                h1(this.K, this.L);
                q();
            } catch (Throwable th) {
                q();
                throw th;
            }
        }
        w1();
        W();
        this.f1497e.b();
        return zC1;
    }

    private void d(c.e.b<Fragment> bVar) {
        int i2 = this.s;
        if (i2 < 1) {
            return;
        }
        int iMin = Math.min(i2, 5);
        for (Fragment fragment : this.f1497e.n()) {
            if (fragment.mState < iMin) {
                U0(fragment, iMin);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    bVar.add(fragment);
                }
            }
        }
    }

    private static void d0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            androidx.fragment.app.a aVar = arrayList.get(i2);
            if (arrayList2.get(i2).booleanValue()) {
                aVar.v(-1);
                aVar.A(i2 == i3 + (-1));
            } else {
                aVar.v(1);
                aVar.z();
            }
            i2++;
        }
    }

    private int d1(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, c.e.b<Fragment> bVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            androidx.fragment.app.a aVar = arrayList.get(i5);
            boolean zBooleanValue = arrayList2.get(i5).booleanValue();
            if (aVar.F() && !aVar.D(arrayList, i5 + 1, i3)) {
                if (this.N == null) {
                    this.N = new ArrayList<>();
                }
                q qVar = new q(aVar, zBooleanValue);
                this.N.add(qVar);
                aVar.H(qVar);
                if (zBooleanValue) {
                    aVar.z();
                } else {
                    aVar.A(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                d(bVar);
            }
        }
        return i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
    private void e0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ?? r1;
        int i4;
        int i5;
        int iD1;
        boolean z;
        int i6;
        ArrayList<Boolean> arrayList3 = arrayList2;
        boolean z2 = arrayList.get(i2).r;
        ArrayList<Fragment> arrayList4 = this.M;
        if (arrayList4 == null) {
            this.M = new ArrayList<>();
        } else {
            arrayList4.clear();
        }
        this.M.addAll(this.f1497e.n());
        Fragment fragmentA0 = A0();
        boolean z3 = false;
        for (int i7 = i2; i7 < i3; i7++) {
            androidx.fragment.app.a aVar = arrayList.get(i7);
            fragmentA0 = !arrayList3.get(i7).booleanValue() ? aVar.B(this.M, fragmentA0) : aVar.I(this.M, fragmentA0);
            z3 = z3 || aVar.f1647i;
        }
        this.M.clear();
        if (z2 || this.s < 1) {
            r1 = 1;
        } else if (f1494b) {
            for (int i8 = i2; i8 < i3; i8++) {
                Iterator<u.a> it = arrayList.get(i8).f1641c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = it.next().f1650b;
                    if (fragment != null && fragment.mFragmentManager != null) {
                        this.f1497e.p(w(fragment));
                    }
                }
            }
            r1 = 1;
        } else {
            r1 = 1;
            v.B(this.t.f(), this.u, arrayList, arrayList2, i2, i3, false, this.p);
        }
        d0(arrayList, arrayList2, i2, i3);
        if (f1494b) {
            boolean zBooleanValue = arrayList3.get(i3 - 1).booleanValue();
            for (int i9 = i2; i9 < i3; i9++) {
                androidx.fragment.app.a aVar2 = arrayList.get(i9);
                if (zBooleanValue) {
                    int size = aVar2.f1641c.size() - r1;
                    while (i6 >= 0) {
                        Fragment fragment2 = aVar2.f1641c.get(i6).f1650b;
                        if (fragment2 != null) {
                            i6 = size;
                            w(fragment2).m();
                        } else {
                            i6 = size;
                        }
                        i6--;
                    }
                    i6 = size;
                } else {
                    Iterator<u.a> it2 = aVar2.f1641c.iterator();
                    while (it2.hasNext()) {
                        Fragment fragment3 = it2.next().f1650b;
                        if (fragment3 != null) {
                            w(fragment3).m();
                        }
                    }
                }
            }
            S0(this.s, r1);
            for (a0 a0Var : t(arrayList, i2, i3)) {
                a0Var.r(zBooleanValue);
                a0Var.p();
                a0Var.g();
            }
            i4 = i3;
            arrayList3 = arrayList3;
        } else {
            if (z2) {
                c.e.b bVar = new c.e.b();
                d(bVar);
                i5 = 1;
                i4 = i3;
                iD1 = d1(arrayList, arrayList2, i2, i3, bVar);
                Q0(bVar);
            } else {
                i4 = i3;
                i5 = 1;
                iD1 = i4;
            }
            if (iD1 == i2 || !z2) {
                arrayList3 = arrayList3;
                i4 = i4;
            } else {
                if (this.s >= i5) {
                    z = true;
                    v.B(this.t.f(), this.u, arrayList, arrayList2, i2, iD1, true, this.p);
                } else {
                    z = true;
                }
                S0(this.s, z);
            }
        }
        for (int i10 = i2; i10 < i4; i10++) {
            androidx.fragment.app.a aVar3 = arrayList.get(i10);
            if (arrayList3.get(i10).booleanValue() && aVar3.v >= 0) {
                aVar3.v = -1;
            }
            aVar3.G();
        }
        if (z3) {
            j1();
        }
    }

    private void g0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        ArrayList<q> arrayList3 = this.N;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            q qVar = this.N.get(i2);
            if (arrayList != null && !qVar.a && (iIndexOf2 = arrayList.indexOf(qVar.f1520b)) != -1 && arrayList2 != null && arrayList2.get(iIndexOf2).booleanValue()) {
                this.N.remove(i2);
                i2--;
                size--;
                qVar.c();
            } else if (qVar.e() || (arrayList != null && qVar.f1520b.D(arrayList, 0, arrayList.size()))) {
                this.N.remove(i2);
                i2--;
                size--;
                if (arrayList == null || qVar.a || (iIndexOf = arrayList.indexOf(qVar.f1520b)) == -1 || arrayList2 == null || !arrayList2.get(iIndexOf).booleanValue()) {
                    qVar.d();
                } else {
                    qVar.c();
                }
            }
            i2++;
        }
    }

    private void h1(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        g0(arrayList, arrayList2);
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!arrayList.get(i2).r) {
                if (i3 != i2) {
                    e0(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (arrayList2.get(i2).booleanValue()) {
                    while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).r) {
                        i3++;
                    }
                }
                e0(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            e0(arrayList, arrayList2, i3, size);
        }
    }

    private void j1() {
        if (this.n != null) {
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                this.n.get(i2).a();
            }
        }
    }

    private void l0() {
        if (f1494b) {
            Iterator<a0> it = s().iterator();
            while (it.hasNext()) {
                it.next().k();
            }
        } else if (this.N != null) {
            while (!this.N.isEmpty()) {
                this.N.remove(0).d();
            }
        }
    }

    static int l1(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private boolean m0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f1495c) {
            if (this.f1495c.isEmpty()) {
                return false;
            }
            int size = this.f1495c.size();
            boolean zA = false;
            for (int i2 = 0; i2 < size; i2++) {
                zA |= this.f1495c.get(i2).a(arrayList, arrayList2);
            }
            this.f1495c.clear();
            this.t.g().removeCallbacks(this.P);
            return zA;
        }
    }

    private void n(Fragment fragment) {
        HashSet<androidx.core.os.b> hashSet = this.o.get(fragment);
        if (hashSet != null) {
            Iterator<androidx.core.os.b> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            x(fragment);
            this.o.remove(fragment);
        }
    }

    private void p() {
        if (M0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private androidx.fragment.app.n p0(Fragment fragment) {
        return this.O.i(fragment);
    }

    private void q() {
        this.f1496d = false;
        this.L.clear();
        this.K.clear();
    }

    private Set<a0> s() {
        HashSet hashSet = new HashSet();
        Iterator<r> it = this.f1497e.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = it.next().k().mContainer;
            if (viewGroup != null) {
                hashSet.add(a0.o(viewGroup, B0()));
            }
        }
        return hashSet;
    }

    private ViewGroup s0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.u.d()) {
            View viewC = this.u.c(fragment.mContainerId);
            if (viewC instanceof ViewGroup) {
                return (ViewGroup) viewC;
            }
        }
        return null;
    }

    private void s1(Fragment fragment) {
        ViewGroup viewGroupS0 = s0(fragment);
        if (viewGroupS0 == null || fragment.getNextAnim() <= 0) {
            return;
        }
        int i2 = c.m.b.f3343c;
        if (viewGroupS0.getTag(i2) == null) {
            viewGroupS0.setTag(i2, fragment);
        }
        ((Fragment) viewGroupS0.getTag(i2)).setNextAnim(fragment.getNextAnim());
    }

    private Set<a0> t(ArrayList<androidx.fragment.app.a> arrayList, int i2, int i3) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i2 < i3) {
            Iterator<u.a> it = arrayList.get(i2).f1641c.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f1650b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(a0.n(viewGroup, this));
                }
            }
            i2++;
        }
        return hashSet;
    }

    private void u1() {
        Iterator<r> it = this.f1497e.k().iterator();
        while (it.hasNext()) {
            W0(it.next());
        }
    }

    private void v(Fragment fragment) {
        Animator animator;
        if (fragment.mView != null) {
            androidx.fragment.app.e.d dVarB = androidx.fragment.app.e.b(this.t.f(), fragment, !fragment.mHidden);
            if (dVarB == null || (animator = dVarB.f1607b) == null) {
                if (dVarB != null) {
                    fragment.mView.startAnimation(dVarB.a);
                    dVarB.a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    ViewGroup viewGroup = fragment.mContainer;
                    View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    dVarB.f1607b.addListener(new h(viewGroup, view, fragment));
                }
                dVarB.f1607b.start();
            }
        }
        if (fragment.mAdded && I0(fragment)) {
            this.F = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    private void v1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new z("FragmentManager"));
        androidx.fragment.app.j<?> jVar = this.t;
        if (jVar != null) {
            try {
                jVar.h("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
                throw runtimeException;
            }
        }
        try {
            X("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e3) {
            Log.e("FragmentManager", "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    private void w1() {
        synchronized (this.f1495c) {
            if (this.f1495c.isEmpty()) {
                this.f1502j.f(o0() > 0 && K0(this.v));
            } else {
                this.f1502j.f(true);
            }
        }
    }

    private void x(Fragment fragment) {
        fragment.performDestroyView();
        this.q.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.n(null);
        fragment.mInLayout = false;
    }

    void A() {
        this.G = false;
        this.H = false;
        this.O.o(false);
        T(0);
    }

    public Fragment A0() {
        return this.w;
    }

    void B(Configuration configuration) {
        for (Fragment fragment : this.f1497e.n()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    b0 B0() {
        b0 b0Var = this.z;
        if (b0Var != null) {
            return b0Var;
        }
        Fragment fragment = this.v;
        return fragment != null ? fragment.mFragmentManager.B0() : this.A;
    }

    boolean C(MenuItem menuItem) {
        if (this.s < 1) {
            return false;
        }
        for (Fragment fragment : this.f1497e.n()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void D() {
        this.G = false;
        this.H = false;
        this.O.o(false);
        T(1);
    }

    androidx.lifecycle.z D0(Fragment fragment) {
        return this.O.l(fragment);
    }

    boolean E(Menu menu, MenuInflater menuInflater) {
        if (this.s < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.f1497e.n()) {
            if (fragment != null && J0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.f1499g != null) {
            for (int i2 = 0; i2 < this.f1499g.size(); i2++) {
                Fragment fragment2 = this.f1499g.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f1499g = arrayList;
        return z;
    }

    void E0() {
        b0(true);
        if (this.f1502j.c()) {
            a1();
        } else {
            this.f1501i.c();
        }
    }

    void F() {
        this.I = true;
        b0(true);
        Y();
        T(-1);
        this.t = null;
        this.u = null;
        this.v = null;
        if (this.f1501i != null) {
            this.f1502j.d();
            this.f1501i = null;
        }
        androidx.activity.result.b<Intent> bVar = this.B;
        if (bVar != null) {
            bVar.c();
            this.C.c();
            this.D.c();
        }
    }

    void F0(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        s1(fragment);
    }

    void G() {
        T(1);
    }

    public boolean G0() {
        return this.I;
    }

    void H() {
        for (Fragment fragment : this.f1497e.n()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    void I(boolean z) {
        for (Fragment fragment : this.f1497e.n()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    void J(Fragment fragment) {
        Iterator<androidx.fragment.app.o> it = this.r.iterator();
        while (it.hasNext()) {
            it.next().a(this, fragment);
        }
    }

    boolean J0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    boolean K(MenuItem menuItem) {
        if (this.s < 1) {
            return false;
        }
        for (Fragment fragment : this.f1497e.n()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean K0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.A0()) && K0(fragmentManager.v);
    }

    void L(Menu menu) {
        if (this.s < 1) {
            return;
        }
        for (Fragment fragment : this.f1497e.n()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    boolean L0(int i2) {
        return this.s >= i2;
    }

    public boolean M0() {
        return this.G || this.H;
    }

    void N() {
        T(5);
    }

    void N0(Fragment fragment, String[] strArr, int i2) {
        if (this.D == null) {
            this.t.k(fragment, strArr, i2);
            return;
        }
        this.E.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
        this.D.a(strArr);
    }

    void O(boolean z) {
        for (Fragment fragment : this.f1497e.n()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    void O0(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (this.B == null) {
            this.t.n(fragment, intent, i2, bundle);
            return;
        }
        this.E.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.B.a(intent);
    }

    boolean P(Menu menu) {
        boolean z = false;
        if (this.s < 1) {
            return false;
        }
        for (Fragment fragment : this.f1497e.n()) {
            if (fragment != null && J0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    void P0(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2;
        if (this.C == null) {
            this.t.o(fragment, intentSender, i2, intent, i3, i4, i5, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            } else {
                intent2 = intent;
            }
            if (H0(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        } else {
            intent2 = intent;
        }
        IntentSenderRequest intentSenderRequestA = new IntentSenderRequest.b(intentSender).b(intent2).c(i4, i3).a();
        this.E.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
        if (H0(2)) {
            Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
        }
        this.C.a(intentSenderRequestA);
    }

    void Q() {
        w1();
        M(this.w);
    }

    void R() {
        this.G = false;
        this.H = false;
        this.O.o(false);
        T(7);
    }

    void R0(Fragment fragment) {
        if (!this.f1497e.c(fragment.mWho)) {
            if (H0(3)) {
                Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.s + "since it is not added to " + this);
                return;
            }
            return;
        }
        T0(fragment);
        View view = fragment.mView;
        if (view != null && fragment.mIsNewlyAdded && fragment.mContainer != null) {
            float f2 = fragment.mPostponedAlpha;
            if (f2 > 0.0f) {
                view.setAlpha(f2);
            }
            fragment.mPostponedAlpha = 0.0f;
            fragment.mIsNewlyAdded = false;
            androidx.fragment.app.e.d dVarB = androidx.fragment.app.e.b(this.t.f(), fragment, true);
            if (dVarB != null) {
                Animation animation = dVarB.a;
                if (animation != null) {
                    fragment.mView.startAnimation(animation);
                } else {
                    dVarB.f1607b.setTarget(fragment.mView);
                    dVarB.f1607b.start();
                }
            }
        }
        if (fragment.mHiddenChanged) {
            v(fragment);
        }
    }

    void S() {
        this.G = false;
        this.H = false;
        this.O.o(false);
        T(5);
    }

    void S0(int i2, boolean z) {
        androidx.fragment.app.j<?> jVar;
        if (this.t == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i2 != this.s) {
            this.s = i2;
            if (f1494b) {
                this.f1497e.r();
            } else {
                Iterator<Fragment> it = this.f1497e.n().iterator();
                while (it.hasNext()) {
                    R0(it.next());
                }
                for (r rVar : this.f1497e.k()) {
                    Fragment fragmentK = rVar.k();
                    if (!fragmentK.mIsNewlyAdded) {
                        R0(fragmentK);
                    }
                    if (fragmentK.mRemoving && !fragmentK.isInBackStack()) {
                        this.f1497e.q(rVar);
                    }
                }
            }
            u1();
            if (this.F && (jVar = this.t) != null && this.s == 7) {
                jVar.p();
                this.F = false;
            }
        }
    }

    void T0(Fragment fragment) {
        U0(fragment, this.s);
    }

    void U() {
        this.H = true;
        this.O.o(true);
        T(4);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    /* JADX WARN: Code duplicated, block: B:33:0x0068  */
    /* JADX WARN: Code duplicated, block: B:35:0x006d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0072  */
    /* JADX WARN: Code duplicated, block: B:39:0x0077  */
    /* JADX WARN: Code duplicated, block: B:97:0x0159  */
    /* JADX WARN: Code duplicated, block: B:99:0x015c  */
    void U0(Fragment fragment, int i2) {
        ViewGroup viewGroup;
        r rVarM = this.f1497e.m(fragment.mWho);
        int i3 = 1;
        if (rVarM == null) {
            rVarM = new r(this.q, this.f1497e, fragment);
            rVarM.u(1);
        }
        if (fragment.mFromLayout && fragment.mInLayout && fragment.mState == 2) {
            i2 = Math.max(i2, 2);
        }
        int iMin = Math.min(i2, rVarM.d());
        int i4 = fragment.mState;
        if (i4 <= iMin) {
            if (i4 < iMin && !this.o.isEmpty()) {
                n(fragment);
            }
            int i5 = fragment.mState;
            if (i5 != -1) {
                if (i5 != 0) {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (i5 != 4) {
                                if (i5 == 5) {
                                }
                            }
                            if (iMin > 5) {
                                rVarM.p();
                            }
                        }
                        if (iMin > 4) {
                            rVarM.v();
                        }
                        if (iMin > 5) {
                            rVarM.p();
                        }
                    }
                    if (iMin > 2) {
                        rVarM.a();
                    }
                    if (iMin > 4) {
                        rVarM.v();
                    }
                    if (iMin > 5) {
                        rVarM.p();
                    }
                }
                if (iMin > -1) {
                    rVarM.j();
                }
                if (iMin > 1) {
                    rVarM.f();
                }
                if (iMin > 2) {
                    rVarM.a();
                }
                if (iMin > 4) {
                    rVarM.v();
                }
                if (iMin > 5) {
                    rVarM.p();
                }
            } else if (iMin > -1) {
                rVarM.c();
            }
            if (iMin > 0) {
                rVarM.e();
            }
            if (iMin > -1) {
                rVarM.j();
            }
            if (iMin > 1) {
                rVarM.f();
            }
            if (iMin > 2) {
                rVarM.a();
            }
            if (iMin > 4) {
                rVarM.v();
            }
            if (iMin > 5) {
                rVarM.p();
            }
        } else if (i4 > iMin) {
            if (i4 == 0) {
                i3 = iMin;
                if (i3 < 0) {
                    rVarM.i();
                }
                iMin = i3;
            } else {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 4) {
                            if (i4 != 5) {
                                if (i4 == 7) {
                                    if (iMin < 7) {
                                        rVarM.n();
                                    }
                                }
                            }
                            if (iMin < 5) {
                                rVarM.w();
                            }
                        }
                        if (iMin < 4) {
                            if (H0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                            }
                            if (fragment.mView != null && this.t.l(fragment) && fragment.mSavedViewState == null) {
                                rVarM.t();
                            }
                        }
                    }
                    if (iMin < 2) {
                        androidx.fragment.app.e.d dVarB = null;
                        View view = fragment.mView;
                        if (view != null && (viewGroup = fragment.mContainer) != null) {
                            viewGroup.endViewTransition(view);
                            fragment.mView.clearAnimation();
                            if (!fragment.isRemovingParent()) {
                                if (this.s > -1 && !this.I && fragment.mView.getVisibility() == 0 && fragment.mPostponedAlpha >= 0.0f) {
                                    dVarB = androidx.fragment.app.e.b(this.t.f(), fragment, false);
                                }
                                fragment.mPostponedAlpha = 0.0f;
                                ViewGroup viewGroup2 = fragment.mContainer;
                                View view2 = fragment.mView;
                                if (dVarB != null) {
                                    androidx.fragment.app.e.a(fragment, dVarB, this.p);
                                }
                                viewGroup2.removeView(view2);
                                if (H0(2)) {
                                    Log.v("FragmentManager", "Removing view " + view2 + " for fragment " + fragment + " from container " + viewGroup2);
                                }
                                if (viewGroup2 != fragment.mContainer) {
                                    return;
                                }
                            }
                        }
                        if (this.o.get(fragment) == null) {
                            rVarM.h();
                        }
                    }
                }
                if (iMin >= 1) {
                    i3 = iMin;
                } else if (this.o.get(fragment) == null) {
                    rVarM.g();
                    i3 = iMin;
                }
                if (i3 < 0) {
                    rVarM.i();
                }
                iMin = i3;
            }
        }
        if (fragment.mState != iMin) {
            if (H0(3)) {
                Log.d("FragmentManager", "moveToState: Fragment state for " + fragment + " not updated inline; expected state " + iMin + " found " + fragment.mState);
            }
            fragment.mState = iMin;
        }
    }

    void V() {
        T(2);
    }

    void V0() {
        if (this.t == null) {
            return;
        }
        this.G = false;
        this.H = false;
        this.O.o(false);
        for (Fragment fragment : this.f1497e.n()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    void W0(r rVar) {
        Fragment fragmentK = rVar.k();
        if (fragmentK.mDeferStart) {
            if (this.f1496d) {
                this.J = true;
                return;
            }
            fragmentK.mDeferStart = false;
            if (f1494b) {
                rVar.m();
            } else {
                T0(fragmentK);
            }
        }
    }

    public void X(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f1497e.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f1499g;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                Fragment fragment = this.f1499g.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList2 = this.f1498f;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                androidx.fragment.app.a aVar = this.f1498f.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.x(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f1503k.get());
        synchronized (this.f1495c) {
            int size3 = this.f1495c.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i4 = 0; i4 < size3; i4++) {
                    o oVar = this.f1495c.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(oVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.t);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.u);
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.v);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.s);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.G);
        printWriter.print(" mStopped=");
        printWriter.print(this.H);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.I);
        if (this.F) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.F);
        }
    }

    public void X0() {
        Z(new p(null, -1, 0), false);
    }

    public void Y0(int i2, int i3) {
        if (i2 >= 0) {
            Z(new p(null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    void Z(o oVar, boolean z) {
        if (!z) {
            if (this.t == null) {
                if (!this.I) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            p();
        }
        synchronized (this.f1495c) {
            if (this.t == null) {
                if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.f1495c.add(oVar);
                o1();
            }
        }
    }

    public void Z0(String str, int i2) {
        Z(new p(str, -1, i2), false);
    }

    public boolean a1() {
        return b1(null, -1, 0);
    }

    boolean b0(boolean z) {
        a0(z);
        boolean z2 = false;
        while (m0(this.K, this.L)) {
            this.f1496d = true;
            try {
                h1(this.K, this.L);
                q();
                z2 = true;
            } catch (Throwable th) {
                q();
                throw th;
            }
        }
        w1();
        W();
        this.f1497e.b();
        return z2;
    }

    void c0(o oVar, boolean z) {
        if (z && (this.t == null || this.I)) {
            return;
        }
        a0(z);
        if (oVar.a(this.K, this.L)) {
            this.f1496d = true;
            try {
                h1(this.K, this.L);
                q();
            } catch (Throwable th) {
                q();
                throw th;
            }
        }
        w1();
        W();
        this.f1497e.b();
    }

    boolean c1(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList<androidx.fragment.app.a> arrayList3 = this.f1498f;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f1498f.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.a aVar = this.f1498f.get(size2);
                    if ((str != null && str.equals(aVar.getName())) || (i2 >= 0 && i2 == aVar.v)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        androidx.fragment.app.a aVar2 = this.f1498f.get(size2);
                        if (str == null || !str.equals(aVar2.getName())) {
                            if (i2 < 0 || i2 != aVar2.v) {
                                break;
                            }
                        }
                    }
                }
                i4 = size2;
            } else {
                i4 = -1;
            }
            if (i4 == this.f1498f.size() - 1) {
                return false;
            }
            for (int size3 = this.f1498f.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f1498f.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    void e(androidx.fragment.app.a aVar) {
        if (this.f1498f == null) {
            this.f1498f = new ArrayList<>();
        }
        this.f1498f.add(aVar);
    }

    public void e1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            v1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    void f(Fragment fragment, androidx.core.os.b bVar) {
        if (this.o.get(fragment) == null) {
            this.o.put(fragment, new HashSet<>());
        }
        this.o.get(fragment).add(bVar);
    }

    public boolean f0() {
        boolean zB0 = b0(true);
        l0();
        return zB0;
    }

    void f1(Fragment fragment, androidx.core.os.b bVar) {
        HashSet<androidx.core.os.b> hashSet = this.o.get(fragment);
        if (hashSet != null && hashSet.remove(bVar) && hashSet.isEmpty()) {
            this.o.remove(fragment);
            if (fragment.mState < 5) {
                x(fragment);
                T0(fragment);
            }
        }
    }

    void g(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        r rVarW = w(fragment);
        fragment.mFragmentManager = this;
        this.f1497e.p(rVarW);
        if (fragment.mDetached) {
            return;
        }
        this.f1497e.a(fragment);
        fragment.mRemoving = false;
        if (fragment.mView == null) {
            fragment.mHiddenChanged = false;
        }
        if (I0(fragment)) {
            this.F = true;
        }
    }

    void g1(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            this.f1497e.s(fragment);
            if (I0(fragment)) {
                this.F = true;
            }
            fragment.mRemoving = true;
            s1(fragment);
        }
    }

    public void h(androidx.fragment.app.o oVar) {
        this.r.add(oVar);
    }

    Fragment h0(String str) {
        return this.f1497e.f(str);
    }

    void i(Fragment fragment) {
        this.O.f(fragment);
    }

    public Fragment i0(int i2) {
        return this.f1497e.g(i2);
    }

    void i1(Fragment fragment) {
        this.O.n(fragment);
    }

    int j() {
        return this.f1503k.getAndIncrement();
    }

    public Fragment j0(String str) {
        return this.f1497e.h(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    void k(androidx.fragment.app.j<?> jVar, androidx.fragment.app.f fVar, Fragment fragment) {
        String str;
        androidx.lifecycle.k kVar;
        if (this.t != null) {
            throw new IllegalStateException("Already attached");
        }
        this.t = jVar;
        this.u = fVar;
        this.v = fragment;
        if (fragment != null) {
            h(new i(fragment));
        } else if (jVar instanceof androidx.fragment.app.o) {
            h((androidx.fragment.app.o) jVar);
        }
        if (this.v != null) {
            w1();
        }
        if (jVar instanceof androidx.activity.c) {
            androidx.activity.c cVar = (androidx.activity.c) jVar;
            OnBackPressedDispatcher onBackPressedDispatcher = cVar.getOnBackPressedDispatcher();
            this.f1501i = onBackPressedDispatcher;
            if (fragment != null) {
                kVar = cVar;
                kVar = fragment;
            }
            kVar = cVar;
            onBackPressedDispatcher.a(kVar, this.f1502j);
        }
        if (fragment != null) {
            this.O = fragment.mFragmentManager.p0(fragment);
        } else if (jVar instanceof androidx.lifecycle.a0) {
            this.O = androidx.fragment.app.n.j(((androidx.lifecycle.a0) jVar).getViewModelStore());
        } else {
            this.O = new androidx.fragment.app.n(false);
        }
        this.O.o(M0());
        this.f1497e.x(this.O);
        Object obj = this.t;
        if (obj instanceof androidx.activity.result.c) {
            ActivityResultRegistry activityResultRegistry = ((androidx.activity.result.c) obj).getActivityResultRegistry();
            if (fragment != null) {
                str = fragment.mWho + ":";
            } else {
                str = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            String str2 = "FragmentManager:" + str;
            this.B = activityResultRegistry.i(str2 + "StartActivityForResult", new androidx.activity.result.d.c(), new j());
            this.C = activityResultRegistry.i(str2 + "StartIntentSenderForResult", new l(), new a());
            this.D = activityResultRegistry.i(str2 + "RequestPermissions", new androidx.activity.result.d.b(), new b());
        }
    }

    Fragment k0(String str) {
        return this.f1497e.i(str);
    }

    void k1(Parcelable parcelable) {
        r rVar;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.f1522f == null) {
            return;
        }
        this.f1497e.t();
        for (FragmentState fragmentState : fragmentManagerState.f1522f) {
            if (fragmentState != null) {
                Fragment fragmentH = this.O.h(fragmentState.f1529g);
                if (fragmentH != null) {
                    if (H0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragmentH);
                    }
                    rVar = new r(this.q, this.f1497e, fragmentH, fragmentState);
                } else {
                    rVar = new r(this.q, this.f1497e, this.t.f().getClassLoader(), t0(), fragmentState);
                }
                Fragment fragmentK = rVar.k();
                fragmentK.mFragmentManager = this;
                if (H0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragmentK.mWho + "): " + fragmentK);
                }
                rVar.o(this.t.f().getClassLoader());
                this.f1497e.p(rVar);
                rVar.u(this.s);
            }
        }
        for (Fragment fragment : this.O.k()) {
            if (!this.f1497e.c(fragment.mWho)) {
                if (H0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.f1522f);
                }
                this.O.n(fragment);
                fragment.mFragmentManager = this;
                r rVar2 = new r(this.q, this.f1497e, fragment);
                rVar2.u(1);
                rVar2.m();
                fragment.mRemoving = true;
                rVar2.m();
            }
        }
        this.f1497e.u(fragmentManagerState.f1523g);
        if (fragmentManagerState.f1524h != null) {
            this.f1498f = new ArrayList<>(fragmentManagerState.f1524h.length);
            int i2 = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.f1524h;
                if (i2 >= backStackStateArr.length) {
                    break;
                }
                androidx.fragment.app.a aVarA = backStackStateArr[i2].a(this);
                if (H0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + aVarA.v + "): " + aVarA);
                    PrintWriter printWriter = new PrintWriter(new z("FragmentManager"));
                    aVarA.y("  ", printWriter, false);
                    printWriter.close();
                }
                this.f1498f.add(aVarA);
                i2++;
            }
        } else {
            this.f1498f = null;
        }
        this.f1503k.set(fragmentManagerState.f1525i);
        String str = fragmentManagerState.f1526j;
        if (str != null) {
            Fragment fragmentH0 = h0(str);
            this.w = fragmentH0;
            M(fragmentH0);
        }
        ArrayList<String> arrayList = fragmentManagerState.f1527k;
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                this.l.put(arrayList.get(i3), fragmentManagerState.l.get(i3));
            }
        }
        this.E = new ArrayDeque<>(fragmentManagerState.m);
    }

    void l(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f1497e.a(fragment);
            if (H0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (I0(fragment)) {
                this.F = true;
            }
        }
    }

    public u m() {
        return new androidx.fragment.app.a(this);
    }

    Parcelable m1() {
        int size;
        l0();
        Y();
        b0(true);
        this.G = true;
        this.O.o(true);
        ArrayList<FragmentState> arrayListV = this.f1497e.v();
        BackStackState[] backStackStateArr = null;
        if (arrayListV.isEmpty()) {
            if (H0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> arrayListW = this.f1497e.w();
        ArrayList<androidx.fragment.app.a> arrayList = this.f1498f;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i2 = 0; i2 < size; i2++) {
                backStackStateArr[i2] = new BackStackState(this.f1498f.get(i2));
                if (H0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f1498f.get(i2));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f1522f = arrayListV;
        fragmentManagerState.f1523g = arrayListW;
        fragmentManagerState.f1524h = backStackStateArr;
        fragmentManagerState.f1525i = this.f1503k.get();
        Fragment fragment = this.w;
        if (fragment != null) {
            fragmentManagerState.f1526j = fragment.mWho;
        }
        fragmentManagerState.f1527k.addAll(this.l.keySet());
        fragmentManagerState.l.addAll(this.l.values());
        fragmentManagerState.m = new ArrayList<>(this.E);
        return fragmentManagerState;
    }

    public k n0(int i2) {
        return this.f1498f.get(i2);
    }

    public Fragment.SavedState n1(Fragment fragment) {
        r rVarM = this.f1497e.m(fragment.mWho);
        if (rVarM == null || !rVarM.k().equals(fragment)) {
            v1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return rVarM.r();
    }

    boolean o() {
        boolean zI0 = false;
        for (Fragment fragment : this.f1497e.l()) {
            if (fragment != null) {
                zI0 = I0(fragment);
            }
            if (zI0) {
                return true;
            }
        }
        return false;
    }

    public int o0() {
        ArrayList<androidx.fragment.app.a> arrayList = this.f1498f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    void o1() {
        synchronized (this.f1495c) {
            ArrayList<q> arrayList = this.N;
            boolean z = (arrayList == null || arrayList.isEmpty()) ? false : true;
            boolean z2 = this.f1495c.size() == 1;
            if (z || z2) {
                this.t.g().removeCallbacks(this.P);
                this.t.g().post(this.P);
                w1();
            }
        }
    }

    void p1(Fragment fragment, boolean z) {
        ViewGroup viewGroupS0 = s0(fragment);
        if (viewGroupS0 == null || !(viewGroupS0 instanceof androidx.fragment.app.g)) {
            return;
        }
        ((androidx.fragment.app.g) viewGroupS0).setDrawDisappearingViewsLast(!z);
    }

    androidx.fragment.app.f q0() {
        return this.u;
    }

    void q1(Fragment fragment, androidx.lifecycle.g.c cVar) {
        if (fragment.equals(h0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = cVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final void r(String str) {
        this.l.remove(str);
    }

    public Fragment r0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragmentH0 = h0(string);
        if (fragmentH0 == null) {
            v1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragmentH0;
    }

    void r1(Fragment fragment) {
        if (fragment == null || (fragment.equals(h0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.w;
            this.w = fragment;
            M(fragment2);
            M(this.w);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public androidx.fragment.app.i t0() {
        androidx.fragment.app.i iVar = this.x;
        if (iVar != null) {
            return iVar;
        }
        Fragment fragment = this.v;
        return fragment != null ? fragment.mFragmentManager.t0() : this.y;
    }

    void t1(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.v;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.v)));
            sb.append("}");
        } else {
            androidx.fragment.app.j<?> jVar = this.t;
            if (jVar != null) {
                sb.append(jVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.t)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    void u(androidx.fragment.app.a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.A(z3);
        } else {
            aVar.z();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2 && this.s >= 1) {
            v.B(this.t.f(), this.u, arrayList, arrayList2, 0, 1, true, this.p);
        }
        if (z3) {
            S0(this.s, true);
        }
        for (Fragment fragment : this.f1497e.l()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && aVar.C(fragment.mContainerId)) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > 0.0f) {
                    fragment.mView.setAlpha(f2);
                }
                if (z3) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    t u0() {
        return this.f1497e;
    }

    public List<Fragment> v0() {
        return this.f1497e.n();
    }

    r w(Fragment fragment) {
        r rVarM = this.f1497e.m(fragment.mWho);
        if (rVarM != null) {
            return rVarM;
        }
        r rVar = new r(this.q, this.f1497e, fragment);
        rVar.o(this.t.f().getClassLoader());
        rVar.u(this.s);
        return rVar;
    }

    androidx.fragment.app.j<?> w0() {
        return this.t;
    }

    LayoutInflater.Factory2 x0() {
        return this.f1500h;
    }

    void y(Fragment fragment) {
        if (H0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (H0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.f1497e.s(fragment);
            if (I0(fragment)) {
                this.F = true;
            }
            s1(fragment);
        }
    }

    androidx.fragment.app.l y0() {
        return this.q;
    }

    void z() {
        this.G = false;
        this.H = false;
        this.O.o(false);
        T(4);
    }

    Fragment z0() {
        return this.v;
    }

    @SuppressLint({"BanParcelableUsage"})
    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f1507f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f1508g;

        class a implements Parcelable.Creator<LaunchedFragmentInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo[] newArray(int i2) {
                return new LaunchedFragmentInfo[i2];
            }
        }

        LaunchedFragmentInfo(String str, int i2) {
            this.f1507f = str;
            this.f1508g = i2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f1507f);
            parcel.writeInt(this.f1508g);
        }

        LaunchedFragmentInfo(Parcel parcel) {
            this.f1507f = parcel.readString();
            this.f1508g = parcel.readInt();
        }
    }
}
