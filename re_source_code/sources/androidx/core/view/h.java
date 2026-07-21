package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;

/* JADX INFO: compiled from: MenuItemCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: compiled from: MenuItemCompat.java */
    class a implements MenuItem.OnActionExpandListener {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.a.onMenuItemActionCollapse(menuItem);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.a.onMenuItemActionExpand(menuItem);
        }
    }

    /* JADX INFO: compiled from: MenuItemCompat.java */
    @Deprecated
    public interface b {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    public static MenuItem a(MenuItem menuItem, androidx.core.view.b bVar) {
        if (menuItem instanceof c.i.f.a.b) {
            return ((c.i.f.a.b) menuItem).a(bVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void b(MenuItem menuItem, char c2, int i2) {
        if (menuItem instanceof c.i.f.a.b) {
            ((c.i.f.a.b) menuItem).setAlphabeticShortcut(c2, i2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c2, i2);
        }
    }

    public static void c(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof c.i.f.a.b) {
            ((c.i.f.a.b) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    public static void d(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof c.i.f.a.b) {
            ((c.i.f.a.b) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    public static void e(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof c.i.f.a.b) {
            ((c.i.f.a.b) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }

    public static void f(MenuItem menuItem, char c2, int i2) {
        if (menuItem instanceof c.i.f.a.b) {
            ((c.i.f.a.b) menuItem).setNumericShortcut(c2, i2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c2, i2);
        }
    }

    @Deprecated
    public static MenuItem g(MenuItem menuItem, b bVar) {
        return menuItem.setOnActionExpandListener(new a(bVar));
    }

    public static void h(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof c.i.f.a.b) {
            ((c.i.f.a.b) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }
}
