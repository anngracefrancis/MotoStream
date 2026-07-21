package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.v0;
import androidx.core.app.p;

/* JADX INFO: compiled from: AppCompatActivity.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends androidx.fragment.app.d implements e, p.a {
    private f mDelegate;
    private Resources mResources;

    public d() {
    }

    private boolean performMenuItemShortcut(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().d(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(getDelegate().h(context));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.f()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.core.app.f, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.o(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i2) {
        return (T) getDelegate().k(i2);
    }

    public f getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = f.i(this, this);
        }
        return this.mDelegate;
    }

    public b getDrawerToggleDelegate() {
        return getDelegate().m();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return getDelegate().o();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.mResources == null && v0.b()) {
            this.mResources = new v0(this, super.getResources());
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public a getSupportActionBar() {
        return getDelegate().p();
    }

    @Override // androidx.core.app.p.a
    public Intent getSupportParentActivityIntent() {
        return androidx.core.app.g.a(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().r();
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        getDelegate().s(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        f delegate = getDelegate();
        delegate.q();
        delegate.t(bundle);
        super.onCreate(bundle);
    }

    public void onCreateSupportNavigateUpTaskStack(p pVar) {
        pVar.f(this);
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        getDelegate().u();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (performMenuItemShortcut(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.i() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    protected void onNightModeChanged(int i2) {
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().v(bundle);
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        getDelegate().w();
    }

    public void onPrepareSupportNavigateUpTaskStack(p pVar) {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate().x(bundle);
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onStart() {
        super.onStart();
        getDelegate().y();
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onStop() {
        super.onStop();
        getDelegate().z();
    }

    @Override // androidx.appcompat.app.e
    public void onSupportActionModeFinished(c.a.o.b bVar) {
    }

    @Override // androidx.appcompat.app.e
    public void onSupportActionModeStarted(c.a.o.b bVar) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (!supportShouldUpRecreateTask(supportParentActivityIntent)) {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
        p pVarH = p.h(this);
        onCreateSupportNavigateUpTaskStack(pVarH);
        onPrepareSupportNavigateUpTaskStack(pVarH);
        pVarH.i();
        try {
            androidx.core.app.a.m(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        getDelegate().J(charSequence);
    }

    @Override // androidx.appcompat.app.e
    public c.a.o.b onWindowStartingSupportActionMode(c.a.o.b.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.p()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i2) {
        getDelegate().D(i2);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().H(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i2) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        super.setTheme(i2);
        getDelegate().I(i2);
    }

    public c.a.o.b startSupportActionMode(c.a.o.b.a aVar) {
        return getDelegate().K(aVar);
    }

    @Override // androidx.fragment.app.d
    public void supportInvalidateOptionsMenu() {
        getDelegate().r();
    }

    public void supportNavigateUpTo(Intent intent) {
        androidx.core.app.g.e(this, intent);
    }

    public boolean supportRequestWindowFeature(int i2) {
        return getDelegate().C(i2);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return androidx.core.app.g.f(this, intent);
    }

    public d(int i2) {
        super(i2);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        getDelegate().E(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().F(view, layoutParams);
    }
}
