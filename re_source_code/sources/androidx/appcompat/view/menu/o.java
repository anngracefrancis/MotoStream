package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: compiled from: MenuWrapperICS.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends c implements Menu {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c.i.f.a.a f349d;

    public o(Context context, c.i.f.a.a aVar) {
        super(context);
        if (aVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f349d = aVar;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return c(this.f349d.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f349d.addIntentOptions(i2, i3, i4, componentName, intentArr, intent, i5, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i6 = 0; i6 < length; i6++) {
                menuItemArr[i6] = c(menuItemArr2[i6]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return d(this.f349d.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        e();
        this.f349d.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.f349d.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i2) {
        return c(this.f349d.findItem(i2));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i2) {
        return c(this.f349d.getItem(i2));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f349d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return this.f349d.isShortcutKey(i2, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i2, int i3) {
        return this.f349d.performIdentifierAction(i2, i3);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        return this.f349d.performShortcut(i2, keyEvent, i3);
    }

    @Override // android.view.Menu
    public void removeGroup(int i2) {
        f(i2);
        this.f349d.removeGroup(i2);
    }

    @Override // android.view.Menu
    public void removeItem(int i2) {
        g(i2);
        this.f349d.removeItem(i2);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i2, boolean z, boolean z2) {
        this.f349d.setGroupCheckable(i2, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i2, boolean z) {
        this.f349d.setGroupEnabled(i2, z);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i2, boolean z) {
        this.f349d.setGroupVisible(i2, z);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f349d.setQwertyMode(z);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f349d.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        return c(this.f349d.add(i2));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        return d(this.f349d.addSubMenu(i2));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return c(this.f349d.add(i2, i3, i4, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        return d(this.f349d.addSubMenu(i2, i3, i4, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        return c(this.f349d.add(i2, i3, i4, i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return d(this.f349d.addSubMenu(i2, i3, i4, i5));
    }
}
