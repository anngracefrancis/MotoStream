package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: compiled from: MenuDialogHelper.java */
/* JADX INFO: loaded from: classes.dex */
class h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, m.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private g f313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private androidx.appcompat.app.c f314g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    e f315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private m.a f316i;

    public h(g gVar) {
        this.f313f = gVar;
    }

    public void a() {
        androidx.appcompat.app.c cVar = this.f314g;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void b(g gVar, boolean z) {
        if (z || gVar == this.f313f) {
            a();
        }
        m.a aVar = this.f316i;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean c(g gVar) {
        m.a aVar = this.f316i;
        if (aVar != null) {
            return aVar.c(gVar);
        }
        return false;
    }

    public void d(IBinder iBinder) {
        g gVar = this.f313f;
        androidx.appcompat.app.c.a aVar = new androidx.appcompat.app.c.a(gVar.w());
        e eVar = new e(aVar.b(), c.a.g.f2740j);
        this.f315h = eVar;
        eVar.g(this);
        this.f313f.b(this.f315h);
        aVar.c(this.f315h.a(), this);
        View viewA = gVar.A();
        if (viewA != null) {
            aVar.e(viewA);
        } else {
            aVar.g(gVar.y()).v(gVar.z());
        }
        aVar.p(this);
        androidx.appcompat.app.c cVarA = aVar.a();
        this.f314g = cVarA;
        cVarA.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f314g.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f314g.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f313f.N((i) this.f315h.a().getItem(i2), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f315h.b(this.f313f, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f314g.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f314g.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f313f.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f313f.performShortcut(i2, keyEvent, 0);
    }
}
