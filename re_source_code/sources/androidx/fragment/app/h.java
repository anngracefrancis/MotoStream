package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: compiled from: FragmentController.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    private final j<?> a;

    private h(j<?> jVar) {
        this.a = jVar;
    }

    public static h b(j<?> jVar) {
        return new h((j) c.i.j.i.d(jVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        j<?> jVar = this.a;
        jVar.f1620j.k(jVar, jVar, fragment);
    }

    public void c() {
        this.a.f1620j.z();
    }

    public void d(Configuration configuration) {
        this.a.f1620j.B(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.a.f1620j.C(menuItem);
    }

    public void f() {
        this.a.f1620j.D();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.a.f1620j.E(menu, menuInflater);
    }

    public void h() {
        this.a.f1620j.F();
    }

    public void i() {
        this.a.f1620j.H();
    }

    public void j(boolean z) {
        this.a.f1620j.I(z);
    }

    public boolean k(MenuItem menuItem) {
        return this.a.f1620j.K(menuItem);
    }

    public void l(Menu menu) {
        this.a.f1620j.L(menu);
    }

    public void m() {
        this.a.f1620j.N();
    }

    public void n(boolean z) {
        this.a.f1620j.O(z);
    }

    public boolean o(Menu menu) {
        return this.a.f1620j.P(menu);
    }

    public void p() {
        this.a.f1620j.R();
    }

    public void q() {
        this.a.f1620j.S();
    }

    public void r() {
        this.a.f1620j.U();
    }

    public boolean s() {
        return this.a.f1620j.b0(true);
    }

    public FragmentManager t() {
        return this.a.f1620j;
    }

    public void u() {
        this.a.f1620j.V0();
    }

    public View v(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.f1620j.x0().onCreateView(view, str, context, attributeSet);
    }

    public void w(Parcelable parcelable) {
        j<?> jVar = this.a;
        if (!(jVar instanceof androidx.lifecycle.a0)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        jVar.f1620j.k1(parcelable);
    }

    public Parcelable x() {
        return this.a.f1620j.m1();
    }
}
