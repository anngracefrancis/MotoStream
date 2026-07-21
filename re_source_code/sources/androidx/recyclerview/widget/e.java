package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends q {
    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    private ArrayList<RecyclerView.c0> mPendingRemovals = new ArrayList<>();
    private ArrayList<RecyclerView.c0> mPendingAdditions = new ArrayList<>();
    private ArrayList<j> mPendingMoves = new ArrayList<>();
    private ArrayList<i> mPendingChanges = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.c0>> mAdditionsList = new ArrayList<>();
    ArrayList<ArrayList<j>> mMovesList = new ArrayList<>();
    ArrayList<ArrayList<i>> mChangesList = new ArrayList<>();
    ArrayList<RecyclerView.c0> mAddAnimations = new ArrayList<>();
    ArrayList<RecyclerView.c0> mMoveAnimations = new ArrayList<>();
    ArrayList<RecyclerView.c0> mRemoveAnimations = new ArrayList<>();
    ArrayList<RecyclerView.c0> mChangeAnimations = new ArrayList<>();

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f2016f;

        a(ArrayList arrayList) {
            this.f2016f = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (j jVar : this.f2016f) {
                e.this.animateMoveImpl(jVar.a, jVar.f2044b, jVar.f2045c, jVar.f2046d, jVar.f2047e);
            }
            this.f2016f.clear();
            e.this.mMovesList.remove(this.f2016f);
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f2018f;

        b(ArrayList arrayList) {
            this.f2018f = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f2018f.iterator();
            while (it.hasNext()) {
                e.this.animateChangeImpl((i) it.next());
            }
            this.f2018f.clear();
            e.this.mChangesList.remove(this.f2018f);
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f2020f;

        c(ArrayList arrayList) {
            this.f2020f = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f2020f.iterator();
            while (it.hasNext()) {
                e.this.animateAddImpl((RecyclerView.c0) it.next());
            }
            this.f2020f.clear();
            e.this.mAdditionsList.remove(this.f2020f);
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    class d extends AnimatorListenerAdapter {
        final /* synthetic */ RecyclerView.c0 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f2022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f2023c;

        d(RecyclerView.c0 c0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.a = c0Var;
            this.f2022b = viewPropertyAnimator;
            this.f2023c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2022b.setListener(null);
            this.f2023c.setAlpha(1.0f);
            e.this.dispatchRemoveFinished(this.a);
            e.this.mRemoveAnimations.remove(this.a);
            e.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.dispatchRemoveStarting(this.a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    class C0041e extends AnimatorListenerAdapter {
        final /* synthetic */ RecyclerView.c0 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f2026c;

        C0041e(RecyclerView.c0 c0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.a = c0Var;
            this.f2025b = view;
            this.f2026c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2025b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2026c.setListener(null);
            e.this.dispatchAddFinished(this.a);
            e.this.mAddAnimations.remove(this.a);
            e.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.dispatchAddStarting(this.a);
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    class f extends AnimatorListenerAdapter {
        final /* synthetic */ RecyclerView.c0 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f2028b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f2029c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f2030d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f2031e;

        f(RecyclerView.c0 c0Var, int i2, View view, int i3, ViewPropertyAnimator viewPropertyAnimator) {
            this.a = c0Var;
            this.f2028b = i2;
            this.f2029c = view;
            this.f2030d = i3;
            this.f2031e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f2028b != 0) {
                this.f2029c.setTranslationX(0.0f);
            }
            if (this.f2030d != 0) {
                this.f2029c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2031e.setListener(null);
            e.this.dispatchMoveFinished(this.a);
            e.this.mMoveAnimations.remove(this.a);
            e.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.dispatchMoveStarting(this.a);
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    class g extends AnimatorListenerAdapter {
        final /* synthetic */ i a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f2033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f2034c;

        g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.a = iVar;
            this.f2033b = viewPropertyAnimator;
            this.f2034c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2033b.setListener(null);
            this.f2034c.setAlpha(1.0f);
            this.f2034c.setTranslationX(0.0f);
            this.f2034c.setTranslationY(0.0f);
            e.this.dispatchChangeFinished(this.a.a, true);
            e.this.mChangeAnimations.remove(this.a.a);
            e.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.dispatchChangeStarting(this.a.a, true);
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    class h extends AnimatorListenerAdapter {
        final /* synthetic */ i a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f2036b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f2037c;

        h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.a = iVar;
            this.f2036b = viewPropertyAnimator;
            this.f2037c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2036b.setListener(null);
            this.f2037c.setAlpha(1.0f);
            this.f2037c.setTranslationX(0.0f);
            this.f2037c.setTranslationY(0.0f);
            e.this.dispatchChangeFinished(this.a.f2039b, false);
            e.this.mChangeAnimations.remove(this.a.f2039b);
            e.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.dispatchChangeStarting(this.a.f2039b, false);
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    private static class j {
        public RecyclerView.c0 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2045c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2046d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2047e;

        j(RecyclerView.c0 c0Var, int i2, int i3, int i4, int i5) {
            this.a = c0Var;
            this.f2044b = i2;
            this.f2045c = i3;
            this.f2046d = i4;
            this.f2047e = i5;
        }
    }

    private void animateRemoveImpl(RecyclerView.c0 c0Var) {
        View view = c0Var.itemView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.mRemoveAnimations.add(c0Var);
        viewPropertyAnimatorAnimate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new d(c0Var, viewPropertyAnimatorAnimate, view)).start();
    }

    private void endChangeAnimation(List<i> list, RecyclerView.c0 c0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (endChangeAnimationIfNecessary(iVar, c0Var) && iVar.a == null && iVar.f2039b == null) {
                list.remove(iVar);
            }
        }
    }

    private void endChangeAnimationIfNecessary(i iVar) {
        RecyclerView.c0 c0Var = iVar.a;
        if (c0Var != null) {
            endChangeAnimationIfNecessary(iVar, c0Var);
        }
        RecyclerView.c0 c0Var2 = iVar.f2039b;
        if (c0Var2 != null) {
            endChangeAnimationIfNecessary(iVar, c0Var2);
        }
    }

    private void resetAnimation(RecyclerView.c0 c0Var) {
        if (sDefaultInterpolator == null) {
            sDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        c0Var.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(c0Var);
    }

    @Override // androidx.recyclerview.widget.q
    public boolean animateAdd(RecyclerView.c0 c0Var) {
        resetAnimation(c0Var);
        c0Var.itemView.setAlpha(0.0f);
        this.mPendingAdditions.add(c0Var);
        return true;
    }

    void animateAddImpl(RecyclerView.c0 c0Var) {
        View view = c0Var.itemView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.mAddAnimations.add(c0Var);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(getAddDuration()).setListener(new C0041e(c0Var, view, viewPropertyAnimatorAnimate)).start();
    }

    @Override // androidx.recyclerview.widget.q
    public boolean animateChange(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2, int i2, int i3, int i4, int i5) {
        if (c0Var == c0Var2) {
            return animateMove(c0Var, i2, i3, i4, i5);
        }
        float translationX = c0Var.itemView.getTranslationX();
        float translationY = c0Var.itemView.getTranslationY();
        float alpha = c0Var.itemView.getAlpha();
        resetAnimation(c0Var);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        c0Var.itemView.setTranslationX(translationX);
        c0Var.itemView.setTranslationY(translationY);
        c0Var.itemView.setAlpha(alpha);
        if (c0Var2 != null) {
            resetAnimation(c0Var2);
            c0Var2.itemView.setTranslationX(-i6);
            c0Var2.itemView.setTranslationY(-i7);
            c0Var2.itemView.setAlpha(0.0f);
        }
        this.mPendingChanges.add(new i(c0Var, c0Var2, i2, i3, i4, i5));
        return true;
    }

    void animateChangeImpl(i iVar) {
        RecyclerView.c0 c0Var = iVar.a;
        View view = c0Var == null ? null : c0Var.itemView;
        RecyclerView.c0 c0Var2 = iVar.f2039b;
        View view2 = c0Var2 != null ? c0Var2.itemView : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.mChangeAnimations.add(iVar.a);
            duration.translationX(iVar.f2042e - iVar.f2040c);
            duration.translationY(iVar.f2043f - iVar.f2041d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.mChangeAnimations.add(iVar.f2039b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new h(iVar, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    @Override // androidx.recyclerview.widget.q
    public boolean animateMove(RecyclerView.c0 c0Var, int i2, int i3, int i4, int i5) {
        View view = c0Var.itemView;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) c0Var.itemView.getTranslationY());
        resetAnimation(c0Var);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            dispatchMoveFinished(c0Var);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.mPendingMoves.add(new j(c0Var, translationX, translationY, i4, i5));
        return true;
    }

    void animateMoveImpl(RecyclerView.c0 c0Var, int i2, int i3, int i4, int i5) {
        View view = c0Var.itemView;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.mMoveAnimations.add(c0Var);
        viewPropertyAnimatorAnimate.setDuration(getMoveDuration()).setListener(new f(c0Var, i6, view, i7, viewPropertyAnimatorAnimate)).start();
    }

    @Override // androidx.recyclerview.widget.q
    public boolean animateRemove(RecyclerView.c0 c0Var) {
        resetAnimation(c0Var);
        this.mPendingRemovals.add(c0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean canReuseUpdatedViewHolder(RecyclerView.c0 c0Var, List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(c0Var, list);
    }

    void cancelAll(List<RecyclerView.c0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    void dispatchFinishedWhenDone() {
        if (isRunning()) {
            return;
        }
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void endAnimation(RecyclerView.c0 c0Var) {
        View view = c0Var.itemView;
        view.animate().cancel();
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.mPendingMoves.get(size).a == c0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(c0Var);
                this.mPendingMoves.remove(size);
            }
        }
        endChangeAnimation(this.mPendingChanges, c0Var);
        if (this.mPendingRemovals.remove(c0Var)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(c0Var);
        }
        if (this.mPendingAdditions.remove(c0Var)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(c0Var);
        }
        for (int size2 = this.mChangesList.size() - 1; size2 >= 0; size2--) {
            ArrayList<i> arrayList = this.mChangesList.get(size2);
            endChangeAnimation(arrayList, c0Var);
            if (arrayList.isEmpty()) {
                this.mChangesList.remove(size2);
            }
        }
        for (int size3 = this.mMovesList.size() - 1; size3 >= 0; size3--) {
            ArrayList<j> arrayList2 = this.mMovesList.get(size3);
            for (int size4 = arrayList2.size() - 1; size4 >= 0; size4--) {
                if (arrayList2.get(size4).a == c0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(c0Var);
                    arrayList2.remove(size4);
                    if (!arrayList2.isEmpty()) {
                        break;
                    }
                    this.mMovesList.remove(size3);
                    break;
                }
            }
        }
        for (int size5 = this.mAdditionsList.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.c0> arrayList3 = this.mAdditionsList.get(size5);
            if (arrayList3.remove(c0Var)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(c0Var);
                if (arrayList3.isEmpty()) {
                    this.mAdditionsList.remove(size5);
                }
            }
        }
        this.mRemoveAnimations.remove(c0Var);
        this.mAddAnimations.remove(c0Var);
        this.mChangeAnimations.remove(c0Var);
        this.mMoveAnimations.remove(c0Var);
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void endAnimations() {
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.mPendingMoves.get(size);
            View view = jVar.a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(jVar.a);
            this.mPendingMoves.remove(size);
        }
        for (int size2 = this.mPendingRemovals.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.mPendingRemovals.get(size2));
            this.mPendingRemovals.remove(size2);
        }
        int size3 = this.mPendingAdditions.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.c0 c0Var = this.mPendingAdditions.get(size3);
            c0Var.itemView.setAlpha(1.0f);
            dispatchAddFinished(c0Var);
            this.mPendingAdditions.remove(size3);
        }
        for (int size4 = this.mPendingChanges.size() - 1; size4 >= 0; size4--) {
            endChangeAnimationIfNecessary(this.mPendingChanges.get(size4));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            for (int size5 = this.mMovesList.size() - 1; size5 >= 0; size5--) {
                ArrayList<j> arrayList = this.mMovesList.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = arrayList.get(size6);
                    View view2 = jVar2.a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(jVar2.a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.mAdditionsList.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.c0> arrayList2 = this.mAdditionsList.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.c0 c0Var2 = arrayList2.get(size8);
                    c0Var2.itemView.setAlpha(1.0f);
                    dispatchAddFinished(c0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.mAdditionsList.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.mChangesList.size() - 1; size9 >= 0; size9--) {
                ArrayList<i> arrayList3 = this.mChangesList.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    endChangeAnimationIfNecessary(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.mChangesList.remove(arrayList3);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean isRunning() {
        return (this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty() && this.mChangesList.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void runPendingAnimations() {
        boolean z = !this.mPendingRemovals.isEmpty();
        boolean z2 = !this.mPendingMoves.isEmpty();
        boolean z3 = !this.mPendingChanges.isEmpty();
        boolean z4 = !this.mPendingAdditions.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.c0> it = this.mPendingRemovals.iterator();
            while (it.hasNext()) {
                animateRemoveImpl(it.next());
            }
            this.mPendingRemovals.clear();
            if (z2) {
                ArrayList<j> arrayList = new ArrayList<>();
                arrayList.addAll(this.mPendingMoves);
                this.mMovesList.add(arrayList);
                this.mPendingMoves.clear();
                a aVar = new a(arrayList);
                if (z) {
                    u.b0(arrayList.get(0).a.itemView, aVar, getRemoveDuration());
                } else {
                    aVar.run();
                }
            }
            if (z3) {
                ArrayList<i> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.mPendingChanges);
                this.mChangesList.add(arrayList2);
                this.mPendingChanges.clear();
                b bVar = new b(arrayList2);
                if (z) {
                    u.b0(arrayList2.get(0).a.itemView, bVar, getRemoveDuration());
                } else {
                    bVar.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.c0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.mPendingAdditions);
                this.mAdditionsList.add(arrayList3);
                this.mPendingAdditions.clear();
                c cVar = new c(arrayList3);
                if (z || z2 || z3) {
                    u.b0(arrayList3.get(0).itemView, cVar, (z ? getRemoveDuration() : 0L) + Math.max(z2 ? getMoveDuration() : 0L, z3 ? getChangeDuration() : 0L));
                } else {
                    cVar.run();
                }
            }
        }
    }

    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    private static class i {
        public RecyclerView.c0 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.c0 f2039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2041d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2042e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2043f;

        private i(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2) {
            this.a = c0Var;
            this.f2039b = c0Var2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.f2039b + ", fromX=" + this.f2040c + ", fromY=" + this.f2041d + ", toX=" + this.f2042e + ", toY=" + this.f2043f + '}';
        }

        i(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2, int i2, int i3, int i4, int i5) {
            this(c0Var, c0Var2);
            this.f2040c = i2;
            this.f2041d = i3;
            this.f2042e = i4;
            this.f2043f = i5;
        }
    }

    private boolean endChangeAnimationIfNecessary(i iVar, RecyclerView.c0 c0Var) {
        boolean z = false;
        if (iVar.f2039b == c0Var) {
            iVar.f2039b = null;
        } else {
            if (iVar.a != c0Var) {
                return false;
            }
            iVar.a = null;
            z = true;
        }
        c0Var.itemView.setAlpha(1.0f);
        c0Var.itemView.setTranslationX(0.0f);
        c0Var.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(c0Var, z);
        return true;
    }
}
