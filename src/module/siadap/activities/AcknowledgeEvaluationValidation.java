package module.siadap.activities;

import org.joda.time.LocalDate;

import module.siadap.domain.Siadap;
import module.siadap.domain.SiadapProcess;
import module.workflow.activities.ActivityInformation;
import module.workflow.activities.WorkflowActivity;
import myorg.domain.User;

public class AcknowledgeEvaluationValidation extends WorkflowActivity<SiadapProcess, ActivityInformation<SiadapProcess>> {

    @Override
    public boolean isActive(SiadapProcess process, User user) {
	Siadap siadap = process.getSiadap();
	return siadap.getEvaluated().getUser() == user && siadap.getValidationDate() != null
		&& siadap.getAcknowledgeValidationDate() == null;
    }

    @Override
    protected void process(ActivityInformation<SiadapProcess> activityInformation) {
	activityInformation.getProcess().getSiadap().setAcknowledgeValidationDate(new LocalDate());
    }

    @Override
    public boolean isConfirmationNeeded(SiadapProcess process) {
	return true;
    }

    @Override
    public String getUsedBundle() {
	return "resources/SiadapResources";
    }
}