package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;

/* JADX INFO: loaded from: classes2.dex */
public class JobInfoSchedulerService extends JobService {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i2 = jobParameters.getExtras().getInt("priority");
        int i3 = jobParameters.getExtras().getInt("attemptNumber");
        e.e.b.a.i.u.f(getApplicationContext());
        e.e.b.a.i.q.a aVarD = e.e.b.a.i.q.a().b(string).d(e.e.b.a.i.d0.a.b(i2));
        if (string2 != null) {
            aVarD.c(Base64.decode(string2, 0));
        }
        e.e.b.a.i.u.c().e().v(aVarD.a(), i3, new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f11321f.b(jobParameters);
            }
        });
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
