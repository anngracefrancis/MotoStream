package com.airbnb.epoxy;

import android.os.Bundle;
import android.os.Handler;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: EpoxyController.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {
    private static final int DELAY_TO_CHECK_ADAPTER_COUNT_MS = 3000;
    private static final k0 NO_OP_TIMER = new d0();
    public static Handler defaultDiffingHandler;
    public static Handler defaultModelBuildingHandler;
    private static boolean filterDuplicatesDefault;
    private static boolean globalDebugLoggingEnabled;
    private static d globalExceptionHandler;
    private final o adapter;
    private final Runnable buildModelsRunnable;
    private p debugObserver;
    private volatile boolean filterDuplicates;
    private volatile boolean hasBuiltModelsEver;
    private final com.airbnb.epoxy.f helper;
    private final List<e> interceptors;
    private final Handler modelBuildHandler;
    private List<f> modelInterceptorCallbacks;
    private h modelsBeingBuilt;
    private int recyclerViewAttachCount;
    private volatile int requestedModelBuildType;
    private s<?> stagedModel;
    private volatile Thread threadBuildingModels;
    private k0 timer;

    /* JADX INFO: compiled from: EpoxyController.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.threadBuildingModels = Thread.currentThread();
            n.this.cancelPendingModelBuild();
            n.this.helper.resetAutoModels();
            n.this.modelsBeingBuilt = new h(n.this.getExpectedModelCount());
            n.this.timer.a("Models built");
            try {
                n.this.buildModels();
                n.this.addCurrentlyStagedModelIfExists();
                n.this.timer.stop();
                n.this.runInterceptors();
                n nVar = n.this;
                nVar.filterDuplicatesIfNeeded(nVar.modelsBeingBuilt);
                n.this.modelsBeingBuilt.c0();
                n.this.timer.a("Models diffed");
                n.this.adapter.I(n.this.modelsBeingBuilt);
                n.this.timer.stop();
                n.this.modelsBeingBuilt = null;
                n.this.hasBuiltModelsEver = true;
                n.this.threadBuildingModels = null;
            } catch (Throwable th) {
                n.this.timer.stop();
                n.this.modelsBeingBuilt = null;
                n.this.hasBuiltModelsEver = true;
                n.this.threadBuildingModels = null;
                n.this.stagedModel = null;
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: EpoxyController.java */
    static class b implements d {
        b() {
        }

        @Override // com.airbnb.epoxy.n.d
        public void a(n nVar, RuntimeException runtimeException) {
        }
    }

    /* JADX INFO: compiled from: EpoxyController.java */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.recyclerViewAttachCount > 1) {
                n.this.onExceptionSwallowed(new IllegalStateException("This EpoxyController had its adapter added to more than one ReyclerView. Epoxy does not support attaching an adapter to multiple RecyclerViews because saved state will not work properly. If you did not intend to attach your adapter to multiple RecyclerViews you may be leaking a reference to a previous RecyclerView. Make sure to remove the adapter from any previous RecyclerViews (eg if the adapter is reused in a Fragment across multiple onCreateView/onDestroyView cycles). See https://github.com/airbnb/epoxy/wiki/Avoiding-Memory-Leaks for more information."));
            }
        }
    }

    /* JADX INFO: compiled from: EpoxyController.java */
    public interface d {
        void a(n nVar, RuntimeException runtimeException);
    }

    /* JADX INFO: compiled from: EpoxyController.java */
    public interface e {
        void a(List<s<?>> list);
    }

    /* JADX INFO: compiled from: EpoxyController.java */
    interface f {
        void a(n nVar);

        void b(n nVar);
    }

    static {
        Handler handler = b0.f8391g.f8478f;
        defaultModelBuildingHandler = handler;
        defaultDiffingHandler = handler;
        filterDuplicatesDefault = false;
        globalDebugLoggingEnabled = false;
        globalExceptionHandler = new b();
    }

    public n() {
        this(defaultModelBuildingHandler, defaultDiffingHandler);
    }

    private void assertIsBuildingModels() {
        if (!isBuildingModels()) {
            throw new IllegalEpoxyUsage("Can only call this when inside the `buildModels` method");
        }
    }

    private void assertNotBuildingModels() {
        if (isBuildingModels()) {
            throw new IllegalEpoxyUsage("Cannot call this from inside `buildModels`");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void filterDuplicatesIfNeeded(List<s<?>> list) {
        if (this.filterDuplicates) {
            this.timer.a("Duplicates filtered");
            HashSet hashSet = new HashSet(list.size());
            ListIterator<s<?>> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                s<?> next = listIterator.next();
                if (!hashSet.add(Long.valueOf(next.id()))) {
                    int iPreviousIndex = listIterator.previousIndex();
                    listIterator.remove();
                    int iFindPositionOfDuplicate = findPositionOfDuplicate(list, next);
                    s<?> sVar = list.get(iFindPositionOfDuplicate);
                    if (iPreviousIndex <= iFindPositionOfDuplicate) {
                        iFindPositionOfDuplicate++;
                    }
                    onExceptionSwallowed(new IllegalEpoxyUsage("Two models have the same ID. ID's must be unique!\nOriginal has position " + iFindPositionOfDuplicate + ":\n" + sVar + "\nDuplicate has position " + iPreviousIndex + ":\n" + next));
                }
            }
            this.timer.stop();
        }
    }

    private int findPositionOfDuplicate(List<s<?>> list, s<?> sVar) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2).id() == sVar.id()) {
                return i2;
            }
        }
        throw new IllegalArgumentException("No duplicates in list");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getExpectedModelCount() {
        int itemCount = this.adapter.getItemCount();
        if (itemCount != 0) {
            return itemCount;
        }
        return 25;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runInterceptors() {
        if (!this.interceptors.isEmpty()) {
            List<f> list = this.modelInterceptorCallbacks;
            if (list != null) {
                Iterator<f> it = list.iterator();
                while (it.hasNext()) {
                    it.next().a(this);
                }
            }
            this.timer.a("Interceptors executed");
            Iterator<e> it2 = this.interceptors.iterator();
            while (it2.hasNext()) {
                it2.next().a(this.modelsBeingBuilt);
            }
            this.timer.stop();
            List<f> list2 = this.modelInterceptorCallbacks;
            if (list2 != null) {
                Iterator<f> it3 = list2.iterator();
                while (it3.hasNext()) {
                    it3.next().b(this);
                }
            }
        }
        this.modelInterceptorCallbacks = null;
    }

    public static void setGlobalDebugLoggingEnabled(boolean z) {
        globalDebugLoggingEnabled = z;
    }

    public static void setGlobalDuplicateFilteringDefault(boolean z) {
        filterDuplicatesDefault = z;
    }

    public static void setGlobalExceptionHandler(d dVar) {
        globalExceptionHandler = dVar;
    }

    protected void add(s<?> sVar) {
        sVar.addTo(this);
    }

    void addAfterInterceptorCallback(f fVar) {
        assertIsBuildingModels();
        if (this.modelInterceptorCallbacks == null) {
            this.modelInterceptorCallbacks = new ArrayList();
        }
        this.modelInterceptorCallbacks.add(fVar);
    }

    void addCurrentlyStagedModelIfExists() {
        s<?> sVar = this.stagedModel;
        if (sVar != null) {
            sVar.addTo(this);
        }
        this.stagedModel = null;
    }

    public void addInterceptor(e eVar) {
        this.interceptors.add(eVar);
    }

    void addInternal(s<?> sVar) {
        assertIsBuildingModels();
        if (sVar.hasDefaultId()) {
            throw new IllegalEpoxyUsage("You must set an id on a model before adding it. Use the @AutoModel annotation if you want an id to be automatically generated for you.");
        }
        if (!sVar.isShown()) {
            throw new IllegalEpoxyUsage("You cannot hide a model in an EpoxyController. Use `addIf` to conditionally add a model instead.");
        }
        clearModelFromStaging(sVar);
        sVar.controllerToStageTo = null;
        this.modelsBeingBuilt.add(sVar);
    }

    public void addModelBuildListener(g0 g0Var) {
        this.adapter.C(g0Var);
    }

    protected abstract void buildModels();

    public synchronized void cancelPendingModelBuild() {
        if (this.requestedModelBuildType != 0) {
            this.requestedModelBuildType = 0;
            this.modelBuildHandler.removeCallbacks(this.buildModelsRunnable);
        }
    }

    void clearModelFromStaging(s<?> sVar) {
        if (this.stagedModel != sVar) {
            addCurrentlyStagedModelIfExists();
        }
        this.stagedModel = null;
    }

    public o getAdapter() {
        return this.adapter;
    }

    int getFirstIndexOfModelInBuildingList(s<?> sVar) {
        assertIsBuildingModels();
        int size = this.modelsBeingBuilt.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.modelsBeingBuilt.get(i2) == sVar) {
                return i2;
            }
        }
        return -1;
    }

    protected int getModelCountBuiltSoFar() {
        assertIsBuildingModels();
        return this.modelsBeingBuilt.size();
    }

    public int getSpanCount() {
        return this.adapter.l();
    }

    public GridLayoutManager.c getSpanSizeLookup() {
        return this.adapter.m();
    }

    public boolean hasPendingModelBuild() {
        return (this.requestedModelBuildType == 0 && this.threadBuildingModels == null && !this.adapter.F()) ? false : true;
    }

    protected boolean isBuildingModels() {
        return this.threadBuildingModels == Thread.currentThread();
    }

    public boolean isDebugLoggingEnabled() {
        return this.timer != NO_OP_TIMER;
    }

    public boolean isDuplicateFilteringEnabled() {
        return this.filterDuplicates;
    }

    boolean isModelAddedMultipleTimes(s<?> sVar) {
        assertIsBuildingModels();
        int size = this.modelsBeingBuilt.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (this.modelsBeingBuilt.get(i3) == sVar) {
                i2++;
            }
        }
        return i2 > 1;
    }

    public boolean isMultiSpan() {
        return this.adapter.n();
    }

    public void moveModel(int i2, int i3) {
        assertNotBuildingModels();
        this.adapter.G(i2, i3);
        requestDelayedModelBuild(500);
    }

    protected void onAttachedToRecyclerView(RecyclerView recyclerView) {
    }

    void onAttachedToRecyclerViewInternal(RecyclerView recyclerView) {
        int i2 = this.recyclerViewAttachCount + 1;
        this.recyclerViewAttachCount = i2;
        if (i2 > 1) {
            b0.f8391g.f8478f.postDelayed(new c(), 3000L);
        }
        onAttachedToRecyclerView(recyclerView);
    }

    protected void onDetachedFromRecyclerView(RecyclerView recyclerView) {
    }

    void onDetachedFromRecyclerViewInternal(RecyclerView recyclerView) {
        this.recyclerViewAttachCount--;
        onDetachedFromRecyclerView(recyclerView);
    }

    protected void onExceptionSwallowed(RuntimeException runtimeException) {
        globalExceptionHandler.a(this, runtimeException);
    }

    protected void onModelBound(u uVar, s<?> sVar, int i2, s<?> sVar2) {
    }

    protected void onModelUnbound(u uVar, s<?> sVar) {
    }

    public void onRestoreInstanceState(Bundle bundle) {
        this.adapter.x(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.adapter.onSaveInstanceState(bundle);
    }

    protected void onViewAttachedToWindow(u uVar, s<?> sVar) {
    }

    protected void onViewDetachedFromWindow(u uVar, s<?> sVar) {
    }

    public void removeInterceptor(e eVar) {
        this.interceptors.remove(eVar);
    }

    public void removeModelBuildListener(g0 g0Var) {
        this.adapter.H(g0Var);
    }

    public synchronized void requestDelayedModelBuild(int i2) {
        if (isBuildingModels()) {
            throw new IllegalEpoxyUsage("Cannot call `requestDelayedModelBuild` from inside `buildModels`");
        }
        if (this.requestedModelBuildType == 2) {
            cancelPendingModelBuild();
        } else if (this.requestedModelBuildType == 1) {
            return;
        }
        this.requestedModelBuildType = i2 != 0 ? 2 : 1;
        this.modelBuildHandler.postDelayed(this.buildModelsRunnable, i2);
    }

    public void requestModelBuild() {
        if (isBuildingModels()) {
            throw new IllegalEpoxyUsage("Cannot call `requestModelBuild` from inside `buildModels`");
        }
        if (this.hasBuiltModelsEver) {
            requestDelayedModelBuild(0);
        } else {
            this.buildModelsRunnable.run();
        }
    }

    public void setDebugLoggingEnabled(boolean z) {
        assertNotBuildingModels();
        if (z) {
            this.timer = new i(getClass().getSimpleName());
            if (this.debugObserver == null) {
                this.debugObserver = new p(getClass().getSimpleName());
            }
            this.adapter.registerAdapterDataObserver(this.debugObserver);
            return;
        }
        this.timer = NO_OP_TIMER;
        p pVar = this.debugObserver;
        if (pVar != null) {
            this.adapter.unregisterAdapterDataObserver(pVar);
        }
    }

    public void setFilterDuplicates(boolean z) {
        this.filterDuplicates = z;
    }

    public void setSpanCount(int i2) {
        this.adapter.B(i2);
    }

    void setStagedModel(s<?> sVar) {
        if (sVar != this.stagedModel) {
            addCurrentlyStagedModelIfExists();
        }
        this.stagedModel = sVar;
    }

    public n(Handler handler, Handler handler2) {
        this.recyclerViewAttachCount = 0;
        this.interceptors = new CopyOnWriteArrayList();
        this.filterDuplicates = filterDuplicatesDefault;
        this.threadBuildingModels = null;
        this.timer = NO_OP_TIMER;
        this.helper = g.b(this);
        this.requestedModelBuildType = 0;
        this.buildModelsRunnable = new a();
        this.adapter = new o(this, handler2);
        this.modelBuildHandler = handler;
        setDebugLoggingEnabled(globalDebugLoggingEnabled);
    }

    protected void add(s<?>... sVarArr) {
        h hVar = this.modelsBeingBuilt;
        hVar.ensureCapacity(hVar.size() + sVarArr.length);
        for (s<?> sVar : sVarArr) {
            sVar.addTo(this);
        }
    }

    protected void add(List<? extends s<?>> list) {
        h hVar = this.modelsBeingBuilt;
        hVar.ensureCapacity(hVar.size() + list.size());
        Iterator<? extends s<?>> it = list.iterator();
        while (it.hasNext()) {
            it.next().addTo(this);
        }
    }
}
