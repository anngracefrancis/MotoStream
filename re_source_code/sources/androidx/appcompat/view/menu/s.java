package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: SubMenuWrapperICS.java */
/* JADX INFO: loaded from: classes.dex */
class s extends o implements SubMenu {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c.i.f.a.c f357e;

    s(Context context, c.i.f.a.c cVar) {
        super(context, cVar);
        this.f357e = cVar;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f357e.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return c(this.f357e.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i2) {
        this.f357e.setHeaderIcon(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i2) {
        this.f357e.setHeaderTitle(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.f357e.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i2) {
        this.f357e.setIcon(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f357e.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f357e.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f357e.setIcon(drawable);
        return this;
    }
}
