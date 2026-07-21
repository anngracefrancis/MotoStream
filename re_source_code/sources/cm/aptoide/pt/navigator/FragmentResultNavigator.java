package cm.aptoide.pt.navigator;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.u;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class FragmentResultNavigator implements FragmentNavigator {
    private final int containerId;
    private final int enterAnimation;
    private final int exitAnimation;
    private final FragmentManager fragmentManager;
    private final e.g.b.a<Map<Integer, Result>> resultRelay;
    private final Map<Integer, Result> results;

    public FragmentResultNavigator(FragmentManager fragmentManager, int i2, int i3, int i4, Map<Integer, Result> map, e.g.b.a<Map<Integer, Result>> aVar) {
        this.fragmentManager = fragmentManager;
        this.containerId = i2;
        this.enterAnimation = i3;
        this.exitAnimation = i4;
        this.results = map;
        this.resultRelay = aVar;
    }

    private void handleNavigationResult(Result result) {
        this.results.put(Integer.valueOf(result.getRequestCode()), result);
        this.resultRelay.call(this.results);
    }

    static /* synthetic */ Result lambda$results$1(int i2, Map map) {
        return (Result) map.get(Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$results$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(int i2, Result result) {
        this.results.remove(Integer.valueOf(i2));
    }

    private void setUpNavigationForResult(Fragment fragment, int i2) {
        Bundle arguments = fragment.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putInt(FragmentNavigator.REQUEST_CODE_EXTRA, i2);
        fragment.setArguments(arguments);
    }

    @Override // cm.aptoide.pt.navigator.FragmentNavigator
    public void cleanBackStack() {
        for (int i2 = 0; i2 < this.fragmentManager.o0(); i2++) {
            this.fragmentManager.X0();
        }
        this.fragmentManager.f0();
    }

    @Override // cm.aptoide.pt.navigator.FragmentNavigator
    public int getBackStackEntryCount() {
        return this.fragmentManager.o0();
    }

    @Override // cm.aptoide.pt.navigator.FragmentNavigator
    public Fragment getFragment() {
        return this.fragmentManager.i0(this.containerId);
    }

    @Override // cm.aptoide.pt.navigator.FragmentNavigator
    public String getTagByBackStackEntry(int i2) {
        return this.fragmentManager.n0(i2).getName();
    }

    @Override // cm.aptoide.pt.navigator.FragmentNavigator
    public void navigateForResult(Fragment fragment, int i2, boolean z) {
        setUpNavigationForResult(fragment, i2);
        navigateTo(fragment, z);
    }

    @Override // cm.aptoide.pt.navigator.FragmentNavigator
    public String navigateTo(Fragment fragment, boolean z) {
        String string = Integer.toString(this.fragmentManager.o0());
        u uVarM = this.fragmentManager.m();
        int i2 = this.enterAnimation;
        int i3 = this.exitAnimation;
        u uVarG = uVarM.s(i2, i3, i2, i3).g(string);
        (z ? uVarG.r(this.containerId, fragment, string) : uVarG.c(this.containerId, fragment, string)).i();
        return string;
    }

    @Override // cm.aptoide.pt.navigator.FragmentNavigator
    public void navigateToCleaningBackStack(Fragment fragment, boolean z) {
        cleanBackStack();
        navigateToWithoutBackSave(fragment, z);
    }

    @Override // cm.aptoide.pt.navigator.FragmentNavigator
    public void navigateToDialogForResult(androidx.fragment.app.c cVar, int i2) {
        setUpNavigationForResult(cVar, i2);
        navigateToDialogFragment(cVar);
    }

    @Override // cm.aptoide.pt.navigator.FragmentNavigator
    public void navigateToDialogFragment(androidx.fragment.app.c cVar) {
        cVar.show(this.fragmentManager, Integer.toString(this.fragmentManager.o0()));
    }

    @Override // cm.aptoide.pt.navigator.FragmentNavigator
    public void navigateToWithoutBackSave(Fragment fragment, boolean z) {
        u uVarM = this.fragmentManager.m();
        int i2 = this.enterAnimation;
        int i3 = this.exitAnimation;
        u uVarS = uVarM.s(i2, i3, i2, i3);
        (z ? uVarS.q(this.containerId, fragment) : uVarS.b(this.containerId, fragment)).i();
    }

    @Override // cm.aptoide.pt.navigator.FragmentNavigator
    public Fragment peekLast() {
        if (this.fragmentManager.o0() <= 0) {
            return null;
        }
        FragmentManager fragmentManager = this.fragmentManager;
        return this.fragmentManager.j0(fragmentManager.n0(fragmentManager.o0() - 1).getName());
    }

    @Override // cm.aptoide.pt.navigator.FragmentNavigator
    public boolean popBackStack() {
        return this.fragmentManager.a1();
    }

    @Override // cm.aptoide.pt.navigator.FragmentNavigator
    public void popBackStackUntil(String str) {
        this.fragmentManager.Z0(str, 1);
    }

    @Override // cm.aptoide.pt.navigator.FragmentNavigator
    public void popDialogWithResult(Result result) {
        handleNavigationResult(result);
    }

    @Override // cm.aptoide.pt.navigator.FragmentNavigator
    public void popWithResult(Result result) {
        handleNavigationResult(result);
        popBackStack();
    }

    @Override // cm.aptoide.pt.navigator.FragmentNavigator
    public rx.e<Result> results(final int i2) {
        return this.resultRelay.D(new rx.m.e() { // from class: cm.aptoide.pt.navigator.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Map) obj).containsKey(Integer.valueOf(i2)));
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.navigator.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return FragmentResultNavigator.lambda$results$1(i2, (Map) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.navigator.f
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6627f.a(i2, (Result) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.navigator.FragmentNavigator
    public Fragment getFragment(String str) {
        return this.fragmentManager.j0(str);
    }
}
