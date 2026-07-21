package c.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: Visibility.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class j0 extends m {
    private static final String[] P = {"android:visibility:visibility", "android:visibility:parent"};
    private int Q = 3;

    /* JADX INFO: compiled from: Visibility.java */
    class a extends n {
        final /* synthetic */ ViewGroup a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f3575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f3576c;

        a(ViewGroup viewGroup, View view, View view2) {
            this.a = viewGroup;
            this.f3575b = view;
            this.f3576c = view2;
        }

        @Override // c.x.n, c.x.m.f
        public void b(m mVar) {
            x.a(this.a).d(this.f3575b);
        }

        @Override // c.x.m.f
        public void c(m mVar) {
            this.f3576c.setTag(j.f3572b, null);
            x.a(this.a).d(this.f3575b);
            mVar.T(this);
        }

        @Override // c.x.n, c.x.m.f
        public void e(m mVar) {
            if (this.f3575b.getParent() == null) {
                x.a(this.a).c(this.f3575b);
            } else {
                j0.this.cancel();
            }
        }
    }

    /* JADX INFO: compiled from: Visibility.java */
    private static class b extends AnimatorListenerAdapter implements m.f, c.x.a.InterfaceC0100a {
        private final View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f3578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ViewGroup f3579c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f3580d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f3581e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f3582f = false;

        b(View view, int i2, boolean z) {
            this.a = view;
            this.f3578b = i2;
            this.f3579c = (ViewGroup) view.getParent();
            this.f3580d = z;
            g(true);
        }

        private void f() {
            if (!this.f3582f) {
                c0.h(this.a, this.f3578b);
                ViewGroup viewGroup = this.f3579c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z) {
            ViewGroup viewGroup;
            if (!this.f3580d || this.f3581e == z || (viewGroup = this.f3579c) == null) {
                return;
            }
            this.f3581e = z;
            x.c(viewGroup, z);
        }

        @Override // c.x.m.f
        public void a(m mVar) {
        }

        @Override // c.x.m.f
        public void b(m mVar) {
            g(false);
        }

        @Override // c.x.m.f
        public void c(m mVar) {
            f();
            mVar.T(this);
        }

        @Override // c.x.m.f
        public void d(m mVar) {
        }

        @Override // c.x.m.f
        public void e(m mVar) {
            g(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3582f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, c.x.a.InterfaceC0100a
        public void onAnimationPause(Animator animator) {
            if (this.f3582f) {
                return;
            }
            c0.h(this.a, this.f3578b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, c.x.a.InterfaceC0100a
        public void onAnimationResume(Animator animator) {
            if (this.f3582f) {
                return;
            }
            c0.h(this.a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: Visibility.java */
    private static class c {
        boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f3583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f3584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f3585d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ViewGroup f3586e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ViewGroup f3587f;

        c() {
        }
    }

    private void k0(s sVar) {
        sVar.a.put("android:visibility:visibility", Integer.valueOf(sVar.f3608b.getVisibility()));
        sVar.a.put("android:visibility:parent", sVar.f3608b.getParent());
        int[] iArr = new int[2];
        sVar.f3608b.getLocationOnScreen(iArr);
        sVar.a.put("android:visibility:screenLocation", iArr);
    }

    private c l0(s sVar, s sVar2) {
        c cVar = new c();
        cVar.a = false;
        cVar.f3583b = false;
        if (sVar == null || !sVar.a.containsKey("android:visibility:visibility")) {
            cVar.f3584c = -1;
            cVar.f3586e = null;
        } else {
            cVar.f3584c = ((Integer) sVar.a.get("android:visibility:visibility")).intValue();
            cVar.f3586e = (ViewGroup) sVar.a.get("android:visibility:parent");
        }
        if (sVar2 == null || !sVar2.a.containsKey("android:visibility:visibility")) {
            cVar.f3585d = -1;
            cVar.f3587f = null;
        } else {
            cVar.f3585d = ((Integer) sVar2.a.get("android:visibility:visibility")).intValue();
            cVar.f3587f = (ViewGroup) sVar2.a.get("android:visibility:parent");
        }
        if (sVar != null && sVar2 != null) {
            int i2 = cVar.f3584c;
            int i3 = cVar.f3585d;
            if (i2 == i3 && cVar.f3586e == cVar.f3587f) {
                return cVar;
            }
            if (i2 != i3) {
                if (i2 == 0) {
                    cVar.f3583b = false;
                    cVar.a = true;
                } else if (i3 == 0) {
                    cVar.f3583b = true;
                    cVar.a = true;
                }
            } else if (cVar.f3587f == null) {
                cVar.f3583b = false;
                cVar.a = true;
            } else if (cVar.f3586e == null) {
                cVar.f3583b = true;
                cVar.a = true;
            }
        } else if (sVar == null && cVar.f3585d == 0) {
            cVar.f3583b = true;
            cVar.a = true;
        } else if (sVar2 == null && cVar.f3584c == 0) {
            cVar.f3583b = false;
            cVar.a = true;
        }
        return cVar;
    }

    @Override // c.x.m
    public String[] H() {
        return P;
    }

    @Override // c.x.m
    public boolean J(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar != null && sVar2 != null && sVar2.a.containsKey("android:visibility:visibility") != sVar.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c cVarL0 = l0(sVar, sVar2);
        if (cVarL0.a) {
            return cVarL0.f3584c == 0 || cVarL0.f3585d == 0;
        }
        return false;
    }

    @Override // c.x.m
    public void h(s sVar) {
        k0(sVar);
    }

    @Override // c.x.m
    public void k(s sVar) {
        k0(sVar);
    }

    public abstract Animator m0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    public Animator n0(ViewGroup viewGroup, s sVar, int i2, s sVar2, int i3) {
        if ((this.Q & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.f3608b.getParent();
            if (l0(u(view, false), I(view, false)).a) {
                return null;
            }
        }
        return m0(viewGroup, sVar2.f3608b, sVar, sVar2);
    }

    @Override // c.x.m
    public Animator o(ViewGroup viewGroup, s sVar, s sVar2) {
        c cVarL0 = l0(sVar, sVar2);
        if (!cVarL0.a) {
            return null;
        }
        if (cVarL0.f3586e == null && cVarL0.f3587f == null) {
            return null;
        }
        return cVarL0.f3583b ? n0(viewGroup, sVar, cVarL0.f3584c, sVar2, cVarL0.f3585d) : q0(viewGroup, sVar, cVarL0.f3584c, sVar2, cVarL0.f3585d);
    }

    public abstract Animator o0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    /* JADX WARN: Code duplicated, block: B:25:0x0045  */
    public Animator q0(ViewGroup viewGroup, s sVar, int i2, s sVar2, int i3) {
        View view;
        boolean z;
        boolean z2;
        View view2;
        if ((this.Q & 2) != 2 || sVar == null) {
            return null;
        }
        View view3 = sVar.f3608b;
        View viewA = sVar2 != null ? sVar2.f3608b : null;
        int i4 = j.f3572b;
        View view4 = (View) view3.getTag(i4);
        if (view4 != null) {
            view2 = null;
            z2 = true;
        } else {
            if (viewA == null || viewA.getParent() == null) {
                if (viewA != null) {
                    view = null;
                    z = false;
                } else {
                    viewA = null;
                    view = null;
                    z = true;
                }
            } else if (i3 == 4 || view3 == viewA) {
                view = viewA;
                z = false;
                viewA = null;
            } else {
                viewA = null;
                view = null;
                z = true;
            }
            if (z) {
                if (view3.getParent() != null) {
                    if (view3.getParent() instanceof View) {
                        View view5 = (View) view3.getParent();
                        if (l0(I(view5, true), u(view5, true)).a) {
                            int id = view5.getId();
                            if (view5.getParent() != null || id == -1 || viewGroup.findViewById(id) == null || !this.E) {
                            }
                        } else {
                            viewA = r.a(viewGroup, view3, view5);
                        }
                    }
                    z2 = false;
                    View view6 = view;
                    view4 = viewA;
                    view2 = view6;
                }
                view2 = view;
                z2 = false;
                view4 = view3;
            } else {
                z2 = false;
                View view7 = view;
                view4 = viewA;
                view2 = view7;
            }
        }
        if (view4 == null) {
            if (view2 == null) {
                return null;
            }
            int visibility = view2.getVisibility();
            c0.h(view2, 0);
            Animator animatorO0 = o0(viewGroup, view2, sVar, sVar2);
            if (animatorO0 != null) {
                b bVar = new b(view2, i3, true);
                animatorO0.addListener(bVar);
                c.x.a.a(animatorO0, bVar);
                b(bVar);
            } else {
                c0.h(view2, visibility);
            }
            return animatorO0;
        }
        if (!z2) {
            int[] iArr = (int[]) sVar.a.get("android:visibility:screenLocation");
            int i5 = iArr[0];
            int i6 = iArr[1];
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            view4.offsetLeftAndRight((i5 - iArr2[0]) - view4.getLeft());
            view4.offsetTopAndBottom((i6 - iArr2[1]) - view4.getTop());
            x.a(viewGroup).c(view4);
        }
        Animator animatorO1 = o0(viewGroup, view4, sVar, sVar2);
        if (!z2) {
            if (animatorO1 == null) {
                x.a(viewGroup).d(view4);
            } else {
                view3.setTag(i4, view4);
                b(new a(viewGroup, view4, view3));
            }
        }
        return animatorO1;
    }

    public void r0(int i2) {
        if ((i2 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.Q = i2;
    }
}
