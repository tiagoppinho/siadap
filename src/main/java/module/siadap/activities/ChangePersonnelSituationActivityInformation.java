/*
 * @(#)ChangePersonnelSituationActivityInformation.java
 *
 * Copyright 2012 Instituto Superior Tecnico
 * Founding Authors: Paulo Abrantes
 * 
 *      https://fenix-ashes.ist.utl.pt/
 * 
 *   This file is part of the SIADAP Module.
 *
 *   The SIADAP Module is free software: you can
 *   redistribute it and/or modify it under the terms of the GNU Lesser General
 *   Public License as published by the Free Software Foundation, either version 
 *   3 of the License, or (at your option) any later version.
 *
 *   The SIADAP Module is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *   GNU Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public License
 *   along with the SIADAP Module. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package module.siadap.activities;

import module.siadap.domain.SiadapProcess;
import module.siadap.presentationTier.actions.SiadapPersonnelManagement.ActivityInformationBeanWrapper;
import module.workflow.activities.ActivityInformation;
import module.workflow.activities.WorkflowActivity;
import module.workflow.domain.WorkflowProcess;

/**
 * 
 * @author João Antunes
 * 
 */
public class ChangePersonnelSituationActivityInformation extends ActivityInformation<SiadapProcess> {

    /**
     * Default serial version ID
     */
    private static final long serialVersionUID = 1L;

    private final ActivityInformationBeanWrapper beanWrapper;

    public ChangePersonnelSituationActivityInformation(SiadapProcess process,
            WorkflowActivity<? extends WorkflowProcess, ? extends ActivityInformation> activity,
            ActivityInformationBeanWrapper beanWrapper) {
        super(process, activity);
        this.beanWrapper = beanWrapper;
    }

    public ActivityInformationBeanWrapper getBeanWrapper() {
        return beanWrapper;
    }

    @Override
    public boolean hasAllneededInfo() {
        return getBeanWrapper().hasAllNeededInfo();
    }

}
