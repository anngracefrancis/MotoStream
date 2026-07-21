package io.sentry.android.core.internal.gestures;

import android.annotation.SuppressLint;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: compiled from: WindowCallbackAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
class k implements Window.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Window.Callback f22161f;

    k(Window.Callback callback) {
        this.f22161f = callback;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f22161f.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f22161f.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f22161f.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f22161f.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f22161f.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f22161f.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.f22161f.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.f22161f.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f22161f.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.f22161f.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        return this.f22161f.onCreatePanelMenu(i2, menu);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i2) {
        return this.f22161f.onCreatePanelView(i2);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f22161f.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        return this.f22161f.onMenuItemSelected(i2, menuItem);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        return this.f22161f.onMenuOpened(i2, menu);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        this.f22161f.onPanelClosed(i2, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return this.f22161f.onPreparePanel(i2, view, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f22161f.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f22161f.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        this.f22161f.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f22161f.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    @SuppressLint({"NewApi"})
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f22161f.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    @SuppressLint({"NewApi"})
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        return this.f22161f.onWindowStartingActionMode(callback, i2);
    }
}
