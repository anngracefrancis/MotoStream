package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: MenuPopupWindow.java */
/* JADX INFO: loaded from: classes.dex */
public class f0 extends d0 implements e0 {
    private static Method O;
    private e0 P;

    /* JADX INFO: compiled from: MenuPopupWindow.java */
    public static class a extends z {
        final int t;
        final int u;
        private e0 v;
        private MenuItem w;

        public a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.t = 22;
                this.u = 21;
            } else {
                this.t = 21;
                this.u = 22;
            }
        }

        @Override // androidx.appcompat.widget.z
        public /* bridge */ /* synthetic */ int d(int i2, int i3, int i4, int i5, int i6) {
            return super.d(i2, i3, i4, i5, i6);
        }

        @Override // androidx.appcompat.widget.z
        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i2) {
            return super.e(motionEvent, i2);
        }

        @Override // androidx.appcompat.widget.z, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.z, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.z, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.z, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.z, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int headersCount;
            androidx.appcompat.view.menu.f fVar;
            int iPointToPosition;
            int i2;
            if (this.v != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    fVar = (androidx.appcompat.view.menu.f) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    fVar = (androidx.appcompat.view.menu.f) adapter;
                }
                androidx.appcompat.view.menu.i item = null;
                if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i2 = iPointToPosition - headersCount) >= 0 && i2 < fVar.getCount()) {
                    item = fVar.getItem(i2);
                }
                MenuItem menuItem = this.w;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.g gVarB = fVar.b();
                    if (menuItem != null) {
                        this.v.g(gVarB, menuItem);
                    }
                    this.w = item;
                    if (item != null) {
                        this.v.d(gVarB, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.t) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i2 != this.u) {
                return super.onKeyDown(i2, keyEvent);
            }
            setSelection(-1);
            ((androidx.appcompat.view.menu.f) getAdapter()).b().e(false);
            return true;
        }

        @Override // androidx.appcompat.widget.z, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(e0 e0Var) {
            this.v = e0Var;
        }

        @Override // androidx.appcompat.widget.z, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                O = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public f0(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void Q(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.N.setEnterTransition((Transition) obj);
        }
    }

    public void R(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.N.setExitTransition((Transition) obj);
        }
    }

    public void S(e0 e0Var) {
        this.P = e0Var;
    }

    public void T(boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            this.N.setTouchModal(z);
            return;
        }
        Method method = O;
        if (method != null) {
            try {
                method.invoke(this.N, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // androidx.appcompat.widget.e0
    public void d(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        e0 e0Var = this.P;
        if (e0Var != null) {
            e0Var.d(gVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.e0
    public void g(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        e0 e0Var = this.P;
        if (e0Var != null) {
            e0Var.g(gVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.d0
    z r(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }
}
