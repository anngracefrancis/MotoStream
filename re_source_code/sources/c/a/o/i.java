package c.a.o;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* JADX INFO: compiled from: WindowCallbackWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements Window.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Window.Callback f2841f;

    public i(Window.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f2841f = callback;
    }

    public final Window.Callback a() {
        return this.f2841f;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f2841f.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f2841f.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f2841f.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f2841f.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f2841f.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f2841f.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.f2841f.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.f2841f.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f2841f.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.f2841f.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        return this.f2841f.onCreatePanelMenu(i2, menu);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i2) {
        return this.f2841f.onCreatePanelView(i2);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f2841f.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        return this.f2841f.onMenuItemSelected(i2, menuItem);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i2, Menu menu) {
        return this.f2841f.onMenuOpened(i2, menu);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        this.f2841f.onPanelClosed(i2, menu);
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
        this.f2841f.onPointerCaptureChanged(z);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return this.f2841f.onPreparePanel(i2, view, menu);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
        this.f2841f.onProvideKeyboardShortcuts(list, menu, i2);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f2841f.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f2841f.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        this.f2841f.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f2841f.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f2841f.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        return this.f2841f.onWindowStartingActionMode(callback, i2);
    }
}
