package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: MenuItemWrapperICS.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends androidx.appcompat.view.menu.c implements MenuItem {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c.i.f.a.b f327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Method f328e;

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    private class a extends androidx.core.view.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final ActionProvider f329d;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f329d = actionProvider;
        }

        @Override // androidx.core.view.b
        public boolean a() {
            return this.f329d.hasSubMenu();
        }

        @Override // androidx.core.view.b
        public View c() {
            return this.f329d.onCreateActionView();
        }

        @Override // androidx.core.view.b
        public boolean e() {
            return this.f329d.onPerformDefaultAction();
        }

        @Override // androidx.core.view.b
        public void f(SubMenu subMenu) {
            this.f329d.onPrepareSubMenu(j.this.d(subMenu));
        }
    }

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    private class b extends a implements ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private androidx.core.view.b.InterfaceC0024b f331f;

        b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.view.b
        public boolean b() {
            return this.f329d.isVisible();
        }

        @Override // androidx.core.view.b
        public View d(MenuItem menuItem) {
            return this.f329d.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.b
        public boolean g() {
            return this.f329d.overridesItemVisibility();
        }

        @Override // androidx.core.view.b
        public void j(androidx.core.view.b.InterfaceC0024b interfaceC0024b) {
            this.f331f = interfaceC0024b;
            this.f329d.setVisibilityListener(interfaceC0024b != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            androidx.core.view.b.InterfaceC0024b interfaceC0024b = this.f331f;
            if (interfaceC0024b != null) {
                interfaceC0024b.onActionProviderVisibilityChanged(z);
            }
        }
    }

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    static class c extends FrameLayout implements c.a.o.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final CollapsibleActionView f333f;

        /* JADX WARN: Multi-variable type inference failed */
        c(View view) {
            super(view.getContext());
            this.f333f = (CollapsibleActionView) view;
            addView(view);
        }

        View a() {
            return (View) this.f333f;
        }

        @Override // c.a.o.c
        public void c() {
            this.f333f.onActionViewExpanded();
        }

        @Override // c.a.o.c
        public void f() {
            this.f333f.onActionViewCollapsed();
        }
    }

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    private class d implements MenuItem.OnActionExpandListener {
        private final MenuItem.OnActionExpandListener a;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.a.onMenuItemActionCollapse(j.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.a.onMenuItemActionExpand(j.this.c(menuItem));
        }
    }

    /* JADX INFO: compiled from: MenuItemWrapperICS.java */
    private class e implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f335f;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f335f = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f335f.onMenuItemClick(j.this.c(menuItem));
        }
    }

    public j(Context context, c.i.f.a.b bVar) {
        super(context);
        if (bVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f327d = bVar;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f327d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f327d.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        androidx.core.view.b bVarB = this.f327d.b();
        if (bVarB instanceof a) {
            return ((a) bVarB).f329d;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f327d.getActionView();
        return actionView instanceof c ? ((c) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f327d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f327d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f327d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f327d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f327d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f327d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f327d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f327d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f327d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f327d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f327d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f327d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f327d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(this.f327d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f327d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f327d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f327d.getTooltipText();
    }

    public void h(boolean z) {
        try {
            if (this.f328e == null) {
                this.f328e = this.f327d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f328e.invoke(this.f327d, Boolean.valueOf(z));
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f327d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f327d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f327d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f327d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f327d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f327d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        androidx.core.view.b bVar = Build.VERSION.SDK_INT >= 16 ? new b(this.a, actionProvider) : new a(this.a, actionProvider);
        c.i.f.a.b bVar2 = this.f327d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f327d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f327d.setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f327d.setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f327d.setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f327d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f327d.setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f327d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f327d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f327d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f327d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.f327d.setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f327d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f327d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f327d.setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i2) {
        this.f327d.setShowAsAction(i2);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i2) {
        this.f327d.setShowAsActionFlags(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f327d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f327d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f327d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return this.f327d.setVisible(z);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f327d.setAlphabeticShortcut(c2, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f327d.setIcon(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f327d.setNumericShortcut(c2, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f327d.setShortcut(c2, c3, i2, i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        this.f327d.setTitle(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i2) {
        this.f327d.setActionView(i2);
        View actionView = this.f327d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f327d.setActionView(new c(actionView));
        }
        return this;
    }
}
