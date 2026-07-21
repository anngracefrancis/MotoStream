package cm.aptoide.pt.view.wizard;

import android.R;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.viewpager.widget.ViewPager;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.account.view.LoginBottomSheet;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.NotBottomNavigationView;
import cm.aptoide.pt.view.custom.AptoideViewPager;
import cm.aptoide.pt.view.fragment.NavigationTrackFragment;
import cm.aptoide.pt.view.fragment.UIComponentFragment;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes.dex */
public class WizardFragment extends UIComponentFragment implements WizardView, NotBottomNavigationView {
    public static final int LAYOUT = 2131493045;
    private static final String PAGE_INDEX = "page_index";
    private View animatedColorView;
    private int currentPosition;
    private boolean isInPortraitMode;
    private boolean isUserLoggedIn;
    private LoginBottomSheet loginBottomSheet;
    private ViewPager.m pageChangeListener;
    private RadioGroup radioGroup;
    private Runnable registerViewpagerCurrentItem;
    private View skipButton;
    private View skipOrNextLayout;
    private Integer[] transitionColors;
    private AptoideViewPager viewPager;
    private WizardPagerAdapter viewPagerAdapter;
    private List<RadioButton> wizardButtons;

    @Inject
    WizardFragmentProvider wizardFragmentProvider;

    @Inject
    WizardPresenter wizardPresenter;

