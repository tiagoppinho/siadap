package module.siadap.activities;

import module.siadap.domain.Siadap;
import module.siadap.domain.SiadapProcess;
import module.workflow.activities.ActivityInformation;
import module.workflow.activities.WorkflowActivity;
import myorg.domain.User;

public class RemoveObjectiveEvaluation extends WorkflowActivity<SiadapProcess, RemoveObjectiveEvaluationActivityInformation> {

    @Override
    public boolean isActive(SiadapProcess process, User user) {
	Siadap siadap = process.getSiadap();
	return siadap.getObjectiveSpecificationInterval().containsNow() && siadap.getEvaluator().getPerson().getUser() == user
		&& siadap.getRequestedAcknowledgeDate() == null && !process.hasBeenExecuted(SubmitForObjectivesAcknowledge.class);
    }

    @Override
    protected void process(RemoveObjectiveEvaluationActivityInformation activityInformation) {
	activityInformation.getSiadap().removeSiadapEvaluationItems(activityInformation.getEvaluation());
	// TODO probably will have to alter this in the near future, related
	// with Issue #2, most likely depending if it is sealed or not, and if
	// it is we will want to add it to some object that will store the old
	// objectives
	activityInformation.getEvaluation().delete();
    }

    @Override
    protected boolean shouldLogActivity(RemoveObjectiveEvaluationActivityInformation activityInformation) {
	if (activityInformation.getProcess().getSiadap().getObjectivesAndCompetencesSealedDate() != null)
	    return true;
	else
	    return false;
    }

    @Override
    public ActivityInformation<SiadapProcess> getActivityInformation(SiadapProcess process) {
	return new RemoveObjectiveEvaluationActivityInformation(process, this);
    }

    @Override
    public boolean isUserAwarenessNeeded(SiadapProcess process) {
	return false;
    }

    @Override
    public boolean isVisible() {
	return false;
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
