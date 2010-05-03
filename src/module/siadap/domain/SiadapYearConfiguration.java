package module.siadap.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import module.organization.domain.Party;
import module.organization.domain.Person;
import module.organization.domain.Unit;
import pt.ist.fenixWebFramework.services.Service;

public class SiadapYearConfiguration extends SiadapYearConfiguration_Base {

    private static final Double DEFAULT_OBJECTIVES_PONDERATION = 75.0;
    private static final Double DEFAULT_COMPETENCES_PONDERATION = 25.0;

    public SiadapYearConfiguration(Integer year, Double objectivesPonderation, Double competencesPonderation) {
	super();
	setYear(year);
	setObjectivesPonderation(objectivesPonderation);
	setCompetencesPonderation(competencesPonderation);
	setSiadapRootModule(SiadapRootModule.getInstance());
    }

    public static SiadapYearConfiguration getSiadapYearConfiguration(Integer year) {
	for (SiadapYearConfiguration configuration : SiadapRootModule.getInstance().getYearConfigurations()) {
	    if (configuration.getYear() == year) {
		return configuration;
	    }
	}
	return null;
    }

    @Service
    public static SiadapYearConfiguration createNewSiadapYearConfiguration(Integer year) {
	SiadapYearConfiguration configuration = getSiadapYearConfiguration(year);
	if (configuration != null) {
	    return configuration;
	}
	return new SiadapYearConfiguration(year, DEFAULT_OBJECTIVES_PONDERATION, DEFAULT_COMPETENCES_PONDERATION);
    }

    public Set<Person> getEvalutedFor(Person evaluator) {
	Set<Person> people = new HashSet<Person>();

	return people;
    }

    public Person getEvaluatorFor(Person evaluated) {
	Person evaluator = null;

	Collection<Party> parents = evaluated.getParents(getEvaluationRelation());
	if (!parents.isEmpty()) {
	    evaluator = (Person) parents.iterator().next();
	} else {
	    Collection<Party> workingPlaces = evaluated.getParents(getWorkingRelation());
	    Unit workingUnit = (Unit) workingPlaces.iterator().next();
	    Collection<Person> childPersons = workingUnit.getChildPersons(getEvaluationRelation());
	    evaluator = childPersons.iterator().next();
	}

	return evaluator;
    }
}