    private void createRadioButtons() {
        int pixelsForDip = AptoideUtils.ScreenU.getPixelsForDip(10, getResources());
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(pixelsForDip, pixelsForDip);
        int pixelsForDip2 = AptoideUtils.ScreenU.getPixelsForDip(2, getResources());
        layoutParams.setMargins(pixelsForDip2, pixelsForDip2, pixelsForDip2, pixelsForDip2);
        int count = this.viewPagerAdapter.getCount();
        this.wizardButtons = new ArrayList(count);
        Context context = getContext();
        for (int i2 = 0; i2 < count; i2++) {
            RadioButton radioButton = new RadioButton(context);
            radioButton.setLayoutParams(layoutParams);
            radioButton.setButtonDrawable(R.color.transparent);
            radioButton.setBackgroundResource(cm.aptoide.pt.R.drawable.wizard_custom_indicator);
            radioButton.setClickable(false);
            this.radioGroup.addView(radioButton);
            this.wizardButtons.add(radioButton);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createWizardAdapter$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(boolean z) {
        this.viewPagerAdapter = new WizardPagerAdapter(getChildFragmentManager(), Boolean.valueOf(z), this.wizardFragmentProvider);
        createRadioButtons();
        this.viewPager.setAdapter(this.viewPagerAdapter);
        this.viewPager.setCurrentItem(this.currentPosition);
        handleSelectedPage(this.currentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupViews$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(LoginBottomSheet.State state) {
        if (this.isInPortraitMode && LoginBottomSheet.State.EXPANDED.equals(state)) {
            this.skipOrNextLayout.setVisibility(8);
        } else if (LoginBottomSheet.State.COLLAPSED.equals(state)) {
            this.skipOrNextLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupViews$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g() {
        AptoideViewPager aptoideViewPager = this.viewPager;
        if (aptoideViewPager != null) {
            this.pageChangeListener.onPageSelected(aptoideViewPager.getCurrentItem());
        }
    }

    public static WizardFragment newInstance() {
        return new WizardFragment();
    }

    @Override // cm.aptoide.pt.view.fragment.UiComponent
    public void bindViews(View view) {
        this.viewPager = (AptoideViewPager) view.findViewById(cm.aptoide.pt.R.id.view_pager);
        this.skipOrNextLayout = view.findViewById(cm.aptoide.pt.R.id.skip_next_layout);
        this.radioGroup = (RadioGroup) view.findViewById(cm.aptoide.pt.R.id.view_pager_radio_group);
        this.skipButton = view.findViewById(cm.aptoide.pt.R.id.skip_button);
        this.isInPortraitMode = getActivity().getResources().getConfiguration().orientation == 1;
        this.animatedColorView = view.findViewById(cm.aptoide.pt.R.id.animated_color_view);
    }

    @Override // cm.aptoide.pt.view.wizard.WizardView
    public rx.b createWizardAdapter(final boolean z) {
        this.isUserLoggedIn = z;
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.view.wizard.b
            @Override // rx.m.a
            public final void call() {
                this.f8302f.e(z);
            }
        });
    }

    @Override // cm.aptoide.pt.view.fragment.UiComponent
    public int getContentViewId() {
        return cm.aptoide.pt.R.layout.fragment_wizard;
    }

    @Override // cm.aptoide.pt.view.wizard.WizardView
    public int getCount() {
        return this.wizardFragmentProvider.getCount(Boolean.valueOf(this.isUserLoggedIn));
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName());
    }

    @Override // cm.aptoide.pt.view.wizard.WizardView
    public void handleColorTransitions(int i2, float f2, int i3) {
        if (this.animatedColorView != null) {
            if (i2 < this.viewPagerAdapter.getCount() - 1 && i2 < this.transitionColors.length - 1) {
                ArgbEvaluator argbEvaluator = new ArgbEvaluator();
                Integer[] numArr = this.transitionColors;
                this.animatedColorView.setBackgroundColor(((Integer) argbEvaluator.evaluate(f2, numArr[i2], numArr[i2 + 1])).intValue());
                return;
            }
            if (this.viewPagerAdapter.isLoggedIn()) {
                View view = this.animatedColorView;
                Integer[] numArr2 = this.transitionColors;
                view.setBackgroundColor(numArr2[numArr2.length - 2].intValue());
            } else {
                View view2 = this.animatedColorView;
                Integer[] numArr3 = this.transitionColors;
                view2.setBackgroundColor(numArr3[numArr3.length - 1].intValue());
            }
        }
    }

    @Override // cm.aptoide.pt.view.wizard.WizardView
    public void handleSelectedPage(int i2) {
        RadioButton radioButton;
        List<RadioButton> list = this.wizardButtons;
        if (list == null || i2 >= list.size() || (radioButton = this.wizardButtons.get(i2)) == null) {
            return;
        }
        radioButton.setChecked(true);
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void loadExtras(Bundle bundle) {
        super.loadExtras(bundle);
        this.currentPosition = 0;
        if (bundle != null) {
            this.currentPosition = bundle.getInt(PAGE_INDEX, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cm.aptoide.pt.view.BackButtonFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof LoginBottomSheet) {
            this.loginBottomSheet = (LoginBottomSheet) context;
            return;
        }
        throw new IllegalStateException("Context should implement " + LoginBottomSheet.class.getSimpleName());
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        Integer[] transitionColors = this.wizardFragmentProvider.getTransitionColors();
        this.transitionColors = new Integer[transitionColors.length];
        for (int i2 = 0; i2 < transitionColors.length; i2++) {
            this.transitionColors[i2] = Integer.valueOf(getContext().getResources().getColor(transitionColors[i2].intValue()));
        }
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.viewPager.removeOnPageChangeListener(this.pageChangeListener);
        this.viewPager.setAdapter(null);
        this.viewPager.removeCallbacks(this.registerViewpagerCurrentItem);
        this.viewPager.removeOnPageChangeListener(null);
        this.registerViewpagerCurrentItem = null;
        this.viewPager = null;
        this.skipOrNextLayout = null;
        this.wizardButtons = null;
        this.radioGroup = null;
        this.skipButton = null;
        this.animatedColorView = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        AptoideViewPager aptoideViewPager = this.viewPager;
        if (aptoideViewPager != null) {
            bundle.putInt(PAGE_INDEX, aptoideViewPager.getCurrentItem());
        }
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        attachPresenter(this.wizardPresenter);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        loadExtras(bundle);
    }

    @Override // cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void setupViews() {
        this.loginBottomSheet.state().j0(rx.l.c.a.b()).f(bindUntilEvent(com.trello.rxlifecycle.g.b.DESTROY_VIEW)).G0(new rx.m.b() { // from class: cm.aptoide.pt.view.wizard.a
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8301f.f((LoginBottomSheet.State) obj);
            }
        });
        this.pageChangeListener = new ViewPager.m() { // from class: cm.aptoide.pt.view.wizard.WizardFragment.1
            @Override // androidx.viewpager.widget.ViewPager.m, androidx.viewpager.widget.ViewPager.j
            public void onPageSelected(int i2) {
                if (i2 == 0) {
                    ((NavigationTrackFragment) WizardFragment.this).navigationTracker.registerScreen(ScreenTagHistory.Builder.build(WizardPageOneFragment.class.getSimpleName(), "0"));
                }
            }
        };
        this.viewPager.addOnPageChangeListener(this.wizardPresenter);
        this.viewPager.addOnPageChangeListener(this.pageChangeListener);
        Runnable runnable = new Runnable() { // from class: cm.aptoide.pt.view.wizard.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f8304f.g();
            }
        };
        this.registerViewpagerCurrentItem = runnable;
        this.viewPager.post(runnable);
    }

    @Override // cm.aptoide.pt.view.wizard.WizardView
    public void skipWizard() {
        getActivity().onBackPressed();
    }

    @Override // cm.aptoide.pt.view.wizard.WizardView
    public rx.e<Void> skipWizardClick() {
        return e.g.a.c.a.a(this.skipButton);
    }
}
