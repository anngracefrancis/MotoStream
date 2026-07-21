package cm.aptoide.pt.view.fragment;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.navigator.ActivityNavigator;
import cm.aptoide.pt.navigator.ActivityResultNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.navigator.FragmentResultNavigator;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.util.ScreenTrackingUtils;
import cm.aptoide.pt.view.BaseFragment;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentView extends BaseFragment implements View {
    private static final String TAG = FragmentView.class.getName();
    private ActivityResultNavigator activityResultNavigator;
    private boolean startActivityForResultCalled;

    /* JADX INFO: renamed from: cm.aptoide.pt.view.fragment.FragmentView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent;

        static {
            int[] iArr = new int[com.trello.rxlifecycle.g.b.values().length];
            $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent = iArr;
            try {
                iArr[com.trello.rxlifecycle.g.b.ATTACH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.CREATE_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.STOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.DESTROY_VIEW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.DETACH.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.DESTROY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: convertToEvent, reason: merged with bridge method [inline-methods] */
    public e<View.LifecycleEvent> d(com.trello.rxlifecycle.g.b bVar) {
        switch (AnonymousClass1.$SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[bVar.ordinal()]) {
            case 1:
            case 2:
                return e.B();
            case 3:
                return e.S(View.LifecycleEvent.CREATE);
            case 4:
                return e.S(View.LifecycleEvent.START);
            case 5:
                return e.S(View.LifecycleEvent.RESUME);
            case 6:
                return e.S(View.LifecycleEvent.PAUSE);
            case 7:
                return e.S(View.LifecycleEvent.STOP);
            case 8:
                return e.S(View.LifecycleEvent.DESTROY);
            case 9:
            case 10:
                return e.B();
            default:
                throw new IllegalStateException("Unrecognized event: " + bVar.name());
        }
    }

    @Override // cm.aptoide.pt.presenter.View
    public void attachPresenter(Presenter presenter) {
        presenter.present();
    }

    @Override // cm.aptoide.pt.presenter.View
    public final <T> com.trello.rxlifecycle.b<T> bindUntilEvent(View.LifecycleEvent lifecycleEvent) {
        return com.trello.rxlifecycle.c.b(getLifecycleEvent(), lifecycleEvent);
    }

    public ActivityNavigator getActivityNavigator() {
        return this.activityResultNavigator.getActivityNavigator();
    }

    public FragmentNavigator getFragmentChildNavigator(int i2) {
        return new FragmentResultNavigator(getChildFragmentManager(), i2, R.anim.fade_in, R.anim.fade_out, this.activityResultNavigator.getFragmentResultMap(), this.activityResultNavigator.getFragmentResultRelay());
    }

    public FragmentNavigator getFragmentNavigator() {
        return this.activityResultNavigator.getFragmentNavigator();
    }

    @Override // cm.aptoide.pt.presenter.View
    public e<View.LifecycleEvent> getLifecycleEvent() {
        return lifecycle().G(new rx.m.e() { // from class: cm.aptoide.pt.view.fragment.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f8058f.d((com.trello.rxlifecycle.g.b) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideKeyboard() {
        androidx.fragment.app.d activity = getActivity();
        android.view.View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public boolean isStartActivityForResultCalled() {
        return this.startActivityForResultCalled;
    }

    @Override // cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.activityResultNavigator = (ActivityResultNavigator) activity;
        } catch (ClassCastException unused) {
            Logger.getInstance().e(TAG, String.format("Parent activity must implement %s interface", ActivityResultNavigator.class.getName()));
        }
    }

    @Override // com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ScreenTrackingUtils.getInstance().incrementNumberOfScreens();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ScreenTrackingUtils.getInstance().decrementNumberOfScreens();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (getFragmentNavigator().popBackStack()) {
            return true;
        }
        getActivityNavigator().navigateBack();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            ScreenTrackingUtils.getInstance().addScreenToHistory(getClass().getSimpleName());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(Intent intent, int i2) {
        this.startActivityForResultCalled = true;
        super.startActivityForResult(intent, i2);
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        this.startActivityForResultCalled = true;
        super.startActivityForResult(intent, i2, bundle);
    }
}
